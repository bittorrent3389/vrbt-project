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
 * This class is a wrapper for {@link ViolationEntry}.
 * </p>
 *
 * @author    loind
 * @see       ViolationEntry
 * @generated
 */
public class ViolationEntryWrapper implements ViolationEntry,
	ModelWrapper<ViolationEntry> {
	public ViolationEntryWrapper(ViolationEntry violationEntry) {
		_violationEntry = violationEntry;
	}

	public Class<?> getModelClass() {
		return ViolationEntry.class;
	}

	public String getModelClassName() {
		return ViolationEntry.class.getName();
	}

	/**
	* Returns the primary key of this violation entry.
	*
	* @return the primary key of this violation entry
	*/
	public long getPrimaryKey() {
		return _violationEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this violation entry.
	*
	* @param primaryKey the primary key of this violation entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_violationEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the violation ID of this violation entry.
	*
	* @return the violation ID of this violation entry
	*/
	public long getViolationId() {
		return _violationEntry.getViolationId();
	}

	/**
	* Sets the violation ID of this violation entry.
	*
	* @param violationId the violation ID of this violation entry
	*/
	public void setViolationId(long violationId) {
		_violationEntry.setViolationId(violationId);
	}

	/**
	* Returns the violation title of this violation entry.
	*
	* @return the violation title of this violation entry
	*/
	public java.lang.String getViolationTitle() {
		return _violationEntry.getViolationTitle();
	}

	/**
	* Sets the violation title of this violation entry.
	*
	* @param violationTitle the violation title of this violation entry
	*/
	public void setViolationTitle(java.lang.String violationTitle) {
		_violationEntry.setViolationTitle(violationTitle);
	}

	/**
	* Returns the description of this violation entry.
	*
	* @return the description of this violation entry
	*/
	public java.lang.String getDescription() {
		return _violationEntry.getDescription();
	}

	/**
	* Sets the description of this violation entry.
	*
	* @param description the description of this violation entry
	*/
	public void setDescription(java.lang.String description) {
		_violationEntry.setDescription(description);
	}

	/**
	* Returns the status of this violation entry.
	*
	* @return the status of this violation entry
	*/
	public int getStatus() {
		return _violationEntry.getStatus();
	}

	/**
	* Sets the status of this violation entry.
	*
	* @param status the status of this violation entry
	*/
	public void setStatus(int status) {
		_violationEntry.setStatus(status);
	}

	public boolean isNew() {
		return _violationEntry.isNew();
	}

	public void setNew(boolean n) {
		_violationEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _violationEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_violationEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _violationEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _violationEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_violationEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _violationEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_violationEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ViolationEntryWrapper((ViolationEntry)_violationEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.ViolationEntry violationEntry) {
		return _violationEntry.compareTo(violationEntry);
	}

	@Override
	public int hashCode() {
		return _violationEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ViolationEntry> toCacheModel() {
		return _violationEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ViolationEntry toEscapedModel() {
		return new ViolationEntryWrapper(_violationEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _violationEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _violationEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_violationEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ViolationEntry getWrappedViolationEntry() {
		return _violationEntry;
	}

	public ViolationEntry getWrappedModel() {
		return _violationEntry;
	}

	public void resetOriginalValues() {
		_violationEntry.resetOriginalValues();
	}

	private ViolationEntry _violationEntry;
}