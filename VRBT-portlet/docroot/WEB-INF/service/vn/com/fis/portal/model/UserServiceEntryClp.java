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
import com.liferay.portal.util.PortalUtil;

import vn.com.fis.portal.service.UserServiceEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class UserServiceEntryClp extends BaseModelImpl<UserServiceEntry>
	implements UserServiceEntry {
	public UserServiceEntryClp() {
	}

	public Class<?> getModelClass() {
		return UserServiceEntry.class;
	}

	public String getModelClassName() {
		return UserServiceEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _userServiceId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserServiceId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userServiceId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getUserServiceId() {
		return _userServiceId;
	}

	public void setUserServiceId(long userServiceId) {
		_userServiceId = userServiceId;
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
			UserServiceEntryLocalServiceUtil.addUserServiceEntry(this);
		}
		else {
			UserServiceEntryLocalServiceUtil.updateUserServiceEntry(this);
		}
	}

	@Override
	public UserServiceEntry toEscapedModel() {
		return (UserServiceEntry)Proxy.newProxyInstance(UserServiceEntry.class.getClassLoader(),
			new Class[] { UserServiceEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserServiceEntryClp clone = new UserServiceEntryClp();

		clone.setUserServiceId(getUserServiceId());
		clone.setUserId(getUserId());
		clone.setServiceId(getServiceId());
		clone.setServiceStatus(getServiceStatus());
		clone.setServiceStartDate(getServiceStartDate());
		clone.setServiceStopDate(getServiceStopDate());
		clone.setServicePackageId(getServicePackageId());
		clone.setPackageDate(getPackageDate());

		return clone;
	}

	public int compareTo(UserServiceEntry userServiceEntry) {
		int value = 0;

		if (getServiceId() < userServiceEntry.getServiceId()) {
			value = -1;
		}
		else if (getServiceId() > userServiceEntry.getServiceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		UserServiceEntryClp userServiceEntry = null;

		try {
			userServiceEntry = (UserServiceEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = userServiceEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{userServiceId=");
		sb.append(getUserServiceId());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.UserServiceEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userServiceId</column-name><column-value><![CDATA[");
		sb.append(getUserServiceId());
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

	private long _userServiceId;
	private long _userId;
	private String _userUuid;
	private long _serviceId;
	private int _serviceStatus;
	private Date _serviceStartDate;
	private Date _serviceStopDate;
	private long _servicePackageId;
	private Date _packageDate;
}