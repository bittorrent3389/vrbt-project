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
 * This class is used by SOAP remote services, specifically {@link vn.com.fis.portal.service.http.ViolationEntryServiceSoap}.
 *
 * @author    loind
 * @see       vn.com.fis.portal.service.http.ViolationEntryServiceSoap
 * @generated
 */
public class ViolationEntrySoap implements Serializable {
	public static ViolationEntrySoap toSoapModel(ViolationEntry model) {
		ViolationEntrySoap soapModel = new ViolationEntrySoap();

		soapModel.setViolationId(model.getViolationId());
		soapModel.setViolationTitle(model.getViolationTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ViolationEntrySoap[] toSoapModels(ViolationEntry[] models) {
		ViolationEntrySoap[] soapModels = new ViolationEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViolationEntrySoap[][] toSoapModels(ViolationEntry[][] models) {
		ViolationEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViolationEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViolationEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViolationEntrySoap[] toSoapModels(List<ViolationEntry> models) {
		List<ViolationEntrySoap> soapModels = new ArrayList<ViolationEntrySoap>(models.size());

		for (ViolationEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViolationEntrySoap[soapModels.size()]);
	}

	public ViolationEntrySoap() {
	}

	public long getPrimaryKey() {
		return _violationId;
	}

	public void setPrimaryKey(long pk) {
		setViolationId(pk);
	}

	public long getViolationId() {
		return _violationId;
	}

	public void setViolationId(long violationId) {
		_violationId = violationId;
	}

	public String getViolationTitle() {
		return _violationTitle;
	}

	public void setViolationTitle(String violationTitle) {
		_violationTitle = violationTitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _violationId;
	private String _violationTitle;
	private String _description;
	private int _status;
}