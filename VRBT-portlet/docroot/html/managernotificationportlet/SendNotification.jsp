<%@page import="vn.com.fis.portal.VRBTLibrary"%>
<%@ include file="/html/init.jsp" %>

<portlet:defineObjects />

<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<theme:defineObjects/>

<%
	long userId=user.getUserId();
	VRBTLibrary vrbtLibrary = new VRBTLibrary();
	//--------------------------check login and permission------------------------------
	if(!vrbtLibrary.checkLogin(userId,renderRequest, "Network-Operator").equals("Success"))
	{
		out.println(vrbtLibrary.checkLogin(userId,renderRequest, "Third-party"));
		return;
	}
	//----------------------------------------------------------------------------------
	
%>

<div style="font-size: 20px;text-align: center;margin-bottom:5px;margin-top:5px">
Send Notification
</div>
<portlet:actionURL var="SendNotification" name="sendNotification">
</portlet:actionURL>
<div>
<%@ include file="/html/messagevalidate.jsp" %>
</div>
<aui:form action="<%= SendNotification.toString() %>" method="post" inlineLabels="true">
	<input type="text" name="UserIdFrom"  value="<%= userId%>" hidden="true"/>
	<aui:input name="UserTo" label="UserTo-label" title="UserTo-label"  value=""/>
	<aui:input name="Subject" label="Subject-label" title="Subject-label"  value=""/>
	<aui:input name="Message" label="Message-label" title="Message-label"  value=""/>
	
	<aui:button-row>
		<aui:button type="submit" value="submit-button" />
	</aui:button-row>
	
</aui:form>