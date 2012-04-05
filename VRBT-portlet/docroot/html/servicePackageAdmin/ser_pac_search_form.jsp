<%@ include file="/html/init.jsp" %>
<% 
	long serviceId = ParamUtil.getLong(renderRequest, "service", 0);
	int searchType = ParamUtil.getInteger(renderRequest, "searchType", 1); 
	int status = ParamUtil.getInteger(renderRequest, "status", 1);
	List<ServiceEntry> list = ServiceEntryLocalServiceUtil.findBystatus(1);
%>

<%-- tao render URL --%>

<portlet:actionURL var="searchServicPackageeURL" name="servicePackageSearch"/>

<aui:form action="<%= searchServicPackageeURL %>" method="post" name="searchServicePackageForm">
	
	<aui:select name="searchType"  label="" 
		prefix="portlet-service-service_search_form-searchServiceForm-select-prefix" 
		suffix="portlet-service-service_search_form-searchServiceForm-select-suffix">
		
		<aui:option label="portlet-servicePackage-service_search_form-searchServiceForm-select-option-type-1" 
				value="1" selected="<%= searchType==1 %>"/>
		<aui:option label="portlet-servicePackage-service_search_form-searchServiceForm-select-option-type-0" 
				value="0" selected="<%= searchType==0 %>"/>
	</aui:select>

	<aui:input name="servicePackageCode" size="30" type="text" 
		label="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-input-servicePackageCode"
		value='<%= ParamUtil.getString(renderRequest, "servicePackageCode", "") %>'/>
	<aui:input name="servicePackageName" size="30" type="text" 
		label="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-input-servicePackageName"
		value='<%= ParamUtil.getString(renderRequest, "servicePackageName", "") %>'/>
	
	<aui:select name="service" label="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-select-service">
		<aui:option value="0" selected="true">
			<liferay-ui:message key="Select All..."/>
		</aui:option>
		
		<% for(ServiceEntry serviceExt : list) { %>
			<aui:option value="<%= serviceExt.getServiceId() %>" 
				selected='<%= serviceExt.getServiceId() == serviceId %>'>
				<liferay-ui:message key='<%= serviceExt.getServiceCode()+" - "+serviceExt.getServiceName() %>'/>
			</aui:option>
		<% } %>
	</aui:select>
		
	<aui:select name="status" label="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-select-status">
		<aui:option label="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-select-option-type-1" 
			value="1" selected='<%= status==1 %>'/>
		<aui:option label="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-select-option-type-0" 
			value="0" selected='<%= status==0 %>'/>
	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" 
			value="portlet-servicePackage-ser_pac_search_form-searchServicePackageForm-button-search" name="search"/>
	</aui:button-row>
</aui:form>