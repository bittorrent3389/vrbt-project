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

import vn.com.fis.portal.model.VideoUserContactEntry;

/**
 * The persistence interface for the video user contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserContactEntryPersistenceImpl
 * @see VideoUserContactEntryUtil
 * @generated
 */
public interface VideoUserContactEntryPersistence extends BasePersistence<VideoUserContactEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUserContactEntryUtil} to access the video user contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video user contact entry in the entity cache if it is enabled.
	*
	* @param videoUserContactEntry the video user contact entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry);

	/**
	* Caches the video user contact entries in the entity cache if it is enabled.
	*
	* @param videoUserContactEntries the video user contact entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> videoUserContactEntries);

	/**
	* Creates a new video user contact entry with the primary key. Does not add the video user contact entry to the database.
	*
	* @param videoUserContactId the primary key for the new video user contact entry
	* @return the new video user contact entry
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry create(
		long videoUserContactId);

	/**
	* Removes the video user contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry remove(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException;

	public vn.com.fis.portal.model.VideoUserContactEntry updateImpl(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video user contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserContactEntryException} if it could not be found.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry
	* @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry findByPrimaryKey(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException;

	/**
	* Returns the video user contact entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry, or <code>null</code> if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry fetchByPrimaryKey(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @return the matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.fis.portal.model.VideoUserContactEntry findByContactId_VideoUserId_First(
		long contactId, long videoUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException;

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
	public vn.com.fis.portal.model.VideoUserContactEntry findByContactId_VideoUserId_Last(
		long contactId, long videoUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException;

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
	public vn.com.fis.portal.model.VideoUserContactEntry[] findByContactId_VideoUserId_PrevAndNext(
		long videoUserContactId, long contactId, long videoUserId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserContactEntryException;

	/**
	* Returns all the video user contact entries.
	*
	* @return the video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video user contact entries where contactId = &#63; and videoUserId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactId_VideoUserId(long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video user contact entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @return the number of matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactId_VideoUserId(long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user contact entries.
	*
	* @return the number of video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}