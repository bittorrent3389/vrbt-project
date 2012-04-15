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

import vn.com.fis.portal.model.ViolationVideoEntry;

/**
 * The persistence interface for the violation video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ViolationVideoEntryPersistenceImpl
 * @see ViolationVideoEntryUtil
 * @generated
 */
public interface ViolationVideoEntryPersistence extends BasePersistence<ViolationVideoEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViolationVideoEntryUtil} to access the violation video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the violation video entry in the entity cache if it is enabled.
	*
	* @param violationVideoEntry the violation video entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry);

	/**
	* Caches the violation video entries in the entity cache if it is enabled.
	*
	* @param violationVideoEntries the violation video entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> violationVideoEntries);

	/**
	* Creates a new violation video entry with the primary key. Does not add the violation video entry to the database.
	*
	* @param violationVideoId the primary key for the new violation video entry
	* @return the new violation video entry
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry create(
		long violationVideoId);

	/**
	* Removes the violation video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param violationVideoId the primary key of the violation video entry
	* @return the violation video entry that was removed
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry remove(
		long violationVideoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	public vn.com.fis.portal.model.ViolationVideoEntry updateImpl(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the violation video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchViolationVideoEntryException} if it could not be found.
	*
	* @param violationVideoId the primary key of the violation video entry
	* @return the violation video entry
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry findByPrimaryKey(
		long violationVideoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Returns the violation video entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param violationVideoId the primary key of the violation video entry
	* @return the violation video entry, or <code>null</code> if a violation video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry fetchByPrimaryKey(
		long violationVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the violation video entries where videoId = &#63; and userId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @return the matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation video entries where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param start the lower bound of the range of violation video entries
	* @param end the upper bound of the range of violation video entries (not inclusive)
	* @return the range of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findByVideoId_UserId(
		long videoId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the violation video entries where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param start the lower bound of the range of violation video entries
	* @param end the upper bound of the range of violation video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findByVideoId_UserId(
		long videoId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first violation video entry in the ordered set where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching violation video entry
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry findByVideoId_UserId_First(
		long videoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Returns the last violation video entry in the ordered set where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching violation video entry
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry findByVideoId_UserId_Last(
		long videoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Returns the violation video entries before and after the current violation video entry in the ordered set where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationVideoId the primary key of the current violation video entry
	* @param videoId the video ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next violation video entry
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry[] findByVideoId_UserId_PrevAndNext(
		long violationVideoId, long videoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or throws a {@link vn.com.fis.portal.NoSuchViolationVideoEntryException} if it could not be found.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @return the matching violation video entry
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry findByVideo_User_Violation(
		long videoId, long userId, long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @return the matching violation video entry, or <code>null</code> if a matching violation video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry fetchByVideo_User_Violation(
		long videoId, long userId, long violationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching violation video entry, or <code>null</code> if a matching violation video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry fetchByVideo_User_Violation(
		long videoId, long userId, long violationId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the violation video entries.
	*
	* @return the violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of violation video entries
	* @param end the upper bound of the range of violation video entries (not inclusive)
	* @return the range of violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the violation video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of violation video entries
	* @param end the upper bound of the range of violation video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the violation video entries where videoId = &#63; and userId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoId_UserId(long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideo_User_Violation(long videoId, long userId,
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Removes all the violation video entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation video entries where videoId = &#63; and userId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @return the number of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId_UserId(long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation video entries where videoId = &#63; and userId = &#63; and violationId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @return the number of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideo_User_Violation(long videoId, long userId,
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation video entries.
	*
	* @return the number of violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}