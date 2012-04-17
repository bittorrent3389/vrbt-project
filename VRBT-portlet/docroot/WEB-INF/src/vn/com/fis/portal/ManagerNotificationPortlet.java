package vn.com.fis.portal;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.service.NotificationEntryLocalServiceUtil;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class ManagerNotificationPortlet
 */
public class ManagerNotificationPortlet extends MVCPortlet {
 
	private static Log log = LogFactoryUtil.getLog(ManagerNotificationPortlet.class);
	
	public void sendNotification(ActionRequest actionRequest,
			ActionResponse actionResponse){
		try
		{
			NotificationEntry notificationEntry = null;
			try {
				notificationEntry = NotificationEntryLocalServiceUtil.createNotificationEntry(CounterLocalServiceUtil.increment());
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				log.error(e);
				SessionErrors.add(actionRequest,"send-notification-fail");
			}
			
			UserEntry userEntry=null;
			long userId=Integer.parseInt(ParamUtil.getString(actionRequest, "UserIdFrom"));
			notificationEntry.setUserIdFrom(userId);
			try
			{
				userEntry = UserEntryLocalServiceUtil.getUserEntryByUserName(ParamUtil.getString(actionRequest, "UserTo"));
				notificationEntry.setUserIdTo(userEntry.getUserId());
			}
			catch(Exception e)
			{
				log.error(e);
				SessionErrors.add(actionRequest,"notification-user-to-fail");
			}
			
			
			//--------------------userfromid usertoId------------------------------
			String subject = ParamUtil.getString(actionRequest, "Subject")+"";
			if(subject.equals("null")||subject.equals("")||subject.equals(" "))
			{
				SessionErrors.add(actionRequest,"notification-subject-fail");
				
			}
			else
			{
				notificationEntry.setSubject(ParamUtil.getString(actionRequest, "Subject"));
			}
			notificationEntry.setMessage(ParamUtil.getString(actionRequest, "Message"));
			Date date = new Date();
			
			notificationEntry.setCreateDate(date);
			try {
				NotificationEntryLocalServiceUtil.updateNotificationEntry(notificationEntry);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				log.error(e);
				SessionErrors.add(actionRequest,"send-notification-fail");
				
			}
		}
		catch(Exception e)
		{
			log.error(e);
			SessionErrors.add(actionRequest,"send-notification-fail");
		}
		actionResponse.setRenderParameter("jspPage",
				"/html/managernotificationportlet/SendNotification.jsp");
	}
		
}
