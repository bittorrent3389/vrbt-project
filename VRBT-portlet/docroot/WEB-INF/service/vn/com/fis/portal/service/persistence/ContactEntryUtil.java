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

import vn.com.fis.portal.model.ContactEntry;

import java.util.List;

/**
 * The persistence utility for the contact entry service. This utility wraps {@link ContactEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactEntryPersistence
 * @see ContactEntryPersistenceImpl
 * @generated
 */
public class ContactEntryUtil {
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
	public static void clearCache(ContactEntry contactEntry) {
		getPersistence().clearCache(contactEntry);
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
	public static List<ContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ContactEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ContactEntry update(ContactEntry contactEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(contactEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ContactEntry update(ContactEntry contactEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(contactEntry, merge, serviceContext);
	}

	/**
	* Caches the contact entry in the entity cache if it is enabled.
	*
	* @param contactEntry the contact entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.ContactEntry contactEntry) {
		getPersistence().cacheResult(contactEntry);
	}

	/**
	* Caches the contact entries in the entity cache if it is enabled.
	*
	* @param contactEntries the contact entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.ContactEntry> contactEntries) {
		getPersistence().cacheResult(contactEntries);
	}

	/**
	* Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	*
	* @param contactId the primary key for the new contact entry
	* @return the new contact entry
	*/
	public static vn.com.fis.portal.model.ContactEntry create(long contactId) {
		return getPersistence().create(contactId);
	}

	/**
	* Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactId the primary key of the contact entry
	* @return the contact entry that was removed
	* @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactEntry remove(long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException {
		return getPersistence().remove(contactId);
	}

	public static vn.com.fis.portal.model.ContactEntry updateImpl(
		vn.com.fis.portal.model.ContactEntry contactEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(contactEntry, merge);
	}

	/**
	* Returns the contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	*
	* @param contactId the primary key of the contact entry
	* @return the contact entry
	* @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactEntry findByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException {
		return getPersistence().findByPrimaryKey(contactId);
	}

	/**
	* Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param contactId the primary key of the contact entry
	* @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactEntry fetchByPrimaryKey(
		long contactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(contactId);
	}

	/**
	* Returns the contact entry where userId = &#63; and mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @return the matching contact entry
	* @throws vn.com.fis.portal.NoSuchContactEntryException if a matching contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactEntry findByUserId_MobileNumber(
		long userId, java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException {
		return getPersistence().findByUserId_MobileNumber(userId, mobileNumber);
	}

	/**
	* Returns the contact entry where userId = &#63; and mobileNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactEntry fetchByUserId_MobileNumber(
		long userId, java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_MobileNumber(userId, mobileNumber);
	}

	/**
	* Returns the contact entry where userId = &#63; and mobileNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactEntry fetchByUserId_MobileNumber(
		long userId, java.lang.String mobileNumber, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_MobileNumber(userId, mobileNumber,
			retrieveFromCache);
	}

	/**
	* Returns all the contact entries.
	*
	* @return the contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.fis.portal.model.ContactEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ContactEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the contact entry where userId = &#63; and mobileNumber = &#63; from the database.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_MobileNumber(long userId,
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactEntryException {
		getPersistence().removeByUserId_MobileNumber(userId, mobileNumber);
	}

	/**
	* Removes all the contact entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of contact entries where userId = &#63; and mobileNumber = &#63;.
	*
	* @param userId the user ID
	* @param mobileNumber the mobile number
	* @return the number of matching contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_MobileNumber(long userId,
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId_MobileNumber(userId, mobileNumber);
	}

	/**
	* Returns the number of contact entries.
	*
	* @return the number of contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ContactEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ContactEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ContactEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ContactEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ContactEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ContactEntryUtil.class,
			"_persistence");
	}

	private static ContactEntryPersistence _persistence;
}