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
import vn.com.fis.portal.service.persistence.VideoEntryFinderUtil;
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
	public List<VideoEntry> searchVideoByCategory(long categoryId ,int start , int end)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByCategory(categoryId, start, end);
	}
	public int searchVideoByCategoryCount(long categoryId )throws SystemException{
		return VideoEntryFinderUtil.searchVideoByCategoryCount(categoryId);
	}
	
	public List<VideoEntry> searchVideoByCategory_User(long categoryId, long userId ,int start , int end,boolean andOperator)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByCategory_User(categoryId, userId, start, end, andOperator);
	}
			
	
	public int searchVideoByCategory_User_Count(long categoryId,long userId,boolean andOperator )throws SystemException{
		return VideoEntryFinderUtil.searchVideoByCategory_User_Count(categoryId, userId, andOperator);
	}
	public List<VideoEntry> searchVideoByCategory_OtherUser(long categoryId, long userId ,int start , int end,boolean andOperator)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByCategory_OtherUser(categoryId, userId, start, end, andOperator);
	}
	public int searchVideoByCategory_OtherUser_Count(long categoryId,long userId,boolean andOperator )throws SystemException{
		return VideoEntryFinderUtil.searchVideoByCategory_OtherUser_Count(categoryId, userId, andOperator);
	}
	public List<VideoEntry> searchVideoByUser(long userId ,int start , int end,boolean andOperator)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByUser(userId, start, end, andOperator);
	}
	public int searchVideoByUserCount(long userId,boolean andOperator )throws SystemException{
		return VideoEntryFinderUtil.searchVideoByUserCount(userId, andOperator);
	}
	public List<VideoEntry> searchVideoByVideoName_Folder_User(String videoName, long folderId,long userId ,int start , int end)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByVideoName_Folder_User(videoName, folderId, userId, start, end);
	}
	public int searchVideoByVideoName_Folder_User_Count(String videoName, long folderId,long userId  )throws SystemException{
		return VideoEntryFinderUtil.searchVideoByVideoName_Folder_User_Count(videoName, folderId, userId);
	}
	public List<VideoEntry> searchVideoByVideoName_OriginCode_ServiceActive(String videoName,int originCode, int serviceActive,long userId ,int start , int end)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByVideoName_OriginCode_ServiceActive(videoName, originCode, serviceActive, userId, start, end);
	}
	
	public int searchVideoByVideoName_OriginCode_ServiceActive_Count(String videoName,int originCode, int serviceActive,long userId)throws SystemException{
		return VideoEntryFinderUtil.searchVideoByVideoName_OriginCode_ServiceActive_Count(videoName, originCode, serviceActive, userId);
	}
}