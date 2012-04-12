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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ContactEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ContactEntryServiceSoap
 * @generated
 */
public class ContactEntrySoap implements Serializable {
	public static ContactEntrySoap toSoapModel(ContactEntry model) {
		ContactEntrySoap soapModel = new ContactEntrySoap();

		soapModel.setContactId(model.getContactId());
		soapModel.setContactName(model.getContactName());
		soapModel.setMobileNumber(model.getMobileNumber());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ContactEntrySoap[] toSoapModels(ContactEntry[] models) {
		ContactEntrySoap[] soapModels = new ContactEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactEntrySoap[][] toSoapModels(ContactEntry[][] models) {
		ContactEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactEntrySoap[] toSoapModels(List<ContactEntry> models) {
		List<ContactEntrySoap> soapModels = new ArrayList<ContactEntrySoap>(models.size());

		for (ContactEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactEntrySoap[soapModels.size()]);
	}

	public ContactEntrySoap() {
	}

	public long getPrimaryKey() {
		return _contactId;
	}

	public void setPrimaryKey(long pk) {
		setContactId(pk);
	}

	public long getContactId() {
		return _contactId;
	}

	public void setContactId(long contactId) {
		_contactId = contactId;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _contactId;
	private String _contactName;
	private String _mobileNumber;
	private long _userId;
}