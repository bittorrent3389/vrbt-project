 <%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@ include file="/html/init.jsp" %>



 <%    com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog("videomarket.view_video_list.jsp"); %>
<% 


	PortletURL	videoIteratorURL  =  renderResponse.createRenderURL();
	//long categoryId = ParamUtil.getLong(renderRequest, "video-Category-Id",0);
	long categoryId = ParamUtil.getLong(renderRequest, "categoryId",0);
	
	List<VideoEntry> videoEntries = null;
	int videoTotal = 0;
	//VideoEntryLocalServiceUtil.getVideoEntries(searchContainer.getStart(), searchContainer.getEnd());
	long userId =  0 ;
	try{
		userId =PortalUtil.getUserId(request);
		videoTotal = VideoEntryLocalServiceUtil.searchVideoByCategory_OtherUser_Count(categoryId, userId, true);
		videoEntries = VideoEntryLocalServiceUtil.searchVideoByCategory_OtherUser(categoryId,userId, 0,videoTotal , true);		
	}catch(Exception e){_log.info(e);}	
	_log.info(categoryId);
	if(videoEntries==null){videoEntries =new  ArrayList<VideoEntry>();}
	Iterator<VideoEntry> iter = videoEntries.iterator();
	VideoEntry videoEntry=null;
%>
 
 <div id="mainContainer">
	<div class="title"> Videos </div>
    <!-- div#mainContainerWrapper-->
	<div id="mainContainerWrapper">
	
	<% while(iter.hasNext()){
		videoEntry = iter.next();
		%>
	<portlet:renderURL  var="videoItemURL"  windowState="<%= LiferayWindowState.NORMAL.toString()%>" > <!--  windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" -->
					<portlet:param name="categoryId" value="<%=String.valueOf(categoryId) %>" />
					<portlet:param name="videoId" value="<%=String.valueOf( videoEntry.getVideoId()) %>" />
					<%-- <portlet:param name="jspPage" value="/html/videomarket/videoArea.jsp" />--%>
	</portlet:renderURL>
				
	<!--  start div.entry-->
    	<div class="entry">
        	<div class="entryThumbnail" >
        	
			<a href="<%=videoItemURL.toString() %>" class="videoItem">
            	<img  src="<%= videoEntry.getLargeImageUrl() %>" alt="<%= videoEntry.getVideoName()%>"/>
            </a>
            </div> 
            <div class="entryText">
            	<div>
            	<span><%= videoEntry.getVideoName() %> </span> |
            	<span><%= videoEntry.getDescription() %> </span> |
            	<span><%= videoEntry.getViewCount() %> </span>
            	</div>
            	<div>
            		<span>Published on <%= videoEntry.getDate_().toString() %></span>
            	</div> 
            </div>  
            <div class="videoFuncBar">
            	 <div class="purchaseButton">
                    <a href="#">Purchase </a>
                </div>
                <div style="clear:both;"></div>
            </div>
         </div>
     <!--  end div.entry-->
     <% } %>
     
      <div style="clear:both;"></div>
    </div>
 <!--  end div#mainContainerWrapper-->

</div>

