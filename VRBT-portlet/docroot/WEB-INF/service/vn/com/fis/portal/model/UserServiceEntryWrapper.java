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

package vn.com.fis.portal.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UserServiceEntry}.
 * </p>
 *
 * @author    loind
 * @see       UserServiceEntry
 * @generated
 */
public class UserServiceEntryWrapper implements UserServiceEntry,
	ModelWrapper<UserServiceEntry> {
	public UserServiceEntryWrapper(UserServiceEntry userServiceEntry) {
		_userServiceEntry = userServiceEntry;
	}

	public Class<?> getModelClass() {
		return UserServiceEntry.class;
	}

	public String getModelClassName() {
		return UserServiceEntry.class.getName();
	}

	/**
	* Returns the primary key of this user service entry.
	*
	* @return the primary key of this user service entry
	*/
	public long getPrimaryKey() {
		return _userServiceEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user service entry.
	*
	* @param primaryKey the primary key of this user service entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_userServiceEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user service ID of this user service entry.
	*
	* @return the user service ID of this user service entry
	*/
	public long getUserServiceId() {
		return _userServiceEntry.getUserServiceId();
	}

	/**
	* Sets the user service ID of this user service entry.
	*
	* @param userServiceId the user service ID of this user service entry
	*/
	public void setUserServiceId(long userServiceId) {
		_userServiceEntry.setUserServiceId(userServiceId);
	}

	/**
	* Returns the user ID of this user service entry.
	*
	* @return the user ID of this user service entry
	*/
	public long getUserId() {
		return _userServiceEntry.getUserId();
	}

	/**
	* Sets the user ID of this user service entry.
	*
	* @param userId the user ID of this user service entry
	*/
	public void setUserId(long userId) {
		_userServiceEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user service entry.
	*
	* @return the user uuid of this user service entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userServiceEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this user service entry.
	*
	* @param userUuid the user uuid of this user service entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userServiceEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the service ID of this user service entry.
	*
	* @return the service ID of this user service entry
	*/
	public long getServiceId() {
		return _userServiceEntry.getServiceId();
	}

	/**
	* Sets the service ID of this user service entry.
	*
	* @param serviceId the service ID of this user service entry
	*/
	public void setServiceId(long serviceId) {
		_userServiceEntry.setServiceId(serviceId);
	}

	/**
	* Returns the service status of this user service entry.
	*
	* @return the service status of this user service entry
	*/
	public int getServiceStatus() {
		return _userServiceEntry.getServiceStatus();
	}

	/**
	* Sets the service status of this user service entry.
	*
	* @param serviceStatus the service status of this user service entry
	*/
	public void setServiceStatus(int serviceStatus) {
		_userServiceEntry.setServiceStatus(serviceStatus);
	}

	/**
	* Returns the service start date of this user service entry.
	*
	* @return the service start date of this user service entry
	*/
	public java.util.Date getServiceStartDate() {
		return _userServiceEntry.getServiceStartDate();
	}

	/**
	* Sets the service start date of this user service entry.
	*
	* @param serviceStartDate the service start date of this user service entry
	*/
	public void setServiceStartDate(java.util.Date serviceStartDate) {
		_userServiceEntry.setServiceStartDate(serviceStartDate);
	}

	/**
	* Returns the service stop date of this user service entry.
	*
	* @return the service stop date of this user service entry
	*/
	public java.util.Date getServiceStopDate() {
		return _userServiceEntry.getServiceStopDate();
	}

	/**
	* Sets the service stop date of this user service entry.
	*
	* @param serviceStopDate the service stop date of this user service entry
	*/
	public void setServiceStopDate(java.util.Date serviceStopDate) {
		_userServiceEntry.setServiceStopDate(serviceStopDate);
	}

	/**
	* Returns the service package ID of this user service entry.
	*
	* @return the service package ID of this user service entry
	*/
	public long getServicePackageId() {
		return _userServiceEntry.getServicePackageId();
	}

	/**
	* Sets the service package ID of this user service entry.
	*
	* @param servicePackageId the service package ID of this user service entry
	*/
	public void setServicePackageId(long servicePackageId) {
		_userServiceEntry.setServicePackageId(servicePackageId);
	}

	/**
	* Returns the package date of this user service entry.
	*
	* @return the package date of this user service entry
	*/
	public java.util.Date getPackageDate() {
		return _userServiceEntry.getPackageDate();
	}

	/**
	* Sets the package date of this user service entry.
	*
	* @param packageDate the package date of this user service entry
	*/
	public void setPackageDate(java.util.Date packageDate) {
		_userServiceEntry.setPackageDate(packageDate);
	}

	public boolean isNew() {
		return _userServiceEntry.isNew();
	}

	public void setNew(boolean n) {
		_userServiceEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _userServiceEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userServiceEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userServiceEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userServiceEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userServiceEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userServiceEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userServiceEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserServiceEntryWrapper((UserServiceEntry)_userServiceEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry) {
		return _userServiceEntry.compareTo(userServiceEntry);
	}

	@Override
	public int hashCode() {
		return _userServiceEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.UserServiceEntry> toCacheModel() {
		return _userServiceEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.UserServiceEntry toEscapedModel() {
		return new UserServiceEntryWrapper(_userServiceEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userServiceEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _userServiceEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userServiceEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserServiceEntry getWrappedUserServiceEntry() {
		return _userServiceEntry;
	}

	public UserServiceEntry getWrappedModel() {
		return _userServiceEntry;
	}

	public void resetOriginalValues() {
		_userServiceEntry.resetOriginalValues();
	}

	private UserServiceEntry _userServiceEntry;
}