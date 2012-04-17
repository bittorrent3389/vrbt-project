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

import vn.com.fis.portal.model.FolderEntry;

/**
 * The persistence interface for the folder entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see FolderEntryPersistenceImpl
 * @see FolderEntryUtil
 * @generated
 */
public interface FolderEntryPersistence extends BasePersistence<FolderEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FolderEntryUtil} to access the folder entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the folder entry in the entity cache if it is enabled.
	*
	* @param folderEntry the folder entry
	*/
	public void cacheResult(vn.com.fis.portal.model.FolderEntry folderEntry);

	/**
	* Caches the folder entries in the entity cache if it is enabled.
	*
	* @param folderEntries the folder entries
	*/
	public void cacheResult(
		java.util.List<vn.com.fis.portal.model.FolderEntry> folderEntries);

	/**
	* Creates a new folder entry with the primary key. Does not add the folder entry to the database.
	*
	* @param folderId the primary key for the new folder entry
	* @return the new folder entry
	*/
	public vn.com.fis.portal.model.FolderEntry create(long folderId);

	/**
	* Removes the folder entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param folderId the primary key of the folder entry
	* @return the folder entry that was removed
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry remove(long folderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	public vn.com.fis.portal.model.FolderEntry updateImpl(
		vn.com.fis.portal.model.FolderEntry folderEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the folder entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchFolderEntryException} if it could not be found.
	*
	* @param folderId the primary key of the folder entry
	* @return the folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByPrimaryKey(long folderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param folderId the primary key of the folder entry
	* @return the folder entry, or <code>null</code> if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry fetchByPrimaryKey(long folderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the folder entries where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderName(
		java.lang.String folderName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the folder entries where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderName the folder name
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @return the range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderName(
		java.lang.String folderName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the folder entries where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderName the folder name
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderName(
		java.lang.String folderName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first folder entry in the ordered set where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderName_First(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the last folder entry in the ordered set where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderName_Last(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entries before and after the current folder entry in the ordered set where folderName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current folder entry
	* @param folderName the folder name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry[] findByFolderName_PrevAndNext(
		long folderId, java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entry where folderName = &#63; and userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchFolderEntryException} if it could not be found.
	*
	* @param folderName the folder name
	* @param userId the user ID
	* @return the matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderNameAbsolute_UserId(
		java.lang.String folderName, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entry where folderName = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param folderName the folder name
	* @param userId the user ID
	* @return the matching folder entry, or <code>null</code> if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry fetchByFolderNameAbsolute_UserId(
		java.lang.String folderName, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the folder entry where folderName = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param folderName the folder name
	* @param userId the user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching folder entry, or <code>null</code> if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry fetchByFolderNameAbsolute_UserId(
		java.lang.String folderName, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the folder entries where folderIdParent = &#63;.
	*
	* @param folderIdParent the folder ID parent
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent(
		long folderIdParent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the folder entries where folderIdParent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @return the range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent(
		long folderIdParent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the folder entries where folderIdParent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent(
		long folderIdParent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first folder entry in the ordered set where folderIdParent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderIdParent_First(
		long folderIdParent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the last folder entry in the ordered set where folderIdParent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderIdParent_Last(
		long folderIdParent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entries before and after the current folder entry in the ordered set where folderIdParent = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current folder entry
	* @param folderIdParent the folder ID parent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry[] findByFolderIdParent_PrevAndNext(
		long folderId, long folderIdParent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns all the folder entries where folderIdParent = &#63; and userId = &#63;.
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent_UserId(
		long folderIdParent, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the folder entries where folderIdParent = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @return the range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent_UserId(
		long folderIdParent, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the folder entries where folderIdParent = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent_UserId(
		long folderIdParent, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first folder entry in the ordered set where folderIdParent = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderIdParent_UserId_First(
		long folderIdParent, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the last folder entry in the ordered set where folderIdParent = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByFolderIdParent_UserId_Last(
		long folderIdParent, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entries before and after the current folder entry in the ordered set where folderIdParent = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current folder entry
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry[] findByFolderIdParent_UserId_PrevAndNext(
		long folderId, long folderIdParent, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns all the folder entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the folder entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @return the range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the folder entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first folder entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the last folder entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns the folder entries before and after the current folder entry in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param folderId the primary key of the current folder entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.FolderEntry[] findByUserId_PrevAndNext(
		long folderId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Returns all the folder entries.
	*
	* @return the folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the folder entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @return the range of folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the folder entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of folder entries
	* @param end the upper bound of the range of folder entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of folder entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.FolderEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the folder entries where folderName = &#63; from the database.
	*
	* @param folderName the folder name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFolderName(java.lang.String folderName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the folder entry where folderName = &#63; and userId = &#63; from the database.
	*
	* @param folderName the folder name
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFolderNameAbsolute_UserId(java.lang.String folderName,
		long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException;

	/**
	* Removes all the folder entries where folderIdParent = &#63; from the database.
	*
	* @param folderIdParent the folder ID parent
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFolderIdParent(long folderIdParent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the folder entries where folderIdParent = &#63; and userId = &#63; from the database.
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFolderIdParent_UserId(long folderIdParent, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the folder entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the folder entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of folder entries where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByFolderName(java.lang.String folderName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of folder entries where folderName = &#63; and userId = &#63;.
	*
	* @param folderName the folder name
	* @param userId the user ID
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByFolderNameAbsolute_UserId(java.lang.String folderName,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of folder entries where folderIdParent = &#63;.
	*
	* @param folderIdParent the folder ID parent
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByFolderIdParent(long folderIdParent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of folder entries where folderIdParent = &#63; and userId = &#63;.
	*
	* @param folderIdParent the folder ID parent
	* @param userId the user ID
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByFolderIdParent_UserId(long folderIdParent, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of folder entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of folder entries.
	*
	* @return the number of folder entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}