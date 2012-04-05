<%@ include file="/html/init.jsp" %>
<%-- Tao action URL --%>

<portlet:actionURL var="addServiceURL" name="addService">
</portlet:actionURL>

<%-- Tao form add service --%>

<aui:form action="<%= addServiceURL %>" method="post" name="addServiceForm">
	<aui:input name="serviceCode" size="30" type="text" label="portlet-service-service_add_form-addServiceForm-input-serviceCode">
		<aui:validator name="required"/>
		<aui:validator name="rangeLength">[0,300]</aui:validator>
	</aui:input>
	
	<aui:input name="serviceName" size="30" type="text" label="portlet-service-service_add_form-addServiceForm-input-serviceName">
		<aui:validator name="required"/>
		<aui:validator name="rangeLength">[0,300]</aui:validator>
	</aui:input>	
	
	<aui:input name="description" size="30" type="text" label="portlet-service-service_add_form-addServiceForm-input-description"/>
	
	<aui:select name="status" label="portlet-service-service_add_form-addServiceForm-select-status">
		<aui:option label="portlet-service-service_add_form-addServiceForm-select-option-type-1" value="1"/>
		<aui:option label="portlet-service-service_add_form-addServiceForm-select-option-type-0" value="0"/>
	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" value="portlet-service-service_add_form-addServiceForm-button-save" name="save"/>
	</aui:button-row>
</aui:form>
