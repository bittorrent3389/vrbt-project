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
public class ServiceTransactionEntryFinderUtil {
	public static java.util.List<vn.com.fis.portal.model.ServiceTransactionEntry> search(
		long transactionCode, long serviceId, long servicePackageId, int start,
		int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .search(transactionCode, serviceId, servicePackageId, start,
			end, searchTypeFlag);
	}

	public static int searchCount(long transactionCode, long serviceId,
		long servicePackageId, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchCount(transactionCode, serviceId, servicePackageId,
			searchTypeFlag);
	}

	public static ServiceTransactionEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (ServiceTransactionEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					ServiceTransactionEntryFinder.class.getName());

			ReferenceRegistry.registerReference(ServiceTransactionEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ServiceTransactionEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ServiceTransactionEntryFinderUtil.class,
			"_finder");
	}

	private static ServiceTransactionEntryFinder _finder;
}