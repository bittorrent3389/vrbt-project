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

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.util.dao.orm.CustomSQLUtil;

import vn.com.fis.portal.NoSuchServiceEntryException;
import vn.com.fis.portal.model.ServiceEntry;
import vn.com.fis.portal.model.impl.ServiceEntryImpl;
import vn.com.fis.portal.service.base.ServiceEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ServiceEntryFinderUtil;
import vn.com.fis.portal.service.persistence.ServiceEntryUtil;

/**
 * The implementation of the service entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ServiceEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ServiceEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ServiceEntryLocalServiceUtil
 */
public class ServiceEntryLocalServiceImpl
	extends ServiceEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ServiceEntryLocalServiceUtil} to access the service entry local service.
	 */
	
	public List<ServiceEntry> search(String serviceCode, String serviceName, int status, int start, int end, int searchTypeFlag) throws SystemException {
		return ServiceEntryFinderUtil.search(serviceCode, serviceName, status, start, end, searchTypeFlag);
	}
	
	public int searchCount(String serviceCode, String serviceName, int status, int searchTypeFlag) throws SystemException {
		return ServiceEntryFinderUtil.searchCount(serviceCode, serviceName, status, searchTypeFlag);
	}
	
	public boolean isStartService(String serviceCode) {
		return ServiceEntryFinderUtil.isStartService(serviceCode);
	}
	
	public String getStartServiceCode() {
		return ServiceEntryFinderUtil.getStartServiceCode();
	}
	
	public String getUploadServicePackageCode() {
		return ServiceEntryFinderUtil.getUploadServicePackageCode();
	}
	
	public List<ServiceEntry> findBystatus(int status) throws SystemException {
			return ServiceEntryUtil.findBystatus(status);
	}
	
	public ServiceEntry findByserviceCode(String serviceCode) throws NoSuchServiceEntryException, SystemException {
		return ServiceEntryUtil.findByserviceCode(serviceCode);
	}
	
	public ServiceEntry findByserviceName(String serviceName) throws NoSuchServiceEntryException, SystemException {
		return ServiceEntryUtil.findByserviceName(serviceName);
	}
}