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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ContactGroupVideoGroupEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ContactGroupVideoGroupEntryServiceSoap
 * @generated
 */
public class ContactGroupVideoGroupEntrySoap implements Serializable {
	public static ContactGroupVideoGroupEntrySoap toSoapModel(
		ContactGroupVideoGroupEntry model) {
		ContactGroupVideoGroupEntrySoap soapModel = new ContactGroupVideoGroupEntrySoap();

		soapModel.setContactGroupVideoGroupEntryId(model.getContactGroupVideoGroupEntryId());
		soapModel.setContactGroupId(model.getContactGroupId());
		soapModel.setVideoGroupId(model.getVideoGroupId());

		return soapModel;
	}

	public static ContactGroupVideoGroupEntrySoap[] toSoapModels(
		ContactGroupVideoGroupEntry[] models) {
		ContactGroupVideoGroupEntrySoap[] soapModels = new ContactGroupVideoGroupEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactGroupVideoGroupEntrySoap[][] toSoapModels(
		ContactGroupVideoGroupEntry[][] models) {
		ContactGroupVideoGroupEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactGroupVideoGroupEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactGroupVideoGroupEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactGroupVideoGroupEntrySoap[] toSoapModels(
		List<ContactGroupVideoGroupEntry> models) {
		List<ContactGroupVideoGroupEntrySoap> soapModels = new ArrayList<ContactGroupVideoGroupEntrySoap>(models.size());

		for (ContactGroupVideoGroupEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactGroupVideoGroupEntrySoap[soapModels.size()]);
	}

	public ContactGroupVideoGroupEntrySoap() {
	}

	public long getPrimaryKey() {
		return _contactGroupVideoGroupEntryId;
	}

	public void setPrimaryKey(long pk) {
		setContactGroupVideoGroupEntryId(pk);
	}

	public long getContactGroupVideoGroupEntryId() {
		return _contactGroupVideoGroupEntryId;
	}

	public void setContactGroupVideoGroupEntryId(
		long contactGroupVideoGroupEntryId) {
		_contactGroupVideoGroupEntryId = contactGroupVideoGroupEntryId;
	}

	public long getContactGroupId() {
		return _contactGroupId;
	}

	public void setContactGroupId(long contactGroupId) {
		_contactGroupId = contactGroupId;
	}

	public long getVideoGroupId() {
		return _videoGroupId;
	}

	public void setVideoGroupId(long videoGroupId) {
		_videoGroupId = videoGroupId;
	}

	private long _contactGroupVideoGroupEntryId;
	private long _contactGroupId;
	private long _videoGroupId;
}