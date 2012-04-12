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

import vn.com.fis.portal.model.ContactGroupEntry;

/**
 * The persistence interface for the contact group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupEntryPersistenceImpl
 * @see ContactGroupEntryUtil
 * @generated
 */
public interface ContactGroupEntryPersistence extends BasePersistence<ContactGroupEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ContactGroupEntryUtil} to access the contact group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the contact group entry in the entity cache if it is enabled.
	*
	* @param contactGroupEntry the contact group entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry);

	/**
	* Caches the contact group entries in the entity cache if it is enabled.
	*
	* @param contactGroupEntries the contact group entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.ContactGroupEntry> contactGroupEntries);

	/**
	* Creates a new contact group entry with the primary key. Does not add the contact group entry to the database.
	*
	* @param contactGroupId the primary key for the new contact group entry
	* @return the new contact group entry
	*/
	public vn.com.fis.portal.model.ContactGroupEntry create(long contactGroupId);

	/**
	* Removes the contact group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry that was removed
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry remove(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	public vn.com.fis.portal.model.ContactGroupEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry findByPrimaryKey(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	/**
	* Returns the contact group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry, or <code>null</code> if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry fetchByPrimaryKey(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact group entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact group entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of contact group entries
	* @param end the upper bound of the range of contact group entries (not inclusive)
	* @return the range of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact group entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of contact group entries
	* @param end the upper bound of the range of contact group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first contact group entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	/**
	* Returns the last contact group entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	/**
	* Returns the contact group entries before and after the current contact group entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupId the primary key of the current contact group entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry[] findByUserId_PrevAndNext(
		long contactGroupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry findByUserId_ContactGroupId(
		long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group entry, or <code>null</code> if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry fetchByUserId_ContactGroupId(
		long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contact group entry, or <code>null</code> if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupEntry fetchByUserId_ContactGroupId(
		long userId, long contactGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the contact group entries.
	*
	* @return the contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the contact group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group entries
	* @param end the upper bound of the range of contact group entries (not inclusive)
	* @return the range of contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the contact group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group entries
	* @param end the upper bound of the range of contact group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the contact group entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the contact group entry where userId = &#63; and contactGroupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ContactGroupId(long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException;

	/**
	* Removes all the contact group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact group entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact group entries where userId = &#63; and contactGroupId = &#63;.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_ContactGroupId(long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of contact group entries.
	*
	* @return the number of contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}