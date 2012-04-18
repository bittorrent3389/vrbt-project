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
public class CategoryEntryFinderUtil {
	public static CategoryEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (CategoryEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					CategoryEntryFinder.class.getName());

			ReferenceRegistry.registerReference(CategoryEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CategoryEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CategoryEntryFinderUtil.class,
			"_finder");
	}

	private static CategoryEntryFinder _finder;
}