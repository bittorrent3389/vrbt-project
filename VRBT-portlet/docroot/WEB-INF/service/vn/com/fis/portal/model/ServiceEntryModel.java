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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ServiceEntry service. Represents a row in the &quot;TBL_SERVICE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.fis.portal.model.impl.ServiceEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.fis.portal.model.impl.ServiceEntryImpl}.
 * </p>
 *
 * @author loind
 * @see ServiceEntry
 * @see vn.com.fis.portal.model.impl.ServiceEntryImpl
 * @see vn.com.fis.portal.model.impl.ServiceEntryModelImpl
 * @generated
 */
public interface ServiceEntryModel extends BaseModel<ServiceEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a service entry model instance should use the {@link ServiceEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this service entry.
	 *
	 * @return the primary key of this service entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this service entry.
	 *
	 * @param primaryKey the primary key of this service entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the service ID of this service entry.
	 *
	 * @return the service ID of this service entry
	 */
	public long getServiceId();

	/**
	 * Sets the service ID of this service entry.
	 *
	 * @param serviceId the service ID of this service entry
	 */
	public void setServiceId(long serviceId);

	/**
	 * Returns the service code of this service entry.
	 *
	 * @return the service code of this service entry
	 */
	@AutoEscape
	public String getServiceCode();

	/**
	 * Sets the service code of this service entry.
	 *
	 * @param serviceCode the service code of this service entry
	 */
	public void setServiceCode(String serviceCode);

	/**
	 * Returns the service name of this service entry.
	 *
	 * @return the service name of this service entry
	 */
	@AutoEscape
	public String getServiceName();

	/**
	 * Sets the service name of this service entry.
	 *
	 * @param serviceName the service name of this service entry
	 */
	public void setServiceName(String serviceName);

	/**
	 * Returns the description of this service entry.
	 *
	 * @return the description of this service entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this service entry.
	 *
	 * @param description the description of this service entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the create date of this service entry.
	 *
	 * @return the create date of this service entry
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this service entry.
	 *
	 * @param createDate the create date of this service entry
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this service entry.
	 *
	 * @return the modified date of this service entry
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this service entry.
	 *
	 * @param modifiedDate the modified date of this service entry
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this service entry.
	 *
	 * @return the status of this service entry
	 */
	public int getStatus();

	/**
	 * Sets the status of this service entry.
	 *
	 * @param status the status of this service entry
	 */
	public void setStatus(int status);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ServiceEntry serviceEntry);

	public int hashCode();

	public CacheModel<ServiceEntry> toCacheModel();

	public ServiceEntry toEscapedModel();

	public String toString();

	public String toXmlString();
}