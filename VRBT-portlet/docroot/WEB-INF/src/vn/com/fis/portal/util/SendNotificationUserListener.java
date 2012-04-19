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

	@Override
	protected void doReceive(Message arg0) throws Exception {
			
		List<UserEntry> listUsers = new ArrayList<UserEntry>();
		VRBTLibrary library = new VRBTLibrary();
		
		
		if(UserEntryLocalServiceUtil.countByStatus(1) > 0)
			listUsers = UserEntryLocalServiceUtil.findByStatus(1);
		
		for (UserEntry userEntry : listUsers) {
			int userRole = 0;
			
			try {
				long[] roleList = UserLocalServiceUtil.getUser(userEntry.getUserId()).getRoleIds();				
				
				for (long l : roleList) {
					if (RoleLocalServiceUtil.getRole(l).getName().equals("Subscriber")) {
						userRole = 1;
						
						
						break;
					} else if(RoleLocalServiceUtil.getRole(l).getName().equals("Third-party")) {
						userRole = 2;
						System.out.println("third");
						break;
					}
				}
				System.out.println("user role = "+userRole);
				if (userRole == 1) {
					String month =  VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "MM");
					String day = VRBTLibrary.convertDateToString(Calendar.getInstance().getTime(), "dd");
					
					System.out.println("day= "+ day + " month" + month);
				} else if(userRole == 2) {
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
		
		/*List<Role> listRole = UserServiceUtil;
		System.out.println("listRole: "+listRole);
		for(int i=0;i<listRole.size();i++)
		{
			System.out.println("listRole[i]: "+listRole.get(i).getName());
		}*/
	}

}
