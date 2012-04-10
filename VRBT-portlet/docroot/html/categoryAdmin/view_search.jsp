<%@ include file="/html/init.jsp" %>
<aui:fieldset>
	<%--Render URL for search container --%>
	<%
		String categoryName = ParamUtil.getString(renderRequest, "categoryName", "");
		int status = ParamUtil.getInteger(renderRequest, "status", 1);
		int searchType = ParamUtil.getInteger(renderRequest, "searchType", 1);
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
		PortletURL searchRenderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
		
		RowChecker rowChecker = new RowChecker(renderResponse);
		rowChecker.setRowIds("categoryId");
		rowChecker.setAllRowIds("categoryAllRowIds");
	%>
	
	<%-- Search form --%>
	
	<liferay-util:include page="/html/categoryAdmin/category_search_form.jsp" 
		servletContext="<%= this.getServletContext() %>"/>

	<hr/>
	<%-- Search container --%>
		
	<liferay-ui:search-container delta="5" emptyResultsMessage="portlet-category-view_search-search-container-emptyResultsMessage" 
		iteratorURL="<%= searchRenderURL %>" rowChecker="<%= rowChecker %>">
		<liferay-ui:search-container-results
			results="<%= CategoryEntryLocalServiceUtil.findByCategoryName(categoryName, searchContainer.getStart(), searchContainer.getEnd())%>"
			total="<%= CategoryEntryLocalServiceUtil.countByCategoryName(categoryName)%>"
			/>
				
				
		<liferay-ui:search-container-row className="vn.com.fis.portal.model.CategoryEntry" keyProperty="categoryId" modelVar="categoryVar">
			
			<liferay-ui:search-container-column-text name="portlet-category-view_search-search-container-column-text-categoryName" 
				value="<%= categoryVar.getCategoryName() %>"/>
			<liferay-ui:search-container-column-text name="portlet-category-view_search-search-container-column-text-description" 
				value="<%= categoryVar.getDescription() %>"/>
			<liferay-ui:search-container-column-jsp path="/html/categoryAdmin/category_action_menu.jsp"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
	
</aui:fieldset>