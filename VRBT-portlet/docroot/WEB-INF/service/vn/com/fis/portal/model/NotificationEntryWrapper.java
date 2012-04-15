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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NotificationEntry}.
 * </p>
 *
 * @author    loind
 * @see       NotificationEntry
 * @generated
 */
public class NotificationEntryWrapper implements NotificationEntry,
	ModelWrapper<NotificationEntry> {
	public NotificationEntryWrapper(NotificationEntry notificationEntry) {
		_notificationEntry = notificationEntry;
	}

	public Class<?> getModelClass() {
		return NotificationEntry.class;
	}

	public String getModelClassName() {
		return NotificationEntry.class.getName();
	}

	/**
	* Returns the primary key of this notification entry.
	*
	* @return the primary key of this notification entry
	*/
	public long getPrimaryKey() {
		return _notificationEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this notification entry.
	*
	* @param primaryKey the primary key of this notification entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_notificationEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notification ID of this notification entry.
	*
	* @return the notification ID of this notification entry
	*/
	public long getNotificationId() {
		return _notificationEntry.getNotificationId();
	}

	/**
	* Sets the notification ID of this notification entry.
	*
	* @param notificationId the notification ID of this notification entry
	*/
	public void setNotificationId(long notificationId) {
		_notificationEntry.setNotificationId(notificationId);
	}

	/**
	* Returns the user ID from of this notification entry.
	*
	* @return the user ID from of this notification entry
	*/
	public long getUserIdFrom() {
		return _notificationEntry.getUserIdFrom();
	}

	/**
	* Sets the user ID from of this notification entry.
	*
	* @param userIdFrom the user ID from of this notification entry
	*/
	public void setUserIdFrom(long userIdFrom) {
		_notificationEntry.setUserIdFrom(userIdFrom);
	}

	/**
	* Returns the user ID to of this notification entry.
	*
	* @return the user ID to of this notification entry
	*/
	public long getUserIdTo() {
		return _notificationEntry.getUserIdTo();
	}

	/**
	* Sets the user ID to of this notification entry.
	*
	* @param userIdTo the user ID to of this notification entry
	*/
	public void setUserIdTo(long userIdTo) {
		_notificationEntry.setUserIdTo(userIdTo);
	}

	/**
	* Returns the subject of this notification entry.
	*
	* @return the subject of this notification entry
	*/
	public java.lang.String getSubject() {
		return _notificationEntry.getSubject();
	}

	/**
	* Sets the subject of this notification entry.
	*
	* @param subject the subject of this notification entry
	*/
	public void setSubject(java.lang.String subject) {
		_notificationEntry.setSubject(subject);
	}

	/**
	* Returns the message of this notification entry.
	*
	* @return the message of this notification entry
	*/
	public java.lang.String getMessage() {
		return _notificationEntry.getMessage();
	}

	/**
	* Sets the message of this notification entry.
	*
	* @param message the message of this notification entry
	*/
	public void setMessage(java.lang.String message) {
		_notificationEntry.setMessage(message);
	}

	/**
	* Returns the create date of this notification entry.
	*
	* @return the create date of this notification entry
	*/
	public java.util.Date getCreateDate() {
		return _notificationEntry.getCreateDate();
	}

	/**
	* Sets the create date of this notification entry.
	*
	* @param createDate the create date of this notification entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_notificationEntry.setCreateDate(createDate);
	}

	/**
	* Returns the status of this notification entry.
	*
	* @return the status of this notification entry
	*/
	public int getStatus() {
		return _notificationEntry.getStatus();
	}

	/**
	* Sets the status of this notification entry.
	*
	* @param status the status of this notification entry
	*/
	public void setStatus(int status) {
		_notificationEntry.setStatus(status);
	}

	public boolean isNew() {
		return _notificationEntry.isNew();
	}

	public void setNew(boolean n) {
		_notificationEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _notificationEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_notificationEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _notificationEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _notificationEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_notificationEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _notificationEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_notificationEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NotificationEntryWrapper((NotificationEntry)_notificationEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.NotificationEntry notificationEntry) {
		return _notificationEntry.compareTo(notificationEntry);
	}

	@Override
	public int hashCode() {
		return _notificationEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.NotificationEntry> toCacheModel() {
		return _notificationEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.NotificationEntry toEscapedModel() {
		return new NotificationEntryWrapper(_notificationEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _notificationEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _notificationEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_notificationEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public NotificationEntry getWrappedNotificationEntry() {
		return _notificationEntry;
	}

	public NotificationEntry getWrappedModel() {
		return _notificationEntry;
	}

	public void resetOriginalValues() {
		_notificationEntry.resetOriginalValues();
	}

	private NotificationEntry _notificationEntry;
}