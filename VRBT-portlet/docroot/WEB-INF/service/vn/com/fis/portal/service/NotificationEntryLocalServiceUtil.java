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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the notification entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.NotificationEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see NotificationEntryLocalService
 * @see vn.com.fis.portal.service.base.NotificationEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.NotificationEntryLocalServiceImpl
 * @generated
 */
public class NotificationEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.NotificationEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the notification entry to the database. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @return the notification entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry addNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addNotificationEntry(notificationEntry);
	}

	/**
	* Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	*
	* @param notificationId the primary key for the new notification entry
	* @return the new notification entry
	*/
	public static vn.com.fis.portal.model.NotificationEntry createNotificationEntry(
		long notificationId) {
		return getService().createNotificationEntry(notificationId);
	}

	/**
	* Deletes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the notification entry
	* @throws PortalException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNotificationEntry(long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNotificationEntry(notificationId);
	}

	/**
	* Deletes the notification entry from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteNotificationEntry(notificationEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static vn.com.fis.portal.model.NotificationEntry fetchNotificationEntry(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchNotificationEntry(notificationId);
	}

	/**
	* Returns the notification entry with the primary key.
	*
	* @param notificationId the primary key of the notification entry
	* @return the notification entry
	* @throws PortalException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry getNotificationEntry(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificationEntry(notificationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> getNotificationEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificationEntries(start, end);
	}

	/**
	* Returns the number of notification entries.
	*
	* @return the number of notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getNotificationEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getNotificationEntriesCount();
	}

	/**
	* Updates the notification entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @return the notification entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry updateNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNotificationEntry(notificationEntry);
	}

	/**
	* Updates the notification entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param notificationEntry the notification entry
	* @param merge whether to merge the notification entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the notification entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry updateNotificationEntry(
		vn.com.fis.portal.model.NotificationEntry notificationEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateNotificationEntry(notificationEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> getNotificationEntryByUserId(
		long usreId, java.lang.String typeNotification, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getNotificationEntryByUserId(usreId, typeNotification,
			start, end);
	}

	public static int getNotificationEntryByUserIdCount(long usreId,
		java.lang.String typeNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getNotificationEntryByUserIdCount(usreId, typeNotification);
	}

	public static void clearService() {
		_service = null;
	}

	public static NotificationEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					NotificationEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					NotificationEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new NotificationEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(NotificationEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(NotificationEntryLocalService.class);
		}

		return _service;
	}

	public void setService(NotificationEntryLocalService service) {
		MethodCache.remove(NotificationEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(NotificationEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(NotificationEntryLocalService.class);
	}

	private static NotificationEntryLocalService _service;
}