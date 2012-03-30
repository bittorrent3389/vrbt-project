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
 * This class is a wrapper for {@link VideoGroupEntry}.
 * </p>
 *
 * @author    loind
 * @see       VideoGroupEntry
 * @generated
 */
public class VideoGroupEntryWrapper implements VideoGroupEntry,
	ModelWrapper<VideoGroupEntry> {
	public VideoGroupEntryWrapper(VideoGroupEntry videoGroupEntry) {
		_videoGroupEntry = videoGroupEntry;
	}

	public Class<?> getModelClass() {
		return VideoGroupEntry.class;
	}

	public String getModelClassName() {
		return VideoGroupEntry.class.getName();
	}

	/**
	* Returns the primary key of this video group entry.
	*
	* @return the primary key of this video group entry
	*/
	public long getPrimaryKey() {
		return _videoGroupEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video group entry.
	*
	* @param primaryKey the primary key of this video group entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoGroupEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video group ID of this video group entry.
	*
	* @return the video group ID of this video group entry
	*/
	public long getVideoGroupId() {
		return _videoGroupEntry.getVideoGroupId();
	}

	/**
	* Sets the video group ID of this video group entry.
	*
	* @param videoGroupId the video group ID of this video group entry
	*/
	public void setVideoGroupId(long videoGroupId) {
		_videoGroupEntry.setVideoGroupId(videoGroupId);
	}

	/**
	* Returns the video group name of this video group entry.
	*
	* @return the video group name of this video group entry
	*/
	public java.lang.String getVideoGroupName() {
		return _videoGroupEntry.getVideoGroupName();
	}

	/**
	* Sets the video group name of this video group entry.
	*
	* @param videoGroupName the video group name of this video group entry
	*/
	public void setVideoGroupName(java.lang.String videoGroupName) {
		_videoGroupEntry.setVideoGroupName(videoGroupName);
	}

	/**
	* Returns the description of this video group entry.
	*
	* @return the description of this video group entry
	*/
	public java.lang.String getDescription() {
		return _videoGroupEntry.getDescription();
	}

	/**
	* Sets the description of this video group entry.
	*
	* @param description the description of this video group entry
	*/
	public void setDescription(java.lang.String description) {
		_videoGroupEntry.setDescription(description);
	}

	public boolean isNew() {
		return _videoGroupEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoGroupEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoGroupEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoGroupEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoGroupEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoGroupEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoGroupEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoGroupEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoGroupEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoGroupEntryWrapper((VideoGroupEntry)_videoGroupEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry) {
		return _videoGroupEntry.compareTo(videoGroupEntry);
	}

	@Override
	public int hashCode() {
		return _videoGroupEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.VideoGroupEntry> toCacheModel() {
		return _videoGroupEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.VideoGroupEntry toEscapedModel() {
		return new VideoGroupEntryWrapper(_videoGroupEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoGroupEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoGroupEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoGroupEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoGroupEntry getWrappedVideoGroupEntry() {
		return _videoGroupEntry;
	}

	public VideoGroupEntry getWrappedModel() {
		return _videoGroupEntry;
	}

	public void resetOriginalValues() {
		_videoGroupEntry.resetOriginalValues();
	}

	private VideoGroupEntry _videoGroupEntry;
}