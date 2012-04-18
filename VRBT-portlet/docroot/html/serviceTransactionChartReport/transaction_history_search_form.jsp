<%@ include file="/html/init.jsp" %>
<portlet:actionURL var="searchTransactionHistoryURL" name="searchTransaction_History">
	<portlet:param name="cbServiceChart" value='<%= ParamUtil.getString(renderRequest, "cbServiceChart", "0") %>'/>
	<portlet:param name="cbServicePackageChart" value='<%= ParamUtil.getString(renderRequest, "cbServicePackageChart", "0") %>'/>
</portlet:actionURL>

<%  long transactionCodeNumber = ParamUtil.getLong(renderRequest, "serviceTransactionCode", 0); %>

<fieldset>
	<aui:form name="searchTransactionHistoryForm" method="post" action="<%= searchTransactionHistoryURL %>">
		<aui:select name="serviceTransactionCode" label="portlet-service_transaction_history-transaction_history_search_form-select-serviceTransactionCode">
			<aui:option label="portlet-service_transaction_history-transaction_history_search_form-select-option-type-0" 
				value="0" selected="<%= transactionCodeNumber == 0 %>"/>
			<aui:option label="portlet-service_transaction_history-transaction_history_search_form-select-option-type-1" 
				value="1" selected="<%= transactionCodeNumber == 1 %>"/>
			<aui:option label="portlet-service_transaction_history-transaction_history_search_form-select-option-type-2" 
				value="2" selected="<%= transactionCodeNumber == 2 %>"/>
			<aui:option label="portlet-service_transaction_history-transaction_history_search_form-select-option-type-3" 
				value="3" selected="<%= transactionCodeNumber == 3 %>"/>
		</aui:select>
		
		<aui:button-row>
			<aui:button type="submit" 
				value="portlet-service_transaction_history-transaction_history_search_form-button-search" name="search"/>
		</aui:button-row>
	</aui:form>
</fieldset>