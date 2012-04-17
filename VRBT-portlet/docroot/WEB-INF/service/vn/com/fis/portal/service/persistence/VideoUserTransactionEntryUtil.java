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

import vn.com.fis.portal.model.VideoUserTransactionEntry;

import java.util.List;

/**
 * The persistence utility for the video user transaction entry service. This utility wraps {@link VideoUserTransactionEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserTransactionEntryPersistence
 * @see VideoUserTransactionEntryPersistenceImpl
 * @generated
 */
public class VideoUserTransactionEntryUtil {
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
	public static void clearCache(
		VideoUserTransactionEntry videoUserTransactionEntry) {
		getPersistence().clearCache(videoUserTransactionEntry);
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
	public static List<VideoUserTransactionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoUserTransactionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoUserTransactionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoUserTransactionEntry update(
		VideoUserTransactionEntry videoUserTransactionEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(videoUserTransactionEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoUserTransactionEntry update(
		VideoUserTransactionEntry videoUserTransactionEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(videoUserTransactionEntry, merge, serviceContext);
	}

	/**
	* Caches the video user transaction entry in the entity cache if it is enabled.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry) {
		getPersistence().cacheResult(videoUserTransactionEntry);
	}

	/**
	* Caches the video user transaction entries in the entity cache if it is enabled.
	*
	* @param videoUserTransactionEntries the video user transaction entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> videoUserTransactionEntries) {
		getPersistence().cacheResult(videoUserTransactionEntries);
	}

	/**
	* Creates a new video user transaction entry with the primary key. Does not add the video user transaction entry to the database.
	*
	* @param transactionId the primary key for the new video user transaction entry
	* @return the new video user transaction entry
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry create(
		long transactionId) {
		return getPersistence().create(transactionId);
	}

	/**
	* Removes the video user transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @return the video user transaction entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry remove(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().remove(transactionId);
	}

	public static vn.com.fis.portal.model.VideoUserTransactionEntry updateImpl(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoUserTransactionEntry, merge);
	}

	/**
	* Returns the video user transaction entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserTransactionEntryException} if it could not be found.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @return the video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByPrimaryKey(transactionId);
	}

	/**
	* Returns the video user transaction entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @return the video user transaction entry, or <code>null</code> if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(transactionId);
	}

	/**
	* Returns all the video user transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTransactionCode(transactionCode);
	}

	/**
	* Returns a range of all the video user transaction entries where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode(transactionCode, start, end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode(transactionCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video user transaction entry in the ordered set where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByTransactionCode_First(
		long transactionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_First(transactionCode,
			orderByComparator);
	}

	/**
	* Returns the last video user transaction entry in the ordered set where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByTransactionCode_Last(
		long transactionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Last(transactionCode,
			orderByComparator);
	}

	/**
	* Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current video user transaction entry
	* @param transactionCode the transaction code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry[] findByTransactionCode_PrevAndNext(
		long transactionId, long transactionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_PrevAndNext(transactionId,
			transactionCode, orderByComparator);
	}

	/**
	* Returns all the video user transaction entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date_);
	}

	/**
	* Returns a range of all the video user transaction entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date_, start, end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date_, start, end, orderByComparator);
	}

	/**
	* Returns the first video user transaction entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByDate_First(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByDate_First(date_, orderByComparator);
	}

	/**
	* Returns the last video user transaction entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByDate_Last(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByDate_Last(date_, orderByComparator);
	}

	/**
	* Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current video user transaction entry
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry[] findByDate_PrevAndNext(
		long transactionId, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByDate_PrevAndNext(transactionId, date_,
			orderByComparator);
	}

	/**
	* Returns all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Returns a range of all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode_Date(transactionCode, date_, start,
			end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode_Date(transactionCode, date_, start,
			end, orderByComparator);
	}

	/**
	* Returns the first video user transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByTransactionCode_Date_First(
		long transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Date_First(transactionCode, date_,
			orderByComparator);
	}

	/**
	* Returns the last video user transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByTransactionCode_Date_Last(
		long transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Date_Last(transactionCode, date_,
			orderByComparator);
	}

	/**
	* Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current video user transaction entry
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry[] findByTransactionCode_Date_PrevAndNext(
		long transactionId, long transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Date_PrevAndNext(transactionId,
			transactionCode, date_, orderByComparator);
	}

	/**
	* Returns all the video user transaction entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the video user transaction entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first video user transaction entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last video user transaction entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current video user transaction entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry[] findByUserId_PrevAndNext(
		long transactionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(transactionId, userId,
			orderByComparator);
	}

	/**
	* Returns all the video user transaction entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoId(videoId);
	}

	/**
	* Returns a range of all the video user transaction entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoId(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoId(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first video user transaction entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByVideoId_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByVideoId_First(videoId, orderByComparator);
	}

	/**
	* Returns the last video user transaction entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByVideoId_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence().findByVideoId_Last(videoId, orderByComparator);
	}

	/**
	* Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current video user transaction entry
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry[] findByVideoId_PrevAndNext(
		long transactionId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByVideoId_PrevAndNext(transactionId, videoId,
			orderByComparator);
	}

	/**
	* Returns all the video user transaction entries where receiverId = &#63;.
	*
	* @param receiverId the receiver ID
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreceiverId(receiverId);
	}

	/**
	* Returns a range of all the video user transaction entries where receiverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByreceiverId(receiverId, start, end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries where receiverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByreceiverId(receiverId, start, end, orderByComparator);
	}

	/**
	* Returns the first video user transaction entry in the ordered set where receiverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByreceiverId_First(
		long receiverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByreceiverId_First(receiverId, orderByComparator);
	}

	/**
	* Returns the last video user transaction entry in the ordered set where receiverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry findByreceiverId_Last(
		long receiverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByreceiverId_Last(receiverId, orderByComparator);
	}

	/**
	* Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where receiverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current video user transaction entry
	* @param receiverId the receiver ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video user transaction entry
	* @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry[] findByreceiverId_PrevAndNext(
		long transactionId, long receiverId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserTransactionEntryException {
		return getPersistence()
				   .findByreceiverId_PrevAndNext(transactionId, receiverId,
			orderByComparator);
	}

	/**
	* Returns all the video user transaction entries.
	*
	* @return the video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video user transaction entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video user transaction entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video user transaction entries where transactionCode = &#63; from the database.
	*
	* @param transactionCode the transaction code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTransactionCode(long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTransactionCode(transactionCode);
	}

	/**
	* Removes all the video user transaction entries where date_ = &#63; from the database.
	*
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDate(date_);
	}

	/**
	* Removes all the video user transaction entries where transactionCode = &#63; and date_ = &#63; from the database.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTransactionCode_Date(long transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Removes all the video user transaction entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the video user transaction entries where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideoId(videoId);
	}

	/**
	* Removes all the video user transaction entries where receiverId = &#63; from the database.
	*
	* @param receiverId the receiver ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByreceiverId(long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByreceiverId(receiverId);
	}

	/**
	* Removes all the video user transaction entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video user transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransactionCode(long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTransactionCode(transactionCode);
	}

	/**
	* Returns the number of video user transaction entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDate(date_);
	}

	/**
	* Returns the number of video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransactionCode_Date(long transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Returns the number of video user transaction entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of video user transaction entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideoId(videoId);
	}

	/**
	* Returns the number of video user transaction entries where receiverId = &#63;.
	*
	* @param receiverId the receiver ID
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByreceiverId(long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByreceiverId(receiverId);
	}

	/**
	* Returns the number of video user transaction entries.
	*
	* @return the number of video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoUserTransactionEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoUserTransactionEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoUserTransactionEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoUserTransactionEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VideoUserTransactionEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VideoUserTransactionEntryUtil.class,
			"_persistence");
	}

	private static VideoUserTransactionEntryPersistence _persistence;
}