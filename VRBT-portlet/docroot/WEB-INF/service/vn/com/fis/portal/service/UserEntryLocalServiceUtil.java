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
 * The utility for the user entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.UserEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see UserEntryLocalService
 * @see vn.com.fis.portal.service.base.UserEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.UserEntryLocalServiceImpl
 * @generated
 */
public class UserEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.UserEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the user entry to the database. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @return the user entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry addUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserEntry(userEntry);
	}

	/**
	* Creates a new user entry with the primary key. Does not add the user entry to the database.
	*
	* @param userId the primary key for the new user entry
	* @return the new user entry
	*/
	public static vn.com.fis.portal.model.UserEntry createUserEntry(long userId) {
		return getService().createUserEntry(userId);
	}

	/**
	* Deletes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user entry
	* @throws PortalException if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserEntry(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserEntry(userId);
	}

	/**
	* Deletes the user entry from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserEntry(userEntry);
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

	public static vn.com.fis.portal.model.UserEntry fetchUserEntry(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchUserEntry(userId);
	}

	/**
	* Returns the user entry with the primary key.
	*
	* @param userId the primary key of the user entry
	* @return the user entry
	* @throws PortalException if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry getUserEntry(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEntry(userId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the user entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user entries
	* @param end the upper bound of the range of user entries (not inclusive)
	* @return the range of user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.UserEntry> getUserEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEntries(start, end);
	}

	/**
	* Returns the number of user entries.
	*
	* @return the number of user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserEntriesCount();
	}

	/**
	* Updates the user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @return the user entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry updateUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserEntry(userEntry);
	}

	/**
	* Updates the user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @param merge whether to merge the user entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry updateUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserEntry(userEntry, merge);
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
	* Returns the user entry where userName = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userName the user name
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry findByUserName(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		return getService().findByUserName(userName);
	}

	/**
	* Removes the user entry where userName = &#63; from the database.
	*
	* @param userName the user name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		getService().removeByUserName(userName);
	}

	/**
	* Returns the number of user entries where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserName(userName);
	}

	/**
	* Returns the user entry where mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param mobileNumber the mobile number
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry findByMobileNumber(
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		return getService().findByMobileNumber(mobileNumber);
	}

	/**
	* Returns the number of user entries where mobileNumber = &#63;.
	*
	* @param mobileNumber the mobile number
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMobileNumber(java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByMobileNumber(mobileNumber);
	}

	/**
	* Removes the user entry where mobileNumber = &#63; from the database.
	*
	* @param mobileNumber the mobile number
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMobileNumber(java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		getService().removeByMobileNumber(mobileNumber);
	}

	/**
	* Returns the user entry where userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.UserEntry findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		return getService().findByUserId(userId);
	}

	/**
	* Returns the number of user entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId(userId);
	}

	/**
	* Removes the user entry where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		getService().removeByUserId(userId);
	}

	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByStatus(status);
	}

	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countAll();
	}

	public static java.util.List<vn.com.fis.portal.model.UserEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus(status);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					UserEntryLocalService.class.getName(), portletClassLoader);

			_service = new UserEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(UserEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(UserEntryLocalService.class);
		}

		return _service;
	}

	public void setService(UserEntryLocalService service) {
		MethodCache.remove(UserEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(UserEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(UserEntryLocalService.class);
	}

	private static UserEntryLocalService _service;
}