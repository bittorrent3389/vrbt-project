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

import vn.com.fis.portal.model.ServiceTransactionEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ServiceTransactionEntry in entity cache.
 *
 * @author loind
 * @see ServiceTransactionEntry
 * @generated
 */
public class ServiceTransactionEntryCacheModel implements CacheModel<ServiceTransactionEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{transactionId=");
		sb.append(transactionId);
		sb.append(", transactionCode=");
		sb.append(transactionCode);
		sb.append(", date_=");
		sb.append(date_);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", serviceId=");
		sb.append(serviceId);
		sb.append(", serviceStatus=");
		sb.append(serviceStatus);
		sb.append(", serviceStartDate=");
		sb.append(serviceStartDate);
		sb.append(", serviceStopDate=");
		sb.append(serviceStopDate);
		sb.append(", servicePackageId=");
		sb.append(servicePackageId);
		sb.append(", packageDate=");
		sb.append(packageDate);
		sb.append("}");

		return sb.toString();
	}

	public ServiceTransactionEntry toEntityModel() {
		ServiceTransactionEntryImpl serviceTransactionEntryImpl = new ServiceTransactionEntryImpl();

		serviceTransactionEntryImpl.setTransactionId(transactionId);
		serviceTransactionEntryImpl.setTransactionCode(transactionCode);

		if (date_ == Long.MIN_VALUE) {
			serviceTransactionEntryImpl.setDate_(null);
		}
		else {
			serviceTransactionEntryImpl.setDate_(new Date(date_));
		}

		serviceTransactionEntryImpl.setUserId(userId);
		serviceTransactionEntryImpl.setServiceId(serviceId);
		serviceTransactionEntryImpl.setServiceStatus(serviceStatus);

		if (serviceStartDate == Long.MIN_VALUE) {
			serviceTransactionEntryImpl.setServiceStartDate(null);
		}
		else {
			serviceTransactionEntryImpl.setServiceStartDate(new Date(
					serviceStartDate));
		}

		if (serviceStopDate == Long.MIN_VALUE) {
			serviceTransactionEntryImpl.setServiceStopDate(null);
		}
		else {
			serviceTransactionEntryImpl.setServiceStopDate(new Date(
					serviceStopDate));
		}

		serviceTransactionEntryImpl.setServicePackageId(servicePackageId);

		if (packageDate == Long.MIN_VALUE) {
			serviceTransactionEntryImpl.setPackageDate(null);
		}
		else {
			serviceTransactionEntryImpl.setPackageDate(new Date(packageDate));
		}

		serviceTransactionEntryImpl.resetOriginalValues();

		return serviceTransactionEntryImpl;
	}

	public long transactionId;
	public int transactionCode;
	public long date_;
	public long userId;
	public long serviceId;
	public int serviceStatus;
	public long serviceStartDate;
	public long serviceStopDate;
	public long servicePackageId;
	public long packageDate;
}