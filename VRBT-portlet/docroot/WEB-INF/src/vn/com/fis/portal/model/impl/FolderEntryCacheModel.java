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

package vn.com.fis.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.fis.portal.model.FolderEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing FolderEntry in entity cache.
 *
 * @author loind
 * @see FolderEntry
 * @generated
 */
public class FolderEntryCacheModel implements CacheModel<FolderEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{folderId=");
		sb.append(folderId);
		sb.append(", folderName=");
		sb.append(folderName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", folderIdParent=");
		sb.append(folderIdParent);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public FolderEntry toEntityModel() {
		FolderEntryImpl folderEntryImpl = new FolderEntryImpl();

		folderEntryImpl.setFolderId(folderId);

		if (folderName == null) {
			folderEntryImpl.setFolderName(StringPool.BLANK);
		}
		else {
			folderEntryImpl.setFolderName(folderName);
		}

		if (description == null) {
			folderEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			folderEntryImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			folderEntryImpl.setCreateDate(null);
		}
		else {
			folderEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			folderEntryImpl.setModifiedDate(null);
		}
		else {
			folderEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		folderEntryImpl.setFolderIdParent(folderIdParent);
		folderEntryImpl.setUserId(userId);

		folderEntryImpl.resetOriginalValues();

		return folderEntryImpl;
	}

	public long folderId;
	public String folderName;
	public String description;
	public long createDate;
	public long modifiedDate;
	public long folderIdParent;
	public long userId;
}