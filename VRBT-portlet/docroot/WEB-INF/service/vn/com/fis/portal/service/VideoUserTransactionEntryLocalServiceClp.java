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

package vn.com.fis.portal.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author loind
 */
public class VideoUserTransactionEntryLocalServiceClp
	implements VideoUserTransactionEntryLocalService {
	public VideoUserTransactionEntryLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addVideoUserTransactionEntryMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addVideoUserTransactionEntry",
				vn.com.fis.portal.model.VideoUserTransactionEntry.class);

		_createVideoUserTransactionEntryMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createVideoUserTransactionEntry", long.class);

		_deleteVideoUserTransactionEntryMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteVideoUserTransactionEntry", long.class);

		_deleteVideoUserTransactionEntryMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteVideoUserTransactionEntry",
				vn.com.fis.portal.model.VideoUserTransactionEntry.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchVideoUserTransactionEntryMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchVideoUserTransactionEntry", long.class);

		_getVideoUserTransactionEntryMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getVideoUserTransactionEntry", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getVideoUserTransactionEntriesMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getVideoUserTransactionEntries", int.class, int.class);

		_getVideoUserTransactionEntriesCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getVideoUserTransactionEntriesCount");

		_updateVideoUserTransactionEntryMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateVideoUserTransactionEntry",
				vn.com.fis.portal.model.VideoUserTransactionEntry.class);

		_updateVideoUserTransactionEntryMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateVideoUserTransactionEntry",
				vn.com.fis.portal.model.VideoUserTransactionEntry.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCodeMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode",
				long.class);

		_getCount_Destinct_VideoUserTransaction_By_transactionCode_And_DateMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date",
				long.class, java.lang.String.class, java.lang.String.class);

		_getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCodeMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode",
				long.class, long.class);

		_getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_DateMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date",
				long.class, long.class, java.lang.String.class,
				java.lang.String.class);

		_getCount_VideoUserTransaction_By_TransactionCodeMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_VideoUserTransaction_By_TransactionCode", long.class);

		_getVideoUserTransaction_By_TransactionCodeMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getVideoUserTransaction_By_TransactionCode", long.class,
				int.class, int.class);

		_getCount_VideoUserTransaction_By_transactionCode_And_DateMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_VideoUserTransaction_By_transactionCode_And_Date",
				long.class, java.lang.String.class, java.lang.String.class);

		_getCount_VideoUserTransaction_By_UserId_And_TransactionCodeMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_VideoUserTransaction_By_UserId_And_TransactionCode",
				long.class, long.class);

		_getVideoUserTransaction_By_UserId_And_TransactionCodeMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getVideoUserTransaction_By_UserId_And_TransactionCode",
				long.class, long.class, int.class, int.class);

		_getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_DateMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date",
				long.class, long.class, java.lang.String.class,
				java.lang.String.class);

		_getVideoUserTransaction_By_UploaderId_And_TransactionCodeMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getVideoUserTransaction_By_UploaderId_And_TransactionCode",
				long.class, long.class, int.class, int.class);

		_getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_DateMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date",
				long.class, long.class, java.lang.String.class,
				java.lang.String.class);

		_getCount_VideoUserTransaction_By_UploaderId_And_TransactionCodeMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode",
				long.class, long.class);

		_seachVideoUserTransactionEntryByConditionMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"seachVideoUserTransactionEntryByCondition",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class);

		_countSeachVideoUserTransactionEntryByConditionMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"countSeachVideoUserTransactionEntryByCondition",
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class);

		_seachThirdPartyVideoUserTransactionEntryByConditionMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"seachThirdPartyVideoUserTransactionEntryByCondition",
				int.class, long.class, java.lang.String.class, int.class,
				int.class);

		_countSeachThirdPartyVideoUserTransactionEntryByConditionMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"countSeachThirdPartyVideoUserTransactionEntryByCondition",
				int.class, long.class, java.lang.String.class);
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry addVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addVideoUserTransactionEntryMethodKey0,
				ClpSerializer.translateInput(videoUserTransactionEntry));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.VideoUserTransactionEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry createVideoUserTransactionEntry(
		long transactionId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createVideoUserTransactionEntryMethodKey1,
				transactionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.VideoUserTransactionEntry)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteVideoUserTransactionEntry(long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteVideoUserTransactionEntryMethodKey2,
				transactionId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteVideoUserTransactionEntryMethodKey3,
				ClpSerializer.translateInput(videoUserTransactionEntry));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry fetchVideoUserTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchVideoUserTransactionEntryMethodKey8,
				transactionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.VideoUserTransactionEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry getVideoUserTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getVideoUserTransactionEntryMethodKey9,
				transactionId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.VideoUserTransactionEntry)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransactionEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getVideoUserTransactionEntriesMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int getVideoUserTransactionEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getVideoUserTransactionEntriesCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry updateVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateVideoUserTransactionEntryMethodKey13,
				ClpSerializer.translateInput(videoUserTransactionEntry));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.VideoUserTransactionEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.VideoUserTransactionEntry updateVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateVideoUserTransactionEntryMethodKey14,
				ClpSerializer.translateInput(videoUserTransactionEntry), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.VideoUserTransactionEntry)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(
		long transactionCode) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCodeMethodKey17,
				transactionCode);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_Destinct_VideoUserTransaction_By_transactionCode_And_DateMethodKey18,
				transactionCode, ClpSerializer.translateInput(startDate),
				ClpSerializer.translateInput(endDate));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCodeMethodKey19,
				uploadId, transactionCode);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_DateMethodKey20,
				uploadId, transactionCode,
				ClpSerializer.translateInput(startDate),
				ClpSerializer.translateInput(endDate));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int getCount_VideoUserTransaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_VideoUserTransaction_By_TransactionCodeMethodKey21,
				transactionCode);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getVideoUserTransaction_By_TransactionCodeMethodKey22,
				transactionCode, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCount_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_VideoUserTransaction_By_transactionCode_And_DateMethodKey23,
				transactionCode, ClpSerializer.translateInput(startDate),
				ClpSerializer.translateInput(endDate));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_VideoUserTransaction_By_UserId_And_TransactionCodeMethodKey24,
				uploadId, transactionCode);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getVideoUserTransaction_By_UserId_And_TransactionCodeMethodKey25,
				uploadId, transactionCode, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_DateMethodKey26,
				uploadId, transactionCode,
				ClpSerializer.translateInput(startDate),
				ClpSerializer.translateInput(endDate));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getVideoUserTransaction_By_UploaderId_And_TransactionCodeMethodKey27,
				uploadId, transactionCode, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_DateMethodKey28,
				uploadId, transactionCode,
				ClpSerializer.translateInput(startDate),
				ClpSerializer.translateInput(endDate));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCount_VideoUserTransaction_By_UploaderId_And_TransactionCodeMethodKey29,
				uploadId, transactionCode);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_seachVideoUserTransactionEntryByConditionMethodKey30,
				ClpSerializer.translateInput(userName),
				ClpSerializer.translateInput(videoName),
				ClpSerializer.translateInput(transactionCode), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int countSeachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countSeachVideoUserTransactionEntryByConditionMethodKey31,
				ClpSerializer.translateInput(userName),
				ClpSerializer.translateInput(videoName),
				ClpSerializer.translateInput(transactionCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_seachThirdPartyVideoUserTransactionEntryByConditionMethodKey32,
				trasactionCode, userId,
				ClpSerializer.translateInput(videoName), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int countSeachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countSeachThirdPartyVideoUserTransactionEntryByConditionMethodKey33,
				trasactionCode, userId, ClpSerializer.translateInput(videoName));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addVideoUserTransactionEntryMethodKey0;
	private MethodKey _createVideoUserTransactionEntryMethodKey1;
	private MethodKey _deleteVideoUserTransactionEntryMethodKey2;
	private MethodKey _deleteVideoUserTransactionEntryMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchVideoUserTransactionEntryMethodKey8;
	private MethodKey _getVideoUserTransactionEntryMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getVideoUserTransactionEntriesMethodKey11;
	private MethodKey _getVideoUserTransactionEntriesCountMethodKey12;
	private MethodKey _updateVideoUserTransactionEntryMethodKey13;
	private MethodKey _updateVideoUserTransactionEntryMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCodeMethodKey17;
	private MethodKey _getCount_Destinct_VideoUserTransaction_By_transactionCode_And_DateMethodKey18;
	private MethodKey _getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCodeMethodKey19;
	private MethodKey _getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_DateMethodKey20;
	private MethodKey _getCount_VideoUserTransaction_By_TransactionCodeMethodKey21;
	private MethodKey _getVideoUserTransaction_By_TransactionCodeMethodKey22;
	private MethodKey _getCount_VideoUserTransaction_By_transactionCode_And_DateMethodKey23;
	private MethodKey _getCount_VideoUserTransaction_By_UserId_And_TransactionCodeMethodKey24;
	private MethodKey _getVideoUserTransaction_By_UserId_And_TransactionCodeMethodKey25;
	private MethodKey _getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_DateMethodKey26;
	private MethodKey _getVideoUserTransaction_By_UploaderId_And_TransactionCodeMethodKey27;
	private MethodKey _getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_DateMethodKey28;
	private MethodKey _getCount_VideoUserTransaction_By_UploaderId_And_TransactionCodeMethodKey29;
	private MethodKey _seachVideoUserTransactionEntryByConditionMethodKey30;
	private MethodKey _countSeachVideoUserTransactionEntryByConditionMethodKey31;
	private MethodKey _seachThirdPartyVideoUserTransactionEntryByConditionMethodKey32;
	private MethodKey _countSeachThirdPartyVideoUserTransactionEntryByConditionMethodKey33;
}