<%@page import="vn.com.fis.portal.model.VideoEntry"%>
<%@page import="vn.com.fis.portal.service.VideoEntryLocalServiceUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/util"  prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<portlet:defineObjects/>
<theme:defineObjects/>


<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.com.fis.portal.service.FolderEntryLocalServiceUtil"%>
<%@page import="vn.com.fis.portal.model.FolderEntry"%>
<%@page import="java.util.List"%>
<% 
	
	long currFolderId = ParamUtil.getLong(renderRequest, "currFolderId",0); // ROOT_FOLDER_ID=0
	FolderEntry folderEntry = null;
	long userId =0;
	
	
	try{
		userId= user.getUserId();
		if(currFolderId>0)
			folderEntry = FolderEntryLocalServiceUtil.getFolderEntry(currFolderId);
		
	}catch(Exception e){e.printStackTrace();}
	
%>
	<div>
			<%-- up to parent folder --%>
<%-- 			<% //if(  folderEntry !=null ){ %>
			 	<b> select a folder </b>
			<% //} %> --%>
	</div>


<% 
PortletURL	videoIteratorURL  =  renderResponse.createRenderURL();

%>
 
<liferay-ui:search-container 
				emptyResultsMessage="there-are-no-videos"
				iteratorURL="<%= videoIteratorURL %>">
			<liferay-ui:search-container-results results="<%= VideoEntryLocalServiceUtil.searchVideoByVideoName_Folder_User(null, currFolderId, userId, searchContainer.getStart(), searchContainer.getEnd()) %>"
					total="<%=  VideoEntryLocalServiceUtil.searchVideoByVideoName_Folder_User_Count(null, currFolderId, userId)%>"/>
	<liferay-ui:search-container-row 
					className="vn.com.fis.portal.model.VideoEntry"
					keyProperty="videoId"
					modelVar="videoEntry">
		<liferay-ui:search-container-column-text
				align="left">
					<portlet:renderURL var="videoURL" copyCurrentRenderParameters="<%= true %>">
							<portlet:param name="videoId" value="<%=String.valueOf( videoEntry.getVideoId()) %>"></portlet:param>
							<portlet:param name="video-Id" value="<%=String.valueOf( videoEntry.getVideoId()) %>"></portlet:param>
					</portlet:renderURL>
					<span>
					<aui:a href="<%=videoURL%>">
						<img  alt="" src="<%= videoEntry.getSmallImageUrl() %>"  />
					</aui:a>
					</span>
				
		</liferay-ui:search-container-column-text>	
		<liferay-ui:search-container-column-text align="left">
					<span >
						<div> <h4><%= videoEntry.getVideoName() %> </h4></div>
						<div><%= videoEntry.getDescription()%> </div>
						<div>  <span> 0 views</span></div>
						<div><%= String.valueOf(videoEntry.getUserId()) %>  <span>uploaded</span></div>
					</span>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/html/videoadminportlet/video_actions.jsp" />
	</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />			
</liferay-ui:search-container>
