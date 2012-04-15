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
 * The interface for the violation video entry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see ViolationVideoEntryLocalServiceUtil
 * @see vn.com.fis.portal.service.base.ViolationVideoEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.ViolationVideoEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ViolationVideoEntryLocalService
	extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViolationVideoEntryLocalServiceUtil} to access the violation video entry local service. Add custom service methods to {@link vn.com.fis.portal.service.impl.ViolationVideoEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the violation video entry to the database. Also notifies the appropriate model listeners.
	*
	* @param violationVideoEntry the violation video entry
	* @return the violation video entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry addViolationVideoEntry(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new violation video entry with the primary key. Does not add the violation video entry to the database.
	*
	* @param violationVideoId the primary key for the new violation video entry
	* @return the new violation video entry
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry createViolationVideoEntry(
		long violationVideoId);

	/**
	* Deletes the violation video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param violationVideoId the primary key of the violation video entry
	* @throws PortalException if a violation video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteViolationVideoEntry(long violationVideoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the violation video entry from the database. Also notifies the appropriate model listeners.
	*
	* @param violationVideoEntry the violation video entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteViolationVideoEntry(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry)
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
	public vn.com.fis.portal.model.ViolationVideoEntry fetchViolationVideoEntry(
		long violationVideoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the violation video entry with the primary key.
	*
	* @param violationVideoId the primary key of the violation video entry
	* @return the violation video entry
	* @throws PortalException if a violation video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.ViolationVideoEntry getViolationVideoEntry(
		long violationVideoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of violation video entries
	* @param end the upper bound of the range of violation video entries (not inclusive)
	* @return the range of violation video entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> getViolationVideoEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation video entries.
	*
	* @return the number of violation video entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getViolationVideoEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the violation video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param violationVideoEntry the violation video entry
	* @return the violation video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry updateViolationVideoEntry(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the violation video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param violationVideoEntry the violation video entry
	* @param merge whether to merge the violation video entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the violation video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry updateViolationVideoEntry(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry,
		boolean merge)
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
	* Returns all the violation video entries where videoId = &#63; and userId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @return the matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findByVideoId_UserId(
		long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the violation video entries where videoId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param start the lower bound of the range of violation video entries
	* @param end the upper bound of the range of violation video entries (not inclusive)
	* @return the range of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationVideoEntry> findByVideoId_UserId(
		long videoId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of violation video entries where videoId = &#63; and userId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @return the number of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId_UserId(long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the violation video entries where videoId = &#63; and userId = &#63; from the database.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVideoId_UserId(long videoId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or throws a {@link vn.com.fis.portal.NoSuchViolationVideoEntryException} if it could not be found.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @return the matching violation video entry
	* @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationVideoEntry findByVideo_User_Violation(
		long videoId, long userId, long violationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchViolationVideoEntryException;

	/**
	* Returns the number of violation video entries where videoId = &#63; and userId = &#63; and violationId = &#63;.
	*
	* @param videoId the video ID
	* @param userId the user ID
	* @param violationId the violation ID
	* @return the number of matching violation video entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideo_User_Violation(long videoId, long userId,
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException;
}