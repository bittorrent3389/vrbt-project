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
import com.liferay.portal.model.CacheModel;

import vn.com.fis.portal.model.ContactGroupVideoGroupEntry;

import java.io.Serializable;

/**
 * The cache model class for representing ContactGroupVideoGroupEntry in entity cache.
 *
 * @author loind
 * @see ContactGroupVideoGroupEntry
 * @generated
 */
public class ContactGroupVideoGroupEntryCacheModel implements CacheModel<ContactGroupVideoGroupEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{contactGroupVideoGroupEntryId=");
		sb.append(contactGroupVideoGroupEntryId);
		sb.append(", contactGroupId=");
		sb.append(contactGroupId);
		sb.append(", videoGroupId=");
		sb.append(videoGroupId);
		sb.append("}");

		return sb.toString();
	}

	public ContactGroupVideoGroupEntry toEntityModel() {
		ContactGroupVideoGroupEntryImpl contactGroupVideoGroupEntryImpl = new ContactGroupVideoGroupEntryImpl();

		contactGroupVideoGroupEntryImpl.setContactGroupVideoGroupEntryId(contactGroupVideoGroupEntryId);
		contactGroupVideoGroupEntryImpl.setContactGroupId(contactGroupId);
		contactGroupVideoGroupEntryImpl.setVideoGroupId(videoGroupId);

		contactGroupVideoGroupEntryImpl.resetOriginalValues();

		return contactGroupVideoGroupEntryImpl;
	}

	public long contactGroupVideoGroupEntryId;
	public long contactGroupId;
	public long videoGroupId;
}