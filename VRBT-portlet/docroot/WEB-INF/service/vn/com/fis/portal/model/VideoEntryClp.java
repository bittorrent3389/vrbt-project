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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.com.fis.portal.service.VideoEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class VideoEntryClp extends BaseModelImpl<VideoEntry>
	implements VideoEntry {
	public VideoEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoEntry.class;
	}

	public String getModelClassName() {
		return VideoEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(long primaryKey) {
		setVideoId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_videoId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public String getVideoName() {
		return _videoName;
	}

	public void setVideoName(String videoName) {
		_videoName = videoName;
	}

	public String getVideoUrl() {
		return _videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getViewCount() {
		return _viewCount;
	}

	public void setViewCount(long viewCount) {
		_viewCount = viewCount;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	public String getSmallImageUrl() {
		return _smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;
	}

	public String getLargeImageUrl() {
		return _largeImageUrl;
	}

	public void setLargeImageUrl(String largeImageUrl) {
		_largeImageUrl = largeImageUrl;
	}

	public int getAccessModifier() {
		return _accessModifier;
	}

	public void setAccessModifier(int accessModifier) {
		_accessModifier = accessModifier;
	}

	public long getUploaderId() {
		return _uploaderId;
	}

	public void setUploaderId(long uploaderId) {
		_uploaderId = uploaderId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoEntryLocalServiceUtil.addVideoEntry(this);
		}
		else {
			VideoEntryLocalServiceUtil.updateVideoEntry(this);
		}
	}

	@Override
	public VideoEntry toEscapedModel() {
		return (VideoEntry)Proxy.newProxyInstance(VideoEntry.class.getClassLoader(),
			new Class[] { VideoEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoEntryClp clone = new VideoEntryClp();

		clone.setVideoId(getVideoId());
		clone.setVideoName(getVideoName());
		clone.setVideoUrl(getVideoUrl());
		clone.setDescription(getDescription());
		clone.setViewCount(getViewCount());
		clone.setDate_(getDate_());
		clone.setSmallImageUrl(getSmallImageUrl());
		clone.setLargeImageUrl(getLargeImageUrl());
		clone.setAccessModifier(getAccessModifier());
		clone.setUploaderId(getUploaderId());
		clone.setFolderId(getFolderId());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(VideoEntry videoEntry) {
		int value = 0;

		value = getVideoName().compareTo(videoEntry.getVideoName());

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getDate_(), videoEntry.getDate_());

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

		VideoEntryClp videoEntry = null;

		try {
			videoEntry = (VideoEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{videoId=");
		sb.append(getVideoId());
		sb.append(", videoName=");
		sb.append(getVideoName());
		sb.append(", videoUrl=");
		sb.append(getVideoUrl());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", viewCount=");
		sb.append(getViewCount());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append(", smallImageUrl=");
		sb.append(getSmallImageUrl());
		sb.append(", largeImageUrl=");
		sb.append(getLargeImageUrl());
		sb.append(", accessModifier=");
		sb.append(getAccessModifier());
		sb.append(", uploaderId=");
		sb.append(getUploaderId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.VideoEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoName</column-name><column-value><![CDATA[");
		sb.append(getVideoName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoUrl</column-name><column-value><![CDATA[");
		sb.append(getVideoUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCount</column-name><column-value><![CDATA[");
		sb.append(getViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageUrl</column-name><column-value><![CDATA[");
		sb.append(getSmallImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>largeImageUrl</column-name><column-value><![CDATA[");
		sb.append(getLargeImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accessModifier</column-name><column-value><![CDATA[");
		sb.append(getAccessModifier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploaderId</column-name><column-value><![CDATA[");
		sb.append(getUploaderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoId;
	private String _videoName;
	private String _videoUrl;
	private String _description;
	private long _viewCount;
	private Date _date_;
	private String _smallImageUrl;
	private String _largeImageUrl;
	private int _accessModifier;
	private long _uploaderId;
	private long _folderId;
	private int _status;
}