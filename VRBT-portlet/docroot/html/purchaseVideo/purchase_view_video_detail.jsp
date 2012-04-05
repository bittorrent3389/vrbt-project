<%@ include file="/html/init.jsp" %>
<%
	//long videoId = ParamUtil.getLong(renderRequest, "videoId");
	long videoId = ParamUtil.getLong(renderRequest, "video-Id", 0);
%>

<c:if test="<%= videoId != 0 %>">
	<%
		VideoEntry videoExt = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
	
		boolean isAllow = false;
		boolean isLike = false;
		boolean isUnlike = false;
		boolean isBuy = false;
		
		long userId = permissionChecker.getUserId();
		long companyid = PortalUtil.getCompanyId(renderRequest);
		
		try{
			long roleId = RoleLocalServiceUtil.getRole(companyid, "Subscriber").getRoleId();
			
			if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
				isAllow = true;
			
		}catch(Exception e){
			isAllow = false;
		}
		
		List<VideoUserEntry> listVideo = VideoUserEntryLocalServiceUtil.findByUserId_VideoId_Status(userId, videoId, 1);
		if(listVideo.size() > 0)
			isBuy = true;
	
		try {
			UserEntry userEntry = UserEntryLocalServiceUtil.getUserEntry(userId);
			List<RatingEntry> listRate = RatingEntryLocalServiceUtil.findByvideoId_userId_status(videoId, userEntry.getUserId(), 1);
			
			if(listRate.size() > 0){
				RatingEntry ratingExt = listRate.get(0);
		
				if(ratingExt.getRatingCode() == 1)
					isLike = true;
				else
					if(ratingExt.getRatingCode() == 2)
						isUnlike = true;
			}
		}catch(Exception e){
			isLike = false;
			isUnlike = false;
		}
	
		List<RatingEntry> listLike = RatingEntryLocalServiceUtil.findByvideoId_ratingCode_status(videoId, 1, 1);
		List<RatingEntry> listUnlike = RatingEntryLocalServiceUtil.findByvideoId_ratingCode_status(videoId, 2, 1);
	
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
		<portlet:param name="jspPage" value="/html/vrbt_purchase/purchase_transaction_detail.jsp"/>
		<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
		<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
		<portlet:param name="redirect" value="<%= redirectURL.toString() %>"/>
	</portlet:renderURL>

	<portlet:renderURL var="videoReportURL">
		<portlet:param name="jspPage" value="/html/vrbt_purchase/video_notifiaction.jsp"/>
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

	<fieldset>
		<liferay-ui:panel-container >
		<liferay-ui:panel title="More" >
			<!-- video infor-->
			<aui:fieldset>
			 	<aui:column>
					<h4><%= videoExt.getVideoName() %>" </h4>
					<br/>
					<div>Size <%= String.valueOf(videoExt.getSize()) %>" </div>
					<div><%=   videoExt.getDescription() %>" </div>
				</aui:column>
			</aui:fieldset>
		</liferay-ui:panel>
		</liferay-ui:panel-container>
		
		<hr/>
	
		<aui:fieldset>
			<aui:column>
				<aui:button-row>
					<aui:button type="button" name="btBuy" value="Buy VRBT" href="<%= videoTransactionURL %>" 
						disabled="<%= !isAllow %>"/>
					<aui:button type="button" name="btReport" value="Report" href="<%= videoReportURL %>"
						disabled="<%= !isAllow %>"/>
					<aui:button type="button" name="like" value="Like it" onClick="<%= likeVideoURL %>" 
						disabled='<%= isLike || !isAllow %>'/>
					<aui:button type="button" name="unlike" value="Unlike" onClick="<%= unlikeVideoURL %>" 
						disabled='<%= isUnlike || !isAllow %>'/>				
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
	
		<c:if test="<%= !isAllow %>">
			<liferay-ui:message key="Log in to buy video ringback tone."/>
		</c:if>
		<c:if test='<%= isBuy && isAllow %>'>
			<liferay-ui:message key="You have already bought this video."/>
		</c:if>
	</fieldset>
</c:if>


