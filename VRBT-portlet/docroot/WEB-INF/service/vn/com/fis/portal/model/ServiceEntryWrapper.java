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
 * This class is a wrapper for {@link ServiceEntry}.
 * </p>
 *
 * @author    loind
 * @see       ServiceEntry
 * @generated
 */
public class ServiceEntryWrapper implements ServiceEntry,
	ModelWrapper<ServiceEntry> {
	public ServiceEntryWrapper(ServiceEntry serviceEntry) {
		_serviceEntry = serviceEntry;
	}

	public Class<?> getModelClass() {
		return ServiceEntry.class;
	}

	public String getModelClassName() {
		return ServiceEntry.class.getName();
	}

	/**
	* Returns the primary key of this service entry.
	*
	* @return the primary key of this service entry
	*/
	public long getPrimaryKey() {
		return _serviceEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service entry.
	*
	* @param primaryKey the primary key of this service entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_serviceEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the service ID of this service entry.
	*
	* @return the service ID of this service entry
	*/
	public long getServiceId() {
		return _serviceEntry.getServiceId();
	}

	/**
	* Sets the service ID of this service entry.
	*
	* @param serviceId the service ID of this service entry
	*/
	public void setServiceId(long serviceId) {
		_serviceEntry.setServiceId(serviceId);
	}

	/**
	* Returns the service code of this service entry.
	*
	* @return the service code of this service entry
	*/
	public java.lang.String getServiceCode() {
		return _serviceEntry.getServiceCode();
	}

	/**
	* Sets the service code of this service entry.
	*
	* @param serviceCode the service code of this service entry
	*/
	public void setServiceCode(java.lang.String serviceCode) {
		_serviceEntry.setServiceCode(serviceCode);
	}

	/**
	* Returns the service name of this service entry.
	*
	* @return the service name of this service entry
	*/
	public java.lang.String getServiceName() {
		return _serviceEntry.getServiceName();
	}

	/**
	* Sets the service name of this service entry.
	*
	* @param serviceName the service name of this service entry
	*/
	public void setServiceName(java.lang.String serviceName) {
		_serviceEntry.setServiceName(serviceName);
	}

	/**
	* Returns the description of this service entry.
	*
	* @return the description of this service entry
	*/
	public java.lang.String getDescription() {
		return _serviceEntry.getDescription();
	}

	/**
	* Sets the description of this service entry.
	*
	* @param description the description of this service entry
	*/
	public void setDescription(java.lang.String description) {
		_serviceEntry.setDescription(description);
	}

	/**
	* Returns the create date of this service entry.
	*
	* @return the create date of this service entry
	*/
	public java.util.Date getCreateDate() {
		return _serviceEntry.getCreateDate();
	}

	/**
	* Sets the create date of this service entry.
	*
	* @param createDate the create date of this service entry
	*/
	public void setCreateDate(java.util.Date createDate) {
		_serviceEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this service entry.
	*
	* @return the modified date of this service entry
	*/
	public java.util.Date getModifiedDate() {
		return _serviceEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this service entry.
	*
	* @param modifiedDate the modified date of this service entry
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_serviceEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this service entry.
	*
	* @return the status of this service entry
	*/
	public int getStatus() {
		return _serviceEntry.getStatus();
	}

	/**
	* Sets the status of this service entry.
	*
	* @param status the status of this service entry
	*/
	public void setStatus(int status) {
		_serviceEntry.setStatus(status);
	}

	public boolean isNew() {
		return _serviceEntry.isNew();
	}

	public void setNew(boolean n) {
		_serviceEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _serviceEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_serviceEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _serviceEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceEntryWrapper((ServiceEntry)_serviceEntry.clone());
	}

	public int compareTo(vn.com.fis.portal.model.ServiceEntry serviceEntry) {
		return _serviceEntry.compareTo(serviceEntry);
	}

	@Override
	public int hashCode() {
		return _serviceEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ServiceEntry> toCacheModel() {
		return _serviceEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ServiceEntry toEscapedModel() {
		return new ServiceEntryWrapper(_serviceEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _serviceEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ServiceEntry getWrappedServiceEntry() {
		return _serviceEntry;
	}

	public ServiceEntry getWrappedModel() {
		return _serviceEntry;
	}

	public void resetOriginalValues() {
		_serviceEntry.resetOriginalValues();
	}

	private ServiceEntry _serviceEntry;
}