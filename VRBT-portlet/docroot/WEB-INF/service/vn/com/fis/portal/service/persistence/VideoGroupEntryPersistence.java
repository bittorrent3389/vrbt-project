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

import vn.com.fis.portal.model.VideoGroupEntry;

/**
 * The persistence interface for the video group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoGroupEntryPersistenceImpl
 * @see VideoGroupEntryUtil
 * @generated
 */
public interface VideoGroupEntryPersistence extends BasePersistence<VideoGroupEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoGroupEntryUtil} to access the video group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video group entry in the entity cache if it is enabled.
	*
	* @param videoGroupEntry the video group entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry);

	/**
	* Caches the video group entries in the entity cache if it is enabled.
	*
	* @param videoGroupEntries the video group entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoGroupEntry> videoGroupEntries);

	/**
	* Creates a new video group entry with the primary key. Does not add the video group entry to the database.
	*
	* @param videoGroupId the primary key for the new video group entry
	* @return the new video group entry
	*/
	public vn.com.fis.portal.model.VideoGroupEntry create(long videoGroupId);

	/**
	* Removes the video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry remove(long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException;

	public vn.com.fis.portal.model.VideoGroupEntry updateImpl(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoGroupEntryException} if it could not be found.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry findByPrimaryKey(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException;

	/**
	* Returns the video group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry, or <code>null</code> if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry fetchByPrimaryKey(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video group entries where videoGroupName = &#63;.
	*
	* @param videoGroupName the video group name
	* @return the matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video group entries where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @return the range of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video group entries where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video group entry in the ordered set where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a matching video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry findByGroupName_First(
		java.lang.String videoGroupName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException;

	/**
	* Returns the last video group entry in the ordered set where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a matching video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry findByGroupName_Last(
		java.lang.String videoGroupName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException;

	/**
	* Returns the video group entries before and after the current video group entry in the ordered set where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupId the primary key of the current video group entry
	* @param videoGroupName the video group name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry[] findByGroupName_PrevAndNext(
		long videoGroupId, java.lang.String videoGroupName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException;

	/**
	* Returns all the video group entries.
	*
	* @return the video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @return the range of video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video group entries where videoGroupName = &#63; from the database.
	*
	* @param videoGroupName the video group name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupName(java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video group entries where videoGroupName = &#63;.
	*
	* @param videoGroupName the video group name
	* @return the number of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupName(java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video group entries.
	*
	* @return the number of video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}