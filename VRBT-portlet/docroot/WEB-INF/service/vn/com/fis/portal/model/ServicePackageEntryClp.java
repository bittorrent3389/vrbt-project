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

import vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class ServicePackageEntryClp extends BaseModelImpl<ServicePackageEntry>
	implements ServicePackageEntry {
	public ServicePackageEntryClp() {
	}

	public Class<?> getModelClass() {
		return ServicePackageEntry.class;
	}

	public String getModelClassName() {
		return ServicePackageEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _servicePackageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setServicePackageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_servicePackageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ServicePackageEntryLocalServiceUtil.addServicePackageEntry(this);
		}
		else {
			ServicePackageEntryLocalServiceUtil.updateServicePackageEntry(this);
		}
	}

	@Override
	public ServicePackageEntry toEscapedModel() {
		return (ServicePackageEntry)Proxy.newProxyInstance(ServicePackageEntry.class.getClassLoader(),
			new Class[] { ServicePackageEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServicePackageEntryClp clone = new ServicePackageEntryClp();

		clone.setServicePackageId(getServicePackageId());
		clone.setServicePackageName(getServicePackageName());
		clone.setServicePackageCode(getServicePackageCode());
		clone.setDescription(getDescription());
		clone.setTotalFile(getTotalFile());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setServiceId(getServiceId());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ServicePackageEntry servicePackageEntry) {
		int value = 0;

		value = getServicePackageName()
					.compareTo(servicePackageEntry.getServicePackageName());

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

		ServicePackageEntryClp servicePackageEntry = null;

		try {
			servicePackageEntry = (ServicePackageEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = servicePackageEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{servicePackageId=");
		sb.append(getServicePackageId());
		sb.append(", servicePackageName=");
		sb.append(getServicePackageName());
		sb.append(", servicePackageCode=");
		sb.append(getServicePackageCode());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", totalFile=");
		sb.append(getTotalFile());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", serviceId=");
		sb.append(getServiceId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ServicePackageEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>servicePackageId</column-name><column-value><![CDATA[");
		sb.append(getServicePackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>servicePackageName</column-name><column-value><![CDATA[");
		sb.append(getServicePackageName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>servicePackageCode</column-name><column-value><![CDATA[");
		sb.append(getServicePackageCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalFile</column-name><column-value><![CDATA[");
		sb.append(getTotalFile());
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
			"<column><column-name>serviceId</column-name><column-value><![CDATA[");
		sb.append(getServiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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