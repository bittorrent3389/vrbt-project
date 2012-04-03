<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@page import="javax.portlet.PortletURL"%>
<portlet:defineObjects />
<theme:defineObjects/>

 
<%
long currFolderId = ParamUtil.getLong(renderRequest, "currFolderId",0); // ROOT_FOLDER_ID=0
//long folderId = ParamUtil.getLong(renderRequest, "folderId",0); // ROOT_FOLDER_ID=0
long folderId = 0;
	try{
		Long id = (Long)renderRequest.getAttribute("folderId");
		folderId = id.longValue();
	}
	catch(Exception e){e.printStackTrace();}
PortletURL  redirectURL = 	PortletURLUtil.getCurrent(renderRequest, renderResponse);
String redirect = redirectURL.toString();
%>

<liferay-util:buffer var="iconMenu">

<liferay-ui:icon-menu align="auto" direction="down" 
 message="<%= StringPool.BLANK %>"
 icon=""  
showWhenSingleIcon="<%= false%>">
<%-- add subfolder --%>

		<portlet:renderURL var="addSubFolderURL" >
			<portlet:param name="currFolderId" value="<%= String.valueOf(folderId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="jspPage" value="/html/videoadminportlet/add_subfolder.jsp" />
		</portlet:renderURL>	

		<liferay-ui:icon
			image="add_folder"
			message="add-subfolder"
			url="<%= addSubFolderURL %>"
		/>
<%-- edit  --%>

		<portlet:renderURL var="editFolderURL" >
			<portlet:param name="currFolderId" value="<%= String.valueOf(currFolderId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
			<portlet:param name="jspPage" value="/html/videoadminportlet/rename_folder.jsp" />
		</portlet:renderURL>	

		<liferay-ui:icon
			image="edit"
			message="rename"
			url="<%= editFolderURL %>"
		/>

 <%-- del  --%>
 
		<portlet:actionURL var="delFolderURL" name="deleteFolder">
			<portlet:param name="currFolderId" value="<%= String.valueOf(currFolderId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>	

		<liferay-ui:icon
			image="delete"
			url="<%= delFolderURL %>"
		/>
</liferay-ui:icon-menu>

</liferay-util:buffer>

<div class="videoAdminPortlet">
<%= iconMenu %>

</div>