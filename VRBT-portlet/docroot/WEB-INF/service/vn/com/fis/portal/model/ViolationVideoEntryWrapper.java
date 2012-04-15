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
 * This class is a wrapper for {@link ViolationVideoEntry}.
 * </p>
 *
 * @author    loind
 * @see       ViolationVideoEntry
 * @generated
 */
public class ViolationVideoEntryWrapper implements ViolationVideoEntry,
	ModelWrapper<ViolationVideoEntry> {
	public ViolationVideoEntryWrapper(ViolationVideoEntry violationVideoEntry) {
		_violationVideoEntry = violationVideoEntry;
	}

	public Class<?> getModelClass() {
		return ViolationVideoEntry.class;
	}

	public String getModelClassName() {
		return ViolationVideoEntry.class.getName();
	}

	/**
	* Returns the primary key of this violation video entry.
	*
	* @return the primary key of this violation video entry
	*/
	public long getPrimaryKey() {
		return _violationVideoEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this violation video entry.
	*
	* @param primaryKey the primary key of this violation video entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_violationVideoEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the violation video ID of this violation video entry.
	*
	* @return the violation video ID of this violation video entry
	*/
	public long getViolationVideoId() {
		return _violationVideoEntry.getViolationVideoId();
	}

	/**
	* Sets the violation video ID of this violation video entry.
	*
	* @param violationVideoId the violation video ID of this violation video entry
	*/
	public void setViolationVideoId(long violationVideoId) {
		_violationVideoEntry.setViolationVideoId(violationVideoId);
	}

	/**
	* Returns the violation ID of this violation video entry.
	*
	* @return the violation ID of this violation video entry
	*/
	public long getViolationId() {
		return _violationVideoEntry.getViolationId();
	}

	/**
	* Sets the violation ID of this violation video entry.
	*
	* @param violationId the violation ID of this violation video entry
	*/
	public void setViolationId(long violationId) {
		_violationVideoEntry.setViolationId(violationId);
	}

	/**
	* Returns the video ID of this violation video entry.
	*
	* @return the video ID of this violation video entry
	*/
	public long getVideoId() {
		return _violationVideoEntry.getVideoId();
	}

	/**
	* Sets the video ID of this violation video entry.
	*
	* @param videoId the video ID of this violation video entry
	*/
	public void setVideoId(long videoId) {
		_violationVideoEntry.setVideoId(videoId);
	}

	/**
	* Returns the user ID of this violation video entry.
	*
	* @return the user ID of this violation video entry
	*/
	public long getUserId() {
		return _violationVideoEntry.getUserId();
	}

	/**
	* Sets the user ID of this violation video entry.
	*
	* @param userId the user ID of this violation video entry
	*/
	public void setUserId(long userId) {
		_violationVideoEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this violation video entry.
	*
	* @return the user uuid of this violation video entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationVideoEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this violation video entry.
	*
	* @param userUuid the user uuid of this violation video entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_violationVideoEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the date_ of this violation video entry.
	*
	* @return the date_ of this violation video entry
	*/
	public java.util.Date getDate_() {
		return _violationVideoEntry.getDate_();
	}

	/**
	* Sets the date_ of this violation video entry.
	*
	* @param date_ the date_ of this violation video entry
	*/
	public void setDate_(java.util.Date date_) {
		_violationVideoEntry.setDate_(date_);
	}

	/**
	* Returns the description of this violation video entry.
	*
	* @return the description of this violation video entry
	*/
	public java.lang.String getDescription() {
		return _violationVideoEntry.getDescription();
	}

	/**
	* Sets the description of this violation video entry.
	*
	* @param description the description of this violation video entry
	*/
	public void setDescription(java.lang.String description) {
		_violationVideoEntry.setDescription(description);
	}

	public boolean isNew() {
		return _violationVideoEntry.isNew();
	}

	public void setNew(boolean n) {
		_violationVideoEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _violationVideoEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_violationVideoEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _violationVideoEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _violationVideoEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_violationVideoEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _violationVideoEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_violationVideoEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ViolationVideoEntryWrapper((ViolationVideoEntry)_violationVideoEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry) {
		return _violationVideoEntry.compareTo(violationVideoEntry);
	}

	@Override
	public int hashCode() {
		return _violationVideoEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ViolationVideoEntry> toCacheModel() {
		return _violationVideoEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ViolationVideoEntry toEscapedModel() {
		return new ViolationVideoEntryWrapper(_violationVideoEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _violationVideoEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _violationVideoEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_violationVideoEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ViolationVideoEntry getWrappedViolationVideoEntry() {
		return _violationVideoEntry;
	}

	public ViolationVideoEntry getWrappedModel() {
		return _violationVideoEntry;
	}

	public void resetOriginalValues() {
		_violationVideoEntry.resetOriginalValues();
	}

	private ViolationVideoEntry _violationVideoEntry;
}