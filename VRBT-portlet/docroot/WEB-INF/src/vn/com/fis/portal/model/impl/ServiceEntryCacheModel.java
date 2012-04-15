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

import vn.com.fis.portal.model.ServiceEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ServiceEntry in entity cache.
 *
 * @author loind
 * @see ServiceEntry
 * @generated
 */
public class ServiceEntryCacheModel implements CacheModel<ServiceEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{serviceId=");
		sb.append(serviceId);
		sb.append(", serviceCode=");
		sb.append(serviceCode);
		sb.append(", serviceName=");
		sb.append(serviceName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public ServiceEntry toEntityModel() {
		ServiceEntryImpl serviceEntryImpl = new ServiceEntryImpl();

		serviceEntryImpl.setServiceId(serviceId);

		if (serviceCode == null) {
			serviceEntryImpl.setServiceCode(StringPool.BLANK);
		}
		else {
			serviceEntryImpl.setServiceCode(serviceCode);
		}

		if (serviceName == null) {
			serviceEntryImpl.setServiceName(StringPool.BLANK);
		}
		else {
			serviceEntryImpl.setServiceName(serviceName);
		}

		if (description == null) {
			serviceEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			serviceEntryImpl.setDescription(description);
		}

		if (createDate == Long.MIN_VALUE) {
			serviceEntryImpl.setCreateDate(null);
		}
		else {
			serviceEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceEntryImpl.setModifiedDate(null);
		}
		else {
			serviceEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		serviceEntryImpl.setStatus(status);

		serviceEntryImpl.resetOriginalValues();

		return serviceEntryImpl;
	}

	public long serviceId;
	public String serviceCode;
	public String serviceName;
	public String description;
	public long createDate;
	public long modifiedDate;
	public int status;
}