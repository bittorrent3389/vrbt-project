<%@ include file="/html/init.jsp" %>
<%	
	long videoId = ParamUtil.getLong(renderRequest, "videoId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
%>

<portlet:actionURL var="buyVideoURL" name="buyVideo">
	<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
	<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<fieldset>
	<liferay-ui:message key="Transaction."/>
	<br/>
	<liferay-ui:message key="Video Name : "/> <%= VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName() %>
	<br/>
	<liferay-ui:message key="Total: 0.99$"/>
	<br/>
	<liferay-ui:message key="Do you want to continue transaction."/>
	
	<aui:button-row>
		<aui:button type="submit" value="OK" name="" href="<%= buyVideoURL %>"/>
		<aui:button type="button" value="Cancel" name="" href="<%= redirect %>"/>
	</aui:button-row>
</fieldset>
