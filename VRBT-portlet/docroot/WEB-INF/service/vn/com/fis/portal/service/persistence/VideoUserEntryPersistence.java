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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.com.fis.portal.model.VideoUserEntry;

/**
 * The persistence interface for the video user entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserEntryPersistenceImpl
 * @see VideoUserEntryUtil
 * @generated
 */
public interface VideoUserEntryPersistence extends BasePersistence<VideoUserEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUserEntryUtil} to access the video user entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video user entry in the entity cache if it is enabled.
	*
	* @param videoUserEntry the video user entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry);

	/**
	* Caches the video user entries in the entity cache if it is enabled.
	*
	* @param videoUserEntries the video user entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserEntry> videoUserEntries);

	/**
	* Creates a new video user entry with the primary key. Does not add the video user entry to the database.
	*
	* @param videoUserId the primary key for the new video user entry
	* @return the new video user entry
	*/
	public vn.com.fis.portal.model.VideoUserEntry create(long videoUserId);

	/**
	* Removes the video user entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserEntry remove(long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

	public vn.com.fis.portal.model.VideoUserEntry updateImpl(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video user entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserEntryException} if it could not be found.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry
	* @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserEntry findByPrimaryKey(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

	/**
	* Returns the video user entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry, or <code>null</code> if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserEntry fetchByPrimaryKey(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user entries where userId = &#63; and videoId = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @return the matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_First(
		long userId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

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
	public vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_Last(
		long userId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

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
	public vn.com.fis.portal.model.VideoUserEntry[] findByUserId_VideoId_PrevAndNext(
		long videoUserId, long userId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

	/**
	* Returns all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @return the matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId_Status(
		long userId, long videoId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId_Status(
		long userId, long videoId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId_Status(
		long userId, long videoId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_Status_First(
		long userId, long videoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

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
	public vn.com.fis.portal.model.VideoUserEntry findByUserId_VideoId_Status_Last(
		long userId, long videoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

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
	public vn.com.fis.portal.model.VideoUserEntry[] findByUserId_VideoId_Status_PrevAndNext(
		long videoUserId, long userId, long videoId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserEntryException;

	/**
	* Returns all the video user entries.
	*
	* @return the video user entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video user entries where userId = &#63; and videoId = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_VideoId(long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video user entries where userId = &#63; and videoId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_VideoId_Status(long userId, long videoId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video user entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user entries where userId = &#63; and videoId = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @return the number of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_VideoId(long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param status the status
	* @return the number of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_VideoId_Status(long userId, long videoId,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user entries.
	*
	* @return the number of video user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}