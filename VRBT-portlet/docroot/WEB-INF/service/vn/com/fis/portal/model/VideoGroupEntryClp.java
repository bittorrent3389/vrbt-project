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

import vn.com.fis.portal.service.VideoGroupEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class VideoGroupEntryClp extends BaseModelImpl<VideoGroupEntry>
	implements VideoGroupEntry {
	public VideoGroupEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoGroupEntry.class;
	}

	public String getModelClassName() {
		return VideoGroupEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _videoGroupId;
	}

	public void setPrimaryKey(long primaryKey) {
		setVideoGroupId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_videoGroupId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getVideoGroupId() {
		return _videoGroupId;
	}

	public void setVideoGroupId(long videoGroupId) {
		_videoGroupId = videoGroupId;
	}

	public String getVideoGroupName() {
		return _videoGroupName;
	}

	public void setVideoGroupName(String videoGroupName) {
		_videoGroupName = videoGroupName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoGroupEntryLocalServiceUtil.addVideoGroupEntry(this);
		}
		else {
			VideoGroupEntryLocalServiceUtil.updateVideoGroupEntry(this);
		}
	}

	@Override
	public VideoGroupEntry toEscapedModel() {
		return (VideoGroupEntry)Proxy.newProxyInstance(VideoGroupEntry.class.getClassLoader(),
			new Class[] { VideoGroupEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoGroupEntryClp clone = new VideoGroupEntryClp();

		clone.setVideoGroupId(getVideoGroupId());
		clone.setVideoGroupName(getVideoGroupName());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(VideoGroupEntry videoGroupEntry) {
		int value = 0;

		value = getVideoGroupName()
					.compareTo(videoGroupEntry.getVideoGroupName());

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

		VideoGroupEntryClp videoGroupEntry = null;

		try {
			videoGroupEntry = (VideoGroupEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoGroupEntry.getPrimaryKey();

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

		sb.append("{videoGroupId=");
		sb.append(getVideoGroupId());
		sb.append(", videoGroupName=");
		sb.append(getVideoGroupName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.VideoGroupEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoGroupId</column-name><column-value><![CDATA[");
		sb.append(getVideoGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoGroupName</column-name><column-value><![CDATA[");
		sb.append(getVideoGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoGroupId;
	private String _videoGroupName;
	private String _description;
}