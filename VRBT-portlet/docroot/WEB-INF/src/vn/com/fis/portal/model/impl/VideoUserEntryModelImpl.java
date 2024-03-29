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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.com.fis.portal.model.VideoUserEntry;
import vn.com.fis.portal.model.VideoUserEntryModel;
import vn.com.fis.portal.model.VideoUserEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the VideoUserEntry service. Represents a row in the &quot;TBL_VIDEO_USER&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.fis.portal.model.VideoUserEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VideoUserEntryImpl}.
 * </p>
 *
 * @author loind
 * @see VideoUserEntryImpl
 * @see vn.com.fis.portal.model.VideoUserEntry
 * @see vn.com.fis.portal.model.VideoUserEntryModel
 * @generated
 */
@JSON(strict = true)
public class VideoUserEntryModelImpl extends BaseModelImpl<VideoUserEntry>
	implements VideoUserEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video user entry model instance should use the {@link vn.com.fis.portal.model.VideoUserEntry} interface instead.
	 */
	public static final String TABLE_NAME = "TBL_VIDEO_USER";
	public static final Object[][] TABLE_COLUMNS = {
			{ "videoUserId", Types.BIGINT },
			{ "videoId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "originCode", Types.INTEGER },
			{ "date_", Types.TIMESTAMP },
			{ "startDate", Types.TIMESTAMP },
			{ "endDate", Types.TIMESTAMP },
			{ "senderId", Types.BIGINT },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table TBL_VIDEO_USER (videoUserId LONG not null primary key,videoId LONG,userId LONG,originCode INTEGER,date_ DATE null,startDate DATE null,endDate DATE null,senderId LONG,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table TBL_VIDEO_USER";
	public static final String ORDER_BY_JPQL = " ORDER BY videoUserEntry.date_ ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TBL_VIDEO_USER.date_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.fis.portal.model.VideoUserEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.fis.portal.model.VideoUserEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.fis.portal.model.VideoUserEntry"),
			true);
	public static long STATUS_COLUMN_BITMASK = 1L;
	public static long USERID_COLUMN_BITMASK = 2L;
	public static long VIDEOID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VideoUserEntry toModel(VideoUserEntrySoap soapModel) {
		VideoUserEntry model = new VideoUserEntryImpl();

		model.setVideoUserId(soapModel.getVideoUserId());
		model.setVideoId(soapModel.getVideoId());
		model.setUserId(soapModel.getUserId());
		model.setOriginCode(soapModel.getOriginCode());
		model.setDate_(soapModel.getDate_());
		model.setStartDate(soapModel.getStartDate());
		model.setEndDate(soapModel.getEndDate());
		model.setSenderId(soapModel.getSenderId());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VideoUserEntry> toModels(VideoUserEntrySoap[] soapModels) {
		List<VideoUserEntry> models = new ArrayList<VideoUserEntry>(soapModels.length);

		for (VideoUserEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.fis.portal.model.VideoUserEntry"));

	public VideoUserEntryModelImpl() {
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

	public Class<?> getModelClass() {
		return VideoUserEntry.class;
	}

	public String getModelClassName() {
		return VideoUserEntry.class.getName();
	}

	@JSON
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

	@JSON
	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_columnBitmask |= VIDEOID_COLUMN_BITMASK;

		if (!_setOriginalVideoId) {
			_setOriginalVideoId = true;

			_originalVideoId = _videoId;
		}

		_videoId = videoId;
	}

	public long getOriginalVideoId() {
		return _originalVideoId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public int getOriginCode() {
		return _originCode;
	}

	public void setOriginCode(int originCode) {
		_originCode = originCode;
	}

	@JSON
	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_columnBitmask = -1L;

		_date_ = date_;
	}

	@JSON
	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public VideoUserEntry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (VideoUserEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					VideoUserEntry.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		VideoUserEntryImpl videoUserEntryImpl = new VideoUserEntryImpl();

		videoUserEntryImpl.setVideoUserId(getVideoUserId());
		videoUserEntryImpl.setVideoId(getVideoId());
		videoUserEntryImpl.setUserId(getUserId());
		videoUserEntryImpl.setOriginCode(getOriginCode());
		videoUserEntryImpl.setDate_(getDate_());
		videoUserEntryImpl.setStartDate(getStartDate());
		videoUserEntryImpl.setEndDate(getEndDate());
		videoUserEntryImpl.setSenderId(getSenderId());
		videoUserEntryImpl.setStatus(getStatus());

		videoUserEntryImpl.resetOriginalValues();

		return videoUserEntryImpl;
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

		VideoUserEntry videoUserEntry = null;

		try {
			videoUserEntry = (VideoUserEntry)obj;
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
	public void resetOriginalValues() {
		VideoUserEntryModelImpl videoUserEntryModelImpl = this;

		videoUserEntryModelImpl._originalVideoId = videoUserEntryModelImpl._videoId;

		videoUserEntryModelImpl._setOriginalVideoId = false;

		videoUserEntryModelImpl._originalUserId = videoUserEntryModelImpl._userId;

		videoUserEntryModelImpl._setOriginalUserId = false;

		videoUserEntryModelImpl._originalStatus = videoUserEntryModelImpl._status;

		videoUserEntryModelImpl._setOriginalStatus = false;

		videoUserEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VideoUserEntry> toCacheModel() {
		VideoUserEntryCacheModel videoUserEntryCacheModel = new VideoUserEntryCacheModel();

		videoUserEntryCacheModel.videoUserId = getVideoUserId();

		videoUserEntryCacheModel.videoId = getVideoId();

		videoUserEntryCacheModel.userId = getUserId();

		videoUserEntryCacheModel.originCode = getOriginCode();

		Date date_ = getDate_();

		if (date_ != null) {
			videoUserEntryCacheModel.date_ = date_.getTime();
		}
		else {
			videoUserEntryCacheModel.date_ = Long.MIN_VALUE;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			videoUserEntryCacheModel.startDate = startDate.getTime();
		}
		else {
			videoUserEntryCacheModel.startDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			videoUserEntryCacheModel.endDate = endDate.getTime();
		}
		else {
			videoUserEntryCacheModel.endDate = Long.MIN_VALUE;
		}

		videoUserEntryCacheModel.senderId = getSenderId();

		videoUserEntryCacheModel.status = getStatus();

		return videoUserEntryCacheModel;
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

	private static ClassLoader _classLoader = VideoUserEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			VideoUserEntry.class
		};
	private long _videoUserId;
	private String _videoUserUuid;
	private long _videoId;
	private long _originalVideoId;
	private boolean _setOriginalVideoId;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private int _originCode;
	private Date _date_;
	private Date _startDate;
	private Date _endDate;
	private long _senderId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private VideoUserEntry _escapedModelProxy;
}