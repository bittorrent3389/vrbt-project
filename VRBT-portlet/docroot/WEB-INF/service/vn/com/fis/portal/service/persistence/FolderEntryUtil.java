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

import vn.com.fis.portal.model.FolderEntry;

import java.util.List;

/**
 * The persistence utility for the folder entry service. This utility wraps {@link FolderEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see FolderEntryPersistence
 * @see FolderEntryPersistenceImpl
 * @generated
 */
public class FolderEntryUtil {
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
	public static void clearCache(FolderEntry folderEntry) {
		getPersistence().clearCache(folderEntry);
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
	public static List<FolderEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FolderEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FolderEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static FolderEntry update(FolderEntry folderEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(folderEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static FolderEntry update(FolderEntry folderEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(folderEntry, merge, serviceContext);
	}

	/**
	* Caches the folder entry in the entity cache if it is enabled.
	*
	* @param folderEntry the folder entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.FolderEntry folderEntry) {
		getPersistence().cacheResult(folderEntry);
	}

	/**
	* Caches the folder entries in the entity cache if it is enabled.
	*
	* @param folderEntries the folder entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.FolderEntry> folderEntries) {
		getPersistence().cacheResult(folderEntries);
	}

	/**
	* Creates a new folder entry with the primary key. Does not add the folder entry to the database.
	*
	* @param folderId the primary key for the new folder entry
	* @return the new folder entry
	*/
	public static vn.com.fis.portal.model.FolderEntry create(long folderId) {
		return getPersistence().create(folderId);
	}

	/**
	* Removes the folder entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param folderId the primary key of the folder entry
	* @return the folder entry that was removed
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.FolderEntry remove(long folderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence().remove(folderId);
	}

	public static vn.com.fis.portal.model.FolderEntry updateImpl(
		vn.com.fis.portal.model.FolderEntry folderEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(folderEntry, merge);
	}

	/**
	* Returns the folder entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchFolderEntryException} if it could not be found.
	*
	* @param folderId the primary key of the folder entry
	* @return the folder entry
	* @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.FolderEntry findByPrimaryKey(
		long folderId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence().findByPrimaryKey(folderId);
	}

	/**
	* Returns the folder entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param folderId the primary key of the folder entry
	* @return the folder entry, or <code>null</code> if a folder entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.FolderEntry fetchByPrimaryKey(
		long folderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(folderId);
	}

	/**
	* Returns all the folder entries where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderName(
		java.lang.String folderName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFolderName(folderName);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderName(
		java.lang.String folderName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFolderName(folderName, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderName(
		java.lang.String folderName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFolderName(folderName, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry findByFolderName_First(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByFolderName_First(folderName, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry findByFolderName_Last(
		java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByFolderName_Last(folderName, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry[] findByFolderName_PrevAndNext(
		long folderId, java.lang.String folderName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByFolderName_PrevAndNext(folderId, folderName,
			orderByComparator);
	}

	/**
	* Returns all the folder entries where folderIdParent = &#63;.
	*
	* @param folderIdParent the folder ID parent
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent(
		long folderIdParent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFolderIdParent(folderIdParent);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent(
		long folderIdParent, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFolderIdParent(folderIdParent, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByFolderIdParent(
		long folderIdParent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFolderIdParent(folderIdParent, start, end,
			orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry findByFolderIdParent_First(
		long folderIdParent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByFolderIdParent_First(folderIdParent, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry findByFolderIdParent_Last(
		long folderIdParent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByFolderIdParent_Last(folderIdParent, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry[] findByFolderIdParent_PrevAndNext(
		long folderId, long folderIdParent,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByFolderIdParent_PrevAndNext(folderId, folderIdParent,
			orderByComparator);
	}

	/**
	* Returns all the folder entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.FolderEntry[] findByUserId_PrevAndNext(
		long folderId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchFolderEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(folderId, userId, orderByComparator);
	}

	/**
	* Returns all the folder entries.
	*
	* @return the folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.FolderEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the folder entries where folderName = &#63; from the database.
	*
	* @param folderName the folder name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFolderName(java.lang.String folderName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFolderName(folderName);
	}

	/**
	* Removes all the folder entries where folderIdParent = &#63; from the database.
	*
	* @param folderIdParent the folder ID parent
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFolderIdParent(long folderIdParent)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFolderIdParent(folderIdParent);
	}

	/**
	* Removes all the folder entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes all the folder entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of folder entries where folderName = &#63;.
	*
	* @param folderName the folder name
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFolderName(java.lang.String folderName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFolderName(folderName);
	}

	/**
	* Returns the number of folder entries where folderIdParent = &#63;.
	*
	* @param folderIdParent the folder ID parent
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFolderIdParent(long folderIdParent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFolderIdParent(folderIdParent);
	}

	/**
	* Returns the number of folder entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of folder entries.
	*
	* @return the number of folder entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FolderEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FolderEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					FolderEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(FolderEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(FolderEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(FolderEntryUtil.class,
			"_persistence");
	}

	private static FolderEntryPersistence _persistence;
}