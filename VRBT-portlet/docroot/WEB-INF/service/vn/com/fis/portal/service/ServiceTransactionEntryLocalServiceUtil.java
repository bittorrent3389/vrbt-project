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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the service transaction entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.ServiceTransactionEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see ServiceTransactionEntryLocalService
 * @see vn.com.fis.portal.service.base.ServiceTransactionEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.ServiceTransactionEntryLocalServiceImpl
 * @generated
 */
public class ServiceTransactionEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.ServiceTransactionEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the service transaction entry to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceTransactionEntry the service transaction entry
	* @return the service transaction entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry addServiceTransactionEntry(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addServiceTransactionEntry(serviceTransactionEntry);
	}

	/**
	* Creates a new service transaction entry with the primary key. Does not add the service transaction entry to the database.
	*
	* @param transactionId the primary key for the new service transaction entry
	* @return the new service transaction entry
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry createServiceTransactionEntry(
		long transactionId) {
		return getService().createServiceTransactionEntry(transactionId);
	}

	/**
	* Deletes the service transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the service transaction entry
	* @throws PortalException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteServiceTransactionEntry(long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteServiceTransactionEntry(transactionId);
	}

	/**
	* Deletes the service transaction entry from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceTransactionEntry the service transaction entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteServiceTransactionEntry(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteServiceTransactionEntry(serviceTransactionEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static vn.com.fis.portal.model.ServiceTransactionEntry fetchServiceTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchServiceTransactionEntry(transactionId);
	}

	/**
	* Returns the service transaction entry with the primary key.
	*
	* @param transactionId the primary key of the service transaction entry
	* @return the service transaction entry
	* @throws PortalException if a service transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry getServiceTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceTransactionEntry(transactionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service transaction entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> getServiceTransactionEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceTransactionEntries(start, end);
	}

	/**
	* Returns the number of service transaction entries.
	*
	* @return the number of service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getServiceTransactionEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceTransactionEntriesCount();
	}

	/**
	* Updates the service transaction entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceTransactionEntry the service transaction entry
	* @return the service transaction entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry updateServiceTransactionEntry(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateServiceTransactionEntry(serviceTransactionEntry);
	}

	/**
	* Updates the service transaction entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceTransactionEntry the service transaction entry
	* @param merge whether to merge the service transaction entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the service transaction entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceTransactionEntry updateServiceTransactionEntry(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateServiceTransactionEntry(serviceTransactionEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns all the service transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode(
		int transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTransactionCode(transactionCode);
	}

	/**
	* Returns the number of service transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransactionCode(int transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByTransactionCode(transactionCode);
	}

	/**
	* Returns all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Returns a range of all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByTransactionCode_Date(transactionCode, date_, start,
			end);
	}

	/**
	* Returns the number of service transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTransactionCode_Date(int transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByTransactionCode_Date(transactionCode, date_);
	}

	/**
	* Returns all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserId_TransactionCode_Date(userId, transactionCode,
			date_);
	}

	/**
	* Returns a range of all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of service transaction entries
	* @param end the upper bound of the range of service transaction entries (not inclusive)
	* @return the range of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, java.util.Date date_, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByUserId_TransactionCode_Date(userId, transactionCode,
			date_, start, end);
	}

	/**
	* Returns the number of service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	*
	* @param userId the user ID
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the number of matching service transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_TransactionCode_Date(long userId,
		int transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByUserId_TransactionCode_Date(userId, transactionCode,
			date_);
	}

	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> searchService(
		long transactionCode, long serviceId, long servicePackageId, int start,
		int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchService(transactionCode, serviceId, servicePackageId,
			start, end, searchTypeFlag);
	}

	public static int searchServiceCount(long transactionCode, long serviceId,
		long servicePackageId, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchServiceCount(transactionCode, serviceId,
			servicePackageId, searchTypeFlag);
	}

	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> searchServicePac(
		long transactionCode, long serviceId, long servicePackageId, int start,
		int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchServicePac(transactionCode, serviceId,
			servicePackageId, start, end, searchTypeFlag);
	}

	public static int searchServicePacCount(long transactionCode,
		long serviceId, long servicePackageId, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchServicePacCount(transactionCode, serviceId,
			servicePackageId, searchTypeFlag);
	}

	public static void clearService() {
		_service = null;
	}

	public static ServiceTransactionEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ServiceTransactionEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ServiceTransactionEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new ServiceTransactionEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ServiceTransactionEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ServiceTransactionEntryLocalService.class);
		}

		return _service;
	}

	public void setService(ServiceTransactionEntryLocalService service) {
		MethodCache.remove(ServiceTransactionEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ServiceTransactionEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ServiceTransactionEntryLocalService.class);
	}

	private static ServiceTransactionEntryLocalService _service;
}