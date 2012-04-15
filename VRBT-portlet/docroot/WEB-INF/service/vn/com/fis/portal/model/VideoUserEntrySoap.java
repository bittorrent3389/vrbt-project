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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.VideoUserEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.VideoUserEntryServiceSoap
 * @generated
 */
public class VideoUserEntrySoap implements Serializable {
	public static VideoUserEntrySoap toSoapModel(VideoUserEntry model) {
		VideoUserEntrySoap soapModel = new VideoUserEntrySoap();

		soapModel.setVideoUserId(model.getVideoUserId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setUserId(model.getUserId());
		soapModel.setOriginCode(model.getOriginCode());
		soapModel.setDate_(model.getDate_());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setSenderId(model.getSenderId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VideoUserEntrySoap[] toSoapModels(VideoUserEntry[] models) {
		VideoUserEntrySoap[] soapModels = new VideoUserEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoUserEntrySoap[][] toSoapModels(VideoUserEntry[][] models) {
		VideoUserEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoUserEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoUserEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoUserEntrySoap[] toSoapModels(List<VideoUserEntry> models) {
		List<VideoUserEntrySoap> soapModels = new ArrayList<VideoUserEntrySoap>(models.size());

		for (VideoUserEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoUserEntrySoap[soapModels.size()]);
	}

	public VideoUserEntrySoap() {
	}

	public long getPrimaryKey() {
		return _videoUserId;
	}

	public void setPrimaryKey(long pk) {
		setVideoUserId(pk);
	}

	public long getVideoUserId() {
		return _videoUserId;
	}

	public void setVideoUserId(long videoUserId) {
		_videoUserId = videoUserId;
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

	private long _videoUserId;
	private long _videoId;
	private long _userId;
	private int _originCode;
	private Date _date_;
	private Date _startDate;
	private Date _endDate;
	private long _senderId;
	private int _status;
}