/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.login.action;

import java.util.Calendar;
import java.util.logging.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.AddressCityException;
import com.liferay.portal.AddressStreetException;
import com.liferay.portal.AddressZipException;
import com.liferay.portal.CompanyMaxUsersException;
import com.liferay.portal.ContactFirstNameException;
import com.liferay.portal.ContactFullNameException;
import com.liferay.portal.ContactLastNameException;
import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.DuplicateUserScreenNameException;
import com.liferay.portal.EmailAddressException;
import com.liferay.portal.NoSuchCountryException;
import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.NoSuchListTypeException;
import com.liferay.portal.NoSuchOrganizationException;
import com.liferay.portal.NoSuchRegionException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.OrganizationParentException;
import com.liferay.portal.PhoneNumberException;
import com.liferay.portal.RequiredFieldException;
import com.liferay.portal.RequiredUserException;
import com.liferay.portal.ReservedUserEmailAddressException;
import com.liferay.portal.ReservedUserScreenNameException;
import com.liferay.portal.TermsOfUseException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserIdException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.UserSmsException;
import com.liferay.portal.WebsiteURLException;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.log.LogUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.login.util.LoginUtil;
import com.liferay.portlet.rolesadmin.search.UserRoleChecker;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
 
/**
 * @author Brian Wing Shun Chan
 * @author Amos Fong
 * @author Daniel Sanz
 * @author Sergio González
 */
public class CreateAccountAction extends PortletAction {

	@Override
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD)) {
				if (PropsValues.CAPTCHA_CHECK_PORTAL_CREATE_ACCOUNT) {
					CaptchaUtil.check(actionRequest);
				}

				addUser(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.RESET)) {
				resetUser(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.UPDATE)) {
				updateIncompleteUser(actionRequest, actionResponse);
			}
		}
		catch (Exception e) {
			if (e instanceof DuplicateUserEmailAddressException ||
				e instanceof DuplicateUserScreenNameException) {

				String emailAddress = ParamUtil.getString(
					actionRequest, "emailAddress");

				try {
					User user = UserLocalServiceUtil.getUserByEmailAddress(
						themeDisplay.getCompanyId(), emailAddress);

					if (user.getStatus() !=
							WorkflowConstants.STATUS_INCOMPLETE) {

						SessionErrors.add(
							actionRequest, e.getClass().getName(), e);
					}
					else {
						setForward(
							actionRequest, "portlet.login.update_account");
					}
				}
				catch (NoSuchUserException nsue) {
					SessionErrors.add(actionRequest, e.getClass().getName(), e);
				}
			}
			else if (e instanceof AddressCityException ||
					 e instanceof AddressStreetException ||
					 e instanceof AddressZipException ||
					 e instanceof CaptchaMaxChallengesException ||
					 e instanceof CaptchaTextException ||
					 e instanceof CompanyMaxUsersException ||
					 e instanceof ContactFirstNameException ||
					 e instanceof ContactFullNameException ||
					 e instanceof ContactLastNameException ||
					 e instanceof EmailAddressException ||
					 e instanceof NoSuchCountryException ||
					 e instanceof NoSuchListTypeException ||
					 e instanceof NoSuchOrganizationException ||
					 e instanceof NoSuchRegionException ||
					 e instanceof OrganizationParentException ||
					 e instanceof PhoneNumberException ||
					 e instanceof RequiredFieldException ||
					 e instanceof RequiredUserException ||
					 e instanceof ReservedUserEmailAddressException ||
					 e instanceof ReservedUserScreenNameException ||
					 e instanceof TermsOfUseException ||
					 e instanceof UserEmailAddressException ||
					 e instanceof UserIdException ||
					 e instanceof UserPasswordException ||
					 e instanceof UserScreenNameException ||
					 e instanceof UserSmsException ||
					 e instanceof WebsiteURLException) {

				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}

		if (Validator.isNull(PropsValues.COMPANY_SECURITY_STRANGERS_URL)) {
			return;
		}

		try {
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(
				themeDisplay.getScopeGroupId(), false,
				PropsValues.COMPANY_SECURITY_STRANGERS_URL);

			String redirect = PortalUtil.getLayoutURL(layout, themeDisplay);

			sendRedirect(actionRequest, actionResponse, redirect);
		}
		catch (NoSuchLayoutException nsle) {
		}
	}

	@Override
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		Company company = PortalUtil.getCompany(renderRequest);

		if (!company.isStrangers()) {
			throw new PrincipalException();
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		renderResponse.setTitle(themeDisplay.translate("create-account"));

		return mapping.findForward(
			getForward(renderRequest, "portlet.login.create_account"));
	}

	protected void addUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);
		HttpSession session = request.getSession();

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		Company company = themeDisplay.getCompany();

		boolean autoPassword = true;
		String password1 = null;
		String password2 = null;
		boolean autoScreenName = isAutoScreenName();
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(
			actionRequest, "emailAddress");
		long facebookId = ParamUtil.getLong(actionRequest, "facebookId");
		String openId = ParamUtil.getString(actionRequest, "openId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		int birthdayMonth = ParamUtil.getInteger(
			actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		if (PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD) {
			autoPassword = false;

			password1 = ParamUtil.getString(actionRequest, "password1");
			password2 = ParamUtil.getString(actionRequest, "password2");
		}

		boolean openIdPending = false;

		Boolean openIdLoginPending = (Boolean)session.getAttribute(
			WebKeys.OPEN_ID_LOGIN_PENDING);

		if ((openIdLoginPending != null) &&
			(openIdLoginPending.booleanValue()) &&
			(Validator.isNotNull(openId))) {

			sendEmail = false;
			openIdPending = true;
		}

		
		// check accountRole - numberPhone
		String accountRole = ParamUtil.getString(actionRequest, "accountRole","");
		String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone","");
		boolean subscriberAccount=false;
		
		if(accountRole.equals("subscriberAccount")){
			subscriberAccount=true;
			if(!Validator.isPhoneNumber(mobilePhone)) {
				throw new Exception("mobile-phone-invalid");
			}
			
			try {
			UserEntry  tmpEmtry = UserEntryLocalServiceUtil.findByMobilePhone(mobilePhone);
			if(tmpEmtry!=null)	throw new Exception("mobile-phone-invalid");
			} catch (Exception e) {
				// TODO: handle exception
				
			}
			
		}
		//accountRole
		User user = UserServiceUtil.addUserWithWorkflow(
			company.getCompanyId(), autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			themeDisplay.getLocale(), firstName, middleName, lastName, prefixId,
			suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
			groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
			serviceContext);
		
		if (openIdPending) {
			session.setAttribute(
				WebKeys.OPEN_ID_LOGIN, new Long(user.getUserId()));
			session.removeAttribute(WebKeys.OPEN_ID_LOGIN_PENDING);
		}
		else {

			// Session messages

			if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
				SessionMessages.add(
					request, "user_added", user.getEmailAddress());
				SessionMessages.add(
					request, "user_added_password",
					user.getPasswordUnencrypted());
			}
			else {
				SessionMessages.add(
					request, "user_pending", user.getEmailAddress());
			}
		}

		// ============================================================
		// create user success - ok then create vrbt_user
		// add new UserEntry ( vrbt_user table ) 
		UserEntry userEntry = null;
		try {
			userEntry = UserEntryLocalServiceUtil.createUserEntry(CounterLocalServiceUtil.increment(UserEntry.class.getName()));
			userEntry.setUserId(user.getUserId());
			userEntry.setUserName(user.getScreenName());
			userEntry.setGroupId(user.getGroupId());
			userEntry.setCompanyId(user.getCompanyId());
			userEntry.setCreateDate(Calendar.getInstance().getTime());
			userEntry.setStatus(1);
			if(subscriberAccount){
				userEntry.setMobilePhone(mobilePhone);
			}
			UserEntryLocalServiceUtil.updateUserEntry(userEntry);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// add role
		long roleId=0;
		try {
			Role role = null;
			if(subscriberAccount){
			  role = RoleLocalServiceUtil.getRole(PortalUtil.getCompanyId(request), "Subscriber");
			  if(role!=null) roleId= role.getRoleId();
			}else{
				role = RoleLocalServiceUtil.getRole(PortalUtil.getCompanyId(request), "Third-party");
				if(role!=null) roleId= role.getRoleId();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("roleId:"+roleId);
		if(roleId>0){
			try {
				RoleLocalServiceUtil.addUserRoles(user.getUserId(), new long[]{roleId});
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		// ============================================================
		// Send redirect

		String login = null;

		if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_ID)) {
			login = String.valueOf(user.getUserId());
		}
		else if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_SN)) {
			login = user.getScreenName();
		}
		else {
			login = user.getEmailAddress();
		}
		// fix 
		login = user.getScreenName();
		// 
		sendRedirect(
			actionRequest, actionResponse, themeDisplay, login,
			user.getPasswordUnencrypted());
	}

	protected boolean isAutoScreenName() {
		return _AUTO_SCREEN_NAME;
	}

	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	protected void resetUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String emailAddress = ParamUtil.getString(
			actionRequest, "emailAddress");

		User anonymousUser = UserLocalServiceUtil.getUserByEmailAddress(
			themeDisplay.getCompanyId(), emailAddress);

		UserLocalServiceUtil.deleteUser(anonymousUser.getUserId());

		addUser(actionRequest, actionResponse);
	}

	protected void sendRedirect(
			ActionRequest actionRequest, ActionResponse actionResponse,
			ThemeDisplay themeDisplay, String login, String password)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		String redirect = PortalUtil.escapeRedirect(
			ParamUtil.getString(actionRequest, "redirect"));

		if (Validator.isNotNull(redirect)) {
			HttpServletResponse response = PortalUtil.getHttpServletResponse(
				actionResponse);

			LoginUtil.login(request, response, login, password, false, null);
		}
		else {
			PortletURL loginURL = LoginUtil.getLoginURL(
				request, themeDisplay.getPlid());

			loginURL.setParameter("login", login);

			redirect = loginURL.toString();
		}

		actionResponse.sendRedirect(redirect);
	}

	protected void updateIncompleteUser(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(
			actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		boolean autoPassword = true;
		String password1 = null;
		String password2 = null;
		boolean autoScreenName = false;
		String screenName = ParamUtil.getString(actionRequest, "screenName");
		String emailAddress = ParamUtil.getString(
			actionRequest, "emailAddress");
		long facebookId = ParamUtil.getLong(actionRequest, "facebookId");
		String openId = ParamUtil.getString(actionRequest, "openId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String middleName = ParamUtil.getString(actionRequest, "middleName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		int prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
		int suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
		boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
		int birthdayMonth = ParamUtil.getInteger(
			actionRequest, "birthdayMonth");
		int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
		int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		boolean updateUserInformation = true;
		boolean sendEmail = true;

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			User.class.getName(), actionRequest);

		User user = UserServiceUtil.updateIncompleteUser(
			themeDisplay.getCompanyId(), autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			themeDisplay.getLocale(), firstName, middleName, lastName, prefixId,
			suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle,
			sendEmail, updateUserInformation, serviceContext);

		// Session messages

		if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
			SessionMessages.add(request, "user_added", user.getEmailAddress());
			SessionMessages.add(
				request, "user_added_password", user.getPasswordUnencrypted());
		}
		else {
			SessionMessages.add(
				request, "user_pending", user.getEmailAddress());
		}

		// Send redirect

		String login = null;

		Company company = themeDisplay.getCompany();

		if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_ID)) {
			login = String.valueOf(user.getUserId());
		}
		else if (company.getAuthType().equals(CompanyConstants.AUTH_TYPE_SN)) {
			login = user.getScreenName();
		}
		else {
			login = user.getEmailAddress();
		}

		sendRedirect(
			actionRequest, actionResponse, themeDisplay, login,
			user.getPasswordUnencrypted());
	}

	private static final boolean _AUTO_SCREEN_NAME = false;

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
}