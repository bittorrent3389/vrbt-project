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

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.fis.portal.NoSuchUserServiceEntryException;
import vn.com.fis.portal.model.UserServiceEntry;
import vn.com.fis.portal.service.base.UserServiceEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.UserServiceEntryUtil;

/**
 * The implementation of the user service entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.UserServiceEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.UserServiceEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.UserServiceEntryLocalServiceUtil
 */
public class UserServiceEntryLocalServiceImpl
	extends UserServiceEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.UserServiceEntryLocalServiceUtil} to access the user service entry local service.
	 */
	
	public UserServiceEntry findByUserId_ServiceId_PackageId(long userId,
			long serviceId, long servicePackageId) throws NoSuchUserServiceEntryException, SystemException{
		return UserServiceEntryUtil.findByUserId_ServiceId_PackageId(userId, serviceId, servicePackageId);
	}
	
	public UserServiceEntry findByUserId_ServiceId(long userId, long serviceId)
			throws NoSuchUserServiceEntryException, SystemException {
		return UserServiceEntryUtil.findByUserId_ServiceId(userId, serviceId);
	}
}