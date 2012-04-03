<%@ include file="/html/init.jsp" %>

<% 
	long userId;
	boolean isAllow = false;
	
	long companyId;
	long roleId;
	
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
		<liferay-ui:error  key="error-message" message="portlet-service-view-error-message-errorCategoryFormMessage"/>
		<liferay-ui:error  key="error-add-category-message" message="portlet-service-view-error-message-errorAddCategoryMessage"/>
		<liferay-ui:error  key="error-edit-category-message" message="portlet-service-view-error-message-errorEditCategoryMessage"/>
		<liferay-ui:error  key="error-delete-category-message" message="portlet-service-view-error-message-errorDeleteCategoryMessage"/>
	</div>

	<liferay-ui:tabs names="View Category,Add Category" refresh="false">
		<liferay-ui:section>
			<%@ include file="/html/category/view_search.jsp" %>
		</liferay-ui:section>
	
		<liferay-ui:section>
			<%@ include file="/html/category/category_add_form.jsp" %>
		</liferay-ui:section>
	</liferay-ui:tabs>
</c:if>