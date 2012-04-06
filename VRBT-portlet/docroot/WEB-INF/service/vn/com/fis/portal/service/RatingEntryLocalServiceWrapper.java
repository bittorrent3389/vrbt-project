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
 * This class is a wrapper for {@link RatingEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       RatingEntryLocalService
 * @generated
 */
public class RatingEntryLocalServiceWrapper implements RatingEntryLocalService,
	ServiceWrapper<RatingEntryLocalService> {
	public RatingEntryLocalServiceWrapper(
		RatingEntryLocalService ratingEntryLocalService) {
		_ratingEntryLocalService = ratingEntryLocalService;
	}

	/**
	* Adds the rating entry to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @return the rating entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry addRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.addRatingEntry(ratingEntry);
	}

	/**
	* Creates a new rating entry with the primary key. Does not add the rating entry to the database.
	*
	* @param ratingId the primary key for the new rating entry
	* @return the new rating entry
	*/
	public vn.com.fis.portal.model.RatingEntry createRatingEntry(long ratingId) {
		return _ratingEntryLocalService.createRatingEntry(ratingId);
	}

	/**
	* Deletes the rating entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating entry
	* @throws PortalException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ratingEntryLocalService.deleteRatingEntry(ratingId);
	}

	/**
	* Deletes the rating entry from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_ratingEntryLocalService.deleteRatingEntry(ratingEntry);
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
		return _ratingEntryLocalService.dynamicQuery(dynamicQuery);
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
		return _ratingEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _ratingEntryLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _ratingEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.RatingEntry fetchRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.fetchRatingEntry(ratingId);
	}

	/**
	* Returns the rating entry with the primary key.
	*
	* @param ratingId the primary key of the rating entry
	* @return the rating entry
	* @throws PortalException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry getRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.getRatingEntry(ratingId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the rating entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> getRatingEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.getRatingEntries(start, end);
	}

	/**
	* Returns the number of rating entries.
	*
	* @return the number of rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int getRatingEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.getRatingEntriesCount();
	}

	/**
	* Updates the rating entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @return the rating entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry updateRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.updateRatingEntry(ratingEntry);
	}

	/**
	* Updates the rating entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @param merge whether to merge the rating entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the rating entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry updateRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.updateRatingEntry(ratingEntry, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ratingEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ratingEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns all the rating entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByVideoId(videoId);
	}

	/**
	* Returns a range of all the rating entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByVideoId(videoId, start, end);
	}

	/**
	* Returns the number of rating entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.countByVideoId(videoId);
	}

	/**
	* Returns all the rating entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByUserId(userId);
	}

	/**
	* Returns a range of all the rating entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByUserId(userId, start, end);
	}

	/**
	* Returns the number of rating entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.countByUserId(userId);
	}

	/**
	* Returns all the rating entries where code = &#63;.
	*
	* @param code the code
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByRatingCode(
		int code) throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByRatingCode(code);
	}

	/**
	* Returns a range of all the rating entries where code = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param code the code
	* @param start the lower bound of the range of rating entries
	* @param end the upper bound of the range of rating entries (not inclusive)
	* @return the range of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByRatingCode(
		int code, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByRatingCode(code, start, end);
	}

	/**
	* Returns the number of rating entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByRatingCode(int code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.countByRatingCode(code);
	}

	/**
	* Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @return the matching rating entry
	* @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry findByUser_Video_Code(
		long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException {
		return _ratingEntryLocalService.findByUser_Video_Code(userId, videoId,
			code);
	}

	public vn.com.fis.portal.model.RatingEntry fetchByUser_Video_Code(
		long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.fetchByUser_Video_Code(userId, videoId,
			code);
	}

	/**
	* Returns the number of rating entries where userId = &#63; and videoId = &#63; and code = &#63;.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUser_Video_Code(long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.countByUser_Video_Code(userId, videoId,
			code);
	}

	/**
	* Removes the rating entry where userId = &#63; and videoId = &#63; and code = &#63; from the database.
	*
	* @param userId the user ID
	* @param videoId the video ID
	* @param code the code
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUser_Video_Code(long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException {
		_ratingEntryLocalService.removeByUser_Video_Code(userId, videoId, code);
	}

	public vn.com.fis.portal.model.RatingEntry findByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException {
		return _ratingEntryLocalService.findByVideoId_UserId(videoId, userId);
	}

	public vn.com.fis.portal.model.RatingEntry fetchByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.fetchByVideoId_UserId(videoId, userId);
	}

	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_Code(
		long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.findByVideoId_Code(videoId, code);
	}

	public int countByVideoId_Code(long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingEntryLocalService.countByVideoId_Code(videoId, code);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public RatingEntryLocalService getWrappedRatingEntryLocalService() {
		return _ratingEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedRatingEntryLocalService(
		RatingEntryLocalService ratingEntryLocalService) {
		_ratingEntryLocalService = ratingEntryLocalService;
	}

	public RatingEntryLocalService getWrappedService() {
		return _ratingEntryLocalService;
	}

	public void setWrappedService(
		RatingEntryLocalService ratingEntryLocalService) {
		_ratingEntryLocalService = ratingEntryLocalService;
	}

	private RatingEntryLocalService _ratingEntryLocalService;
}