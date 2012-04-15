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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author loind
 */
public class VideoEntryFinderUtil {
	public static java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByCategory(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchVideoByCategory(categoryId, start, end);
	}

	public static int searchVideoByCategoryCount(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchVideoByCategoryCount(categoryId);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByCategory_User(
		long categoryId, long userId, int start, int end, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByCategory_User(categoryId, userId, start, end,
			andOperator);
	}

	public static int searchVideoByCategory_User_Count(long categoryId,
		long userId, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByCategory_User_Count(categoryId, userId,
			andOperator);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByCategory_OtherUser(
		long categoryId, long userId, int start, int end, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByCategory_OtherUser(categoryId, userId, start,
			end, andOperator);
	}

	public static int searchVideoByCategory_OtherUser_Count(long categoryId,
		long userId, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByCategory_OtherUser_Count(categoryId, userId,
			andOperator);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByUser(
		long userId, int start, int end, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchVideoByUser(userId, start, end, andOperator);
	}

	public static int searchVideoByUserCount(long userId, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().searchVideoByUserCount(userId, andOperator);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByVideoName_Folder_User(
		java.lang.String videoName, long folderId, long userId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByVideoName_Folder_User(videoName, folderId,
			userId, start, end);
	}

	public static int searchVideoByVideoName_Folder_User_Count(
		java.lang.String videoName, long folderId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByVideoName_Folder_User_Count(videoName,
			folderId, userId);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoEntry> searchVideoByVideoName_OriginCode_ServiceActive(
		java.lang.String videoName, int originCode, int serviceActive,
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByVideoName_OriginCode_ServiceActive(videoName,
			originCode, serviceActive, userId, start, end);
	}

	public static int searchVideoByVideoName_OriginCode_ServiceActive_Count(
		java.lang.String videoName, int originCode, int serviceActive,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .searchVideoByVideoName_OriginCode_ServiceActive_Count(videoName,
			originCode, serviceActive, userId);
	}

	public static VideoEntryFinder getFinder() {
		if (_finder == null) {
			_finder = (VideoEntryFinder)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoEntryFinder.class.getName());

			ReferenceRegistry.registerReference(VideoEntryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VideoEntryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VideoEntryFinderUtil.class,
			"_finder");
	}

	private static VideoEntryFinder _finder;
}