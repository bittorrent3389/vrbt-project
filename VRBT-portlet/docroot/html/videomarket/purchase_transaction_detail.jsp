<%@page import="vn.com.fis.portal.service.VideoEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="vn.com.fis.portal.util.VideoAdminPortletUtil"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/util"  prefix="liferay-util"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<portlet:defineObjects/>
<theme:defineObjects/>

<%	
	long videoId = ParamUtil.getLong(renderRequest, "videoId");
	long userId = ParamUtil.getLong(renderRequest, "userId");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
%>

<c:if  test='<%= VideoAdminPortletUtil.hasRole(PortalUtil.getUserId(request),PortalUtil.getCompanyId(request), "Subscriber") %>'>
<portlet:actionURL var="buyVideoURL" name="buyVideo">
	<portlet:param name="videoId" value="<%= String.valueOf(videoId)  %>"/>
	<portlet:param name="userId" value="<%= String.valueOf(userId) %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<fieldset>
	<liferay-ui:message key="Transaction."/>
	<br/>
	<liferay-ui:message key="Video Name : "/> <%= VideoEntryLocalServiceUtil.getVideoEntry(videoId).getVideoName() %>
	<br/>
	<liferay-ui:message key="Total: 0.99$"/>
	<br/>
	<liferay-ui:message key="Do you want to continue transaction."/>
	
	<aui:button-row>
		<aui:button type="submit" value="OK" name="" href="<%= buyVideoURL %>"/>
		<aui:button type="button" value="Cancel" name="" href="<%= redirect %>"/>
	</aui:button-row>
</fieldset>
</c:if>