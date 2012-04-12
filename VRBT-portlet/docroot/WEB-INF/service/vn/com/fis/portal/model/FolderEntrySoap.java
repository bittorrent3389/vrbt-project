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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.FolderEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.FolderEntryServiceSoap
 * @generated
 */
public class FolderEntrySoap implements Serializable {
	public static FolderEntrySoap toSoapModel(FolderEntry model) {
		FolderEntrySoap soapModel = new FolderEntrySoap();

		soapModel.setFolderId(model.getFolderId());
		soapModel.setFolderName(model.getFolderName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFolderIdParent(model.getFolderIdParent());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static FolderEntrySoap[] toSoapModels(FolderEntry[] models) {
		FolderEntrySoap[] soapModels = new FolderEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FolderEntrySoap[][] toSoapModels(FolderEntry[][] models) {
		FolderEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FolderEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FolderEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FolderEntrySoap[] toSoapModels(List<FolderEntry> models) {
		List<FolderEntrySoap> soapModels = new ArrayList<FolderEntrySoap>(models.size());

		for (FolderEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FolderEntrySoap[soapModels.size()]);
	}

	public FolderEntrySoap() {
	}

	public long getPrimaryKey() {
		return _folderId;
	}

	public void setPrimaryKey(long pk) {
		setFolderId(pk);
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getFolderName() {
		return _folderName;
	}

	public void setFolderName(String folderName) {
		_folderName = folderName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getFolderIdParent() {
		return _folderIdParent;
	}

	public void setFolderIdParent(long folderIdParent) {
		_folderIdParent = folderIdParent;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _folderId;
	private String _folderName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private long _folderIdParent;
	private long _userId;
}