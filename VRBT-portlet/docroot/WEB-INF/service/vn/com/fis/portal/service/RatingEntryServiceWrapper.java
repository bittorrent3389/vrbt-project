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
 * This class is a wrapper for {@link RatingEntryService}.
 * </p>
 *
 * @author    loind
 * @see       RatingEntryService
 * @generated
 */
public class RatingEntryServiceWrapper implements RatingEntryService,
	ServiceWrapper<RatingEntryService> {
	public RatingEntryServiceWrapper(RatingEntryService ratingEntryService) {
		_ratingEntryService = ratingEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RatingEntryService getWrappedRatingEntryService() {
		return _ratingEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRatingEntryService(
		RatingEntryService ratingEntryService) {
		_ratingEntryService = ratingEntryService;
	}

	public RatingEntryService getWrappedService() {
		return _ratingEntryService;
	}

	public void setWrappedService(RatingEntryService ratingEntryService) {
		_ratingEntryService = ratingEntryService;
	}

	private RatingEntryService _ratingEntryService;
}