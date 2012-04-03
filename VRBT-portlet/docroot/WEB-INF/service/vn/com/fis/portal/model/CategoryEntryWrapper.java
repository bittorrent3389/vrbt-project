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
 * This class is a wrapper for {@link CategoryEntry}.
 * </p>
 *
 * @author    loind
 * @see       CategoryEntry
 * @generated
 */
public class CategoryEntryWrapper implements CategoryEntry,
	ModelWrapper<CategoryEntry> {
	public CategoryEntryWrapper(CategoryEntry categoryEntry) {
		_categoryEntry = categoryEntry;
	}

	public Class<?> getModelClass() {
		return CategoryEntry.class;
	}

	public String getModelClassName() {
		return CategoryEntry.class.getName();
	}

	/**
	* Returns the primary key of this category entry.
	*
	* @return the primary key of this category entry
	*/
	public long getPrimaryKey() {
		return _categoryEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category entry.
	*
	* @param primaryKey the primary key of this category entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_categoryEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this category entry.
	*
	* @return the category ID of this category entry
	*/
	public long getCategoryId() {
		return _categoryEntry.getCategoryId();
	}

	/**
	* Sets the category ID of this category entry.
	*
	* @param categoryId the category ID of this category entry
	*/
	public void setCategoryId(long categoryId) {
		_categoryEntry.setCategoryId(categoryId);
	}

	/**
	* Returns the category name of this category entry.
	*
	* @return the category name of this category entry
	*/
	public java.lang.String getCategoryName() {
		return _categoryEntry.getCategoryName();
	}

	/**
	* Sets the category name of this category entry.
	*
	* @param categoryName the category name of this category entry
	*/
	public void setCategoryName(java.lang.String categoryName) {
		_categoryEntry.setCategoryName(categoryName);
	}

	/**
	* Returns the description of this category entry.
	*
	* @return the description of this category entry
	*/
	public java.lang.String getDescription() {
		return _categoryEntry.getDescription();
	}

	/**
	* Sets the description of this category entry.
	*
	* @param description the description of this category entry
	*/
	public void setDescription(java.lang.String description) {
		_categoryEntry.setDescription(description);
	}

	/**
	* Returns the status of this category entry.
	*
	* @return the status of this category entry
	*/
	public int getStatus() {
		return _categoryEntry.getStatus();
	}

	/**
	* Sets the status of this category entry.
	*
	* @param status the status of this category entry
	*/
	public void setStatus(int status) {
		_categoryEntry.setStatus(status);
	}

	public boolean isNew() {
		return _categoryEntry.isNew();
	}

	public void setNew(boolean n) {
		_categoryEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoryEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoryEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoryEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoryEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoryEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoryEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoryEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryEntryWrapper((CategoryEntry)_categoryEntry.clone());
	}

	public int compareTo(CategoryEntry categoryEntry) {
		return _categoryEntry.compareTo(categoryEntry);
	}

	@Override
	public int hashCode() {
		return _categoryEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<CategoryEntry> toCacheModel() {
		return _categoryEntry.toCacheModel();
	}

	public CategoryEntry toEscapedModel() {
		return new CategoryEntryWrapper(_categoryEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoryEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _categoryEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CategoryEntry getWrappedCategoryEntry() {
		return _categoryEntry;
	}

	public CategoryEntry getWrappedModel() {
		return _categoryEntry;
	}

	public void resetOriginalValues() {
		_categoryEntry.resetOriginalValues();
	}

	private CategoryEntry _categoryEntry;
}