package vn.com.fis.portal.portlet.util;

import vn.com.fis.portal.portlet.util.model.NotificationExt;
import vn.com.fis.portal.portlet.util.service.NotificationExtLocalServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

public class SendNotificationUserListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		// TODO Auto-generated method stub
		NotificationExt notificationToAdmin = (NotificationExt) message.get("notificationToUser");
		
		NotificationExtLocalServiceUtil.addNotificationExt(notificationToAdmin);
		
	}

}
