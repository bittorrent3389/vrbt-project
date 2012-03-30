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
 * This class is a wrapper for {@link ContactGroupVideoGroupEntry}.
 * </p>
 *
 * @author    loind
 * @see       ContactGroupVideoGroupEntry
 * @generated
 */
public class ContactGroupVideoGroupEntryWrapper
	implements ContactGroupVideoGroupEntry,
		ModelWrapper<ContactGroupVideoGroupEntry> {
	public ContactGroupVideoGroupEntryWrapper(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		_contactGroupVideoGroupEntry = contactGroupVideoGroupEntry;
	}

	public Class<?> getModelClass() {
		return ContactGroupVideoGroupEntry.class;
	}

	public String getModelClassName() {
		return ContactGroupVideoGroupEntry.class.getName();
	}

	/**
	* Returns the primary key of this contact group video group entry.
	*
	* @return the primary key of this contact group video group entry
	*/
	public long getPrimaryKey() {
		return _contactGroupVideoGroupEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this contact group video group entry.
	*
	* @param primaryKey the primary key of this contact group video group entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_contactGroupVideoGroupEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the contact group video group entry ID of this contact group video group entry.
	*
	* @return the contact group video group entry ID of this contact group video group entry
	*/
	public long getContactGroupVideoGroupEntryId() {
		return _contactGroupVideoGroupEntry.getContactGroupVideoGroupEntryId();
	}

	/**
	* Sets the contact group video group entry ID of this contact group video group entry.
	*
	* @param contactGroupVideoGroupEntryId the contact group video group entry ID of this contact group video group entry
	*/
	public void setContactGroupVideoGroupEntryId(
		long contactGroupVideoGroupEntryId) {
		_contactGroupVideoGroupEntry.setContactGroupVideoGroupEntryId(contactGroupVideoGroupEntryId);
	}

	/**
	* Returns the contact group ID of this contact group video group entry.
	*
	* @return the contact group ID of this contact group video group entry
	*/
	public long getContactGroupId() {
		return _contactGroupVideoGroupEntry.getContactGroupId();
	}

	/**
	* Sets the contact group ID of this contact group video group entry.
	*
	* @param contactGroupId the contact group ID of this contact group video group entry
	*/
	public void setContactGroupId(long contactGroupId) {
		_contactGroupVideoGroupEntry.setContactGroupId(contactGroupId);
	}

	/**
	* Returns the video group ID of this contact group video group entry.
	*
	* @return the video group ID of this contact group video group entry
	*/
	public long getVideoGroupId() {
		return _contactGroupVideoGroupEntry.getVideoGroupId();
	}

	/**
	* Sets the video group ID of this contact group video group entry.
	*
	* @param videoGroupId the video group ID of this contact group video group entry
	*/
	public void setVideoGroupId(long videoGroupId) {
		_contactGroupVideoGroupEntry.setVideoGroupId(videoGroupId);
	}

	public boolean isNew() {
		return _contactGroupVideoGroupEntry.isNew();
	}

	public void setNew(boolean n) {
		_contactGroupVideoGroupEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _contactGroupVideoGroupEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_contactGroupVideoGroupEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _contactGroupVideoGroupEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _contactGroupVideoGroupEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_contactGroupVideoGroupEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _contactGroupVideoGroupEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_contactGroupVideoGroupEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ContactGroupVideoGroupEntryWrapper((ContactGroupVideoGroupEntry)_contactGroupVideoGroupEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		return _contactGroupVideoGroupEntry.compareTo(contactGroupVideoGroupEntry);
	}

	@Override
	public int hashCode() {
		return _contactGroupVideoGroupEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> toCacheModel() {
		return _contactGroupVideoGroupEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry toEscapedModel() {
		return new ContactGroupVideoGroupEntryWrapper(_contactGroupVideoGroupEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _contactGroupVideoGroupEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _contactGroupVideoGroupEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactGroupVideoGroupEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ContactGroupVideoGroupEntry getWrappedContactGroupVideoGroupEntry() {
		return _contactGroupVideoGroupEntry;
	}

	public ContactGroupVideoGroupEntry getWrappedModel() {
		return _contactGroupVideoGroupEntry;
	}

	public void resetOriginalValues() {
		_contactGroupVideoGroupEntry.resetOriginalValues();
	}

	private ContactGroupVideoGroupEntry _contactGroupVideoGroupEntry;
}