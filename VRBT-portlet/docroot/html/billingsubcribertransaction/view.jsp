<%@ include file="/html/init.jsp" %>
<%
	//-----------------------khai bao-------------------------
	int transactionCode=2;
	String userId=user.getUserId()+"";
	String pageRecord=renderRequest.getParameter("delta")+"";
	//--------------------------------------------------------
	if(userId.equals("null")||userId.equals("")||userId.equals("10158"))
	{
		//userId="0";
		out.println("please login");
		return;
	}
	if(pageRecord.equals("null"))
	{
		pageRecord="20";
	}
	
	String pageIndex=renderRequest.getParameter("cur")+"";
	if(pageIndex.equals("null"))
	{
		pageIndex="1";
	}
	int endRow=Integer.parseInt(pageIndex) * Integer.parseInt(pageRecord);
	
	
	String userName = ParamUtil.getString(renderRequest, "UserName","");
	//System.out.println(ParamUtil.getString(renderRequest, "UserName",""));
	
	
	List<VideoUserTransactionEntry> listVideoUserTransactionEntry;
	int countListVideoUserTransactionEntry=0;
	
	UserEntry userEntry = UserEntryLocalServiceUtil.getUserEntry(Integer.parseInt(userId));
	
	listVideoUserTransactionEntry = VideoUserTransactionEntryLocalServiceUtil.getVideoUserTransaction_By_UserId_And_TransactionCode(Integer.parseInt(userId),transactionCode,endRow - Integer.parseInt(pageRecord), endRow);
	//System.out.println("listVideoUserTransactionEntry: "+listVideoUserTransactionEntry.size());
	countListVideoUserTransactionEntry = VideoUserTransactionEntryLocalServiceUtil.getCount_VideoUserTransaction_By_UserId_And_TransactionCode(Integer.parseInt(userId),transactionCode);
	//System.out.println("countListVideoUserTransactionEntry: "+countListVideoUserTransactionEntry);
	long purchase = VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(Integer.parseInt(userId),2);
	long nopurchase= VideoUserTransactionEntryLocalServiceUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(Integer.parseInt(userId),1)-purchase;
	//System.out.println("purchase: "+purchase+" nopurchase : "+nopurchase);
%>
<portlet:actionURL var="SeachBillingVideoTransactionHistory" name="seachBillingVideoTransactionHistory">
</portlet:actionURL>
<div>
<liferay-ui:success key="notification-Success" message="notification"/>
</div>
<div class="fontTitleForm">
		Billing Subcriber Transaction
</div>

<div style="font-size: 20px;text-align: center;margin-bottom:5px;margin-top:5px">Report</div>
<div style="border: dashed 1px gray;">
	<div style="margin-top:10px;margin-left: 10px">
		UserName: <%= userEntry.getUserName()%>
	</div>
	
	<div style="margin-top:5px;margin-left: 10px;margin-bottom: 10px;">video buy: <%= countListVideoUserTransactionEntry%> x 3000VND =<%= countListVideoUserTransactionEntry*3000%>VND</div>
</div>
<hr/>
	
<liferay-ui:search-container delta="<%= Integer.parseInt(pageRecord) %>" emptyResultsMessage="No record were found">
	<liferay-ui:search-container-results 
		results="<%= listVideoUserTransactionEntry%>"
		total="<%= countListVideoUserTransactionEntry%>">
	</liferay-ui:search-container-results>
	
	
	<div>
	
		<liferay-ui:search-container-row className="vn.com.fis.portal.model.VideoUserTransactionEntry" keyProperty="transactionId" modelVar="videoTransactionHistoryExt">
		
			<%
				String transactionCodeName= "";
				if(String.valueOf(videoTransactionHistoryExt.getTransactionCode()).equals("1"))
				{
					transactionCodeName ="upload";
				}
				else if(String.valueOf(videoTransactionHistoryExt.getTransactionCode()).equals("2"))
				{
					transactionCodeName = "purchase";
				}
				else
				{
					transactionCodeName = "receive";
				}
				
				String receiver ="";
				if(!String.valueOf(videoTransactionHistoryExt.getReceiverId()).equals("0"))
				{
					receiver = UserEntryLocalServiceUtil.getUserEntry(videoTransactionHistoryExt.getReceiverId()).getUserName();
				}
			%>
		
			<liferay-ui:search-container-column-text name="transaction_Code" value="<%= String.valueOf(transactionCodeName) %>"/>
			<liferay-ui:search-container-column-text name="video_Name" value="<%= VideoEntryLocalServiceUtil.getVideoEntry(videoTransactionHistoryExt.getVideoId()).getVideoName() %>"/>
			<liferay-ui:search-container-column-text name="user_Name" value="<%= UserEntryLocalServiceUtil.getUserEntry(videoTransactionHistoryExt.getUserId()).getUserName() %>"/>
			<liferay-ui:search-container-column-text name="receiver_User" value="<%= String.valueOf(receiver) %>"/>
			<liferay-ui:search-container-column-text name="Transaction_Date" value="<%= String.valueOf(videoTransactionHistoryExt.getDate_()) %>"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator/>
	</div>
	
</liferay-ui:search-container>

		
