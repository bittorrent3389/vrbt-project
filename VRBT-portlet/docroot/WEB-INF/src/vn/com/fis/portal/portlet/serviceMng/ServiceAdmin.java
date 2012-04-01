package vn.com.fis.portal.portlet.serviceMng;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.com.fis.portal.model.ServiceEntry;
import vn.com.fis.portal.model.ServicePackageEntry;
import vn.com.fis.portal.service.ServiceEntryLocalService;
import vn.com.fis.portal.service.ServiceEntryLocalServiceUtil;
import vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ServiceAdmin
 */
public class ServiceAdmin extends MVCPortlet {
	
	public void serviceSearch(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		actionResponse.setRenderParameter("searchType", ParamUtil.getString(actionRequest, "searchType"));
		actionResponse.setRenderParameter("serviceCode", ParamUtil.getString(actionRequest, "serviceCode"));
		actionResponse.setRenderParameter("serviceName", ParamUtil.getString(actionRequest, "serviceName"));
		actionResponse.setRenderParameter("status", ParamUtil.getString(actionRequest, "status"));
	}
	
	public void addService(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		
		String serviceCode = ParamUtil.getString(actionRequest, "serviceCode");
		String serviceName = ParamUtil.getString(actionRequest, "serviceName");
		String description = ParamUtil.getString(actionRequest, "description");
		int status = ParamUtil.getInteger(actionRequest, "status");
		
		//check valid data
		if (!checkAddServiceValidator(serviceCode, serviceName)) {
			SessionErrors.add(actionRequest, "error-message");
			return;
		}
		else{
			ServiceEntry serviceEntry = ServiceEntryLocalServiceUtil.createServiceEntry(CounterLocalServiceUtil.increment());
		
			try {
				serviceEntry.setServiceCode(serviceCode);
				serviceEntry.setServiceName(serviceName);
				serviceEntry.setCreateDate(Calendar.getInstance().getTime());
				serviceEntry.setDescription(description);
				serviceEntry.setStatus(status);
				ServiceEntryLocalServiceUtil.addServiceEntry(serviceEntry);
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				SessionErrors.add(actionRequest, "error-add-service-message");
			}
		}		
	}
	
	public void editService(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, SystemException {
		long serviceId = ParamUtil.getInteger(actionRequest, "serviceId", 0);
		String serviceCode = ParamUtil.getString(actionRequest, "serviceCode");
		String serviceName = ParamUtil.getString(actionRequest, "serviceName");
		String description = ParamUtil.getString(actionRequest, "description");
		int status = ParamUtil.getInteger(actionRequest, "status");
		
		//check valid data
		if (!checkEditServiceValidator(serviceId, serviceCode, serviceName)) {
			SessionErrors.add(actionRequest, "error-message");
			return;
		} else {
			ServiceEntry serviceExt = null;
			try {
				serviceExt = ServiceEntryLocalServiceUtil.fetchServiceEntry(serviceId);
				serviceExt.setServiceCode(serviceCode);
				serviceExt.setServiceName(serviceName);
				serviceExt.setModifiedDate(Calendar.getInstance().getTime());
				serviceExt.setDescription(description);
				serviceExt.setStatus(status);
			
				ServiceEntryLocalServiceUtil.updateServiceEntry(serviceExt);	
				//UserEntryLocalServiceUtil.updateServiceName_ByServiceId(serviceId, serviceName);
			} 
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				SessionErrors.add(actionRequest, "error-edit-service-message");
			}
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirect"));
		}
	}
	
	public void deleteService(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		
		long serviceId = ParamUtil.getInteger(actionRequest, "serviceId");
		
		//check valid data
		
		ServiceEntry serviceEntry = null;
		try {
			serviceEntry = ServiceEntryLocalServiceUtil.fetchServiceEntry(serviceId);
			serviceEntry.setModifiedDate(Calendar.getInstance().getTime());
			serviceEntry.setStatus(0);
			
			ServiceEntryLocalServiceUtil.updateServiceEntry(serviceEntry);
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			SessionErrors.add(actionRequest, "error-delete-service-message");
		}
		
		if (SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirect"));
		}
	}
	
public boolean checkAddServiceValidator(String serviceCode, String serviceName) throws SystemException {
		
		boolean isValidCode = false;
		boolean isValidName = false;
			
		ServiceEntry serviceCheckCode = null;
		ServiceEntry serviceCheckName = null;
		
		try {
			 serviceCheckCode = ServiceEntryLocalServiceUtil.findByserviceCode(serviceCode);
		} catch (Exception e) {
			serviceCheckCode = null;
		}
		
		try {
			serviceCheckName = ServiceEntryLocalServiceUtil.findByserviceName(serviceName);
		} catch (Exception e) {
			serviceCheckName = null;
		}
				
		//Check Service Code is valid or not
		if (serviceCheckCode == null)
			isValidCode = true;
			
		//Check service Name is valid or not
		if (serviceCheckName == null)
			isValidName = true;
			
		//If service Code & service Name are not the same other record in db => return true
		if (isValidCode && isValidName) {
			 return true;
		}
		
		return false;
	}
	
	public boolean checkEditServiceValidator(long serviceId, String serviceCode, String serviceName) throws SystemException {
		
		if(serviceId != 0){
			
			boolean isValidCode = false;
			boolean isValidName = false;
			
			ServiceEntry serviceCheckCode = null;
			ServiceEntry serviceCheckName = null;
			
			try {
				 serviceCheckCode = ServiceEntryLocalServiceUtil.findByserviceCode(serviceCode);
			} catch (Exception e) {
				serviceCheckCode = null;
			}
			
			try {
				serviceCheckName = ServiceEntryLocalServiceUtil.findByserviceName(serviceName);
			} catch (Exception e) {
				serviceCheckName = null;
			}
			
			//Check Service Code is valid or not
			if (serviceCheckCode != null) {
				if (serviceCheckCode.getServiceId() == serviceId)
					isValidCode = true;
				
			}else if (serviceCheckCode == null) {
				isValidCode = true;
			}
			
			//Check service Name is valid or not
			if (serviceCheckName != null) {
				if (serviceCheckName.getServiceId() == serviceId)
					isValidName = true;
				
			}else if (serviceCheckName == null) {
				isValidName = true;
			}
			
			//If service Code & service Name are not the same other record in db => return true
			if (isValidCode && isValidName) {
				 return true;
			}
		}
		
		return false;
	}

}
