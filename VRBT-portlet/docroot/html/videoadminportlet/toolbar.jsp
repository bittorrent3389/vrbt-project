<%@page import="vn.com.fis.portal.util.VideoAdminPortletUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<portlet:defineObjects />
<theme:defineObjects/>


<%
long currFolderId = ParamUtil.getLong(renderRequest, "currFolderId",0); // ROOT_FOLDER_ID=0
String toolbarItem = ParamUtil.getString(request, "toolbarItem", "HOME");
String redirectURL = PortalUtil.getCurrentURL(renderRequest);
long userId = PortalUtil.getUserId(request);
%>

<portlet:renderURL var="viewAllUrl">
		<portlet:param name="toolbarItem" value="HOME"></portlet:param>
		<portlet:param name="redirectURL" value="<%=redirectURL %>"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="addSubFolder">
		<portlet:param name="toolbarItem" value="addSubFolder"></portlet:param>
		<portlet:param name="redirectURL" value="<%=redirectURL %>"></portlet:param>
		<portlet:param name="jspPage" value="/html/videoadminportlet/add_subfolder.jsp"></portlet:param>
		<portlet:param name="currFolderId" value="<%=String.valueOf(currFolderId) %>" />
		<portlet:param name="folderId" value="<%=String.valueOf(currFolderId) %>" />
</portlet:renderURL>


<div class="lfr-portlet-toolbar">
	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("HOME") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewAllUrl %>"><liferay-ui:message key="HOME"/></a>
	</span>
	
	
	<liferay-ui:icon-menu   align="left" cssClass='<%= "lfr-toolbar-button add-button " + (toolbarItem.equals("add") ? "current" : StringPool.BLANK) %>'
							 direction="down" extended="<%= false %>" icon='<%= themeDisplay.getPathThemeImages() + "/common/add.png" %>'  message="add">
			<liferay-ui:icon
				image="add_folder"
				label="true"
				message="add-subfolder"
				toolTip="addUrl"
				url="<%= addSubFolder.toString() %>"/>
 	
	 	<portlet:renderURL var="addVideo">
			<portlet:param name="toolbarItem" value="uploadVideo"></portlet:param>
			<portlet:param name="redirectURL" value="<%=redirectURL %>"></portlet:param>
			<portlet:param name="jspPage" value="/html/videoadminportlet/upload_video.jsp"></portlet:param>
			<portlet:param name="currFolderId" value="<%=String.valueOf(currFolderId) %>" />
		</portlet:renderURL>
	 	
	 	<liferay-ui:icon
					image="add_article"
					label="true"
					message="add-video"
					toolTip="upload video"
					url="<%= addVideo.toString() %>"/> 
		</liferay-ui:icon-menu>
	
	</span>
	
	
</div>

