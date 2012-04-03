<%@page import="vn.com.fis.portal.model.CateVideoEntry"%>
<%@page import="vn.com.fis.portal.service.CateVideoEntryLocalServiceUtil"%>
<%@page import="vn.com.fis.portal.model.CategoryEntry"%>
<%@page import="vn.com.fis.portal.service.CategoryEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<liferay-ui:error key="edit-video-error" message="edit-video-error" />


<% 
	PortletURL  currURL = 	PortletURLUtil.getCurrent(renderRequest, renderResponse);
	String redirectCurr = currURL.toString();	
	//long currFolderId = ParamUtil.getLong(renderRequest, "currFolderId",0); // ROOT_FOLDER_ID=0
	
	long videoId = ParamUtil.getLong(renderRequest, "videoId",0);
	
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	VideoEntry videoEntry= null;
	long userId =0;
	
	List<CategoryEntry> categoryEntries =new  ArrayList<CategoryEntry>(); 
	try{
		categoryEntries = CategoryEntryLocalServiceUtil.getCategoryEntries(0,CategoryEntryLocalServiceUtil.getCategoryEntriesCount() );
	}catch(Exception e){e.printStackTrace();}
	
	try{
		userId= user.getUserId();
		if(videoId>0)
			videoEntry = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
		
	}catch(Exception e){e.printStackTrace();}
	 
	
%>

<% 
PortletURL	videoIteratorURL  =  renderResponse.createRenderURL();

%>
 			
		<liferay-ui:header title="Update video" backURL="<%=redirect%>" />
		
		<portlet:actionURL  name="editVideo" var="editVideoURL">
			<portlet:param name="redirectCurr" value="<%=String.valueOf(redirectCurr) %>" />
			<portlet:param name="redirect" value="<%=String.valueOf(redirect) %>" />
			<portlet:param name="videoId" value="<%=String.valueOf(videoId) %>" />
		</portlet:actionURL>
	 
	
	<c:if  test="<%= videoEntry!=null %>">	
		<aui:form name="editVideoForm" action="<%=editVideoURL.toString() %>"   method="POST">
		  <aui:input type="text" name="videoName" size="50"  value="<%= videoEntry.getVideoName() %>"/>
		  <aui:input type="text" name="description" size="50" value="<%= videoEntry.getDescription() %>"/>
		  
		  <% 
//		  		CateVideoEntryLocalServiceUtil.
				List<CateVideoEntry> lis = CateVideoEntryLocalServiceUtil.findByVideoId(videoId);
		  %>
		  
		<aui:select name="categoryIds"  multiple="true" label="Category">
			<% 
			CategoryEntry  categoryEntry=null;
			
			for(int i = 0; i<categoryEntries.size(); i++){
				categoryEntry = categoryEntries.get(i);
				boolean selected = false;
				for(int j =0 ; j< lis.size();j++){
					if( categoryEntry.getCategoryId() == lis.get(j).getCategoryId()){
						selected = true;
					}
				}
			%>	  	
		   	
		   			<aui:option value="<%= categoryEntry.getCategoryId()%>" 
		   							selected='<%= selected %>' label="<%= categoryEntry.getCategoryName()%>" >
		  					
		  			</aui:option>
			<% } %>
		  	
		 </aui:select>	
		  <aui:button-row>
		  	<aui:button type="submit" value="save" />
		  </aui:button-row>
		</aui:form>
 
 </c:if>

<aui:script>
				if (document.<portlet:namespace />editVideoForm.<portlet:namespace />videoName) {
					Liferay.Util.focusFormField(document.<portlet:namespace />editVideoForm.<portlet:namespace />videoName);
				}
</aui:script>
 