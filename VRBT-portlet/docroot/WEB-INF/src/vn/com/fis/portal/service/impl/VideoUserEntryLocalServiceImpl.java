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

package vn.com.fis.portal.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.fis.portal.model.VideoUserEntry;
import vn.com.fis.portal.service.base.VideoUserEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.VideoUserEntryUtil;

/**
 * The implementation of the video user entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.VideoUserEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.VideoUserEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil
 */
public class VideoUserEntryLocalServiceImpl
	extends VideoUserEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil} to access the video user entry local service.
	 */
	

	/**
	 * Returns all the video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @return the matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId(long userId, long videoId)
		throws SystemException {
		return VideoUserEntryUtil.findByUserId_VideoId(userId, videoId);
	}

	/**
	 * Returns a range of all the video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @return the range of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId(long userId, long videoId,
		int start, int end) throws SystemException {
		return VideoUserEntryUtil.findByUserId_VideoId(userId, videoId, start, end);
	}
	/**
	 * Removes all the video user entries where userId = &#63; and videoId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_VideoId(long userId, long videoId)
		throws SystemException {
		  VideoUserEntryUtil.removeByUserId_VideoId(userId, videoId);
	}
	/**
	 * Returns the number of video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @return the number of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_VideoId(long userId, long videoId)
		throws SystemException {
		return VideoUserEntryUtil.countByUserId_VideoId(userId, videoId);
	}
}