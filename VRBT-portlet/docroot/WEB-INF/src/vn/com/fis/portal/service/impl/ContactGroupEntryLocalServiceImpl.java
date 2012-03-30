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

import vn.com.fis.portal.NoSuchContactGroupEntryException;
import vn.com.fis.portal.model.ContactGroupEntry;
import vn.com.fis.portal.service.base.ContactGroupEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ContactGroupEntryUtil;

/**
 * The implementation of the contact group entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ContactGroupEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ContactGroupEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ContactGroupEntryLocalServiceUtil
 */
public class ContactGroupEntryLocalServiceImpl
	extends ContactGroupEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ContactGroupEntryLocalServiceUtil} to access the contact group entry local service.
	 */
	/**
	 * Returns all the contact group entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupEntry> findByUserId(long userId)
		throws SystemException {
		return ContactGroupEntryUtil.findByUserId(userId);
	}
	
	/**
	 * Returns a range of all the contact group entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of contact group entries
	 * @param end the upper bound of the range of contact group entries (not inclusive)
	 * @return the range of matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return ContactGroupEntryUtil.findByUserId(userId, start, end);
	}
	/**
	 * Returns the number of contact group entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		return ContactGroupEntryUtil.countByUserId(userId);
	}
	
	/**
	 * Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @return the matching contact group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry findByUserId_ContactGroupId(long userId,
		long contactGroupId)
		throws NoSuchContactGroupEntryException, SystemException {
		return ContactGroupEntryUtil.findByUserId_ContactGroupId(userId, contactGroupId);
		}
	/**
	 * Returns the number of contact group entries where userId = &#63; and contactGroupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @return the number of matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ContactGroupId(long userId, long contactGroupId)
		throws SystemException {
		return ContactGroupEntryUtil.countByUserId_ContactGroupId(userId, contactGroupId);
	}
	/**
	 * Removes the contact group entry where userId = &#63; and contactGroupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ContactGroupId(long userId, long contactGroupId)
		throws NoSuchContactGroupEntryException, SystemException {
		ContactGroupEntryUtil.removeByUserId_ContactGroupId(userId, contactGroupId);
	}
}