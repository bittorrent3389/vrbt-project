<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@taglib uri="http://liferay.com/tld/util"  prefix="liferay-util"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>

<div>
	<liferay-ui:success key="edit-video-successfully" message="edit-video-successfully" />
	<liferay-ui:success key="add-subfolder-success" message="add-subfolder-success" />
	<liferay-ui:success key="upload-video-success" message="upload-video-success" />
</div>
<div>
	<liferay-ui:error key="unknown-case" message="unknown-case" />
	<liferay-ui:error key="do-not-service-or-stopped-service" message="do-not-service-or-stopped-service" />
	<liferay-ui:error key="do-not-service-package" message="do-not-service-package" />
	<liferay-ui:error key="file-size-more-than-package-size" message="file-size-more-than-package-size" />
	
	
</div>

<aui:layout>
	<aui:column columnWidth="20">
		<liferay-util:include page="/html/videoadminportlet/view_folders.jsp"  servletContext="<%=getServletContext() %>"></liferay-util:include>
	</aui:column>
	<aui:column columnWidth="80">
		<liferay-util:include page="/html/videoadminportlet/toolbar.jsp"   servletContext="<%=getServletContext() %>"></liferay-util:include>
		<hr/>
		<liferay-util:include page="/html/videoadminportlet/view_folder_videos.jsp"   servletContext="<%=getServletContext() %>"></liferay-util:include>
	</aui:column>
</aui:layout>