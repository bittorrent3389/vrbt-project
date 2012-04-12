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

import vn.com.fis.portal.model.CategoryEntry;

import java.io.Serializable;

/**
 * The cache model class for representing CategoryEntry in entity cache.
 *
 * @author loind
 * @see CategoryEntry
 * @generated
 */
public class CategoryEntryCacheModel implements CacheModel<CategoryEntry>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	public CategoryEntry toEntityModel() {
		CategoryEntryImpl categoryEntryImpl = new CategoryEntryImpl();

		categoryEntryImpl.setCategoryId(categoryId);

		if (categoryName == null) {
			categoryEntryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			categoryEntryImpl.setCategoryName(categoryName);
		}

		if (description == null) {
			categoryEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			categoryEntryImpl.setDescription(description);
		}

		categoryEntryImpl.setStatus(status);

		categoryEntryImpl.resetOriginalValues();

		return categoryEntryImpl;
	}

	public long categoryId;
	public String categoryName;
	public String description;
	public int status;
}