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

import vn.com.fis.portal.service.RatingEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class RatingEntryClp extends BaseModelImpl<RatingEntry>
	implements RatingEntry {
	public RatingEntryClp() {
	}

	public Class<?> getModelClass() {
		return RatingEntry.class;
	}

	public String getModelClassName() {
		return RatingEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _ratingId;
	}

	public void setPrimaryKey(long primaryKey) {
		setRatingId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ratingId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getRatingId() {
		return _ratingId;
	}

	public void setRatingId(long ratingId) {
		_ratingId = ratingId;
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

	public int getCode() {
		return _code;
	}

	public void setCode(int code) {
		_code = code;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			RatingEntryLocalServiceUtil.addRatingEntry(this);
		}
		else {
			RatingEntryLocalServiceUtil.updateRatingEntry(this);
		}
	}

	@Override
	public RatingEntry toEscapedModel() {
		return (RatingEntry)Proxy.newProxyInstance(RatingEntry.class.getClassLoader(),
			new Class[] { RatingEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RatingEntryClp clone = new RatingEntryClp();

		clone.setRatingId(getRatingId());
		clone.setVideoId(getVideoId());
		clone.setUserId(getUserId());
		clone.setCode(getCode());
		clone.setDate_(getDate_());

		return clone;
	}

	public int compareTo(RatingEntry ratingEntry) {
		int value = 0;

		value = DateUtil.compareTo(getDate_(), ratingEntry.getDate_());

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

		RatingEntryClp ratingEntry = null;

		try {
			ratingEntry = (RatingEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ratingEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{ratingId=");
		sb.append(getRatingId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.RatingEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ratingId</column-name><column-value><![CDATA[");
		sb.append(getRatingId());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ratingId;
	private long _videoId;
	private long _userId;
	private String _userUuid;
	private int _code;
	private Date _date_;
}