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

import vn.com.fis.portal.model.CategoryEntry;

import java.util.List;

/**
 * The persistence utility for the category entry service. This utility wraps {@link CategoryEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see CategoryEntryPersistence
 * @see CategoryEntryPersistenceImpl
 * @generated
 */
public class CategoryEntryUtil {
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
	public static void clearCache(CategoryEntry categoryEntry) {
		getPersistence().clearCache(categoryEntry);
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
	public static List<CategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CategoryEntry update(CategoryEntry categoryEntry,
		boolean merge) throws SystemException {
		return getPersistence().update(categoryEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CategoryEntry update(CategoryEntry categoryEntry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(categoryEntry, merge, serviceContext);
	}

	/**
	* Caches the category entry in the entity cache if it is enabled.
	*
	* @param categoryEntry the category entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.CategoryEntry categoryEntry) {
		getPersistence().cacheResult(categoryEntry);
	}

	/**
	* Caches the category entries in the entity cache if it is enabled.
	*
	* @param categoryEntries the category entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.CategoryEntry> categoryEntries) {
		getPersistence().cacheResult(categoryEntries);
	}

	/**
	* Creates a new category entry with the primary key. Does not add the category entry to the database.
	*
	* @param categoryId the primary key for the new category entry
	* @return the new category entry
	*/
	public static vn.com.fis.portal.model.CategoryEntry create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category entry
	* @return the category entry that was removed
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence().remove(categoryId);
	}

	public static vn.com.fis.portal.model.CategoryEntry updateImpl(
		vn.com.fis.portal.model.CategoryEntry categoryEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(categoryEntry, merge);
	}

	/**
	* Returns the category entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchCategoryEntryException} if it could not be found.
	*
	* @param categoryId the primary key of the category entry
	* @return the category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the category entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the category entry
	* @return the category entry, or <code>null</code> if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the category entries where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findByCategoryName(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(categoryName);
	}

	/**
	* Returns a range of all the category entries where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @return the range of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findByCategoryName(
		java.lang.String categoryName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(categoryName, start, end);
	}

	/**
	* Returns an ordered range of all the category entries where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findByCategoryName(
		java.lang.String categoryName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(categoryName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first category entry in the ordered set where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry findByCategoryName_First(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence()
				   .findByCategoryName_First(categoryName, orderByComparator);
	}

	/**
	* Returns the last category entry in the ordered set where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry findByCategoryName_Last(
		java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence()
				   .findByCategoryName_Last(categoryName, orderByComparator);
	}

	/**
	* Returns the category entries before and after the current category entry in the ordered set where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current category entry
	* @param categoryName the category name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry[] findByCategoryName_PrevAndNext(
		long categoryId, java.lang.String categoryName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence()
				   .findByCategoryName_PrevAndNext(categoryId, categoryName,
			orderByComparator);
	}

	/**
	* Returns all the category entries where status = &#63;.
	*
	* @param status the status
	* @return the matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findBystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status);
	}

	/**
	* Returns a range of all the category entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @return the range of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findBystatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBystatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the category entries where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findBystatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBystatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first category entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry findBystatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	* Returns the last category entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry findBystatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	* Returns the category entries before and after the current category entry in the ordered set where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the primary key of the current category entry
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry[] findBystatus_PrevAndNext(
		long categoryId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getPersistence()
				   .findBystatus_PrevAndNext(categoryId, status,
			orderByComparator);
	}

	/**
	* Returns all the category entries.
	*
	* @return the category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the category entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @return the range of category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the category entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the category entries where categoryName = &#63; from the database.
	*
	* @param categoryName the category name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryName(categoryName);
	}

	/**
	* Removes all the category entries where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBystatus(status);
	}

	/**
	* Removes all the category entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of category entries where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryName(categoryName);
	}

	/**
	* Returns the number of category entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBystatus(status);
	}

	/**
	* Returns the number of category entries.
	*
	* @return the number of category entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoryEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					CategoryEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CategoryEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CategoryEntryUtil.class,
			"_persistence");
	}

	private static CategoryEntryPersistence _persistence;
}