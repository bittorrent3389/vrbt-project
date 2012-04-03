package vn.com.fis.portal.portlet.util;
import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.service.NotificationEntryLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

public class SendNotificationUserListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		NotificationEntry notificationToAdmin = (NotificationEntry) message.get("notificationToUser");
		
		NotificationEntryLocalServiceUtil.addNotificationEntry(notificationToAdmin);
		
	}

}
