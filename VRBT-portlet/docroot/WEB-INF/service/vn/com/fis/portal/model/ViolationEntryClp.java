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

import vn.com.fis.portal.service.ViolationEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class ViolationEntryClp extends BaseModelImpl<ViolationEntry>
	implements ViolationEntry {
	public ViolationEntryClp() {
	}

	public Class<?> getModelClass() {
		return ViolationEntry.class;
	}

	public String getModelClassName() {
		return ViolationEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _violationId;
	}

	public void setPrimaryKey(long primaryKey) {
		setViolationId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_violationId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getViolationId() {
		return _violationId;
	}

	public void setViolationId(long violationId) {
		_violationId = violationId;
	}

	public String getViolationTitle() {
		return _violationTitle;
	}

	public void setViolationTitle(String violationTitle) {
		_violationTitle = violationTitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ViolationEntryLocalServiceUtil.addViolationEntry(this);
		}
		else {
			ViolationEntryLocalServiceUtil.updateViolationEntry(this);
		}
	}

	@Override
	public ViolationEntry toEscapedModel() {
		return (ViolationEntry)Proxy.newProxyInstance(ViolationEntry.class.getClassLoader(),
			new Class[] { ViolationEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ViolationEntryClp clone = new ViolationEntryClp();

		clone.setViolationId(getViolationId());
		clone.setViolationTitle(getViolationTitle());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ViolationEntry violationEntry) {
		int value = 0;

		value = getViolationTitle().compareTo(violationEntry.getViolationTitle());

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

		ViolationEntryClp violationEntry = null;

		try {
			violationEntry = (ViolationEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = violationEntry.getPrimaryKey();

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

		sb.append("{violationId=");
		sb.append(getViolationId());
		sb.append(", violationTitle=");
		sb.append(getViolationTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ViolationEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>violationId</column-name><column-value><![CDATA[");
		sb.append(getViolationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>violationTitle</column-name><column-value><![CDATA[");
		sb.append(getViolationTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _violationId;
	private String _violationTitle;
	private String _description;
	private int _status;
}