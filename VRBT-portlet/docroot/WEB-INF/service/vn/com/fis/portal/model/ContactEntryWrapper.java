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
 * This class is a wrapper for {@link ContactEntry}.
 * </p>
 *
 * @author    loind
 * @see       ContactEntry
 * @generated
 */
public class ContactEntryWrapper implements ContactEntry,
	ModelWrapper<ContactEntry> {
	public ContactEntryWrapper(ContactEntry contactEntry) {
		_contactEntry = contactEntry;
	}

	public Class<?> getModelClass() {
		return ContactEntry.class;
	}

	public String getModelClassName() {
		return ContactEntry.class.getName();
	}

	/**
	* Returns the primary key of this contact entry.
	*
	* @return the primary key of this contact entry
	*/
	public long getPrimaryKey() {
		return _contactEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact entry.
	*
	* @param primaryKey the primary key of this contact entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact ID of this contact entry.
	*
	* @return the contact ID of this contact entry
	*/
	public long getContactId() {
		return _contactEntry.getContactId();
	}

	/**
	* Sets the contact ID of this contact entry.
	*
	* @param contactId the contact ID of this contact entry
	*/
	public void setContactId(long contactId) {
		_contactEntry.setContactId(contactId);
	}

	/**
	* Returns the contact name of this contact entry.
	*
	* @return the contact name of this contact entry
	*/
	public java.lang.String getContactName() {
		return _contactEntry.getContactName();
	}

	/**
	* Sets the contact name of this contact entry.
	*
	* @param contactName the contact name of this contact entry
	*/
	public void setContactName(java.lang.String contactName) {
		_contactEntry.setContactName(contactName);
	}

	/**
	* Returns the mobile number of this contact entry.
	*
	* @return the mobile number of this contact entry
	*/
	public java.lang.String getMobileNumber() {
		return _contactEntry.getMobileNumber();
	}

	/**
	* Sets the mobile number of this contact entry.
	*
	* @param mobileNumber the mobile number of this contact entry
	*/
	public void setMobileNumber(java.lang.String mobileNumber) {
		_contactEntry.setMobileNumber(mobileNumber);
	}

	/**
	* Returns the user ID of this contact entry.
	*
	* @return the user ID of this contact entry
	*/
	public long getUserId() {
		return _contactEntry.getUserId();
	}

	/**
	* Sets the user ID of this contact entry.
	*
	* @param userId the user ID of this contact entry
	*/
	public void setUserId(long userId) {
		_contactEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this contact entry.
	*
	* @return the user uuid of this contact entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this contact entry.
	*
	* @param userUuid the user uuid of this contact entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_contactEntry.setUserUuid(userUuid);
	}

	public boolean isNew() {
		return _contactEntry.isNew();
	}

	public void setNew(boolean n) {
		_contactEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactEntryWrapper((ContactEntry)_contactEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.ContactEntry contactEntry) {
		return _contactEntry.compareTo(contactEntry);
	}

	@Override
	public int hashCode() {
		return _contactEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ContactEntry> toCacheModel() {
		return _contactEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ContactEntry toEscapedModel() {
		return new ContactEntryWrapper(_contactEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _contactEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactEntry getWrappedContactEntry() {
		return _contactEntry;
	}

	public ContactEntry getWrappedModel() {
		return _contactEntry;
	}

	public void resetOriginalValues() {
		_contactEntry.resetOriginalValues();
	}

	private ContactEntry _contactEntry;
}