<%@ include file="/html/init.jsp" %>
<aui:fieldset>
	<%--Render URL for search container --%>
	<%
		PortletURL searchRenderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		RowChecker rowChecker = new RowChecker(renderResponse);
		rowChecker.setRowIds("ser_pacIds");
		rowChecker.setAllRowIds("ser_pacAllRowIds");
	%>
	
	<%-- Search form --%>
	
	<liferay-util:include page="/html/servicePackage/ser_pac_search_form.jsp" 
		servletContext="<%= this.getServletContext() %>"/>

	<hr/>
	<%-- Search container --%>
	
	<%
		String ser_pacCode = ParamUtil.getString(renderRequest, "servicePackageCode",null);
		String ser_pacName = ParamUtil.getString(renderRequest, "servicePackageName",null);
		long serviceId = ParamUtil.getLong(renderRequest, "service", 0);
		int status = ParamUtil.getInteger(renderRequest, "status", 1);
		int searchType = ParamUtil.getInteger(renderRequest, "searchType", 1);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	%>
	
	<liferay-ui:search-container delta="5" emptyResultsMessage="portlet-servicePackage-view_search-search-container-emptyResultsMessage" 
		iteratorURL="<%= searchRenderURL %>" rowChecker="<%= rowChecker %>">
		<liferay-ui:search-container-results
			results="<%=  ServicePackageEntryLocalServiceUtil.search(ser_pacCode, ser_pacName, serviceId, status, searchContainer.getStart(), searchContainer.getEnd(), searchType) %>"
			total="<%= ServicePackageEntryLocalServiceUtil.searchCount(ser_pacCode, ser_pacName, serviceId, status, searchType) %>"
			/>
		
		<liferay-ui:search-container-row className="vn.com.fis.portal.model.ServicePackageEntry" keyProperty="servicePackageId" modelVar="ser_pac_Var">
		
			<% String modifiedDate = "";
			
				if(ser_pac_Var.getModifiedDate() != null)
					modifiedDate = dateFormat.format(ser_pac_Var.getModifiedDate());
			%>
			
			<liferay-ui:search-container-column-text name="portlet-servicePackage-view_search-search-container-column-text-servicePackageCode" 
					value="<%= String.valueOf(ser_pac_Var.getServicePackageCode()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-servicePackage-view_search-search-container-column-text-servicePackageName" 
					value="<%= String.valueOf(ser_pac_Var.getServicePackageName()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-servicePackage-view_search-search-container-column-text-description" 
					value="<%= String.valueOf(ser_pac_Var.getDescription()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-servicePackage-view_search-search-container-column-text-status" 
					value="<%= String.valueOf(ser_pac_Var.getStatus()) %>"/>			
			<liferay-ui:search-container-column-text name="portlet-servicePackage-view_search-search-container-column-text-createDate" 
					value="<%= dateFormat.format(ser_pac_Var.getCreateDate()) %>"/>
			<liferay-ui:search-container-column-text name="portlet-servicePackage-view_search-search-container-column-text-modifiedDate" 
					value="<%= modifiedDate %>"/>
			<liferay-ui:search-container-column-jsp path="/html/servicePackage/ser_pac_action_menu.jsp"/>
		</liferay-ui:search-container-row>
		
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
	
</aui:fieldset>