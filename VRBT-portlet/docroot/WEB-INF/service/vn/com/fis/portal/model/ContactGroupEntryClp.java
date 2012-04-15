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

import vn.com.fis.portal.service.ContactGroupEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class ContactGroupEntryClp extends BaseModelImpl<ContactGroupEntry>
	implements ContactGroupEntry {
	public ContactGroupEntryClp() {
	}

	public Class<?> getModelClass() {
		return ContactGroupEntry.class;
	}

	public String getModelClassName() {
		return ContactGroupEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _contactGroupId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactGroupId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactGroupId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getContactGroupId() {
		return _contactGroupId;
	}

	public void setContactGroupId(long contactGroupId) {
		_contactGroupId = contactGroupId;
	}

	public String getContactGroupName() {
		return _contactGroupName;
	}

	public void setContactGroupName(String contactGroupName) {
		_contactGroupName = contactGroupName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getContactGroupType() {
		return _contactGroupType;
	}

	public void setContactGroupType(int contactGroupType) {
		_contactGroupType = contactGroupType;
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
			ContactGroupEntryLocalServiceUtil.addContactGroupEntry(this);
		}
		else {
			ContactGroupEntryLocalServiceUtil.updateContactGroupEntry(this);
		}
	}

	@Override
	public ContactGroupEntry toEscapedModel() {
		return (ContactGroupEntry)Proxy.newProxyInstance(ContactGroupEntry.class.getClassLoader(),
			new Class[] { ContactGroupEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactGroupEntryClp clone = new ContactGroupEntryClp();

		clone.setContactGroupId(getContactGroupId());
		clone.setContactGroupName(getContactGroupName());
		clone.setDescription(getDescription());
		clone.setContactGroupType(getContactGroupType());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(ContactGroupEntry contactGroupEntry) {
		int value = 0;

		value = getContactGroupName()
					.compareTo(contactGroupEntry.getContactGroupName());

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

		ContactGroupEntryClp contactGroupEntry = null;

		try {
			contactGroupEntry = (ContactGroupEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contactGroupEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{contactGroupId=");
		sb.append(getContactGroupId());
		sb.append(", contactGroupName=");
		sb.append(getContactGroupName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", contactGroupType=");
		sb.append(getContactGroupType());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ContactGroupEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactGroupId</column-name><column-value><![CDATA[");
		sb.append(getContactGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactGroupName</column-name><column-value><![CDATA[");
		sb.append(getContactGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactGroupType</column-name><column-value><![CDATA[");
		sb.append(getContactGroupType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactGroupId;
	private String _contactGroupName;
	private String _description;
	private int _contactGroupType;
	private long _userId;
	private String _userUuid;
}