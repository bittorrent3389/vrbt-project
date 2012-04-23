<%@ include file="/html/init.jsp" %>


<%
	//long videoId = ParamUtil.getLong(renderRequest, "videoId");
	long videoId = ParamUtil.getLong(renderRequest, "videoId", 0);
%>

<c:if test="<%= videoId != 0 %>">
	<%
		VideoEntry videoExt = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
	
		long userId = permissionChecker.getUserId();
	
		boolean isLike = false;
		boolean isUnlike = false;
		boolean isBuy = false;
	
		List<VideoUserEntry> listVideo = VideoUserEntryLocalServiceUtil.findByUserId_VideoId_Status(userId, videoId, 1);
		if(listVideo.size() > 0)
			isBuy = true;
	
		try {
			UserEntry userExt = UserEntryLocalServiceUtil.getUserEntry(userId);
			List<RatingEntry> listRate = RatingEntryLocalServiceUtil.findByVideoId_UserId(videoId, userExt.getUserId());
			
			if(listRate.size() > 0){
				RatingEntry ratingExt = listRate.get(0);
		
				if(ratingExt.getCode() == 1)
					isLike = true;
				else
					if(ratingExt.getCode() == 2)
						isUnlike = true;
			}
		}catch(Exception e){
			isLike = false;
			isUnlike = false;
		}
	
		List<RatingEntry> listLike = RatingEntryLocalServiceUtil.findByVideoId_Code(videoId, 1);
		List<RatingEntry> listUnlike = RatingEntryLocalServiceUtil.findByVideoId_Code(videoId, 2);
	
		long totalLike = 0;
		if(listLike.size() > 0)
			totalLike = listLike.size();
	
		long totalUnlike = 0;
		if(listUnlike.size() > 0)
			totalUnlike = listUnlike.size();
	
		long totalRate = 0;
		if(totalLike != 0 ||totalUnlike != 0)
			totalRate = ((totalLike/(totalLike + totalUnlike)) * 100) / 20;
		totalRate = Math.round(totalRate);
		
		PortletURL redirectURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	%>

	<portlet:renderURL var="videoTransactionURL">
		<portlet:param name="jspPage" value="/html/videomarket/purchase_transaction_detail.jsp"/>
		<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
		<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
		<portlet:param name="redirect" value="<%= redirectURL.toString() %>"/>
	</portlet:renderURL>

	<portlet:renderURL var="videoReportURL">
		<portlet:param name="jspPage" value="/html/videomarket/video_notifiaction.jsp"/>
		<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
		<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
		<portlet:param name="redirect" value="<%= redirectURL.toString() %>"/>
	</portlet:renderURL>

	<portlet:actionURL var="likeVideoURL" name="videoRating">
		<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
		<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
		<portlet:param name="rate" value="1"/>
		<portlet:param name="redirect" value="<%= redirectURL.toString() %>"/>
	</portlet:actionURL>

	<portlet:actionURL var="unlikeVideoURL" name="videoRating">
		<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
		<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
		<portlet:param name="rate" value="2"/>
		<portlet:param name="redirect" value="<%= redirectURL.toString() %>"/>
	</portlet:actionURL>

	<liferay-ui:error key="error-message" message="You must log in to buy video ringback tone."/>
	<aui:fieldset>
			<aui:column>
				<aui:button-row>
					<aui:button type="button" name="btBuy" value="Buy VRBT" href="<%= videoTransactionURL %>"  />
					<aui:button type="button" name="btReport" value="Report" href="<%= videoReportURL %>"/>
					<aui:button type="button" name="like" value="Like it" onClick="<%= likeVideoURL %>" 
						disabled="<%= isLike %>"/>
					<aui:button type="button" name="unlike" value="Unlike" onClick="<%= unlikeVideoURL %>" 
						disabled="<%= isUnlike %>"/>				
				</aui:button-row>
			</aui:column>
		
			<aui:column>
				<br/>
				<liferay-ui:ratings-score score="<%= totalRate %>"/>
			</aui:column>
		
			<aui:column>
				<br/>
				<liferay-ui:message key='<%= totalLike + " like, " + totalUnlike + " unlike" %>'/>
			</aui:column>
		</aui:fieldset>
	
		<c:if test="<%= isBuy %>">
			<liferay-ui:message key="You have already bought this video."/>
		</c:if>
	</fieldset>
</c:if>


