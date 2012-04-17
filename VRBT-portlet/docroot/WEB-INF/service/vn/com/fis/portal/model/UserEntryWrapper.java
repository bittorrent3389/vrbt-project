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
 * This class is a wrapper for {@link UserEntry}.
 * </p>
 *
 * @author    loind
 * @see       UserEntry
 * @generated
 */
public class UserEntryWrapper implements UserEntry, ModelWrapper<UserEntry> {
	public UserEntryWrapper(UserEntry userEntry) {
		_userEntry = userEntry;
	}

	public Class<?> getModelClass() {
		return UserEntry.class;
	}

	public String getModelClassName() {
		return UserEntry.class.getName();
	}

	/**
	* Returns the primary key of this user entry.
	*
	* @return the primary key of this user entry
	*/
	public long getPrimaryKey() {
		return _userEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user entry.
	*
	* @param primaryKey the primary key of this user entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_userEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this user entry.
	*
	* @return the user ID of this user entry
	*/
	public long getUserId() {
		return _userEntry.getUserId();
	}

	/**
	* Sets the user ID of this user entry.
	*
	* @param userId the user ID of this user entry
	*/
	public void setUserId(long userId) {
		_userEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user entry.
	*
	* @return the user uuid of this user entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this user entry.
	*
	* @param userUuid the user uuid of this user entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_userEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this user entry.
	*
	* @return the user name of this user entry
	*/
	public java.lang.String getUserName() {
		return _userEntry.getUserName();
	}

	/**
	* Sets the user name of this user entry.
	*
	* @param userName the user name of this user entry
	*/
	public void setUserName(java.lang.String userName) {
		_userEntry.setUserName(userName);
	}

	/**
	* Returns the mobile number of this user entry.
	*
	* @return the mobile number of this user entry
	*/
	public java.lang.String getMobileNumber() {
		return _userEntry.getMobileNumber();
	}

	/**
	* Sets the mobile number of this user entry.
	*
	* @param mobileNumber the mobile number of this user entry
	*/
	public void setMobileNumber(java.lang.String mobileNumber) {
		_userEntry.setMobileNumber(mobileNumber);
	}

	/**
	* Returns the company ID of this user entry.
	*
	* @return the company ID of this user entry
	*/
	public long getCompanyId() {
		return _userEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this user entry.
	*
	* @param companyId the company ID of this user entry
	*/
	public void setCompanyId(long companyId) {
		_userEntry.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this user entry.
	*
	* @return the create date of this user entry
	*/
	public java.util.Date getCreateDate() {
		return _userEntry.getCreateDate();
	}

	/**
	* Sets the create date of this user entry.
	*
	* @param createDate the create date of this user entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_userEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this user entry.
	*
	* @return the modified date of this user entry
	*/
	public java.util.Date getModifiedDate() {
		return _userEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this user entry.
	*
	* @param modifiedDate the modified date of this user entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this user entry.
	*
	* @return the status of this user entry
	*/
	public int getStatus() {
		return _userEntry.getStatus();
	}

	/**
	* Sets the status of this user entry.
	*
	* @param status the status of this user entry
	*/
	public void setStatus(int status) {
		_userEntry.setStatus(status);
	}

	public boolean isNew() {
		return _userEntry.isNew();
	}

	public void setNew(boolean n) {
		_userEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _userEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_userEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _userEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _userEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserEntryWrapper((UserEntry)_userEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.UserEntry userEntry) {
		return _userEntry.compareTo(userEntry);
	}

	@Override
	public int hashCode() {
		return _userEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.UserEntry> toCacheModel() {
		return _userEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.UserEntry toEscapedModel() {
		return new UserEntryWrapper(_userEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _userEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public UserEntry getWrappedUserEntry() {
		return _userEntry;
	}

	public UserEntry getWrappedModel() {
		return _userEntry;
	}

	public void resetOriginalValues() {
		_userEntry.resetOriginalValues();
	}

	private UserEntry _userEntry;
}