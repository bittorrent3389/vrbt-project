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
 * This class is a wrapper for {@link RatingEntry}.
 * </p>
 *
 * @author    loind
 * @see       RatingEntry
 * @generated
 */
public class RatingEntryWrapper implements RatingEntry,
	ModelWrapper<RatingEntry> {
	public RatingEntryWrapper(RatingEntry ratingEntry) {
		_ratingEntry = ratingEntry;
	}

	public Class<?> getModelClass() {
		return RatingEntry.class;
	}

	public String getModelClassName() {
		return RatingEntry.class.getName();
	}

	/**
	* Returns the primary key of this rating entry.
	*
	* @return the primary key of this rating entry
	*/
	public long getPrimaryKey() {
		return _ratingEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rating entry.
	*
	* @param primaryKey the primary key of this rating entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_ratingEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the rating ID of this rating entry.
	*
	* @return the rating ID of this rating entry
	*/
	public long getRatingId() {
		return _ratingEntry.getRatingId();
	}

	/**
	* Sets the rating ID of this rating entry.
	*
	* @param ratingId the rating ID of this rating entry
	*/
	public void setRatingId(long ratingId) {
		_ratingEntry.setRatingId(ratingId);
	}

	/**
	* Returns the video ID of this rating entry.
	*
	* @return the video ID of this rating entry
	*/
	public long getVideoId() {
		return _ratingEntry.getVideoId();
	}

	/**
	* Sets the video ID of this rating entry.
	*
	* @param videoId the video ID of this rating entry
	*/
	public void setVideoId(long videoId) {
		_ratingEntry.setVideoId(videoId);
	}

	/**
	* Returns the user ID of this rating entry.
	*
	* @return the user ID of this rating entry
	*/
	public long getUserId() {
		return _ratingEntry.getUserId();
	}

	/**
	* Sets the user ID of this rating entry.
	*
	* @param userId the user ID of this rating entry
	*/
	public void setUserId(long userId) {
		_ratingEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rating entry.
	*
	* @return the user uuid of this rating entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this rating entry.
	*
	* @param userUuid the user uuid of this rating entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_ratingEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the code of this rating entry.
	*
	* @return the code of this rating entry
	*/
	public int getCode() {
		return _ratingEntry.getCode();
	}

	/**
	* Sets the code of this rating entry.
	*
	* @param code the code of this rating entry
	*/
	public void setCode(int code) {
		_ratingEntry.setCode(code);
	}

	/**
	* Returns the date_ of this rating entry.
	*
	* @return the date_ of this rating entry
	*/
	public java.util.Date getDate_() {
		return _ratingEntry.getDate_();
	}

	/**
	* Sets the date_ of this rating entry.
	*
	* @param date_ the date_ of this rating entry
	*/
	public void setDate_(java.util.Date date_) {
		_ratingEntry.setDate_(date_);
	}

	public boolean isNew() {
		return _ratingEntry.isNew();
	}

	public void setNew(boolean n) {
		_ratingEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _ratingEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ratingEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ratingEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ratingEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ratingEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ratingEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ratingEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RatingEntryWrapper((RatingEntry)_ratingEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.RatingEntry ratingEntry) {
		return _ratingEntry.compareTo(ratingEntry);
	}

	@Override
	public int hashCode() {
		return _ratingEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.RatingEntry> toCacheModel() {
		return _ratingEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.RatingEntry toEscapedModel() {
		return new RatingEntryWrapper(_ratingEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ratingEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _ratingEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ratingEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public RatingEntry getWrappedRatingEntry() {
		return _ratingEntry;
	}

	public RatingEntry getWrappedModel() {
		return _ratingEntry;
	}

	public void resetOriginalValues() {
		_ratingEntry.resetOriginalValues();
	}

	private RatingEntry _ratingEntry;
}