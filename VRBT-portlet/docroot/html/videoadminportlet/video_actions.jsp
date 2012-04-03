<%@page import="vn.com.fis.portal.model.VideoEntry"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
VideoEntry videoEntry = (VideoEntry) row.getObject();

long videoId = videoEntry.getVideoId();
PortletURL  redirectURL = 	PortletURLUtil.getCurrent(renderRequest, renderResponse);
String redirect = redirectURL.toString();
%>


<liferay-ui:icon-menu align="auto" direction="down" >
<%-- add subfolder --%>

		<portlet:actionURL var="delVideoURL" name="deleteMyUploadVideo">
			<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			image="delete"
			message="delete"
			url="<%= delVideoURL %>"
		/>
<%-- edit  --%>

		<portlet:renderURL var="editVideoURL" >
			<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="jspPage" value="/html/videoadminportlet/edit_video.jsp" />
		</portlet:renderURL>	

		<liferay-ui:icon
			image="edit"
			message="edit"
			url="<%= editVideoURL %>"
		/>
 
</liferay-ui:icon-menu>



