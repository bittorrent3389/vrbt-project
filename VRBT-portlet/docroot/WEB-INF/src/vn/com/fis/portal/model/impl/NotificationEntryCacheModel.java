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

package vn.com.fis.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.fis.portal.model.NotificationEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing NotificationEntry in entity cache.
 *
 * @author loind
 * @see NotificationEntry
 * @generated
 */
public class NotificationEntryCacheModel implements CacheModel<NotificationEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{notificationId=");
		sb.append(notificationId);
		sb.append(", userIdFrom=");
		sb.append(userIdFrom);
		sb.append(", userIdTo=");
		sb.append(userIdTo);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", message=");
		sb.append(message);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public NotificationEntry toEntityModel() {
		NotificationEntryImpl notificationEntryImpl = new NotificationEntryImpl();

		notificationEntryImpl.setNotificationId(notificationId);
		notificationEntryImpl.setUserIdFrom(userIdFrom);
		notificationEntryImpl.setUserIdTo(userIdTo);

		if (subject == null) {
			notificationEntryImpl.setSubject(StringPool.BLANK);
		}
		else {
			notificationEntryImpl.setSubject(subject);
		}

		if (message == null) {
			notificationEntryImpl.setMessage(StringPool.BLANK);
		}
		else {
			notificationEntryImpl.setMessage(message);
		}

		if (createDate == Long.MIN_VALUE) {
			notificationEntryImpl.setCreateDate(null);
		}
		else {
			notificationEntryImpl.setCreateDate(new Date(createDate));
		}

		notificationEntryImpl.setStatus(status);

		notificationEntryImpl.resetOriginalValues();

		return notificationEntryImpl;
	}

	public long notificationId;
	public long userIdFrom;
	public long userIdTo;
	public String subject;
	public String message;
	public long createDate;
	public int status;
}