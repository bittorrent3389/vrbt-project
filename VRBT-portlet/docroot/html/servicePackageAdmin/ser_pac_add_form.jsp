<%@ include file="/html/init.jsp" %>
<%-- Tao action URL --%>

<portlet:actionURL var="addServicePackageURL" name="addServicePackage">
</portlet:actionURL>

<%-- Tao form add service --%>

<aui:form action="<%= addServicePackageURL %>" method="post" name="addServicePackageForm">
	<aui:input name="servicePackageCode" size="30" type="text" 
		label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-input-servicePackageCode">
		<aui:validator name="required"/>
		<aui:validator name="rangeLength">[0,300]</aui:validator>	
	</aui:input>
	
	<aui:input name="servicePackageName" size="30" type="text" 
		label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-input-servicePackageName">
		<aui:validator name="required"/>
		<aui:validator name="rangeLength">[0,300]</aui:validator>	
	</aui:input>
	
	<% List<ServiceExt> list = ServiceExtLocalServiceUtil.findBystatus(1);	%>
	
	<aui:select name="service" label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-input-service">
		<% for(ServiceExt serviceExt : list) { %>
			<aui:option value="<%= serviceExt.getServiceId() %>">
				<liferay-ui:message key='<%= serviceExt.getServiceCode()+" - "+serviceExt.getServiceName() %>'/>
			</aui:option>
		<% } %>
	</aui:select>
	
	<aui:input name="maxSize" size="30" type="text" 
		label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-input-maxSize">
		<aui:validator name="required"/>
		<aui:validator name="rangeLength">[0,30]</aui:validator>
		<aui:validator name="number"/>
	</aui:input>
	
	<aui:input name="description" size="30" type="text" label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-input-description"/>
	
	<aui:select name="status" label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-select-status">
		<aui:option label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-select-option-type-1" value="1"/>
		<aui:option label="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-select-option-type-0" value="0"/>
	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" value="portlet-servicePackage-ser_pac_add_form-addServicePackageForm-button-save" name="save"/>
	</aui:button-row>
</aui:form>
