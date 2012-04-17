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

package vn.com.fis.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import vn.com.fis.portal.model.VideoUserEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VideoUserEntry in entity cache.
 *
 * @author loind
 * @see VideoUserEntry
 * @generated
 */
public class VideoUserEntryCacheModel implements CacheModel<VideoUserEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{videoUserId=");
		sb.append(videoUserId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", originCode=");
		sb.append(originCode);
		sb.append(", date_=");
		sb.append(date_);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", senderId=");
		sb.append(senderId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VideoUserEntry toEntityModel() {
		VideoUserEntryImpl videoUserEntryImpl = new VideoUserEntryImpl();

		videoUserEntryImpl.setVideoUserId(videoUserId);
		videoUserEntryImpl.setVideoId(videoId);
		videoUserEntryImpl.setUserId(userId);
		videoUserEntryImpl.setOriginCode(originCode);

		if (date_ == Long.MIN_VALUE) {
			videoUserEntryImpl.setDate_(null);
		}
		else {
			videoUserEntryImpl.setDate_(new Date(date_));
		}

		if (startDate == Long.MIN_VALUE) {
			videoUserEntryImpl.setStartDate(null);
		}
		else {
			videoUserEntryImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			videoUserEntryImpl.setEndDate(null);
		}
		else {
			videoUserEntryImpl.setEndDate(new Date(endDate));
		}

		videoUserEntryImpl.setSenderId(senderId);
		videoUserEntryImpl.setStatus(status);

		videoUserEntryImpl.resetOriginalValues();

		return videoUserEntryImpl;
	}

	public long videoUserId;
	public long videoId;
	public long userId;
	public int originCode;
	public long date_;
	public long startDate;
	public long endDate;
	public long senderId;
	public int status;
}