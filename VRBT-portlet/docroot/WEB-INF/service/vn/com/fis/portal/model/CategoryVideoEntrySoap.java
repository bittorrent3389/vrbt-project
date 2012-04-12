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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.CategoryVideoEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.CategoryVideoEntryServiceSoap
 * @generated
 */
public class CategoryVideoEntrySoap implements Serializable {
	public static CategoryVideoEntrySoap toSoapModel(CategoryVideoEntry model) {
		CategoryVideoEntrySoap soapModel = new CategoryVideoEntrySoap();

		soapModel.setCategoryViceoId(model.getCategoryViceoId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setVideoId(model.getVideoId());

		return soapModel;
	}

	public static CategoryVideoEntrySoap[] toSoapModels(
		CategoryVideoEntry[] models) {
		CategoryVideoEntrySoap[] soapModels = new CategoryVideoEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoryVideoEntrySoap[][] toSoapModels(
		CategoryVideoEntry[][] models) {
		CategoryVideoEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategoryVideoEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoryVideoEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoryVideoEntrySoap[] toSoapModels(
		List<CategoryVideoEntry> models) {
		List<CategoryVideoEntrySoap> soapModels = new ArrayList<CategoryVideoEntrySoap>(models.size());

		for (CategoryVideoEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoryVideoEntrySoap[soapModels.size()]);
	}

	public CategoryVideoEntrySoap() {
	}

	public long getPrimaryKey() {
		return _categoryViceoId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryViceoId(pk);
	}

	public long getCategoryViceoId() {
		return _categoryViceoId;
	}

	public void setCategoryViceoId(long categoryViceoId) {
		_categoryViceoId = categoryViceoId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	private long _categoryViceoId;
	private long _categoryId;
	private long _videoId;
}