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

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.fis.portal.model.VideoUserTransactionEntry;
import vn.com.fis.portal.service.base.VideoUserTransactionEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.VideoUserTransactionEntryUtil;

/**
 * The implementation of the video user transaction entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.VideoUserTransactionEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.VideoUserTransactionEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.VideoUserTransactionEntryLocalServiceUtil
 */
public class VideoUserTransactionEntryLocalServiceImpl
	extends VideoUserTransactionEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.VideoUserTransactionEntryLocalServiceUtil} to access the video user transaction entry local service.
	 */

	/**
	 * Returns all the video user transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode) throws SystemException {
		return VideoUserTransactionEntryUtil.findByTransactionCode(transactionCode);
	}

	/**
	 * Returns a range of all the video user transaction entries where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end) throws SystemException {
		return VideoUserTransactionEntryUtil.findByTransactionCode(transactionCode, start, end);
	}
	/**
	 * Returns the number of video user transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTransactionCode(long transactionCode)
		throws SystemException {
		return VideoUserTransactionEntryUtil.countByTransactionCode(transactionCode);
	}
	/**
	 * Returns all the video user transaction entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByDate(Date date_)
		throws SystemException {
		return VideoUserTransactionEntryUtil.findByDate(date_);
	}

	/**
	 * Returns a range of all the video user transaction entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByDate(Date date_, int start,
		int end) throws SystemException {
		return VideoUserTransactionEntryUtil.findByDate(date_, start, end);
	}
	/**
	 * Returns the number of video user transaction entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDate(Date date_) throws SystemException {
		return VideoUserTransactionEntryUtil.countByDate(date_);
	}
	
	/**
	 * Returns all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, Date date_) throws SystemException {
		return VideoUserTransactionEntryUtil.findByTransactionCode_Date(transactionCode, date_);
	}

	/**
	 * Returns a range of all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, Date date_, int start, int end)
		throws SystemException {
		return VideoUserTransactionEntryUtil.findByTransactionCode_Date(transactionCode, date_, start, end);
	}
	/**
	 * Returns the number of video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTransactionCode_Date(long transactionCode, Date date_)
		throws SystemException {
		return VideoUserTransactionEntryUtil.countByTransactionCode_Date(transactionCode, date_);
	}
	/**
	 * Returns all the video user transaction entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByUserId(long userId)
		throws SystemException {
		return VideoUserTransactionEntryUtil.findByUserId(userId);
	}

	/**
	 * Returns a range of all the video user transaction entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByUserId(long userId, int start,
		int end) throws SystemException {
		return VideoUserTransactionEntryUtil.findByUserId(userId, start, end);
	}
	/**
	 * Returns the number of video user transaction entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		return VideoUserTransactionEntryUtil.countByUserId(userId);
		}
	/**
	 * Returns all the video user transaction entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByVideoId(long videoId)
		throws SystemException {
		return VideoUserTransactionEntryUtil.findByVideoId(videoId);
	}

	/**
	 * Returns a range of all the video user transaction entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByVideoId(long videoId,
		int start, int end) throws SystemException {
		return VideoUserTransactionEntryUtil.findByVideoId(videoId, start, end);
	}

	/**
	 * Returns the number of video user transaction entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId(long videoId) throws SystemException {
		return VideoUserTransactionEntryUtil.countByVideoId(videoId);
		}
	/**
	 * Returns all the video user transaction entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByreceiverId(long receiverId)
		throws SystemException {
		return VideoUserTransactionEntryUtil.findByreceiverId(receiverId);
	}

	/**
	 * Returns a range of all the video user transaction entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByreceiverId(long receiverId,
		int start, int end) throws SystemException {
		return VideoUserTransactionEntryUtil.findByreceiverId(receiverId, start, end);
	}
	/**
	 * Returns the number of video user transaction entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByreceiverId(long receiverId) throws SystemException {
		return VideoUserTransactionEntryUtil.countByreceiverId(receiverId);
	}
}