<%@page import="vn.com.fis.portal.util.VideoAdminPortletUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil"%>
<%@page import="vn.com.fis.portal.model.VideoUserEntry"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<portlet:defineObjects />
<theme:defineObjects/>
 
<%

//long folderId = ParamUtil.getLong(renderRequest, "folderId",0); // ROOT_FOLDER_ID=0
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
VideoEntry videoEntry = (VideoEntry) row.getObject();
long userId = PortalUtil.getUserId(request);
int serviceActive = -1;
	try{
	Integer obj= (Integer)request.getAttribute("serviceActive");
	serviceActive = obj.intValue();
	}catch(Exception e){}

long videoId = 0;

 VideoUserEntry  videoUserEntry =null;
 
PortletURL  redirectURL = 	PortletURLUtil.getCurrent(renderRequest, renderResponse);
String redirect = redirectURL.toString();
%>

		<% 
			
							try{
								videoId=  videoEntry.getVideoId();
//								videoUserEntry =  VideoUserEntryLocalServiceUtil.findByVideoId_UserId(videoId, PortalUtil.getUserId(request));
								//videoUserEntry =  VideoUserEntryLocalServiceUtil.findByUserId_VideoId(PortalUtil.getUserId(request), videoId);
								
								//serviceActive = videoUserEntry.getServiceActive();
							}catch(Exception e){}
						%>
						
						
<liferay-ui:icon-menu align="auto" direction="down" >
<%-- add subfolder --%>

		<portlet:actionURL var="delVideoURL" name="deleteMyVideo">
			<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			image="delete"
			message="delete"
			url="<%= delVideoURL %>"
		/>
		
<c:if  test='<%= VideoAdminPortletUtil.hasRole(userId,PortalUtil.getCompanyId(request), "Subscriber") %>'>
<%-- send to my friend--%>

		<portlet:renderURL var="sendFriend"  windowState="<%= WindowState.MAXIMIZED.toString() %>">
			<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="jspPage" value="/html/myvideoportlet/send_friend.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon
			image="assign"
			message="sendToFriend"
			url="<%= sendFriend %>"
		/>


<% 
/* 	Integer  obj = null;
		try{
			obj = (Integer)renderRequest.getAttribute("serviceActive");
		  	if(obj!=null)
		  	serviceActive = obj.intValue();
		}catch(Exception e){} */
%>
<%-- active_service  --%>
		<portlet:actionURL var="serviceActiveURL"  name="serviceActive">
			<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<c:if test="<%= (serviceActive==1) %>">
				<portlet:param name="inactiveService" value="true" />
			</c:if>
		</portlet:actionURL>	


		<c:if test="<%= serviceActive==1%>">
			<liferay-ui:icon
				image="services"
				message="service-inactive"
				url="<%= serviceActiveURL %>" 
		/>
		</c:if>
		<c:if test="<%= serviceActive !=1 %>">
			<liferay-ui:icon
				image="services"
				message="service-active"
				url="<%= serviceActiveURL %>"/>
		</c:if>
</c:if>
</liferay-ui:icon-menu>



