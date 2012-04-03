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
public class ServicePackageEntryLocalServiceClp
	implements ServicePackageEntryLocalService {
	public ServicePackageEntryLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addServicePackageEntryMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addServicePackageEntry",
				vn.com.fis.portal.model.ServicePackageEntry.class);

		_createServicePackageEntryMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createServicePackageEntry", long.class);

		_deleteServicePackageEntryMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteServicePackageEntry", long.class);

		_deleteServicePackageEntryMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteServicePackageEntry",
				vn.com.fis.portal.model.ServicePackageEntry.class);

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

		_fetchServicePackageEntryMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchServicePackageEntry", long.class);

		_getServicePackageEntryMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getServicePackageEntry", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getServicePackageEntriesMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getServicePackageEntries", int.class, int.class);

		_getServicePackageEntriesCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getServicePackageEntriesCount");

		_updateServicePackageEntryMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateServicePackageEntry",
				vn.com.fis.portal.model.ServicePackageEntry.class);

		_updateServicePackageEntryMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateServicePackageEntry",
				vn.com.fis.portal.model.ServicePackageEntry.class, boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_searchMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", java.lang.String.class, java.lang.String.class,
				long.class, int.class, int.class, int.class, int.class);

		_searchCountMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchCount", java.lang.String.class, java.lang.String.class,
				long.class, int.class, int.class);

		_findBystatusMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"findBystatus", int.class);

		_findByserviceIdMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByserviceId", long.class);

		_findByserviceId_StatusMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByserviceId_Status", long.class, int.class);

		_findByservicePackageCodeMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByservicePackageCode", java.lang.String.class);

		_findByservicePackageNameMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByservicePackageName", java.lang.String.class);
	}

	public vn.com.fis.portal.model.ServicePackageEntry addServicePackageEntry(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addServicePackageEntryMethodKey0,
				ClpSerializer.translateInput(servicePackageEntry));

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

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ServicePackageEntry createServicePackageEntry(
		long servicePackageId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createServicePackageEntryMethodKey1,
				servicePackageId);

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

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteServicePackageEntry(long servicePackageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteServicePackageEntryMethodKey2,
				servicePackageId);

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

	public void deleteServicePackageEntry(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteServicePackageEntryMethodKey3,
				ClpSerializer.translateInput(servicePackageEntry));

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

	public vn.com.fis.portal.model.ServicePackageEntry fetchServicePackageEntry(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchServicePackageEntryMethodKey8,
				servicePackageId);

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

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ServicePackageEntry getServicePackageEntry(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getServicePackageEntryMethodKey9,
				servicePackageId);

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

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<vn.com.fis.portal.model.ServicePackageEntry> getServicePackageEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getServicePackageEntriesMethodKey11,
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

		return (java.util.List<vn.com.fis.portal.model.ServicePackageEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int getServicePackageEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getServicePackageEntriesCountMethodKey12);

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

	public vn.com.fis.portal.model.ServicePackageEntry updateServicePackageEntry(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateServicePackageEntryMethodKey13,
				ClpSerializer.translateInput(servicePackageEntry));

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

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ServicePackageEntry updateServicePackageEntry(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateServicePackageEntryMethodKey14,
				ClpSerializer.translateInput(servicePackageEntry), merge);

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

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
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

	public java.util.List<vn.com.fis.portal.model.ServicePackageEntry> search(
		java.lang.String ser_pacCode, java.lang.String ser_pacName,
		long serviceId, int status, int start, int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey17,
				ClpSerializer.translateInput(ser_pacCode),
				ClpSerializer.translateInput(ser_pacName), serviceId, status,
				start, end, searchTypeFlag);

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

		return (java.util.List<vn.com.fis.portal.model.ServicePackageEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int searchCount(java.lang.String ser_pacCode,
		java.lang.String ser_pacName, long serviceId, int status,
		int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchCountMethodKey18,
				ClpSerializer.translateInput(ser_pacCode),
				ClpSerializer.translateInput(ser_pacName), serviceId, status,
				searchTypeFlag);

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

	public java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findBystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findBystatusMethodKey19,
				status);

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

		return (java.util.List<vn.com.fis.portal.model.ServicePackageEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByserviceIdMethodKey20,
				serviceId);

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

		return (java.util.List<vn.com.fis.portal.model.ServicePackageEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.com.fis.portal.model.ServicePackageEntry> findByserviceId_Status(
		long serviceId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByserviceId_StatusMethodKey21,
				serviceId, status);

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

		return (java.util.List<vn.com.fis.portal.model.ServicePackageEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ServicePackageEntry findByservicePackageCode(
		java.lang.String servicePackageCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByservicePackageCodeMethodKey22,
				ClpSerializer.translateInput(servicePackageCode));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof vn.com.fis.portal.NoSuchServicePackageEntryException) {
				throw (vn.com.fis.portal.NoSuchServicePackageEntryException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ServicePackageEntry findByservicePackageName(
		java.lang.String servicePackageName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServicePackageEntryException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByservicePackageNameMethodKey23,
				ClpSerializer.translateInput(servicePackageName));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof vn.com.fis.portal.NoSuchServicePackageEntryException) {
				throw (vn.com.fis.portal.NoSuchServicePackageEntryException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ServicePackageEntry)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addServicePackageEntryMethodKey0;
	private MethodKey _createServicePackageEntryMethodKey1;
	private MethodKey _deleteServicePackageEntryMethodKey2;
	private MethodKey _deleteServicePackageEntryMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchServicePackageEntryMethodKey8;
	private MethodKey _getServicePackageEntryMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getServicePackageEntriesMethodKey11;
	private MethodKey _getServicePackageEntriesCountMethodKey12;
	private MethodKey _updateServicePackageEntryMethodKey13;
	private MethodKey _updateServicePackageEntryMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _searchMethodKey17;
	private MethodKey _searchCountMethodKey18;
	private MethodKey _findBystatusMethodKey19;
	private MethodKey _findByserviceIdMethodKey20;
	private MethodKey _findByserviceId_StatusMethodKey21;
	private MethodKey _findByservicePackageCodeMethodKey22;
	private MethodKey _findByservicePackageNameMethodKey23;
}