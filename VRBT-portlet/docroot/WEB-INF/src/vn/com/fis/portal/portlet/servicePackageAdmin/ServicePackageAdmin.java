package vn.com.fis.portal.portlet.servicePackageAdmin;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.com.fis.portal.model.ServicePackageEntry;
import vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ServicePackageAdmin
 */
public class ServicePackageAdmin extends MVCPortlet {
	public void servicePackageSearch(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("searchType", ParamUtil.getString(actionRequest, "searchType"));
		actionResponse.setRenderParameter("servicePackageCode", ParamUtil.getString(actionRequest, "servicePackageCode"));
		actionResponse.setRenderParameter("servicePackageName", ParamUtil.getString(actionRequest, "servicePackageName"));
		actionResponse.setRenderParameter("service", ParamUtil.getString(actionRequest, "service"));
		actionResponse.setRenderParameter("status", ParamUtil.getString(actionRequest, "status"));
	}
 
	public void addServicePackage(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {

		String ser_Pac_Code = ParamUtil.getString(actionRequest, "servicePackageCode");
		String ser_Pac_Name = ParamUtil.getString(actionRequest, "servicePackageName");
		long serviceId = ParamUtil.getLong(actionRequest, "service");
		String maxSize = ParamUtil.getString(actionRequest, "maxSize");
		String description = ParamUtil.getString(actionRequest, "description");
		int status = ParamUtil.getInteger(actionRequest, "status");
		
		//check valid data
		if (!checkAddServicePackageValidator(ser_Pac_Code, ser_Pac_Name, maxSize)) {
			SessionErrors.add(actionRequest, "error-message");
			return;
		} else {
			ServicePackageEntry servicePackage = ServicePackageEntryLocalServiceUtil.createServicePackageEntry(CounterLocalServiceUtil.increment());
		
			try {
				servicePackage.setServicePackageCode(ser_Pac_Code);
				servicePackage.setServicePackageName(ser_Pac_Name);
				servicePackage.setServiceId(serviceId);
				servicePackage.setCreateDate(Calendar.getInstance().getTime());
				servicePackage.setTotalFile(Integer.valueOf(maxSize));
				servicePackage.setDescription(description);
				servicePackage.setStatus(status);
			
				ServicePackageEntryLocalServiceUtil.addServicePackageEntry(servicePackage);
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				SessionErrors.add(actionRequest, "error-add-servicePackage-message");
			}
		}
	}
	
	public void editServicePackage(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {

		long ser_Pac_Id = ParamUtil.getLong(actionRequest, "servicePackageId", 0);
		String ser_Pac_Code = ParamUtil.getString(actionRequest, "servicePackageCode");
		String ser_Pac_Name = ParamUtil.getString(actionRequest, "servicePackageName");
		long serviceId = ParamUtil.getLong(actionRequest, "service");
		String maxSize = ParamUtil.getString(actionRequest, "maxSize");
		String description = ParamUtil.getString(actionRequest, "description");
		int status = ParamUtil.getInteger(actionRequest, "status");
		
		//check valid data
		if (!checkEditServicePackageValidator(ser_Pac_Id, ser_Pac_Code, ser_Pac_Name, maxSize)) {
			SessionErrors.add(actionRequest, "error-message");
			return;
		} else {
			ServicePackageEntry servicePackage = null;
		
			try {
				servicePackage = ServicePackageEntryLocalServiceUtil.fetchServicePackageEntry(ser_Pac_Id);
				servicePackage.setServicePackageCode(ser_Pac_Code);
				servicePackage.setServicePackageName(ser_Pac_Name);
				servicePackage.setServiceId(serviceId);
				servicePackage.setModifiedDate(Calendar.getInstance().getTime());
				servicePackage.setTotalFile(Integer.valueOf(maxSize));
				servicePackage.setDescription(description);
				servicePackage.setStatus(status);
			
				ServicePackageEntryLocalServiceUtil.updateServicePackageEntry(servicePackage);
				//UserExtLocalServiceUtil.updateServicePackageName_ByServiceId(ser_Pac_Id, ser_Pac_Name);
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				SessionErrors.add(actionRequest, "error-edit-servicePackage-message");
			}
		}
	}
	
	public void deleteServicePackage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		long ser_Pac_Id = ParamUtil.getLong(actionRequest, "servicePackageId");
		
		//check valid data
		
		ServicePackageEntry servicePackage = null;
		
		try {
			servicePackage = ServicePackageEntryLocalServiceUtil.fetchServicePackageEntry(ser_Pac_Id);
			servicePackage.setModifiedDate(Calendar.getInstance().getTime());
			servicePackage.setStatus(0);
			
			ServicePackageEntryLocalServiceUtil.updateServicePackageEntry(servicePackage);
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error-delete-servicePackage-message");
		}
	}
	
	private boolean checkAddServicePackageValidator(
			String servicePackageCode, String servicePackageName, String maxSize) throws SystemException {
			
			boolean isValidCode = false;
			boolean isValidName = false;
			boolean isValidMaxSize = false;
				
			
			ServicePackageEntry servicePackageCheckCode = null;
			ServicePackageEntry servicePackageCheckName = null;
			
			try {
				 servicePackageCheckCode = ServicePackageEntryLocalServiceUtil.findByservicePackageCode(servicePackageCode);
			} catch (Exception e) {
				servicePackageCheckCode = null;
			}
			
			try {
				servicePackageCheckName = 
						ServicePackageEntryLocalServiceUtil.findByservicePackageName(servicePackageName);
			} catch (Exception e) {
				servicePackageCheckName = null;
			}
			
			//Check Service Package Code is valid or not
			if (servicePackageCheckCode == null)
				isValidCode = true;
			
			//Check service Package Name is valid or not
			if (servicePackageCheckName == null)
				isValidName = true;;
				
			//If service Package Code & service Package Name are not the same other record in db => return true
			if (isValidCode && isValidName) {
				 return true;
			}
			
			return false;
		}
		
		private boolean checkEditServicePackageValidator(
				long servicePackageId, String servicePackageCode, String servicePackageName, String maxSize) throws SystemException {
			
			if(servicePackageId != 0){
				
				boolean isValidCode = false;
				boolean isValidName = false;
				boolean isValidMaxSize = false;
				
				ServicePackageEntry servicePackageCheckCode = null;
				ServicePackageEntry servicePackageCheckName = null;
				
				try {
					 servicePackageCheckCode = ServicePackageEntryLocalServiceUtil.findByservicePackageCode(servicePackageCode);
				} catch (Exception e) {
					servicePackageCheckCode = null;
				}
				
				try {
					servicePackageCheckName = 
							ServicePackageEntryLocalServiceUtil.findByservicePackageName(servicePackageName);
				} catch (Exception e) {
					servicePackageCheckName = null;
				}
					
				//Check Service Package Code is valid or not
				if (servicePackageCheckCode != null) {					
					if (servicePackageCheckCode.getServicePackageId() == servicePackageId)
						isValidCode = true;
					
				}else if (servicePackageCheckCode == null) {
					isValidCode = true;
				}
				
				//Check service Package Name is valid or not
				if (servicePackageCheckName != null) {
					
					if (servicePackageCheckName.getServicePackageId() == servicePackageId)
						isValidName = true;
					
				}else if (servicePackageCheckName == null) {
					isValidName = true;
				}
				
				//If service Package Code & service Package Name are not the same other record in db => return true
				if (isValidCode && isValidName) {
					 return true;
				}
			}
			
			return false;
		}

}
