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

import vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException;
import vn.com.fis.portal.model.ContactGroupVideoGroupEntry;
import vn.com.fis.portal.service.base.ContactGroupVideoGroupEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ContactGroupVideoGroupEntryUtil;

/**
 * The implementation of the contact group video group entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ContactGroupVideoGroupEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ContactGroupVideoGroupEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ContactGroupVideoGroupEntryLocalServiceUtil
 */
public class ContactGroupVideoGroupEntryLocalServiceImpl
	extends ContactGroupVideoGroupEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ContactGroupVideoGroupEntryLocalServiceUtil} to access the contact group video group entry local service.
	 */
	/**
	 * Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException} if it could not be found.
	 *
	 * @param contactGroupId the contact group ID
	 * @param videoGroupId the video group ID
	 * @return the matching contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
			return ContactGroupVideoGroupEntryUtil.findByContactGroup_VideoGroup(contactGroupId, videoGroupId);
		}
		/**
		 * Returns the number of contact group video group entries where contactGroupId = &#63; and videoGroupId = &#63;.
		 *
		 * @param contactGroupId the contact group ID
		 * @param videoGroupId the video group ID
		 * @return the number of matching contact group video group entries
		 * @throws SystemException if a system exception occurred
		 */
		public int countByContactGroup_VideoGroup(long contactGroupId,
			long videoGroupId) throws SystemException {
			return ContactGroupVideoGroupEntryUtil.countByContactGroup_VideoGroup(contactGroupId, videoGroupId);
		}
		
			/**
		 * Removes the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; from the database.
		 *
		 * @param contactGroupId the contact group ID
		 * @param videoGroupId the video group ID
		 * @throws SystemException if a system exception occurred
		 */
		public void removeByContactGroup_VideoGroup(long contactGroupId,
			long videoGroupId)
			throws NoSuchContactGroupVideoGroupEntryException, SystemException {
			ContactGroupVideoGroupEntryUtil.removeByContactGroup_VideoGroup(contactGroupId, videoGroupId);
		}
			
			
		/**
		 * Returns all the contact group video group entries where contactGroupId = &#63;.
		 *
		 * @param contactGroupId the contact group ID
		 * @return the matching contact group video group entries
		 * @throws SystemException if a system exception occurred
		 */
		public List<ContactGroupVideoGroupEntry> findByContactGroup(
			long contactGroupId) throws SystemException {
			return ContactGroupVideoGroupEntryUtil.findByContactGroup(contactGroupId);
		}
			/**
		 * Returns a range of all the contact group video group entries where contactGroupId = &#63;.
		 *
		 * <p>
		 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
		 * </p>
		 *
		 * @param contactGroupId the contact group ID
		 * @param start the lower bound of the range of contact group video group entries
		 * @param end the upper bound of the range of contact group video group entries (not inclusive)
		 * @return the range of matching contact group video group entries
		 * @throws SystemException if a system exception occurred
		 */
		public List<ContactGroupVideoGroupEntry> findByContactGroup(
			long contactGroupId, int start, int end) throws SystemException {
			return ContactGroupVideoGroupEntryUtil.findByContactGroup(contactGroupId, start, end);
		}
			/**
		 * Returns the number of contact group video group entries where contactGroupId = &#63;.
		 *
		 * @param contactGroupId the contact group ID
		 * @return the number of matching contact group video group entries
		 * @throws SystemException if a system exception occurred
		 */
		public int countByContactGroup(long contactGroupId)
			throws SystemException {
			return ContactGroupVideoGroupEntryUtil.countByContactGroup(contactGroupId);
		}
			/**
		 * Removes all the contact group video group entries where contactGroupId = &#63; from the database.
		 *
		 * @param contactGroupId the contact group ID
		 * @throws SystemException if a system exception occurred
		 */
		public void removeByContactGroup(long contactGroupId)
			throws SystemException {
			ContactGroupVideoGroupEntryUtil.removeByContactGroup(contactGroupId);
		}
		
			
}