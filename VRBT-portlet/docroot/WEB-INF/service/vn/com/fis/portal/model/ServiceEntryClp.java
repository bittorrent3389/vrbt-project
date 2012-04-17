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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import vn.com.fis.portal.service.ServiceEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class ServiceEntryClp extends BaseModelImpl<ServiceEntry>
	implements ServiceEntry {
	public ServiceEntryClp() {
	}

	public Class<?> getModelClass() {
		return ServiceEntry.class;
	}

	public String getModelClassName() {
		return ServiceEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _serviceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setServiceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_serviceId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceEntryLocalServiceUtil.addServiceEntry(this);
		}
		else {
			ServiceEntryLocalServiceUtil.updateServiceEntry(this);
		}
	}

	@Override
	public ServiceEntry toEscapedModel() {
		return (ServiceEntry)Proxy.newProxyInstance(ServiceEntry.class.getClassLoader(),
			new Class[] { ServiceEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceEntryClp clone = new ServiceEntryClp();

		clone.setServiceId(getServiceId());
		clone.setServiceCode(getServiceCode());
		clone.setServiceName(getServiceName());
		clone.setDescription(getDescription());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ServiceEntry serviceEntry) {
		int value = 0;

		value = getServiceName().compareTo(serviceEntry.getServiceName());

		if (value != 0) {
			return value;
		}

		value = getServiceCode().compareTo(serviceEntry.getServiceCode());

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

		ServiceEntryClp serviceEntry = null;

		try {
			serviceEntry = (ServiceEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = serviceEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{serviceId=");
		sb.append(getServiceId());
		sb.append(", serviceCode=");
		sb.append(getServiceCode());
		sb.append(", serviceName=");
		sb.append(getServiceName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ServiceEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serviceId</column-name><column-value><![CDATA[");
		sb.append(getServiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceCode</column-name><column-value><![CDATA[");
		sb.append(getServiceCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceName</column-name><column-value><![CDATA[");
		sb.append(getServiceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _serviceId;
	private String _serviceCode;
	private String _serviceName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
}