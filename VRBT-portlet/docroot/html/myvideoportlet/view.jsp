<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="vn.com.fis.portal.util.VideoAdminPortletUtil"%>
<%@page import="vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil"%>
<%@page import="vn.com.fis.portal.model.VideoUserEntry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.com.fis.portal.model.VideoEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.com.fis.portal.service.VideoEntryLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/util"  prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<portlet:defineObjects/>
<theme:defineObjects/>

<% 
long userId =0;
long videoId=0;
VideoUserEntry videoUserEntry=null; 
	try{
		userId = user.getUserId();
	}catch(Exception e){}
	
PortletURL	videoIteratorURL  =  renderResponse.createRenderURL();
long categoryId = ParamUtil.getLong(renderRequest, "video-Category-Id",0);
List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
int videoTotal = 0;

// param 
String videoName = ParamUtil.getString(renderRequest, "videoName",null);
int originCode = ParamUtil.getInteger(renderRequest, "originCode",-1);
int serviceActive = ParamUtil.getInteger(renderRequest, "serviceActive",-1);

//VideoEntryLocalServiceUtil.getVideoEntries(searchContainer.getStart(), searchContainer.getEnd());

%>

 
<liferay-util:include page="/html/myvideoportlet/search_form.jsp" servletContext="<%= getServletContext() %>" />

 
<liferay-ui:search-container delta="5"  
				emptyResultsMessage="there-are-no-videos"
				iteratorURL="<%= videoIteratorURL %>">
	<liferay-ui:search-container-results 
					results="<%= VideoEntryLocalServiceUtil.searchVideoByVideoName_OriginCode_ServiceActive(videoName, originCode
							, serviceActive, userId, searchContainer.getStart(), searchContainer.getEnd())  %>"
					total="<%=  VideoEntryLocalServiceUtil.searchVideoByVideoName_OriginCode_ServiceActive_Count(videoName, originCode, serviceActive, userId) %>"/>
	
	<liferay-ui:search-container-row   
					className="vn.com.fis.portal.model.VideoEntry"
					keyProperty="videoId"
					modelVar="videoEntry">
				
					
		
		<liferay-ui:search-container-column-text  name="preview"
				align="left">
					<portlet:renderURL var="videoURL" >
							<portlet:param name="videoId" value="<%=String.valueOf( videoEntry.getVideoId()) %>"></portlet:param>
							<portlet:param name="video-Id" value="<%=String.valueOf( videoEntry.getVideoId()) %>"></portlet:param>
					</portlet:renderURL>
					<span>
					<aui:a href="<%=videoURL%>">
						<img  alt="" src="<%= videoEntry.getSmallImageUrl() %>"  />
					</aui:a>
					</span>
				
		</liferay-ui:search-container-column-text>	
		<liferay-ui:search-container-column-text align="left" name="summary">
					<span >
						<div> <h4><%= videoEntry.getVideoName() %> </h4></div>
						<div><%= videoEntry.getDescription()%> </div>
						<div>  <span> 0 views</span></div>
						<div><%= String.valueOf(videoEntry.getUserId()) %>  <span>uploaded</span></div>
					</span>
				</liferay-ui:search-container-column-text>
				
<c:if  test='<%= VideoAdminPortletUtil.hasRole(userId,PortalUtil.getCompanyId(request), "Subscriber") %>'>
		<liferay-ui:search-container-column-text align="center" name="service-active">
						<% 
							videoId = videoEntry.getVideoId();
							try{
								videoUserEntry =  VideoUserEntryLocalServiceUtil.findByVideoId_UserId(videoId, userId);
							}catch(Exception e){}
						%>
						
						<c:if test="<%= videoUserEntry!=null %>">
								<c:if test="<%= videoUserEntry.getServiceActive()==1 %>">
										<liferay-ui:icon 
											image="services"
											message="serviceActive"
										/>
										
								</c:if>
						</c:if>
		</liferay-ui:search-container-column-text>
</c:if>
		<liferay-ui:search-container-column-jsp path="/html/myvideoportlet/video_actions.jsp"  align="center"  name="actions" >
		
		</liferay-ui:search-container-column-jsp>
		
		
	</liferay-ui:search-container-row>
	
	
		<liferay-ui:search-iterator />			
</liferay-ui:search-container>


