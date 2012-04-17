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

import vn.com.fis.portal.model.UserServiceEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UserServiceEntry in entity cache.
 *
 * @author loind
 * @see UserServiceEntry
 * @generated
 */
public class UserServiceEntryCacheModel implements CacheModel<UserServiceEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userServiceId=");
		sb.append(userServiceId);
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

	public UserServiceEntry toEntityModel() {
		UserServiceEntryImpl userServiceEntryImpl = new UserServiceEntryImpl();

		userServiceEntryImpl.setUserServiceId(userServiceId);
		userServiceEntryImpl.setUserId(userId);
		userServiceEntryImpl.setServiceId(serviceId);
		userServiceEntryImpl.setServiceStatus(serviceStatus);

		if (serviceStartDate == Long.MIN_VALUE) {
			userServiceEntryImpl.setServiceStartDate(null);
		}
		else {
			userServiceEntryImpl.setServiceStartDate(new Date(serviceStartDate));
		}

		if (serviceStopDate == Long.MIN_VALUE) {
			userServiceEntryImpl.setServiceStopDate(null);
		}
		else {
			userServiceEntryImpl.setServiceStopDate(new Date(serviceStopDate));
		}

		userServiceEntryImpl.setServicePackageId(servicePackageId);

		if (packageDate == Long.MIN_VALUE) {
			userServiceEntryImpl.setPackageDate(null);
		}
		else {
			userServiceEntryImpl.setPackageDate(new Date(packageDate));
		}

		userServiceEntryImpl.resetOriginalValues();

		return userServiceEntryImpl;
	}

	public long userServiceId;
	public long userId;
	public long serviceId;
	public int serviceStatus;
	public long serviceStartDate;
	public long serviceStopDate;
	public long servicePackageId;
	public long packageDate;
}