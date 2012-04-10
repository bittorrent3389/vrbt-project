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
 * The utility for the user service entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.UserServiceEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see UserServiceEntryLocalService
 * @see vn.com.fis.portal.service.base.UserServiceEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.UserServiceEntryLocalServiceImpl
 * @generated
 */
public class UserServiceEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.UserServiceEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user service entry to the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @return the user service entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry addUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserServiceEntry(userServiceEntry);
	}

	/**
	* Creates a new user service entry with the primary key. Does not add the user service entry to the database.
	*
	* @param userServiceId the primary key for the new user service entry
	* @return the new user service entry
	*/
	public static vn.com.fis.portal.model.UserServiceEntry createUserServiceEntry(
		long userServiceId) {
		return getService().createUserServiceEntry(userServiceId);
	}

	/**
	* Deletes the user service entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceId the primary key of the user service entry
	* @throws PortalException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserServiceEntry(long userServiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserServiceEntry(userServiceId);
	}

	/**
	* Deletes the user service entry from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserServiceEntry(userServiceEntry);
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

	public static vn.com.fis.portal.model.UserServiceEntry fetchUserServiceEntry(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserServiceEntry(userServiceId);
	}

	/**
	* Returns the user service entry with the primary key.
	*
	* @param userServiceId the primary key of the user service entry
	* @return the user service entry
	* @throws PortalException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry getUserServiceEntry(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserServiceEntry(userServiceId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user service entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user service entries
	* @param end the upper bound of the range of user service entries (not inclusive)
	* @return the range of user service entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.UserServiceEntry> getUserServiceEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserServiceEntries(start, end);
	}

	/**
	* Returns the number of user service entries.
	*
	* @return the number of user service entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserServiceEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserServiceEntriesCount();
	}

	/**
	* Updates the user service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @return the user service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry updateUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserServiceEntry(userServiceEntry);
	}

	/**
	* Updates the user service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @param merge whether to merge the user service entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry updateUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserServiceEntry(userServiceEntry, merge);
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
	* returns the user service entry where userId = &#63; and serviceId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @return the matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId(
		long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return getService().findByUserId_ServiceId(userId, serviceId);
	}

	/**
	* Removes the user service entry where userId = &#63; and serviceId = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_ServiceId(long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		getService().removeByUserId_ServiceId(userId, serviceId);
	}

	/**
	* Returns the number of user service entries where userId = &#63; and serviceId = &#63;.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_ServiceId(long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId_ServiceId(userId, serviceId);
	}

	/**
	* Returns the user service entry where userId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @return the matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry findByUserId_ServicePackageId(
		long userId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return getService()
				   .findByUserId_ServicePackageId(userId, servicePackageId);
	}

	/**
	* Removes the user service entry where userId = &#63; and servicePackageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		getService().removeByUserId_ServicePackageId(userId, servicePackageId);
	}

	/**
	* Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @return the matching user service entry
	* @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId_PackageId(
		long userId, long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return getService()
				   .findByUserId_ServiceId_PackageId(userId, serviceId,
			servicePackageId);
	}

	/**
	* Returns the number of user service entries where userId = &#63; and serviceId = &#63; and servicePackageId = &#63;.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_ServiceId_PackageId(long userId,
		long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByUserId_ServiceId_PackageId(userId, serviceId,
			servicePackageId);
	}

	/**
	* Removes the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_ServiceId_PackageId(long userId,
		long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		getService()
			.removeByUserId_ServiceId_PackageId(userId, serviceId,
			servicePackageId);
	}

	public static java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByUserId_serviceStatus(
		long userId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return getService().findByUserId_serviceStatus(userId, serviceStatus);
	}

	public static java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByuserId(userId);
	}

	public static java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByservicePackageId(
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByservicePackageId(servicePackageId);
	}

	public static java.util.List<vn.com.fis.portal.model.UserServiceEntry> findByserviceId_ServiceStatus(
		long serviceId, int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByserviceId_ServiceStatus(serviceId, serviceStatus);
	}

	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByuserId(userId);
	}

	public static int countByservicePackageId(long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByservicePackageId(servicePackageId);
	}

	public static int countByserviceId_ServiceStatus(long serviceId,
		int serviceStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByserviceId_ServiceStatus(serviceId, serviceStatus);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserServiceEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserServiceEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					UserServiceEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new UserServiceEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(UserServiceEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(UserServiceEntryLocalService.class);
		}

		return _service;
	}

	public void setService(UserServiceEntryLocalService service) {
		MethodCache.remove(UserServiceEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(UserServiceEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(UserServiceEntryLocalService.class);
	}

	private static UserServiceEntryLocalService _service;
}