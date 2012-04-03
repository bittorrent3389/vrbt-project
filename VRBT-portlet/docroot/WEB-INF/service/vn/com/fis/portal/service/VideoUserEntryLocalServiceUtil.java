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

package vn.com.fis.portal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the video user entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.VideoUserEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see VideoUserEntryLocalService
 * @see vn.com.fis.portal.service.base.VideoUserEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.VideoUserEntryLocalServiceImpl
 * @generated
 */
public class VideoUserEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.VideoUserEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the video user entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserEntry the video user entry
	* @return the video user entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry addVideoUserEntry(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addVideoUserEntry(videoUserEntry);
	}

	/**
	* Creates a new video user entry with the primary key. Does not add the video user entry to the database.
	*
	* @param videoUserId the primary key for the new video user entry
	* @return the new video user entry
	*/
	public static vn.com.fis.portal.model.VideoUserEntry createVideoUserEntry(
		long videoUserId) {
		return getService().createVideoUserEntry(videoUserId);
	}

	/**
	* Deletes the video user entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserId the primary key of the video user entry
	* @throws PortalException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVideoUserEntry(long videoUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVideoUserEntry(videoUserId);
	}

	/**
	* Deletes the video user entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserEntry the video user entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVideoUserEntry(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVideoUserEntry(videoUserEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static vn.com.fis.portal.model.VideoUserEntry fetchVideoUserEntry(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVideoUserEntry(videoUserId);
	}

	/**
	* Returns the video user entry with the primary key.
	*
	* @param videoUserId the primary key of the video user entry
	* @return the video user entry
	* @throws PortalException if a video user entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry getVideoUserEntry(
		long videoUserId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoUserEntry(videoUserId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video user entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @return the range of video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> getVideoUserEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoUserEntries(start, end);
	}

	/**
	* Returns the number of video user entries.
	*
	* @return the number of video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getVideoUserEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoUserEntriesCount();
	}

	/**
	* Updates the video user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserEntry the video user entry
	* @return the video user entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry updateVideoUserEntry(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoUserEntry(videoUserEntry);
	}

	/**
	* Updates the video user entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserEntry the video user entry
	* @param merge whether to merge the video user entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video user entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserEntry updateVideoUserEntry(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateVideoUserEntry(videoUserEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns all the video user entries where userId = &#63; and videoId = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @return the matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId_VideoId(userId, videoId);
	}

	/**
	* Returns a range of all the video user entries where userId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param start the lower bound of the range of video user entries
	* @param end the upper bound of the range of video user entries (not inclusive)
	* @return the range of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.VideoUserEntry> findByUserId_VideoId(
		long userId, long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId_VideoId(userId, videoId, start, end);
	}

	/**
	* Removes all the video user entries where userId = &#63; and videoId = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_VideoId(long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByUserId_VideoId(userId, videoId);
	}

	/**
	* Returns the number of video user entries where userId = &#63; and videoId = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @return the number of matching video user entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_VideoId(long userId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId_VideoId(userId, videoId);
	}

	public static void clearService() {
		_service = null;
	}

	public static VideoUserEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VideoUserEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VideoUserEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new VideoUserEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VideoUserEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(VideoUserEntryLocalService.class);
		}

		return _service;
	}

	public void setService(VideoUserEntryLocalService service) {
		MethodCache.remove(VideoUserEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(VideoUserEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(VideoUserEntryLocalService.class);
	}

	private static VideoUserEntryLocalService _service;
}