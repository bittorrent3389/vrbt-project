<%@ include file="/html/init.jsp" %>
<% 
	long userId = 0;
	boolean isAllow = false;
	
	long companyId = 0;
	long roleId = 0;
	
	try{
		userId = permissionChecker.getUserId();
	
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Subscriber").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
			isAllow = true;
		
	}catch(Exception e)
	{
		e.printStackTrace();
		isAllow = false;
	}
%>

<liferay-ui:tabs names="My Service" refresh="false">
	<c:if test="<%= !isAllow %>">
		<fieldset>
			<liferay-ui:message key="portlet-message-deniedPermission"/>
		</fieldset>
		<br/>
		<br/>	
	</c:if>
	
	<c:if test="<%= isAllow %>">
		<liferay-ui:section>
		<%@ include file="/html/subscriber_ServiceMng/subscriber_service_view_form.jsp" %>
	</liferay-ui:section>
	</c:if>
</liferay-ui:tabs>