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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ContactGroupEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ContactGroupEntryServiceSoap
 * @generated
 */
public class ContactGroupEntrySoap implements Serializable {
	public static ContactGroupEntrySoap toSoapModel(ContactGroupEntry model) {
		ContactGroupEntrySoap soapModel = new ContactGroupEntrySoap();

		soapModel.setContactGroupId(model.getContactGroupId());
		soapModel.setContactGroupName(model.getContactGroupName());
		soapModel.setDescription(model.getDescription());
		soapModel.setContactGroupType(model.getContactGroupType());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static ContactGroupEntrySoap[] toSoapModels(
		ContactGroupEntry[] models) {
		ContactGroupEntrySoap[] soapModels = new ContactGroupEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContactGroupEntrySoap[][] toSoapModels(
		ContactGroupEntry[][] models) {
		ContactGroupEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContactGroupEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContactGroupEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContactGroupEntrySoap[] toSoapModels(
		List<ContactGroupEntry> models) {
		List<ContactGroupEntrySoap> soapModels = new ArrayList<ContactGroupEntrySoap>(models.size());

		for (ContactGroupEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContactGroupEntrySoap[soapModels.size()]);
	}

	public ContactGroupEntrySoap() {
	}

	public long getPrimaryKey() {
		return _contactGroupId;
	}

	public void setPrimaryKey(long pk) {
		setContactGroupId(pk);
	}

	public long getContactGroupId() {
		return _contactGroupId;
	}

	public void setContactGroupId(long contactGroupId) {
		_contactGroupId = contactGroupId;
	}

	public String getContactGroupName() {
		return _contactGroupName;
	}

	public void setContactGroupName(String contactGroupName) {
		_contactGroupName = contactGroupName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getContactGroupType() {
		return _contactGroupType;
	}

	public void setContactGroupType(int contactGroupType) {
		_contactGroupType = contactGroupType;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _contactGroupId;
	private String _contactGroupName;
	private String _description;
	private int _contactGroupType;
	private long _userId;
}