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

import vn.com.fis.portal.model.ViolationEntry;

import java.io.Serializable;

/**
 * The cache model class for representing ViolationEntry in entity cache.
 *
 * @author loind
 * @see ViolationEntry
 * @generated
 */
public class ViolationEntryCacheModel implements CacheModel<ViolationEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{violationId=");
		sb.append(violationId);
		sb.append(", violationTitle=");
		sb.append(violationTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public ViolationEntry toEntityModel() {
		ViolationEntryImpl violationEntryImpl = new ViolationEntryImpl();

		violationEntryImpl.setViolationId(violationId);

		if (violationTitle == null) {
			violationEntryImpl.setViolationTitle(StringPool.BLANK);
		}
		else {
			violationEntryImpl.setViolationTitle(violationTitle);
		}

		if (description == null) {
			violationEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			violationEntryImpl.setDescription(description);
		}

		violationEntryImpl.setStatus(status);

		violationEntryImpl.resetOriginalValues();

		return violationEntryImpl;
	}

	public long violationId;
	public String violationTitle;
	public String description;
	public int status;
}