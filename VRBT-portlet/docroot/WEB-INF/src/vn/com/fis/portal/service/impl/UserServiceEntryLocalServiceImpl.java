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
	/**returns the user service entry where userId = &#63; and serviceId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @return the matching user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByUserId_ServiceId(long userId, long serviceId)
		throws NoSuchUserServiceEntryException, SystemException {
		 return UserServiceEntryUtil.findByUserId_ServiceId(userId, serviceId);
	 }
	/**
	 * Removes the user service entry where userId = &#63; and serviceId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ServiceId(long userId, long serviceId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntryUtil.removeByUserId_ServiceId(userId, serviceId);
	}
	/**
	 * Returns the number of user service entries where userId = &#63; and serviceId = &#63;.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @return the number of matching user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ServiceId(long userId, long serviceId)
		throws SystemException {
		return UserServiceEntryUtil.countByUserId_ServiceId(userId, serviceId);
	}
	/**
	 * Returns the user service entry where userId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @return the matching user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		return UserServiceEntryUtil.findByUserId_ServicePackageId(userId, servicePackageId);
	}
	/**
	 * Removes the user service entry where userId = &#63; and servicePackageId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntryUtil.removeByUserId_ServicePackageId(userId, servicePackageId);
	}
	
	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @return the matching user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByUserId_ServiceId_PackageId(long userId,
		long serviceId, long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		return UserServiceEntryUtil.findByUserId_ServiceId_PackageId(userId, serviceId, servicePackageId);
	}
	/**
	 * Returns the number of user service entries where userId = &#63; and serviceId = &#63; and servicePackageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @return the number of matching user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId) throws SystemException {
		return UserServiceEntryUtil.countByUserId_ServiceId_PackageId(userId, serviceId, servicePackageId);
	}
	/**
	 * Removes the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntryUtil.removeByUserId_ServiceId_PackageId(userId, serviceId, servicePackageId);
	}
	
	public List<UserServiceEntry> findByUserId_serviceStatus(long userId, 
			int serviceStatus) throws SystemException, NoSuchUserServiceEntryException {
		return UserServiceEntryUtil.findByUserId_serviceStatus(userId, serviceStatus);
	}
	
	public List<UserServiceEntry> findByuserId(long userId) throws SystemException{
		return UserServiceEntryUtil.findByuserId(userId);
	}
	
	public List<UserServiceEntry> findByservicePackageId(long servicePackageId)
			throws SystemException {
		return UserServiceEntryUtil.findByservicePackageId(servicePackageId);
	}
	
	public List<UserServiceEntry> findByserviceId_ServiceStatus(
			long serviceId, int serviceStatus) throws SystemException {
		return UserServiceEntryUtil.findByserviceId_ServiceStatus(serviceId, serviceStatus);
	}
	
	public int countByuserId(long userId) throws SystemException {
		return UserServiceEntryUtil.countByuserId(userId);
	}
	
	public int countByservicePackageId(long servicePackageId)
			throws SystemException {
		return UserServiceEntryUtil.countByservicePackageId(servicePackageId);
	}
	
	public int countByserviceId_ServiceStatus(long serviceId, int serviceStatus)
			throws SystemException {
		return UserServiceEntryUtil.countByserviceId_ServiceStatus(serviceId, serviceStatus);
	}
}