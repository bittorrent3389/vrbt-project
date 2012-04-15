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

import vn.com.fis.portal.service.FolderEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author loind
 */
public class FolderEntryClp extends BaseModelImpl<FolderEntry>
	implements FolderEntry {
	public FolderEntryClp() {
	}

	public Class<?> getModelClass() {
		return FolderEntry.class;
	}

	public String getModelClassName() {
		return FolderEntry.class.getName();
	}

	public long getPrimaryKey() {
		return _folderId;
	}

	public void setPrimaryKey(long primaryKey) {
		setFolderId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_folderId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getFolderName() {
		return _folderName;
	}

	public void setFolderName(String folderName) {
		_folderName = folderName;
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

	public long getFolderIdParent() {
		return _folderIdParent;
	}

	public void setFolderIdParent(long folderIdParent) {
		_folderIdParent = folderIdParent;
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
			FolderEntryLocalServiceUtil.addFolderEntry(this);
		}
		else {
			FolderEntryLocalServiceUtil.updateFolderEntry(this);
		}
	}

	@Override
	public FolderEntry toEscapedModel() {
		return (FolderEntry)Proxy.newProxyInstance(FolderEntry.class.getClassLoader(),
			new Class[] { FolderEntry.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FolderEntryClp clone = new FolderEntryClp();

		clone.setFolderId(getFolderId());
		clone.setFolderName(getFolderName());
		clone.setDescription(getDescription());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFolderIdParent(getFolderIdParent());
		clone.setUserId(getUserId());

		return clone;
	}

	public int compareTo(FolderEntry folderEntry) {
		int value = 0;

		value = getFolderName().compareTo(folderEntry.getFolderName());

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

		FolderEntryClp folderEntry = null;

		try {
			folderEntry = (FolderEntryClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = folderEntry.getPrimaryKey();

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

		sb.append("{folderId=");
		sb.append(getFolderId());
		sb.append(", folderName=");
		sb.append(getFolderName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", folderIdParent=");
		sb.append(getFolderIdParent());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.FolderEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderName</column-name><column-value><![CDATA[");
		sb.append(getFolderName());
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
			"<column><column-name>folderIdParent</column-name><column-value><![CDATA[");
		sb.append(getFolderIdParent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _folderId;
	private String _folderName;
	private String _description;
	private Date _createDate;
	private Date _modifiedDate;
	private long _folderIdParent;
	private long _userId;
	private String _userUuid;
}