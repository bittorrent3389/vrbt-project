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

import vn.com.fis.portal.model.CategoryVideoEntry;

import java.util.List;

/**
 * The persistence utility for the category video entry service. This utility wraps {@link CategoryVideoEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see CategoryVideoEntryPersistence
 * @see CategoryVideoEntryPersistenceImpl
 * @generated
 */
public class CategoryVideoEntryUtil {
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
	public static void clearCache(CategoryVideoEntry categoryVideoEntry) {
		getPersistence().clearCache(categoryVideoEntry);
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
	public static List<CategoryVideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoryVideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoryVideoEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CategoryVideoEntry update(
		CategoryVideoEntry categoryVideoEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(categoryVideoEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CategoryVideoEntry update(
		CategoryVideoEntry categoryVideoEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(categoryVideoEntry, merge, serviceContext);
	}

	/**
	* Caches the category video entry in the entity cache if it is enabled.
	*
	* @param categoryVideoEntry the category video entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry) {
		getPersistence().cacheResult(categoryVideoEntry);
	}

	/**
	* Caches the category video entries in the entity cache if it is enabled.
	*
	* @param categoryVideoEntries the category video entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> categoryVideoEntries) {
		getPersistence().cacheResult(categoryVideoEntries);
	}

	/**
	* Creates a new category video entry with the primary key. Does not add the category video entry to the database.
	*
	* @param categoryViceoId the primary key for the new category video entry
	* @return the new category video entry
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry create(
		long categoryViceoId) {
		return getPersistence().create(categoryViceoId);
	}

	/**
	* Removes the category video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @return the category video entry that was removed
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry remove(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence().remove(categoryViceoId);
	}

	public static vn.com.fis.portal.model.CategoryVideoEntry updateImpl(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(categoryVideoEntry, merge);
	}

	/**
	* Returns the category video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchCategoryVideoEntryException} if it could not be found.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @return the category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByPrimaryKey(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence().findByPrimaryKey(categoryViceoId);
	}

	/**
	* Returns the category video entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @return the category video entry, or <code>null</code> if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry fetchByPrimaryKey(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryViceoId);
	}

	/**
	* Returns all the category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_V(categoryId, videoId);
	}

	/**
	* Returns a range of all the category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByC_V(categoryId, videoId, start, end);
	}

	/**
	* Returns an ordered range of all the category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByC_V(categoryId, videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first category video entry in the ordered set where categoryId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByC_V_First(
		long categoryId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByC_V_First(categoryId, videoId, orderByComparator);
	}

	/**
	* Returns the last category video entry in the ordered set where categoryId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByC_V_Last(
		long categoryId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByC_V_Last(categoryId, videoId, orderByComparator);
	}

	/**
	* Returns the category video entries before and after the current category video entry in the ordered set where categoryId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryViceoId the primary key of the current category video entry
	* @param categoryId the category ID
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry[] findByC_V_PrevAndNext(
		long categoryViceoId, long categoryId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByC_V_PrevAndNext(categoryViceoId, categoryId, videoId,
			orderByComparator);
	}

	/**
	* Returns all the category video entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoId(videoId);
	}

	/**
	* Returns a range of all the category video entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByVideoId(videoId, start, end);
	}

	/**
	* Returns an ordered range of all the category video entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByVideoId(
		long videoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByVideoId(videoId, start, end, orderByComparator);
	}

	/**
	* Returns the first category video entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByVideoId_First(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence().findByVideoId_First(videoId, orderByComparator);
	}

	/**
	* Returns the last category video entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByVideoId_Last(
		long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence().findByVideoId_Last(videoId, orderByComparator);
	}

	/**
	* Returns the category video entries before and after the current category video entry in the ordered set where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryViceoId the primary key of the current category video entry
	* @param videoId the video ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry[] findByVideoId_PrevAndNext(
		long categoryViceoId, long videoId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByVideoId_PrevAndNext(categoryViceoId, videoId,
			orderByComparator);
	}

	/**
	* Returns all the category video entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId);
	}

	/**
	* Returns a range of all the category video entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryId(categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the category video entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryId(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns the first category video entry in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByCategoryId_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last category video entry in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByCategoryId_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the category video entries before and after the current category video entry in the ordered set where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryViceoId the primary key of the current category video entry
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next category video entry
	* @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry[] findByCategoryId_PrevAndNext(
		long categoryViceoId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryVideoEntryException {
		return getPersistence()
				   .findByCategoryId_PrevAndNext(categoryViceoId, categoryId,
			orderByComparator);
	}

	/**
	* Returns all the category video entries.
	*
	* @return the category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the category video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the category video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the category video entries where categoryId = &#63; and videoId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_V(long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByC_V(categoryId, videoId);
	}

	/**
	* Removes all the category video entries where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByVideoId(videoId);
	}

	/**
	* Removes all the category video entries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryId(categoryId);
	}

	/**
	* Removes all the category video entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_V(long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_V(categoryId, videoId);
	}

	/**
	* Returns the number of category video entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByVideoId(videoId);
	}

	/**
	* Returns the number of category video entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	* Returns the number of category video entries.
	*
	* @return the number of category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoryVideoEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoryVideoEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					CategoryVideoEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoryVideoEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(CategoryVideoEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(CategoryVideoEntryUtil.class,
			"_persistence");
	}

	private static CategoryVideoEntryPersistence _persistence;
}