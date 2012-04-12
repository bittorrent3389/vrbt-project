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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.fis.portal.model.VideoUserVideoGroupEntry;

import java.util.List;

/**
 * The persistence utility for the video user video group entry service. This utility wraps {@link VideoUserVideoGroupEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserVideoGroupEntryPersistence
 * @see VideoUserVideoGroupEntryPersistenceImpl
 * @generated
 */
public class VideoUserVideoGroupEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		getPersistence().clearCache(videoUserVideoGroupEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<VideoUserVideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoUserVideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoUserVideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoUserVideoGroupEntry update(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry, boolean merge)
		throws SystemException {
		return getPersistence().update(videoUserVideoGroupEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoUserVideoGroupEntry update(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(videoUserVideoGroupEntry, merge, serviceContext);
	}

	/**
	* Caches the video user video group entry in the entity cache if it is enabled.
	*
	* @param videoUserVideoGroupEntry the video user video group entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		getPersistence().cacheResult(videoUserVideoGroupEntry);
	}

	/**
	* Caches the video user video group entries in the entity cache if it is enabled.
	*
	* @param videoUserVideoGroupEntries the video user video group entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> videoUserVideoGroupEntries) {
		getPersistence().cacheResult(videoUserVideoGroupEntries);
	}

	/**
	* Creates a new video user video group entry with the primary key. Does not add the video user video group entry to the database.
	*
	* @param videoUserVideoGroupID the primary key for the new video user video group entry
	* @return the new video user video group entry
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry create(
		long videoUserVideoGroupID) {
		return getPersistence().create(videoUserVideoGroupID);
	}

	/**
	* Removes the video user video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserVideoGroupID the primary key of the video user video group entry
	* @return the video user video group entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry remove(
		long videoUserVideoGroupID)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException {
		return getPersistence().remove(videoUserVideoGroupID);
	}

	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry updateImpl(
		vn.com.fis.portal.model.VideoUserVideoGroupEntry videoUserVideoGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoUserVideoGroupEntry, merge);
	}

	/**
	* Returns the video user video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	*
	* @param videoUserVideoGroupID the primary key of the video user video group entry
	* @return the video user video group entry
	* @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry findByPrimaryKey(
		long videoUserVideoGroupID)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException {
		return getPersistence().findByPrimaryKey(videoUserVideoGroupID);
	}

	/**
	* Returns the video user video group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoUserVideoGroupID the primary key of the video user video group entry
	* @return the video user video group entry, or <code>null</code> if a video user video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry fetchByPrimaryKey(
		long videoUserVideoGroupID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoUserVideoGroupID);
	}

	/**
	* Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @return the matching video user video group entry
	* @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a matching video user video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry findByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException {
		return getPersistence()
				   .findByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}

	/**
	* Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @return the matching video user video group entry, or <code>null</code> if a matching video user video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry fetchByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}

	/**
	* Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching video user video group entry, or <code>null</code> if a matching video user video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserVideoGroupEntry fetchByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByVideoUser_VideoGroup(videoUserId, videoGroupId,
			retrieveFromCache);
	}

	/**
	* Returns all the video user video group entries.
	*
	* @return the video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video user video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user video group entries
	* @param end the upper bound of the range of video user video group entries (not inclusive)
	* @return the range of video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video user video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user video group entries
	* @param end the upper bound of the range of video user video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserVideoGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; from the database.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoUser_VideoGroup(long videoUserId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException {
		getPersistence().removeByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}

	/**
	* Removes all the video user video group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video user video group entries where videoUserId = &#63; and videoGroupId = &#63;.
	*
	* @param videoUserId the video user ID
	* @param videoGroupId the video group ID
	* @return the number of matching video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoUser_VideoGroup(long videoUserId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByVideoUser_VideoGroup(videoUserId, videoGroupId);
	}

	/**
	* Returns the number of video user video group entries.
	*
	* @return the number of video user video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoUserVideoGroupEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoUserVideoGroupEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoUserVideoGroupEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoUserVideoGroupEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VideoUserVideoGroupEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VideoUserVideoGroupEntryUtil.class,
			"_persistence");
	}

	private static VideoUserVideoGroupEntryPersistence _persistence;
}