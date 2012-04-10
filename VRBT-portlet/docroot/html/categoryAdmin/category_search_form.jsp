<%@ include file="/html/init.jsp" %>

<% 
	int searchType = ParamUtil.getInteger(renderRequest, "searchType", 1); 
	int status = ParamUtil.getInteger(renderRequest, "status", 1); 
	String categoryName = ParamUtil.getString(renderRequest, "categoryName", "");
%>
	
<%-- tao render URL --%>

<portlet:actionURL var="searchCategoryURL" name="categorySearch"/>

<aui:form action="<%= searchCategoryURL %>" method="post" name="searchCategoryForm">
	
	<%-- <aui:select name="searchType" label=""
		prefix="portlet-category-category_search_form-searchCategoryForm-select-prefix" 
		suffix="portlet-category-category_search_form-searchCategoryForm-select-suffix">
		
		<aui:option label="portlet-category-category_search_form-searchCategoryForm-select-option-searchType-1" 
				value="1" selected="<%= searchType==1 %>"/>
		<aui:option label="portlet-category-category_search_form-searchCategoryForm-select-option-searchType-0" 
				value="0" selected="<%= searchType==0 %>"/>
	</aui:select>
 --%>
	<aui:input name="categoryName" size="30" type="text" 
		value='<%= categoryName %>'
		label="portlet-category-category_search_form-searchCategoryForm-input-categoryName"/>
<%--	
	<aui:select name="status" label="portlet-category-category_search_form-searchCategoryForm-select-status">
		<aui:option label="portlet-category-category_search_form-searchCategoryForm-select-option-type-1" value="1"
			selected='<%= status==1 %>'/>
		<aui:option label="portlet-category-category_search_form-searchCategoryForm-select-option-type-0" value="0"
			selected='<%= status==0 %>'/>
	</aui:select> --%>
	
	<aui:button-row>
		<aui:button type="submit" name="Search" 
			value="portlet-category-category_search_form-searchCategoryForm-button-save"/>
	</aui:button-row>
</aui:form>