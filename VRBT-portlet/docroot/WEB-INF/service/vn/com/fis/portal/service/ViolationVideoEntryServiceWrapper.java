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
 * This class is a wrapper for {@link ViolationVideoEntryService}.
 * </p>
 *
 * @author    loind
 * @see       ViolationVideoEntryService
 * @generated
 */
public class ViolationVideoEntryServiceWrapper
	implements ViolationVideoEntryService,
		ServiceWrapper<ViolationVideoEntryService> {
	public ViolationVideoEntryServiceWrapper(
		ViolationVideoEntryService violationVideoEntryService) {
		_violationVideoEntryService = violationVideoEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ViolationVideoEntryService getWrappedViolationVideoEntryService() {
		return _violationVideoEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedViolationVideoEntryService(
		ViolationVideoEntryService violationVideoEntryService) {
		_violationVideoEntryService = violationVideoEntryService;
	}

	public ViolationVideoEntryService getWrappedService() {
		return _violationVideoEntryService;
	}

	public void setWrappedService(
		ViolationVideoEntryService violationVideoEntryService) {
		_violationVideoEntryService = violationVideoEntryService;
	}

	private ViolationVideoEntryService _violationVideoEntryService;
}