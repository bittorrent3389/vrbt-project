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

import vn.com.fis.portal.model.VideoUserContactEntry;

import java.util.List;

/**
 * The persistence utility for the video user contact entry service. This utility wraps {@link VideoUserContactEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserContactEntryPersistence
 * @see VideoUserContactEntryPersistenceImpl
 * @generated
 */
public class VideoUserContactEntryUtil {
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
	public static void clearCache(VideoUserContactEntry videoUserContactEntry) {
		getPersistence().clearCache(videoUserContactEntry);
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
	public static List<VideoUserContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoUserContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoUserContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoUserContactEntry update(
		VideoUserContactEntry videoUserContactEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(videoUserContactEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoUserContactEntry update(
		VideoUserContactEntry videoUserContactEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(videoUserContactEntry, merge, serviceContext);
	}

	/**
	* Caches the video user contact entry in the entity cache if it is enabled.
	*
	* @param videoUserContactEntry the video user contact entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry) {
		getPersistence().cacheResult(videoUserContactEntry);
	}

	/**
	* Caches the video user contact entries in the entity cache if it is enabled.
	*
	* @param videoUserContactEntries the video user contact entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> videoUserContactEntries) {
		getPersistence().cacheResult(videoUserContactEntries);
	}

	/**
	* Creates a new video user contact entry with the primary key. Does not add the video user contact entry to the database.
	*
	* @param videoUserContactId the primary key for the new video user contact entry
	* @return the new video user contact entry
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry create(
		long videoUserContactId) {
		return getPersistence().create(videoUserContactId);
	}

	/**
	* Removes the video user contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry remove(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException {
		return getPersistence().remove(videoUserContactId);
	}

	public static vn.com.fis.portal.model.VideoUserContactEntry updateImpl(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoUserContactEntry, merge);
	}

	/**
	* Returns the video user contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserContactEntryException} if it could not be found.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry findByPrimaryKey(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException {
		return getPersistence().findByPrimaryKey(videoUserContactId);
	}

	/**
	* Returns the video user contact entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry, or <code>null</code> if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry fetchByPrimaryKey(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoUserContactId);
	}

	/**
	* Returns all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @return the matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactId_VideoUserId(contactId, videoUserId);
	}

	/**
	* Returns a range of all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @param start the lower bound of the range of video user contact entries
	* @param end the upper bound of the range of video user contact entries (not inclusive)
	* @return the range of matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactId_VideoUserId(contactId, videoUserId, start,
			end);
	}

	/**
	* Returns an ordered range of all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @param start the lower bound of the range of video user contact entries
	* @param end the upper bound of the range of video user contact entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactId_VideoUserId(contactId, videoUserId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first video user contact entry in the ordered set where contactId = &#63; and videoUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user contact entry
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a matching video user contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry findByContactId_VideoUserId_First(
		long contactId, long videoUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException {
		return getPersistence()
				   .findByContactId_VideoUserId_First(contactId, videoUserId,
			orderByComparator);
	}

	/**
	* Returns the last video user contact entry in the ordered set where contactId = &#63; and videoUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user contact entry
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a matching video user contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry findByContactId_VideoUserId_Last(
		long contactId, long videoUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException {
		return getPersistence()
				   .findByContactId_VideoUserId_Last(contactId, videoUserId,
			orderByComparator);
	}

	/**
	* Returns the video user contact entries before and after the current video user contact entry in the ordered set where contactId = &#63; and videoUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoUserContactId the primary key of the current video user contact entry
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user contact entry
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserContactEntry[] findByContactId_VideoUserId_PrevAndNext(
		long videoUserContactId, long contactId, long videoUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException {
		return getPersistence()
				   .findByContactId_VideoUserId_PrevAndNext(videoUserContactId,
			contactId, videoUserId, orderByComparator);
	}

	/**
	* Returns all the video user contact entries.
	*
	* @return the video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video user contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user contact entries
	* @param end the upper bound of the range of video user contact entries (not inclusive)
	* @return the range of video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video user contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user contact entries
	* @param end the upper bound of the range of video user contact entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video user contact entries where contactId = &#63; and videoUserId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactId_VideoUserId(long contactId,
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContactId_VideoUserId(contactId, videoUserId);
	}

	/**
	* Removes all the video user contact entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @return the number of matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactId_VideoUserId(long contactId,
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByContactId_VideoUserId(contactId, videoUserId);
	}

	/**
	* Returns the number of video user contact entries.
	*
	* @return the number of video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoUserContactEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoUserContactEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoUserContactEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoUserContactEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VideoUserContactEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VideoUserContactEntryUtil.class,
			"_persistence");
	}

	private static VideoUserContactEntryPersistence _persistence;
}