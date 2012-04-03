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

		_findByTransactionCodeMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTransactionCode", long.class);

		_findByTransactionCodeMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTransactionCode", long.class, int.class, int.class);

		_countByTransactionCodeMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByTransactionCode", long.class);

		_findByDateMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByDate", java.util.Date.class);

		_findByDateMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByDate", java.util.Date.class, int.class, int.class);

		_countByDateMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByDate", java.util.Date.class);

		_findByTransactionCode_DateMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTransactionCode_Date", long.class, java.util.Date.class);

		_findByTransactionCode_DateMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByTransactionCode_Date", long.class, java.util.Date.class,
				int.class, int.class);

		_countByTransactionCode_DateMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByTransactionCode_Date", long.class, java.util.Date.class);

		_findByUserIdMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByUserId", long.class);

		_findByUserIdMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByUserId", long.class, int.class, int.class);

		_countByUserIdMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByUserId", long.class);

		_findByVideoIdMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByVideoId", long.class);

		_findByVideoIdMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByVideoId", long.class, int.class, int.class);

		_countByVideoIdMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByVideoId", long.class);

		_findByreceiverIdMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByreceiverId", long.class);

		_findByreceiverIdMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByreceiverId", long.class, int.class, int.class);

		_countByreceiverIdMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByreceiverId", long.class);
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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTransactionCodeMethodKey17,
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

		return (java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTransactionCodeMethodKey18,
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

	public int countByTransactionCode(long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTransactionCodeMethodKey19,
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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByDateMethodKey20,
				ClpSerializer.translateInput(date_));

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByDateMethodKey21,
				ClpSerializer.translateInput(date_), start, end);

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

	public int countByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByDateMethodKey22,
				ClpSerializer.translateInput(date_));

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTransactionCode_DateMethodKey23,
				transactionCode, ClpSerializer.translateInput(date_));

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByTransactionCode_DateMethodKey24,
				transactionCode, ClpSerializer.translateInput(date_), start, end);

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

	public int countByTransactionCode_Date(long transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByTransactionCode_DateMethodKey25,
				transactionCode, ClpSerializer.translateInput(date_));

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByUserIdMethodKey26,
				userId);

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByUserIdMethodKey27,
				userId, start, end);

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

	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByUserIdMethodKey28,
				userId);

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByVideoIdMethodKey29,
				videoId);

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByVideoIdMethodKey30,
				videoId, start, end);

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

	public int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByVideoIdMethodKey31,
				videoId);

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByreceiverIdMethodKey32,
				receiverId);

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

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByreceiverIdMethodKey33,
				receiverId, start, end);

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

	public int countByreceiverId(long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByreceiverIdMethodKey34,
				receiverId);

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
	private MethodKey _findByTransactionCodeMethodKey17;
	private MethodKey _findByTransactionCodeMethodKey18;
	private MethodKey _countByTransactionCodeMethodKey19;
	private MethodKey _findByDateMethodKey20;
	private MethodKey _findByDateMethodKey21;
	private MethodKey _countByDateMethodKey22;
	private MethodKey _findByTransactionCode_DateMethodKey23;
	private MethodKey _findByTransactionCode_DateMethodKey24;
	private MethodKey _countByTransactionCode_DateMethodKey25;
	private MethodKey _findByUserIdMethodKey26;
	private MethodKey _findByUserIdMethodKey27;
	private MethodKey _countByUserIdMethodKey28;
	private MethodKey _findByVideoIdMethodKey29;
	private MethodKey _findByVideoIdMethodKey30;
	private MethodKey _countByVideoIdMethodKey31;
	private MethodKey _findByreceiverIdMethodKey32;
	private MethodKey _findByreceiverIdMethodKey33;
	private MethodKey _countByreceiverIdMethodKey34;
}