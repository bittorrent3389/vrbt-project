<%@ include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>




<%
	long userId;
	boolean isAllow = false;

	long companyId=0;
	long roleId=0;
	
	long categoryId=0;
	String redirect="";
	CategoryEntry category =null;
	try{
		userId = permissionChecker.getUserId();

		companyId = PortalUtil.getCompanyId(renderRequest);
	
		roleId = RoleLocalServiceUtil.getRole(companyId, "Network-Operator").getRoleId();

		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			isAllow = true;
			
			categoryId = ParamUtil.getLong(renderRequest, "categoryId");
			 category = CategoryEntryLocalServiceUtil.getCategoryEntry(categoryId);
			
			redirect = ParamUtil.getString(request, "redirect");
		}
	
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
	<%-- Tao action URL --%>

	<portlet:actionURL var="editCategoryURL" name="editCategory">
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>

	<%-- Header --%>
	<liferay-ui:header backURL="<%= redirect %>" 
		title='portlet-service-service_edit_form-header-title-EditService'/>

	<%-- Tao form add service --%>

	<aui:form action="<%= editCategoryURL %>" method="post" name="editCategoryForm">
		<aui:input name="categoryId" type="hidden" value="<%= categoryId %>"/>
	
		<aui:input name="categoryName" size="30" type="text" value="<%= category.getCategoryName() %>" 
			label="portlet-category-category_edit_form-editCategoryForm-input-categoryName">
			<aui:validator name="required"/>
			<aui:validator name="rangeLength">[0,300]</aui:validator>
		</aui:input>
	
		<aui:select name="status" label="portlet-category-category_edit_form-editCategoryForm-select-status">
			<aui:option label="portlet-category-category_edit_form-editCategoryForm-select-option-type-1" 
				value="1" selected="<%= category.getStatus() == 1 %>"/>
			<aui:option label="portlet-category-category_edit_form-editCategoryForm-select-option-type-0" 
				value="0" selected="<%= category.getStatus() == 0 %>"/>
		</aui:select>
	
		<aui:button-row>
			<aui:button type="submit" name="save" 
				value="portlet-category-category_edit_form-editCategoryForm-button-save"/>
		</aui:button-row>
	</aui:form>
</c:if>

