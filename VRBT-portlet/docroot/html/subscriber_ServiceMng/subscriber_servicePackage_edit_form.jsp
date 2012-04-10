<%@ include file="/html/init.jsp" %>
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	PortletURL curRedirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String curRedirect = curRedirectURL.toString();

	long userId = permissionChecker.getUserId();
	UserEntry userExt = null;
	
	long companyId = 0;
	long roleId = 0;
	boolean isAllow = false;

	Long serviceId = ParamUtil.getLong(renderRequest, "serviceId", 0);

	ServiceEntry serviceEntry = null;
	List<ServicePackageEntry> listPackage = null;

	try{
		
		companyId = PortalUtil.getCompanyId(renderRequest);
		
		roleId = RoleLocalServiceUtil.getRole(companyId, "Subscriber").getRoleId();
	
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			isAllow = true;
			userExt =UserEntryLocalServiceUtil.getUserEntry(userId);

			if(serviceId > 0){
				serviceEntry = ServiceEntryLocalServiceUtil.getServiceEntry(serviceId);
				
				if(ServicePackageEntryLocalServiceUtil.countByserviceId_status(serviceId, 1) > 0)
					listPackage = ServicePackageEntryLocalServiceUtil.findByserviceId_Status(serviceId, 1);
			}	
		}
			
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Subscriber role does not exist");
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
	<%
		long packageId = 0;
		boolean isUse = false;
	
		if(UserServiceEntryLocalServiceUtil.countByUserId_ServiceId(userId, serviceId) > 0){
			isUse = true;
			UserServiceEntry userServiceEntry = UserServiceEntryLocalServiceUtil.findByUserId_ServiceId(userId, serviceId);
			packageId = userServiceEntry.getServicePackageId();
		}
	%>
	<portlet:renderURL var="subscriber_Service_currentFormURL">
		<portlet:param name="jspPage" value="/html/subscriber_serviceMng/subscriber_servicePackage_edit_form.jsp"/>
		<portlet:param name="serviceId" value="<%= String.valueOf(serviceId) %>"/>
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:renderURL>

	<fieldset>
		<liferay-ui:header backURL="<%= redirect %>" title="Service Package List"/>
	
		<aui:layout>
			<aui:column columnWidth="300">
				<%@ include file="/html/subscriber_ServiceMng/subscriber_servicePackage_list_form.jsp" %>
			</aui:column>	
	
			<aui:column columnWidth="600" >
				<c:if test="<%= serviceId > 0 %>">	
					<c:if test="<%= listPackage.size() > 0 %>">	
						<portlet:actionURL var="registrationServicePackageURL" name="registrationServicePackage">
							<portlet:param name="serviceId" value="<%= String.valueOf(serviceEntry.getServiceId()) %>"/>
							<portlet:param name="userId" value="<%= String.valueOf(userExt.getUserId()) %>"/>
							<portlet:param name="curRedirect" value="/html/subscriber_serviceMng/subscriber_service_edit_form.jsp"/>
							<portlet:param name="redirect" value="<%= redirect %>"/>
						</portlet:actionURL>
						
						<portlet:actionURL var="removeServicePackageURL" name="removeServicePackage">
							<portlet:param name="userId" value="<%= String.valueOf(userExt.getUserId()) %>"/>
							<portlet:param name="serviceId" value="<%= String.valueOf(serviceEntry.getServiceId()) %>"/>
							<portlet:param name="packageId" value="<%= String.valueOf(packageId) %>"/>
							<portlet:param name="redirect" value="<%= curRedirect %>"/>
						</portlet:actionURL>
					
						<b><%= serviceEntry.getServiceCode() %> - <%= serviceEntry.getServiceName() %></b>
						<hr />
						<br />
				
						<aui:form action="<%= registrationServicePackageURL %>" method="POST" name="registrationServicePackageForm">
							<aui:field-wrapper name="<%= serviceEntry.getServiceName() %>" label="">
								<% for(ServicePackageEntry packageExt :listPackage) { 
									%>
																		
									<aui:input type="radio" name="<%= serviceEntry.getServiceName() %>" value="<%= packageExt.getServicePackageId() %>"
										checked="<%= isUse %>"	
										showRequiredLabel="true" label="<%= packageExt.getServicePackageName() %>"/>
								<% } %> 
							</aui:field-wrapper>
						
							<aui:button-row>
								<aui:button type="submit" value="portlet-subscriber_serviceMng-subscriber_service_edit_form-button-save" name="save"/>
								<aui:button type="button" value="Stop Package" name="stop" href="<%= removeServicePackageURL %>"/>
							</aui:button-row>
						</aui:form>
					</c:if>
				</c:if>	
			</aui:column>
		</aui:layout>
	</fieldset>

	<br/>
</c:if>

