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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.VideoEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.VideoEntryServiceSoap
 * @generated
 */
public class VideoEntrySoap implements Serializable {
	public static VideoEntrySoap toSoapModel(VideoEntry model) {
		VideoEntrySoap soapModel = new VideoEntrySoap();

		soapModel.setVideoId(model.getVideoId());
		soapModel.setVideoName(model.getVideoName());
		soapModel.setVideoUrl(model.getVideoUrl());
		soapModel.setDescription(model.getDescription());
		soapModel.setViewCount(model.getViewCount());
		soapModel.setDate_(model.getDate_());
		soapModel.setSmallImageUrl(model.getSmallImageUrl());
		soapModel.setLargeImageUrl(model.getLargeImageUrl());
		soapModel.setAccessModifier(model.getAccessModifier());
		soapModel.setUploaderId(model.getUploaderId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VideoEntrySoap[] toSoapModels(VideoEntry[] models) {
		VideoEntrySoap[] soapModels = new VideoEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoEntrySoap[][] toSoapModels(VideoEntry[][] models) {
		VideoEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoEntrySoap[] toSoapModels(List<VideoEntry> models) {
		List<VideoEntrySoap> soapModels = new ArrayList<VideoEntrySoap>(models.size());

		for (VideoEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoEntrySoap[soapModels.size()]);
	}

	public VideoEntrySoap() {
	}

	public long getPrimaryKey() {
		return _videoId;
	}

	public void setPrimaryKey(long pk) {
		setVideoId(pk);
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public String getVideoName() {
		return _videoName;
	}

	public void setVideoName(String videoName) {
		_videoName = videoName;
	}

	public String getVideoUrl() {
		return _videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getViewCount() {
		return _viewCount;
	}

	public void setViewCount(long viewCount) {
		_viewCount = viewCount;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	public String getSmallImageUrl() {
		return _smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		_smallImageUrl = smallImageUrl;
	}

	public String getLargeImageUrl() {
		return _largeImageUrl;
	}

	public void setLargeImageUrl(String largeImageUrl) {
		_largeImageUrl = largeImageUrl;
	}

	public int getAccessModifier() {
		return _accessModifier;
	}

	public void setAccessModifier(int accessModifier) {
		_accessModifier = accessModifier;
	}

	public long getUploaderId() {
		return _uploaderId;
	}

	public void setUploaderId(long uploaderId) {
		_uploaderId = uploaderId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _videoId;
	private String _videoName;
	private String _videoUrl;
	private String _description;
	private long _viewCount;
	private Date _date_;
	private String _smallImageUrl;
	private String _largeImageUrl;
	private int _accessModifier;
	private long _uploaderId;
	private long _folderId;
	private int _status;
}