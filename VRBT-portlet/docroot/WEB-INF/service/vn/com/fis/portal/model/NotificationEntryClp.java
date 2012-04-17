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

package vn.com.fis.portal.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.com.fis.portal.service.NotificationEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class NotificationEntryClp extends BaseModelImpl<NotificationEntry>
	implements NotificationEntry {
	public NotificationEntryClp() {
	}

	public Class<?> getModelClass() {
		return NotificationEntry.class;
	}

	public String getModelClassName() {
		return NotificationEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _notificationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setNotificationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_notificationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getNotificationId() {
		return _notificationId;
	}

	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;
	}

	public long getUserIdFrom() {
		return _userIdFrom;
	}

	public void setUserIdFrom(long userIdFrom) {
		_userIdFrom = userIdFrom;
	}

	public long getUserIdTo() {
		return _userIdTo;
	}

	public void setUserIdTo(long userIdTo) {
		_userIdTo = userIdTo;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			NotificationEntryLocalServiceUtil.addNotificationEntry(this);
		}
		else {
			NotificationEntryLocalServiceUtil.updateNotificationEntry(this);
		}
	}

	@Override
	public NotificationEntry toEscapedModel() {
		return (NotificationEntry)Proxy.newProxyInstance(NotificationEntry.class.getClassLoader(),
			new Class[] { NotificationEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NotificationEntryClp clone = new NotificationEntryClp();

		clone.setNotificationId(getNotificationId());
		clone.setUserIdFrom(getUserIdFrom());
		clone.setUserIdTo(getUserIdTo());
		clone.setSubject(getSubject());
		clone.setMessage(getMessage());
		clone.setCreateDate(getCreateDate());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(NotificationEntry notificationEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				notificationEntry.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		NotificationEntryClp notificationEntry = null;

		try {
			notificationEntry = (NotificationEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = notificationEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{notificationId=");
		sb.append(getNotificationId());
		sb.append(", userIdFrom=");
		sb.append(getUserIdFrom());
		sb.append(", userIdTo=");
		sb.append(getUserIdTo());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.NotificationEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificationId</column-name><column-value><![CDATA[");
		sb.append(getNotificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdFrom</column-name><column-value><![CDATA[");
		sb.append(getUserIdFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdTo</column-name><column-value><![CDATA[");
		sb.append(getUserIdTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _notificationId;
	private long _userIdFrom;
	private long _userIdTo;
	private String _subject;
	private String _message;
	private Date _createDate;
	private int _status;
}