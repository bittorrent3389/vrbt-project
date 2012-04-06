package vn.com.fis.portal.portlet.subscriber_ServiceMng;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.com.fis.portal.model.ServiceEntry;
import vn.com.fis.portal.model.ServicePackageEntry;
import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.model.UserServiceEntry;
import vn.com.fis.portal.portlet.util.System_Notification;
import vn.com.fis.portal.service.ServiceEntryLocalServiceUtil;
import vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import vn.com.fis.portal.service.UserServiceEntryLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Subscriber_ServiceMng
 */
public class Subscriber_ServiceMng extends MVCPortlet {
	public void registrationService(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		
		long serviceId = ParamUtil.getLong(actionRequest, "serviceId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		String isUse = ParamUtil.getString(actionRequest, "isUse");
		
		try {
			UserEntry user = UserEntryLocalServiceUtil.fetchUserEntry(userId);
			ServiceEntry service = ServiceEntryLocalServiceUtil.fetchServiceEntry(serviceId);
			
			if (isUse.equalsIgnoreCase("1")) {
				UserServiceEntry userService = UserServiceEntryLocalServiceUtil.findByUserId_ServiceId(userId, serviceId);
				
				userService.setServiceStopDate(Calendar.getInstance().getTime());
				userService.setServiceStatus(2);
				
				UserServiceEntryLocalServiceUtil.updateUserServiceEntry(userService);
				
				Add_Transaction_History.addService_Transaction_History(Add_Transaction_History.STOP_SERVICE_CODE, 
						Calendar.getInstance().getTime(), userId, serviceId, 2, null, userService.getServiceStopDate(), 0, null);
				
				//Send notification to admin (TEST Account)
				String subject = user.getUserName()
									+ " stoped to use '"
									+  service.getServiceName() +"' service";
				String messageToAdmin = "User ID: "+ userId 
									+"; Username: "+ user.getUserName() 
									+"; Service stoped: "+ service.getServiceName() +"' service.";
				String messageToUser = " Stoped "+ service.getServiceName() +"' service.";
				
				new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
				
			}else if (isUse.equalsIgnoreCase("0")) {
				UserServiceEntry userService = 
						UserServiceEntryLocalServiceUtil.createUserServiceEntry(CounterLocalServiceUtil.increment());
				
				userService.setServiceId(serviceId);
				userService.setServiceStartDate(Calendar.getInstance().getTime());
				userService.setServiceStatus(1);
				userService.setUserId(userId);
				
				UserServiceEntryLocalServiceUtil.addUserServiceEntry(userService);
				
				Add_Transaction_History.addService_Transaction_History(Add_Transaction_History.START_SERVICE_CODE, 
						Calendar.getInstance().getTime(), userId, serviceId, 1, userService.getServiceStartDate(), null, 0, null);
				
				//Send notification to admin (TEST Account)
				String subject = user.getUserName()
									+ " started to use '"
									+  service.getServiceName() +"' service";
				String messageToAdmin = "User ID: "+ userId 
									+"; Username: "+ user.getUserName() 
									+"; Service started to use: "+ service.getServiceName() +"' service.";
				String messageToUser = "Started "+ service.getServiceName() +"' service.";
				
				new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "service-add-error");
		}
		
	/*	if (SessionErrors.isEmpty(actionRequest)) {
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "curRedirect"));
		}*/
		
		//actionResponse.setRenderParameter("jspPage", ParamUtil.getString(actionRequest, "jspPage"));
		
	}
	
	public void registrationServicePackage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		long serviceId = ParamUtil.getLong(actionRequest, "serviceId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		try {
			UserServiceEntry userService = null;
			try{
				userService = UserServiceEntryLocalServiceUtil.findByUserId_ServiceId(userId, serviceId);
			}catch (Exception e) {
				userService = null;
				System.out.println("No User service record found for registrationServicePackage");
			}
			
			ServiceEntry service = ServiceEntryLocalServiceUtil.fetchServiceEntry(serviceId);
			long packageId = ParamUtil.getLong(actionRequest, service.getServiceName(), 0);
			
			if (packageId != 0)
				if(userService == null){
					userService = UserServiceEntryLocalServiceUtil.createUserServiceEntry(CounterLocalServiceUtil.increment());
					
					userService.setUserId(userId);
					userService.setServiceId(serviceId);
					userService.setServicePackageId(packageId);
					userService.setPackageDate(Calendar.getInstance().getTime());
					
					UserServiceEntryLocalServiceUtil.addUserServiceEntry(userService);
				}
				
				if(userService != null && userService.getServicePackageId() != packageId){			
					userService.setUserId(userId);
					userService.setServiceId(serviceId);
					userService.setServicePackageId(packageId);
					userService.setPackageDate(Calendar.getInstance().getTime());
					
					UserServiceEntryLocalServiceUtil.updateUserServiceEntry(userService);
				}
				
				ServicePackageEntry packageExt = ServicePackageEntryLocalServiceUtil.fetchServicePackageEntry(packageId);
				
				Add_Transaction_History.addService_Transaction_History(Add_Transaction_History.START_UPLOAD_PACKAGE_CODE, 
						Calendar.getInstance().getTime(), userId, 0, 0, null, null, packageId, userService.getPackageDate());
					
					//Send notification to admin (TEST Account)
					String subject = UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() 
										+ " started to use '"
										+  packageExt.getServicePackageName()+"' service Package";
					String messageToAdmin = "User ID: "+ userId 
										+"; Username: "+ UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() 
										+"; Service Package started to use: "+ packageExt.getServicePackageName()+"' service Package";
					String messageToUser = "Started "+ packageExt.getServicePackageName()+"' service Package";
				
					new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
			
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "service-add-error");
		}
	}
	
	public void removeServicePackage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortalException, SystemException {
		long userId = ParamUtil.getLong(actionRequest, "userId");
		long serviceId = ParamUtil.getLong(actionRequest, "serviceId");
		long packageId = ParamUtil.getLong(actionRequest, "packageId", 0);
	
		try {
			if(packageId == 0)
				packageId = ParamUtil.getLong(actionRequest, ServiceEntryLocalServiceUtil.getServiceEntry(serviceId).getServiceName(), 0);
			
			UserServiceEntry userService = null;
			userService = UserServiceEntryLocalServiceUtil.findByUserId_ServiceId_PackageId(userId, serviceId, packageId);
			
			if(packageId > 0){
				userService.setServicePackageId(0);
				userService.setPackageDate(null);
				
				UserServiceEntryLocalServiceUtil.updateUserServiceEntry(userService);
				
				Add_Transaction_History.addService_Transaction_History(Add_Transaction_History.STOP_UPLOAD_SERVICE_PACKAGE_CODE, 
						Calendar.getInstance().getTime(), userId, 0, 0, null, null, packageId, null);
				
				//Send notification to admin (TEST Account)
				String subject = UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() 
									+ " stoped to use '"
									+  ServicePackageEntryLocalServiceUtil.getServicePackageEntry(packageId).getServicePackageName() +"' service Package";
				String messageToAdmin = "User ID: "+ userId 
									+"; Username: "+ UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() 
									+"; Service Package stoped: "+ ServicePackageEntryLocalServiceUtil.getServicePackageEntry(packageId).getServicePackageName() 
									+"' service Package";
				String messageToUser = "Stoped '"+ ServicePackageEntryLocalServiceUtil.getServicePackageEntry(packageId).getServicePackageName() 
						+"' service Package";
				
				new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(actionRequest, "service-add-error");
		}
	}
}
