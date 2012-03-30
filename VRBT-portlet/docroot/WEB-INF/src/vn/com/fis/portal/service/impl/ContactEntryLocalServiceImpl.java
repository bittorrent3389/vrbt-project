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

import vn.com.fis.portal.NoSuchContactEntryException;
import vn.com.fis.portal.model.ContactEntry;
import vn.com.fis.portal.service.base.ContactEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ContactEntryUtil;

/**
 * The implementation of the contact entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ContactEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ContactEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ContactEntryLocalServiceUtil
 */
public class ContactEntryLocalServiceImpl
	extends ContactEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ContactEntryLocalServiceUtil} to access the contact entry local service.
	 */
	/**
	 * Returns the contact entry where userId = &#63; and mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @return the matching contact entry
	 * @throws vn.com.fis.portal.NoSuchContactEntryException if a matching contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry findByUserId_MobileNumber(long userId,
		String mobileNumber)
		throws NoSuchContactEntryException, SystemException {
			return ContactEntryUtil.findByUserId_MobileNumber(userId, mobileNumber);
	}
		/**
	 * Returns the number of contact entries where userId = &#63; and mobileNumber = &#63;.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @return the number of matching contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_MobileNumber(long userId, String mobileNumber)
		throws SystemException {
		return ContactEntryUtil.countByUserId_MobileNumber(userId, mobileNumber);
	}
		
}