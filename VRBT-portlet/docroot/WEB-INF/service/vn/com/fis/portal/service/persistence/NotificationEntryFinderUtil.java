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
public class NotificationEntryFinderUtil {
	public static java.util.List<vn.com.fis.portal.model.NotificationEntry> getNotificationEntryByUserId(
		long usreId, java.lang.String typeNotification, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getNotificationEntryByUserId(usreId, typeNotification,
			start, end);
	}

	public static int getNotificationEntryByUserIdCount(long usreId,
		java.lang.String typeNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getNotificationEntryByUserIdCount(usreId, typeNotification);
	}

	public static NotificationEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (NotificationEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					NotificationEntryFinder.class.getName());

			ReferenceRegistry.registerReference(NotificationEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(NotificationEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(NotificationEntryFinderUtil.class,
			"_finder");
	}

	private static NotificationEntryFinder _finder;
}