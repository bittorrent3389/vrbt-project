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

import vn.com.fis.portal.service.VideoUserContactEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class VideoUserContactEntryClp extends BaseModelImpl<VideoUserContactEntry>
	implements VideoUserContactEntry {
	public VideoUserContactEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoUserContactEntry.class;
	}

	public String getModelClassName() {
		return VideoUserContactEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _videoUserContactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setVideoUserContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_videoUserContactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getVideoUserContactId() {
		return _videoUserContactId;
	}

	public void setVideoUserContactId(long videoUserContactId) {
		_videoUserContactId = videoUserContactId;
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

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public int getPriority() {
		return _priority;
	}

	public void setPriority(int priority) {
		_priority = priority;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoUserContactEntryLocalServiceUtil.addVideoUserContactEntry(this);
		}
		else {
			VideoUserContactEntryLocalServiceUtil.updateVideoUserContactEntry(this);
		}
	}

	@Override
	public VideoUserContactEntry toEscapedModel() {
		return (VideoUserContactEntry)Proxy.newProxyInstance(VideoUserContactEntry.class.getClassLoader(),
			new Class[] { VideoUserContactEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoUserContactEntryClp clone = new VideoUserContactEntryClp();

		clone.setVideoUserContactId(getVideoUserContactId());
		clone.setVideoUserId(getVideoUserId());
		clone.setContactId(getContactId());
		clone.setCompanyId(getCompanyId());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setPriority(getPriority());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(VideoUserContactEntry videoUserContactEntry) {
		int value = 0;

		if (getPriority() < videoUserContactEntry.getPriority()) {
			value = -1;
		}
		else if (getPriority() > videoUserContactEntry.getPriority()) {
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

		VideoUserContactEntryClp videoUserContactEntry = null;

		try {
			videoUserContactEntry = (VideoUserContactEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoUserContactEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{videoUserContactId=");
		sb.append(getVideoUserContactId());
		sb.append(", videoUserId=");
		sb.append(getVideoUserId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", priority=");
		sb.append(getPriority());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.VideoUserContactEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoUserContactId</column-name><column-value><![CDATA[");
		sb.append(getVideoUserContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoUserId</column-name><column-value><![CDATA[");
		sb.append(getVideoUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priority</column-name><column-value><![CDATA[");
		sb.append(getPriority());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _videoUserContactId;
	private long _videoUserId;
	private String _videoUserUuid;
	private long _contactId;
	private long _companyId;
	private Date _startTime;
	private Date _endTime;
	private int _priority;
	private int _status;
}