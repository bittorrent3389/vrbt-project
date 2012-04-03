<%@page import="vn.com.fis.portal.model.VideoEntry"%>
<%@page import="vn.com.fis.portal.service.VideoEntryLocalServiceUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/util"  prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<portlet:defineObjects/>
<theme:defineObjects/>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.com.fis.portal.service.FolderEntryLocalServiceUtil"%>
<%@page import="vn.com.fis.portal.model.FolderEntry"%>
<%@page import="java.util.List"%>

<% 
	
	long currFolderId = ParamUtil.getLong(renderRequest, "currFolderId",0); // ROOT_FOLDER_ID=0
	FolderEntry folderEntry = null;
	long userId =0;
	
	
	try{
		userId= user.getUserId();
		if(currFolderId!=0)
			folderEntry = FolderEntryLocalServiceUtil.getFolderEntry(currFolderId);
		
	}catch(Exception e){e.printStackTrace();}
	 
	
%>
 <% 
PortletURL	videoIteratorURL  =  renderResponse.createRenderURL();
String backURL = ParamUtil.getString(renderRequest, "redirectURL");
%>
 			
		<liferay-ui:header title="Add subfolder" backURL="<%=backURL%>" />
		
		<portlet:actionURL  name="addSubFolder" var="addSubFolder">
			<portlet:param name="currFolderId" value="<%=String.valueOf(currFolderId) %>" />
		</portlet:actionURL>
		
		<aui:form name="addSubFolderForm" action="<%=addSubFolder.toString() %>"   method="POST">
		  <aui:input type="text" name="folderName" size="50" />
		  <aui:button-row>
		  	<aui:button type="submit" value="Create" />
		  </aui:button-row>
		</aui:form>
 