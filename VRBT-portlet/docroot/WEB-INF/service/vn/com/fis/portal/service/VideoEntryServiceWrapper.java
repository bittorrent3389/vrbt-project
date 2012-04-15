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
 * This class is a wrapper for {@link VideoEntryService}.
 * </p>
 *
 * @author    loind
 * @see       VideoEntryService
 * @generated
 */
public class VideoEntryServiceWrapper implements VideoEntryService,
	ServiceWrapper<VideoEntryService> {
	public VideoEntryServiceWrapper(VideoEntryService videoEntryService) {
		_videoEntryService = videoEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoEntryService getWrappedVideoEntryService() {
		return _videoEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoEntryService(VideoEntryService videoEntryService) {
		_videoEntryService = videoEntryService;
	}

	public VideoEntryService getWrappedService() {
		return _videoEntryService;
	}

	public void setWrappedService(VideoEntryService videoEntryService) {
		_videoEntryService = videoEntryService;
	}

	private VideoEntryService _videoEntryService;
}