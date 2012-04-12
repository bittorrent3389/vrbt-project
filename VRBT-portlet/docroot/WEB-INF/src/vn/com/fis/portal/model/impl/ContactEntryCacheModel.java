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

import vn.com.fis.portal.model.ContactEntry;

import java.io.Serializable;

/**
 * The cache model class for representing ContactEntry in entity cache.
 *
 * @author loind
 * @see ContactEntry
 * @generated
 */
public class ContactEntryCacheModel implements CacheModel<ContactEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{contactId=");
		sb.append(contactId);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	public ContactEntry toEntityModel() {
		ContactEntryImpl contactEntryImpl = new ContactEntryImpl();

		contactEntryImpl.setContactId(contactId);

		if (contactName == null) {
			contactEntryImpl.setContactName(StringPool.BLANK);
		}
		else {
			contactEntryImpl.setContactName(contactName);
		}

		if (mobileNumber == null) {
			contactEntryImpl.setMobileNumber(StringPool.BLANK);
		}
		else {
			contactEntryImpl.setMobileNumber(mobileNumber);
		}

		contactEntryImpl.setUserId(userId);

		contactEntryImpl.resetOriginalValues();

		return contactEntryImpl;
	}

	public long contactId;
	public String contactName;
	public String mobileNumber;
	public long userId;
}