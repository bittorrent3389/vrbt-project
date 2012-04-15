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

import vn.com.fis.portal.model.ContactGroupContactEntry;

import java.io.Serializable;

/**
 * The cache model class for representing ContactGroupContactEntry in entity cache.
 *
 * @author loind
 * @see ContactGroupContactEntry
 * @generated
 */
public class ContactGroupContactEntryCacheModel implements CacheModel<ContactGroupContactEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactGroupContactId=");
		sb.append(contactGroupContactId);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", contactGroupId=");
		sb.append(contactGroupId);
		sb.append("}");

		return sb.toString();
	}

	public ContactGroupContactEntry toEntityModel() {
		ContactGroupContactEntryImpl contactGroupContactEntryImpl = new ContactGroupContactEntryImpl();

		contactGroupContactEntryImpl.setContactGroupContactId(contactGroupContactId);

		if (contactId == null) {
			contactGroupContactEntryImpl.setContactId(StringPool.BLANK);
		}
		else {
			contactGroupContactEntryImpl.setContactId(contactId);
		}

		if (contactGroupId == null) {
			contactGroupContactEntryImpl.setContactGroupId(StringPool.BLANK);
		}
		else {
			contactGroupContactEntryImpl.setContactGroupId(contactGroupId);
		}

		contactGroupContactEntryImpl.resetOriginalValues();

		return contactGroupContactEntryImpl;
	}

	public long contactGroupContactId;
	public String contactId;
	public String contactGroupId;
}