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

import vn.com.fis.portal.NoSuchUserEntryException;

import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.service.base.UserEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.UserEntryUtil;

/**
 * The implementation of the user entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.UserEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.UserEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.UserEntryLocalServiceUtil
 */
public class UserEntryLocalServiceImpl extends UserEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.UserEntryLocalServiceUtil} to access the user entry local service.
	 */
	/**
	 * Returns the user entry where userName = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByUserName(String userName)
		throws NoSuchUserEntryException, SystemException {
		return UserEntryUtil.findByUserName(userName);
	}
	
	/**
	 * Removes the user entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserName(String userName)
		throws NoSuchUserEntryException, SystemException {
		UserEntryUtil.removeByUserName(userName);
	}
	/**
	 * Returns the number of user entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserName(String userName) throws SystemException {
		return UserEntryUtil.countByUserName(userName);
	}
	
	/**
	 * Returns the user entry where mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param mobileNumber the mobile number
	 * @return the matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByMobileNumber(long mobileNumber)
		throws NoSuchUserEntryException, SystemException {
		return UserEntryUtil.findByMobileNumber(mobileNumber);
	}
	/**
	 * Returns the number of user entries where mobileNumber = &#63;.
	 *
	 * @param mobileNumber the mobile number
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMobileNumber(long mobileNumber) throws SystemException {
		return UserEntryUtil.countByMobileNumber(mobileNumber);
	}
	/**
	 * Removes the user entry where mobileNumber = &#63; from the database.
	 *
	 * @param mobileNumber the mobile number
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMobileNumber(long mobileNumber)
		throws NoSuchUserEntryException, SystemException {
		UserEntryUtil.removeByMobileNumber(mobileNumber);
	}
	/**
	 * Returns the user entry where userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByUserId(long userId)
		throws NoSuchUserEntryException, SystemException {
		return UserEntryUtil.findByUserId(userId);
	}
	/**
	 * Returns the number of user entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		return UserEntryUtil.countByUserId(userId);
	}

	/**
	 * Removes the user entry where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId)
		throws NoSuchUserEntryException, SystemException {
		 UserEntryUtil.removeByUserId(userId);
	}

}