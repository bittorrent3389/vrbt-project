package vn.com.fis.portal.util;

import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.service.NotificationEntryLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

public class System_Notification_Listener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		NotificationEntry notificationToAdmin = (NotificationEntry) message.get("notificationToAdmin");
		NotificationEntry notificationToUser = (NotificationEntry) message.get("notificationToUser");
		
		System.out.println("================");
		System.out.println(notificationToAdmin.getCreateDate());
		System.out.println(notificationToUser.getCreateDate());
		
		NotificationEntryLocalServiceUtil.addNotificationEntry(notificationToAdmin);
		NotificationEntryLocalServiceUtil.addNotificationEntry(notificationToUser);
	}

}
