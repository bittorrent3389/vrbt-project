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
 * The utility for the service entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.ServiceEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see ServiceEntryLocalService
 * @see vn.com.fis.portal.service.base.ServiceEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.ServiceEntryLocalServiceImpl
 * @generated
 */
public class ServiceEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.ServiceEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the service entry to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceEntry the service entry
	* @return the service entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceEntry addServiceEntry(
		vn.com.fis.portal.model.ServiceEntry serviceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addServiceEntry(serviceEntry);
	}

	/**
	* Creates a new service entry with the primary key. Does not add the service entry to the database.
	*
	* @param serviceId the primary key for the new service entry
	* @return the new service entry
	*/
	public static vn.com.fis.portal.model.ServiceEntry createServiceEntry(
		long serviceId) {
		return getService().createServiceEntry(serviceId);
	}

	/**
	* Deletes the service entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceId the primary key of the service entry
	* @throws PortalException if a service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteServiceEntry(long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteServiceEntry(serviceId);
	}

	/**
	* Deletes the service entry from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceEntry the service entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteServiceEntry(
		vn.com.fis.portal.model.ServiceEntry serviceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteServiceEntry(serviceEntry);
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

	public static vn.com.fis.portal.model.ServiceEntry fetchServiceEntry(
		long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchServiceEntry(serviceId);
	}

	/**
	* Returns the service entry with the primary key.
	*
	* @param serviceId the primary key of the service entry
	* @return the service entry
	* @throws PortalException if a service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceEntry getServiceEntry(
		long serviceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceEntry(serviceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of service entries
	* @param end the upper bound of the range of service entries (not inclusive)
	* @return the range of service entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ServiceEntry> getServiceEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceEntries(start, end);
	}

	/**
	* Returns the number of service entries.
	*
	* @return the number of service entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getServiceEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getServiceEntriesCount();
	}

	/**
	* Updates the service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceEntry the service entry
	* @return the service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceEntry updateServiceEntry(
		vn.com.fis.portal.model.ServiceEntry serviceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateServiceEntry(serviceEntry);
	}

	/**
	* Updates the service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceEntry the service entry
	* @param merge whether to merge the service entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ServiceEntry updateServiceEntry(
		vn.com.fis.portal.model.ServiceEntry serviceEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateServiceEntry(serviceEntry, merge);
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

	public static java.util.List<vn.com.fis.portal.model.ServiceEntry> search(
		java.lang.String serviceCode, java.lang.String serviceName, int status,
		int start, int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(serviceCode, serviceName, status, start, end,
			searchTypeFlag);
	}

	public static int searchCount(java.lang.String serviceCode,
		java.lang.String serviceName, int status, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .searchCount(serviceCode, serviceName, status, searchTypeFlag);
	}

	public static boolean isStartService(java.lang.String serviceCode) {
		return getService().isStartService(serviceCode);
	}

	public static java.lang.String getStartServiceCode() {
		return getService().getStartServiceCode();
	}

	public static java.lang.String getUploadServicePackageCode() {
		return getService().getUploadServicePackageCode();
	}

	public static java.util.List<vn.com.fis.portal.model.ServiceEntry> findBystatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findBystatus(status);
	}

	public static vn.com.fis.portal.model.ServiceEntry findByserviceCode(
		java.lang.String serviceCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException {
		return getService().findByserviceCode(serviceCode);
	}

	public static vn.com.fis.portal.model.ServiceEntry findByserviceName(
		java.lang.String serviceName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchServiceEntryException {
		return getService().findByserviceName(serviceName);
	}

	public static int countByserviceCode(java.lang.String serviceCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByserviceCode(serviceCode);
	}

	public static int countBystatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countBystatus(status);
	}

	public static void clearService() {
		_service = null;
	}

	public static ServiceEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ServiceEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ServiceEntryLocalService.class.getName(), portletClassLoader);

			_service = new ServiceEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ServiceEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ServiceEntryLocalService.class);
		}

		return _service;
	}

	public void setService(ServiceEntryLocalService service) {
		MethodCache.remove(ServiceEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ServiceEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ServiceEntryLocalService.class);
	}

	private static ServiceEntryLocalService _service;
}