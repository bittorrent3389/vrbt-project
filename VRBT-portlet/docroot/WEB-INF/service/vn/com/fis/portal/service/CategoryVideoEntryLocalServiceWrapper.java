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

package vn.com.fis.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CategoryVideoEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       CategoryVideoEntryLocalService
 * @generated
 */
public class CategoryVideoEntryLocalServiceWrapper
	implements CategoryVideoEntryLocalService,
		ServiceWrapper<CategoryVideoEntryLocalService> {
	public CategoryVideoEntryLocalServiceWrapper(
		CategoryVideoEntryLocalService categoryVideoEntryLocalService) {
		_categoryVideoEntryLocalService = categoryVideoEntryLocalService;
	}

	/**
	* Adds the category video entry to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @return the category video entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryVideoEntry addCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.addCategoryVideoEntry(categoryVideoEntry);
	}

	/**
	* Creates a new category video entry with the primary key. Does not add the category video entry to the database.
	*
	* @param categoryViceoId the primary key for the new category video entry
	* @return the new category video entry
	*/
	public vn.com.fis.portal.model.CategoryVideoEntry createCategoryVideoEntry(
		long categoryViceoId) {
		return _categoryVideoEntryLocalService.createCategoryVideoEntry(categoryViceoId);
	}

	/**
	* Deletes the category video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @throws PortalException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCategoryVideoEntry(long categoryViceoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_categoryVideoEntryLocalService.deleteCategoryVideoEntry(categoryViceoId);
	}

	/**
	* Deletes the category video entry from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryVideoEntryLocalService.deleteCategoryVideoEntry(categoryVideoEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.CategoryVideoEntry fetchCategoryVideoEntry(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.fetchCategoryVideoEntry(categoryViceoId);
	}

	/**
	* Returns the category video entry with the primary key.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @return the category video entry
	* @throws PortalException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryVideoEntry getCategoryVideoEntry(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.getCategoryVideoEntry(categoryViceoId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> getCategoryVideoEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.getCategoryVideoEntries(start,
			end);
	}

	/**
	* Returns the number of category video entries.
	*
	* @return the number of category video entries
	* @throws SystemException if a system exception occurred
	*/
	public int getCategoryVideoEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.getCategoryVideoEntriesCount();
	}

	/**
	* Updates the category video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @return the category video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryVideoEntry updateCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.updateCategoryVideoEntry(categoryVideoEntry);
	}

	/**
	* Updates the category video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @param merge whether to merge the category video entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryVideoEntry updateCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.updateCategoryVideoEntry(categoryVideoEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoryVideoEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoryVideoEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns all the category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.findByC_V(categoryId, videoId);
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
	public java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.findByC_V(categoryId, videoId,
			start, end);
	}

	/**
	* Returns the number of category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_V(long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryVideoEntryLocalService.countByC_V(categoryId, videoId);
	}

	/**
	* Removes all the category video entries where categoryId = &#63; and videoId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_V(long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryVideoEntryLocalService.removeByC_V(categoryId, videoId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryVideoEntryLocalService getWrappedCategoryVideoEntryLocalService() {
		return _categoryVideoEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryVideoEntryLocalService(
		CategoryVideoEntryLocalService categoryVideoEntryLocalService) {
		_categoryVideoEntryLocalService = categoryVideoEntryLocalService;
	}

	public CategoryVideoEntryLocalService getWrappedService() {
		return _categoryVideoEntryLocalService;
	}

	public void setWrappedService(
		CategoryVideoEntryLocalService categoryVideoEntryLocalService) {
		_categoryVideoEntryLocalService = categoryVideoEntryLocalService;
	}

	private CategoryVideoEntryLocalService _categoryVideoEntryLocalService;
}