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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ViolationVideoEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ViolationVideoEntryServiceSoap
 * @generated
 */
public class ViolationVideoEntrySoap implements Serializable {
	public static ViolationVideoEntrySoap toSoapModel(ViolationVideoEntry model) {
		ViolationVideoEntrySoap soapModel = new ViolationVideoEntrySoap();

		soapModel.setViolationVideoId(model.getViolationVideoId());
		soapModel.setViolationId(model.getViolationId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setUserId(model.getUserId());
		soapModel.setDate_(model.getDate_());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static ViolationVideoEntrySoap[] toSoapModels(
		ViolationVideoEntry[] models) {
		ViolationVideoEntrySoap[] soapModels = new ViolationVideoEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViolationVideoEntrySoap[][] toSoapModels(
		ViolationVideoEntry[][] models) {
		ViolationVideoEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViolationVideoEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViolationVideoEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViolationVideoEntrySoap[] toSoapModels(
		List<ViolationVideoEntry> models) {
		List<ViolationVideoEntrySoap> soapModels = new ArrayList<ViolationVideoEntrySoap>(models.size());

		for (ViolationVideoEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViolationVideoEntrySoap[soapModels.size()]);
	}

	public ViolationVideoEntrySoap() {
	}

	public long getPrimaryKey() {
		return _violationVideoId;
	}

	public void setPrimaryKey(long pk) {
		setViolationVideoId(pk);
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

	private long _violationVideoId;
	private long _violationId;
	private long _videoId;
	private long _userId;
	private Date _date_;
	private String _description;
}