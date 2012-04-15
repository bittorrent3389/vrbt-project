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

import vn.com.fis.portal.model.RatingEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing RatingEntry in entity cache.
 *
 * @author loind
 * @see RatingEntry
 * @generated
 */
public class RatingEntryCacheModel implements CacheModel<RatingEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ratingId=");
		sb.append(ratingId);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", date_=");
		sb.append(date_);
		sb.append("}");

		return sb.toString();
	}

	public RatingEntry toEntityModel() {
		RatingEntryImpl ratingEntryImpl = new RatingEntryImpl();

		ratingEntryImpl.setRatingId(ratingId);
		ratingEntryImpl.setVideoId(videoId);
		ratingEntryImpl.setUserId(userId);
		ratingEntryImpl.setCode(code);

		if (date_ == Long.MIN_VALUE) {
			ratingEntryImpl.setDate_(null);
		}
		else {
			ratingEntryImpl.setDate_(new Date(date_));
		}

		ratingEntryImpl.resetOriginalValues();

		return ratingEntryImpl;
	}

	public long ratingId;
	public long videoId;
	public long userId;
	public int code;
	public long date_;
}