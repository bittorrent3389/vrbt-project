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

import vn.com.fis.portal.model.ViolationEntry;

import java.util.List;

/**
 * The persistence utility for the violation entry service. This utility wraps {@link ViolationEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ViolationEntryPersistence
 * @see ViolationEntryPersistenceImpl
 * @generated
 */
public class ViolationEntryUtil {
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
	public static void clearCache(ViolationEntry violationEntry) {
		getPersistence().clearCache(violationEntry);
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
	public static List<ViolationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ViolationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ViolationEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ViolationEntry update(ViolationEntry violationEntry,
		boolean merge) throws SystemException {
		return getPersistence().update(violationEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ViolationEntry update(ViolationEntry violationEntry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(violationEntry, merge, serviceContext);
	}

	/**
	* Caches the violation entry in the entity cache if it is enabled.
	*
	* @param violationEntry the violation entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.ViolationEntry violationEntry) {
		getPersistence().cacheResult(violationEntry);
	}

	/**
	* Caches the violation entries in the entity cache if it is enabled.
	*
	* @param violationEntries the violation entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.ViolationEntry> violationEntries) {
		getPersistence().cacheResult(violationEntries);
	}

	/**
	* Creates a new violation entry with the primary key. Does not add the violation entry to the database.
	*
	* @param violationId the primary key for the new violation entry
	* @return the new violation entry
	*/
	public static vn.com.fis.portal.model.ViolationEntry create(
		long violationId) {
		return getPersistence().create(violationId);
	}

	/**
	* Removes the violation entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry that was removed
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ViolationEntry remove(
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence().remove(violationId);
	}

	public static vn.com.fis.portal.model.ViolationEntry updateImpl(
		vn.com.fis.portal.model.ViolationEntry violationEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(violationEntry, merge);
	}

	/**
	* Returns the violation entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchViolationEntryException} if it could not be found.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry
	* @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ViolationEntry findByPrimaryKey(
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence().findByPrimaryKey(violationId);
	}

	/**
	* Returns the violation entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry, or <code>null</code> if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ViolationEntry fetchByPrimaryKey(
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(violationId);
	}

	/**
	* Returns all the violation entries where violationTitle = &#63;.
	*
	* @param violationTitle the violation title
	* @return the matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findByTitle(
		java.lang.String violationTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(violationTitle);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findByTitle(
		java.lang.String violationTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(violationTitle, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findByTitle(
		java.lang.String violationTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitle(violationTitle, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ViolationEntry findByTitle_First(
		java.lang.String violationTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence()
				   .findByTitle_First(violationTitle, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ViolationEntry findByTitle_Last(
		java.lang.String violationTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence()
				   .findByTitle_Last(violationTitle, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ViolationEntry[] findByTitle_PrevAndNext(
		long violationId, java.lang.String violationTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence()
				   .findByTitle_PrevAndNext(violationId, violationTitle,
			orderByComparator);
	}

	/**
	* Returns all the violation entries where status = &#63;.
	*
	* @param status the status
	* @return the matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ViolationEntry findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ViolationEntry findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

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
	public static vn.com.fis.portal.model.ViolationEntry[] findByStatus_PrevAndNext(
		long violationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationEntryException {
		return getPersistence()
				   .findByStatus_PrevAndNext(violationId, status,
			orderByComparator);
	}

	/**
	* Returns all the violation entries.
	*
	* @return the violation entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the violation entries where violationTitle = &#63; from the database.
	*
	* @param violationTitle the violation title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String violationTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(violationTitle);
	}

	/**
	* Removes all the violation entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Removes all the violation entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of violation entries where violationTitle = &#63;.
	*
	* @param violationTitle the violation title
	* @return the number of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String violationTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(violationTitle);
	}

	/**
	* Returns the number of violation entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns the number of violation entries.
	*
	* @return the number of violation entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ViolationEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ViolationEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ViolationEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(ViolationEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ViolationEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ViolationEntryUtil.class,
			"_persistence");
	}

	private static ViolationEntryPersistence _persistence;
}