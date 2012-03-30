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

import vn.com.fis.portal.NoSuchContactGroupContactEntryException;
import vn.com.fis.portal.model.ContactGroupContactEntry;
import vn.com.fis.portal.service.base.ContactGroupContactEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ContactGroupContactEntryUtil;

/**
 * The implementation of the contact group contact entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ContactGroupContactEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ContactGroupContactEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ContactGroupContactEntryLocalServiceUtil
 */
public class ContactGroupContactEntryLocalServiceImpl
	extends ContactGroupContactEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ContactGroupContactEntryLocalServiceUtil} to access the contact group contact entry local service.
	 */
	/**
	 * Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupContactEntryException} if it could not be found.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @return the matching contact group contact entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a matching contact group contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupContactEntry findByContactId_ContactGroupId(
		String contactId, String contactGroupId)
		throws NoSuchContactGroupContactEntryException, SystemException {
		return ContactGroupContactEntryUtil.findByContactId_ContactGroupId(contactId, contactGroupId);
	}
	
	/**
	 * Returns the number of contact group contact entries where contactId = &#63; and contactGroupId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @return the number of matching contact group contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactId_ContactGroupId(String contactId,
		String contactGroupId) throws SystemException {
		return ContactGroupContactEntryUtil.countByContactId_ContactGroupId(contactId, contactGroupId);
	}
	/**
	 * Removes the contact group contact entry where contactId = &#63; and contactGroupId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactId_ContactGroupId(String contactId,
		String contactGroupId)
		throws NoSuchContactGroupContactEntryException, SystemException {
		ContactGroupContactEntryUtil.removeByContactId_ContactGroupId(contactId, contactGroupId);
	}
}