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
 * This class is a wrapper for {@link CategoryEntyLocalService}.
 * </p>
 *
 * @author    loind
 * @see       CategoryEntyLocalService
 * @generated
 */
public class CategoryEntyLocalServiceWrapper implements CategoryEntyLocalService,
	ServiceWrapper<CategoryEntyLocalService> {
	public CategoryEntyLocalServiceWrapper(
		CategoryEntyLocalService categoryEntyLocalService) {
		_categoryEntyLocalService = categoryEntyLocalService;
	}

	/**
	* Adds the category enty to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @return the category enty that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryEnty addCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.addCategoryEnty(categoryEnty);
	}

	/**
	* Creates a new category enty with the primary key. Does not add the category enty to the database.
	*
	* @param categoryId the primary key for the new category enty
	* @return the new category enty
	*/
	public vn.com.fis.portal.model.CategoryEnty createCategoryEnty(
		long categoryId) {
		return _categoryEntyLocalService.createCategoryEnty(categoryId);
	}

	/**
	* Deletes the category enty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category enty
	* @throws PortalException if a category enty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCategoryEnty(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_categoryEntyLocalService.deleteCategoryEnty(categoryId);
	}

	/**
	* Deletes the category enty from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @throws SystemException if a system exception occurred
	*/
	public void deleteCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty)
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryEntyLocalService.deleteCategoryEnty(categoryEnty);
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
		return _categoryEntyLocalService.dynamicQuery(dynamicQuery);
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
		return _categoryEntyLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _categoryEntyLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _categoryEntyLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.CategoryEnty fetchCategoryEnty(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.fetchCategoryEnty(categoryId);
	}

	/**
	* Returns the category enty with the primary key.
	*
	* @param categoryId the primary key of the category enty
	* @return the category enty
	* @throws PortalException if a category enty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryEnty getCategoryEnty(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.getCategoryEnty(categoryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the category enties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category enties
	* @param end the upper bound of the range of category enties (not inclusive)
	* @return the range of category enties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.CategoryEnty> getCategoryEnties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.getCategoryEnties(start, end);
	}

	/**
	* Returns the number of category enties.
	*
	* @return the number of category enties
	* @throws SystemException if a system exception occurred
	*/
	public int getCategoryEntiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.getCategoryEntiesCount();
	}

	/**
	* Updates the category enty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @return the category enty that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryEnty updateCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.updateCategoryEnty(categoryEnty);
	}

	/**
	* Updates the category enty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @param merge whether to merge the category enty with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category enty that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.CategoryEnty updateCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.updateCategoryEnty(categoryEnty, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoryEntyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoryEntyLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns all the category enties where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the matching category enties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.CategoryEnty> findByCategoryName(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.findByCategoryName(categoryName);
	}

	/**
	* Returns a range of all the category enties where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param start the lower bound of the range of category enties
	* @param end the upper bound of the range of category enties (not inclusive)
	* @return the range of matching category enties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.CategoryEnty> findByCategoryName(
		java.lang.String categoryName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.findByCategoryName(categoryName,
			start, end);
	}

	/**
	* Returns the number of category enties where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching category enties
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoryEntyLocalService.countByCategoryName(categoryName);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryEntyLocalService getWrappedCategoryEntyLocalService() {
		return _categoryEntyLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryEntyLocalService(
		CategoryEntyLocalService categoryEntyLocalService) {
		_categoryEntyLocalService = categoryEntyLocalService;
	}

	public CategoryEntyLocalService getWrappedService() {
		return _categoryEntyLocalService;
	}

	public void setWrappedService(
		CategoryEntyLocalService categoryEntyLocalService) {
		_categoryEntyLocalService = categoryEntyLocalService;
	}

	private CategoryEntyLocalService _categoryEntyLocalService;
}