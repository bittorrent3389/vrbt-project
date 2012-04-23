 <%@ include file="/html/init.jsp" %>

<%
	long videoId = ParamUtil.getLong(request, "videoId");
%>


<portlet:resourceURL var="purchaseURL" >
	<portlet:param name="videoId" value="<%= String.valueOf(videoId) %>"/>
	<portlet:param name="cmd" value="buyVideo"/>
</portlet:resourceURL>

<c:if test="<%= videoId > 0 %>">
<% 
	VideoEntry videoEntry = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
%>
	<c:if test="<%= videoEntry!=null %>">
	
	<div id="videoPurchaseForm">
	<fieldset>
		<div>Transaction</div>
		<div>Video Name : <%= videoEntry.getVideoName() %></div>
		<div>Total: 0.99$  <%= videoEntry.getVideoName() %></div>
		<div>Do you want to continue transaction.</div>
		<br/>
		<aui:form method="post"  action="<%= purchaseURL.toString() %>" id="purchaseForm">
			<button class="reportBtn" onclick="purchaseForm('<%=purchaseURL.toString()%>');return false;"> Purchase  </button>
		</aui:form>
	</fieldset>
	
	</div>
	</c:if>

</c:if>
<aui:script use="aui-io-request,aui-node,json-parse" >
 
    Liferay.provide(
            window,
            'purchaseForm',
            function(urlParam) {
            var A = AUI();
            A.io.request(
            urlParam, {
            method: 'POST',
            dataType: 'JSON',
			form: {
			   id: '<portlet:namespace />purchaseForm'
			  },
			on: {
               success: function(dataJson) {
					
					if(this.get('responseData').result =='successfully'){
					A.one('div#videoPurchaseForm').html('<center > <h3>Thansk you ! </h3></center>');
					}else 
					if(this.get('responseData').result =='failure'){
					A.one('div#videoPurchaseForm').html('<center > <h3>Transaction failure! </h3></center>');
					}
					
					
            	   }
            	}
            });
        });
 
</aui:script>
