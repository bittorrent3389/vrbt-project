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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.VideoUserContactEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.VideoUserContactEntryServiceSoap
 * @generated
 */
public class VideoUserContactEntrySoap implements Serializable {
	public static VideoUserContactEntrySoap toSoapModel(
		VideoUserContactEntry model) {
		VideoUserContactEntrySoap soapModel = new VideoUserContactEntrySoap();

		soapModel.setVideoUserContactId(model.getVideoUserContactId());
		soapModel.setVideoUserId(model.getVideoUserId());
		soapModel.setContactId(model.getContactId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setPriority(model.getPriority());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VideoUserContactEntrySoap[] toSoapModels(
		VideoUserContactEntry[] models) {
		VideoUserContactEntrySoap[] soapModels = new VideoUserContactEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoUserContactEntrySoap[][] toSoapModels(
		VideoUserContactEntry[][] models) {
		VideoUserContactEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoUserContactEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoUserContactEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoUserContactEntrySoap[] toSoapModels(
		List<VideoUserContactEntry> models) {
		List<VideoUserContactEntrySoap> soapModels = new ArrayList<VideoUserContactEntrySoap>(models.size());

		for (VideoUserContactEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoUserContactEntrySoap[soapModels.size()]);
	}

	public VideoUserContactEntrySoap() {
	}

	public long getPrimaryKey() {
		return _videoUserContactId;
	}

	public void setPrimaryKey(long pk) {
		setVideoUserContactId(pk);
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

	private long _videoUserContactId;
	private long _videoUserId;
	private long _contactId;
	private long _companyId;
	private Date _startTime;
	private Date _endTime;
	private int _priority;
	private int _status;
}