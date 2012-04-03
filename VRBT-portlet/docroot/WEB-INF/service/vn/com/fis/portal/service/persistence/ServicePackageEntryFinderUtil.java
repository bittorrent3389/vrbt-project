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
public class ServicePackageEntryFinderUtil {
	public static java.util.List<vn.com.fis.portal.model.ServicePackageEntry> search(
		java.lang.String ser_pacCode, java.lang.String ser_pacName,
		long serviceId, int status, int start, int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .search(ser_pacCode, ser_pacName, serviceId, status, start,
			end, searchTypeFlag);
	}

	public static int searchCount(java.lang.String ser_pacCode,
		java.lang.String ser_pacName, long serviceId, int status,
		int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchCount(ser_pacCode, ser_pacName, serviceId, status,
			searchTypeFlag);
	}

	public static ServicePackageEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (ServicePackageEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ServicePackageEntryFinder.class.getName());

			ReferenceRegistry.registerReference(ServicePackageEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ServicePackageEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ServicePackageEntryFinderUtil.class,
			"_finder");
	}

	private static ServicePackageEntryFinder _finder;
}