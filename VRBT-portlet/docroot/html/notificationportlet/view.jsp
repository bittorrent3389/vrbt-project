<%@page import="vn.com.fis.portal.VRBTLibrary"%>
<%@ include file="/html/init.jsp" %>
<%
	String typeNotification="";
	//System.out.println(renderRequest.getParameter("typeNotification")+"");
	typeNotification=renderRequest.getParameter("typeNotification")+"";
	long userId=user.getUserId();
	VRBTLibrary vrbtLibrary = new VRBTLibrary();
	//--------------------------check login and permission------------------------------
		if(!vrbtLibrary.checkLogin(userId,renderRequest, "Subscriber#Third-party").equals("Success"))
		{
			out.println(vrbtLibrary.checkLogin(userId,renderRequest, "Subscriber#Third-party"));
			return;
		}
		//----------------------------------------------------------------------------------
	typeNotification="NOTIFICATIONUSERIDTO";
	
	//System.out.println("delta:"+renderRequest.getParameter("typeNotification")+"");
	String pageRecord=renderRequest.getParameter("delta")+"";
	if(pageRecord.equals("null"))
	{
		pageRecord="20";
	}
	if((userId+"").equals("null"))
	{
		userId=0;		
	}
	String pageIndex=renderRequest.getParameter("cur")+"";
	if(pageIndex.equals("null"))
	{
		pageIndex="1";
	}
	int endRow=Integer.parseInt(pageIndex) * Integer.parseInt(pageRecord);
%>

<div class="fontTitleForm">
		This is the Notify portlet in notify mode....
	</div>
<div>
<liferay-ui:success key="notification-Success" message="notification"/>
</div>

<liferay-ui:search-container delta="<%= Integer.parseInt(pageRecord) %>" emptyResultsMessage="No record were found">
	<liferay-ui:search-container-results 
		results="<%= NotificationEntryLocalServiceUtil.getNotificationEntryByUserId(userId,typeNotification, endRow - Integer.parseInt(pageRecord), endRow)%>"
		total="<%= NotificationEntryLocalServiceUtil.getNotificationEntryByUserIdCount(userId,typeNotification)%>">
	</liferay-ui:search-container-results>
	
	<hr/>
	
	<div style="background-color: black;height: 20px;">
		<span id='spanInbox' style="background-color:red;color: white;" >InBox</span>
		
	</div>
	<liferay-ui:search-container-row className="vn.com.fis.portal.model.NotificationEntry" keyProperty="notificationId" modelVar="notificationEntry">
		<liferay-ui:search-container-column-text name="getUserFrom" value="<%= UserEntryLocalServiceUtil.getUserEntry(notificationEntry.getUserIdFrom()).getUserName() %>"/>
		<liferay-ui:search-container-column-text name="getUserTo" value="<%= UserEntryLocalServiceUtil.getUserEntry(notificationEntry.getUserIdTo()).getUserName() %>"/>
		<liferay-ui:search-container-column-text name="Subject" value="<%= notificationEntry.getSubject().toString() %>"/>
		<liferay-ui:search-container-column-text name="SendDate" value="<%= notificationEntry.getCreateDate().toString() %>"/>
		<%
			String statusImage= renderRequest.getContextPath();
			if(notificationEntry.getStatus()==0)
			{
				statusImage+="/img/letter.png";
			}
			else
			{
				statusImage+="/img/letter_open.png";
			}
		%>
		<portlet:renderURL var="viewNotificationURL">
		<portlet:param name="jspPage" value="/html/notificationportlet/ViewNotification.jsp"/>
		<portlet:param name="notificationId" value="<%= String.valueOf(notificationEntry.getNotificationId()) %>" />
		</portlet:renderURL>
		<liferay-ui:search-container-column-text name="Status">
			<img src="<%=statusImage%>"/>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Action" >
			<a href="<%= viewNotificationURL%>" class="tagA"><img src="<%=renderRequest.getContextPath()%>/img/file.png"/></a>  <a href="#" class="tagA"><img src="<%=renderRequest.getContextPath()%>/img/delete.png"/></a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
</liferay-ui:search-container>

		
