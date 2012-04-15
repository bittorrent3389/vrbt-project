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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.VideoUserTransactionEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.VideoUserTransactionEntryServiceSoap
 * @generated
 */
public class VideoUserTransactionEntrySoap implements Serializable {
	public static VideoUserTransactionEntrySoap toSoapModel(
		VideoUserTransactionEntry model) {
		VideoUserTransactionEntrySoap soapModel = new VideoUserTransactionEntrySoap();

		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setTransactionCode(model.getTransactionCode());
		soapModel.setDate_(model.getDate_());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setUserId(model.getUserId());
		soapModel.setReceiverId(model.getReceiverId());

		return soapModel;
	}

	public static VideoUserTransactionEntrySoap[] toSoapModels(
		VideoUserTransactionEntry[] models) {
		VideoUserTransactionEntrySoap[] soapModels = new VideoUserTransactionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoUserTransactionEntrySoap[][] toSoapModels(
		VideoUserTransactionEntry[][] models) {
		VideoUserTransactionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoUserTransactionEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoUserTransactionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoUserTransactionEntrySoap[] toSoapModels(
		List<VideoUserTransactionEntry> models) {
		List<VideoUserTransactionEntrySoap> soapModels = new ArrayList<VideoUserTransactionEntrySoap>(models.size());

		for (VideoUserTransactionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoUserTransactionEntrySoap[soapModels.size()]);
	}

	public VideoUserTransactionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long pk) {
		setTransactionId(pk);
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

	public long getReceiverId() {
		return _receiverId;
	}

	public void setReceiverId(long receiverId) {
		_receiverId = receiverId;
	}

	private long _transactionId;
	private long _transactionCode;
	private Date _date_;
	private long _videoId;
	private long _userId;
	private long _receiverId;
}