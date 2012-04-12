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

import vn.com.fis.portal.model.ServiceEntry;

/**
 * The persistence interface for the service entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ServiceEntryPersistenceImpl
 * @see ServiceEntryUtil
 * @generated
 */
public interface ServiceEntryPersistence extends BasePersistence<ServiceEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceEntryUtil} to access the service entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the service entry in the entity cache if it is enabled.
	*
	* @param serviceEntry the service entry
	*/
	public void cacheResult(vn.com.fis.portal.model.ServiceEntry serviceEntry);

	/**
	* Caches the service entries in the entity cache if it is enabled.
	*
	* @param serviceEntries the service entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.ServiceEntry> serviceEntries);

	/**
	* Creates a new service entry with the primary key. Does not add the service entry to the database.
	*
	* @param serviceId the primary key for the new service entry
	* @return the new service entry
	*/
	public vn.com.fis.portal.model.ServiceEntry create(long serviceId);

	/**
	* Removes the service entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceId the primary key of the service entry
	* @return the service entry that was removed
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry remove(long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	public vn.com.fis.portal.model.ServiceEntry updateImpl(
		vn.com.fis.portal.model.ServiceEntry serviceEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchServiceEntryException} if it could not be found.
	*
	* @param serviceId the primary key of the service entry
	* @return the service entry
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry findByPrimaryKey(long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Returns the service entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param serviceId the primary key of the service entry
	* @return the service entry, or <code>null</code> if a service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry fetchByPrimaryKey(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service entry where serviceCode = &#63; or throws a {@link vn.com.fis.portal.NoSuchServiceEntryException} if it could not be found.
	*
	* @param serviceCode the service code
	* @return the matching service entry
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry findByserviceCode(
		java.lang.String serviceCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Returns the service entry where serviceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceCode the service code
	* @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry fetchByserviceCode(
		java.lang.String serviceCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service entry where serviceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceCode the service code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry fetchByserviceCode(
		java.lang.String serviceCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service entry where serviceName = &#63; or throws a {@link vn.com.fis.portal.NoSuchServiceEntryException} if it could not be found.
	*
	* @param serviceName the service name
	* @return the matching service entry
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry findByserviceName(
		java.lang.String serviceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Returns the service entry where serviceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param serviceName the service name
	* @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry fetchByserviceName(
		java.lang.String serviceName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the service entry where serviceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param serviceName the service name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry fetchByserviceName(
		java.lang.String serviceName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the service entries where status = &#63;.
	*
	* @param status the status
	* @return the matching service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ServiceEntry> findBystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of service entries
	* @param end the upper bound of the range of service entries (not inclusive)
	* @return the range of matching service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ServiceEntry> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of service entries
	* @param end the upper bound of the range of service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ServiceEntry> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first service entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching service entry
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry findBystatus_First(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Returns the last service entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching service entry
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry findBystatus_Last(int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Returns the service entries before and after the current service entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the primary key of the current service entry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next service entry
	* @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ServiceEntry[] findBystatus_PrevAndNext(
		long serviceId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Returns all the service entries.
	*
	* @return the service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ServiceEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the service entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service entries
	* @param end the upper bound of the range of service entries (not inclusive)
	* @return the range of service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ServiceEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the service entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service entries
	* @param end the upper bound of the range of service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ServiceEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the service entry where serviceCode = &#63; from the database.
	*
	* @param serviceCode the service code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByserviceCode(java.lang.String serviceCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Removes the service entry where serviceName = &#63; from the database.
	*
	* @param serviceName the service name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByserviceName(java.lang.String serviceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException;

	/**
	* Removes all the service entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the service entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service entries where serviceCode = &#63;.
	*
	* @param serviceCode the service code
	* @return the number of matching service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByserviceCode(java.lang.String serviceCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service entries where serviceName = &#63;.
	*
	* @param serviceName the service name
	* @return the number of matching service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByserviceName(java.lang.String serviceName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of service entries.
	*
	* @return the number of service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}