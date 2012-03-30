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
 * This class is a wrapper for {@link ServicePackageEntry}.
 * </p>
 *
 * @author    loind
 * @see       ServicePackageEntry
 * @generated
 */
public class ServicePackageEntryWrapper implements ServicePackageEntry,
	ModelWrapper<ServicePackageEntry> {
	public ServicePackageEntryWrapper(ServicePackageEntry servicePackageEntry) {
		_servicePackageEntry = servicePackageEntry;
	}

	public Class<?> getModelClass() {
		return ServicePackageEntry.class;
	}

	public String getModelClassName() {
		return ServicePackageEntry.class.getName();
	}

	/**
	* Returns the primary key of this service package entry.
	*
	* @return the primary key of this service package entry
	*/
	public long getPrimaryKey() {
		return _servicePackageEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service package entry.
	*
	* @param primaryKey the primary key of this service package entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_servicePackageEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the service package ID of this service package entry.
	*
	* @return the service package ID of this service package entry
	*/
	public long getServicePackageId() {
		return _servicePackageEntry.getServicePackageId();
	}

	/**
	* Sets the service package ID of this service package entry.
	*
	* @param servicePackageId the service package ID of this service package entry
	*/
	public void setServicePackageId(long servicePackageId) {
		_servicePackageEntry.setServicePackageId(servicePackageId);
	}

	/**
	* Returns the service package name of this service package entry.
	*
	* @return the service package name of this service package entry
	*/
	public java.lang.String getServicePackageName() {
		return _servicePackageEntry.getServicePackageName();
	}

	/**
	* Sets the service package name of this service package entry.
	*
	* @param servicePackageName the service package name of this service package entry
	*/
	public void setServicePackageName(java.lang.String servicePackageName) {
		_servicePackageEntry.setServicePackageName(servicePackageName);
	}

	/**
	* Returns the service package code of this service package entry.
	*
	* @return the service package code of this service package entry
	*/
	public java.lang.String getServicePackageCode() {
		return _servicePackageEntry.getServicePackageCode();
	}

	/**
	* Sets the service package code of this service package entry.
	*
	* @param servicePackageCode the service package code of this service package entry
	*/
	public void setServicePackageCode(java.lang.String servicePackageCode) {
		_servicePackageEntry.setServicePackageCode(servicePackageCode);
	}

	/**
	* Returns the description of this service package entry.
	*
	* @return the description of this service package entry
	*/
	public java.lang.String getDescription() {
		return _servicePackageEntry.getDescription();
	}

	/**
	* Sets the description of this service package entry.
	*
	* @param description the description of this service package entry
	*/
	public void setDescription(java.lang.String description) {
		_servicePackageEntry.setDescription(description);
	}

	/**
	* Returns the total file of this service package entry.
	*
	* @return the total file of this service package entry
	*/
	public int getTotalFile() {
		return _servicePackageEntry.getTotalFile();
	}

	/**
	* Sets the total file of this service package entry.
	*
	* @param totalFile the total file of this service package entry
	*/
	public void setTotalFile(int totalFile) {
		_servicePackageEntry.setTotalFile(totalFile);
	}

	/**
	* Returns the create date of this service package entry.
	*
	* @return the create date of this service package entry
	*/
	public java.util.Date getCreateDate() {
		return _servicePackageEntry.getCreateDate();
	}

	/**
	* Sets the create date of this service package entry.
	*
	* @param createDate the create date of this service package entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_servicePackageEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this service package entry.
	*
	* @return the modified date of this service package entry
	*/
	public java.util.Date getModifiedDate() {
		return _servicePackageEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this service package entry.
	*
	* @param modifiedDate the modified date of this service package entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_servicePackageEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the service ID of this service package entry.
	*
	* @return the service ID of this service package entry
	*/
	public long getServiceId() {
		return _servicePackageEntry.getServiceId();
	}

	/**
	* Sets the service ID of this service package entry.
	*
	* @param serviceId the service ID of this service package entry
	*/
	public void setServiceId(long serviceId) {
		_servicePackageEntry.setServiceId(serviceId);
	}

	/**
	* Returns the status of this service package entry.
	*
	* @return the status of this service package entry
	*/
	public int getStatus() {
		return _servicePackageEntry.getStatus();
	}

	/**
	* Sets the status of this service package entry.
	*
	* @param status the status of this service package entry
	*/
	public void setStatus(int status) {
		_servicePackageEntry.setStatus(status);
	}

	public boolean isNew() {
		return _servicePackageEntry.isNew();
	}

	public void setNew(boolean n) {
		_servicePackageEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _servicePackageEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_servicePackageEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _servicePackageEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _servicePackageEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_servicePackageEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _servicePackageEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_servicePackageEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServicePackageEntryWrapper((ServicePackageEntry)_servicePackageEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry) {
		return _servicePackageEntry.compareTo(servicePackageEntry);
	}

	@Override
	public int hashCode() {
		return _servicePackageEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ServicePackageEntry> toCacheModel() {
		return _servicePackageEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ServicePackageEntry toEscapedModel() {
		return new ServicePackageEntryWrapper(_servicePackageEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _servicePackageEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _servicePackageEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_servicePackageEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ServicePackageEntry getWrappedServicePackageEntry() {
		return _servicePackageEntry;
	}

	public ServicePackageEntry getWrappedModel() {
		return _servicePackageEntry;
	}

	public void resetOriginalValues() {
		_servicePackageEntry.resetOriginalValues();
	}

	private ServicePackageEntry _servicePackageEntry;
}