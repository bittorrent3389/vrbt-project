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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.fis.portal.service.ServiceTransactionEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class ServiceTransactionEntryClp extends BaseModelImpl<ServiceTransactionEntry>
	implements ServiceTransactionEntry {
	public ServiceTransactionEntryClp() {
	}

	public Class<?> getModelClass() {
		return ServiceTransactionEntry.class;
	}

	public String getModelClassName() {
		return ServiceTransactionEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTransactionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_transactionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceTransactionEntryLocalServiceUtil.addServiceTransactionEntry(this);
		}
		else {
			ServiceTransactionEntryLocalServiceUtil.updateServiceTransactionEntry(this);
		}
	}

	@Override
	public ServiceTransactionEntry toEscapedModel() {
		return (ServiceTransactionEntry)Proxy.newProxyInstance(ServiceTransactionEntry.class.getClassLoader(),
			new Class[] { ServiceTransactionEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceTransactionEntryClp clone = new ServiceTransactionEntryClp();

		clone.setTransactionId(getTransactionId());
		clone.setTransactionCode(getTransactionCode());
		clone.setDate_(getDate_());
		clone.setUserId(getUserId());
		clone.setServiceId(getServiceId());
		clone.setServiceStatus(getServiceStatus());
		clone.setServiceStartDate(getServiceStartDate());
		clone.setServiceStopDate(getServiceStopDate());
		clone.setServicePackageId(getServicePackageId());
		clone.setPackageDate(getPackageDate());

		return clone;
	}

	public int compareTo(ServiceTransactionEntry serviceTransactionEntry) {
		int value = 0;

		value = DateUtil.compareTo(getDate_(),
				serviceTransactionEntry.getDate_());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ServiceTransactionEntryClp serviceTransactionEntry = null;

		try {
			serviceTransactionEntry = (ServiceTransactionEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = serviceTransactionEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{transactionId=");
		sb.append(getTransactionId());
		sb.append(", transactionCode=");
		sb.append(getTransactionCode());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", serviceId=");
		sb.append(getServiceId());
		sb.append(", serviceStatus=");
		sb.append(getServiceStatus());
		sb.append(", serviceStartDate=");
		sb.append(getServiceStartDate());
		sb.append(", serviceStopDate=");
		sb.append(getServiceStopDate());
		sb.append(", servicePackageId=");
		sb.append(getServicePackageId());
		sb.append(", packageDate=");
		sb.append(getPackageDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ServiceTransactionEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionCode</column-name><column-value><![CDATA[");
		sb.append(getTransactionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceId</column-name><column-value><![CDATA[");
		sb.append(getServiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceStatus</column-name><column-value><![CDATA[");
		sb.append(getServiceStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceStartDate</column-name><column-value><![CDATA[");
		sb.append(getServiceStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceStopDate</column-name><column-value><![CDATA[");
		sb.append(getServiceStopDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>servicePackageId</column-name><column-value><![CDATA[");
		sb.append(getServicePackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packageDate</column-name><column-value><![CDATA[");
		sb.append(getPackageDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _transactionId;
	private int _transactionCode;
	private Date _date_;
	private long _userId;
	private String _userUuid;
	private long _serviceId;
	private int _serviceStatus;
	private Date _serviceStartDate;
	private Date _serviceStopDate;
	private long _servicePackageId;
	private Date _packageDate;
}