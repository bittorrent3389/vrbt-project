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

package vn.com.fis.portal.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CategoryEnty}.
 * </p>
 *
 * @author    loind
 * @see       CategoryEnty
 * @generated
 */
public class CategoryEntyWrapper implements CategoryEnty,
	ModelWrapper<CategoryEnty> {
	public CategoryEntyWrapper(CategoryEnty categoryEnty) {
		_categoryEnty = categoryEnty;
	}

	public Class<?> getModelClass() {
		return CategoryEnty.class;
	}

	public String getModelClassName() {
		return CategoryEnty.class.getName();
	}

	/**
	* Returns the primary key of this category enty.
	*
	* @return the primary key of this category enty
	*/
	public long getPrimaryKey() {
		return _categoryEnty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category enty.
	*
	* @param primaryKey the primary key of this category enty
	*/
	public void setPrimaryKey(long primaryKey) {
		_categoryEnty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category enty.
	*
	* @return the category ID of this category enty
	*/
	public long getCategoryId() {
		return _categoryEnty.getCategoryId();
	}

	/**
	* Sets the category ID of this category enty.
	*
	* @param categoryId the category ID of this category enty
	*/
	public void setCategoryId(long categoryId) {
		_categoryEnty.setCategoryId(categoryId);
	}

	/**
	* Returns the category name of this category enty.
	*
	* @return the category name of this category enty
	*/
	public java.lang.String getCategoryName() {
		return _categoryEnty.getCategoryName();
	}

	/**
	* Sets the category name of this category enty.
	*
	* @param categoryName the category name of this category enty
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_categoryEnty.setCategoryName(categoryName);
	}

	/**
	* Returns the description of this category enty.
	*
	* @return the description of this category enty
	*/
	public java.lang.String getDescription() {
		return _categoryEnty.getDescription();
	}

	/**
	* Sets the description of this category enty.
	*
	* @param description the description of this category enty
	*/
	public void setDescription(java.lang.String description) {
		_categoryEnty.setDescription(description);
	}

	/**
	* Returns the status of this category enty.
	*
	* @return the status of this category enty
	*/
	public int getStatus() {
		return _categoryEnty.getStatus();
	}

	/**
	* Sets the status of this category enty.
	*
	* @param status the status of this category enty
	*/
	public void setStatus(int status) {
		_categoryEnty.setStatus(status);
	}

	public boolean isNew() {
		return _categoryEnty.isNew();
	}

	public void setNew(boolean n) {
		_categoryEnty.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoryEnty.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoryEnty.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoryEnty.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoryEnty.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoryEnty.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoryEnty.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoryEnty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryEntyWrapper((CategoryEnty)_categoryEnty.clone());
	}

	public int compareTo(vn.com.fis.portal.model.CategoryEnty categoryEnty) {
		return _categoryEnty.compareTo(categoryEnty);
	}

	@Override
	public int hashCode() {
		return _categoryEnty.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.CategoryEnty> toCacheModel() {
		return _categoryEnty.toCacheModel();
	}

	public vn.com.fis.portal.model.CategoryEnty toEscapedModel() {
		return new CategoryEntyWrapper(_categoryEnty.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoryEnty.toString();
	}

	public java.lang.String toXmlString() {
		return _categoryEnty.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryEnty.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CategoryEnty getWrappedCategoryEnty() {
		return _categoryEnty;
	}

	public CategoryEnty getWrappedModel() {
		return _categoryEnty;
	}

	public void resetOriginalValues() {
		_categoryEnty.resetOriginalValues();
	}

	private CategoryEnty _categoryEnty;
}