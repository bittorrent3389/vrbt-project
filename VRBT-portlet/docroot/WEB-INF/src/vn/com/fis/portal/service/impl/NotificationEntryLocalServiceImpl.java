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

import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.service.base.NotificationEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.NotificationEntryUtil;

/**
 * The implementation of the notification entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.NotificationEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.NotificationEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.NotificationEntryLocalServiceUtil
 */
public class NotificationEntryLocalServiceImpl
	extends NotificationEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.NotificationEntryLocalServiceUtil} to access the notification entry local service.
	 */
	/**
	 * Returns all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @return the matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findByUserIdFrom_UserIdTo(long userIdFrom,
		long userIdTo) throws SystemException {
		return NotificationEntryUtil.findByUserIdFrom_UserIdTo(userIdFrom, userIdTo);
	}
	/**
	 * Returns a range of all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findByUserIdFrom_UserIdTo(long userIdFrom,
		long userIdTo, int start, int end) throws SystemException {
		return NotificationEntryUtil.findByUserIdFrom_UserIdTo(userIdFrom, userIdTo, start, end);
	}
	/**
	 * Returns the number of notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @return the number of matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdFrom_UserIdTo(long userIdFrom, long userIdTo)
		throws SystemException {
		return NotificationEntryUtil.countByUserIdFrom_UserIdTo(userIdFrom, userIdTo);
		}
}