<%@ include file="/html/init.jsp" %>
<%-- tao render URL --%>

<portlet:actionURL var="searchServiceURL" name="serviceSearch"/>

<aui:form action="<%= searchServiceURL %>" method="post" name="searchServiceForm">

	<% int searchType = ParamUtil.getInteger(renderRequest, "searchType", 1); %>
	
	<aui:select name="searchType" label=""
		prefix="portlet-service-service_search_form-searchServiceForm-select-prefix" 
		suffix="portlet-service-service_search_form-searchServiceForm-select-suffix">
		
		<aui:option label="portlet-service-service_search_form-searchServiceForm-select-option-searchType-1" 
				value="1" selected="<%= searchType==1 %>"/>
		<aui:option label="portlet-service-service_search_form-searchServiceForm-select-option-searchType-0" 
				value="0" selected="<%= searchType==0 %>"/>
	</aui:select>

	<aui:input name="serviceCode" size="30" type="text" 
		value='<%= ParamUtil.getString(renderRequest, "serviceCode", "") %>'
		label="portlet-service-service_search_form-searchServiceForm-input-serviceCode"/>
	
	<aui:input name="serviceName" size="30" type="text"
		value='<%= ParamUtil.getString(renderRequest, "serviceName", "") %>'
		label="portlet-service-service_search_form-searchServiceForm-input-serviceName"/>
		
		
	<% int status = ParamUtil.getInteger(renderRequest, "status", 1); %>
	<aui:select name="status" label="portlet-service-service_search_form-searchServiceForm-select-status">
		<aui:option label="portlet-service-service_search_form-searchServiceForm-select-option-type-1" 
			value="1" selected='<%= status==1 %>'/>
		<aui:option label="portlet-service-service_search_form-searchServiceForm-select-option-type-0" 
			value="0" selected='<%= status==0 %>'/>
	</aui:select>
	
	<aui:button-row>
		<aui:button type="submit" 
			value="portlet-service-service_search_form-searchServiceForm-button-search"
			name="search" />
	</aui:button-row>
</aui:form>