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

import vn.com.fis.portal.service.CategoryVideoEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author loind
 */
public class CategoryVideoEntryClp extends BaseModelImpl<CategoryVideoEntry>
	implements CategoryVideoEntry {
	public CategoryVideoEntryClp() {
	}

	public Class<?> getModelClass() {
		return CategoryVideoEntry.class;
	}

	public String getModelClassName() {
		return CategoryVideoEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _categoryViceoId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoryViceoId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoryViceoId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getCategoryViceoId() {
		return _categoryViceoId;
	}

	public void setCategoryViceoId(long categoryViceoId) {
		_categoryViceoId = categoryViceoId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getVideoId() {
		return _videoId;
	}

	public void setVideoId(long videoId) {
		_videoId = videoId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CategoryVideoEntryLocalServiceUtil.addCategoryVideoEntry(this);
		}
		else {
			CategoryVideoEntryLocalServiceUtil.updateCategoryVideoEntry(this);
		}
	}

	@Override
	public CategoryVideoEntry toEscapedModel() {
		return (CategoryVideoEntry)Proxy.newProxyInstance(CategoryVideoEntry.class.getClassLoader(),
			new Class[] { CategoryVideoEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CategoryVideoEntryClp clone = new CategoryVideoEntryClp();

		clone.setCategoryViceoId(getCategoryViceoId());
		clone.setCategoryId(getCategoryId());
		clone.setVideoId(getVideoId());

		return clone;
	}

	public int compareTo(CategoryVideoEntry categoryVideoEntry) {
		int value = 0;

		if (getCategoryViceoId() < categoryVideoEntry.getCategoryViceoId()) {
			value = -1;
		}
		else if (getCategoryViceoId() > categoryVideoEntry.getCategoryViceoId()) {
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

		CategoryVideoEntryClp categoryVideoEntry = null;

		try {
			categoryVideoEntry = (CategoryVideoEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = categoryVideoEntry.getPrimaryKey();

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

		sb.append("{categoryViceoId=");
		sb.append(getCategoryViceoId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.CategoryVideoEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryViceoId</column-name><column-value><![CDATA[");
		sb.append(getCategoryViceoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoryViceoId;
	private long _categoryId;
	private long _videoId;
}