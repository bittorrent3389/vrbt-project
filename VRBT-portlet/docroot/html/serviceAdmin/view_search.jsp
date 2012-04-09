<%@ include file="/html/init.jsp" %>
<aui:fieldset>
	<%--Render URL for search container --%>
	<%
		PortletURL searchRenderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		RowChecker rowChecker = new RowChecker(renderResponse);
		rowChecker.setRowIds("serviceIds");
		rowChecker.setAllRowIds("serviceAllRowIds");
	%>
	
	<%-- Search form --%>
	
	<liferay-util:include page="/html/serviceAdmin/service_search_form.jsp" 
		servletContext="<%= this.getServletContext() %>"/>

	<hr/>
	<%-- Search container --%>
	
	<%
		String serviceCode = ParamUtil.getString(renderRequest, "serviceCode",null);
		String serviceName = ParamUtil.getString(renderRequest, "serviceName",null);
		int status = ParamUtil.getInteger(renderRequest, "status", 1);
		int searchType = ParamUtil.getInteger(renderRequest, "searchType", 1);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<liferay-ui:search-container delta="5" emptyResultsMessage="portlet-service-view_search-search-container-emptyResultsMessage" 
		iteratorURL="<%= searchRenderURL %>" rowChecker="<%= rowChecker %>">
		<liferay-ui:search-container-results
			results="<%= ServiceEntryLocalServiceUtil.search(serviceCode, serviceName, status, searchContainer.getStart(), searchContainer.getEnd(), searchType) %>"
			total="<%= ServiceEntryLocalServiceUtil.searchCount(serviceCode, serviceName, status, searchType) %>"
			/>
				
		<liferay-ui:search-container-row className="vn.com.fis.portal.model.ServiceEntry" keyProperty="serviceId" modelVar="serviceVar">
		
			<% String modifiedDate = "";
			
				if(serviceVar.getModifiedDate() != null)
					modifiedDate = dateFormat.format(serviceVar.getModifiedDate());
			%>
		
			<liferay-ui:search-container-column-text name="portlet-service-view_search-search-container-column-text-serviceCode" 
				value="<%= String.valueOf(serviceVar.getServiceCode()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-service-view_search-search-container-column-text-serviceName" 
				value="<%= String.valueOf(serviceVar.getServiceName()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-service-view_search-search-container-column-text-description" 
				value="<%= String.valueOf(serviceVar.getDescription()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-service-view_search-search-container-column-text-status" 
				value="<%= String.valueOf(serviceVar.getStatus()) %>"/>			
			<liferay-ui:search-container-column-text name="portlet-service-view_search-search-container-column-text-createDate" 
				value="<%= dateFormat.format(serviceVar.getCreateDate()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-service-view_search-search-container-column-text-modifiedDate" 
				value="<%= modifiedDate %>"/>
			<liferay-ui:search-container-column-jsp path="/html/serviceAdmin/service_action_menu.jsp"/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
	
</aui:fieldset>