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

import vn.com.fis.portal.service.ContactEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class ContactEntryClp extends BaseModelImpl<ContactEntry>
	implements ContactEntry {
	public ContactEntryClp() {
	}

	public Class<?> getModelClass() {
		return ContactEntry.class;
	}

	public String getModelClassName() {
		return ContactEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
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

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactEntryLocalServiceUtil.addContactEntry(this);
		}
		else {
			ContactEntryLocalServiceUtil.updateContactEntry(this);
		}
	}

	@Override
	public ContactEntry toEscapedModel() {
		return (ContactEntry)Proxy.newProxyInstance(ContactEntry.class.getClassLoader(),
			new Class[] { ContactEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactEntryClp clone = new ContactEntryClp();

		clone.setContactId(getContactId());
		clone.setContactName(getContactName());
		clone.setMobileNumber(getMobileNumber());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(ContactEntry contactEntry) {
		int value = 0;

		value = getContactName().compareTo(contactEntry.getContactName());

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

		ContactEntryClp contactEntry = null;

		try {
			contactEntry = (ContactEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contactEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{contactId=");
		sb.append(getContactId());
		sb.append(", contactName=");
		sb.append(getContactName());
		sb.append(", mobileNumber=");
		sb.append(getMobileNumber());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ContactEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactName</column-name><column-value><![CDATA[");
		sb.append(getContactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileNumber</column-name><column-value><![CDATA[");
		sb.append(getMobileNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactId;
	private String _contactName;
	private String _mobileNumber;
	private long _userId;
	private String _userUuid;
}