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
 * This class is a wrapper for {@link VideoUserTransactionEntry}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserTransactionEntry
 * @generated
 */
public class VideoUserTransactionEntryWrapper
	implements VideoUserTransactionEntry,
		ModelWrapper<VideoUserTransactionEntry> {
	public VideoUserTransactionEntryWrapper(
		VideoUserTransactionEntry videoUserTransactionEntry) {
		_videoUserTransactionEntry = videoUserTransactionEntry;
	}

	public Class<?> getModelClass() {
		return VideoUserTransactionEntry.class;
	}

	public String getModelClassName() {
		return VideoUserTransactionEntry.class.getName();
	}

	/**
	* Returns the primary key of this video user transaction entry.
	*
	* @return the primary key of this video user transaction entry
	*/
	public long getPrimaryKey() {
		return _videoUserTransactionEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video user transaction entry.
	*
	* @param primaryKey the primary key of this video user transaction entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_videoUserTransactionEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the transaction ID of this video user transaction entry.
	*
	* @return the transaction ID of this video user transaction entry
	*/
	public long getTransactionId() {
		return _videoUserTransactionEntry.getTransactionId();
	}

	/**
	* Sets the transaction ID of this video user transaction entry.
	*
	* @param transactionId the transaction ID of this video user transaction entry
	*/
	public void setTransactionId(long transactionId) {
		_videoUserTransactionEntry.setTransactionId(transactionId);
	}

	/**
	* Returns the transaction code of this video user transaction entry.
	*
	* @return the transaction code of this video user transaction entry
	*/
	public long getTransactionCode() {
		return _videoUserTransactionEntry.getTransactionCode();
	}

	/**
	* Sets the transaction code of this video user transaction entry.
	*
	* @param transactionCode the transaction code of this video user transaction entry
	*/
	public void setTransactionCode(long transactionCode) {
		_videoUserTransactionEntry.setTransactionCode(transactionCode);
	}

	/**
	* Returns the date_ of this video user transaction entry.
	*
	* @return the date_ of this video user transaction entry
	*/
	public java.util.Date getDate_() {
		return _videoUserTransactionEntry.getDate_();
	}

	/**
	* Sets the date_ of this video user transaction entry.
	*
	* @param date_ the date_ of this video user transaction entry
	*/
	public void setDate_(java.util.Date date_) {
		_videoUserTransactionEntry.setDate_(date_);
	}

	/**
	* Returns the video ID of this video user transaction entry.
	*
	* @return the video ID of this video user transaction entry
	*/
	public long getVideoId() {
		return _videoUserTransactionEntry.getVideoId();
	}

	/**
	* Sets the video ID of this video user transaction entry.
	*
	* @param videoId the video ID of this video user transaction entry
	*/
	public void setVideoId(long videoId) {
		_videoUserTransactionEntry.setVideoId(videoId);
	}

	/**
	* Returns the user ID of this video user transaction entry.
	*
	* @return the user ID of this video user transaction entry
	*/
	public long getUserId() {
		return _videoUserTransactionEntry.getUserId();
	}

	/**
	* Sets the user ID of this video user transaction entry.
	*
	* @param userId the user ID of this video user transaction entry
	*/
	public void setUserId(long userId) {
		_videoUserTransactionEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this video user transaction entry.
	*
	* @return the user uuid of this video user transaction entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserTransactionEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this video user transaction entry.
	*
	* @param userUuid the user uuid of this video user transaction entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_videoUserTransactionEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the receiver ID of this video user transaction entry.
	*
	* @return the receiver ID of this video user transaction entry
	*/
	public long getReceiverId() {
		return _videoUserTransactionEntry.getReceiverId();
	}

	/**
	* Sets the receiver ID of this video user transaction entry.
	*
	* @param receiverId the receiver ID of this video user transaction entry
	*/
	public void setReceiverId(long receiverId) {
		_videoUserTransactionEntry.setReceiverId(receiverId);
	}

	public boolean isNew() {
		return _videoUserTransactionEntry.isNew();
	}

	public void setNew(boolean n) {
		_videoUserTransactionEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _videoUserTransactionEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_videoUserTransactionEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _videoUserTransactionEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _videoUserTransactionEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoUserTransactionEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoUserTransactionEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoUserTransactionEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoUserTransactionEntryWrapper((VideoUserTransactionEntry)_videoUserTransactionEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry) {
		return _videoUserTransactionEntry.compareTo(videoUserTransactionEntry);
	}

	@Override
	public int hashCode() {
		return _videoUserTransactionEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.VideoUserTransactionEntry> toCacheModel() {
		return _videoUserTransactionEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry toEscapedModel() {
		return new VideoUserTransactionEntryWrapper(_videoUserTransactionEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoUserTransactionEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _videoUserTransactionEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoUserTransactionEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public VideoUserTransactionEntry getWrappedVideoUserTransactionEntry() {
		return _videoUserTransactionEntry;
	}

	public VideoUserTransactionEntry getWrappedModel() {
		return _videoUserTransactionEntry;
	}

	public void resetOriginalValues() {
		_videoUserTransactionEntry.resetOriginalValues();
	}

	private VideoUserTransactionEntry _videoUserTransactionEntry;
}