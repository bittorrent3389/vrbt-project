<%@ include file="/html/init.jsp" %>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL curRedirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String curRedirect = curRedirectURL.toString();

	long userId = permissionChecker.getUserId();
	UserEntry userEntry = null;
	
	/* String userService = ""; */
	
	long companyId = 0;
	long roleId = 0;
	boolean isAllow = false;

	List<UserServiceEntry> userService = null;
	
	try{
		
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Subscriber").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			userEntry = UserEntryLocalServiceUtil.getUserEntry(userId);
			userService = UserServiceEntryLocalServiceUtil.findByUserId_serviceStatus(userId, 1);
			isAllow = true;
		}
		
	}catch(Exception e){
		System.out.println("Subscriber role does not exist");
		e.printStackTrace();
		isAllow = false;
	}
%>

<c:if test="<%= !isAllow %>">
	<fieldset>
		<liferay-ui:message key="portlet-message-deniedPermission"/>
	</fieldset>
	<br/>
	<br/>
</c:if>

<c:if test="<%= isAllow %>">
	<portlet:renderURL var="registerServiceURL">
		<portlet:param name="jspPage" value="/html/subscriber_ServiceMng/subscriber_servicePackage_detail_form.jsp"/>
		<portlet:param name="redirect" value="<%= curRedirect %>"/>
	</portlet:renderURL>
	
	<fieldset>
		<liferay-ui:header title="My Service" backURL="<%= redirect %>"/>
		
		<c:if test='<%= userService.size() > 0 && userService != null %>'>
			<% for(UserServiceEntry serviceEntry : userService) { %>
				<portlet:actionURL var="stopServiceURL" name="registrationService">
					<portlet:param name="serviceId" value="<%= String.valueOf(serviceEntry.getServiceId()) %>"/>
					<portlet:param name="userId" value="<%= String.valueOf(userEntry.getUserId()) %>"/>
					<portlet:param name="isUse" value="1"/>
					<portlet:param name="redirect" value="<%= curRedirect %>"/>
				</portlet:actionURL>
				
				<aui:fieldset>				
					<aui:column>
						<liferay-ui:message key="You are using "/>
							<%= ServiceEntryLocalServiceUtil.getServiceEntry(serviceEntry.getServiceId()).getServiceName() %>
						<liferay-ui:message key="  service."/>
					</aui:column>
			
					<aui:column>
						<aui:button name="Stop" value="Stop Service" onClick="<%= stopServiceURL %>"/>
					</aui:column>	
				</aui:fieldset>
				<hr/>
			<% } %>
			
			<aui:a label="Click to register new service." onClick="<%= registerServiceURL %>" href="<%= registerServiceURL %>"/>
			<br/>
		</c:if>
		
		<c:if test='<%= userService.size() <= 0 || userService == null %>'>
			<liferay-ui:message key='No service in use.'/>
			<hr/>
			<aui:a label="Click to register new service." onClick="<%= registerServiceURL %>" href="<%= registerServiceURL %>"/>
		</c:if>
	</fieldset>
	<br/>
</c:if>