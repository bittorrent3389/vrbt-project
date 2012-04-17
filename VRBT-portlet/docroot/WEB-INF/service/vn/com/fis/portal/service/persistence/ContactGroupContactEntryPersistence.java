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

import vn.com.fis.portal.model.ContactGroupContactEntry;

/**
 * The persistence interface for the contact group contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupContactEntryPersistenceImpl
 * @see ContactGroupContactEntryUtil
 * @generated
 */
public interface ContactGroupContactEntryPersistence extends BasePersistence<ContactGroupContactEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactGroupContactEntryUtil} to access the contact group contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contact group contact entry in the entity cache if it is enabled.
	*
	* @param contactGroupContactEntry the contact group contact entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry);

	/**
	* Caches the contact group contact entries in the entity cache if it is enabled.
	*
	* @param contactGroupContactEntries the contact group contact entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.ContactGroupContactEntry> contactGroupContactEntries);

	/**
	* Creates a new contact group contact entry with the primary key. Does not add the contact group contact entry to the database.
	*
	* @param contactGroupContactId the primary key for the new contact group contact entry
	* @return the new contact group contact entry
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry create(
		long contactGroupContactId);

	/**
	* Removes the contact group contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupContactId the primary key of the contact group contact entry
	* @return the contact group contact entry that was removed
	* @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a contact group contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry remove(
		long contactGroupContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupContactEntryException;

	public vn.com.fis.portal.model.ContactGroupContactEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact group contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupContactEntryException} if it could not be found.
	*
	* @param contactGroupContactId the primary key of the contact group contact entry
	* @return the contact group contact entry
	* @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a contact group contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry findByPrimaryKey(
		long contactGroupContactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupContactEntryException;

	/**
	* Returns the contact group contact entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactGroupContactId the primary key of the contact group contact entry
	* @return the contact group contact entry, or <code>null</code> if a contact group contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry fetchByPrimaryKey(
		long contactGroupContactId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupContactEntryException} if it could not be found.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group contact entry
	* @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a matching contact group contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry findByContactId_ContactGroupId(
		java.lang.String contactId, java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupContactEntryException;

	/**
	* Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group contact entry, or <code>null</code> if a matching contact group contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry fetchByContactId_ContactGroupId(
		java.lang.String contactId, java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contact group contact entry, or <code>null</code> if a matching contact group contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupContactEntry fetchByContactId_ContactGroupId(
		java.lang.String contactId, java.lang.String contactGroupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact group contact entries.
	*
	* @return the contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupContactEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact group contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group contact entries
	* @param end the upper bound of the range of contact group contact entries (not inclusive)
	* @return the range of contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupContactEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact group contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group contact entries
	* @param end the upper bound of the range of contact group contact entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the contact group contact entry where contactId = &#63; and contactGroupId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactId_ContactGroupId(java.lang.String contactId,
		java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupContactEntryException;

	/**
	* Removes all the contact group contact entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact group contact entries where contactId = &#63; and contactGroupId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactId_ContactGroupId(java.lang.String contactId,
		java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact group contact entries.
	*
	* @return the number of contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}