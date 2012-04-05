<%@ include file="/html/init.jsp" %>
<% 
	long videoId = Long.parseLong(String.valueOf(request.getAttribute("view_video_Id")));

	VideoExt videoExt = VideoExtLocalServiceUtil.getVideoExt(videoId);
%>

<portlet:renderURL var="viewVideoDetailURL">
	<portlet:param name="jspPage" value="/html/vrbt_purchase/purchase_view_video_detail.jsp"/>
	<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>"/>
</portlet:renderURL>

<div class="document-display-style display-icon selectable" data-draggable="<%= Boolean.TRUE.toString()%>" data-title="<%= videoExt.getVideoName() %>">
	<a class="document-link" data-folder="false" href="#" title="<%= videoExt.getVideoName() %>">
		<span class="document-thumbnail">
			
			
			<img alt="" border="no" src="#"  />

			<img alt="<liferay-ui:message key="shortcut" />" class="shortcut-icon" src="<%= themeDisplay.getPathThemeImages() %>/file_system/large/overlay_link.png">

		</span>
		<br/>
		<span class="entry-title">
				<span class="workflow-status-">
					<aui:a href="<%= viewVideoDetailURL %>" label="<%= videoExt.getVideoName() %>"/>
				</span>
			
		</span>
	</a>
</div>

