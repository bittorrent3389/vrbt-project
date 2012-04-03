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

import vn.com.fis.portal.model.ServicePackageEntry;

import java.util.List;

/**
 * The persistence utility for the service package entry service. This utility wraps {@link ServicePackageEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ServicePackageEntryPersistence
 * @see ServicePackageEntryPersistenceImpl
 * @generated
 */
public class ServicePackageEntryUtil {
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
	public static void clearCache(ServicePackageEntry servicePackageEntry) {
		getPersistence().clearCache(servicePackageEntry);
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
	public static List<ServicePackageEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServicePackageEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServicePackageEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ServicePackageEntry update(
		ServicePackageEntry servicePackageEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(servicePackageEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ServicePackageEntry update(
		ServicePackageEntry servicePackageEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(servicePackageEntry, merge, serviceContext);
	}

	/**
	* Caches the service package entry in the entity cache if it is enabled.
	*
	* @param servicePackageEntry the service package entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry) {
		getPersistence().cacheResult(servicePackageEntry);
	}

	/**
	* Caches the service package entries in the entity cache if it is enabled.
	*
	* @param servicePackageEntries the service package entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.ServicePackageEntry> servicePackageEntries) {
		getPersistence().cacheResult(servicePackageEntries);
	}

	/**
	* Creates a new service package entry with the primary key. Does not add the service package entry to the database.
	*
	* @param servicePackageId the primary key for the new service package entry
	* @return the new service package entry
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry create(
		long servicePackageId) {
		return getPersistence().create(servicePackageId);
	}

	/**
	* Removes the service package entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param servicePackageId the primary key of the service package entry
	* @return the service package entry that was removed
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry remove(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence().remove(servicePackageId);
	}

	public static vn.com.fis.portal.model.ServicePackageEntry updateImpl(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(servicePackageEntry, merge);
	}

	/**
	* Returns the service package entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchServicePackageEntryException} if it could not be found.
	*
	* @param servicePackageId the primary key of the service package entry
	* @return the service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByPrimaryKey(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence().findByPrimaryKey(servicePackageId);
	}

	/**
	* Returns the service package entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param servicePackageId the primary key of the service package entry
	* @return the service package entry, or <code>null</code> if a service package entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry fetchByPrimaryKey(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(servicePackageId);
	}

	/**
	* Returns all the service package entries where status = &#63;.
	*
	* @param status the status
	* @return the matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findBystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the service package entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @return the range of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the service package entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first service package entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findBystatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last service package entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findBystatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the service package entries before and after the current service package entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the primary key of the current service package entry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry[] findBystatus_PrevAndNext(
		long servicePackageId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findBystatus_PrevAndNext(servicePackageId, status,
			orderByComparator);
	}

	/**
	* Returns all the service package entries where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @return the matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByserviceId(serviceId);
	}

	/**
	* Returns a range of all the service package entries where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @return the range of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId(
		long serviceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByserviceId(serviceId, start, end);
	}

	/**
	* Returns an ordered range of all the service package entries where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId(
		long serviceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByserviceId(serviceId, start, end, orderByComparator);
	}

	/**
	* Returns the first service package entry in the ordered set where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByserviceId_First(
		long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findByserviceId_First(serviceId, orderByComparator);
	}

	/**
	* Returns the last service package entry in the ordered set where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByserviceId_Last(
		long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findByserviceId_Last(serviceId, orderByComparator);
	}

	/**
	* Returns the service package entries before and after the current service package entry in the ordered set where serviceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the primary key of the current service package entry
	* @param serviceId the service ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry[] findByserviceId_PrevAndNext(
		long servicePackageId, long serviceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findByserviceId_PrevAndNext(servicePackageId, serviceId,
			orderByComparator);
	}

	/**
	* Returns the service package entry where servicePackageName = &#63; or throws a {@link vn.com.fis.portal.NoSuchServicePackageEntryException} if it could not be found.
	*
	* @param servicePackageName the service package name
	* @return the matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByservicePackageName(
		java.lang.String servicePackageName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence().findByservicePackageName(servicePackageName);
	}

	/**
	* Returns the service package entry where servicePackageName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param servicePackageName the service package name
	* @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry fetchByservicePackageName(
		java.lang.String servicePackageName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByservicePackageName(servicePackageName);
	}

	/**
	* Returns the service package entry where servicePackageName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param servicePackageName the service package name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry fetchByservicePackageName(
		java.lang.String servicePackageName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByservicePackageName(servicePackageName,
			retrieveFromCache);
	}

	/**
	* Returns the service package entry where servicePackageCode = &#63; or throws a {@link vn.com.fis.portal.NoSuchServicePackageEntryException} if it could not be found.
	*
	* @param servicePackageCode the service package code
	* @return the matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByservicePackageCode(
		java.lang.String servicePackageCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence().findByservicePackageCode(servicePackageCode);
	}

	/**
	* Returns the service package entry where servicePackageCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param servicePackageCode the service package code
	* @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry fetchByservicePackageCode(
		java.lang.String servicePackageCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByservicePackageCode(servicePackageCode);
	}

	/**
	* Returns the service package entry where servicePackageCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param servicePackageCode the service package code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry fetchByservicePackageCode(
		java.lang.String servicePackageCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByservicePackageCode(servicePackageCode,
			retrieveFromCache);
	}

	/**
	* Returns all the service package entries where serviceId = &#63; and status = &#63;.
	*
	* @param serviceId the service ID
	* @param status the status
	* @return the matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId_status(
		long serviceId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByserviceId_status(serviceId, status);
	}

	/**
	* Returns a range of all the service package entries where serviceId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param status the status
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @return the range of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId_status(
		long serviceId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByserviceId_status(serviceId, status, start, end);
	}

	/**
	* Returns an ordered range of all the service package entries where serviceId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param status the status
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId_status(
		long serviceId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByserviceId_status(serviceId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first service package entry in the ordered set where serviceId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByserviceId_status_First(
		long serviceId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findByserviceId_status_First(serviceId, status,
			orderByComparator);
	}

	/**
	* Returns the last service package entry in the ordered set where serviceId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry findByserviceId_status_Last(
		long serviceId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findByserviceId_status_Last(serviceId, status,
			orderByComparator);
	}

	/**
	* Returns the service package entries before and after the current service package entry in the ordered set where serviceId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the primary key of the current service package entry
	* @param serviceId the service ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service package entry
	* @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServicePackageEntry[] findByserviceId_status_PrevAndNext(
		long servicePackageId, long serviceId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		return getPersistence()
				   .findByserviceId_status_PrevAndNext(servicePackageId,
			serviceId, status, orderByComparator);
	}

	/**
	* Returns all the service package entries.
	*
	* @return the service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the service package entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @return the range of service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the service package entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service package entries
	* @param end the upper bound of the range of service package entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the service package entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Removes all the service package entries where serviceId = &#63; from the database.
	*
	* @param serviceId the service ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByserviceId(long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByserviceId(serviceId);
	}

	/**
	* Removes the service package entry where servicePackageName = &#63; from the database.
	*
	* @param servicePackageName the service package name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByservicePackageName(
		java.lang.String servicePackageName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		getPersistence().removeByservicePackageName(servicePackageName);
	}

	/**
	* Removes the service package entry where servicePackageCode = &#63; from the database.
	*
	* @param servicePackageCode the service package code
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByservicePackageCode(
		java.lang.String servicePackageCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		getPersistence().removeByservicePackageCode(servicePackageCode);
	}

	/**
	* Removes all the service package entries where serviceId = &#63; and status = &#63; from the database.
	*
	* @param serviceId the service ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByserviceId_status(long serviceId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByserviceId_status(serviceId, status);
	}

	/**
	* Removes all the service package entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of service package entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Returns the number of service package entries where serviceId = &#63;.
	*
	* @param serviceId the service ID
	* @return the number of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByserviceId(long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByserviceId(serviceId);
	}

	/**
	* Returns the number of service package entries where servicePackageName = &#63;.
	*
	* @param servicePackageName the service package name
	* @return the number of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByservicePackageName(
		java.lang.String servicePackageName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByservicePackageName(servicePackageName);
	}

	/**
	* Returns the number of service package entries where servicePackageCode = &#63;.
	*
	* @param servicePackageCode the service package code
	* @return the number of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByservicePackageCode(
		java.lang.String servicePackageCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByservicePackageCode(servicePackageCode);
	}

	/**
	* Returns the number of service package entries where serviceId = &#63; and status = &#63;.
	*
	* @param serviceId the service ID
	* @param status the status
	* @return the number of matching service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByserviceId_status(long serviceId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByserviceId_status(serviceId, status);
	}

	/**
	* Returns the number of service package entries.
	*
	* @return the number of service package entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ServicePackageEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ServicePackageEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ServicePackageEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ServicePackageEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ServicePackageEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ServicePackageEntryUtil.class,
			"_persistence");
	}

	private static ServicePackageEntryPersistence _persistence;
}