<%@page import="vn.com.fis.portal.service.CategoryEntryLocalServiceUtil"%>
<%@page import="vn.com.fis.portal.service.persistence.CategoryEntryFinderUtil"%>
<%@page import="vn.com.fis.portal.model.CategoryEntry"%>
<%@page import="vn.com.fis.portal.model.VideoEntry"%>
<%@page import="vn.com.fis.portal.service.VideoEntryLocalServiceUtil"%>
<%@taglib uri="http://java.sun.com/portlet_2_0"  prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@taglib uri="http://liferay.com/tld/util"  prefix="liferay-util"%>
<%@taglib uri="http://liferay.com/tld/ui"  prefix="liferay-ui"%>
<%@taglib uri="http://alloy.liferay.com/tld/aui"  prefix="aui"%>
<%@taglib uri="http://liferay.com/tld/theme"  prefix="theme"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	List<CategoryEntry> categoryEntries =new  ArrayList<CategoryEntry>(); 
	long userId =0;
	
	
	try{
		userId= user.getUserId();
		if(currFolderId!=0)
			folderEntry = FolderEntryLocalServiceUtil.getFolderEntry(currFolderId);
		
	}catch(Exception e){e.printStackTrace();}
	 
	try{
		categoryEntries = CategoryEntryLocalServiceUtil.getCategoryEntries(0,CategoryEntryLocalServiceUtil.getCategoryEntriesCount() );
	}catch(Exception e){e.printStackTrace();}
	
%>
 

<% 
PortletURL	videoIteratorURL  =  renderResponse.createRenderURL();
String backURL = ParamUtil.getString(renderRequest, "redirectURL");
%>
 			
		<liferay-ui:header title="Upload video" backURL="<%=backURL%>" />
	
		<portlet:actionURL  name="uploadVideo" var="uploadVideo">
			<portlet:param name="folderId" value="<%=String.valueOf(currFolderId) %>" />
		</portlet:actionURL>
		
		<aui:form name="uploadVideoForm" action="<%=uploadVideo.toString() %>" enctype="multipart/form-data" method="POST">
		  <aui:input  name="videoName" size="50"  >
		  	<aui:validator name="required" />
		  </aui:input>
		  
		  <aui:select  name="categoryId" multiple="true" label="Category"  showEmptyOption="true" >
		  	
		  	<c:forEach var="categoryEntry" items="<%=categoryEntries %>" >
		  			<aui:option value="${categoryEntry.categoryId}" >
		  					<c:out value="${categoryEntry.categoryName}"  />
		  			</aui:option>
		  	</c:forEach> 

		  </aui:select>
		  <aui:input  name="description" size="50" />
		  <aui:input type="file" name="fileName" size="50"  >
		  		<aui:validator name="required" />
		  </aui:input>
		  
		  
		  <aui:button-row>
		  	<aui:button type="submit" value="upload" />
		  </aui:button-row>
		</aui:form>
