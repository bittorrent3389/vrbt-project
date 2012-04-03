/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.com.fis.portal.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import vn.com.fis.portal.service.CategoryEntryLocalServiceUtil;
import vn.com.fis.portal.service.CategoryEntryServiceUtil;
import vn.com.fis.portal.service.CategoryVideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.CategoryVideoEntryServiceUtil;
import vn.com.fis.portal.service.ClpSerializer;
import vn.com.fis.portal.service.ContactEntryLocalServiceUtil;
import vn.com.fis.portal.service.ContactEntryServiceUtil;
import vn.com.fis.portal.service.ContactGroupContactEntryLocalServiceUtil;
import vn.com.fis.portal.service.ContactGroupContactEntryServiceUtil;
import vn.com.fis.portal.service.ContactGroupEntryLocalServiceUtil;
import vn.com.fis.portal.service.ContactGroupEntryServiceUtil;
import vn.com.fis.portal.service.ContactGroupVideoGroupEntryLocalServiceUtil;
import vn.com.fis.portal.service.ContactGroupVideoGroupEntryServiceUtil;
import vn.com.fis.portal.service.FolderEntryLocalServiceUtil;
import vn.com.fis.portal.service.FolderEntryServiceUtil;
import vn.com.fis.portal.service.NotificationEntryLocalServiceUtil;
import vn.com.fis.portal.service.NotificationEntryServiceUtil;
import vn.com.fis.portal.service.RatingEntryLocalServiceUtil;
import vn.com.fis.portal.service.RatingEntryServiceUtil;
import vn.com.fis.portal.service.ServiceEntryLocalServiceUtil;
import vn.com.fis.portal.service.ServiceEntryServiceUtil;
import vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil;
import vn.com.fis.portal.service.ServicePackageEntryServiceUtil;
import vn.com.fis.portal.service.ServiceTransactionEntryLocalServiceUtil;
import vn.com.fis.portal.service.ServiceTransactionEntryServiceUtil;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import vn.com.fis.portal.service.UserEntryServiceUtil;
import vn.com.fis.portal.service.UserServiceEntryLocalServiceUtil;
import vn.com.fis.portal.service.UserServiceEntryServiceUtil;
import vn.com.fis.portal.service.VideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoEntryServiceUtil;
import vn.com.fis.portal.service.VideoGroupEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoGroupEntryServiceUtil;
import vn.com.fis.portal.service.VideoUserContactEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserContactEntryServiceUtil;
import vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserEntryServiceUtil;
import vn.com.fis.portal.service.VideoUserTransactionEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserTransactionEntryServiceUtil;
import vn.com.fis.portal.service.VideoUserVideoGroupEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserVideoGroupEntryServiceUtil;
import vn.com.fis.portal.service.ViolationEntryLocalServiceUtil;
import vn.com.fis.portal.service.ViolationEntryServiceUtil;
import vn.com.fis.portal.service.ViolationVideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.ViolationVideoEntryServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CategoryEntryLocalServiceUtil.clearService();

			CategoryEntryServiceUtil.clearService();
			CategoryVideoEntryLocalServiceUtil.clearService();

			CategoryVideoEntryServiceUtil.clearService();
			ContactEntryLocalServiceUtil.clearService();

			ContactEntryServiceUtil.clearService();
			ContactGroupContactEntryLocalServiceUtil.clearService();

			ContactGroupContactEntryServiceUtil.clearService();
			ContactGroupEntryLocalServiceUtil.clearService();

			ContactGroupEntryServiceUtil.clearService();
			ContactGroupVideoGroupEntryLocalServiceUtil.clearService();

			ContactGroupVideoGroupEntryServiceUtil.clearService();
			FolderEntryLocalServiceUtil.clearService();

			FolderEntryServiceUtil.clearService();
			NotificationEntryLocalServiceUtil.clearService();

			NotificationEntryServiceUtil.clearService();
			RatingEntryLocalServiceUtil.clearService();

			RatingEntryServiceUtil.clearService();
			ServiceEntryLocalServiceUtil.clearService();

			ServiceEntryServiceUtil.clearService();
			ServicePackageEntryLocalServiceUtil.clearService();

			ServicePackageEntryServiceUtil.clearService();
			ServiceTransactionEntryLocalServiceUtil.clearService();

			ServiceTransactionEntryServiceUtil.clearService();
			UserEntryLocalServiceUtil.clearService();

			UserEntryServiceUtil.clearService();
			UserServiceEntryLocalServiceUtil.clearService();

			UserServiceEntryServiceUtil.clearService();
			VideoEntryLocalServiceUtil.clearService();

			VideoEntryServiceUtil.clearService();
			VideoGroupEntryLocalServiceUtil.clearService();

			VideoGroupEntryServiceUtil.clearService();
			VideoUserContactEntryLocalServiceUtil.clearService();

			VideoUserContactEntryServiceUtil.clearService();
			VideoUserEntryLocalServiceUtil.clearService();

			VideoUserEntryServiceUtil.clearService();
			VideoUserTransactionEntryLocalServiceUtil.clearService();

			VideoUserTransactionEntryServiceUtil.clearService();
			VideoUserVideoGroupEntryLocalServiceUtil.clearService();

			VideoUserVideoGroupEntryServiceUtil.clearService();
			ViolationEntryLocalServiceUtil.clearService();

			ViolationEntryServiceUtil.clearService();
			ViolationVideoEntryLocalServiceUtil.clearService();

			ViolationVideoEntryServiceUtil.clearService();
		}
	}
}