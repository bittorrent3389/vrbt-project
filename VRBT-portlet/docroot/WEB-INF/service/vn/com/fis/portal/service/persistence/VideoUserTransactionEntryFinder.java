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

package vn.com.fis.portal.service.persistence;

/**
 * @author loind
 */
public interface VideoUserTransactionEntryFinder {
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_VideoUserTransaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode, int start, int end);

	public int countSeachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName, int start,
		int end);

	public int countSeachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName)
		throws com.liferay.portal.kernel.exception.SystemException;
}