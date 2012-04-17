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
 * This class is a wrapper for {@link ContactGroupContactEntry}.
 * </p>
 *
 * @author    loind
 * @see       ContactGroupContactEntry
 * @generated
 */
public class ContactGroupContactEntryWrapper implements ContactGroupContactEntry,
	ModelWrapper<ContactGroupContactEntry> {
	public ContactGroupContactEntryWrapper(
		ContactGroupContactEntry contactGroupContactEntry) {
		_contactGroupContactEntry = contactGroupContactEntry;
	}

	public Class<?> getModelClass() {
		return ContactGroupContactEntry.class;
	}

	public String getModelClassName() {
		return ContactGroupContactEntry.class.getName();
	}

	/**
	* Returns the primary key of this contact group contact entry.
	*
	* @return the primary key of this contact group contact entry
	*/
	public long getPrimaryKey() {
		return _contactGroupContactEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact group contact entry.
	*
	* @param primaryKey the primary key of this contact group contact entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactGroupContactEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact group contact ID of this contact group contact entry.
	*
	* @return the contact group contact ID of this contact group contact entry
	*/
	public long getContactGroupContactId() {
		return _contactGroupContactEntry.getContactGroupContactId();
	}

	/**
	* Sets the contact group contact ID of this contact group contact entry.
	*
	* @param contactGroupContactId the contact group contact ID of this contact group contact entry
	*/
	public void setContactGroupContactId(long contactGroupContactId) {
		_contactGroupContactEntry.setContactGroupContactId(contactGroupContactId);
	}

	/**
	* Returns the contact ID of this contact group contact entry.
	*
	* @return the contact ID of this contact group contact entry
	*/
	public java.lang.String getContactId() {
		return _contactGroupContactEntry.getContactId();
	}

	/**
	* Sets the contact ID of this contact group contact entry.
	*
	* @param contactId the contact ID of this contact group contact entry
	*/
	public void setContactId(java.lang.String contactId) {
		_contactGroupContactEntry.setContactId(contactId);
	}

	/**
	* Returns the contact group ID of this contact group contact entry.
	*
	* @return the contact group ID of this contact group contact entry
	*/
	public java.lang.String getContactGroupId() {
		return _contactGroupContactEntry.getContactGroupId();
	}

	/**
	* Sets the contact group ID of this contact group contact entry.
	*
	* @param contactGroupId the contact group ID of this contact group contact entry
	*/
	public void setContactGroupId(java.lang.String contactGroupId) {
		_contactGroupContactEntry.setContactGroupId(contactGroupId);
	}

	public boolean isNew() {
		return _contactGroupContactEntry.isNew();
	}

	public void setNew(boolean n) {
		_contactGroupContactEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactGroupContactEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactGroupContactEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactGroupContactEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactGroupContactEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactGroupContactEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactGroupContactEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactGroupContactEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactGroupContactEntryWrapper((ContactGroupContactEntry)_contactGroupContactEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry) {
		return _contactGroupContactEntry.compareTo(contactGroupContactEntry);
	}

	@Override
	public int hashCode() {
		return _contactGroupContactEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ContactGroupContactEntry> toCacheModel() {
		return _contactGroupContactEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ContactGroupContactEntry toEscapedModel() {
		return new ContactGroupContactEntryWrapper(_contactGroupContactEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactGroupContactEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _contactGroupContactEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactGroupContactEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactGroupContactEntry getWrappedContactGroupContactEntry() {
		return _contactGroupContactEntry;
	}

	public ContactGroupContactEntry getWrappedModel() {
		return _contactGroupContactEntry;
	}

	public void resetOriginalValues() {
		_contactGroupContactEntry.resetOriginalValues();
	}

	private ContactGroupContactEntry _contactGroupContactEntry;
}