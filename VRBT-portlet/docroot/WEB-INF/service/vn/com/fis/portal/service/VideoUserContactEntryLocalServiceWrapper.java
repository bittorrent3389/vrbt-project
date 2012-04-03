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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link VideoUserContactEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       VideoUserContactEntryLocalService
 * @generated
 */
public class VideoUserContactEntryLocalServiceWrapper
	implements VideoUserContactEntryLocalService,
		ServiceWrapper<VideoUserContactEntryLocalService> {
	public VideoUserContactEntryLocalServiceWrapper(
		VideoUserContactEntryLocalService videoUserContactEntryLocalService) {
		_videoUserContactEntryLocalService = videoUserContactEntryLocalService;
	}

	/**
	* Adds the video user contact entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactEntry the video user contact entry
	* @return the video user contact entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry addVideoUserContactEntry(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.addVideoUserContactEntry(videoUserContactEntry);
	}

	/**
	* Creates a new video user contact entry with the primary key. Does not add the video user contact entry to the database.
	*
	* @param videoUserContactId the primary key for the new video user contact entry
	* @return the new video user contact entry
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry createVideoUserContactEntry(
		long videoUserContactId) {
		return _videoUserContactEntryLocalService.createVideoUserContactEntry(videoUserContactId);
	}

	/**
	* Deletes the video user contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @throws PortalException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoUserContactEntry(long videoUserContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_videoUserContactEntryLocalService.deleteVideoUserContactEntry(videoUserContactId);
	}

	/**
	* Deletes the video user contact entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactEntry the video user contact entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoUserContactEntry(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoUserContactEntryLocalService.deleteVideoUserContactEntry(videoUserContactEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.VideoUserContactEntry fetchVideoUserContactEntry(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.fetchVideoUserContactEntry(videoUserContactId);
	}

	/**
	* Returns the video user contact entry with the primary key.
	*
	* @param videoUserContactId the primary key of the video user contact entry
	* @return the video user contact entry
	* @throws PortalException if a video user contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry getVideoUserContactEntry(
		long videoUserContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.getVideoUserContactEntry(videoUserContactId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the video user contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user contact entries
	* @param end the upper bound of the range of video user contact entries (not inclusive)
	* @return the range of video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> getVideoUserContactEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.getVideoUserContactEntries(start,
			end);
	}

	/**
	* Returns the number of video user contact entries.
	*
	* @return the number of video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int getVideoUserContactEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.getVideoUserContactEntriesCount();
	}

	/**
	* Updates the video user contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactEntry the video user contact entry
	* @return the video user contact entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry updateVideoUserContactEntry(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.updateVideoUserContactEntry(videoUserContactEntry);
	}

	/**
	* Updates the video user contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserContactEntry the video user contact entry
	* @param merge whether to merge the video user contact entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video user contact entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserContactEntry updateVideoUserContactEntry(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.updateVideoUserContactEntry(videoUserContactEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _videoUserContactEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_videoUserContactEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @return the matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.findByContactId_VideoUserId(contactId,
			videoUserId);
	}

	/**
	* Returns a range of all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @param start the lower bound of the range of video user contact entries
	* @param end the upper bound of the range of video user contact entries (not inclusive)
	* @return the range of matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.findByContactId_VideoUserId(contactId,
			videoUserId, start, end);
	}

	/**
	* Returns the number of video user contact entries where contactId = &#63; and videoUserId = &#63;.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @return the number of matching video user contact entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactId_VideoUserId(long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoUserContactEntryLocalService.countByContactId_VideoUserId(contactId,
			videoUserId);
	}

	/**
	* Removes all the video user contact entries where contactId = &#63; and videoUserId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param videoUserId the video user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactId_VideoUserId(long contactId, long videoUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoUserContactEntryLocalService.removeByContactId_VideoUserId(contactId,
			videoUserId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public VideoUserContactEntryLocalService getWrappedVideoUserContactEntryLocalService() {
		return _videoUserContactEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedVideoUserContactEntryLocalService(
		VideoUserContactEntryLocalService videoUserContactEntryLocalService) {
		_videoUserContactEntryLocalService = videoUserContactEntryLocalService;
	}

	public VideoUserContactEntryLocalService getWrappedService() {
		return _videoUserContactEntryLocalService;
	}

	public void setWrappedService(
		VideoUserContactEntryLocalService videoUserContactEntryLocalService) {
		_videoUserContactEntryLocalService = videoUserContactEntryLocalService;
	}

	private VideoUserContactEntryLocalService _videoUserContactEntryLocalService;
}