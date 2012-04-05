<%@ include file="/html/init.jsp" %>

<%
	boolean isAllow = false;
	long userId = permissionChecker.getUserId();
	long companyId = PortalUtil.getCompanyId(renderRequest);
	
	try{
		long roleId = RoleLocalServiceUtil.getRole(companyId, "Network-Operator").getRoleId();
		
		if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
			isAllow = true;
		
	}catch(Exception e){
		e.printStackTrace();
		isAllow = false;
	}
%>

<c:if test="<%= !isAllow %>">
	<fieldset>
		<liferay-ui:message key="portlet-message-deniedPermission"/>	
	</fieldset>

	<br/>
</c:if>

<c:if test="<%= isAllow %>">
	<%@ include file="/html/service_transaction_history/transaction_history_chart_form.jsp" %>

	<br/>
	<hr/>
	<br/>

	<%@ include file="/html/service_transaction_history/transaction_history_search_form.jsp" %>

	<br/>

	<liferay-ui:search-container delta="10" emptyResultsMessage="portlet-service_transaction_history-view-search-container-emptyResultsMessage">
		<liferay-ui:search-container-results 
			results="<%= ServiceTransactionEntryLocalServiceUtil.search(transactionCodeNumber, 0, 0, searchContainer.getStart(), searchContainer.getEnd(), 1) %>"
			total="<%= ServiceTransactionEntryLocalServiceUtil.searchCount(transactionCodeNumber, 0, 0, 1) %>"
		/>
	
		<liferay-ui:search-container-row className="vn.com.fis.portal.portlet.util.model.Service_Transaction_HistoryExt" 
			keyProperty="serviceTransactionHistoryId" modelVar="tran_history">
		
			<% String transactionCode = "";
				if(tran_history.getTransactionCode() == 1)
					transactionCode = "Start service";
				else 
					if(tran_history.getTransactionCode() == 2)
						transactionCode = "Stop service";
					else 
						if(tran_history.getTransactionCode() == 3)
							transactionCode = "Start service Package";
						else 
							if(tran_history.getTransactionCode() == 4)
								transactionCode = "Stop service Package";
			
				String serviceStartDate = "";
				String serviceEndDate = "";
				String servicePackageStartDate = "";
			
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			
				if(tran_history.getServiceStartDate() != null)
					serviceStartDate = dateFormat.format(tran_history.getServiceStartDate());
			
				if(tran_history.getServiceStopDate() != null)
					serviceStartDate = dateFormat.format(tran_history.getServiceStopDate());
			
				if(tran_history.getServicePackageStartDate() != null)
					servicePackageStartDate = dateFormat.format(tran_history.getServicePackageStartDate());
			
				UserEntry userEntry = UserEntryLocalServiceUtil.getUserEntry(tran_history.getUserId());
			
				long serviceId = tran_history.getServiceId();
				String serviceName = "";
			
				try{
					if(serviceId != 0)
					serviceName = ServiceEntryLocalServiceUtil.getServiceEntry(serviceId).getServiceName();
				}catch(Exception e){e.printStackTrace();}
				long servicePackageId = tran_history.getServicePackageId();
				String servicePackageName = "";
				try{
				if(servicePackageId != 0)
					servicePackageName = ServicePackageEntryLocalServiceUtil.getServicePackageEntry(servicePackageId).getServicePackageName();
				}catch(Exception e){e.printStackTrace();}
			%>
		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-transactionCode"
				value="<%= transactionCode %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-transactionDate"
				value="<%= dateFormat.format(tran_history.getTransactionDate()) %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-userId"
				value="<%= String.valueOf(tran_history.getUserId()) %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-userName"
				value="<%= userEntry.getUserName() %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-serviceId"
				value="<%= String.valueOf(serviceId) %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-serviceName"
				value="<%= serviceName %>"/>			
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-serviceStartDate"
				value="<%= serviceStartDate %>"/>			
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-serviceEndDate"
				value="<%= serviceEndDate %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-servicePackageId"
				value="<%= String.valueOf(servicePackageId) %>"/>		
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-servicePackageName"
				value="<%= servicePackageName %>"/>			
			<liferay-ui:search-container-column-text name="portlet-service_transaction_history-view-search-container-column-text-servicePackageStartDate"
				value="<%= servicePackageStartDate %>"/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator/>

	</liferay-ui:search-container>
</c:if>


