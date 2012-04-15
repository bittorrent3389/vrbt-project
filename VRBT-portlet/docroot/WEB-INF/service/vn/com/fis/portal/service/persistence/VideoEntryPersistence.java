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

import vn.com.fis.portal.model.VideoEntry;

/**
 * The persistence interface for the video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoEntryPersistenceImpl
 * @see VideoEntryUtil
 * @generated
 */
public interface VideoEntryPersistence extends BasePersistence<VideoEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoEntryUtil} to access the video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the video entry in the entity cache if it is enabled.
	*
	* @param videoEntry the video entry
	*/
	public void cacheResult(vn.com.fis.portal.model.VideoEntry videoEntry);

	/**
	* Caches the video entries in the entity cache if it is enabled.
	*
	* @param videoEntries the video entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoEntry> videoEntries);

	/**
	* Creates a new video entry with the primary key. Does not add the video entry to the database.
	*
	* @param videoId the primary key for the new video entry
	* @return the new video entry
	*/
	public vn.com.fis.portal.model.VideoEntry create(long videoId);

	/**
	* Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video entry
	* @return the video entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry remove(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	public vn.com.fis.portal.model.VideoEntry updateImpl(
		vn.com.fis.portal.model.VideoEntry videoEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoEntryException} if it could not be found.
	*
	* @param videoId the primary key of the video entry
	* @return the video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByPrimaryKey(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video entry
	* @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry fetchByPrimaryKey(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByDateUpload(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByDateUpload(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByDateUpload(
		java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByDateUpload_First(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the last video entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByDateUpload_Last(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the video entries before and after the current video entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the primary key of the current video entry
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry[] findByDateUpload_PrevAndNext(
		long videoId, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns all the video entries where uploaderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId(
		long uploaderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries where uploaderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId(
		long uploaderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries where uploaderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId(
		long uploaderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video entry in the ordered set where uploaderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByUploaderId_First(
		long uploaderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the last video entry in the ordered set where uploaderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByUploaderId_Last(
		long uploaderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the video entries before and after the current video entry in the ordered set where uploaderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the primary key of the current video entry
	* @param uploaderId the uploader ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry[] findByUploaderId_PrevAndNext(
		long videoId, long uploaderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns all the video entries where uploaderId = &#63; and folderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId_Folder(
		long uploaderId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries where uploaderId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId_Folder(
		long uploaderId, long folderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries where uploaderId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId_Folder(
		long uploaderId, long folderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first video entry in the ordered set where uploaderId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByUploaderId_Folder_First(
		long uploaderId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the last video entry in the ordered set where uploaderId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry findByUploaderId_Folder_Last(
		long uploaderId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns the video entries before and after the current video entry in the ordered set where uploaderId = &#63; and folderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the primary key of the current video entry
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoEntry[] findByUploaderId_Folder_PrevAndNext(
		long videoId, long uploaderId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException;

	/**
	* Returns all the video entries.
	*
	* @return the video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @return the range of video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video entries
	* @param end the upper bound of the range of video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video entries where date_ = &#63; from the database.
	*
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDateUpload(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video entries where uploaderId = &#63; from the database.
	*
	* @param uploaderId the uploader ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUploaderId(long uploaderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video entries where uploaderId = &#63; and folderId = &#63; from the database.
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUploaderId_Folder(long uploaderId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the video entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDateUpload(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries where uploaderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUploaderId(long uploaderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries where uploaderId = &#63; and folderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUploaderId_Folder(long uploaderId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video entries.
	*
	* @return the number of video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}