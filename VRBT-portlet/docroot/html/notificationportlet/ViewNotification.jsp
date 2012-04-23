<%@page import="vn.com.fis.portal.VRBTLibrary"%>
<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />
<portlet:actionURL var="ReadNotification" name="readNotification">
	
</portlet:actionURL>
<%
	long userId=user.getUserId();
	VRBTLibrary vrbtLibrary = new VRBTLibrary();
	//--------------------------check login and permission------------------------------
	if(!vrbtLibrary.checkLogin(userId,renderRequest, "Subscriber#Third-party").equals("Success"))
	{
		out.println(vrbtLibrary.checkLogin(userId,renderRequest, "Subscriber#Third-party"));
		return;
	}
	//----------------------------------------------------------------------------------
		long notificationId = Integer.parseInt(renderRequest.getParameter("notificationId"));
		NotificationEntry notificationEntry = NotificationEntryLocalServiceUtil.getNotificationEntry(notificationId);
		if(notificationEntry.getStatus() == 0)
		{
			notificationEntry.setStatus(1);
			NotificationEntryLocalServiceUtil.updateNotificationEntry(notificationEntry);
		}
%>

<div style="background-color: black;color: red;font-weight: bold;font-size: 15px;margin-bottom: 20px;margin-top:20px; text-align: center">This is the <b>Notification</b> portlet in View mode.</div>
<portlet:actionURL var="editVideoURL" name="editVideo">
	
</portlet:actionURL>
<div>
<liferay-ui:error key="video_exception" message="video_exception" />
</div>
<aui:form action="<%= editVideoURL.toString() %>" method="post" inlineLabels="true">
	<aui:input name="UserFrom" label="UserFrom-label" title="UserFrom-label"  value="<%= UserEntryLocalServiceUtil.getUserEntry(notificationEntry.getUserIdFrom()).getUserName()%>" disabled="true"/>
	<aui:input name="UserTo" label="UserTo-label" title="UserTo-label"  value="<%= UserEntryLocalServiceUtil.getUserEntry(notificationEntry.getUserIdTo()).getUserName()%>" disabled="true"/>
	<aui:input name="Subject" label="Subject-label" title="Subject-label"  value="<%= notificationEntry.getSubject()%>" disabled="true"/>
	<aui:input name="Message" label="CreateDate-label" title="CreatePDate-label"  value="<%= notificationEntry.getCreateDate()%>" disabled="true"/>
	<aui:input name="Message" label="Message-label" title="Message-label"  value="<%= notificationEntry.getMessage()%>" disabled="true"/>
	
</aui:form>