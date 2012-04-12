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

import vn.com.fis.portal.model.VideoUserEntry;

import java.util.List;

/**
 * The persistence utility for the video user entry service. This utility wraps {@link VideoUserEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserEntryPersistence
 * @see VideoUserEntryPersistenceImpl
 * @generated
 */
public class VideoUserEntryUtil {
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
	public static void clearCache(VideoUserEntry videoUserEntry) {
		getPersistence().clearCache(videoUserEntry);
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
	public static List<VideoUserEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoUserEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoUserEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoUserEntry update(VideoUserEntry videoUserEntry,
		boolean merge) throws SystemException {
		return getPersistence().update(videoUserEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoUserEntry update(VideoUserEntry videoUserEntry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoUserEntry, merge, serviceContext);
	}

	/**
	* Caches the video user entry in the entity cache if it is enabled.
	*
	* @param videoUserEntry the video user entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry) {
		getPersistence().cacheResult(videoUserEntry);
	}

	/**
	* Caches the video user entries in the entity cache if it is enabled.
	*
	* @param videoUserEntries the video user entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserEntry> videoUserEntries) {
		getPersistence().cacheResult(videoUserEntries);
	}

	/**
	* Creates a new video user entry with the primary key. Does not add the video user entry to the database.
	*
	* @param videoUserId the primary key for the new video user entry
	* @return the new video user entry
	*/
	public static vn.com.fis.portal.model.VideoUserEntry create(
		long videoUserId) {
		return getPersistence().create(videoUserId);
	}

	/**
	* Removes the video user entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry remove(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence().remove(videoUserId);
	}

	public static vn.com.fis.portal.model.VideoUserEntry updateImpl(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoUserEntry, merge);
	}

	/**
	* Returns the video user entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserEntryException} if it could not be found.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry findByPrimaryKey(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence().findByPrimaryKey(videoUserId);
	}

	/**
	* Returns the video user entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry, or <code>null</code> if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry fetchByPrimaryKey(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoUserId);
	}

	/**
	* Returns all the video user entries where userId = &#63; and videoId = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @return the matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_VideoId(userId, videoId);
	}

	/**
	* Returns a range of all the video user entries where userId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @return the range of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId_VideoId(userId, videoId, start, end);
	}

	/**
	* Returns an ordered range of all the video user entries where userId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_VideoId(userId, videoId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video user entry in the ordered set where userId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_First(
		long userId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence()
				   .findByUserId_VideoId_First(userId, videoId,
			orderByComparator);
	}

	/**
	* Returns the last video user entry in the ordered set where userId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_Last(
		long userId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence()
				   .findByUserId_VideoId_Last(userId, videoId, orderByComparator);
	}

	/**
	* Returns the video user entries before and after the current video user entry in the ordered set where userId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoUserId the primary key of the current video user entry
	* @param userId the user ID
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry[] findByUserId_VideoId_PrevAndNext(
		long videoUserId, long userId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence()
				   .findByUserId_VideoId_PrevAndNext(videoUserId, userId,
			videoId, orderByComparator);
	}

	/**
	* Returns all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @return the matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId_Status(
		long userId, long videoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_VideoId_Status(userId, videoId, status);
	}

	/**
	* Returns a range of all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @return the range of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId_Status(
		long userId, long videoId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_VideoId_Status(userId, videoId, status, start,
			end);
	}

	/**
	* Returns an ordered range of all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId_Status(
		long userId, long videoId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_VideoId_Status(userId, videoId, status, start,
			end, orderByComparator);
	}

	/**
	* Returns the first video user entry in the ordered set where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_Status_First(
		long userId, long videoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence()
				   .findByUserId_VideoId_Status_First(userId, videoId, status,
			orderByComparator);
	}

	/**
	* Returns the last video user entry in the ordered set where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_Status_Last(
		long userId, long videoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence()
				   .findByUserId_VideoId_Status_Last(userId, videoId, status,
			orderByComparator);
	}

	/**
	* Returns the video user entries before and after the current video user entry in the ordered set where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoUserId the primary key of the current video user entry
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry[] findByUserId_VideoId_Status_PrevAndNext(
		long videoUserId, long userId, long videoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException {
		return getPersistence()
				   .findByUserId_VideoId_Status_PrevAndNext(videoUserId,
			userId, videoId, status, orderByComparator);
	}

	/**
	* Returns all the video user entries.
	*
	* @return the video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video user entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @return the range of video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video user entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video user entries where userId = &#63; and videoId = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_VideoId(long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId_VideoId(userId, videoId);
	}

	/**
	* Removes all the video user entries where userId = &#63; and videoId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_VideoId_Status(long userId, long videoId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId_VideoId_Status(userId, videoId, status);
	}

	/**
	* Removes all the video user entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video user entries where userId = &#63; and videoId = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @return the number of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_VideoId(long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId_VideoId(userId, videoId);
	}

	/**
	* Returns the number of video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @return the number of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_VideoId_Status(long userId, long videoId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserId_VideoId_Status(userId, videoId, status);
	}

	/**
	* Returns the number of video user entries.
	*
	* @return the number of video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoUserEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoUserEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoUserEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoUserEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VideoUserEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VideoUserEntryUtil.class,
			"_persistence");
	}

	private static VideoUserEntryPersistence _persistence;
}