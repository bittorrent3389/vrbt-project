<%@ include file="/html/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ServicePackageEntry servicePackage = (ServicePackageEntry) row.getObject();
	
	PortletURL redirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String redirect = redirectURL.toString();
%>

<%-- Tao render URL cho edit action --%>

<portlet:renderURL var="editServicePackageURL">
	<portlet:param name="servicePackageId" value="<%= String.valueOf(servicePackage.getServicePackageId()) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
	<portlet:param name="jspPage" value="/html/servicePackageAdmin/ser_pac_edit_form.jsp"/>
</portlet:renderURL>

<%-- Tao action URL cho edit action --%>

<portlet:actionURL var="deleteServicePackageURL" name="deleteServicePackage">
	<portlet:param name="servicePackageId" value="<%= String.valueOf(servicePackage.getServicePackageId()) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" url="<%= editServicePackageURL %>"/>
	<liferay-ui:icon image="delete" url="<%= deleteServicePackageURL %>"/>
</liferay-ui:icon-menu>