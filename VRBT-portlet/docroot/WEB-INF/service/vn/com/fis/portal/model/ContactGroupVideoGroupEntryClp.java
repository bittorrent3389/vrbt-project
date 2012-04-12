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

import vn.com.fis.portal.service.ContactGroupVideoGroupEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class ContactGroupVideoGroupEntryClp extends BaseModelImpl<ContactGroupVideoGroupEntry>
	implements ContactGroupVideoGroupEntry {
	public ContactGroupVideoGroupEntryClp() {
	}

	public Class<?> getModelClass() {
		return ContactGroupVideoGroupEntry.class;
	}

	public String getModelClassName() {
		return ContactGroupVideoGroupEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _contactGroupVideoGroupEntryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setContactGroupVideoGroupEntryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_contactGroupVideoGroupEntryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getContactGroupVideoGroupEntryId() {
		return _contactGroupVideoGroupEntryId;
	}

	public void setContactGroupVideoGroupEntryId(
		long contactGroupVideoGroupEntryId) {
		_contactGroupVideoGroupEntryId = contactGroupVideoGroupEntryId;
	}

	public long getContactGroupId() {
		return _contactGroupId;
	}

	public void setContactGroupId(long contactGroupId) {
		_contactGroupId = contactGroupId;
	}

	public long getVideoGroupId() {
		return _videoGroupId;
	}

	public void setVideoGroupId(long videoGroupId) {
		_videoGroupId = videoGroupId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ContactGroupVideoGroupEntryLocalServiceUtil.addContactGroupVideoGroupEntry(this);
		}
		else {
			ContactGroupVideoGroupEntryLocalServiceUtil.updateContactGroupVideoGroupEntry(this);
		}
	}

	@Override
	public ContactGroupVideoGroupEntry toEscapedModel() {
		return (ContactGroupVideoGroupEntry)Proxy.newProxyInstance(ContactGroupVideoGroupEntry.class.getClassLoader(),
			new Class[] { ContactGroupVideoGroupEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ContactGroupVideoGroupEntryClp clone = new ContactGroupVideoGroupEntryClp();

		clone.setContactGroupVideoGroupEntryId(getContactGroupVideoGroupEntryId());
		clone.setContactGroupId(getContactGroupId());
		clone.setVideoGroupId(getVideoGroupId());

		return clone;
	}

	public int compareTo(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		long primaryKey = contactGroupVideoGroupEntry.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ContactGroupVideoGroupEntryClp contactGroupVideoGroupEntry = null;

		try {
			contactGroupVideoGroupEntry = (ContactGroupVideoGroupEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = contactGroupVideoGroupEntry.getPrimaryKey();

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

		sb.append("{contactGroupVideoGroupEntryId=");
		sb.append(getContactGroupVideoGroupEntryId());
		sb.append(", contactGroupId=");
		sb.append(getContactGroupId());
		sb.append(", videoGroupId=");
		sb.append(getVideoGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ContactGroupVideoGroupEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contactGroupVideoGroupEntryId</column-name><column-value><![CDATA[");
		sb.append(getContactGroupVideoGroupEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactGroupId</column-name><column-value><![CDATA[");
		sb.append(getContactGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoGroupId</column-name><column-value><![CDATA[");
		sb.append(getVideoGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contactGroupVideoGroupEntryId;
	private long _contactGroupId;
	private long _videoGroupId;
}