<%@ include file="/html/init.jsp" %>
<% 
	List<CategoryExt> listCat = CategoryExtLocalServiceUtil.findBycategoryParentId_Status(0, 1);
%>

<div class="portal-add-content">

<liferay-ui:panel-container id="categoryMenu" extended="true" accordion="false" 
	cssClass="rightPanel_VRBT_Purchase_Shop">	
	
	<liferay-ui:panel title="" collapsible="false" extended="false">
		<portlet:actionURL var="viewAllVideoURL" name="viewVideoByCategory">
				<portlet:param name="categoryId" value="0"/>
			</portlet:actionURL>
			
		<aui:a href="<%= viewAllVideoURL %>" label="View All"/>
	</liferay-ui:panel>
	
	<% for(CategoryExt category : listCat) { 
		
		List<CategoryExt> listSubCategory = 
				CategoryExtLocalServiceUtil.findBycategoryParentId_Status(category.getCategoryId(), 1);
		%>
		
		<liferay-ui:panel title="" collapsible="false" extended="false">
			
			<portlet:actionURL var="viewVideoByRootCategoryURL" name="viewVideoByCategory">
				<portlet:param name="categoryId" value="<%= String.valueOf(category.getCategoryId()) %>"/>
			</portlet:actionURL>
				
			<aui:a href="<%= viewVideoByRootCategoryURL %>" label="<%= category.getCategoryName() %>"/>
		</liferay-ui:panel>
	<% } %>

</liferay-ui:panel-container>
</div>