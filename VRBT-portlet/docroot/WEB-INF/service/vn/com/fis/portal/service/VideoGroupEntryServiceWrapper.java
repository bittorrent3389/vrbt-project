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
 * This class is a wrapper for {@link VideoGroupEntryService}.
 * </p>
 *
 * @author    loind
 * @see       VideoGroupEntryService
 * @generated
 */
public class VideoGroupEntryServiceWrapper implements VideoGroupEntryService,
	ServiceWrapper<VideoGroupEntryService> {
	public VideoGroupEntryServiceWrapper(
		VideoGroupEntryService videoGroupEntryService) {
		_videoGroupEntryService = videoGroupEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoGroupEntryService getWrappedVideoGroupEntryService() {
		return _videoGroupEntryService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoGroupEntryService(
		VideoGroupEntryService videoGroupEntryService) {
		_videoGroupEntryService = videoGroupEntryService;
	}

	public VideoGroupEntryService getWrappedService() {
		return _videoGroupEntryService;
	}

	public void setWrappedService(VideoGroupEntryService videoGroupEntryService) {
		_videoGroupEntryService = videoGroupEntryService;
	}

	private VideoGroupEntryService _videoGroupEntryService;
}