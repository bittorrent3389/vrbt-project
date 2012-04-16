<%@ include file="/html/init.jsp" %>

<%
	
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CategoryEntry categoryEntry= (CategoryEntry) row.getObject();
	
	PortletURL redirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String redirect = redirectURL.toString();
%>

<%-- Tao render URL cho edit action --%>

<portlet:renderURL var="editCategoryURL">
	<portlet:param name="categoryId" value="<%= String.valueOf(categoryEntry.getCategoryId()) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
	<portlet:param name="jspPage" value="/html/categoryAdmin/category_edit_form.jsp"></portlet:param>
</portlet:renderURL>

<%-- Tao action URL cho edit action --%>

<portlet:actionURL var="deleteCategoryURL" name="deleteCategory">
	<portlet:param name="categoryId" value="<%= String.valueOf(categoryEntry.getCategoryId()) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" url="<%= editCategoryURL %>"/>
	<liferay-ui:icon image="delete" url="<%= deleteCategoryURL %>"/>
</liferay-ui:icon-menu>