package vn.com.fis.portal.portlet.util;

import vn.com.fis.portal.portlet.util.model.NotificationExt;
import vn.com.fis.portal.portlet.util.service.NotificationExtLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.messaging.Destination;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.messaging.ParallelDestination;

public class System_Notification {
	
	public void sendNotification(long userIdForm, String subject, String messageToAdmin, String messageToUser) throws SystemException {
		Destination destination = new ParallelDestination("systemNotification");
		
		MessageBusUtil.addDestination(destination);
		
		if (!destination.register(new System_Notification_Listener()))
			MessageBusUtil.registerMessageListener("systemNotification", new System_Notification_Listener());
		
		//Create message object
		Message notificationMessage = new Message();
		
		NotificationExt notificationToAdmin = NotificationExtLocalServiceUtil.createNotificationExt(CounterLocalServiceUtil.increment());
		notificationToAdmin.setUserIdFrom(userIdForm);
		notificationToAdmin.setUserIdTo(10196);
		notificationToAdmin.setSubject(subject);
		notificationToAdmin.setMessage(messageToAdmin);
		notificationToAdmin.setStatus(1);
		
		NotificationExt notificationToUser = NotificationExtLocalServiceUtil.createNotificationExt(CounterLocalServiceUtil.increment());
		notificationToUser.setUserIdFrom(userIdForm);
		notificationToUser.setUserIdTo(userIdForm);
		notificationToUser.setSubject(subject);
		notificationToUser.setMessage(messageToUser);
		notificationToUser.setStatus(1);
		
		notificationMessage.put("notificationToAdmin", notificationToAdmin);
		notificationMessage.put("notificationToUser", notificationToUser);
		
		MessageBusUtil.sendMessage("systemNotification", notificationMessage);
	}
	
	public void sendNotificationToUser(long userIdTo, String subject, String message) throws SystemException {
		Destination destination = new ParallelDestination("notificationToUserDestination");
		
		MessageBusUtil.addDestination(destination);
		
		if (!destination.register(new SendNotificationUserListener()))
			MessageBusUtil.registerMessageListener("notificationToUserDestination", new SendNotificationUserListener());
		
		//Create message object
		Message notificationMessage = new Message();
		
		NotificationExt notificationExt = NotificationExtLocalServiceUtil.createNotificationExt(CounterLocalServiceUtil.increment());
		notificationExt.setUserIdFrom(10196);
		notificationExt.setUserIdTo(userIdTo);
		notificationExt.setSubject(subject);
		notificationExt.setMessage(message);
		notificationExt.setStatus(1);
		 
		notificationMessage.put("notificationToUser", notificationExt);
		MessageBusUtil.sendMessage("notificationToUserDestination", notificationMessage);
		
	}
}
