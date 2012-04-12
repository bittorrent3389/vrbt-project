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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.VideoGroupEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.VideoGroupEntryServiceSoap
 * @generated
 */
public class VideoGroupEntrySoap implements Serializable {
	public static VideoGroupEntrySoap toSoapModel(VideoGroupEntry model) {
		VideoGroupEntrySoap soapModel = new VideoGroupEntrySoap();

		soapModel.setVideoGroupId(model.getVideoGroupId());
		soapModel.setVideoGroupName(model.getVideoGroupName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static VideoGroupEntrySoap[] toSoapModels(VideoGroupEntry[] models) {
		VideoGroupEntrySoap[] soapModels = new VideoGroupEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoGroupEntrySoap[][] toSoapModels(
		VideoGroupEntry[][] models) {
		VideoGroupEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoGroupEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoGroupEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoGroupEntrySoap[] toSoapModels(
		List<VideoGroupEntry> models) {
		List<VideoGroupEntrySoap> soapModels = new ArrayList<VideoGroupEntrySoap>(models.size());

		for (VideoGroupEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoGroupEntrySoap[soapModels.size()]);
	}

	public VideoGroupEntrySoap() {
	}

	public long getPrimaryKey() {
		return _videoGroupId;
	}

	public void setPrimaryKey(long pk) {
		setVideoGroupId(pk);
	}

	public long getVideoGroupId() {
		return _videoGroupId;
	}

	public void setVideoGroupId(long videoGroupId) {
		_videoGroupId = videoGroupId;
	}

	public String getVideoGroupName() {
		return _videoGroupName;
	}

	public void setVideoGroupName(String videoGroupName) {
		_videoGroupName = videoGroupName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _videoGroupId;
	private String _videoGroupName;
	private String _description;
}