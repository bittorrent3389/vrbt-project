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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserServiceEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       UserServiceEntryLocalService
 * @generated
 */
public class UserServiceEntryLocalServiceWrapper
	implements UserServiceEntryLocalService,
		ServiceWrapper<UserServiceEntryLocalService> {
	public UserServiceEntryLocalServiceWrapper(
		UserServiceEntryLocalService userServiceEntryLocalService) {
		_userServiceEntryLocalService = userServiceEntryLocalService;
	}

	/**
	* Adds the user service entry to the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @return the user service entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry addUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.addUserServiceEntry(userServiceEntry);
	}

	/**
	* Creates a new user service entry with the primary key. Does not add the user service entry to the database.
	*
	* @param userServiceId the primary key for the new user service entry
	* @return the new user service entry
	*/
	public vn.com.fis.portal.model.UserServiceEntry createUserServiceEntry(
		long userServiceId) {
		return _userServiceEntryLocalService.createUserServiceEntry(userServiceId);
	}

	/**
	* Deletes the user service entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceId the primary key of the user service entry
	* @throws PortalException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserServiceEntry(long userServiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userServiceEntryLocalService.deleteUserServiceEntry(userServiceId);
	}

	/**
	* Deletes the user service entry from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userServiceEntryLocalService.deleteUserServiceEntry(userServiceEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.UserServiceEntry fetchUserServiceEntry(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.fetchUserServiceEntry(userServiceId);
	}

	/**
	* Returns the user service entry with the primary key.
	*
	* @param userServiceId the primary key of the user service entry
	* @return the user service entry
	* @throws PortalException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry getUserServiceEntry(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.getUserServiceEntry(userServiceId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> getUserServiceEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.getUserServiceEntries(start, end);
	}

	/**
	* Returns the number of user service entries.
	*
	* @return the number of user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int getUserServiceEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.getUserServiceEntriesCount();
	}

	/**
	* Updates the user service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @return the user service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry updateUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.updateUserServiceEntry(userServiceEntry);
	}

	/**
	* Updates the user service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @param merge whether to merge the user service entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry updateUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.updateUserServiceEntry(userServiceEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userServiceEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userServiceEntryLocalService.setBeanIdentifier(beanIdentifier);
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
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId(
		long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return _userServiceEntryLocalService.findByUserId_ServiceId(userId,
			serviceId);
	}

	/**
	* Removes the user service entry where userId = &#63; and serviceId = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ServiceId(long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		_userServiceEntryLocalService.removeByUserId_ServiceId(userId, serviceId);
	}

	/**
	* Returns the number of user service entries where userId = &#63; and serviceId = &#63;.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @return the number of matching user service entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId_ServiceId(long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.countByUserId_ServiceId(userId,
			serviceId);
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
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServicePackageId(
		long userId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return _userServiceEntryLocalService.findByUserId_ServicePackageId(userId,
			servicePackageId);
	}

	/**
	* Removes the user service entry where userId = &#63; and servicePackageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		_userServiceEntryLocalService.removeByUserId_ServicePackageId(userId,
			servicePackageId);
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
	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId_PackageId(
		long userId, long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		return _userServiceEntryLocalService.findByUserId_ServiceId_PackageId(userId,
			serviceId, servicePackageId);
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
	public int countByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntryLocalService.countByUserId_ServiceId_PackageId(userId,
			serviceId, servicePackageId);
	}

	/**
	* Removes the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; from the database.
	*
	* @param userId the user ID
	* @param serviceId the service ID
	* @param servicePackageId the service package ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException {
		_userServiceEntryLocalService.removeByUserId_ServiceId_PackageId(userId,
			serviceId, servicePackageId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserServiceEntryLocalService getWrappedUserServiceEntryLocalService() {
		return _userServiceEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserServiceEntryLocalService(
		UserServiceEntryLocalService userServiceEntryLocalService) {
		_userServiceEntryLocalService = userServiceEntryLocalService;
	}

	public UserServiceEntryLocalService getWrappedService() {
		return _userServiceEntryLocalService;
	}

	public void setWrappedService(
		UserServiceEntryLocalService userServiceEntryLocalService) {
		_userServiceEntryLocalService = userServiceEntryLocalService;
	}

	private UserServiceEntryLocalService _userServiceEntryLocalService;
}