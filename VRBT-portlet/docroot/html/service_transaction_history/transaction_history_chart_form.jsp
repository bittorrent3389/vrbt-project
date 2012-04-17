<%@ include file="/html/init.jsp" %>

<liferay-ui:tabs names="Service Transsaction Report, Service Package Transaction Report" refresh="false">
	<liferay-ui:section>
		<%@ include file="/html/service_transaction_history/transaction_history_service_chart_form.jsp" %>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<%@ include file="/html/service_transaction_history/transaction_history_package_chart_form.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs>