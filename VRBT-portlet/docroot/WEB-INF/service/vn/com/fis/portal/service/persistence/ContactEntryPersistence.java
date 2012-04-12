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

import vn.com.fis.portal.model.ContactEntry;

/**
 * The persistence interface for the contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactEntryPersistenceImpl
 * @see ContactEntryUtil
 * @generated
 */
public interface ContactEntryPersistence extends BasePersistence<ContactEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactEntryUtil} to access the contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contact entry in the entity cache if it is enabled.
	*
	* @param contactEntry the contact entry
	*/
	public void cacheResult(vn.com.fis.portal.model.ContactEntry contactEntry);

	/**
	* Caches the contact entries in the entity cache if it is enabled.
	*
	* @param contactEntries the contact entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.ContactEntry> contactEntries);

	/**
	* Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	*
	* @param contactId the primary key for the new contact entry
	* @return the new contact entry
	*/
	public vn.com.fis.portal.model.ContactEntry create(long contactId);

	/**
	* Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the contact entry
	* @return the contact entry that was removed
	* @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactEntry remove(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException;

	public vn.com.fis.portal.model.ContactEntry updateImpl(
		vn.com.fis.portal.model.ContactEntry contactEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	*
	* @param contactId the primary key of the contact entry
	* @return the contact entry
	* @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactEntry findByPrimaryKey(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException;

	/**
	* Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactId the primary key of the contact entry
	* @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactEntry fetchByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact entry where userId = &#63; and mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @return the matching contact entry
	* @throws vn.com.fis.portal.NoSuchContactEntryException if a matching contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactEntry findByUserId_MobileNumber(
		long userId, java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException;

	/**
	* Returns the contact entry where userId = &#63; and mobileNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactEntry fetchByUserId_MobileNumber(
		long userId, java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact entry where userId = &#63; and mobileNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactEntry fetchByUserId_MobileNumber(
		long userId, java.lang.String mobileNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact entries.
	*
	* @return the contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact entries
	* @param end the upper bound of the range of contact entries (not inclusive)
	* @return the range of contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact entries
	* @param end the upper bound of the range of contact entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the contact entry where userId = &#63; and mobileNumber = &#63; from the database.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_MobileNumber(long userId,
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException;

	/**
	* Removes all the contact entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact entries where userId = &#63; and mobileNumber = &#63;.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @return the number of matching contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_MobileNumber(long userId,
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact entries.
	*
	* @return the number of contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}