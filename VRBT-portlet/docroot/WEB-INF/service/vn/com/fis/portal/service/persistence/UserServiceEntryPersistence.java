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

import vn.com.fis.portal.model.UserServiceEntry;

/**
 * The persistence interface for the user service entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see UserServiceEntryPersistenceImpl
 * @see UserServiceEntryUtil
 * @generated
 */
public interface UserServiceEntryPersistence extends BasePersistence<UserServiceEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserServiceEntryUtil} to access the user service entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user service entry in the entity cache if it is enabled.
	*
	* @param userServiceEntry the user service entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry);

	/**
	* Caches the user service entries in the entity cache if it is enabled.
	*
	* @param userServiceEntries the user service entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.UserServiceEntry> userServiceEntries);

	/**
	* Creates a new user service entry with the primary key. Does not add the user service entry to the database.
	*
	* @param userServiceId the primary key for the new user service entry
	* @return the new user service entry
	*/
	public vn.com.fis.portal.model.UserServiceEntry create(long userServiceId);

	/**
	* Removes the user service entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceId the primary key of the user service entry
	* @return the user service entry that was removed
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry remove(long userServiceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	public vn.com.fis.portal.model.UserServiceEntry updateImpl(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userServiceId the primary key of the user service entry
	* @return the user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByPrimaryKey(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userServiceId the primary key of the user service entry
	* @return the user service entry, or <code>null</code> if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByPrimaryKey(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @return the matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId(
		long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByUserId_ServiceId(
		long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByUserId_ServiceId(
		long userId, long serviceId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry where userId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @return the matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServicePackageId(
		long userId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entry where userId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByUserId_ServicePackageId(
		long userId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry where userId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByUserId_ServicePackageId(
		long userId, long servicePackageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @return the matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId_PackageId(
		long userId, long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByUserId_ServiceId_PackageId(
		long userId, long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry fetchByUserId_ServiceId_PackageId(
		long userId, long serviceId, long servicePackageId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user service entries where userId = &#63; and serviceStatus = &#63;.
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @return the matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByUserId_serviceStatus(
		long userId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user service entries where userId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @return the range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByUserId_serviceStatus(
		long userId, int serviceStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user service entries where userId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByUserId_serviceStatus(
		long userId, int serviceStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user service entry in the ordered set where userId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_serviceStatus_First(
		long userId, int serviceStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the last user service entry in the ordered set where userId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_serviceStatus_Last(
		long userId, int serviceStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entries before and after the current user service entry in the ordered set where userId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userServiceId the primary key of the current user service entry
	* @param userId the user ID
	* @param serviceStatus the service status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry[] findByUserId_serviceStatus_PrevAndNext(
		long userServiceId, long userId, int serviceStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns all the user service entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user service entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @return the range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user service entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user service entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the last user service entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entries before and after the current user service entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userServiceId the primary key of the current user service entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry[] findByuserId_PrevAndNext(
		long userServiceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns all the user service entries where servicePackageId = &#63;.
	*
	* @param servicePackageId the service package ID
	* @return the matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByservicePackageId(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user service entries where servicePackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the service package ID
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @return the range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByservicePackageId(
		long servicePackageId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user service entries where servicePackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the service package ID
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByservicePackageId(
		long servicePackageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user service entry in the ordered set where servicePackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the service package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByservicePackageId_First(
		long servicePackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the last user service entry in the ordered set where servicePackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param servicePackageId the service package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByservicePackageId_Last(
		long servicePackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entries before and after the current user service entry in the ordered set where servicePackageId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userServiceId the primary key of the current user service entry
	* @param servicePackageId the service package ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry[] findByservicePackageId_PrevAndNext(
		long userServiceId, long servicePackageId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns all the user service entries where serviceId = &#63; and serviceStatus = &#63;.
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @return the matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByserviceId_Status(
		long serviceId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user service entries where serviceId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @return the range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByserviceId_Status(
		long serviceId, int serviceStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user service entries where serviceId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByserviceId_Status(
		long serviceId, int serviceStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first user service entry in the ordered set where serviceId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByserviceId_Status_First(
		long serviceId, int serviceStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the last user service entry in the ordered set where serviceId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry findByserviceId_Status_Last(
		long serviceId, int serviceStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns the user service entries before and after the current user service entry in the ordered set where serviceId = &#63; and serviceStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userServiceId the primary key of the current user service entry
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry[] findByserviceId_Status_PrevAndNext(
		long userServiceId, long serviceId, int serviceStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Returns all the user service entries.
	*
	* @return the user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user service entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @return the range of user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user service entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user service entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user service entry where userId = &#63; and serviceId = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ServiceId(long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Removes the user service entry where userId = &#63; and servicePackageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Removes the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	/**
	* Removes all the user service entries where userId = &#63; and serviceStatus = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_serviceStatus(long userId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user service entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user service entries where servicePackageId = &#63; from the database.
	*
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByservicePackageId(long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user service entries where serviceId = &#63; and serviceStatus = &#63; from the database.
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByserviceId_Status(long serviceId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user service entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where userId = &#63; and serviceId = &#63;.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_ServiceId(long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where userId = &#63; and servicePackageId = &#63;.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_ServicePackageId(long userId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where userId = &#63; and serviceId = &#63; and servicePackageId = &#63;.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where userId = &#63; and serviceStatus = &#63;.
	*
	* @param userId the user ID
	* @param serviceStatus the service status
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_serviceStatus(long userId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where servicePackageId = &#63;.
	*
	* @param servicePackageId the service package ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByservicePackageId(long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries where serviceId = &#63; and serviceStatus = &#63;.
	*
	* @param serviceId the service ID
	* @param serviceStatus the service status
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByserviceId_Status(long serviceId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries.
	*
	* @return the number of user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}