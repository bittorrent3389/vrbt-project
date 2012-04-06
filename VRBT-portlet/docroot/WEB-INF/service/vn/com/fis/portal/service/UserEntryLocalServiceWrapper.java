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
 * This class is a wrapper for {@link UserEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       UserEntryLocalService
 * @generated
 */
public class UserEntryLocalServiceWrapper implements UserEntryLocalService,
	ServiceWrapper<UserEntryLocalService> {
	public UserEntryLocalServiceWrapper(
		UserEntryLocalService userEntryLocalService) {
		_userEntryLocalService = userEntryLocalService;
	}

	/**
	* Adds the user entry to the database. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @return the user entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry addUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.addUserEntry(userEntry);
	}

	/**
	* Creates a new user entry with the primary key. Does not add the user entry to the database.
	*
	* @param userId the primary key for the new user entry
	* @return the new user entry
	*/
	public vn.com.fis.portal.model.UserEntry createUserEntry(long userId) {
		return _userEntryLocalService.createUserEntry(userId);
	}

	/**
	* Deletes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the user entry
	* @throws PortalException if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserEntry(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_userEntryLocalService.deleteUserEntry(userId);
	}

	/**
	* Deletes the user entry from the database. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteUserEntry(vn.com.fis.portal.model.UserEntry userEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_userEntryLocalService.deleteUserEntry(userEntry);
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
		return _userEntryLocalService.dynamicQuery(dynamicQuery);
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
		return _userEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _userEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _userEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.UserEntry fetchUserEntry(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.fetchUserEntry(userId);
	}

	/**
	* Returns the user entry with the primary key.
	*
	* @param userId the primary key of the user entry
	* @return the user entry
	* @throws PortalException if a user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry getUserEntry(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.getUserEntry(userId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<vn.com.fis.portal.model.UserEntry> getUserEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.getUserEntries(start, end);
	}

	/**
	* Returns the number of user entries.
	*
	* @return the number of user entries
	* @throws SystemException if a system exception occurred
	*/
	public int getUserEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.getUserEntriesCount();
	}

	/**
	* Updates the user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @return the user entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry updateUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.updateUserEntry(userEntry);
	}

	/**
	* Updates the user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userEntry the user entry
	* @param merge whether to merge the user entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry updateUserEntry(
		vn.com.fis.portal.model.UserEntry userEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.updateUserEntry(userEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _userEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns the user entry where userName = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userName the user name
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByUserName(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		return _userEntryLocalService.findByUserName(userName);
	}

	/**
	* Removes the user entry where userName = &#63; from the database.
	*
	* @param userName the user name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		_userEntryLocalService.removeByUserName(userName);
	}

	/**
	* Returns the number of user entries where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserName(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.countByUserName(userName);
	}

	/**
	* Returns the user entry where mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param mobileNumber the mobile number
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByMobileNumber(
		java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		return _userEntryLocalService.findByMobileNumber(mobileNumber);
	}

	/**
	* Returns the number of user entries where mobileNumber = &#63;.
	*
	* @param mobileNumber the mobile number
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByMobileNumber(java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.countByMobileNumber(mobileNumber);
	}

	/**
	* Removes the user entry where mobileNumber = &#63; from the database.
	*
	* @param mobileNumber the mobile number
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMobileNumber(java.lang.String mobileNumber)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		_userEntryLocalService.removeByMobileNumber(mobileNumber);
	}

	/**
	* Returns the user entry where userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching user entry
	* @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.UserEntry findByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		return _userEntryLocalService.findByUserId(userId);
	}

	/**
	* Returns the number of user entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching user entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.countByUserId(userId);
	}

	/**
	* Removes the user entry where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchUserEntryException {
		_userEntryLocalService.removeByUserId(userId);
	}

	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.countByStatus(status);
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.countAll();
	}

	public java.util.List<vn.com.fis.portal.model.UserEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntryLocalService.findByStatus(status);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UserEntryLocalService getWrappedUserEntryLocalService() {
		return _userEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUserEntryLocalService(
		UserEntryLocalService userEntryLocalService) {
		_userEntryLocalService = userEntryLocalService;
	}

	public UserEntryLocalService getWrappedService() {
		return _userEntryLocalService;
	}

	public void setWrappedService(UserEntryLocalService userEntryLocalService) {
		_userEntryLocalService = userEntryLocalService;
	}

	private UserEntryLocalService _userEntryLocalService;
}