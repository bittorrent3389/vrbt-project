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
 * This class is a wrapper for {@link VideoUserVideoGroupEntryService}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserVideoGroupEntryService
 * @generated
 */
public class VideoUserVideoGroupEntryServiceWrapper
	implements VideoUserVideoGroupEntryService,
		ServiceWrapper<VideoUserVideoGroupEntryService> {
	public VideoUserVideoGroupEntryServiceWrapper(
		VideoUserVideoGroupEntryService videoUserVideoGroupEntryService) {
		_videoUserVideoGroupEntryService = videoUserVideoGroupEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoUserVideoGroupEntryService getWrappedVideoUserVideoGroupEntryService() {
		return _videoUserVideoGroupEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoUserVideoGroupEntryService(
		VideoUserVideoGroupEntryService videoUserVideoGroupEntryService) {
		_videoUserVideoGroupEntryService = videoUserVideoGroupEntryService;
	}

	public VideoUserVideoGroupEntryService getWrappedService() {
		return _videoUserVideoGroupEntryService;
	}

	public void setWrappedService(
		VideoUserVideoGroupEntryService videoUserVideoGroupEntryService) {
		_videoUserVideoGroupEntryService = videoUserVideoGroupEntryService;
	}

	private VideoUserVideoGroupEntryService _videoUserVideoGroupEntryService;
}