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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the rating entry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see RatingEntryLocalServiceUtil
 * @see vn.com.fis.portal.service.base.RatingEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.RatingEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RatingEntryLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RatingEntryLocalServiceUtil} to access the rating entry local service. Add custom service methods to {@link vn.com.fis.portal.service.impl.RatingEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the rating entry to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @return the rating entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry addRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new rating entry with the primary key. Does not add the rating entry to the database.
	*
	* @param ratingId the primary key for the new rating entry
	* @return the new rating entry
	*/
	public vn.com.fis.portal.model.RatingEntry createRatingEntry(long ratingId);

	/**
	* Deletes the rating entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating entry
	* @throws PortalException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the rating entry from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.RatingEntry fetchRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rating entry with the primary key.
	*
	* @param ratingId the primary key of the rating entry
	* @return the rating entry
	* @throws PortalException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.RatingEntry getRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.RatingEntry> getRatingEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries.
	*
	* @return the number of rating entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getRatingEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the rating entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @return the rating entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.RatingEntry updateRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	/**
	* Returns all the rating entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rating entries where code = &#63;.
	*
	* @param code the code
	* @return the matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByRatingCode(
		int code) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rating entries where code = &#63;.
	*
	* @param code the code
	* @return the number of matching rating entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByRatingCode(int code)
		throws com.liferay.portal.kernel.exception.SystemException;

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
			vn.com.fis.portal.NoSuchRatingEntryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.RatingEntry fetchByUser_Video_Code(
		long userId, long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
			vn.com.fis.portal.NoSuchRatingEntryException;

	public vn.com.fis.portal.model.RatingEntry findByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchRatingEntryException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.RatingEntry fetchByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.RatingEntry> findByVideoId_Code(
		long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countByVideoId_Code(long videoId, int code)
		throws com.liferay.portal.kernel.exception.SystemException;
}