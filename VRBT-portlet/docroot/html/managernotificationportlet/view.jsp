<%@page import="vn.com.fis.portal.service.persistence.NotificationEntryFinderUtil"%>
<%@page import="vn.com.fis.portal.VRBTLibrary"%>
<%@ include file="/html/init.jsp" %>
<%
	String typeNotification="";
	//System.out.println(renderRequest.getParameter("typeNotification")+"");
	typeNotification=renderRequest.getParameter("typeNotification")+"";
	VRBTLibrary vrbtLibrary = new VRBTLibrary();
	long userId=user.getUserId();
	//--------------------------check login and permission------------------------------
	if((userId+"").equals("null"))
	{
		userId=0;		
	}
		if(!vrbtLibrary.checkLogin(userId,renderRequest, "Network-Operator").equals("Success"))
		{
			out.println(vrbtLibrary.checkLogin(userId,renderRequest, "Third-party"));
			return;
		}
		else
		{
			if(ParamUtil.getString(renderRequest, "delete","").equals("true"))
			{
				NotificationEntryLocalServiceUtil.deleteNotificationEntry(Integer.parseInt(ParamUtil.getString(renderRequest, "notificationId","")));
				
			}
		}
		//----------------------------------------------------------------------------------
	if(typeNotification.equals("null"))
	{
		typeNotification="NOTIFICATIONUSERIDTO";
	}
	
	//System.out.println("delta:"+renderRequest.getParameter("typeNotification")+"");
	String pageRecord=renderRequest.getParameter("delta")+"";
	if(pageRecord.equals("null"))
	{
		pageRecord="20";
	}
	
	
	
	String pageIndex=renderRequest.getParameter("cur")+"";
	if(pageIndex.equals("null"))
	{
		pageIndex="1";
	}
	int endRow=Integer.parseInt(pageIndex) * Integer.parseInt(pageRecord);
	
	
	PortletURL searchRenderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	
	RowChecker rowChecker = new RowChecker(renderResponse);
	rowChecker.setRowIds("notificationId");
	rowChecker.setAllRowIds("notificationAllRowIds");
%>

<div class="fontTitleForm">
		This is the Manager Notify portlet in notify mode...
	</div>
<div>

</div>
<portlet:actionURL var="editGreetingURL">
    <portlet:param name="jspPage" value="/html/notificationportlet/SendNotification.jsp" />
</portlet:actionURL>
<liferay-ui:search-container delta="<%= Integer.parseInt(pageRecord) %>" emptyResultsMessage="No record were found" iteratorURL="<%= searchRenderURL %>" rowChecker="<%= rowChecker %>">
	<liferay-ui:search-container-results 
		results="<%= NotificationEntryLocalServiceUtil.getNotificationEntryByUserId(userId,typeNotification, endRow - Integer.parseInt(pageRecord), endRow)%>"
		total="<%= NotificationEntryLocalServiceUtil.getNotificationEntryByUserIdCount(userId,typeNotification)%>">
	</liferay-ui:search-container-results>
	
	
	
	<portlet:renderURL var="SendNotification" >
		<portlet:param name="jspPage" value="/html/managernotificationportlet/SendNotification.jsp" />
	</portlet:renderURL>
	<portlet:renderURL var="viewInbox" >
		<portlet:param name="jspPage" value="/html/managernotificationportlet/view.jsp" />
		<portlet:param name="typeNotification" value="NOTIFICATIONUSERIDTO" />
	</portlet:renderURL>
	<portlet:renderURL var="viewOutbox" >
		<portlet:param name="jspPage" value="/html/managernotificationportlet/view.jsp" />
		<portlet:param name="typeNotification" value="NOTIFICATIONUSERIDFROM" />
	</portlet:renderURL>
	<hr/>
	<a href="<%= SendNotification %>" class="tagA"><img src="<%=renderRequest.getContextPath()%>/img/text_signature.png"/><span class="spanA">SendNotification</span></a>
	<hr/>
	<div style="background-color: black;height: 20px;">
		<aui:a id="aSpanInbox" href="<%=viewInbox%>" ><span id='spanInbox' style="color: #ffffff" >InBox</span></aui:a>|
		<aui:a id="aSpanOutbox" href="<%=viewOutbox%>"><span id='spanOutbox' style="color: #ffffff" >OutBox</span></aui:a>
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
			<liferay-ui:search-container-column-text name="Status">
			<img src="<%=statusImage%>"/>
		</liferay-ui:search-container-column-text>
		<portlet:renderURL var="viewNotificationURL">
			<portlet:param name="jspPage" value="/html/managernotificationportlet/ViewNotification.jsp"/>
			<portlet:param name="notificationId" value="<%= String.valueOf(notificationEntry.getNotificationId()) %>" />
		</portlet:renderURL>
		<portlet:renderURL var="deleteNotificationURL">
			<portlet:param name="delete" value="<%= String.valueOf(true) %>" />
			<portlet:param name="notificationId" value="<%= String.valueOf(notificationEntry.getNotificationId()) %>" />
		</portlet:renderURL>
			<liferay-ui:search-container-column-text name="Action" >
			<a href="<%= viewNotificationURL%>" class="tagA"><img src="<%=renderRequest.getContextPath()%>/img/file.png"/></a>  <a href="<%= deleteNotificationURL%>" class="tagA"><img src="<%=renderRequest.getContextPath()%>/img/delete.png"/></a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator/>
</liferay-ui:search-container>
<span id="spanlocalvariable" hidden="true"><%= typeNotification%></span>
<script type="text/javascript">
var str = document.getElementById("spanlocalvariable").innerHTML;
function changeColorSpan(typeNotification)
{
	if(typeNotification =='NOTIFICATIONUSERIDFROM')
	{
		document.getElementById('spanInbox').style.backgroundColor = 'black';
		document.getElementById('spanOutbox').style.backgroundColor = 'red';
	}
	else if(typeNotification == 'NOTIFICATIONUSERIDTO')
	{
		document.getElementById('spanInbox').style.backgroundColor = 'red';
		document.getElementById('spanOutbox').style.backgroundColor = 'black';
	}

	
}
changeColorSpan(str);

document.getElementById("spanlocalvariable").innerHTML="";
</script>
		
