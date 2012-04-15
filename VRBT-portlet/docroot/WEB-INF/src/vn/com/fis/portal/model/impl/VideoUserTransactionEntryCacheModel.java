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

import vn.com.fis.portal.model.VideoUserTransactionEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VideoUserTransactionEntry in entity cache.
 *
 * @author loind
 * @see VideoUserTransactionEntry
 * @generated
 */
public class VideoUserTransactionEntryCacheModel implements CacheModel<VideoUserTransactionEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{transactionId=");
		sb.append(transactionId);
		sb.append(", transactionCode=");
		sb.append(transactionCode);
		sb.append(", date_=");
		sb.append(date_);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", receiverId=");
		sb.append(receiverId);
		sb.append("}");

		return sb.toString();
	}

	public VideoUserTransactionEntry toEntityModel() {
		VideoUserTransactionEntryImpl videoUserTransactionEntryImpl = new VideoUserTransactionEntryImpl();

		videoUserTransactionEntryImpl.setTransactionId(transactionId);
		videoUserTransactionEntryImpl.setTransactionCode(transactionCode);

		if (date_ == Long.MIN_VALUE) {
			videoUserTransactionEntryImpl.setDate_(null);
		}
		else {
			videoUserTransactionEntryImpl.setDate_(new Date(date_));
		}

		videoUserTransactionEntryImpl.setVideoId(videoId);
		videoUserTransactionEntryImpl.setUserId(userId);
		videoUserTransactionEntryImpl.setReceiverId(receiverId);

		videoUserTransactionEntryImpl.resetOriginalValues();

		return videoUserTransactionEntryImpl;
	}

	public long transactionId;
	public long transactionCode;
	public long date_;
	public long videoId;
	public long userId;
	public long receiverId;
}