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

import vn.com.fis.portal.model.VideoUserContactEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing VideoUserContactEntry in entity cache.
 *
 * @author loind
 * @see VideoUserContactEntry
 * @generated
 */
public class VideoUserContactEntryCacheModel implements CacheModel<VideoUserContactEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{videoUserContactId=");
		sb.append(videoUserContactId);
		sb.append(", videoUserId=");
		sb.append(videoUserId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", priority=");
		sb.append(priority);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public VideoUserContactEntry toEntityModel() {
		VideoUserContactEntryImpl videoUserContactEntryImpl = new VideoUserContactEntryImpl();

		videoUserContactEntryImpl.setVideoUserContactId(videoUserContactId);
		videoUserContactEntryImpl.setVideoUserId(videoUserId);
		videoUserContactEntryImpl.setContactId(contactId);
		videoUserContactEntryImpl.setCompanyId(companyId);

		if (startTime == Long.MIN_VALUE) {
			videoUserContactEntryImpl.setStartTime(null);
		}
		else {
			videoUserContactEntryImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			videoUserContactEntryImpl.setEndTime(null);
		}
		else {
			videoUserContactEntryImpl.setEndTime(new Date(endTime));
		}

		videoUserContactEntryImpl.setPriority(priority);
		videoUserContactEntryImpl.setStatus(status);

		videoUserContactEntryImpl.resetOriginalValues();

		return videoUserContactEntryImpl;
	}

	public long videoUserContactId;
	public long videoUserId;
	public long contactId;
	public long companyId;
	public long startTime;
	public long endTime;
	public int priority;
	public int status;
}