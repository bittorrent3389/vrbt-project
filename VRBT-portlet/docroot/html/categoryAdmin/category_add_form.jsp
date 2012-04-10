<%@ include file="/html/init.jsp" %>

<%-- Tao action URL --%>

<portlet:actionURL var="addCategoryURL" name="addCategory"/>

<%-- Tao form add service --%>

<aui:form action="<%= addCategoryURL %>" method="post" name="addCategoryForm">
	<aui:input name="categoryName" size="30" type="text" 
		label="portlet-category-category_add_form-addCategoryForm-input-categoryName">
		<aui:validator name="required"/>
		<aui:validator name="rangeLength">[0,300]</aui:validator>
	</aui:input>
	<aui:input name="description" size="30" type="text" 
		label="portlet-category-category_add_form-addCategoryForm-input-description">
	</aui:input>
	<aui:select name="status" label="portlet-category-category_add_form-addCategoryForm-select-status">
		<aui:option label="portlet-category-category_add_form-addCategoryForm-select-option-type-1" value="1"/>
		<aui:option label="portlet-category-category_add_form-addCategoryForm-select-option-type-0" value="0"/>
	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" name="save" 
			value="portlet-category-category_add_form-addCategoryForm-button-save"/>
	</aui:button-row>
</aui:form>
