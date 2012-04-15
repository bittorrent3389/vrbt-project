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

package vn.com.fis.portal.service.persistence;

/**
 * @author loind
 */
public interface VideoEntryFinder {
	public java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int searchVideoByCategoryCount(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByCategory_User(
		long categoryId, long userId, int start, int end, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int searchVideoByCategory_User_Count(long categoryId, long userId,
		boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByCategory_OtherUser(
		long categoryId, long userId, int start, int end, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int searchVideoByCategory_OtherUser_Count(long categoryId,
		long userId, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByUser(
		long userId, int start, int end, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int searchVideoByUserCount(long userId, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByVideoName_Folder_User(
		java.lang.String videoName, long folderId, long userId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int searchVideoByVideoName_Folder_User_Count(
		java.lang.String videoName, long folderId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByVideoName_OriginCode_ServiceActive(
		java.lang.String videoName, int originCode, int serviceActive,
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int searchVideoByVideoName_OriginCode_ServiceActive_Count(
		java.lang.String videoName, int originCode, int serviceActive,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;
}