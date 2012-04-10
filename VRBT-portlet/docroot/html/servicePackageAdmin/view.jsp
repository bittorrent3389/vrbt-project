<%@ include file="/html/init.jsp" %>

<% 
	long userId = 0;
	boolean isAllow = false;
	
	long companyId = 0;
	long roleId =0;
	
	try{
		userId = permissionChecker.getUserId();
	
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Network-Operator").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
			isAllow = true;
		
	}catch(Exception e)
	{
		System.out.println("Network-Operator role does not exist");
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
		<liferay-ui:error key="error-message" message="portlet-servicePackage-view-error-message-errorServicePackageFormMessage"/>
		<liferay-ui:error  key="error-add-servicePackage-message" message="portlet-servicePackage-view-error-message-errorAddServicePackageMessage"/>
		<liferay-ui:error  key="error-edit-servicePackage-message" message="portlet-servicePackage-view-error-message-errorEditServicePackageMessage"/>
		<liferay-ui:error  key="error-delete-servicePackage-message" message="portlet-servicePackage-view-error-message-errorDeleteServicePackageMessage"/>
	</div>

	<liferay-ui:tabs names="View Services Package,Add Service Package" refresh="false">
		<liferay-ui:section>
			<%@ include file="/html/servicePackageAdmin/view_search.jsp" %>
		</liferay-ui:section>
	
		<liferay-ui:section>
			<%@ include file="/html/servicePackageAdmin/ser_pac_add_form.jsp" %>
		</liferay-ui:section>
	</liferay-ui:tabs>
</c:if>