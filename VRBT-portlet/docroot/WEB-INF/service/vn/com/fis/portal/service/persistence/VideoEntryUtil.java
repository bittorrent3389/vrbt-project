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

import vn.com.fis.portal.model.VideoEntry;

import java.util.List;

/**
 * The persistence utility for the video entry service. This utility wraps {@link VideoEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoEntryPersistence
 * @see VideoEntryPersistenceImpl
 * @generated
 */
public class VideoEntryUtil {
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
	public static void clearCache(VideoEntry videoEntry) {
		getPersistence().clearCache(videoEntry);
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
	public static List<VideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoEntry update(VideoEntry videoEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(videoEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoEntry update(VideoEntry videoEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoEntry, merge, serviceContext);
	}

	/**
	* Caches the video entry in the entity cache if it is enabled.
	*
	* @param videoEntry the video entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.VideoEntry videoEntry) {
		getPersistence().cacheResult(videoEntry);
	}

	/**
	* Caches the video entries in the entity cache if it is enabled.
	*
	* @param videoEntries the video entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoEntry> videoEntries) {
		getPersistence().cacheResult(videoEntries);
	}

	/**
	* Creates a new video entry with the primary key. Does not add the video entry to the database.
	*
	* @param videoId the primary key for the new video entry
	* @return the new video entry
	*/
	public static vn.com.fis.portal.model.VideoEntry create(long videoId) {
		return getPersistence().create(videoId);
	}

	/**
	* Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoId the primary key of the video entry
	* @return the video entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoEntry remove(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence().remove(videoId);
	}

	public static vn.com.fis.portal.model.VideoEntry updateImpl(
		vn.com.fis.portal.model.VideoEntry videoEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoEntry, merge);
	}

	/**
	* Returns the video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoEntryException} if it could not be found.
	*
	* @param videoId the primary key of the video entry
	* @return the video entry
	* @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoEntry findByPrimaryKey(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence().findByPrimaryKey(videoId);
	}

	/**
	* Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoId the primary key of the video entry
	* @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoEntry fetchByPrimaryKey(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoId);
	}

	/**
	* Returns all the video entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByDateUpload(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDateUpload(date_);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByDateUpload(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDateUpload(date_, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByDateUpload(
		java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDateUpload(date_, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry findByDateUpload_First(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence().findByDateUpload_First(date_, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry findByDateUpload_Last(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence().findByDateUpload_Last(date_, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry[] findByDateUpload_PrevAndNext(
		long videoId, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByDateUpload_PrevAndNext(videoId, date_,
			orderByComparator);
	}

	/**
	* Returns all the video entries where uploaderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId(
		long uploaderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUploaderId(uploaderId);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId(
		long uploaderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUploaderId(uploaderId, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId(
		long uploaderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUploaderId(uploaderId, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry findByUploaderId_First(
		long uploaderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByUploaderId_First(uploaderId, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry findByUploaderId_Last(
		long uploaderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByUploaderId_Last(uploaderId, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry[] findByUploaderId_PrevAndNext(
		long videoId, long uploaderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByUploaderId_PrevAndNext(videoId, uploaderId,
			orderByComparator);
	}

	/**
	* Returns all the video entries where uploaderId = &#63; and folderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @return the matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId_Folder(
		long uploaderId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUploaderId_Folder(uploaderId, folderId);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId_Folder(
		long uploaderId, long folderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUploaderId_Folder(uploaderId, folderId, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findByUploaderId_Folder(
		long uploaderId, long folderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUploaderId_Folder(uploaderId, folderId, start, end,
			orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry findByUploaderId_Folder_First(
		long uploaderId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByUploaderId_Folder_First(uploaderId, folderId,
			orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry findByUploaderId_Folder_Last(
		long uploaderId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByUploaderId_Folder_Last(uploaderId, folderId,
			orderByComparator);
	}

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
	public static vn.com.fis.portal.model.VideoEntry[] findByUploaderId_Folder_PrevAndNext(
		long videoId, long uploaderId, long folderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoEntryException {
		return getPersistence()
				   .findByUploaderId_Folder_PrevAndNext(videoId, uploaderId,
			folderId, orderByComparator);
	}

	/**
	* Returns all the video entries.
	*
	* @return the video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video entries where date_ = &#63; from the database.
	*
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDateUpload(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDateUpload(date_);
	}

	/**
	* Removes all the video entries where uploaderId = &#63; from the database.
	*
	* @param uploaderId the uploader ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUploaderId(long uploaderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUploaderId(uploaderId);
	}

	/**
	* Removes all the video entries where uploaderId = &#63; and folderId = &#63; from the database.
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUploaderId_Folder(long uploaderId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUploaderId_Folder(uploaderId, folderId);
	}

	/**
	* Removes all the video entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDateUpload(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDateUpload(date_);
	}

	/**
	* Returns the number of video entries where uploaderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUploaderId(long uploaderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUploaderId(uploaderId);
	}

	/**
	* Returns the number of video entries where uploaderId = &#63; and folderId = &#63;.
	*
	* @param uploaderId the uploader ID
	* @param folderId the folder ID
	* @return the number of matching video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUploaderId_Folder(long uploaderId, long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUploaderId_Folder(uploaderId, folderId);
	}

	/**
	* Returns the number of video entries.
	*
	* @return the number of video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VideoEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VideoEntryUtil.class, "_persistence");
	}

	private static VideoEntryPersistence _persistence;
}