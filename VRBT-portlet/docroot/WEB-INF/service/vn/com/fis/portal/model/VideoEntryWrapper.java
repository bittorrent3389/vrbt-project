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
 * This class is a wrapper for {@link VideoEntry}.
 * </p>
 *
 * @author    loind
 * @see       VideoEntry
 * @generated
 */
public class VideoEntryWrapper implements VideoEntry, ModelWrapper<VideoEntry> {
	public VideoEntryWrapper(VideoEntry videoEntry) {
		_videoEntry = videoEntry;
	}

	public Class<?> getModelClass() {
		return VideoEntry.class;
	}

	public String getModelClassName() {
		return VideoEntry.class.getName();
	}

	/**
	* Returns the primary key of this video entry.
	*
	* @return the primary key of this video entry
	*/
	public long getPrimaryKey() {
		return _videoEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video entry.
	*
	* @param primaryKey the primary key of this video entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video ID of this video entry.
	*
	* @return the video ID of this video entry
	*/
	public long getVideoId() {
		return _videoEntry.getVideoId();
	}

	/**
	* Sets the video ID of this video entry.
	*
	* @param videoId the video ID of this video entry
	*/
	public void setVideoId(long videoId) {
		_videoEntry.setVideoId(videoId);
	}

	/**
	* Returns the video name of this video entry.
	*
	* @return the video name of this video entry
	*/
	public java.lang.String getVideoName() {
		return _videoEntry.getVideoName();
	}

	/**
	* Sets the video name of this video entry.
	*
	* @param videoName the video name of this video entry
	*/
	public void setVideoName(java.lang.String videoName) {
		_videoEntry.setVideoName(videoName);
	}

	/**
	* Returns the video url of this video entry.
	*
	* @return the video url of this video entry
	*/
	public java.lang.String getVideoUrl() {
		return _videoEntry.getVideoUrl();
	}

	/**
	* Sets the video url of this video entry.
	*
	* @param videoUrl the video url of this video entry
	*/
	public void setVideoUrl(java.lang.String videoUrl) {
		_videoEntry.setVideoUrl(videoUrl);
	}

	/**
	* Returns the description of this video entry.
	*
	* @return the description of this video entry
	*/
	public java.lang.String getDescription() {
		return _videoEntry.getDescription();
	}

	/**
	* Sets the description of this video entry.
	*
	* @param description the description of this video entry
	*/
	public void setDescription(java.lang.String description) {
		_videoEntry.setDescription(description);
	}

	/**
	* Returns the view count of this video entry.
	*
	* @return the view count of this video entry
	*/
	public long getViewCount() {
		return _videoEntry.getViewCount();
	}

	/**
	* Sets the view count of this video entry.
	*
	* @param viewCount the view count of this video entry
	*/
	public void setViewCount(long viewCount) {
		_videoEntry.setViewCount(viewCount);
	}

	/**
	* Returns the date_ of this video entry.
	*
	* @return the date_ of this video entry
	*/
	public java.util.Date getDate_() {
		return _videoEntry.getDate_();
	}

	/**
	* Sets the date_ of this video entry.
	*
	* @param date_ the date_ of this video entry
	*/
	public void setDate_(java.util.Date date_) {
		_videoEntry.setDate_(date_);
	}

	/**
	* Returns the small image url of this video entry.
	*
	* @return the small image url of this video entry
	*/
	public java.lang.String getSmallImageUrl() {
		return _videoEntry.getSmallImageUrl();
	}

	/**
	* Sets the small image url of this video entry.
	*
	* @param smallImageUrl the small image url of this video entry
	*/
	public void setSmallImageUrl(java.lang.String smallImageUrl) {
		_videoEntry.setSmallImageUrl(smallImageUrl);
	}

	/**
	* Returns the large image url of this video entry.
	*
	* @return the large image url of this video entry
	*/
	public java.lang.String getLargeImageUrl() {
		return _videoEntry.getLargeImageUrl();
	}

	/**
	* Sets the large image url of this video entry.
	*
	* @param largeImageUrl the large image url of this video entry
	*/
	public void setLargeImageUrl(java.lang.String largeImageUrl) {
		_videoEntry.setLargeImageUrl(largeImageUrl);
	}

	/**
	* Returns the access modifier of this video entry.
	*
	* @return the access modifier of this video entry
	*/
	public int getAccessModifier() {
		return _videoEntry.getAccessModifier();
	}

	/**
	* Sets the access modifier of this video entry.
	*
	* @param accessModifier the access modifier of this video entry
	*/
	public void setAccessModifier(int accessModifier) {
		_videoEntry.setAccessModifier(accessModifier);
	}

	/**
	* Returns the uploader ID of this video entry.
	*
	* @return the uploader ID of this video entry
	*/
	public long getUploaderId() {
		return _videoEntry.getUploaderId();
	}

	/**
	* Sets the uploader ID of this video entry.
	*
	* @param uploaderId the uploader ID of this video entry
	*/
	public void setUploaderId(long uploaderId) {
		_videoEntry.setUploaderId(uploaderId);
	}

	/**
	* Returns the folder ID of this video entry.
	*
	* @return the folder ID of this video entry
	*/
	public long getFolderId() {
		return _videoEntry.getFolderId();
	}

	/**
	* Sets the folder ID of this video entry.
	*
	* @param folderId the folder ID of this video entry
	*/
	public void setFolderId(long folderId) {
		_videoEntry.setFolderId(folderId);
	}

	/**
	* Returns the status of this video entry.
	*
	* @return the status of this video entry
	*/
	public int getStatus() {
		return _videoEntry.getStatus();
	}

	/**
	* Sets the status of this video entry.
	*
	* @param status the status of this video entry
	*/
	public void setStatus(int status) {
		_videoEntry.setStatus(status);
	}

	public boolean isNew() {
		return _videoEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoEntryWrapper((VideoEntry)_videoEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.VideoEntry videoEntry) {
		return _videoEntry.compareTo(videoEntry);
	}

	@Override
	public int hashCode() {
		return _videoEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.VideoEntry> toCacheModel() {
		return _videoEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.VideoEntry toEscapedModel() {
		return new VideoEntryWrapper(_videoEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoEntry getWrappedVideoEntry() {
		return _videoEntry;
	}

	public VideoEntry getWrappedModel() {
		return _videoEntry;
	}

	public void resetOriginalValues() {
		_videoEntry.resetOriginalValues();
	}

	private VideoEntry _videoEntry;
}