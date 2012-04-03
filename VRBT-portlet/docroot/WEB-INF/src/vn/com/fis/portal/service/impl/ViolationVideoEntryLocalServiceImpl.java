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

import vn.com.fis.portal.NoSuchViolationVideoEntryException;
import vn.com.fis.portal.model.ViolationVideoEntry;
import vn.com.fis.portal.service.base.ViolationVideoEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ViolationVideoEntryUtil;

/**
 * The implementation of the violation video entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ViolationVideoEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ViolationVideoEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ViolationVideoEntryLocalServiceUtil
 */
public class ViolationVideoEntryLocalServiceImpl
	extends ViolationVideoEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ViolationVideoEntryLocalServiceUtil} to access the violation video entry local service.
	 */
	/**
	 * Returns all the violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findByVideoId_UserId(long videoId,
		long userId) throws SystemException {
		return ViolationVideoEntryUtil.findByVideoId_UserId(videoId, userId);
	}

	/**
	 * Returns a range of all the violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of violation video entries
	 * @param end the upper bound of the range of violation video entries (not inclusive)
	 * @return the range of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findByVideoId_UserId(long videoId,
		long userId, int start, int end) throws SystemException {
		return ViolationVideoEntryUtil.findByVideoId_UserId(videoId, userId, start, end);
	}
	/**
	 * Returns the number of violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the number of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId_UserId(long videoId, long userId)
		throws SystemException {
		return ViolationVideoEntryUtil.countByVideoId_UserId(videoId, userId);
	}
	/**
	 * Removes all the violation video entries where videoId = &#63; and userId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId_UserId(long videoId, long userId)
		throws SystemException {
		ViolationVideoEntryUtil.removeByVideoId_UserId(videoId, userId);
	}
	/**
	 * Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or throws a {@link vn.com.fis.portal.NoSuchViolationVideoEntryException} if it could not be found.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @return the matching violation video entry
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry findByVideo_User_Violation(long videoId,
		long userId, long violationId)
		throws NoSuchViolationVideoEntryException, SystemException {
		return ViolationVideoEntryUtil.findByVideo_User_Violation(videoId, userId, violationId);
	}
	/**
	 * Returns the number of violation video entries where videoId = &#63; and userId = &#63; and violationId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @return the number of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideo_User_Violation(long videoId, long userId,
		long violationId) throws SystemException {
		return ViolationVideoEntryUtil.countByVideo_User_Violation(videoId, userId, violationId);		
	}
}