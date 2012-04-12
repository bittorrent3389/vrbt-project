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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ServicePackageEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ServicePackageEntryServiceSoap
 * @generated
 */
public class ServicePackageEntrySoap implements Serializable {
	public static ServicePackageEntrySoap toSoapModel(ServicePackageEntry model) {
		ServicePackageEntrySoap soapModel = new ServicePackageEntrySoap();

		soapModel.setServicePackageId(model.getServicePackageId());
		soapModel.setServicePackageName(model.getServicePackageName());
		soapModel.setServicePackageCode(model.getServicePackageCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setTotalFile(model.getTotalFile());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceId(model.getServiceId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ServicePackageEntrySoap[] toSoapModels(
		ServicePackageEntry[] models) {
		ServicePackageEntrySoap[] soapModels = new ServicePackageEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServicePackageEntrySoap[][] toSoapModels(
		ServicePackageEntry[][] models) {
		ServicePackageEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServicePackageEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServicePackageEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServicePackageEntrySoap[] toSoapModels(
		List<ServicePackageEntry> models) {
		List<ServicePackageEntrySoap> soapModels = new ArrayList<ServicePackageEntrySoap>(models.size());

		for (ServicePackageEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServicePackageEntrySoap[soapModels.size()]);
	}

	public ServicePackageEntrySoap() {
	}

	public long getPrimaryKey() {
		return _servicePackageId;
	}

	public void setPrimaryKey(long pk) {
		setServicePackageId(pk);
	}

	public long getServicePackageId() {
		return _servicePackageId;
	}

	public void setServicePackageId(long servicePackageId) {
		_servicePackageId = servicePackageId;
	}

	public String getServicePackageName() {
		return _servicePackageName;
	}

	public void setServicePackageName(String servicePackageName) {
		_servicePackageName = servicePackageName;
	}

	public String getServicePackageCode() {
		return _servicePackageCode;
	}

	public void setServicePackageCode(String servicePackageCode) {
		_servicePackageCode = servicePackageCode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getTotalFile() {
		return _totalFile;
	}

	public void setTotalFile(int totalFile) {
		_totalFile = totalFile;
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

	public long getServiceId() {
		return _serviceId;
	}

	public void setServiceId(long serviceId) {
		_serviceId = serviceId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _servicePackageId;
	private String _servicePackageName;
	private String _servicePackageCode;
	private String _description;
	private int _totalFile;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceId;
	private int _status;
}