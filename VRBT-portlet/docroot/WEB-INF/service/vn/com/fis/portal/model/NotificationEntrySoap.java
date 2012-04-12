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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.NotificationEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.NotificationEntryServiceSoap
 * @generated
 */
public class NotificationEntrySoap implements Serializable {
	public static NotificationEntrySoap toSoapModel(NotificationEntry model) {
		NotificationEntrySoap soapModel = new NotificationEntrySoap();

		soapModel.setNotificationId(model.getNotificationId());
		soapModel.setUserIdFrom(model.getUserIdFrom());
		soapModel.setUserIdTo(model.getUserIdTo());
		soapModel.setSubject(model.getSubject());
		soapModel.setMessage(model.getMessage());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static NotificationEntrySoap[] toSoapModels(
		NotificationEntry[] models) {
		NotificationEntrySoap[] soapModels = new NotificationEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NotificationEntrySoap[][] toSoapModels(
		NotificationEntry[][] models) {
		NotificationEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NotificationEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new NotificationEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NotificationEntrySoap[] toSoapModels(
		List<NotificationEntry> models) {
		List<NotificationEntrySoap> soapModels = new ArrayList<NotificationEntrySoap>(models.size());

		for (NotificationEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NotificationEntrySoap[soapModels.size()]);
	}

	public NotificationEntrySoap() {
	}

	public long getPrimaryKey() {
		return _notificationId;
	}

	public void setPrimaryKey(long pk) {
		setNotificationId(pk);
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

	private long _notificationId;
	private long _userIdFrom;
	private long _userIdTo;
	private String _subject;
	private String _message;
	private Date _createDate;
	private int _status;
}