 <%@ include file="/html/init.jsp" %>

<%
	String videoId = ParamUtil.getString(request, "videoId");
	String userId = ParamUtil.getString(request, "userId");
	String redirect = ParamUtil.getString(request, "redirect");
	
	List<ViolationEntry> listViolation =  null;
	try{
		//listViolation = ViolationEntryLocalServiceUtil.findByStatus(1);
		listViolation = ViolationEntryLocalServiceUtil.getViolationEntries(0,ViolationEntryLocalServiceUtil.getViolationEntriesCount());
	}catch(Exception e){e.printStackTrace();}
	
%>


<portlet:resourceURL var="videoReportToAdminURL" >
	<portlet:param name="videoId" value="<%= videoId %>"/>
	<portlet:param name="userId" value="<%= userId %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
	<portlet:param name="cmd" value="report"/>
</portlet:resourceURL>
<div id="videoNotificationForm">
<fieldset>
	<aui:form method="post" name="videoReportToAdminForm" action="<%= videoReportToAdminURL %>" id="videoReportToAdminForm">
		<aui:select name="violationId">
			<c:if test="<%=  listViolation!= null %>">
			<% for(ViolationEntry violation : listViolation) { %>
				<aui:option label="<%= violation.getViolationTitle() %>" value="<%= violation.getViolationId() %>"/>
			<% } %>
			</c:if>
		</aui:select>
		
		<button class="reportBtn" onclick="videoReportToAdminForm('<%=videoReportToAdminURL.toString()%>');return false;"> Send </button>
		
	</aui:form>
</fieldset>

</div>


<aui:script use="aui-io-request,aui-node,json-parse" >
 
    Liferay.provide(
            window,
            'videoReportToAdminForm',
            function(urlParam) {
            var A = AUI();
            A.io.request(
            urlParam, {
            method: 'POST',
            dataType: 'JSON',
			form: {
			   id: '<portlet:namespace />videoReportToAdminForm'
			  },
			on: {
               success: function(dataJson) {
					
					if(this.get('responseData').result =='successfully'){
					A.one('div#videoNotificationForm').html('<center > <h3>Thansk you ! </h3></center>');
					}else 
					if(this.get('responseData').result =='failure'){
					A.one('div#videoNotificationForm').html('<center > <h3>Report failure ! </h3></center>');
					}
					
					
            	   }
            	}
            });
        });
 
</aui:script>
