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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ServiceTransactionEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ServiceTransactionEntryServiceSoap
 * @generated
 */
public class ServiceTransactionEntrySoap implements Serializable {
	public static ServiceTransactionEntrySoap toSoapModel(
		ServiceTransactionEntry model) {
		ServiceTransactionEntrySoap soapModel = new ServiceTransactionEntrySoap();

		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setTransactionCode(model.getTransactionCode());
		soapModel.setDate_(model.getDate_());
		soapModel.setUserId(model.getUserId());
		soapModel.setServiceId(model.getServiceId());
		soapModel.setServiceStatus(model.getServiceStatus());
		soapModel.setServiceStartDate(model.getServiceStartDate());
		soapModel.setServiceStopDate(model.getServiceStopDate());
		soapModel.setServiceEndDate(model.getServiceEndDate());
		soapModel.setServicePackageId(model.getServicePackageId());
		soapModel.setPackageDate(model.getPackageDate());

		return soapModel;
	}

	public static ServiceTransactionEntrySoap[] toSoapModels(
		ServiceTransactionEntry[] models) {
		ServiceTransactionEntrySoap[] soapModels = new ServiceTransactionEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceTransactionEntrySoap[][] toSoapModels(
		ServiceTransactionEntry[][] models) {
		ServiceTransactionEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceTransactionEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceTransactionEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceTransactionEntrySoap[] toSoapModels(
		List<ServiceTransactionEntry> models) {
		List<ServiceTransactionEntrySoap> soapModels = new ArrayList<ServiceTransactionEntrySoap>(models.size());

		for (ServiceTransactionEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceTransactionEntrySoap[soapModels.size()]);
	}

	public ServiceTransactionEntrySoap() {
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long pk) {
		setTransactionId(pk);
	}

	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_transactionId = transactionId;
	}

	public int getTransactionCode() {
		return _transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		_transactionCode = transactionCode;
	}

	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_date_ = date_;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getServiceId() {
		return _serviceId;
	}

	public void setServiceId(long serviceId) {
		_serviceId = serviceId;
	}

	public int getServiceStatus() {
		return _serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		_serviceStatus = serviceStatus;
	}

	public Date getServiceStartDate() {
		return _serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		_serviceStartDate = serviceStartDate;
	}

	public Date getServiceStopDate() {
		return _serviceStopDate;
	}

	public void setServiceStopDate(Date serviceStopDate) {
		_serviceStopDate = serviceStopDate;
	}

	public Date getServiceEndDate() {
		return _serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		_serviceEndDate = serviceEndDate;
	}

	public long getServicePackageId() {
		return _servicePackageId;
	}

	public void setServicePackageId(long servicePackageId) {
		_servicePackageId = servicePackageId;
	}

	public Date getPackageDate() {
		return _packageDate;
	}

	public void setPackageDate(Date packageDate) {
		_packageDate = packageDate;
	}

	private long _transactionId;
	private int _transactionCode;
	private Date _date_;
	private long _userId;
	private long _serviceId;
	private int _serviceStatus;
	private Date _serviceStartDate;
	private Date _serviceStopDate;
	private Date _serviceEndDate;
	private long _servicePackageId;
	private Date _packageDate;
}