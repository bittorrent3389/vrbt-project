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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException;
import vn.com.fis.portal.model.VideoUserVideoGroupEntry;
import vn.com.fis.portal.service.base.VideoUserVideoGroupEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.VideoUserVideoGroupEntryUtil;

/**
 * The implementation of the video user video group entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.VideoUserVideoGroupEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.VideoUserVideoGroupEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.VideoUserVideoGroupEntryLocalServiceUtil
 */
public class VideoUserVideoGroupEntryLocalServiceImpl
	extends VideoUserVideoGroupEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.VideoUserVideoGroupEntryLocalServiceUtil} to access the video user video group entry local service.
	 */
	
	/**
	 * Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @return the matching video user video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a matching video user video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry findByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		return VideoUserVideoGroupEntryUtil.findByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}

	/**
	 * Removes the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; from the database.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoUser_VideoGroup(long videoUserId, long videoGroupId)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		VideoUserVideoGroupEntryUtil.removeByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}
	/**
	 * Returns the number of video user video group entries where videoUserId = &#63; and videoGroupId = &#63;.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @return the number of matching video user video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoUser_VideoGroup(long videoUserId, long videoGroupId)
		throws SystemException {
		return VideoUserVideoGroupEntryUtil.countByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}
}