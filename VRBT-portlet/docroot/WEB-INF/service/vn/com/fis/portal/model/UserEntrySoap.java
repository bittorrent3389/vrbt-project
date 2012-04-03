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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.UserEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.UserEntryServiceSoap
 * @generated
 */
public class UserEntrySoap implements Serializable {
	public static UserEntrySoap toSoapModel(UserEntry model) {
		UserEntrySoap soapModel = new UserEntrySoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setMobileNumber(model.getMobileNumber());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static UserEntrySoap[] toSoapModels(UserEntry[] models) {
		UserEntrySoap[] soapModels = new UserEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserEntrySoap[][] toSoapModels(UserEntry[][] models) {
		UserEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserEntrySoap[] toSoapModels(List<UserEntry> models) {
		List<UserEntrySoap> soapModels = new ArrayList<UserEntrySoap>(models.size());

		for (UserEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserEntrySoap[soapModels.size()]);
	}

	public UserEntrySoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _userId;
	private String _userName;
	private String _mobileNumber;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
}