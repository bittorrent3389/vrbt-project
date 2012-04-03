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

import vn.com.fis.portal.model.UserEntry;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing UserEntry in entity cache.
 *
 * @author loind
 * @see UserEntry
 * @generated
 */
public class UserEntryCacheModel implements CacheModel<UserEntry>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public UserEntry toEntityModel() {
		UserEntryImpl userEntryImpl = new UserEntryImpl();

		userEntryImpl.setUserId(userId);

		if (userName == null) {
			userEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			userEntryImpl.setUserName(userName);
		}

		if (mobileNumber == null) {
			userEntryImpl.setMobileNumber(StringPool.BLANK);
		}
		else {
			userEntryImpl.setMobileNumber(mobileNumber);
		}

		userEntryImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			userEntryImpl.setCreateDate(null);
		}
		else {
			userEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userEntryImpl.setModifiedDate(null);
		}
		else {
			userEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		userEntryImpl.setStatus(status);

		userEntryImpl.resetOriginalValues();

		return userEntryImpl;
	}

	public long userId;
	public String userName;
	public String mobileNumber;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public int status;
}