<%@ include file="/html/init.jsp" %>

<div id="<portlet:namespace />playerArea">
	<liferay-util:include page="/html/videomarket/view_video_player.jsp"  servletContext="<%= getServletContext() %>" />
</div>

<div id="<portlet:namespace />videosListArea">
	<liferay-util:include page="/html/videomarket/view_video_list.jsp"  servletContext="<%= getServletContext() %>" />		
</div>