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

import vn.com.fis.portal.model.ContactGroupVideoGroupEntry;

import java.util.List;

/**
 * The persistence utility for the contact group video group entry service. This utility wraps {@link ContactGroupVideoGroupEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupVideoGroupEntryPersistence
 * @see ContactGroupVideoGroupEntryPersistenceImpl
 * @generated
 */
public class ContactGroupVideoGroupEntryUtil {
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
	public static void clearCache(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		getPersistence().clearCache(contactGroupVideoGroupEntry);
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
	public static List<ContactGroupVideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactGroupVideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactGroupVideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContactGroupVideoGroupEntry update(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(contactGroupVideoGroupEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContactGroupVideoGroupEntry update(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(contactGroupVideoGroupEntry, merge, serviceContext);
	}

	/**
	* Caches the contact group video group entry in the entity cache if it is enabled.
	*
	* @param contactGroupVideoGroupEntry the contact group video group entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		getPersistence().cacheResult(contactGroupVideoGroupEntry);
	}

	/**
	* Caches the contact group video group entries in the entity cache if it is enabled.
	*
	* @param contactGroupVideoGroupEntries the contact group video group entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> contactGroupVideoGroupEntries) {
		getPersistence().cacheResult(contactGroupVideoGroupEntries);
	}

	/**
	* Creates a new contact group video group entry with the primary key. Does not add the contact group video group entry to the database.
	*
	* @param contactGroupVideoGroupEntryId the primary key for the new contact group video group entry
	* @return the new contact group video group entry
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry create(
		long contactGroupVideoGroupEntryId) {
		return getPersistence().create(contactGroupVideoGroupEntryId);
	}

	/**
	* Removes the contact group video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	* @return the contact group video group entry that was removed
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry remove(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence().remove(contactGroupVideoGroupEntryId);
	}

	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactGroupVideoGroupEntry, merge);
	}

	/**
	* Returns the contact group video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException} if it could not be found.
	*
	* @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	* @return the contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByPrimaryKey(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence().findByPrimaryKey(contactGroupVideoGroupEntryId);
	}

	/**
	* Returns the contact group video group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	* @return the contact group video group entry, or <code>null</code> if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry fetchByPrimaryKey(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactGroupVideoGroupEntryId);
	}

	/**
	* Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException} if it could not be found.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @return the matching contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByContactGroup_VideoGroup(contactGroupId, videoGroupId);
	}

	/**
	* Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @return the matching contact group video group entry, or <code>null</code> if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry fetchByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactGroup_VideoGroup(contactGroupId, videoGroupId);
	}

	/**
	* Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contact group video group entry, or <code>null</code> if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry fetchByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContactGroup_VideoGroup(contactGroupId,
			videoGroupId, retrieveFromCache);
	}

	/**
	* Returns all the contact group video group entries where contactGroupId = &#63;.
	*
	* @param contactGroupId the contact group ID
	* @return the matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContactGroup(contactGroupId);
	}

	/**
	* Returns a range of all the contact group video group entries where contactGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupId the contact group ID
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @return the range of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContactGroup(contactGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the contact group video group entries where contactGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupId the contact group ID
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContactGroup(contactGroupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first contact group video group entry in the ordered set where contactGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupId the contact group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByContactGroup_First(
		long contactGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByContactGroup_First(contactGroupId, orderByComparator);
	}

	/**
	* Returns the last contact group video group entry in the ordered set where contactGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupId the contact group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByContactGroup_Last(
		long contactGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByContactGroup_Last(contactGroupId, orderByComparator);
	}

	/**
	* Returns the contact group video group entries before and after the current contact group video group entry in the ordered set where contactGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupVideoGroupEntryId the primary key of the current contact group video group entry
	* @param contactGroupId the contact group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry[] findByContactGroup_PrevAndNext(
		long contactGroupVideoGroupEntryId, long contactGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByContactGroup_PrevAndNext(contactGroupVideoGroupEntryId,
			contactGroupId, orderByComparator);
	}

	/**
	* Returns all the contact group video group entries where videoGroupId = &#63;.
	*
	* @param videoGroupId the video group ID
	* @return the matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByVideoGroup(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoGroup(videoGroupId);
	}

	/**
	* Returns a range of all the contact group video group entries where videoGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupId the video group ID
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @return the range of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByVideoGroup(
		long videoGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoGroup(videoGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the contact group video group entries where videoGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupId the video group ID
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByVideoGroup(
		long videoGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoGroup(videoGroupId, start, end, orderByComparator);
	}

	/**
	* Returns the first contact group video group entry in the ordered set where videoGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupId the video group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByVideoGroup_First(
		long videoGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByVideoGroup_First(videoGroupId, orderByComparator);
	}

	/**
	* Returns the last contact group video group entry in the ordered set where videoGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupId the video group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByVideoGroup_Last(
		long videoGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByVideoGroup_Last(videoGroupId, orderByComparator);
	}

	/**
	* Returns the contact group video group entries before and after the current contact group video group entry in the ordered set where videoGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupVideoGroupEntryId the primary key of the current contact group video group entry
	* @param videoGroupId the video group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupVideoGroupEntry[] findByVideoGroup_PrevAndNext(
		long contactGroupVideoGroupEntryId, long videoGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return getPersistence()
				   .findByVideoGroup_PrevAndNext(contactGroupVideoGroupEntryId,
			videoGroupId, orderByComparator);
	}

	/**
	* Returns all the contact group video group entries.
	*
	* @return the contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the contact group video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @return the range of contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the contact group video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; from the database.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		getPersistence()
			.removeByContactGroup_VideoGroup(contactGroupId, videoGroupId);
	}

	/**
	* Removes all the contact group video group entries where contactGroupId = &#63; from the database.
	*
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactGroup(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContactGroup(contactGroupId);
	}

	/**
	* Removes all the contact group video group entries where videoGroupId = &#63; from the database.
	*
	* @param videoGroupId the video group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoGroup(long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideoGroup(videoGroupId);
	}

	/**
	* Removes all the contact group video group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contact group video group entries where contactGroupId = &#63; and videoGroupId = &#63;.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @return the number of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByContactGroup_VideoGroup(contactGroupId, videoGroupId);
	}

	/**
	* Returns the number of contact group video group entries where contactGroupId = &#63;.
	*
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactGroup(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContactGroup(contactGroupId);
	}

	/**
	* Returns the number of contact group video group entries where videoGroupId = &#63;.
	*
	* @param videoGroupId the video group ID
	* @return the number of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoGroup(long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideoGroup(videoGroupId);
	}

	/**
	* Returns the number of contact group video group entries.
	*
	* @return the number of contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactGroupVideoGroupEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactGroupVideoGroupEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ContactGroupVideoGroupEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactGroupVideoGroupEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(
		ContactGroupVideoGroupEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ContactGroupVideoGroupEntryUtil.class,
			"_persistence");
	}

	private static ContactGroupVideoGroupEntryPersistence _persistence;
}