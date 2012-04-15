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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.RatingEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.RatingEntryServiceSoap
 * @generated
 */
public class RatingEntrySoap implements Serializable {
	public static RatingEntrySoap toSoapModel(RatingEntry model) {
		RatingEntrySoap soapModel = new RatingEntrySoap();

		soapModel.setRatingId(model.getRatingId());
		soapModel.setVideoId(model.getVideoId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCode(model.getCode());
		soapModel.setDate_(model.getDate_());

		return soapModel;
	}

	public static RatingEntrySoap[] toSoapModels(RatingEntry[] models) {
		RatingEntrySoap[] soapModels = new RatingEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RatingEntrySoap[][] toSoapModels(RatingEntry[][] models) {
		RatingEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RatingEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new RatingEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RatingEntrySoap[] toSoapModels(List<RatingEntry> models) {
		List<RatingEntrySoap> soapModels = new ArrayList<RatingEntrySoap>(models.size());

		for (RatingEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RatingEntrySoap[soapModels.size()]);
	}

	public RatingEntrySoap() {
	}

	public long getPrimaryKey() {
		return _ratingId;
	}

	public void setPrimaryKey(long pk) {
		setRatingId(pk);
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

	private long _ratingId;
	private long _videoId;
	private long _userId;
	private int _code;
	private Date _date_;
}