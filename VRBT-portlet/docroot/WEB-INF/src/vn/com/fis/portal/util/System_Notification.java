package vn.com.fis.portal.util;

import java.util.Calendar;

import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.portlet.util.SendNotificationUserListener;
import vn.com.fis.portal.service.NotificationEntryLocalServiceUtil;

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
		System.out.println("SEND NOTIFICATION");
		//Create message object
		Message notificationMessage = new Message();
		
		NotificationEntry notificationToAdmin = NotificationEntryLocalServiceUtil.createNotificationEntry(CounterLocalServiceUtil.increment());
		notificationToAdmin.setUserIdFrom(userIdForm);
		notificationToAdmin.setUserIdTo(10196);
		notificationToAdmin.setSubject(subject);
		notificationToAdmin.setMessage(messageToAdmin);
		notificationToAdmin.setCreateDate(Calendar.getInstance().getTime());
		notificationToAdmin.setStatus(1);
		System.out.println("SEND NOTIFICATION");
		NotificationEntry notificationToUser = NotificationEntryLocalServiceUtil.createNotificationEntry(CounterLocalServiceUtil.increment());
		notificationToUser.setUserIdFrom(userIdForm);
		notificationToUser.setUserIdTo(userIdForm);
		notificationToUser.setSubject(subject);
		notificationToUser.setMessage(messageToUser);
		notificationToUser.setCreateDate(Calendar.getInstance().getTime());
		notificationToUser.setStatus(1);
		
		System.out.println("OKIIIIIIIIIIIIIIIIII");
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
		
		NotificationEntry notificationEntry = NotificationEntryLocalServiceUtil.createNotificationEntry(CounterLocalServiceUtil.increment());
		notificationEntry.setUserIdFrom(10196);
		notificationEntry.setUserIdTo(userIdTo);
		notificationEntry.setSubject(subject);
		notificationEntry.setMessage(message);
		notificationEntry.setCreateDate(Calendar.getInstance().getTime());
		notificationEntry.setStatus(1);
		 
		notificationMessage.put("notificationToUser", notificationEntry);
		MessageBusUtil.sendMessage("notificationToUserDestination", notificationMessage);
		
	}
}
