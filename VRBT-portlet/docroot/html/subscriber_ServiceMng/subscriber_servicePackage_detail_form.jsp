<%@ include file="/html/init.jsp" %>

<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL curRedirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String curRedirect = curRedirectURL.toString();

	long userId = permissionChecker.getUserId();
	UserEntry userEntry = null;
	
	long companyId = 0;
	long roleId = 0;
	boolean isAllow = false;

	List<UserServiceEntry> userPackage = new ArrayList<UserServiceEntry>();
	
	try{
		
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Subscriber").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			userEntry = UserEntryLocalServiceUtil.getUserEntry(userId);
			isAllow = true;
			
			if(UserServiceEntryLocalServiceUtil.countByuserId(userId) > 0)
				userPackage = UserServiceEntryLocalServiceUtil.findByuserId(userId);
			
			for(UserServiceEntry userServiceEntry : userPackage){
				if(userServiceEntry.getServicePackageId() <= 0)
					userPackage.remove(userServiceEntry);
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.print("Subscriber role does not exist");
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
	<portlet:renderURL var="registerServicePackageURL">
		<portlet:param name="jspPage" value="/html/subscriber_ServiceMng/subscriber_servicePackage_edit_form.jsp"/>
		<portlet:param name="redirect" value="<%= curRedirect %>"/>
	</portlet:renderURL>
	
	<fieldset>
		<liferay-ui:header title="My Service Package" backURL="<%= redirect %>"/>
		
		<c:if test='<%= userPackage.size() > 0 %>'>
			<% for(UserServiceEntry serviceEntry : userPackage) { %>
				<portlet:actionURL var="removeServicePackageURL" name="removeServicePackage">
					<portlet:param name="userId" value="<%= String.valueOf(userEntry.getUserId()) %>"/>
					<portlet:param name="serviceId" value="<%= String.valueOf(serviceEntry.getServiceId()) %>"/>
					<portlet:param name="packageId" value="<%= String.valueOf(serviceEntry.getServicePackageId()) %>"/>
					<portlet:param name="redirect" value="<%= curRedirect %>"/>
				</portlet:actionURL>
	
				<aui:fieldset>
					<aui:column>
						<liferay-ui:message key="You are using "/>
							<%= ServicePackageEntryLocalServiceUtil.getServicePackageEntry(serviceEntry.getServicePackageId()).getServicePackageName() %>
						<liferay-ui:message key="  service package."/>
					</aui:column>
			
					<aui:column>
						<aui:button name="Stop" value="Stop Service Package" onClick="<%= removeServicePackageURL %>"/>
					</aui:column>
				</aui:fieldset>
				<hr/>
			<% } %>
			
			<aui:a label="Click to register new service package." href="<%= registerServicePackageURL %>"/>
		</c:if>
		
		<c:if test='<%= userPackage.size() <= 0 %>'>
			<liferay-ui:message key='No service package in use.'/>
			<hr/>
			<aui:a label="Click to register new service package." href="<%= registerServicePackageURL %>"/>
		</c:if>
	</fieldset>
	<br/>
</c:if>