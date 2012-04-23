<%@ include file="/html/init.jsp" %>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" >
<!--

//-->
</script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js">
<!--

//-->
</script>

<script type="text/javascript">
function <portlet:namespace/>loadVideosByCategory(urlParam) {
	    jQuery.ajax({
	    type: "GET",
	    url: urlParam,
	    dataType: 'html',
	    success: function(result) {
	    	videoContainerArea = document.getElementById("<portlet:namespace/>videoContainerArea");
	    	videoContainerArea.innerHTML = "";
	    	videoContainerArea.innerHTML = result;
	        }
	    });
}

jQuery(document).ready(function(){
	jQuery("a.categoryItem").click(function(e){
		e.preventDefault();
		url =	jQuery(this).attr("href");
		 <portlet:namespace />loadVideosByCategory(url);
	});
});
</script>



<div>
	<div style="width: 20%;height: auto;float: left;">
		<liferay-util:include page="/html/videomarket/view_category.jsp" servletContext="<%=getServletContext()   %>" />
	</div>
	<div style="width: 80%; height: auto;float: left;">
		<div id="<portlet:namespace />videoContainerArea">
			<liferay-util:include page="/html/videomarket/videoArea.jsp" servletContext="<%=getServletContext()   %>" />
		</div>
	</div>
	<div style="clear: both;"></div>	
</div>


<script type="text/javascript">
	function <portlet:namespace/>playVideo(urlParam) {
	    jQuery.ajax({
	    type: "GET",
	    url: urlParam,
	    dataType:'html',
	    success: function(result) {
	        videoContainerArea = document.getElementById("<portlet:namespace/>videoContainerArea");
	        videoContainerArea.innerHTML = "";
	        videoContainerArea.innerHTML = result;
	        }
	    });
}

jQuery(document).ready(function(){
	jQuery("##a.videoItem").click(function(e){
		e.preventDefault();
		urlVideo =	jQuery(this).attr("href");
		 <portlet:namespace />playVideo(urlVideo);
	});
});
</script>