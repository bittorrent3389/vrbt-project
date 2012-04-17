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
 * This class is a wrapper for {@link VideoUserContactEntryService}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserContactEntryService
 * @generated
 */
public class VideoUserContactEntryServiceWrapper
	implements VideoUserContactEntryService,
		ServiceWrapper<VideoUserContactEntryService> {
	public VideoUserContactEntryServiceWrapper(
		VideoUserContactEntryService videoUserContactEntryService) {
		_videoUserContactEntryService = videoUserContactEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoUserContactEntryService getWrappedVideoUserContactEntryService() {
		return _videoUserContactEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoUserContactEntryService(
		VideoUserContactEntryService videoUserContactEntryService) {
		_videoUserContactEntryService = videoUserContactEntryService;
	}

	public VideoUserContactEntryService getWrappedService() {
		return _videoUserContactEntryService;
	}

	public void setWrappedService(
		VideoUserContactEntryService videoUserContactEntryService) {
		_videoUserContactEntryService = videoUserContactEntryService;
	}

	private VideoUserContactEntryService _videoUserContactEntryService;
}