<%@ include file="/html/init.jsp" %>

<%
	long userId = 0;
	boolean isAllow = false;

	long companyId = 0;
	long roleId = 0;
	
	long service_Id = 0;
	String redirect = "";
	
	ServiceEntry serviceEntry = null;

	try{
		userId = permissionChecker.getUserId();

		companyId = PortalUtil.getCompanyId(renderRequest);
	
		roleId = RoleLocalServiceUtil.getRole(companyId, "Network-Operator").getRoleId();

		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			isAllow = true;
			
			service_Id = ParamUtil.getLong(request, "serviceId");
			serviceEntry = ServiceEntryLocalServiceUtil.getServiceEntry(service_Id);

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

<c:if test="<%= !isAllow %>">
	<%-- Tao action URL --%>

	<portlet:actionURL var="editServiceURL" name="editService">
		<portlet:param name="redirect" value="<%= redirect %>"/>
	</portlet:actionURL>

	<%-- Header --%>
	<liferay-ui:header backURL="<%= redirect %>" 
		title='portlet-service-service_edit_form-header-title-EditService'/>

	<%-- Tao form add service --%>

	<aui:form action="<%= editServiceURL %>" method="post" name="editServiceForm">
		<aui:input name="serviceId" type="hidden" value="<%= serviceEntry.getServiceId() %>"/>
	
		<aui:input name="serviceCode" size="30" type="text" value="<%= serviceEntry.getServiceCode() %>"
				label="portlet-service-service_edit_form-editServiceForm-input-serviceCode">
			<aui:validator name="required"/>
			<aui:validator name="rangeLength">[0,300]</aui:validator>		
		</aui:input>
			
		<aui:input name="serviceName" size="30" type="text" value="<%= serviceEntry.getServiceName() %>"
				label="portlet-service-service_edit_form-editServiceForm-input-serviceName">
			<aui:validator name="required"/>
			<aui:validator name="rangeLength">[0,300]</aui:validator>		
		</aui:input>	
			
		<aui:input name="description" size="30" type="text" value="<%= serviceEntry.getDescription() %>"
				label="portlet-service-service_edit_form-editServiceForm-input-description"/>
	
		<aui:select name="status" label="portlet-service-service_edit_form-editServiceForm-select-status">
	
			<aui:option label="portlet-service-service_edit_form-editServiceForm-select-option-type-1" 
				value="1" selected='<%= serviceEntry.getStatus() == 1 %>'/> 
			
			<aui:option label="portlet-service-service_edit_form-editServiceForm-select-option-type-0" 
				value="0" selected='<%= serviceEntry.getStatus() == 0 %>'/>
		</aui:select>
	
		<aui:button-row>
			<aui:button type="submit" 
				value="portlet-service-service_edit_form-editServiceForm-button-save" name=""/>
		</aui:button-row>
	</aui:form>
</c:if>
