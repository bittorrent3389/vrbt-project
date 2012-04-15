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

import vn.com.fis.portal.model.VideoUserVideoGroupEntry;

/**
 * The persistence interface for the video user video group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserVideoGroupEntryPersistenceImpl
 * @see VideoUserVideoGroupEntryUtil
 * @generated
 */
public interface VideoUserVideoGroupEntryPersistence extends BasePersistence<VideoUserVideoGroupEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUserVideoGroupEntryUtil} to access the video user video group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video user video group entry in the entity cache if it is enabled.
	*
	* @param videoUserVideoGroupEntry the video user video group entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.VideoUserVideoGroupEntry videoUserVideoGroupEntry);

	/**
	* Caches the video user video group entries in the entity cache if it is enabled.
	*
	* @param videoUserVideoGroupEntries the video user video group entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> videoUserVideoGroupEntries);

	/**
	* Creates a new video user video group entry with the primary key. Does not add the video user video group entry to the database.
	*
	* @param videoUserVideoGroupID the primary key for the new video user video group entry
	* @return the new video user video group entry
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry create(
		long videoUserVideoGroupID);

	/**
	* Removes the video user video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserVideoGroupID the primary key of the video user video group entry
	* @return the video user video group entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry remove(
		long videoUserVideoGroupID)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException;

	public vn.com.fis.portal.model.VideoUserVideoGroupEntry updateImpl(
		vn.com.fis.portal.model.VideoUserVideoGroupEntry videoUserVideoGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video user video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	*
	* @param videoUserVideoGroupID the primary key of the video user video group entry
	* @return the video user video group entry
	* @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry findByPrimaryKey(
		long videoUserVideoGroupID)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException;

	/**
	* Returns the video user video group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoUserVideoGroupID the primary key of the video user video group entry
	* @return the video user video group entry, or <code>null</code> if a video user video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry fetchByPrimaryKey(
		long videoUserVideoGroupID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @return the matching video user video group entry
	* @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a matching video user video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry findByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException;

	/**
	* Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @return the matching video user video group entry, or <code>null</code> if a matching video user video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry fetchByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching video user video group entry, or <code>null</code> if a matching video user video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserVideoGroupEntry fetchByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user video group entries.
	*
	* @return the video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user video group entries
	* @param end the upper bound of the range of video user video group entries (not inclusive)
	* @return the range of video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video user video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user video group entries
	* @param end the upper bound of the range of video user video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; from the database.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoUser_VideoGroup(long videoUserId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException;

	/**
	* Removes all the video user video group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user video group entries where videoUserId = &#63; and videoGroupId = &#63;.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @return the number of matching video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoUser_VideoGroup(long videoUserId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user video group entries.
	*
	* @return the number of video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}