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
 * This class is a wrapper for {@link ServiceTransactionEntry}.
 * </p>
 *
 * @author    loind
 * @see       ServiceTransactionEntry
 * @generated
 */
public class ServiceTransactionEntryWrapper implements ServiceTransactionEntry,
	ModelWrapper<ServiceTransactionEntry> {
	public ServiceTransactionEntryWrapper(
		ServiceTransactionEntry serviceTransactionEntry) {
		_serviceTransactionEntry = serviceTransactionEntry;
	}

	public Class<?> getModelClass() {
		return ServiceTransactionEntry.class;
	}

	public String getModelClassName() {
		return ServiceTransactionEntry.class.getName();
	}

	/**
	* Returns the primary key of this service transaction entry.
	*
	* @return the primary key of this service transaction entry
	*/
	public long getPrimaryKey() {
		return _serviceTransactionEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service transaction entry.
	*
	* @param primaryKey the primary key of this service transaction entry
	*/
	public void setPrimaryKey(long primaryKey) {
		_serviceTransactionEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the transaction ID of this service transaction entry.
	*
	* @return the transaction ID of this service transaction entry
	*/
	public long getTransactionId() {
		return _serviceTransactionEntry.getTransactionId();
	}

	/**
	* Sets the transaction ID of this service transaction entry.
	*
	* @param transactionId the transaction ID of this service transaction entry
	*/
	public void setTransactionId(long transactionId) {
		_serviceTransactionEntry.setTransactionId(transactionId);
	}

	/**
	* Returns the transaction code of this service transaction entry.
	*
	* @return the transaction code of this service transaction entry
	*/
	public int getTransactionCode() {
		return _serviceTransactionEntry.getTransactionCode();
	}

	/**
	* Sets the transaction code of this service transaction entry.
	*
	* @param transactionCode the transaction code of this service transaction entry
	*/
	public void setTransactionCode(int transactionCode) {
		_serviceTransactionEntry.setTransactionCode(transactionCode);
	}

	/**
	* Returns the date_ of this service transaction entry.
	*
	* @return the date_ of this service transaction entry
	*/
	public java.util.Date getDate_() {
		return _serviceTransactionEntry.getDate_();
	}

	/**
	* Sets the date_ of this service transaction entry.
	*
	* @param date_ the date_ of this service transaction entry
	*/
	public void setDate_(java.util.Date date_) {
		_serviceTransactionEntry.setDate_(date_);
	}

	/**
	* Returns the user ID of this service transaction entry.
	*
	* @return the user ID of this service transaction entry
	*/
	public long getUserId() {
		return _serviceTransactionEntry.getUserId();
	}

	/**
	* Sets the user ID of this service transaction entry.
	*
	* @param userId the user ID of this service transaction entry
	*/
	public void setUserId(long userId) {
		_serviceTransactionEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this service transaction entry.
	*
	* @return the user uuid of this service transaction entry
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceTransactionEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this service transaction entry.
	*
	* @param userUuid the user uuid of this service transaction entry
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_serviceTransactionEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the service ID of this service transaction entry.
	*
	* @return the service ID of this service transaction entry
	*/
	public long getServiceId() {
		return _serviceTransactionEntry.getServiceId();
	}

	/**
	* Sets the service ID of this service transaction entry.
	*
	* @param serviceId the service ID of this service transaction entry
	*/
	public void setServiceId(long serviceId) {
		_serviceTransactionEntry.setServiceId(serviceId);
	}

	/**
	* Returns the service status of this service transaction entry.
	*
	* @return the service status of this service transaction entry
	*/
	public int getServiceStatus() {
		return _serviceTransactionEntry.getServiceStatus();
	}

	/**
	* Sets the service status of this service transaction entry.
	*
	* @param serviceStatus the service status of this service transaction entry
	*/
	public void setServiceStatus(int serviceStatus) {
		_serviceTransactionEntry.setServiceStatus(serviceStatus);
	}

	/**
	* Returns the service start date of this service transaction entry.
	*
	* @return the service start date of this service transaction entry
	*/
	public java.util.Date getServiceStartDate() {
		return _serviceTransactionEntry.getServiceStartDate();
	}

	/**
	* Sets the service start date of this service transaction entry.
	*
	* @param serviceStartDate the service start date of this service transaction entry
	*/
	public void setServiceStartDate(java.util.Date serviceStartDate) {
		_serviceTransactionEntry.setServiceStartDate(serviceStartDate);
	}

	/**
	* Returns the service stop date of this service transaction entry.
	*
	* @return the service stop date of this service transaction entry
	*/
	public java.util.Date getServiceStopDate() {
		return _serviceTransactionEntry.getServiceStopDate();
	}

	/**
	* Sets the service stop date of this service transaction entry.
	*
	* @param serviceStopDate the service stop date of this service transaction entry
	*/
	public void setServiceStopDate(java.util.Date serviceStopDate) {
		_serviceTransactionEntry.setServiceStopDate(serviceStopDate);
	}

	/**
	* Returns the service end date of this service transaction entry.
	*
	* @return the service end date of this service transaction entry
	*/
	public java.util.Date getServiceEndDate() {
		return _serviceTransactionEntry.getServiceEndDate();
	}

	/**
	* Sets the service end date of this service transaction entry.
	*
	* @param serviceEndDate the service end date of this service transaction entry
	*/
	public void setServiceEndDate(java.util.Date serviceEndDate) {
		_serviceTransactionEntry.setServiceEndDate(serviceEndDate);
	}

	/**
	* Returns the service package ID of this service transaction entry.
	*
	* @return the service package ID of this service transaction entry
	*/
	public long getServicePackageId() {
		return _serviceTransactionEntry.getServicePackageId();
	}

	/**
	* Sets the service package ID of this service transaction entry.
	*
	* @param servicePackageId the service package ID of this service transaction entry
	*/
	public void setServicePackageId(long servicePackageId) {
		_serviceTransactionEntry.setServicePackageId(servicePackageId);
	}

	/**
	* Returns the package date of this service transaction entry.
	*
	* @return the package date of this service transaction entry
	*/
	public java.util.Date getPackageDate() {
		return _serviceTransactionEntry.getPackageDate();
	}

	/**
	* Sets the package date of this service transaction entry.
	*
	* @param packageDate the package date of this service transaction entry
	*/
	public void setPackageDate(java.util.Date packageDate) {
		_serviceTransactionEntry.setPackageDate(packageDate);
	}

	public boolean isNew() {
		return _serviceTransactionEntry.isNew();
	}

	public void setNew(boolean n) {
		_serviceTransactionEntry.setNew(n);
	}

	public boolean isCachedModel() {
		return _serviceTransactionEntry.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_serviceTransactionEntry.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _serviceTransactionEntry.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceTransactionEntry.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceTransactionEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceTransactionEntry.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceTransactionEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceTransactionEntryWrapper((ServiceTransactionEntry)_serviceTransactionEntry.clone());
	}

	public int compareTo(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry) {
		return _serviceTransactionEntry.compareTo(serviceTransactionEntry);
	}

	@Override
	public int hashCode() {
		return _serviceTransactionEntry.hashCode();
	}

	public com.liferay.portal.model.CacheModel<vn.com.fis.portal.model.ServiceTransactionEntry> toCacheModel() {
		return _serviceTransactionEntry.toCacheModel();
	}

	public vn.com.fis.portal.model.ServiceTransactionEntry toEscapedModel() {
		return new ServiceTransactionEntryWrapper(_serviceTransactionEntry.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceTransactionEntry.toString();
	}

	public java.lang.String toXmlString() {
		return _serviceTransactionEntry.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceTransactionEntry.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ServiceTransactionEntry getWrappedServiceTransactionEntry() {
		return _serviceTransactionEntry;
	}

	public ServiceTransactionEntry getWrappedModel() {
		return _serviceTransactionEntry;
	}

	public void resetOriginalValues() {
		_serviceTransactionEntry.resetOriginalValues();
	}

	private ServiceTransactionEntry _serviceTransactionEntry;
}