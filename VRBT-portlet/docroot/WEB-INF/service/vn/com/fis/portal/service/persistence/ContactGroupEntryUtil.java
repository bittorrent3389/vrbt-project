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

import vn.com.fis.portal.model.ContactGroupEntry;

import java.util.List;

/**
 * The persistence utility for the contact group entry service. This utility wraps {@link ContactGroupEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupEntryPersistence
 * @see ContactGroupEntryPersistenceImpl
 * @generated
 */
public class ContactGroupEntryUtil {
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
	public static void clearCache(ContactGroupEntry contactGroupEntry) {
		getPersistence().clearCache(contactGroupEntry);
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
	public static List<ContactGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContactGroupEntry update(
		ContactGroupEntry contactGroupEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(contactGroupEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContactGroupEntry update(
		ContactGroupEntry contactGroupEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactGroupEntry, merge, serviceContext);
	}

	/**
	* Caches the contact group entry in the entity cache if it is enabled.
	*
	* @param contactGroupEntry the contact group entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry) {
		getPersistence().cacheResult(contactGroupEntry);
	}

	/**
	* Caches the contact group entries in the entity cache if it is enabled.
	*
	* @param contactGroupEntries the contact group entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.ContactGroupEntry> contactGroupEntries) {
		getPersistence().cacheResult(contactGroupEntries);
	}

	/**
	* Creates a new contact group entry with the primary key. Does not add the contact group entry to the database.
	*
	* @param contactGroupId the primary key for the new contact group entry
	* @return the new contact group entry
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry create(
		long contactGroupId) {
		return getPersistence().create(contactGroupId);
	}

	/**
	* Removes the contact group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry that was removed
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry remove(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getPersistence().remove(contactGroupId);
	}

	public static vn.com.fis.portal.model.ContactGroupEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactGroupEntry, merge);
	}

	/**
	* Returns the contact group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry findByPrimaryKey(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getPersistence().findByPrimaryKey(contactGroupId);
	}

	/**
	* Returns the contact group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry, or <code>null</code> if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry fetchByPrimaryKey(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactGroupId);
	}

	/**
	* Returns all the contact group entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ContactGroupEntry findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ContactGroupEntry findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ContactGroupEntry[] findByUserId_PrevAndNext(
		long contactGroupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(contactGroupId, userId,
			orderByComparator);
	}

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry findByUserId_ContactGroupId(
		long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getPersistence()
				   .findByUserId_ContactGroupId(userId, contactGroupId);
	}

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group entry, or <code>null</code> if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry fetchByUserId_ContactGroupId(
		long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_ContactGroupId(userId, contactGroupId);
	}

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contact group entry, or <code>null</code> if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry fetchByUserId_ContactGroupId(
		long userId, long contactGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_ContactGroupId(userId, contactGroupId,
			retrieveFromCache);
	}

	/**
	* Returns all the contact group entries.
	*
	* @return the contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the contact group entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Removes the contact group entry where userId = &#63; and contactGroupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_ContactGroupId(long userId,
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		getPersistence().removeByUserId_ContactGroupId(userId, contactGroupId);
	}

	/**
	* Removes all the contact group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contact group entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns the number of contact group entries where userId = &#63; and contactGroupId = &#63;.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_ContactGroupId(long userId,
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserId_ContactGroupId(userId, contactGroupId);
	}

	/**
	* Returns the number of contact group entries.
	*
	* @return the number of contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactGroupEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactGroupEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ContactGroupEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactGroupEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ContactGroupEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ContactGroupEntryUtil.class,
			"_persistence");
	}

	private static ContactGroupEntryPersistence _persistence;
}