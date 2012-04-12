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
 * This class is a wrapper for {@link VideoUserEntry}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserEntry
 * @generated
 */
public class VideoUserEntryWrapper implements VideoUserEntry,
	ModelWrapper<VideoUserEntry> {
	public VideoUserEntryWrapper(VideoUserEntry videoUserEntry) {
		_videoUserEntry = videoUserEntry;
	}

	public Class<?> getModelClass() {
		return VideoUserEntry.class;
	}

	public String getModelClassName() {
		return VideoUserEntry.class.getName();
	}

	/**
	* Returns the primary key of this video user entry.
	*
	* @return the primary key of this video user entry
	*/
	public long getPrimaryKey() {
		return _videoUserEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video user entry.
	*
	* @param primaryKey the primary key of this video user entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoUserEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the video user ID of this video user entry.
	*
	* @return the video user ID of this video user entry
	*/
	public long getVideoUserId() {
		return _videoUserEntry.getVideoUserId();
	}

	/**
	* Sets the video user ID of this video user entry.
	*
	* @param videoUserId the video user ID of this video user entry
	*/
	public void setVideoUserId(long videoUserId) {
		_videoUserEntry.setVideoUserId(videoUserId);
	}

	/**
	* Returns the video user uuid of this video user entry.
	*
	* @return the video user uuid of this video user entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getVideoUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserEntry.getVideoUserUuid();
	}

	/**
	* Sets the video user uuid of this video user entry.
	*
	* @param videoUserUuid the video user uuid of this video user entry
	*/
	public void setVideoUserUuid(java.lang.String videoUserUuid) {
		_videoUserEntry.setVideoUserUuid(videoUserUuid);
	}

	/**
	* Returns the video ID of this video user entry.
	*
	* @return the video ID of this video user entry
	*/
	public long getVideoId() {
		return _videoUserEntry.getVideoId();
	}

	/**
	* Sets the video ID of this video user entry.
	*
	* @param videoId the video ID of this video user entry
	*/
	public void setVideoId(long videoId) {
		_videoUserEntry.setVideoId(videoId);
	}

	/**
	* Returns the user ID of this video user entry.
	*
	* @return the user ID of this video user entry
	*/
	public long getUserId() {
		return _videoUserEntry.getUserId();
	}

	/**
	* Sets the user ID of this video user entry.
	*
	* @param userId the user ID of this video user entry
	*/
	public void setUserId(long userId) {
		_videoUserEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this video user entry.
	*
	* @return the user uuid of this video user entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this video user entry.
	*
	* @param userUuid the user uuid of this video user entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_videoUserEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the origin code of this video user entry.
	*
	* @return the origin code of this video user entry
	*/
	public int getOriginCode() {
		return _videoUserEntry.getOriginCode();
	}

	/**
	* Sets the origin code of this video user entry.
	*
	* @param originCode the origin code of this video user entry
	*/
	public void setOriginCode(int originCode) {
		_videoUserEntry.setOriginCode(originCode);
	}

	/**
	* Returns the date_ of this video user entry.
	*
	* @return the date_ of this video user entry
	*/
	public java.util.Date getDate_() {
		return _videoUserEntry.getDate_();
	}

	/**
	* Sets the date_ of this video user entry.
	*
	* @param date_ the date_ of this video user entry
	*/
	public void setDate_(java.util.Date date_) {
		_videoUserEntry.setDate_(date_);
	}

	/**
	* Returns the start date of this video user entry.
	*
	* @return the start date of this video user entry
	*/
	public java.util.Date getStartDate() {
		return _videoUserEntry.getStartDate();
	}

	/**
	* Sets the start date of this video user entry.
	*
	* @param startDate the start date of this video user entry
	*/
	public void setStartDate(java.util.Date startDate) {
		_videoUserEntry.setStartDate(startDate);
	}

	/**
	* Returns the end date of this video user entry.
	*
	* @return the end date of this video user entry
	*/
	public java.util.Date getEndDate() {
		return _videoUserEntry.getEndDate();
	}

	/**
	* Sets the end date of this video user entry.
	*
	* @param endDate the end date of this video user entry
	*/
	public void setEndDate(java.util.Date endDate) {
		_videoUserEntry.setEndDate(endDate);
	}

	/**
	* Returns the sender ID of this video user entry.
	*
	* @return the sender ID of this video user entry
	*/
	public long getSenderId() {
		return _videoUserEntry.getSenderId();
	}

	/**
	* Sets the sender ID of this video user entry.
	*
	* @param senderId the sender ID of this video user entry
	*/
	public void setSenderId(long senderId) {
		_videoUserEntry.setSenderId(senderId);
	}

	/**
	* Returns the status of this video user entry.
	*
	* @return the status of this video user entry
	*/
	public int getStatus() {
		return _videoUserEntry.getStatus();
	}

	/**
	* Sets the status of this video user entry.
	*
	* @param status the status of this video user entry
	*/
	public void setStatus(int status) {
		_videoUserEntry.setStatus(status);
	}

	public boolean isNew() {
		return _videoUserEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoUserEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoUserEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoUserEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoUserEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoUserEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoUserEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoUserEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoUserEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoUserEntryWrapper((VideoUserEntry)_videoUserEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.VideoUserEntry videoUserEntry) {
		return _videoUserEntry.compareTo(videoUserEntry);
	}

	@Override
	public int hashCode() {
		return _videoUserEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.VideoUserEntry> toCacheModel() {
		return _videoUserEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.VideoUserEntry toEscapedModel() {
		return new VideoUserEntryWrapper(_videoUserEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoUserEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoUserEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoUserEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoUserEntry getWrappedVideoUserEntry() {
		return _videoUserEntry;
	}

	public VideoUserEntry getWrappedModel() {
		return _videoUserEntry;
	}

	public void resetOriginalValues() {
		_videoUserEntry.resetOriginalValues();
	}

	private VideoUserEntry _videoUserEntry;
}