<%@ include file="/html/init.jsp" %>
<%
	//-----------------------khai bao-------------------------
	int transactionCode=2;
	String userId=user.getUserId()+"";
	if(userId.equals("null")||userId.equals("")||userId.equals("10158"))
	{
		//userId="0";
		out.println("please login");
		return;
	}
	//--------------------------------------------------------
	String pageRecord=renderRequest.getParameter("delta")+"";
	if(pageRecord.equals("null")||pageRecord.equals(""))
	{
		pageRecord="20";
	}
	
	int countListVideoUserTransactionEntry=0;
	
	String pageIndex=renderRequest.getParameter("cur")+"";
	if(pageIndex.equals("null")||pageIndex.equals(""))
	{
		pageIndex="1";
	}
	int endRow=Integer.parseInt(pageIndex) * Integer.parseInt(pageRecord);
	
	String userName = ParamUtil.getString(renderRequest, "UserName","");
	String videoName = ParamUtil.getString(renderRequest, "VideoName","");
	String transaction = ParamUtil.getString(renderRequest, "Transaction","");
	List<VideoUserTransactionEntry> listVideoUserTransactionEntry;
	
	int purchase=0;
	int nopurchase=0;
	String strColumnChart="";
	
	if(userName.equals(""))
	{
		listVideoUserTransactionEntry = VideoUserTransactionEntryLocalServiceUtil.getVideoUserTransactionEntries(endRow - Integer.parseInt(pageRecord),endRow);
		countListVideoUserTransactionEntry = VideoUserTransactionEntryLocalServiceUtil.getVideoUserTransactionEntriesCount();
		
		//du lieu cho bieu do
		purchase = VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(2);
		nopurchase= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(1)-purchase;
		
		for(int i = 1;i<12;i++)
			{
				int moth=i+1;
				strColumnChart+= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(1, "1/"+i+"/2012","1/"+moth+"/2012")-VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(2, "1/"+i+"/2012","1/"+moth+"/2012")+"#";
				strColumnChart+= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(2, "1/"+i+"/2012","1/"+moth+"/2012")+"$";
				
			}
		
	}
	else
	{
		//System.out.println("userName: "+userName+" transaction: "+transaction+" videoName: "+videoName);
		userId = UserEntryLocalServiceUtil.getUserEntryByUserName(userName).getUserId()+"";
		listVideoUserTransactionEntry = VideoUserTransactionEntryLocalServiceUtil.seachThirdPartyVideoUserTransactionEntryByCondition(Integer.parseInt(transaction), Integer.parseInt(userId), videoName,endRow - Integer.parseInt(pageRecord), endRow);
		countListVideoUserTransactionEntry = VideoUserTransactionEntryLocalServiceUtil.countSeachThirdPartyVideoUserTransactionEntryByCondition(Integer.parseInt(transaction), Integer.parseInt(userId), videoName);
		//data chart
		purchase = VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(Integer.parseInt(userId),2);
		nopurchase= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(Integer.parseInt(userId),1)-purchase;
		for(int i = 1;i<12;i++)
		{
			int moth=i+1;
			strColumnChart+= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(Integer.parseInt(userId),1, "1/"+i+"/2012","1/"+moth+"/2012")-VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(Integer.parseInt(userId),2, "1/"+i+"/2012","1/"+moth+"/2012")+"#";
			strColumnChart+= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(Integer.parseInt(userId),2, "1/"+i+"/2012","1/"+moth+"/2012")+"$";
		}
		
	}
	
	UserEntry userEntry = UserEntryLocalServiceUtil.getUserEntry(Integer.parseInt(userId));
	
	PortletURL searchRenderURL = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	
	RowChecker rowChecker = new RowChecker(renderResponse);
	rowChecker.setRowIds("transactionHistoryId");
	rowChecker.setAllRowIds("transactionHistoryAllRowIds");
%>
<div class="fontTitleForm">
		Manager billing subscripber ... 
</div>

<!-- chart -->
<span id="spanDataPieChart" style="display: none;">
	purchase#<%= purchase%>@nopurchase#<%= nopurchase%>
</span>
<span id='spanDataColumnChart' style="display: none;">
<% 
//------------------du lieu cho chart----------------------
	
	out.println(strColumnChart);
%></span>
    <link rel="stylesheet" type="text/css" href="<%=renderRequest.getContextPath()%>/ext/resources/css/ext-all.css" />
    <link rel="stylesheet" type="text/css" href="<%=renderRequest.getContextPath()%>/ext/examples/shared/example.css" />
    <script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/bootstrap.js"></script>
    <script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/example-data.js"></script>
    <script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/charts/Pie.js"></script>
    <script type="text/javascript" src="<%=renderRequest.getContextPath()%>/ext/examples/charts/Column.js"></script>


<div id="divChartContainer" style="margin: 10px;width: 500px;height: 300px;float: left;">
</div>  
<div id="divColumnChartContainer" style="margin: 10px;width: 500px;height: 300px;float: left;">
</div> 
<hr style="clear: both"/> 
<!-- end chart -->

<div>
	<portlet:actionURL var="SeachVideoUserTransactionEntry" name="seachVideoUserTransactionEntry">
	</portlet:actionURL>
	<aui:form action="<%= SeachVideoUserTransactionEntry.toString() %>" method="post" inlineLabels="false">
		<aui:input name="UserName" label="UserName-label" title="UserName-label"  value="<%= userName%>" />
		<aui:input name="VideoName" label="UserName-label" title="VideoName-label"  value="<%= videoName%>" />
		<aui:select name="Transaction" label="Transaction-label">
		<aui:option value="-1">
			<liferay-ui:message key="please-choose"/>
		</aui:option>
		<aui:option value="1">
			<liferay-ui:message key="upload"/>
		</aui:option>
		<aui:option value="2">
			<liferay-ui:message key="purchase"/>
		</aui:option>
		<aui:option value="3">
			<liferay-ui:message key="send"/>
		</aui:option>
		<aui:option value="4">
			<liferay-ui:message key="receive"/>
		</aui:option>
	</aui:select>
		<aui:button-row>
				<aui:button type="submit" value="seach-button"/>
		</aui:button-row>
	</aui:form>
</div>

<div style="font-size: 20px;text-align: center;margin-bottom:5px;margin-top:5px">Report</div>
<div style="border: dashed 1px gray;">
	<div style="margin-top:10px;margin-left: 10px">
		UserName: <%= userEntry.getUserName()%>
	</div>
	
	<div style="margin-top:5px;margin-left: 10px;margin-bottom: 10px;">video buy: <%= countListVideoUserTransactionEntry%> x 2500VND =<%=countListVideoUserTransactionEntry*2500%>VND</div>
</div>

<div>
<liferay-ui:search-container delta="<%= Integer.parseInt(pageRecord) %>" emptyResultsMessage="No record were found" iteratorURL="<%= searchRenderURL %>" rowChecker="<%= rowChecker %>">
	<liferay-ui:search-container-results 
		results="<%= listVideoUserTransactionEntry%>"
		total="<%= countListVideoUserTransactionEntry%>">
	</liferay-ui:search-container-results>
	
	<portlet:renderURL var="viewBilling" >
		<portlet:param name="jspPage" value="/html/vrbtsubcriberpaymentportlet/ViewBilling.jsp" />
	</portlet:renderURL>
	
	
	<div>
	
		<liferay-ui:search-container-row className="vn.com.fis.portal.model.VideoUserTransactionEntry" keyProperty="transactionId" modelVar="videoTransactionHistoryEntry">
		
			<%
				String transactionCodeName= "";
				if(String.valueOf(videoTransactionHistoryEntry.getTransactionCode()).equals("1"))
				{
					transactionCodeName ="upload";
				}
				else if(String.valueOf(videoTransactionHistoryEntry.getTransactionCode()).equals("2"))
				{
					transactionCodeName = "purchase";
				}
				else if(String.valueOf(videoTransactionHistoryEntry.getTransactionCode()).equals("3"))
				{
					transactionCodeName = "send";
				}
				else
				{
					transactionCodeName = "receive";
				}
				
				String receiver ="";
				if(!String.valueOf(videoTransactionHistoryEntry.getReceiverId()).equals("0"))
				{
					receiver = UserEntryLocalServiceUtil.getUserEntry(videoTransactionHistoryEntry.getReceiverId()).getUserName();
				}
			%>
		
			<liferay-ui:search-container-column-text name="transaction_Code" value="<%= transactionCodeName %>"/>
			<liferay-ui:search-container-column-text name="video_Name" value="<%= VideoEntryLocalServiceUtil.getVideoEntry(videoTransactionHistoryEntry.getVideoId()).getVideoName() %>"/>
			<liferay-ui:search-container-column-text name="user_Name" value="<%= UserEntryLocalServiceUtil.getUserEntry(videoTransactionHistoryEntry.getUserId()).getUserName() %>"/>
			<liferay-ui:search-container-column-text name="receiver_User" value="<%= String.valueOf(receiver) %>"/>
			<liferay-ui:search-container-column-text name="receiver_User" value="<%= String.valueOf(videoTransactionHistoryEntry.getDate_()) %>"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</div>
</liferay-ui:search-container>
</div>