package vn.com.fis.portal.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vn.com.fis.portal.VRBTLibrary;
import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserTransactionEntryLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class SendNotificationUserListener extends BaseMessageListener {
	
	/**
	 * Follow time in scheduler-entry,system will automatic send notification to 
	 *  third-party and subscriber. 
	 *  - Third-party receives a confirm about total money he earned form upload video in month.
	 *  - Subscriber receives a confirm about total payment for bought video in month
	 *  */
	@Override
	protected void doReceive(Message arg0) throws Exception {
			
		List<UserEntry> listUsers = new ArrayList<UserEntry>();		
		
		//select all active user in DB
		if(UserEntryLocalServiceUtil.countByStatus(1) > 0)
			listUsers = UserEntryLocalServiceUtil.findByStatus(1);
		
		for (UserEntry userEntry : listUsers) {
			int userRole = 0;
			
			//Check is user has third-party role or subscriber role.
			try {
				long[] roleList = UserLocalServiceUtil.getUser(userEntry.getUserId()).getRoleIds();				
				
				for (long l : roleList) {
					if (RoleLocalServiceUtil.getRole(l).getName().equals("Subscriber")) {
						userRole = 1;
						break;
						
					} else if(RoleLocalServiceUtil.getRole(l).getName().equals("Third-party")) {
						userRole = 2;
						break;
					}
				}
				
				//Send notification if user is subscriber
				if (userRole == 1) {
					String year =  VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "yyyy");
					String month =  VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "MM");
					String date = VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "dd");
					String startMonth = String.valueOf(Integer.valueOf(month) - 1);
					String startYear = year;
					
					if (month.equals("1")) {
						startMonth = "12";
						startYear = String.valueOf(Integer.valueOf(startYear) - 1);
					}
					
					long purchased = 
							VideoUserTransactionEntryLocalServiceUtil.getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(userEntry.getUserId(), 
									2, date+"/"+startMonth+"/"+startYear , date+"/"+month+"/"+year);
					
					String message = "Your total payment is "+(purchased*3000)+".";
					new System_Notification().sendNotificationToUser(userEntry.getUserId(), "Total payment in month", message);
					
				}
				//send notification if user is third-party
				else if(userRole == 2) {
					String year =  VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "yyyy");
					String month =  VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "MM");
					String date = VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "dd");
					String startMonth = String.valueOf(Integer.valueOf(month) - 1);
					String startYear = year;
					
					if (month.equals("1")) {
						startMonth = "12";
						startYear = String.valueOf(Integer.valueOf(startYear) - 1);
					}
					
					long purchased = 
						VideoUserTransactionEntryLocalServiceUtil.getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(userEntry.getUserId(), 
								2, date+"/"+startMonth+"/"+startYear , date+"/"+month+"/"+year);
					
					String message = "Your total sale is "+(purchased*500)+".";
					new System_Notification().sendNotificationToUser(userEntry.getUserId(), "Total sale in month", message);
				}
			} catch (Exception e) {}			
		}
	}

}
