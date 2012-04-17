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

package vn.com.fis.portal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the contact group contact entry remote service. This utility wraps {@link vn.com.fis.portal.service.impl.ContactGroupContactEntryServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author loind
 * @see ContactGroupContactEntryService
 * @see vn.com.fis.portal.service.base.ContactGroupContactEntryServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.ContactGroupContactEntryServiceImpl
 * @generated
 */
public class ContactGroupContactEntryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.ContactGroupContactEntryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void clearService() {
		_service = null;
	}

	public static ContactGroupContactEntryService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactGroupContactEntryService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ContactGroupContactEntryService.class.getName(),
					portletClassLoader);

			_service = new ContactGroupContactEntryServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ContactGroupContactEntryServiceUtil.class,
				"_service");
			MethodCache.remove(ContactGroupContactEntryService.class);
		}

		return _service;
	}

	public void setService(ContactGroupContactEntryService service) {
		MethodCache.remove(ContactGroupContactEntryService.class);

		_service = service;

		ReferenceRegistry.registerReference(ContactGroupContactEntryServiceUtil.class,
			"_service");
		MethodCache.remove(ContactGroupContactEntryService.class);
	}

	private static ContactGroupContactEntryService _service;
}