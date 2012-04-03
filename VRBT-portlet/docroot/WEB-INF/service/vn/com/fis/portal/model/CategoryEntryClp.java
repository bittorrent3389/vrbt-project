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

import vn.com.fis.portal.service.CategoryEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class CategoryEntryClp extends BaseModelImpl<CategoryEntry>
	implements CategoryEntry {
	public CategoryEntryClp() {
	}

	public Class<?> getModelClass() {
		return CategoryEntry.class;
	}

	public String getModelClassName() {
		return CategoryEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
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
			CategoryEntryLocalServiceUtil.addCategoryEntry(this);
		}
		else {
			CategoryEntryLocalServiceUtil.updateCategoryEntry(this);
		}
	}

	@Override
	public CategoryEntry toEscapedModel() {
		return (CategoryEntry)Proxy.newProxyInstance(CategoryEntry.class.getClassLoader(),
			new Class[] { CategoryEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CategoryEntryClp clone = new CategoryEntryClp();

		clone.setCategoryId(getCategoryId());
		clone.setCategoryName(getCategoryName());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(CategoryEntry categoryEntry) {
		int value = 0;

		value = getCategoryName().compareTo(categoryEntry.getCategoryName());

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

		CategoryEntryClp categoryEntry = null;

		try {
			categoryEntry = (CategoryEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = categoryEntry.getPrimaryKey();

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

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
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
		sb.append("vn.com.fis.portal.model.CategoryEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
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

	private long _categoryId;
	private String _categoryName;
	private String _description;
	private int _status;
}