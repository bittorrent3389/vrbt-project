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

import vn.com.fis.portal.NoSuchRatingEntryException;
import vn.com.fis.portal.model.RatingEntry;
import vn.com.fis.portal.service.base.RatingEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.RatingEntryUtil;

/**
 * The implementation of the rating entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.RatingEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.RatingEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.RatingEntryLocalServiceUtil
 */
public class RatingEntryLocalServiceImpl extends RatingEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.RatingEntryLocalServiceUtil} to access the rating entry local service.
	 */
	/**
	 * Returns all the rating entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId(long videoId)
		throws SystemException {
		return RatingEntryUtil.findByVideoId(videoId);
	}
	/**
	 * Returns a range of all the rating entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId(long videoId, int start, int end)
		throws SystemException {
		return RatingEntryUtil.findByVideoId(videoId, start, end);
	}
	/**
	 * Returns the number of rating entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId(long videoId) throws SystemException {
		return RatingEntryUtil.countByVideoId(videoId);
		}

	/**
	 * Returns all the rating entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByUserId(long userId)
		throws SystemException {
		return RatingEntryUtil.findByUserId(userId);
	}
	/**
	 * Returns a range of all the rating entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return RatingEntryUtil.findByUserId(userId, start, end);
	}
	/**
	 * Returns the number of rating entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		return RatingEntryUtil.countByUserId(userId);
		}
	/**
	 * Returns all the rating entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByRatingCode(int code)
		throws SystemException {
		return RatingEntryUtil.findByRatingCode(code);
	}

	/**
	 * Returns a range of all the rating entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param code the code
	 
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByRatingCode(int code, int start, int end)
		throws SystemException {
		return RatingEntryUtil.findByRatingCode(code, start, end);
	}
	/**
	 * Returns the number of rating entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRatingCode(int code) throws SystemException {
		return RatingEntryUtil.countByRatingCode(code);
	}
	/**
	 * Returns all the rating entries where code = &#63; and videoId = &#63;.
	 *
	 * @param code the code
	 * @param videoId the video ID
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	
	/**
	 * Returns a range of all the rating entries where code = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param code the code
	 * @param videoId the video ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	
	/**
	 * Returns the number of rating entries where code = &#63; and videoId = &#63;.
	 *
	 * @param code the code
	 * @param videoId the video ID
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	
	/**
	 * Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @return the matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByUser_Video_Code(long userId, long videoId, int code)
		throws NoSuchRatingEntryException, SystemException {
		return RatingEntryUtil.findByUser_Video_Code(userId, videoId, code);
	}
	
	public RatingEntry fetchByUser_Video_Code(long userId, long videoId,
			int code) throws SystemException {
		return RatingEntryUtil.fetchByUser_Video_Code(userId, videoId, code);
	}
	/**
	 * Returns the number of rating entries where userId = &#63; and videoId = &#63; and code = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUser_Video_Code(long userId, long videoId, int code)
		throws SystemException {
		return RatingEntryUtil.countByUser_Video_Code(userId, videoId, code);
	}
	/**
	 * Removes the rating entry where userId = &#63; and videoId = &#63; and code = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUser_Video_Code(long userId, long videoId, int code)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntryUtil.removeByUser_Video_Code(userId, videoId, code);
	}
	
	public List<RatingEntry> findByVideoId_UserId(long videoId, long userId)
			throws SystemException {
		return RatingEntryUtil.findByVideoId_UserId(videoId, userId);
	}
	
	public List<RatingEntry> findByVideoId_Code(long videoId, int code) throws SystemException{
		return RatingEntryUtil.findByVideoId_Code(videoId, code);
	}
	
	public int countByVideoId_Code(long videoId, int code) throws SystemException{
		/*System.out.println("OKI");
		try {
			return RatingEntryUtil.countByVideoId_Code(videoId, code);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}*/
		return RatingEntryUtil.countByVideoId_Code(videoId, code);
	}
	
	public int countByVideoId_UserId(long videoId, long userId)
			throws SystemException {
		return RatingEntryUtil.countByVideoId_UserId(videoId, userId);
	}
}