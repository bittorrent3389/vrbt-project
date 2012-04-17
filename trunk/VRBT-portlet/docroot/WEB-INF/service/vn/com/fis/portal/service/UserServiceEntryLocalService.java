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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the user service entry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see UserServiceEntryLocalServiceUtil
 * @see vn.com.fis.portal.service.base.UserServiceEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.UserServiceEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserServiceEntryLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserServiceEntryLocalServiceUtil} to access the user service entry local service. Add custom service methods to {@link vn.com.fis.portal.service.impl.UserServiceEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the user service entry to the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @return the user service entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry addUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new user service entry with the primary key. Does not add the user service entry to the database.
	*
	* @param userServiceId the primary key for the new user service entry
	* @return the new user service entry
	*/
	public vn.com.fis.portal.model.UserServiceEntry createUserServiceEntry(
		long userServiceId);

	/**
	* Deletes the user service entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceId the primary key of the user service entry
	* @throws PortalException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserServiceEntry(long userServiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the user service entry from the database. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.UserServiceEntry fetchUserServiceEntry(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user service entry with the primary key.
	*
	* @param userServiceId the primary key of the user service entry
	* @return the user service entry
	* @throws PortalException if a user service entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.UserServiceEntry getUserServiceEntry(
		long userServiceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.UserServiceEntry> getUserServiceEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user service entries.
	*
	* @return the number of user service entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserServiceEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the user service entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userServiceEntry the user service entry
	* @return the user service entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserServiceEntry updateUserServiceEntry(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId_PackageId(
		long userId, long serviceId, long servicePackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;

	public vn.com.fis.portal.model.UserServiceEntry findByUserId_ServiceId(
		long userId, long serviceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserServiceEntryException;
}