package vn.com.fis.portal.portlet.subscriber_ServiceMng;

import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.fis.portal.model.ServiceTransactionEntry;
import vn.com.fis.portal.service.ServiceTransactionEntryLocalServiceUtil;

public class Add_Transaction_History {
	public static int START_SERVICE_CODE = 1;
	public static int STOP_SERVICE_CODE = 2;
	public static int REMOVE_SERVICE_CODE = 3;
	public static int START_SERVICE_PACKAGE_CODE = 4;
	public static int STOP_SERVICE_PACKAGE_CODE = 5;
	
	public static void addService_Transaction_History(int transactionCode, Date transactionDate, long userId,
			long serviceId, int serviceStatus, Date serviceStartDate, Date serviceStopDate,
			long servicePackageId, Date servicePackageStartDate) throws SystemException {
		
		ServiceTransactionEntry transaction = 
				ServiceTransactionEntryLocalServiceUtil.createServiceTransactionEntry(CounterLocalServiceUtil.increment());
		
		transaction.setTransactionCode(transactionCode);
		transaction.setDate_(transactionDate);
		transaction.setUserId(userId);
		transaction.setServiceId(serviceId);
		transaction.setServiceStatus(serviceStatus);
		transaction.setServiceStartDate(serviceStartDate);
		transaction.setServiceStopDate(serviceStopDate);
		transaction.setServicePackageId(servicePackageId);
		transaction.setPackageDate(servicePackageStartDate);
		
		ServiceTransactionEntryLocalServiceUtil.addServiceTransactionEntry(transaction);
	}
}
