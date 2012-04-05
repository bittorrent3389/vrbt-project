<%@ include file="/html/init.jsp" %>
<%
	long userId = 0;
	boolean isAllow = false;

	long companyId = 0;
	long roleId = 0;
	
	long servicePackageId = 0;
	ServicePackageEntry servicePackage = null;
	String redirect = "";
	List<ServiceEntry> list = null;

	try{
		userId = permissionChecker.getUserId();

		companyId = PortalUtil.getCompanyId(renderRequest);
	
		roleId = RoleLocalServiceUtil.getRole(companyId, "Network-Operator").getRoleId();

		if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
			isAllow = true;
			
			servicePackageId = ParamUtil.getLong(request, "servicePackageId");
			servicePackage = ServicePackageEntryLocalServiceUtil.getServicePackageEntry(servicePackageId);

			redirect = ParamUtil.getString(request, "redirect");
			
			list = ServiceEntryLocalServiceUtil.findBystatus(1);
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

<c:if test="<%= isAllow %>">
	<%-- Tao action URL --%>

	<portlet:actionURL var="editServicePackageURL" name="editServicePackage">
		<portlet:param name="servicePackageId" value="<%= String.valueOf(servicePackageId) %>"></portlet:param>
	</portlet:actionURL>

	<%-- Header --%>
	<liferay-ui:header backURL="<%=redirect %>" title="Edit Service Package"/>

	<%-- Tao form add service --%>

	<aui:form action="<%= editServicePackageURL %>" method="post" name="editServicePackageForm">

		<aui:input name="servicePackageCode" size="30" type="text" value="<%= servicePackage.getServicePackageCode() %>"
			label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-input-servicePackageCode" >
			<aui:validator name="required"/>
			<aui:validator name="rangeLength">[0,300]</aui:validator>
		</aui:input>
		
		<aui:input name="servicePackageName" size="30" type="text" value="<%= servicePackage.getServicePackageName() %>"
			label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-input-servicePackageName">
			<aui:validator name="required"/>
			<aui:validator name="rangeLength">[0,300]</aui:validator>
		</aui:input>
	
		<aui:select name="service" label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-select-service">
			<% for(ServiceEntry serviceExt : list) { %>
				<aui:option value="<%= serviceExt.getServiceId() %>" selected="<%= servicePackage.getServiceId()==serviceExt.getServiceId() %>">
					<liferay-ui:message key='<%= serviceExt.getServiceCode()+" - "+serviceExt.getServiceName() %>'/>
				</aui:option>
			<% } %>
		
		</aui:select>
	
		<aui:input name="maxSize" size="30" type="text" value="<%= servicePackage.getTotalFile() %>"
			label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-input-maxSize">
			<aui:validator name="required"/>
			<aui:validator name="rangeLength">[0,300]</aui:validator>
			<aui:validator name="number"/>
		</aui:input>
	
		<aui:input name="description" size="30" type="text" value="<%= servicePackage.getDescription() %>"
			label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-input-description"/>
	
		<aui:select name="status" label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-select-status">
			<aui:option label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-select-option-type-1" 
				value="1" selected="<%= servicePackage.getStatus()==1 %>"/>
			<aui:option label="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-select-option-type-0" 
				value="0" selected="<%= servicePackage.getStatus()==0 %>"/>
		</aui:select>
	
		<aui:button-row>
			<aui:button type="submit" value="portlet-servicePackage-ser_pac_edit_form-editServicePackageForm-button-save" name="save"/>
		</aui:button-row>
	</aui:form>
</c:if>
