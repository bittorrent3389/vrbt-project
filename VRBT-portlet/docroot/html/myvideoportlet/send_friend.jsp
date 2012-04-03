<%@page import="com.liferay.portal.util.PortalUtil"%>
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
	long videoId =  ParamUtil.getLong(renderRequest, "videoId",0);

	PortletURL  redirectURL = 	PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String redirect = redirectURL.toString();	
	//String redirect = ParamUtil.getString(renderRequest, "redirect");
%>

<portlet:actionURL var="sendToFriendURL" name="sendToFriend">
		<portlet:param name="videoId" value="<%=String.valueOf(videoId) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<liferay-ui:header title="send-friend-header" backURL="<%= redirect %>" />

<aui:form action="<%= sendToFriendURL %>" method="post" name="sendToFriendForm" >
	<div class="message-alert">
	</div>	 
	<aui:input   name="receiverMobileNumber" size="30" type="text" value="" label="mobile-number-label" />
	<aui:button-row>
		<aui:button type="submit" value="send" />
	</aui:button-row>
</aui:form>

<div class="separator"><!-- --></div>



<aui:script>
				if (document.<portlet:namespace />sendToFriendForm.<portlet:namespace />receiverMobileNumber) {
					Liferay.Util.focusFormField(document.<portlet:namespace />sendToFriendForm.<portlet:namespace />receiverMobileNumber);
				}
</aui:script>

