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
 * This class is a wrapper for {@link ContactGroupEntry}.
 * </p>
 *
 * @author    loind
 * @see       ContactGroupEntry
 * @generated
 */
public class ContactGroupEntryWrapper implements ContactGroupEntry,
	ModelWrapper<ContactGroupEntry> {
	public ContactGroupEntryWrapper(ContactGroupEntry contactGroupEntry) {
		_contactGroupEntry = contactGroupEntry;
	}

	public Class<?> getModelClass() {
		return ContactGroupEntry.class;
	}

	public String getModelClassName() {
		return ContactGroupEntry.class.getName();
	}

	/**
	* Returns the primary key of this contact group entry.
	*
	* @return the primary key of this contact group entry
	*/
	public long getPrimaryKey() {
		return _contactGroupEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact group entry.
	*
	* @param primaryKey the primary key of this contact group entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactGroupEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact group ID of this contact group entry.
	*
	* @return the contact group ID of this contact group entry
	*/
	public long getContactGroupId() {
		return _contactGroupEntry.getContactGroupId();
	}

	/**
	* Sets the contact group ID of this contact group entry.
	*
	* @param contactGroupId the contact group ID of this contact group entry
	*/
	public void setContactGroupId(long contactGroupId) {
		_contactGroupEntry.setContactGroupId(contactGroupId);
	}

	/**
	* Returns the contact group name of this contact group entry.
	*
	* @return the contact group name of this contact group entry
	*/
	public java.lang.String getContactGroupName() {
		return _contactGroupEntry.getContactGroupName();
	}

	/**
	* Sets the contact group name of this contact group entry.
	*
	* @param contactGroupName the contact group name of this contact group entry
	*/
	public void setContactGroupName(java.lang.String contactGroupName) {
		_contactGroupEntry.setContactGroupName(contactGroupName);
	}

	/**
	* Returns the description of this contact group entry.
	*
	* @return the description of this contact group entry
	*/
	public java.lang.String getDescription() {
		return _contactGroupEntry.getDescription();
	}

	/**
	* Sets the description of this contact group entry.
	*
	* @param description the description of this contact group entry
	*/
	public void setDescription(java.lang.String description) {
		_contactGroupEntry.setDescription(description);
	}

	/**
	* Returns the contact group type of this contact group entry.
	*
	* @return the contact group type of this contact group entry
	*/
	public int getContactGroupType() {
		return _contactGroupEntry.getContactGroupType();
	}

	/**
	* Sets the contact group type of this contact group entry.
	*
	* @param contactGroupType the contact group type of this contact group entry
	*/
	public void setContactGroupType(int contactGroupType) {
		_contactGroupEntry.setContactGroupType(contactGroupType);
	}

	/**
	* Returns the user ID of this contact group entry.
	*
	* @return the user ID of this contact group entry
	*/
	public long getUserId() {
		return _contactGroupEntry.getUserId();
	}

	/**
	* Sets the user ID of this contact group entry.
	*
	* @param userId the user ID of this contact group entry
	*/
	public void setUserId(long userId) {
		_contactGroupEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contact group entry.
	*
	* @return the user uuid of this contact group entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this contact group entry.
	*
	* @param userUuid the user uuid of this contact group entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contactGroupEntry.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _contactGroupEntry.isNew();
	}

	public void setNew(boolean n) {
		_contactGroupEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactGroupEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactGroupEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactGroupEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactGroupEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactGroupEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactGroupEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactGroupEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactGroupEntryWrapper((ContactGroupEntry)_contactGroupEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry) {
		return _contactGroupEntry.compareTo(contactGroupEntry);
	}

	@Override
	public int hashCode() {
		return _contactGroupEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ContactGroupEntry> toCacheModel() {
		return _contactGroupEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ContactGroupEntry toEscapedModel() {
		return new ContactGroupEntryWrapper(_contactGroupEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactGroupEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _contactGroupEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactGroupEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactGroupEntry getWrappedContactGroupEntry() {
		return _contactGroupEntry;
	}

	public ContactGroupEntry getWrappedModel() {
		return _contactGroupEntry;
	}

	public void resetOriginalValues() {
		_contactGroupEntry.resetOriginalValues();
	}

	private ContactGroupEntry _contactGroupEntry;
}