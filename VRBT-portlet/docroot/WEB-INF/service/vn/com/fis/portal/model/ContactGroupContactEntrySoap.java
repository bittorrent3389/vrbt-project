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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ContactGroupContactEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ContactGroupContactEntryServiceSoap
 * @generated
 */
public class ContactGroupContactEntrySoap implements Serializable {
	public static ContactGroupContactEntrySoap toSoapModel(
		ContactGroupContactEntry model) {
		ContactGroupContactEntrySoap soapModel = new ContactGroupContactEntrySoap();

		soapModel.setContactGroupContactId(model.getContactGroupContactId());
		soapModel.setContactId(model.getContactId());
		soapModel.setContactGroupId(model.getContactGroupId());

		return soapModel;
	}

	public static ContactGroupContactEntrySoap[] toSoapModels(
		ContactGroupContactEntry[] models) {
		ContactGroupContactEntrySoap[] soapModels = new ContactGroupContactEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactGroupContactEntrySoap[][] toSoapModels(
		ContactGroupContactEntry[][] models) {
		ContactGroupContactEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactGroupContactEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactGroupContactEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactGroupContactEntrySoap[] toSoapModels(
		List<ContactGroupContactEntry> models) {
		List<ContactGroupContactEntrySoap> soapModels = new ArrayList<ContactGroupContactEntrySoap>(models.size());

		for (ContactGroupContactEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactGroupContactEntrySoap[soapModels.size()]);
	}

	public ContactGroupContactEntrySoap() {
	}

	public long getPrimaryKey() {
		return _contactGroupContactId;
	}

	public void setPrimaryKey(long pk) {
		setContactGroupContactId(pk);
	}

	public long getContactGroupContactId() {
		return _contactGroupContactId;
	}

	public void setContactGroupContactId(long contactGroupContactId) {
		_contactGroupContactId = contactGroupContactId;
	}

	public String getContactId() {
		return _contactId;
	}

	public void setContactId(String contactId) {
		_contactId = contactId;
	}

	public String getContactGroupId() {
		return _contactGroupId;
	}

	public void setContactGroupId(String contactGroupId) {
		_contactGroupId = contactGroupId;
	}

	private long _contactGroupContactId;
	private String _contactId;
	private String _contactGroupId;
}