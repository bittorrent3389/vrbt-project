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
 * This class is a wrapper for {@link CategoryVideoEntry}.
 * </p>
 *
 * @author    loind
 * @see       CategoryVideoEntry
 * @generated
 */
public class CategoryVideoEntryWrapper implements CategoryVideoEntry,
	ModelWrapper<CategoryVideoEntry> {
	public CategoryVideoEntryWrapper(CategoryVideoEntry categoryVideoEntry) {
		_categoryVideoEntry = categoryVideoEntry;
	}

	public Class<?> getModelClass() {
		return CategoryVideoEntry.class;
	}

	public String getModelClassName() {
		return CategoryVideoEntry.class.getName();
	}

	/**
	* Returns the primary key of this category video entry.
	*
	* @return the primary key of this category video entry
	*/
	public long getPrimaryKey() {
		return _categoryVideoEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this category video entry.
	*
	* @param primaryKey the primary key of this category video entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_categoryVideoEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category viceo ID of this category video entry.
	*
	* @return the category viceo ID of this category video entry
	*/
	public long getCategoryViceoId() {
		return _categoryVideoEntry.getCategoryViceoId();
	}

	/**
	* Sets the category viceo ID of this category video entry.
	*
	* @param categoryViceoId the category viceo ID of this category video entry
	*/
	public void setCategoryViceoId(long categoryViceoId) {
		_categoryVideoEntry.setCategoryViceoId(categoryViceoId);
	}

	/**
	* Returns the category ID of this category video entry.
	*
	* @return the category ID of this category video entry
	*/
	public long getCategoryId() {
		return _categoryVideoEntry.getCategoryId();
	}

	/**
	* Sets the category ID of this category video entry.
	*
	* @param categoryId the category ID of this category video entry
	*/
	public void setCategoryId(long categoryId) {
		_categoryVideoEntry.setCategoryId(categoryId);
	}

	/**
	* Returns the video ID of this category video entry.
	*
	* @return the video ID of this category video entry
	*/
	public long getVideoId() {
		return _categoryVideoEntry.getVideoId();
	}

	/**
	* Sets the video ID of this category video entry.
	*
	* @param videoId the video ID of this category video entry
	*/
	public void setVideoId(long videoId) {
		_categoryVideoEntry.setVideoId(videoId);
	}

	public boolean isNew() {
		return _categoryVideoEntry.isNew();
	}

	public void setNew(boolean n) {
		_categoryVideoEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoryVideoEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoryVideoEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoryVideoEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoryVideoEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoryVideoEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoryVideoEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoryVideoEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoryVideoEntryWrapper((CategoryVideoEntry)_categoryVideoEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry) {
		return _categoryVideoEntry.compareTo(categoryVideoEntry);
	}

	@Override
	public int hashCode() {
		return _categoryVideoEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.CategoryVideoEntry> toCacheModel() {
		return _categoryVideoEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.CategoryVideoEntry toEscapedModel() {
		return new CategoryVideoEntryWrapper(_categoryVideoEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoryVideoEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _categoryVideoEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoryVideoEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CategoryVideoEntry getWrappedCategoryVideoEntry() {
		return _categoryVideoEntry;
	}

	public CategoryVideoEntry getWrappedModel() {
		return _categoryVideoEntry;
	}

	public void resetOriginalValues() {
		_categoryVideoEntry.resetOriginalValues();
	}

	private CategoryVideoEntry _categoryVideoEntry;
}