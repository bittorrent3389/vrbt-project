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

import vn.com.fis.portal.service.ContactGroupContactEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class ContactGroupContactEntryClp extends BaseModelImpl<ContactGroupContactEntry>
	implements ContactGroupContactEntry {
	public ContactGroupContactEntryClp() {
	}

	public Class<?> getModelClass() {
		return ContactGroupContactEntry.class;
	}

	public String getModelClassName() {
		return ContactGroupContactEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _contactGroupContactId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactGroupContactId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactGroupContactId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getContactGroupContactId() {
		return _contactGroupContactId;
	}

	public void setContactGroupContactId(long contactGroupContactId) {
		_contactGroupContactId = contactGroupContactId;
	}

	public String getContactId() {
		return _contactId;
	}

	public void setContactId(String contactId) {
		_contactId = contactId;
	}

	public String getContactGroupId() {
		return _contactGroupId;
	}

	public void setContactGroupId(String contactGroupId) {
		_contactGroupId = contactGroupId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactGroupContactEntryLocalServiceUtil.addContactGroupContactEntry(this);
		}
		else {
			ContactGroupContactEntryLocalServiceUtil.updateContactGroupContactEntry(this);
		}
	}

	@Override
	public ContactGroupContactEntry toEscapedModel() {
		return (ContactGroupContactEntry)Proxy.newProxyInstance(ContactGroupContactEntry.class.getClassLoader(),
			new Class[] { ContactGroupContactEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactGroupContactEntryClp clone = new ContactGroupContactEntryClp();

		clone.setContactGroupContactId(getContactGroupContactId());
		clone.setContactId(getContactId());
		clone.setContactGroupId(getContactGroupId());

		return clone;
	}

	public int compareTo(ContactGroupContactEntry contactGroupContactEntry) {
		int value = 0;

		value = getContactId().compareTo(contactGroupContactEntry.getContactId());

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

		ContactGroupContactEntryClp contactGroupContactEntry = null;

		try {
			contactGroupContactEntry = (ContactGroupContactEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contactGroupContactEntry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{contactGroupContactId=");
		sb.append(getContactGroupContactId());
		sb.append(", contactId=");
		sb.append(getContactId());
		sb.append(", contactGroupId=");
		sb.append(getContactGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ContactGroupContactEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactGroupContactId</column-name><column-value><![CDATA[");
		sb.append(getContactGroupContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactId</column-name><column-value><![CDATA[");
		sb.append(getContactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactGroupId</column-name><column-value><![CDATA[");
		sb.append(getContactGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactGroupContactId;
	private String _contactId;
	private String _contactGroupId;
}