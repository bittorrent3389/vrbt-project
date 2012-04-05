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

import vn.com.fis.portal.model.VideoEntry;
import vn.com.fis.portal.model.VideoUserEntry;
import vn.com.fis.portal.service.base.VideoEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.VideoEntryUtil;
import vn.com.fis.portal.service.persistence.VideoUserEntryUtil;

/**
 * The implementation of the video entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.VideoEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.VideoEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.VideoEntryLocalServiceUtil
 */
public class VideoEntryLocalServiceImpl extends VideoEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.VideoEntryLocalServiceUtil} to access the video entry local service.
	 */
	
	/**
	 * Returns all the video entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByDateUpload(Date date_)
		throws SystemException {
		return VideoEntryUtil.findByDateUpload(date_);
	}
	/**
	 * Returns a range of all the video entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByDateUpload(Date date_, int start, int end)
		throws SystemException {
		return VideoEntryUtil.findByDateUpload(date_, start, end);
	}
	/**
	 * Returns the number of video entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the number of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDateUpload(Date date_) throws SystemException {
		return VideoEntryUtil.countByDateUpload(date_);
	}
	
	/**
	 * Returns all the video entries where uploaderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId(long uploaderId)
		throws SystemException {
		return VideoEntryUtil.findByUploaderId(uploaderId);
	}
	/**
	 * Returns a range of all the video entries where uploaderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	
	public List<VideoEntry> findByUploaderId(long uploaderId, int start, int end)
		throws SystemException {
		return VideoEntryUtil.findByUploaderId(uploaderId, start, end);
	}
	/**
	 * Returns all the video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId_Folder(long uploaderId,
		long folderId) throws SystemException {
		return VideoEntryUtil.findByUploaderId_Folder(uploaderId, folderId);
	}
	/**
	 * Returns a range of all the video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId_Folder(long uploaderId,
		long folderId, int start, int end) throws SystemException {
		return VideoEntryUtil.findByUploaderId_Folder(uploaderId, folderId, start, end);
	}
	/**
	 * Returns the number of video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @return the number of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUploaderId_Folder(long uploaderId, long folderId)
		throws SystemException {
		return VideoEntryUtil.countByUploaderId_Folder(uploaderId, folderId);
	}
}