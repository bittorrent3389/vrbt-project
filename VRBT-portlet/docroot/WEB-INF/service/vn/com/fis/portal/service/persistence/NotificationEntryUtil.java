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

package vn.com.fis.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.fis.portal.model.NotificationEntry;

import java.util.List;

/**
 * The persistence utility for the notification entry service. This utility wraps {@link NotificationEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see NotificationEntryPersistence
 * @see NotificationEntryPersistenceImpl
 * @generated
 */
public class NotificationEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NotificationEntry notificationEntry) {
		getPersistence().clearCache(notificationEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NotificationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NotificationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NotificationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static NotificationEntry update(
		NotificationEntry notificationEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(notificationEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static NotificationEntry update(
		NotificationEntry notificationEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(notificationEntry, merge, serviceContext);
	}

	/**
	* Caches the notification entry in the entity cache if it is enabled.
	*
	* @param notificationEntry the notification entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.NotificationEntry notificationEntry) {
		getPersistence().cacheResult(notificationEntry);
	}

	/**
	* Caches the notification entries in the entity cache if it is enabled.
	*
	* @param notificationEntries the notification entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.NotificationEntry> notificationEntries) {
		getPersistence().cacheResult(notificationEntries);
	}

	/**
	* Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	*
	* @param notificationId the primary key for the new notification entry
	* @return the new notification entry
	*/
	public static vn.com.fis.portal.model.NotificationEntry create(
		long notificationId) {
		return getPersistence().create(notificationId);
	}

	/**
	* Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the notification entry
	* @return the notification entry that was removed
	* @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry remove(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchNotificationEntryException {
		return getPersistence().remove(notificationId);
	}

	public static vn.com.fis.portal.model.NotificationEntry updateImpl(
		vn.com.fis.portal.model.NotificationEntry notificationEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(notificationEntry, merge);
	}

	/**
	* Returns the notification entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchNotificationEntryException} if it could not be found.
	*
	* @param notificationId the primary key of the notification entry
	* @return the notification entry
	* @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry findByPrimaryKey(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchNotificationEntryException {
		return getPersistence().findByPrimaryKey(notificationId);
	}

	/**
	* Returns the notification entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationId the primary key of the notification entry
	* @return the notification entry, or <code>null</code> if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry fetchByPrimaryKey(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(notificationId);
	}

	/**
	* Returns all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @return the matching notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> findByUserIdFrom_UserIdTo(
		long userIdFrom, long userIdTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdFrom_UserIdTo(userIdFrom, userIdTo);
	}

	/**
	* Returns a range of all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @param start the lower bound of the range of notification entries
	* @param end the upper bound of the range of notification entries (not inclusive)
	* @return the range of matching notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> findByUserIdFrom_UserIdTo(
		long userIdFrom, long userIdTo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdFrom_UserIdTo(userIdFrom, userIdTo, start, end);
	}

	/**
	* Returns an ordered range of all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @param start the lower bound of the range of notification entries
	* @param end the upper bound of the range of notification entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> findByUserIdFrom_UserIdTo(
		long userIdFrom, long userIdTo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdFrom_UserIdTo(userIdFrom, userIdTo, start, end,
			orderByComparator);
	}

	/**
	* Returns the first notification entry in the ordered set where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching notification entry
	* @throws vn.com.fis.portal.NoSuchNotificationEntryException if a matching notification entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry findByUserIdFrom_UserIdTo_First(
		long userIdFrom, long userIdTo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchNotificationEntryException {
		return getPersistence()
				   .findByUserIdFrom_UserIdTo_First(userIdFrom, userIdTo,
			orderByComparator);
	}

	/**
	* Returns the last notification entry in the ordered set where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching notification entry
	* @throws vn.com.fis.portal.NoSuchNotificationEntryException if a matching notification entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry findByUserIdFrom_UserIdTo_Last(
		long userIdFrom, long userIdTo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchNotificationEntryException {
		return getPersistence()
				   .findByUserIdFrom_UserIdTo_Last(userIdFrom, userIdTo,
			orderByComparator);
	}

	/**
	* Returns the notification entries before and after the current notification entry in the ordered set where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param notificationId the primary key of the current notification entry
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next notification entry
	* @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.NotificationEntry[] findByUserIdFrom_UserIdTo_PrevAndNext(
		long notificationId, long userIdFrom, long userIdTo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchNotificationEntryException {
		return getPersistence()
				   .findByUserIdFrom_UserIdTo_PrevAndNext(notificationId,
			userIdFrom, userIdTo, orderByComparator);
	}

	/**
	* Returns all the notification entries.
	*
	* @return the notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the notification entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of notification entries
	* @param end the upper bound of the range of notification entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the notification entries where userIdFrom = &#63; and userIdTo = &#63; from the database.
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdFrom_UserIdTo(long userIdFrom,
		long userIdTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdFrom_UserIdTo(userIdFrom, userIdTo);
	}

	/**
	* Removes all the notification entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	*
	* @param userIdFrom the user ID from
	* @param userIdTo the user ID to
	* @return the number of matching notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdFrom_UserIdTo(long userIdFrom, long userIdTo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdFrom_UserIdTo(userIdFrom, userIdTo);
	}

	/**
	* Returns the number of notification entries.
	*
	* @return the number of notification entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NotificationEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NotificationEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					NotificationEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(NotificationEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(NotificationEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(NotificationEntryUtil.class,
			"_persistence");
	}

	private static NotificationEntryPersistence _persistence;
}