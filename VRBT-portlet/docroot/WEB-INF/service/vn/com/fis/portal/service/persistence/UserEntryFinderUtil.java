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
public class UserEntryFinderUtil {
	public static vn.com.fis.portal.model.UserEntry getUserEntryByUserName(
		java.lang.String username) {
		return getFinder().getUserEntryByUserName(username);
	}

	public static UserEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (UserEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					UserEntryFinder.class.getName());

			ReferenceRegistry.registerReference(UserEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UserEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UserEntryFinderUtil.class, "_finder");
	}

	private static UserEntryFinder _finder;
}