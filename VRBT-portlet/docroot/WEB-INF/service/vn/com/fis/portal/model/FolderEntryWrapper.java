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

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link FolderEntry}.
 * </p>
 *
 * @author    loind
 * @see       FolderEntry
 * @generated
 */
public class FolderEntryWrapper implements FolderEntry,
	ModelWrapper<FolderEntry> {
	public FolderEntryWrapper(FolderEntry folderEntry) {
		_folderEntry = folderEntry;
	}

	public Class<?> getModelClass() {
		return FolderEntry.class;
	}

	public String getModelClassName() {
		return FolderEntry.class.getName();
	}

	/**
	* Returns the primary key of this folder entry.
	*
	* @return the primary key of this folder entry
	*/
	public long getPrimaryKey() {
		return _folderEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this folder entry.
	*
	* @param primaryKey the primary key of this folder entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_folderEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the folder ID of this folder entry.
	*
	* @return the folder ID of this folder entry
	*/
	public long getFolderId() {
		return _folderEntry.getFolderId();
	}

	/**
	* Sets the folder ID of this folder entry.
	*
	* @param folderId the folder ID of this folder entry
	*/
	public void setFolderId(long folderId) {
		_folderEntry.setFolderId(folderId);
	}

	/**
	* Returns the folder name of this folder entry.
	*
	* @return the folder name of this folder entry
	*/
	public java.lang.String getFolderName() {
		return _folderEntry.getFolderName();
	}

	/**
	* Sets the folder name of this folder entry.
	*
	* @param folderName the folder name of this folder entry
	*/
	public void setFolderName(java.lang.String folderName) {
		_folderEntry.setFolderName(folderName);
	}

	/**
	* Returns the description of this folder entry.
	*
	* @return the description of this folder entry
	*/
	public java.lang.String getDescription() {
		return _folderEntry.getDescription();
	}

	/**
	* Sets the description of this folder entry.
	*
	* @param description the description of this folder entry
	*/
	public void setDescription(java.lang.String description) {
		_folderEntry.setDescription(description);
	}

	/**
	* Returns the create date of this folder entry.
	*
	* @return the create date of this folder entry
	*/
	public java.util.Date getCreateDate() {
		return _folderEntry.getCreateDate();
	}

	/**
	* Sets the create date of this folder entry.
	*
	* @param createDate the create date of this folder entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_folderEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this folder entry.
	*
	* @return the modified date of this folder entry
	*/
	public java.util.Date getModifiedDate() {
		return _folderEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this folder entry.
	*
	* @param modifiedDate the modified date of this folder entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_folderEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the folder ID parent of this folder entry.
	*
	* @return the folder ID parent of this folder entry
	*/
	public long getFolderIdParent() {
		return _folderEntry.getFolderIdParent();
	}

	/**
	* Sets the folder ID parent of this folder entry.
	*
	* @param folderIdParent the folder ID parent of this folder entry
	*/
	public void setFolderIdParent(long folderIdParent) {
		_folderEntry.setFolderIdParent(folderIdParent);
	}

	/**
	* Returns the user ID of this folder entry.
	*
	* @return the user ID of this folder entry
	*/
	public long getUserId() {
		return _folderEntry.getUserId();
	}

	/**
	* Sets the user ID of this folder entry.
	*
	* @param userId the user ID of this folder entry
	*/
	public void setUserId(long userId) {
		_folderEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this folder entry.
	*
	* @return the user uuid of this folder entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _folderEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this folder entry.
	*
	* @param userUuid the user uuid of this folder entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_folderEntry.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _folderEntry.isNew();
	}

	public void setNew(boolean n) {
		_folderEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _folderEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_folderEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _folderEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _folderEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_folderEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _folderEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_folderEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FolderEntryWrapper((FolderEntry)_folderEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.FolderEntry folderEntry) {
		return _folderEntry.compareTo(folderEntry);
	}

	@Override
	public int hashCode() {
		return _folderEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.FolderEntry> toCacheModel() {
		return _folderEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.FolderEntry toEscapedModel() {
		return new FolderEntryWrapper(_folderEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _folderEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _folderEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_folderEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FolderEntry getWrappedFolderEntry() {
		return _folderEntry;
	}

	public FolderEntry getWrappedModel() {
		return _folderEntry;
	}

	public void resetOriginalValues() {
		_folderEntry.resetOriginalValues();
	}

	private FolderEntry _folderEntry;
}