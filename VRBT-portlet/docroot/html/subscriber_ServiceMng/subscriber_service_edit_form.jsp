<%@ include file="/html/init.jsp" %>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL curRedirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String curRedirect = curRedirectURL.toString();

	long userId = permissionChecker.getUserId();
	UserEntry userEntry = null;
	
	long companyId = 0;
	long roleId = 0;
	boolean isAllow = false;

	Long serviceId = ParamUtil.getLong(renderRequest, "serviceId", 0);

	ServiceEntry serviceExt = null;
	List<ServicePackageEntry> listPackage = new ArrayList<ServicePackageEntry>();

	try{
		
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Subscriber").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			isAllow = true;
			userEntry =UserEntryLocalServiceUtil.getUserEntry(userId);

			if(serviceId > 0){
				serviceExt = ServiceEntryLocalServiceUtil.getServiceEntry(serviceId);
				
				if(ServicePackageEntryLocalServiceUtil.countByserviceId_status(serviceId, 1) > 0)
					listPackage = ServicePackageEntryLocalServiceUtil.findByserviceId_Status(serviceId, 1);
			}	
		}
			
		
	}catch(Exception e){
		System.out.println("Subscriber role does not exist");
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
	<portlet:renderURL var="subscriber_Service_currentFormURL">
		<portlet:param name="jspPage" value="/html/subscriber_serviceMng/subscriber_service_edit_form.jsp"/>
		<portlet:param name="serviceId" value="<%= String.valueOf(serviceId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>

	<fieldset>
		<liferay-ui:header backURL="<%= redirect %>" title="Service List"/>
	
		<aui:layout>
			<aui:column columnWidth="300">
				<%@ include file="/html/subscriber_ServiceMng/subscriber_service_list_form.jsp" %>
			</aui:column>	
	
			<aui:column columnWidth="600" >
				<c:if test="<%= serviceId > 0 %>">
					<c:if test="<%= listPackage.size() <= 0 %>">
						<% 
							String action =  "Start service";
							String isUse = "0";
							
							if(UserServiceEntryLocalServiceUtil.countByUserId_ServiceId(userEntry.getUserId(), serviceId) > 0 
									&& UserServiceEntryLocalServiceUtil.findByUserId_ServiceId(userEntry.getUserId(), serviceId).getServiceStatus() == 1){
								action = "Stop serivce";
								isUse = "1";
							}
						%>
						<portlet:actionURL var="registrationServiceURL" name="registrationService">
							<portlet:param name="serviceId" value="<%= String.valueOf(serviceExt.getServiceId()) %>"/>
							<portlet:param name="userId" value="<%= String.valueOf(userEntry.getUserId()) %>"/>
							<portlet:param name="isUse" value="<%= isUse %>"/>
						
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:actionURL>
					
						<b><%= serviceExt.getServiceCode() %> - <%= serviceExt.getServiceName() %></b>
						<hr/>
						<br />
						<%= serviceExt.getDescription() %>
				
						<br/>
						<br/>
				
						<aui:button  type="button" name="" value="<%= action %>" href="<%= registrationServiceURL  %>" />
					</c:if>
				</c:if>
			</aui:column>
	</aui:layout>
	</fieldset>

	<br/>
</c:if>

