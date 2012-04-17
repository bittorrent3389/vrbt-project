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

import vn.com.fis.portal.service.VideoUserTransactionEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class VideoUserTransactionEntryClp extends BaseModelImpl<VideoUserTransactionEntry>
	implements VideoUserTransactionEntry {
	public VideoUserTransactionEntryClp() {
	}

	public Class<?> getModelClass() {
		return VideoUserTransactionEntry.class;
	}

	public String getModelClassName() {
		return VideoUserTransactionEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTransactionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_transactionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_transactionId = transactionId;
	}

	public long getTransactionCode() {
		return _transactionCode;
	}

	public void setTransactionCode(long transactionCode) {
		_transactionCode = transactionCode;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
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

	public long getReceiverId() {
		return _receiverId;
	}

	public void setReceiverId(long receiverId) {
		_receiverId = receiverId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoUserTransactionEntryLocalServiceUtil.addVideoUserTransactionEntry(this);
		}
		else {
			VideoUserTransactionEntryLocalServiceUtil.updateVideoUserTransactionEntry(this);
		}
	}

	@Override
	public VideoUserTransactionEntry toEscapedModel() {
		return (VideoUserTransactionEntry)Proxy.newProxyInstance(VideoUserTransactionEntry.class.getClassLoader(),
			new Class[] { VideoUserTransactionEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoUserTransactionEntryClp clone = new VideoUserTransactionEntryClp();

		clone.setTransactionId(getTransactionId());
		clone.setTransactionCode(getTransactionCode());
		clone.setDate_(getDate_());
		clone.setVideoId(getVideoId());
		clone.setUserId(getUserId());
		clone.setReceiverId(getReceiverId());

		return clone;
	}

	public int compareTo(VideoUserTransactionEntry videoUserTransactionEntry) {
		int value = 0;

		value = DateUtil.compareTo(getDate_(),
				videoUserTransactionEntry.getDate_());

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

		VideoUserTransactionEntryClp videoUserTransactionEntry = null;

		try {
			videoUserTransactionEntry = (VideoUserTransactionEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = videoUserTransactionEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{transactionId=");
		sb.append(getTransactionId());
		sb.append(", transactionCode=");
		sb.append(getTransactionCode());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", receiverId=");
		sb.append(getReceiverId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.VideoUserTransactionEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionCode</column-name><column-value><![CDATA[");
		sb.append(getTransactionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
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
			"<column><column-name>receiverId</column-name><column-value><![CDATA[");
		sb.append(getReceiverId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _transactionId;
	private long _transactionCode;
	private Date _date_;
	private long _videoId;
	private long _userId;
	private String _userUuid;
	private long _receiverId;
}