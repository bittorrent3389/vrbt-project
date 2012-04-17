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

package vn.com.fis.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NotificationEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       NotificationEntryLocalService
 * @generated
 */
public class NotificationEntryLocalServiceWrapper
	implements NotificationEntryLocalService,
		ServiceWrapper<NotificationEntryLocalService> {
	public NotificationEntryLocalServiceWrapper(
		NotificationEntryLocalService notificationEntryLocalService) {
		_notificationEntryLocalService = notificationEntryLocalService;
	}

	/**
	* Adds the notification entry to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @return the notification entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.NotificationEntry addNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.addNotificationEntry(notificationEntry);
	}

	/**
	* Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	*
	* @param notificationId the primary key for the new notification entry
	* @return the new notification entry
	*/
	public vn.com.fis.portal.model.NotificationEntry createNotificationEntry(
		long notificationId) {
		return _notificationEntryLocalService.createNotificationEntry(notificationId);
	}

	/**
	* Deletes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the notification entry
	* @throws PortalException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNotificationEntry(long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_notificationEntryLocalService.deleteNotificationEntry(notificationId);
	}

	/**
	* Deletes the notification entry from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_notificationEntryLocalService.deleteNotificationEntry(notificationEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.NotificationEntry fetchNotificationEntry(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.fetchNotificationEntry(notificationId);
	}

	/**
	* Returns the notification entry with the primary key.
	*
	* @param notificationId the primary key of the notification entry
	* @return the notification entry
	* @throws PortalException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.NotificationEntry getNotificationEntry(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.getNotificationEntry(notificationId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the notification entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of notification entries
	* @param end the upper bound of the range of notification entries (not inclusive)
	* @return the range of notification entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.NotificationEntry> getNotificationEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.getNotificationEntries(start, end);
	}

	/**
	* Returns the number of notification entries.
	*
	* @return the number of notification entries
	* @throws SystemException if a system exception occurred
	*/
	public int getNotificationEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.getNotificationEntriesCount();
	}

	/**
	* Updates the notification entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @return the notification entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.NotificationEntry updateNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.updateNotificationEntry(notificationEntry);
	}

	/**
	* Updates the notification entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @param merge whether to merge the notification entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the notification entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.NotificationEntry updateNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.updateNotificationEntry(notificationEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _notificationEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_notificationEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<vn.com.fis.portal.model.NotificationEntry> getNotificationEntryByUserId(
		long usreId, java.lang.String typeNotification, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.getNotificationEntryByUserId(usreId,
			typeNotification, start, end);
	}

	public int getNotificationEntryByUserIdCount(long usreId,
		java.lang.String typeNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _notificationEntryLocalService.getNotificationEntryByUserIdCount(usreId,
			typeNotification);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public NotificationEntryLocalService getWrappedNotificationEntryLocalService() {
		return _notificationEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedNotificationEntryLocalService(
		NotificationEntryLocalService notificationEntryLocalService) {
		_notificationEntryLocalService = notificationEntryLocalService;
	}

	public NotificationEntryLocalService getWrappedService() {
		return _notificationEntryLocalService;
	}

	public void setWrappedService(
		NotificationEntryLocalService notificationEntryLocalService) {
		_notificationEntryLocalService = notificationEntryLocalService;
	}

	private NotificationEntryLocalService _notificationEntryLocalService;
}