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

import vn.com.fis.portal.service.ViolationVideoEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class ViolationVideoEntryClp extends BaseModelImpl<ViolationVideoEntry>
	implements ViolationVideoEntry {
	public ViolationVideoEntryClp() {
	}

	public Class<?> getModelClass() {
		return ViolationVideoEntry.class;
	}

	public String getModelClassName() {
		return ViolationVideoEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _violationVideoId;
	}

	public void setPrimaryKey(long primaryKey) {
		setViolationVideoId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_violationVideoId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getViolationVideoId() {
		return _violationVideoId;
	}

	public void setViolationVideoId(long violationVideoId) {
		_violationVideoId = violationVideoId;
	}

	public long getViolationId() {
		return _violationId;
	}

	public void setViolationId(long violationId) {
		_violationId = violationId;
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

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ViolationVideoEntryLocalServiceUtil.addViolationVideoEntry(this);
		}
		else {
			ViolationVideoEntryLocalServiceUtil.updateViolationVideoEntry(this);
		}
	}

	@Override
	public ViolationVideoEntry toEscapedModel() {
		return (ViolationVideoEntry)Proxy.newProxyInstance(ViolationVideoEntry.class.getClassLoader(),
			new Class[] { ViolationVideoEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ViolationVideoEntryClp clone = new ViolationVideoEntryClp();

		clone.setViolationVideoId(getViolationVideoId());
		clone.setViolationId(getViolationId());
		clone.setVideoId(getVideoId());
		clone.setUserId(getUserId());
		clone.setDate_(getDate_());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ViolationVideoEntry violationVideoEntry) {
		int value = 0;

		value = DateUtil.compareTo(getDate_(), violationVideoEntry.getDate_());

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

		ViolationVideoEntryClp violationVideoEntry = null;

		try {
			violationVideoEntry = (ViolationVideoEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = violationVideoEntry.getPrimaryKey();

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

		sb.append("{violationVideoId=");
		sb.append(getViolationVideoId());
		sb.append(", violationId=");
		sb.append(getViolationId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ViolationVideoEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>violationVideoId</column-name><column-value><![CDATA[");
		sb.append(getViolationVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>violationId</column-name><column-value><![CDATA[");
		sb.append(getViolationId());
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
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _violationVideoId;
	private long _violationId;
	private long _videoId;
	private long _userId;
	private String _userUuid;
	private Date _date_;
	private String _description;
}