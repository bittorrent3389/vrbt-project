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

<portlet:actionURL var="searchMyVideoURL" name="searchMyVideo">
	<portlet:param name="jspPage" value="/html/myvideoportlet/view.jsp" />
</portlet:actionURL>

<aui:form action="<%= searchMyVideoURL %>" method="post" name="searchMyVideoForm" >
	 
	<aui:input   name="videoName" size="30" type="text" value='<%=  ParamUtil.getString(renderRequest, "videoName","") %>' />
	
	<aui:select 	name="originCode" showEmptyOption="true" >
		<aui:option value="1" selected='<%= ParamUtil.getLong(renderRequest, "originCode",-1) == 1 %>' label="Upload" />
		<aui:option value="2" selected='<%= ParamUtil.getLong(renderRequest, "originCode",-1) == 2   %>'  label="Purchase "/>
		<aui:option value="3" selected='<%= ParamUtil.getLong(renderRequest, "originCode",-1) == 3   %>' label="Receive"/>
	</aui:select>
	
	<aui:select 	name="serviceActive" showEmptyOption="true">
		
		<aui:option value="1" selected='<%= ParamUtil.getLong(renderRequest, "serviceActive",-1) == 1 %>'  label="Active" />
		<aui:option value="0" selected='<%= ParamUtil.getLong(renderRequest, "serviceActive",-1) == 0   %>'  label="inActive"/>
	</aui:select>
	
	
	<aui:button-row>
		<aui:button type="submit" value="search" />
	</aui:button-row>
</aui:form>

<div class="separator"><!-- --></div>



<aui:script>
				if (document.<portlet:namespace />searchMyVideoForm.<portlet:namespace />videoName) {
					Liferay.Util.focusFormField(document.<portlet:namespace />searchMyVideoForm.<portlet:namespace />videoName);
				}
</aui:script>