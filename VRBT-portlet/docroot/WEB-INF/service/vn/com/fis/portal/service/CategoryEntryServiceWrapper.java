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

package vn.com.fis.portal.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CategoryEntryService}.
 * </p>
 *
 * @author    loind
 * @see       CategoryEntryService
 * @generated
 */
public class CategoryEntryServiceWrapper implements CategoryEntryService,
	ServiceWrapper<CategoryEntryService> {
	public CategoryEntryServiceWrapper(
		CategoryEntryService categoryEntryService) {
		_categoryEntryService = categoryEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoryEntryService getWrappedCategoryEntryService() {
		return _categoryEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoryEntryService(
		CategoryEntryService categoryEntryService) {
		_categoryEntryService = categoryEntryService;
	}

	public CategoryEntryService getWrappedService() {
		return _categoryEntryService;
	}

	public void setWrappedService(CategoryEntryService categoryEntryService) {
		_categoryEntryService = categoryEntryService;
	}

	private CategoryEntryService _categoryEntryService;
}