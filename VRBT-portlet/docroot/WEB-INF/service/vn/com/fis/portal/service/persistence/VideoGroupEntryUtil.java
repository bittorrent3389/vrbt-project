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

import vn.com.fis.portal.model.VideoGroupEntry;

import java.util.List;

/**
 * The persistence utility for the video group entry service. This utility wraps {@link VideoGroupEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoGroupEntryPersistence
 * @see VideoGroupEntryPersistenceImpl
 * @generated
 */
public class VideoGroupEntryUtil {
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
	public static void clearCache(VideoGroupEntry videoGroupEntry) {
		getPersistence().clearCache(videoGroupEntry);
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
	public static List<VideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<VideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<VideoGroupEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static VideoGroupEntry update(VideoGroupEntry videoGroupEntry,
		boolean merge) throws SystemException {
		return getPersistence().update(videoGroupEntry, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static VideoGroupEntry update(VideoGroupEntry videoGroupEntry,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(videoGroupEntry, merge, serviceContext);
	}

	/**
	* Caches the video group entry in the entity cache if it is enabled.
	*
	* @param videoGroupEntry the video group entry
	*/
	public static void cacheResult(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry) {
		getPersistence().cacheResult(videoGroupEntry);
	}

	/**
	* Caches the video group entries in the entity cache if it is enabled.
	*
	* @param videoGroupEntries the video group entries
	*/
	public static void cacheResult(
		java.util.List<vn.com.fis.portal.model.VideoGroupEntry> videoGroupEntries) {
		getPersistence().cacheResult(videoGroupEntries);
	}

	/**
	* Creates a new video group entry with the primary key. Does not add the video group entry to the database.
	*
	* @param videoGroupId the primary key for the new video group entry
	* @return the new video group entry
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry create(
		long videoGroupId) {
		return getPersistence().create(videoGroupId);
	}

	/**
	* Removes the video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry that was removed
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry remove(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException {
		return getPersistence().remove(videoGroupId);
	}

	public static vn.com.fis.portal.model.VideoGroupEntry updateImpl(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(videoGroupEntry, merge);
	}

	/**
	* Returns the video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoGroupEntryException} if it could not be found.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry findByPrimaryKey(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException {
		return getPersistence().findByPrimaryKey(videoGroupId);
	}

	/**
	* Returns the video group entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry, or <code>null</code> if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry fetchByPrimaryKey(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(videoGroupId);
	}

	/**
	* Returns all the video group entries where videoGroupName = &#63;.
	*
	* @param videoGroupName the video group name
	* @return the matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupName(videoGroupName);
	}

	/**
	* Returns a range of all the video group entries where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @return the range of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupName(videoGroupName, start, end);
	}

	/**
	* Returns an ordered range of all the video group entries where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupName(videoGroupName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first video group entry in the ordered set where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a matching video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry findByGroupName_First(
		java.lang.String videoGroupName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException {
		return getPersistence()
				   .findByGroupName_First(videoGroupName, orderByComparator);
	}

	/**
	* Returns the last video group entry in the ordered set where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupName the video group name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a matching video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry findByGroupName_Last(
		java.lang.String videoGroupName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException {
		return getPersistence()
				   .findByGroupName_Last(videoGroupName, orderByComparator);
	}

	/**
	* Returns the video group entries before and after the current video group entry in the ordered set where videoGroupName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoGroupId the primary key of the current video group entry
	* @param videoGroupName the video group name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next video group entry
	* @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoGroupEntry[] findByGroupName_PrevAndNext(
		long videoGroupId, java.lang.String videoGroupName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchVideoGroupEntryException {
		return getPersistence()
				   .findByGroupName_PrevAndNext(videoGroupId, videoGroupName,
			orderByComparator);
	}

	/**
	* Returns all the video group entries.
	*
	* @return the video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @return the range of video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video group entries
	* @param end the upper bound of the range of video group entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the video group entries where videoGroupName = &#63; from the database.
	*
	* @param videoGroupName the video group name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupName(java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupName(videoGroupName);
	}

	/**
	* Removes all the video group entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of video group entries where videoGroupName = &#63;.
	*
	* @param videoGroupName the video group name
	* @return the number of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupName(java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupName(videoGroupName);
	}

	/**
	* Returns the number of video group entries.
	*
	* @return the number of video group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static VideoGroupEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (VideoGroupEntryPersistence)PortletBeanLocatorUtil.locate(vn.com.fis.portal.service.ClpSerializer.getServletContextName(),
					VideoGroupEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(VideoGroupEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(VideoGroupEntryPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(VideoGroupEntryUtil.class,
			"_persistence");
	}

	private static VideoGroupEntryPersistence _persistence;
}