<%@ include file="/html/init.jsp" %>

<% 
	long userId = 0;
	boolean isAllow = false;
	
	long companyId = 0;
	long roleId = 0;
	
	try{
		userId = permissionChecker.getUserId();
	
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Network-Operator").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
			isAllow = true;
		
	}catch(Exception e)
	{
		e.printStackTrace();
		isAllow = false;
	}
%>

<c:if test="<%= !isAllow %>">
	<fieldset>
		<liferay-ui:message key="portlet-message-deniedPermission"/>	
	</fieldset>

	<br/>
</c:if>

<c:if test="<%= isAllow %>">
	<div>
		<liferay-ui:error  key="error-message" message="portlet-service-view-error-message-errorServiceFormMessage"/>
		<liferay-ui:error  key="error-add-service-message" message="portlet-service-view-error-message-errorAddServiceMessage"/>
		<liferay-ui:error  key="error-edit-service-message" message="portlet-service-view-error-message-errorEditServiceMessage"/>
		<liferay-ui:error  key="error-delete-service-message" message="portlet-service-view-error-message-errorDeleteServiceMessage"/>
	</div>

	<liferay-ui:tabs names="View Services,Add Service" refresh="false">
		<liferay-ui:section>
			<%@ include file="/html/serviceAdmin/view_search.jsp" %>
		</liferay-ui:section>
	
		<liferay-ui:section>
			<%@ include file="/html/serviceAdmin/service_add_form.jsp" %>
		</liferay-ui:section>
	</liferay-ui:tabs>
</c:if>