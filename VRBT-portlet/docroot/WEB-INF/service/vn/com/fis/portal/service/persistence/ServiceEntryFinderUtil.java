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

package vn.com.fis.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author loind
 */
public class ServiceEntryFinderUtil {
	public static java.util.List<vn.com.fis.portal.model.ServiceEntry> search(
		java.lang.String serviceCode, java.lang.String serviceName, int status,
		int start, int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .search(serviceCode, serviceName, status, start, end,
			searchTypeFlag);
	}

	public static int searchCount(java.lang.String serviceCode,
		java.lang.String serviceName, int status, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchCount(serviceCode, serviceName, status, searchTypeFlag);
	}

	public static boolean isStartService(java.lang.String serviceCode) {
		return getFinder().isStartService(serviceCode);
	}

	public static java.lang.String getStartServiceCode() {
		return getFinder().getStartServiceCode();
	}

	public static java.lang.String getUploadServicePackageCode() {
		return getFinder().getUploadServicePackageCode();
	}

	public static ServiceEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (ServiceEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ServiceEntryFinder.class.getName());

			ReferenceRegistry.registerReference(ServiceEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ServiceEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ServiceEntryFinderUtil.class,
			"_finder");
	}

	private static ServiceEntryFinder _finder;
}