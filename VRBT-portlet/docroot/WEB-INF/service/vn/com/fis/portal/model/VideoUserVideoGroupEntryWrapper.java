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
 * This class is a wrapper for {@link VideoUserVideoGroupEntry}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserVideoGroupEntry
 * @generated
 */
public class VideoUserVideoGroupEntryWrapper implements VideoUserVideoGroupEntry,
	ModelWrapper<VideoUserVideoGroupEntry> {
	public VideoUserVideoGroupEntryWrapper(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		_videoUserVideoGroupEntry = videoUserVideoGroupEntry;
	}

	public Class<?> getModelClass() {
		return VideoUserVideoGroupEntry.class;
	}

	public String getModelClassName() {
		return VideoUserVideoGroupEntry.class.getName();
	}

	/**
	* Returns the primary key of this video user video group entry.
	*
	* @return the primary key of this video user video group entry
	*/
	public long getPrimaryKey() {
		return _videoUserVideoGroupEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video user video group entry.
	*
	* @param primaryKey the primary key of this video user video group entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoUserVideoGroupEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video user video group i d of this video user video group entry.
	*
	* @return the video user video group i d of this video user video group entry
	*/
	public long getVideoUserVideoGroupID() {
		return _videoUserVideoGroupEntry.getVideoUserVideoGroupID();
	}

	/**
	* Sets the video user video group i d of this video user video group entry.
	*
	* @param videoUserVideoGroupID the video user video group i d of this video user video group entry
	*/
	public void setVideoUserVideoGroupID(long videoUserVideoGroupID) {
		_videoUserVideoGroupEntry.setVideoUserVideoGroupID(videoUserVideoGroupID);
	}

	/**
	* Returns the video user ID of this video user video group entry.
	*
	* @return the video user ID of this video user video group entry
	*/
	public long getVideoUserId() {
		return _videoUserVideoGroupEntry.getVideoUserId();
	}

	/**
	* Sets the video user ID of this video user video group entry.
	*
	* @param videoUserId the video user ID of this video user video group entry
	*/
	public void setVideoUserId(long videoUserId) {
		_videoUserVideoGroupEntry.setVideoUserId(videoUserId);
	}

	/**
	* Returns the video user uuid of this video user video group entry.
	*
	* @return the video user uuid of this video user video group entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getVideoUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserVideoGroupEntry.getVideoUserUuid();
	}

	/**
	* Sets the video user uuid of this video user video group entry.
	*
	* @param videoUserUuid the video user uuid of this video user video group entry
	*/
	public void setVideoUserUuid(java.lang.String videoUserUuid) {
		_videoUserVideoGroupEntry.setVideoUserUuid(videoUserUuid);
	}

	/**
	* Returns the video group ID of this video user video group entry.
	*
	* @return the video group ID of this video user video group entry
	*/
	public long getVideoGroupId() {
		return _videoUserVideoGroupEntry.getVideoGroupId();
	}

	/**
	* Sets the video group ID of this video user video group entry.
	*
	* @param videoGroupId the video group ID of this video user video group entry
	*/
	public void setVideoGroupId(long videoGroupId) {
		_videoUserVideoGroupEntry.setVideoGroupId(videoGroupId);
	}

	public boolean isNew() {
		return _videoUserVideoGroupEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoUserVideoGroupEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoUserVideoGroupEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoUserVideoGroupEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoUserVideoGroupEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoUserVideoGroupEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoUserVideoGroupEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoUserVideoGroupEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoUserVideoGroupEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoUserVideoGroupEntryWrapper((VideoUserVideoGroupEntry)_videoUserVideoGroupEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		return _videoUserVideoGroupEntry.compareTo(videoUserVideoGroupEntry);
	}

	@Override
	public int hashCode() {
		return _videoUserVideoGroupEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.VideoUserVideoGroupEntry> toCacheModel() {
		return _videoUserVideoGroupEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.VideoUserVideoGroupEntry toEscapedModel() {
		return new VideoUserVideoGroupEntryWrapper(_videoUserVideoGroupEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoUserVideoGroupEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoUserVideoGroupEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoUserVideoGroupEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoUserVideoGroupEntry getWrappedVideoUserVideoGroupEntry() {
		return _videoUserVideoGroupEntry;
	}

	public VideoUserVideoGroupEntry getWrappedModel() {
		return _videoUserVideoGroupEntry;
	}

	public void resetOriginalValues() {
		_videoUserVideoGroupEntry.resetOriginalValues();
	}

	private VideoUserVideoGroupEntry _videoUserVideoGroupEntry;
}