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

import vn.com.fis.portal.model.ServiceTransactionEntry;

import java.util.List;

/**
 * The persistence utility for the service transaction entry service. This utility wraps {@link ServiceTransactionEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ServiceTransactionEntryPersistence
 * @see ServiceTransactionEntryPersistenceImpl
 * @generated
 */
public class ServiceTransactionEntryUtil {
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
		ServiceTransactionEntry serviceTransactionEntry) {
		getPersistence().clearCache(serviceTransactionEntry);
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
	public static List<ServiceTransactionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceTransactionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceTransactionEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ServiceTransactionEntry update(
		ServiceTransactionEntry serviceTransactionEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(serviceTransactionEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ServiceTransactionEntry update(
		ServiceTransactionEntry serviceTransactionEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(serviceTransactionEntry, merge, serviceContext);
	}

	/**
	* Caches the service transaction entry in the entity cache if it is enabled.
	*
	* @param serviceTransactionEntry the service transaction entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry) {
		getPersistence().cacheResult(serviceTransactionEntry);
	}

	/**
	* Caches the service transaction entries in the entity cache if it is enabled.
	*
	* @param serviceTransactionEntries the service transaction entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> serviceTransactionEntries) {
		getPersistence().cacheResult(serviceTransactionEntries);
	}

	/**
	* Creates a new service transaction entry with the primary key. Does not add the service transaction entry to the database.
	*
	* @param transactionId the primary key for the new service transaction entry
	* @return the new service transaction entry
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry create(
		long transactionId) {
		return getPersistence().create(transactionId);
	}

	/**
	* Removes the service transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the service transaction entry
	* @return the service transaction entry that was removed
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry remove(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence().remove(transactionId);
	}

	public static vn.com.fis.portal.model.ServiceTransactionEntry updateImpl(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(serviceTransactionEntry, merge);
	}

	/**
	* Returns the service transaction entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchServiceTransactionEntryException} if it could not be found.
	*
	* @param transactionId the primary key of the service transaction entry
	* @return the service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence().findByPrimaryKey(transactionId);
	}

	/**
	* Returns the service transaction entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param transactionId the primary key of the service transaction entry
	* @return the service transaction entry, or <code>null</code> if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry fetchByPrimaryKey(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(transactionId);
	}

	/**
	* Returns all the service transaction entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByDate(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date_);
	}

	/**
	* Returns a range of all the service transaction entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByDate(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date_, start, end);
	}

	/**
	* Returns an ordered range of all the service transaction entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByDate(
		java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDate(date_, start, end, orderByComparator);
	}

	/**
	* Returns the first service transaction entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByDate_First(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence().findByDate_First(date_, orderByComparator);
	}

	/**
	* Returns the last service transaction entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByDate_Last(
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence().findByDate_Last(date_, orderByComparator);
	}

	/**
	* Returns the service transaction entries before and after the current service transaction entry in the ordered set where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current service transaction entry
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry[] findByDate_PrevAndNext(
		long transactionId, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByDate_PrevAndNext(transactionId, date_,
			orderByComparator);
	}

	/**
	* Returns all the service transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode(
		int transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTransactionCode(transactionCode);
	}

	/**
	* Returns a range of all the service transaction entries where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode(
		int transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode(transactionCode, start, end);
	}

	/**
	* Returns an ordered range of all the service transaction entries where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode(
		int transactionCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode(transactionCode, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service transaction entry in the ordered set where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByTransactionCode_First(
		int transactionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_First(transactionCode,
			orderByComparator);
	}

	/**
	* Returns the last service transaction entry in the ordered set where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByTransactionCode_Last(
		int transactionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Last(transactionCode,
			orderByComparator);
	}

	/**
	* Returns the service transaction entries before and after the current service transaction entry in the ordered set where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current service transaction entry
	* @param transactionCode the transaction code
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry[] findByTransactionCode_PrevAndNext(
		long transactionId, int transactionCode,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_PrevAndNext(transactionId,
			transactionCode, orderByComparator);
	}

	/**
	* Returns all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Returns a range of all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode_Date(transactionCode, date_, start,
			end);
	}

	/**
	* Returns an ordered range of all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, java.util.Date date_, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTransactionCode_Date(transactionCode, date_, start,
			end, orderByComparator);
	}

	/**
	* Returns the first service transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByTransactionCode_Date_First(
		int transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Date_First(transactionCode, date_,
			orderByComparator);
	}

	/**
	* Returns the last service transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByTransactionCode_Date_Last(
		int transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Date_Last(transactionCode, date_,
			orderByComparator);
	}

	/**
	* Returns the service transaction entries before and after the current service transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current service transaction entry
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry[] findByTransactionCode_Date_PrevAndNext(
		long transactionId, int transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByTransactionCode_Date_PrevAndNext(transactionId,
			transactionCode, date_, orderByComparator);
	}

	/**
	* Returns all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_TransactionCode_Date(userId, transactionCode,
			date_);
	}

	/**
	* Returns a range of all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, java.util.Date date_, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_TransactionCode_Date(userId, transactionCode,
			date_, start, end);
	}

	/**
	* Returns an ordered range of all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, java.util.Date date_, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId_TransactionCode_Date(userId, transactionCode,
			date_, start, end, orderByComparator);
	}

	/**
	* Returns the first service transaction entry in the ordered set where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByUserId_TransactionCode_Date_First(
		long userId, int transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByUserId_TransactionCode_Date_First(userId,
			transactionCode, date_, orderByComparator);
	}

	/**
	* Returns the last service transaction entry in the ordered set where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByUserId_TransactionCode_Date_Last(
		long userId, int transactionCode, java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByUserId_TransactionCode_Date_Last(userId,
			transactionCode, date_, orderByComparator);
	}

	/**
	* Returns the service transaction entries before and after the current service transaction entry in the ordered set where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current service transaction entry
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry[] findByUserId_TransactionCode_Date_PrevAndNext(
		long transactionId, long userId, int transactionCode,
		java.util.Date date_,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByUserId_TransactionCode_Date_PrevAndNext(transactionId,
			userId, transactionCode, date_, orderByComparator);
	}

	/**
	* Returns all the service transaction entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the service transaction entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the service transaction entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first service transaction entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last service transaction entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the service transaction entries before and after the current service transaction entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionId the primary key of the current service transaction entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service transaction entry
	* @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry[] findByUserId_PrevAndNext(
		long transactionId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceTransactionEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(transactionId, userId,
			orderByComparator);
	}

	/**
	* Returns all the service transaction entries.
	*
	* @return the service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service transaction entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service transaction entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service transaction entries where date_ = &#63; from the database.
	*
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDate(date_);
	}

	/**
	* Removes all the service transaction entries where transactionCode = &#63; from the database.
	*
	* @param transactionCode the transaction code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTransactionCode(int transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTransactionCode(transactionCode);
	}

	/**
	* Removes all the service transaction entries where transactionCode = &#63; and date_ = &#63; from the database.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTransactionCode_Date(int transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Removes all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63; from the database.
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_TransactionCode_Date(long userId,
		int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByUserId_TransactionCode_Date(userId, transactionCode, date_);
	}

	/**
	* Removes all the service transaction entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the service transaction entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service transaction entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDate(date_);
	}

	/**
	* Returns the number of service transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransactionCode(int transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTransactionCode(transactionCode);
	}

	/**
	* Returns the number of service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransactionCode_Date(int transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Returns the number of service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_TransactionCode_Date(long userId,
		int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserId_TransactionCode_Date(userId, transactionCode,
			date_);
	}

	/**
	* Returns the number of service transaction entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of service transaction entries.
	*
	* @return the number of service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServiceTransactionEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServiceTransactionEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ServiceTransactionEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ServiceTransactionEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ServiceTransactionEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ServiceTransactionEntryUtil.class,
			"_persistence");
	}

	private static ServiceTransactionEntryPersistence _persistence;
}