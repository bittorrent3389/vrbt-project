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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.fis.portal.service.VideoUserVideoGroupEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class VideoUserVideoGroupEntryClp extends BaseModelImpl<VideoUserVideoGroupEntry>
	implements VideoUserVideoGroupEntry {
	public VideoUserVideoGroupEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoUserVideoGroupEntry.class;
	}

	public String getModelClassName() {
		return VideoUserVideoGroupEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _videoUserVideoGroupID;
	}

	public void setPrimaryKey(long primaryKey) {
		setVideoUserVideoGroupID(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_videoUserVideoGroupID);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getVideoUserVideoGroupID() {
		return _videoUserVideoGroupID;
	}

	public void setVideoUserVideoGroupID(long videoUserVideoGroupID) {
		_videoUserVideoGroupID = videoUserVideoGroupID;
	}

	public long getVideoUserId() {
		return _videoUserId;
	}

	public void setVideoUserId(long videoUserId) {
		_videoUserId = videoUserId;
	}

	public String getVideoUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getVideoUserId(), "uuid", _videoUserUuid);
	}

	public void setVideoUserUuid(String videoUserUuid) {
		_videoUserUuid = videoUserUuid;
	}

	public long getVideoGroupId() {
		return _videoGroupId;
	}

	public void setVideoGroupId(long videoGroupId) {
		_videoGroupId = videoGroupId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoUserVideoGroupEntryLocalServiceUtil.addVideoUserVideoGroupEntry(this);
		}
		else {
			VideoUserVideoGroupEntryLocalServiceUtil.updateVideoUserVideoGroupEntry(this);
		}
	}

	@Override
	public VideoUserVideoGroupEntry toEscapedModel() {
		return (VideoUserVideoGroupEntry)Proxy.newProxyInstance(VideoUserVideoGroupEntry.class.getClassLoader(),
			new Class[] { VideoUserVideoGroupEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoUserVideoGroupEntryClp clone = new VideoUserVideoGroupEntryClp();

		clone.setVideoUserVideoGroupID(getVideoUserVideoGroupID());
		clone.setVideoUserId(getVideoUserId());
		clone.setVideoGroupId(getVideoGroupId());

		return clone;
	}

	public int compareTo(VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		int value = 0;

		if (getVideoUserVideoGroupID() < videoUserVideoGroupEntry.getVideoUserVideoGroupID()) {
			value = -1;
		}
		else if (getVideoUserVideoGroupID() > videoUserVideoGroupEntry.getVideoUserVideoGroupID()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		VideoUserVideoGroupEntryClp videoUserVideoGroupEntry = null;

		try {
			videoUserVideoGroupEntry = (VideoUserVideoGroupEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoUserVideoGroupEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{videoUserVideoGroupID=");
		sb.append(getVideoUserVideoGroupID());
		sb.append(", videoUserId=");
		sb.append(getVideoUserId());
		sb.append(", videoGroupId=");
		sb.append(getVideoGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.VideoUserVideoGroupEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoUserVideoGroupID</column-name><column-value><![CDATA[");
		sb.append(getVideoUserVideoGroupID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoUserId</column-name><column-value><![CDATA[");
		sb.append(getVideoUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoGroupId</column-name><column-value><![CDATA[");
		sb.append(getVideoGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoUserVideoGroupID;
	private long _videoUserId;
	private String _videoUserUuid;
	private long _videoGroupId;
}