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

import vn.com.fis.portal.model.RatingEntry;

/**
 * The persistence interface for the rating entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see RatingEntryPersistenceImpl
 * @see RatingEntryUtil
 * @generated
 */
public interface RatingEntryPersistence extends BasePersistence<RatingEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RatingEntryUtil} to access the rating entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the rating entry in the entity cache if it is enabled.
	*
	* @param ratingEntry the rating entry
	*/
	public void cacheResult(vn.com.fis.portal.model.RatingEntry ratingEntry);

	/**
	* Caches the rating entries in the entity cache if it is enabled.
	*
	* @param ratingEntries the rating entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.RatingEntry> ratingEntries);

	/**
	* Creates a new rating entry with the primary key. Does not add the rating entry to the database.
	*
	* @param ratingId the primary key for the new rating entry
	* @return the new rating entry
	*/
	public vn.com.fis.portal.model.RatingEntry create(long ratingId);

	/**
	* Removes the rating entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating entry
	* @return the rating entry that was removed
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry remove(long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	public vn.com.fis.portal.model.RatingEntry updateImpl(
		vn.com.fis.portal.model.RatingEntry ratingEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	*
	* @param ratingId the primary key of the rating entry
	* @return the rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByPrimaryKey(long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ratingId the primary key of the rating entry
	* @return the rating entry, or <code>null</code> if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry fetchByPrimaryKey(long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByVideoId_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the last rating entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByVideoId_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entries before and after the current rating entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ratingId the primary key of the current rating entry
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry[] findByVideoId_PrevAndNext(
		long ratingId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns all the rating entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByDate(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByDate(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByDate(
		java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByDate_First(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the last rating entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByDate_Last(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entries before and after the current rating entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ratingId the primary key of the current rating entry
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry[] findByDate_PrevAndNext(
		long ratingId, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns all the rating entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the last rating entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entries before and after the current rating entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ratingId the primary key of the current rating entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry[] findByUserId_PrevAndNext(
		long ratingId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns all the rating entries where videoId = &#63; and userId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_UserId(
		long videoId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_UserId(
		long videoId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating entry in the ordered set where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByVideoId_UserId_First(
		long videoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the last rating entry in the ordered set where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByVideoId_UserId_Last(
		long videoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entries before and after the current rating entry in the ordered set where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ratingId the primary key of the current rating entry
	* @param videoId the video ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry[] findByVideoId_UserId_PrevAndNext(
		long ratingId, long videoId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns all the rating entries where videoId = &#63; and code = &#63;.
	*
	* @param videoId the video ID
	* @param code the code
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_Code(
		long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries where videoId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param code the code
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_Code(
		long videoId, int code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries where videoId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param code the code
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_Code(
		long videoId, int code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating entry in the ordered set where videoId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByVideoId_Code_First(
		long videoId, int code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the last rating entry in the ordered set where videoId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByVideoId_Code_Last(
		long videoId, int code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entries before and after the current rating entry in the ordered set where videoId = &#63; and code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ratingId the primary key of the current rating entry
	* @param videoId the video ID
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry[] findByVideoId_Code_PrevAndNext(
		long ratingId, long videoId, int code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns all the rating entries where code = &#63;.
	*
	* @param code the code
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByRatingCode(
		int code) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByRatingCode(
		int code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByRatingCode(
		int code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first rating entry in the ordered set where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByRatingCode_First(
		int code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the last rating entry in the ordered set where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByRatingCode_Last(int code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entries before and after the current rating entry in the ordered set where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ratingId the primary key of the current rating entry
	* @param code the code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry[] findByRatingCode_PrevAndNext(
		long ratingId, int code,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @return the matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByUser_Video_Code(
		long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @return the matching rating entry, or <code>null</code> if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry fetchByUser_Video_Code(
		long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rating entry, or <code>null</code> if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry fetchByUser_Video_Code(
		long userId, long videoId, int code, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating entries.
	*
	* @return the rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rating entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rating entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating entries where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating entries where date_ = &#63; from the database.
	*
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating entries where videoId = &#63; and userId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoId_UserId(long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating entries where videoId = &#63; and code = &#63; from the database.
	*
	* @param videoId the video ID
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoId_Code(long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rating entries where code = &#63; from the database.
	*
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRatingCode(int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the rating entry where userId = &#63; and videoId = &#63; and code = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser_Video_Code(long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	/**
	* Removes all the rating entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where videoId = &#63; and userId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId_UserId(long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where videoId = &#63; and code = &#63;.
	*
	* @param videoId the video ID
	* @param code the code
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId_Code(long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByRatingCode(int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where userId = &#63; and videoId = &#63; and code = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser_Video_Code(long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries.
	*
	* @return the number of rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}