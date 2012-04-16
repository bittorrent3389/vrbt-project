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
	List<FolderEntry> folderEntries = new ArrayList<FolderEntry>();
	int	folderTotal = FolderEntryLocalServiceUtil.getFolderEntriesCount();
	long currFolderId = ParamUtil.getLong(renderRequest, "currFolderId",0); // ROOT_FOLDER_ID=0
	FolderEntry folderEntry = null;
	long userId =0;
	
	
	try{
		userId= user.getUserId();
		if(currFolderId!=0)
			folderEntry = FolderEntryLocalServiceUtil.getFolderEntry(currFolderId);
		
	}catch(Exception e){e.printStackTrace();}
	
	try{
		//folderEntries = FolderEntryLocalServiceUtil.findByFolderParentId_UserId(currFolderId, userId);
		folderEntries = FolderEntryLocalServiceUtil.findByFolderIdParent_UserId(currFolderId, userId);
		
	}catch(Exception e){e.printStackTrace();}
 	
	
%>

	<div class="lfr-panel-content">
	 
		<div class="lfr-portlet-toolbar" style="overflow: hidden;padding: 2px;margin-bottom: 5px;padding: 4px 14px 4px 29px;">
					<h3>
						<%= ((folderEntry ==null)?"Home":folderEntry.getFolderName()) %>
					</h3>
		</div>
	 	<hr/>
		<ul class="category-portlets lfr-component" style="padding: 0px;list-style:none outside; margin-top: 2px;position: relative;" >
			<% if(  folderEntry !=null ){ %>
			<li  style="background-color: #00A2EA;cursor: pointer;overflow: auto;margin-bottom: 2px;">
				<portlet:renderURL  var="upToParentFolderURL">
					<portlet:param name="currFolderId" value="<%= String.valueOf(folderEntry.getFolderIdParent()) %>" />
				</portlet:renderURL>
				 <a href="<%= upToParentFolderURL %>" style="text-decoration: none;"  >  
				 	<span style="color: white;font-weight: bold;" ><img class="icon" alt="Up" src="/html/themes/control_panel/images/arrows/01_up.png" style="margin: 5px 10px;"> Up</span> 
				 </a> 
			</li>
			<% } %>
			
			<%--other folders --%>
			<% for(int i=0; i<folderEntries.size();i++){
				folderEntry = folderEntries.get(i);
				renderRequest.setAttribute("folderId",folderEntry.getFolderId() );
				%>
				<li  class="folder" style="background-color: #00A2EA;cursor: pointer;overflow: auto;margin-bottom: 2px;">
				<%-- folder action menu  --%>
				
				 <liferay-util:include page="/html/videoadminportlet/folder_actions.jsp" servletContext="<%= getServletContext() %>">
					 <liferay-util:param name="currFolderId" value="<%= String.valueOf(currFolderId) %>" />
					 <liferay-util:param name="folderId" value="<%= String.valueOf(folderEntry.getFolderId()) %>" />
				 </liferay-util:include>
				 
				<portlet:renderURL  var="folderURL">
					<portlet:param name="currFolderId" value="<%= String.valueOf(folderEntry.getFolderId()) %>" />
				</portlet:renderURL>
				 <a href="<%= folderURL %>" style="text-decoration: none;"  >  
				 	<span  style="color: white;font-weight: bold;"><img class="icon" alt="Up" src="/html/themes/control_panel/images/common/folder_full_document.png" style="margin: 5px 10px;"> <%=  folderEntry.getFolderName()%></span> 
				 </a>
				 
				 
				  
			</li>	
			<% } %>
		</ul>
	</div>


 