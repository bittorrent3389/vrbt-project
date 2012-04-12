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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ServiceEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ServiceEntryServiceSoap
 * @generated
 */
public class ServiceEntrySoap implements Serializable {
	public static ServiceEntrySoap toSoapModel(ServiceEntry model) {
		ServiceEntrySoap soapModel = new ServiceEntrySoap();

		soapModel.setServiceId(model.getServiceId());
		soapModel.setServiceCode(model.getServiceCode());
		soapModel.setServiceName(model.getServiceName());
		soapModel.setDescription(model.getDescription());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ServiceEntrySoap[] toSoapModels(ServiceEntry[] models) {
		ServiceEntrySoap[] soapModels = new ServiceEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceEntrySoap[][] toSoapModels(ServiceEntry[][] models) {
		ServiceEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceEntrySoap[] toSoapModels(List<ServiceEntry> models) {
		List<ServiceEntrySoap> soapModels = new ArrayList<ServiceEntrySoap>(models.size());

		for (ServiceEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceEntrySoap[soapModels.size()]);
	}

	public ServiceEntrySoap() {
	}

	public long getPrimaryKey() {
		return _serviceId;
	}

	public void setPrimaryKey(long pk) {
		setServiceId(pk);
	}

	public long getServiceId() {
		return _serviceId;
	}

	public void setServiceId(long serviceId) {
		_serviceId = serviceId;
	}

	public String getServiceCode() {
		return _serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		_serviceCode = serviceCode;
	}

	public String getServiceName() {
		return _serviceName;
	}

	public void setServiceName(String serviceName) {
		_serviceName = serviceName;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _serviceId;
	private String _serviceCode;
	private String _serviceName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
}