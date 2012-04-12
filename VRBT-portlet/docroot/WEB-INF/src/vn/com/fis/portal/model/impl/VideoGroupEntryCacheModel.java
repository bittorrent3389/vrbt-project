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

import vn.com.fis.portal.model.VideoGroupEntry;

import java.io.Serializable;

/**
 * The cache model class for representing VideoGroupEntry in entity cache.
 *
 * @author loind
 * @see VideoGroupEntry
 * @generated
 */
public class VideoGroupEntryCacheModel implements CacheModel<VideoGroupEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoGroupId=");
		sb.append(videoGroupId);
		sb.append(", videoGroupName=");
		sb.append(videoGroupName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public VideoGroupEntry toEntityModel() {
		VideoGroupEntryImpl videoGroupEntryImpl = new VideoGroupEntryImpl();

		videoGroupEntryImpl.setVideoGroupId(videoGroupId);

		if (videoGroupName == null) {
			videoGroupEntryImpl.setVideoGroupName(StringPool.BLANK);
		}
		else {
			videoGroupEntryImpl.setVideoGroupName(videoGroupName);
		}

		if (description == null) {
			videoGroupEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			videoGroupEntryImpl.setDescription(description);
		}

		videoGroupEntryImpl.resetOriginalValues();

		return videoGroupEntryImpl;
	}

	public long videoGroupId;
	public String videoGroupName;
	public String description;
}