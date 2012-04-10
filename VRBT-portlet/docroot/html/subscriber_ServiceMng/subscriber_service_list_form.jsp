<%@ include file="/html/init.jsp" %>

<% 
	String editDirect = ParamUtil.getString(renderRequest, "redirect");
	List<ServiceEntry> listService = ServiceEntryLocalServiceUtil.findBystatus(1);
%>

<% for(ServiceEntry service : listService){ 
		List<ServicePackageEntry> list = null;
		list = ServicePackageEntryLocalServiceUtil.findByserviceId(service.getServiceId());
	
		if(list == null || list.size() <= 0){
			%>
			<portlet:renderURL var="selectServiceURL">
				<portlet:param name="jspPage" value="/html/subscriber_ServiceMng/subscriber_service_edit_form.jsp"/>
				<portlet:param name="userId" value="<%= String.valueOf(permissionChecker.getUserId()) %>"/>
				<portlet:param name="serviceId" value="<%= String.valueOf(service.getServiceId()) %>"/>
				<portlet:param name="redirect" value="<%= editDirect %>"></portlet:param>
			</portlet:renderURL>

			<aui:a href="<%= selectServiceURL %>" label="<%= service.getServiceName() %>"/>
			<hr/>
<% }} %>
