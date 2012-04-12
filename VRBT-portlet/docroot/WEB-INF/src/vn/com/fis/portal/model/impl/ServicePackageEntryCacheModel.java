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

import vn.com.fis.portal.model.ServicePackageEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ServicePackageEntry in entity cache.
 *
 * @author loind
 * @see ServicePackageEntry
 * @generated
 */
public class ServicePackageEntryCacheModel implements CacheModel<ServicePackageEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{servicePackageId=");
		sb.append(servicePackageId);
		sb.append(", servicePackageName=");
		sb.append(servicePackageName);
		sb.append(", servicePackageCode=");
		sb.append(servicePackageCode);
		sb.append(", description=");
		sb.append(description);
		sb.append(", totalFile=");
		sb.append(totalFile);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", serviceId=");
		sb.append(serviceId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public ServicePackageEntry toEntityModel() {
		ServicePackageEntryImpl servicePackageEntryImpl = new ServicePackageEntryImpl();

		servicePackageEntryImpl.setServicePackageId(servicePackageId);

		if (servicePackageName == null) {
			servicePackageEntryImpl.setServicePackageName(StringPool.BLANK);
		}
		else {
			servicePackageEntryImpl.setServicePackageName(servicePackageName);
		}

		if (servicePackageCode == null) {
			servicePackageEntryImpl.setServicePackageCode(StringPool.BLANK);
		}
		else {
			servicePackageEntryImpl.setServicePackageCode(servicePackageCode);
		}

		if (description == null) {
			servicePackageEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			servicePackageEntryImpl.setDescription(description);
		}

		servicePackageEntryImpl.setTotalFile(totalFile);

		if (createDate == Long.MIN_VALUE) {
			servicePackageEntryImpl.setCreateDate(null);
		}
		else {
			servicePackageEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			servicePackageEntryImpl.setModifiedDate(null);
		}
		else {
			servicePackageEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		servicePackageEntryImpl.setServiceId(serviceId);
		servicePackageEntryImpl.setStatus(status);

		servicePackageEntryImpl.resetOriginalValues();

		return servicePackageEntryImpl;
	}

	public long servicePackageId;
	public String servicePackageName;
	public String servicePackageCode;
	public String description;
	public int totalFile;
	public long createDate;
	public long modifiedDate;
	public long serviceId;
	public int status;
}