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

import vn.com.fis.portal.model.ViolationVideoEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ViolationVideoEntry in entity cache.
 *
 * @author loind
 * @see ViolationVideoEntry
 * @generated
 */
public class ViolationVideoEntryCacheModel implements CacheModel<ViolationVideoEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{violationVideoId=");
		sb.append(violationVideoId);
		sb.append(", violationId=");
		sb.append(violationId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", date_=");
		sb.append(date_);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public ViolationVideoEntry toEntityModel() {
		ViolationVideoEntryImpl violationVideoEntryImpl = new ViolationVideoEntryImpl();

		violationVideoEntryImpl.setViolationVideoId(violationVideoId);
		violationVideoEntryImpl.setViolationId(violationId);
		violationVideoEntryImpl.setVideoId(videoId);
		violationVideoEntryImpl.setUserId(userId);

		if (date_ == Long.MIN_VALUE) {
			violationVideoEntryImpl.setDate_(null);
		}
		else {
			violationVideoEntryImpl.setDate_(new Date(date_));
		}

		if (description == null) {
			violationVideoEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			violationVideoEntryImpl.setDescription(description);
		}

		violationVideoEntryImpl.resetOriginalValues();

		return violationVideoEntryImpl;
	}

	public long violationVideoId;
	public long violationId;
	public long videoId;
	public long userId;
	public long date_;
	public String description;
}