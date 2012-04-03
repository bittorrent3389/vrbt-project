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
 * The interface for the video group entry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see VideoGroupEntryLocalServiceUtil
 * @see vn.com.fis.portal.service.base.VideoGroupEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.VideoGroupEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VideoGroupEntryLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoGroupEntryLocalServiceUtil} to access the video group entry local service. Add custom service methods to {@link vn.com.fis.portal.service.impl.VideoGroupEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the video group entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoGroupEntry the video group entry
	* @return the video group entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry addVideoGroupEntry(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new video group entry with the primary key. Does not add the video group entry to the database.
	*
	* @param videoGroupId the primary key for the new video group entry
	* @return the new video group entry
	*/
	public vn.com.fis.portal.model.VideoGroupEntry createVideoGroupEntry(
		long videoGroupId);

	/**
	* Deletes the video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param videoGroupId the primary key of the video group entry
	* @throws PortalException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoGroupEntry(long videoGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the video group entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoGroupEntry the video group entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoGroupEntry(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry)
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
	public vn.com.fis.portal.model.VideoGroupEntry fetchVideoGroupEntry(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video group entry with the primary key.
	*
	* @param videoGroupId the primary key of the video group entry
	* @return the video group entry
	* @throws PortalException if a video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.VideoGroupEntry getVideoGroupEntry(
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> getVideoGroupEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video group entries.
	*
	* @return the number of video group entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideoGroupEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the video group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoGroupEntry the video group entry
	* @return the video group entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry updateVideoGroupEntry(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the video group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoGroupEntry the video group entry
	* @param merge whether to merge the video group entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video group entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoGroupEntry updateVideoGroupEntry(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry, boolean merge)
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
	* Returns all the video group entries where videoGroupName = &#63;.
	*
	* @param videoGroupName the video group name
	* @return the matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.fis.portal.model.VideoGroupEntry> findByGroupName(
		java.lang.String videoGroupName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video group entries where videoGroupName = &#63;.
	*
	* @param videoGroupName the video group name
	* @return the number of matching video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupName(java.lang.String videoGroupName)
		throws com.liferay.portal.kernel.exception.SystemException;
}