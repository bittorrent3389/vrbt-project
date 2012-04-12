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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.VideoUserVideoGroupEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.VideoUserVideoGroupEntryServiceSoap
 * @generated
 */
public class VideoUserVideoGroupEntrySoap implements Serializable {
	public static VideoUserVideoGroupEntrySoap toSoapModel(
		VideoUserVideoGroupEntry model) {
		VideoUserVideoGroupEntrySoap soapModel = new VideoUserVideoGroupEntrySoap();

		soapModel.setVideoUserVideoGroupID(model.getVideoUserVideoGroupID());
		soapModel.setVideoUserId(model.getVideoUserId());
		soapModel.setVideoGroupId(model.getVideoGroupId());

		return soapModel;
	}

	public static VideoUserVideoGroupEntrySoap[] toSoapModels(
		VideoUserVideoGroupEntry[] models) {
		VideoUserVideoGroupEntrySoap[] soapModels = new VideoUserVideoGroupEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoUserVideoGroupEntrySoap[][] toSoapModels(
		VideoUserVideoGroupEntry[][] models) {
		VideoUserVideoGroupEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoUserVideoGroupEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoUserVideoGroupEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoUserVideoGroupEntrySoap[] toSoapModels(
		List<VideoUserVideoGroupEntry> models) {
		List<VideoUserVideoGroupEntrySoap> soapModels = new ArrayList<VideoUserVideoGroupEntrySoap>(models.size());

		for (VideoUserVideoGroupEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoUserVideoGroupEntrySoap[soapModels.size()]);
	}

	public VideoUserVideoGroupEntrySoap() {
	}

	public long getPrimaryKey() {
		return _videoUserVideoGroupID;
	}

	public void setPrimaryKey(long pk) {
		setVideoUserVideoGroupID(pk);
	}

	public long getVideoUserVideoGroupID() {
		return _videoUserVideoGroupID;
	}

	public void setVideoUserVideoGroupID(long videoUserVideoGroupID) {
		_videoUserVideoGroupID = videoUserVideoGroupID;
	}

	public long getVideoUserId() {
		return _videoUserId;
	}

	public void setVideoUserId(long videoUserId) {
		_videoUserId = videoUserId;
	}

	public long getVideoGroupId() {
		return _videoGroupId;
	}

	public void setVideoGroupId(long videoGroupId) {
		_videoGroupId = videoGroupId;
	}

	private long _videoUserVideoGroupID;
	private long _videoUserId;
	private long _videoGroupId;
}