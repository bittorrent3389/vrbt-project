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
import vn.com.fis.portal.service.persistence.VideoUserTransactionEntryFinderUtil;
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
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(long transactionCode)
	{
		try {
			return VideoUserTransactionEntryFinderUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(transactionCode);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(long transactionCode,String startDate,String endDate)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(transactionCode, startDate, endDate);
	}
	
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(long uploadId,long transactionCode)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(uploadId,transactionCode);
	}
	
	public int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(long uploadId,long transactionCode,String startDate,String endDate)

			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,transactionCode,startDate,endDate);
	}

	public int getCount_VideoUserTransaction_By_TransactionCode(long transactionCode)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_TransactionCode(transactionCode);
	}
	
	public List<VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(long transactionCode,int start,int end)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getVideoUserTransaction_By_TransactionCode(transactionCode,start,end);
	}
	
	public int getCount_VideoUserTransaction_By_transactionCode_And_Date(long transactionCode,String startDate,String endDate)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_transactionCode_And_Date(transactionCode,startDate,endDate);
	}
	
	public int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(long uploadId,long transactionCode)
			throws SystemException {
		
		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_UserId_And_TransactionCode(uploadId,transactionCode);
	}
	
	public List<VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(long uploadId,long transactionCode,int start,int end)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getVideoUserTransaction_By_UserId_And_TransactionCode(uploadId,transactionCode,start,end);
	}

	public int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(long uploadId,long transactionCode,String startDate,String endDate)
			throws SystemException
	{
//		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,transactionCode,start,end);
		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(uploadId,transactionCode,startDate,endDate);
	}
	
	public List<VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(long uploadId,long transactionCode,int start,int end)
			throws SystemException {
		return VideoUserTransactionEntryFinderUtil.getVideoUserTransaction_By_UploaderId_And_TransactionCode(uploadId,transactionCode,start,end);
	}
	public int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(long uploadId,long transactionCode,String startDate,String endDate)
			throws SystemException
	{
//		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,transactionCode,start,end);
		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,transactionCode,startDate,endDate);
	}
	public int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(long uploadId,long transactionCode)
			throws SystemException {
		
		return VideoUserTransactionEntryFinderUtil.getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(uploadId,transactionCode);
	}
	
	public List<VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(String userName, String videoName, String transactionCode,int start, int end)
			throws SystemException {
		
		return VideoUserTransactionEntryFinderUtil.seachVideoUserTransactionEntryByCondition(userName,videoName,transactionCode,start,end);
	}
	
	public int countSeachVideoUserTransactionEntryByCondition(String userName, String videoName, String transactionCode)
			throws SystemException {
		
		return VideoUserTransactionEntryFinderUtil.countSeachVideoUserTransactionEntryByCondition(userName,videoName,transactionCode);
	}
	
	public List<VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(int trasactionCode, long userId, String videoName, int start,int end)
			throws SystemException {
		
		return VideoUserTransactionEntryFinderUtil.seachThirdPartyVideoUserTransactionEntryByCondition(trasactionCode, userId, videoName, start,end);
	}
	public int countSeachThirdPartyVideoUserTransactionEntryByCondition(int trasactionCode, long userId, String videoName)
			throws SystemException {
		
		return VideoUserTransactionEntryFinderUtil.countSeachThirdPartyVideoUserTransactionEntryByCondition(trasactionCode, userId, videoName);
	}
}