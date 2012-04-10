<%@ include file="/html/init.jsp" %>

<%
	UserEntry curUser = UserEntryLocalServiceUtil.getUserEntry(permissionChecker.getUserId()); 

	List<UserServiceEntry> usingService = new ArrayList<UserServiceEntry>();
	List<UserServiceEntry> usingPackageService = new ArrayList<UserServiceEntry>();
	List<UserServiceEntry> listService = new ArrayList<UserServiceEntry>();
	
	System.out.print("CurUser = "+curUser.getUserId());
		
	if(UserServiceEntryLocalServiceUtil.countByuserId(curUser.getUserId()) > 0)
		listService = UserServiceEntryLocalServiceUtil.findByuserId(curUser.getUserId());
	
	for(UserServiceEntry serviceEntry : listService){
		if(serviceEntry.getServiceId() > 0 && serviceEntry.getServiceStatus() == 1)
			usingService.add(serviceEntry);
		else
			if(serviceEntry.getServicePackageId() > 0)
				usingPackageService.add(serviceEntry);
	}
	
	PortletURL redirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String redirect = redirectURL.toString();
%>

<portlet:renderURL var="edit_Subscriber_ServiceURL">
	<portlet:param name="jspPage" value="/html/subscriber_ServiceMng/subscriber_service_detail_form.jsp"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:renderURL>

<portlet:renderURL var="edit_Subscriber_ServicePackageURL">
	<portlet:param name="jspPage" value="/html/subscriber_ServiceMng/subscriber_servicePackage_detail_form.jsp"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:renderURL>

<fieldset>
	<div>
		<c:if test='<%= usingService.size() > 0 %>'>
			<% for(UserServiceEntry usingServiceEntry : usingService) { %>		
				<liferay-ui:message key="portlet-subscriber_serviceMng-subscriber_service_view_form-message-prefixMessage" />
					<b>
						<%= ServiceEntryLocalServiceUtil.getServiceEntry(usingServiceEntry.getServiceId()).getServiceName() %>
					</b>				
				<liferay-ui:message key="portlet-subscriber_serviceMng-subscriber_service_view_form-message-suffixMessage1"/>
				<br/>
			<% } %>
		</c:if>
		
		<c:if test='<%= usingPackageService.size() > 0 %>'>
			<% for(UserServiceEntry usingPackageEntry : usingPackageService) { %>	
				<liferay-ui:message key="portlet-subscriber_serviceMng-subscriber_service_view_form-message-prefixMessage" />
					<b>
						<%= ServicePackageEntryLocalServiceUtil.getServicePackageEntry(usingPackageEntry.getServicePackageId()).getServicePackageName() %>
					</b>
				<liferay-ui:message key="portlet-subscriber_serviceMng-subscriber_service_view_form-message-suffixMessage2"/>	
				<br/>
			<% } %>
		</c:if>
		
		<c:if test='<%= usingService.size() <= 0 && usingPackageService.size() <= 0 %>'>
			<liferay-ui:message key="portlet-subscriber_serviceMng-subscriber_service_view_form-message-noService" />
		</c:if>
	</div>
	
	<hr/>
	
	<c:if test='<%= usingService.size() > 0 %>'>
		<aui:a href="<%= edit_Subscriber_ServiceURL %>" 
			label="Change your service."/>
		<br/>
	</c:if>
	
	<c:if test='<%= usingService.size() <= 0 %>'>
		<aui:a href="<%= edit_Subscriber_ServiceURL %>" 
			label="Register your service."/>
		<br/>
	</c:if>
		
	<c:if test='<%= usingPackageService.size() > 0 %>'>
		<aui:a href="<%= edit_Subscriber_ServicePackageURL %>" 
			label="Change your service package"/>
		<br/>
	</c:if>
				
	<c:if test='<%= usingPackageService.size() <= 0 %>'>
		<aui:a href="<%= edit_Subscriber_ServicePackageURL %>" 
			label="Register your service package."/>
		<br/>
	</c:if>
</fieldset> 

<br/>
<br/>