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
import vn.com.fis.portal.service.persistence.NotificationEntryFinderUtil;
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
	
	public List<NotificationEntry> getNotificationEntryByUserId(long usreId,String typeNotification,int start,int end) throws SystemException
	{
		return NotificationEntryFinderUtil.getNotificationEntryByUserId(usreId,typeNotification,start,end);
	}
	
	public int getNotificationEntryByUserIdCount(long usreId,String typeNotification) throws SystemException
	{
		return NotificationEntryFinderUtil.getNotificationEntryByUserIdCount(usreId,typeNotification);
	}
	
}