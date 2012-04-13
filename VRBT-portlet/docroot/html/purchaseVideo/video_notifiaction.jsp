<%@ include file="/html/init.jsp" %>
<%
	String videoId = ParamUtil.getString(renderRequest, "videoId");
	String userId = ParamUtil.getString(renderRequest, "userId");
	String redirect = ParamUtil.getString(renderRequest, "redirect");
	
	List<ViolationEntry> listViolation = new ArrayList<ViolationEntry>();
	
	try{
	
	if(ViolationEntryLocalServiceUtil.countAll() > 0)
		listViolation = ViolationEntryLocalServiceUtil.findAll();
	}catch(Exception e){
		e.printStackTrace();
	}
%>

<portlet:actionURL var="videoReportToAdminURL" name="videoReportToAdmin">
	<portlet:param name="videoId" value="<%= videoId %>"/>
	<portlet:param name="userId" value="<%= userId %>"/>
	<portlet:param name="redirect" value="<%= redirect %>"/>
</portlet:actionURL>

<fieldset>
	<aui:form method="post" name="videoReportToAdminForm" action="<%= videoReportToAdminURL %>">
		<aui:select name="violationId">
			<% for(ViolationEntry violation : listViolation) { 
				if(violation.getStatus() == 1){	%>
					<aui:option label="<%= violation.getViolationTitle() %>" value="<%= violation.getViolationId() %>"/>
			<% }} %>
		</aui:select>
		
		<aui:button-row>
			<aui:button type="submit" name="" value="Send"/>
			<aui:button type="button" name="" value="Cancel" href="<%= redirect %>"/>
		</aui:button-row>
	</aui:form>
</fieldset>