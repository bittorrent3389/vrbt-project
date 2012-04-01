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

package vn.com.fis.portal.service.impl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.fis.portal.NoSuchServicePackageEntryException;
import vn.com.fis.portal.model.ServicePackageEntry;
import vn.com.fis.portal.service.base.ServicePackageEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ServicePackageEntryFinderUtil;
import vn.com.fis.portal.service.persistence.ServicePackageEntryUtil;

/**
 * The implementation of the service package entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ServicePackageEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ServicePackageEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil
 */
public class ServicePackageEntryLocalServiceImpl
	extends ServicePackageEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ServicePackageEntryLocalServiceUtil} to access the service package entry local service.
	 */
	
	public List<ServicePackageEntry> search(String ser_pacCode, String ser_pacName, long serviceId, int status, int start, int end, int searchTypeFlag) throws SystemException {
		return ServicePackageEntryFinderUtil.search(ser_pacCode, ser_pacName, serviceId, status, start, end, searchTypeFlag);
	}
	
	public int searchCount(String ser_pacCode, String ser_pacName, long serviceId, int status, int searchTypeFlag) throws SystemException {
		return ServicePackageEntryFinderUtil.searchCount(ser_pacCode, ser_pacName, serviceId, status, searchTypeFlag);
	}
	
	public List<ServicePackageEntry> findBystatus(int status) throws SystemException {
			return ServicePackageEntryUtil.findBystatus(status);
	}
	
	public List<ServicePackageEntry> findByserviceId(long serviceId) throws SystemException{
		return ServicePackageEntryUtil.findByserviceId(serviceId);
	}
	
	public List<ServicePackageEntry> findByserviceId_Status(long serviceId, int status) throws SystemException {
		return ServicePackageEntryUtil.findByserviceId_Status(serviceId, status);
	}
	
	public ServicePackageEntry findByservicePackageCode(String servicePackageCode) throws NoSuchServicePackageEntryException, SystemException{
		return ServicePackageEntryUtil.findByservicePackageCode(servicePackageCode);
	}
	
	public ServicePackageEntry findByservicePackageName(String servicePackageName) throws NoSuchServicePackageEntryException, SystemException{
		return ServicePackageEntryUtil.findByservicePackageName(servicePackageName);
	}
}