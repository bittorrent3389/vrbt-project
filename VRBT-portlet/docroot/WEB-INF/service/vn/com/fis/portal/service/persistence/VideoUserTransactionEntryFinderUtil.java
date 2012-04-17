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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author loind
 */
public class VideoUserTransactionEntryFinderUtil {
	public static int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(transactionCode);
	}

	public static int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(transactionCode,
			startDate, endDate);
	}

	public static int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(uploadId,
			transactionCode);
	}

	public static int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,
			transactionCode, startDate, endDate);
	}

	public static int getCount_VideoUserTransaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_VideoUserTransaction_By_TransactionCode(transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getVideoUserTransaction_By_TransactionCode(transactionCode,
			start, end);
	}

	public static int getCount_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_VideoUserTransaction_By_transactionCode_And_Date(transactionCode,
			startDate, endDate);
	}

	public static int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_VideoUserTransaction_By_UserId_And_TransactionCode(uploadId,
			transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getVideoUserTransaction_By_UserId_And_TransactionCode(uploadId,
			transactionCode, start, end);
	}

	public static int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(uploadId,
			transactionCode, startDate, endDate);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getVideoUserTransaction_By_UploaderId_And_TransactionCode(uploadId,
			transactionCode, start, end);
	}

	public static int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,
			transactionCode, startDate, endDate);
	}

	public static int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(uploadId,
			transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode, int start, int end) {
		return getFinder()
				   .seachVideoUserTransactionEntryByCondition(userName,
			videoName, transactionCode, start, end);
	}

	public static int countSeachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countSeachVideoUserTransactionEntryByCondition(userName,
			videoName, transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName, int start,
		int end) {
		return getFinder()
				   .seachThirdPartyVideoUserTransactionEntryByCondition(trasactionCode,
			userId, videoName, start, end);
	}

	public static int countSeachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countSeachThirdPartyVideoUserTransactionEntryByCondition(trasactionCode,
			userId, videoName);
	}

	public static VideoUserTransactionEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (VideoUserTransactionEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoUserTransactionEntryFinder.class.getName());

			ReferenceRegistry.registerReference(VideoUserTransactionEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VideoUserTransactionEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VideoUserTransactionEntryFinderUtil.class,
			"_finder");
	}

	private static VideoUserTransactionEntryFinder _finder;
}