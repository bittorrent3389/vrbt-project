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
 * This class is a wrapper for {@link VideoUserContactEntry}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserContactEntry
 * @generated
 */
public class VideoUserContactEntryWrapper implements VideoUserContactEntry,
	ModelWrapper<VideoUserContactEntry> {
	public VideoUserContactEntryWrapper(
		VideoUserContactEntry videoUserContactEntry) {
		_videoUserContactEntry = videoUserContactEntry;
	}

	public Class<?> getModelClass() {
		return VideoUserContactEntry.class;
	}

	public String getModelClassName() {
		return VideoUserContactEntry.class.getName();
	}

	/**
	* Returns the primary key of this video user contact entry.
	*
	* @return the primary key of this video user contact entry
	*/
	public long getPrimaryKey() {
		return _videoUserContactEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video user contact entry.
	*
	* @param primaryKey the primary key of this video user contact entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoUserContactEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video user contact ID of this video user contact entry.
	*
	* @return the video user contact ID of this video user contact entry
	*/
	public long getVideoUserContactId() {
		return _videoUserContactEntry.getVideoUserContactId();
	}

	/**
	* Sets the video user contact ID of this video user contact entry.
	*
	* @param videoUserContactId the video user contact ID of this video user contact entry
	*/
	public void setVideoUserContactId(long videoUserContactId) {
		_videoUserContactEntry.setVideoUserContactId(videoUserContactId);
	}

	/**
	* Returns the video user ID of this video user contact entry.
	*
	* @return the video user ID of this video user contact entry
	*/
	public long getVideoUserId() {
		return _videoUserContactEntry.getVideoUserId();
	}

	/**
	* Sets the video user ID of this video user contact entry.
	*
	* @param videoUserId the video user ID of this video user contact entry
	*/
	public void setVideoUserId(long videoUserId) {
		_videoUserContactEntry.setVideoUserId(videoUserId);
	}

	/**
	* Returns the video user uuid of this video user contact entry.
	*
	* @return the video user uuid of this video user contact entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getVideoUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntry.getVideoUserUuid();
	}

	/**
	* Sets the video user uuid of this video user contact entry.
	*
	* @param videoUserUuid the video user uuid of this video user contact entry
	*/
	public void setVideoUserUuid(java.lang.String videoUserUuid) {
		_videoUserContactEntry.setVideoUserUuid(videoUserUuid);
	}

	/**
	* Returns the contact ID of this video user contact entry.
	*
	* @return the contact ID of this video user contact entry
	*/
	public long getContactId() {
		return _videoUserContactEntry.getContactId();
	}

	/**
	* Sets the contact ID of this video user contact entry.
	*
	* @param contactId the contact ID of this video user contact entry
	*/
	public void setContactId(long contactId) {
		_videoUserContactEntry.setContactId(contactId);
	}

	/**
	* Returns the company ID of this video user contact entry.
	*
	* @return the company ID of this video user contact entry
	*/
	public long getCompanyId() {
		return _videoUserContactEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this video user contact entry.
	*
	* @param companyId the company ID of this video user contact entry
	*/
	public void setCompanyId(long companyId) {
		_videoUserContactEntry.setCompanyId(companyId);
	}

	/**
	* Returns the start time of this video user contact entry.
	*
	* @return the start time of this video user contact entry
	*/
	public java.util.Date getStartTime() {
		return _videoUserContactEntry.getStartTime();
	}

	/**
	* Sets the start time of this video user contact entry.
	*
	* @param startTime the start time of this video user contact entry
	*/
	public void setStartTime(java.util.Date startTime) {
		_videoUserContactEntry.setStartTime(startTime);
	}

	/**
	* Returns the end time of this video user contact entry.
	*
	* @return the end time of this video user contact entry
	*/
	public java.util.Date getEndTime() {
		return _videoUserContactEntry.getEndTime();
	}

	/**
	* Sets the end time of this video user contact entry.
	*
	* @param endTime the end time of this video user contact entry
	*/
	public void setEndTime(java.util.Date endTime) {
		_videoUserContactEntry.setEndTime(endTime);
	}

	/**
	* Returns the priority of this video user contact entry.
	*
	* @return the priority of this video user contact entry
	*/
	public int getPriority() {
		return _videoUserContactEntry.getPriority();
	}

	/**
	* Sets the priority of this video user contact entry.
	*
	* @param priority the priority of this video user contact entry
	*/
	public void setPriority(int priority) {
		_videoUserContactEntry.setPriority(priority);
	}

	/**
	* Returns the status of this video user contact entry.
	*
	* @return the status of this video user contact entry
	*/
	public int getStatus() {
		return _videoUserContactEntry.getStatus();
	}

	/**
	* Sets the status of this video user contact entry.
	*
	* @param status the status of this video user contact entry
	*/
	public void setStatus(int status) {
		_videoUserContactEntry.setStatus(status);
	}

	public boolean isNew() {
		return _videoUserContactEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoUserContactEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoUserContactEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoUserContactEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoUserContactEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoUserContactEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoUserContactEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoUserContactEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoUserContactEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoUserContactEntryWrapper((VideoUserContactEntry)_videoUserContactEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry) {
		return _videoUserContactEntry.compareTo(videoUserContactEntry);
	}

	@Override
	public int hashCode() {
		return _videoUserContactEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.VideoUserContactEntry> toCacheModel() {
		return _videoUserContactEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.VideoUserContactEntry toEscapedModel() {
		return new VideoUserContactEntryWrapper(_videoUserContactEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoUserContactEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoUserContactEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoUserContactEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoUserContactEntry getWrappedVideoUserContactEntry() {
		return _videoUserContactEntry;
	}

	public VideoUserContactEntry getWrappedModel() {
		return _videoUserContactEntry;
	}

	public void resetOriginalValues() {
		_videoUserContactEntry.resetOriginalValues();
	}

	private VideoUserContactEntry _videoUserContactEntry;
}