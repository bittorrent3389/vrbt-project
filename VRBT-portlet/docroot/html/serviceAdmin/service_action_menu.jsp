<%@ include file="/html/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	ServiceEntry serviceEntry = (ServiceEntry) row.getObject();
	
	PortletURL redirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String redirect = redirectURL.toString();
%>

<%-- Tao render URL cho edit action --%>

<portlet:renderURL var="editServiceURL">
	<portlet:param name="serviceId" value="<%= String.valueOf(serviceEntry.getServiceId()) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
	<portlet:param name="jspPage" value="/html/serviceAdmin/service_edit_form.jsp"></portlet:param>
</portlet:renderURL>

<%-- Tao action URL cho edit action --%>

<portlet:actionURL var="deleteServiceURL" name="deleteService">
	<portlet:param name="serviceId" value="<%= String.valueOf(serviceEntry.getServiceId()) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<liferay-ui:icon-menu>
	<liferay-ui:icon image="edit" url="<%= editServiceURL %>"/>
	<liferay-ui:icon image="delete" url="<%= deleteServiceURL %>"/>
</liferay-ui:icon-menu>