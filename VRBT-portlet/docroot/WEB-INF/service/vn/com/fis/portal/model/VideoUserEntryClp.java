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
import com.liferay.portal.util.PortalUtil;

import vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class VideoUserEntryClp extends BaseModelImpl<VideoUserEntry>
	implements VideoUserEntry {
	public VideoUserEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoUserEntry.class;
	}

	public String getModelClassName() {
		return VideoUserEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _videoUserId;
	}

	public void setPrimaryKey(long primaryKey) {
		setVideoUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_videoUserId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public int getOriginCode() {
		return _originCode;
	}

	public void setOriginCode(int originCode) {
		_originCode = originCode;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoUserEntryLocalServiceUtil.addVideoUserEntry(this);
		}
		else {
			VideoUserEntryLocalServiceUtil.updateVideoUserEntry(this);
		}
	}

	@Override
	public VideoUserEntry toEscapedModel() {
		return (VideoUserEntry)Proxy.newProxyInstance(VideoUserEntry.class.getClassLoader(),
			new Class[] { VideoUserEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoUserEntryClp clone = new VideoUserEntryClp();

		clone.setVideoUserId(getVideoUserId());
		clone.setVideoId(getVideoId());
		clone.setUserId(getUserId());
		clone.setOriginCode(getOriginCode());
		clone.setDate_(getDate_());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setSenderId(getSenderId());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(VideoUserEntry videoUserEntry) {
		int value = 0;

		value = DateUtil.compareTo(getDate_(), videoUserEntry.getDate_());

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

		VideoUserEntryClp videoUserEntry = null;

		try {
			videoUserEntry = (VideoUserEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoUserEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{videoUserId=");
		sb.append(getVideoUserId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", originCode=");
		sb.append(getOriginCode());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", senderId=");
		sb.append(getSenderId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.VideoUserEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoUserId</column-name><column-value><![CDATA[");
		sb.append(getVideoUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>originCode</column-name><column-value><![CDATA[");
		sb.append(getOriginCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>senderId</column-name><column-value><![CDATA[");
		sb.append(getSenderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoUserId;
	private String _videoUserUuid;
	private long _videoId;
	private long _userId;
	private String _userUuid;
	private int _originCode;
	private Date _date_;
	private Date _startDate;
	private Date _endDate;
	private long _senderId;
	private int _status;
}