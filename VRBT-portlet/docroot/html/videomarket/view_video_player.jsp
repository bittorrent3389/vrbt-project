<%@page import="vn.com.fis.portal.util.VideoAdminPortletUtil"%>
<%@ include file="/html/init.jsp" %>

<% 
		 
	long videoId = ParamUtil.getLong(renderRequest, "videoId",0);
	
	String videoURL = "";
	String smallImageUrl = "";
	VideoEntry videoEntry =null;
	String path = "";
	try{
		videoEntry = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
		path =  videoEntry.getVideoUrl();
		videoURL = path;
		//videoURL = PortalUtil.getPortalWebDir() + path;
		
		smallImageUrl = videoEntry.getSmallImageUrl();
		videoURL = PortalUtil.getPortalURL(themeDisplay) + StringPool.SLASH+path;
		
		//themeDisplay.getPortalURL() + themeDisplay.getPathContext()
		//videoURL = themeDisplay.getPortalURL() + themeDisplay.getPathContext()+ StringPool.SLASH +path;
		
	}catch(Exception e){System.out.println("exception:"+ e.getMessage());}
	 
%>

<c:if test="<%=videoEntry!=null%>" >

<aui:layout >
	<aui:column columnWidth="100" >
		<!-- START OF THE PLAYER EMBEDDING TO COPY-PASTE -->
	 
	<div id="<portlet:namespace />mediaplayer">THE PLAYER EMBEDDING </div>
	<%-- <div> 
	<liferay-ui:icon image="like"   message="I like this"  id="<portlet:namespace/>like"  onClick="alert('like')"/>
	<liferay-ui:icon image="dislike" message="I dislike this" id="<portlet:namespace/>dislike"/>
	<liferay-ui:icon image="warning"  message="report " id="<portlet:namespace/>warning"/>	
	</div> --%>
	
	<!-- <script type="text/javascript" src="/html/videolistdisplay/jwplayer/jwplayer.js">
	</script> -->
	
	<script type="text/javascript">
		jwplayer("<portlet:namespace />mediaplayer").setup({
			flashplayer: "/VRBT-portlet/html/jwplayer/player.swf",
			file: "<%=videoURL%>",
			image: "<%= smallImageUrl%>",
			width: "100%",
			height: "350px"
		});
	</script>
	<!-- END OF THE PLAYER EMBEDDING -->
	<%-- 
	<liferay-ui:panel-container >
	<liferay-ui:panel title="More" >
			<!-- vide infor-->
			<h5> <%= videoEntry.getVideoName() %></h5>
			<div><%= videoEntry.getDescription() %></div>
			<div> <span>uploaded by </span><%= videoEntry.getUserId() %> on 1/3/2012 </div>
			<div> 100 views </div>
	</liferay-ui:panel>
	
	</liferay-ui:panel-container> --%>
	</aui:column>
</aui:layout>



<%--  Function bar  --%>

<c:if  test='<%= VideoAdminPortletUtil.hasRole(PortalUtil.getUserId(request),PortalUtil.getCompanyId(request), "Subscriber") %>'>
<br/>

<div>
	<!-- <liferay-util:include page="/html/videomarket/purchase_view_video_detail.jsp"  servletContext="< getServletContext() %>" /> -->
</div>

</c:if>
<br/>

 


 <!--  ================================================================  -->
<div>
<style type="text/css">
/*	 rating bar */	

div#rating div.ratingBar{
		width:auto;
		margin:auto;
	}
div#rating  div.ratingBar div.ratingButton{
		float:left;
		width:auto;
	}
div#rating  div.ratingBar div.viewCount{
		float:right;
		width:auto;
	}
span.like {
		font-weight:400;
		font-size:16px;
		margin:0px 5px 0px 0px;
		background-color:#9742A7;
		text-shadow:#FFF;
	}
span.like:hover{
		cursor:pointer;
	}
span.dislike {
		font-weight:400;
		font-size:16px;
		margin:0px 5px 0px 5px;
		background-color:#9742A7;
		text-shadow:#FFF;
	}
span.dislike:hover{
		cursor:pointer;
		
	}
div.viewCount{
	font-size: 16px;
	font-weight: 400;
}
</style>


<!-- report popup  -->
<portlet:renderURL var="reportURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
  <portlet:param name="jspPage" value="/html/videomarket/video_notifiaction.jsp"/>
  <portlet:param name="videoId" value="<%= String.valueOf(videoEntry.getVideoId()) %>"/>
  <portlet:param name="userId" value="<%= String.valueOf(PortalUtil.getUserId(request)) %>"/>
</portlet:renderURL>
<%-- purchase --%>
<portlet:renderURL var="purchaseURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
  <portlet:param name="jspPage" value="/html/videomarket/video_purchase.jsp"/>
  <portlet:param name="videoId" value="<%= String.valueOf(videoEntry.getVideoId()) %>"/>
  
  
</portlet:renderURL>

<aui:script>
function showReportPopup() {
  AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
   
    var dialog = new A.Dialog({
            title: 'Video report',
            centered: true,
            draggable: true,
            modal: true,
            width: 200,
            height: 200

        }).plug(A.Plugin.IO, {uri: '<%= reportURL.toString() %>'}).render();
       
        dialog.show();
       
  });
}

function purchasePopup() {
  AUI().use('aui-dialog', 'aui-io', 'event', 'event-custom', function(A) {
   
    var dialog = new A.Dialog({
            title: 'Video report',
            centered: true,
            draggable: true,
            modal: true,
            width: 400,
            height: 300

        }).plug(A.Plugin.IO, {uri: '<%= purchaseURL.toString() %>'}).render();
       
        dialog.show();
       
  });
}


</aui:script>
 



<div id="rating">
<div class="ratingBar">
                	<div class="ratingButton" >
                    	<button >Like 1010</button>
						<button >Dislike 1010</button>
                        <button  onclick="showReportPopup();">Report</button>
                         <button  onclick="purchasePopup();">Purchase</button>
</div><!-- end div.ratingButton-->
                    <div class="viewCount">
                    	<%= videoEntry.getViewCount() %> views 
                    </div>
                    <div style="clear:both;">
</div><!-- end div.viewCount-->
             </div><!-- end div.ratingBar-->
        </div>
</div>
<!--  ================================================================  -->

<%--  more information  --%>
<br/>
<aui:layout>
		<liferay-ui:panel-container >
		<liferay-ui:panel title="More" >
			<!-- video infor-->
				<aui:layout>
					<h4><%= videoEntry.getVideoName() %>" </h4>
					<br/>
					<div><%=   videoEntry.getDescription() %>" </div>
				</aui:layout>
		</liferay-ui:panel>
		</liferay-ui:panel-container>
</aui:layout>
<br/>
</c:if>





 