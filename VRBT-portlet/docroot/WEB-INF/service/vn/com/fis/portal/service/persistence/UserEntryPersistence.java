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

import vn.com.fis.portal.model.UserEntry;

/**
 * The persistence interface for the user entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see UserEntryPersistenceImpl
 * @see UserEntryUtil
 * @generated
 */
public interface UserEntryPersistence extends BasePersistence<UserEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserEntryUtil} to access the user entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the user entry in the entity cache if it is enabled.
	*
	* @param userEntry the user entry
	*/
	public void cacheResult(vn.com.fis.portal.model.UserEntry userEntry);

	/**
	* Caches the user entries in the entity cache if it is enabled.
	*
	* @param userEntries the user entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.UserEntry> userEntries);

	/**
	* Creates a new user entry with the primary key. Does not add the user entry to the database.
	*
	* @param userId the primary key for the new user entry
	* @return the new user entry
	*/
	public vn.com.fis.portal.model.UserEntry create(long userId);

	/**
	* Removes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user entry
	* @return the user entry that was removed
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry remove(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	public vn.com.fis.portal.model.UserEntry updateImpl(
		vn.com.fis.portal.model.UserEntry userEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userId the primary key of the user entry
	* @return the user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByPrimaryKey(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Returns the user entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the user entry
	* @return the user entry, or <code>null</code> if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByPrimaryKey(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry where userName = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userName the user name
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByUserName(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Returns the user entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userName the user name
	* @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByUserName(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userName the user name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByUserName(
		java.lang.String userName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry where mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param mobileNumber the mobile number
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByMobileNumber(
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Returns the user entry where mobileNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mobileNumber the mobile number
	* @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByMobileNumber(
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry where mobileNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mobileNumber the mobile number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByMobileNumber(
		java.lang.String mobileNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry where userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Returns the user entry where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user entry where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry fetchByUserId(long userId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user entries.
	*
	* @return the user entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user entries
	* @param end the upper bound of the range of user entries (not inclusive)
	* @return the range of user entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user entries
	* @param end the upper bound of the range of user entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.UserEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user entry where userName = &#63; from the database.
	*
	* @param userName the user name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Removes the user entry where mobileNumber = &#63; from the database.
	*
	* @param mobileNumber the mobile number
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMobileNumber(java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Removes the user entry where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException;

	/**
	* Removes all the user entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries where mobileNumber = &#63;.
	*
	* @param mobileNumber the mobile number
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByMobileNumber(java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user entries.
	*
	* @return the number of user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}