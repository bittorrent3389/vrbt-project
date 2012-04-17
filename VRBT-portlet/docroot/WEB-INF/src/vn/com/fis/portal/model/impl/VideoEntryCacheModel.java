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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.fis.portal.model.VideoEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VideoEntry in entity cache.
 *
 * @author loind
 * @see VideoEntry
 * @generated
 */
public class VideoEntryCacheModel implements CacheModel<VideoEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{videoId=");
		sb.append(videoId);
		sb.append(", videoName=");
		sb.append(videoName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append(", date_=");
		sb.append(date_);
		sb.append(", smallImageUrl=");
		sb.append(smallImageUrl);
		sb.append(", largeImageUrl=");
		sb.append(largeImageUrl);
		sb.append(", accessModifier=");
		sb.append(accessModifier);
		sb.append(", uploaderId=");
		sb.append(uploaderId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VideoEntry toEntityModel() {
		VideoEntryImpl videoEntryImpl = new VideoEntryImpl();

		videoEntryImpl.setVideoId(videoId);

		if (videoName == null) {
			videoEntryImpl.setVideoName(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setVideoName(videoName);
		}

		if (description == null) {
			videoEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setDescription(description);
		}

		videoEntryImpl.setViewCount(viewCount);

		if (date_ == Long.MIN_VALUE) {
			videoEntryImpl.setDate_(null);
		}
		else {
			videoEntryImpl.setDate_(new Date(date_));
		}

		if (smallImageUrl == null) {
			videoEntryImpl.setSmallImageUrl(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setSmallImageUrl(smallImageUrl);
		}

		if (largeImageUrl == null) {
			videoEntryImpl.setLargeImageUrl(StringPool.BLANK);
		}
		else {
			videoEntryImpl.setLargeImageUrl(largeImageUrl);
		}

		videoEntryImpl.setAccessModifier(accessModifier);
		videoEntryImpl.setUploaderId(uploaderId);
		videoEntryImpl.setFolderId(folderId);
		videoEntryImpl.setStatus(status);

		videoEntryImpl.resetOriginalValues();

		return videoEntryImpl;
	}

	public long videoId;
	public String videoName;
	public String description;
	public long viewCount;
	public long date_;
	public String smallImageUrl;
	public String largeImageUrl;
	public int accessModifier;
	public long uploaderId;
	public long folderId;
	public int status;
}