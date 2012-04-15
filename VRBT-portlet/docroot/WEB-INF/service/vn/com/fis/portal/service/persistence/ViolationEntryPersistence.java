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

import vn.com.fis.portal.model.ViolationEntry;

/**
 * The persistence interface for the violation entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ViolationEntryPersistenceImpl
 * @see ViolationEntryUtil
 * @generated
 */
public interface ViolationEntryPersistence extends BasePersistence<ViolationEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViolationEntryUtil} to access the violation entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the violation entry in the entity cache if it is enabled.
	*
	* @param violationEntry the violation entry
	*/
	public void cacheResult(
		vn.com.fis.portal.model.ViolationEntry violationEntry);

	/**
	* Caches the violation entries in the entity cache if it is enabled.
	*
	* @param violationEntries the violation entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.ViolationEntry> violationEntries);

	/**
	* Creates a new violation entry with the primary key. Does not add the violation entry to the database.
	*
	* @param violationId the primary key for the new violation entry
	* @return the new violation entry
	*/
	public vn.com.fis.portal.model.ViolationEntry create(long violationId);

	/**
	* Removes the violation entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry that was removed
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry remove(long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	public vn.com.fis.portal.model.ViolationEntry updateImpl(
		vn.com.fis.portal.model.ViolationEntry violationEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the violation entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchViolationEntryException} if it could not be found.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry findByPrimaryKey(
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns the violation entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry, or <code>null</code> if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry fetchByPrimaryKey(
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the violation entries where violationTitle = &#63;.
	*
	* @param violationTitle the violation title
	* @return the matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByTitle(
		java.lang.String violationTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation entries where violationTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationTitle the violation title
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @return the range of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByTitle(
		java.lang.String violationTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the violation entries where violationTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationTitle the violation title
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByTitle(
		java.lang.String violationTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first violation entry in the ordered set where violationTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationTitle the violation title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry findByTitle_First(
		java.lang.String violationTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns the last violation entry in the ordered set where violationTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationTitle the violation title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry findByTitle_Last(
		java.lang.String violationTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns the violation entries before and after the current violation entry in the ordered set where violationTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationId the primary key of the current violation entry
	* @param violationTitle the violation title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry[] findByTitle_PrevAndNext(
		long violationId, java.lang.String violationTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns all the violation entries where status = &#63;.
	*
	* @param status the status
	* @return the matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @return the range of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the violation entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first violation entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns the last violation entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns the violation entries before and after the current violation entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param violationId the primary key of the current violation entry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry[] findByStatus_PrevAndNext(
		long violationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException;

	/**
	* Returns all the violation entries.
	*
	* @return the violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @return the range of violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the violation entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the violation entries where violationTitle = &#63; from the database.
	*
	* @param violationTitle the violation title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String violationTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the violation entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the violation entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation entries where violationTitle = &#63;.
	*
	* @param violationTitle the violation title
	* @return the number of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String violationTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation entries.
	*
	* @return the number of violation entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}