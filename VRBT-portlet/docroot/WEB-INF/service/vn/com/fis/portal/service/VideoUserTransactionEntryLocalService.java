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
 * The interface for the video user transaction entry local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see VideoUserTransactionEntryLocalServiceUtil
 * @see vn.com.fis.portal.service.base.VideoUserTransactionEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.VideoUserTransactionEntryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface VideoUserTransactionEntryLocalService
	extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUserTransactionEntryLocalServiceUtil} to access the video user transaction entry local service. Add custom service methods to {@link vn.com.fis.portal.service.impl.VideoUserTransactionEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the video user transaction entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @return the video user transaction entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserTransactionEntry addVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new video user transaction entry with the primary key. Does not add the video user transaction entry to the database.
	*
	* @param transactionId the primary key for the new video user transaction entry
	* @return the new video user transaction entry
	*/
	public vn.com.fis.portal.model.VideoUserTransactionEntry createVideoUserTransactionEntry(
		long transactionId);

	/**
	* Deletes the video user transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @throws PortalException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoUserTransactionEntry(long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the video user transaction entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
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
	public vn.com.fis.portal.model.VideoUserTransactionEntry fetchVideoUserTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the video user transaction entry with the primary key.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @return the video user transaction entry
	* @throws PortalException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public vn.com.fis.portal.model.VideoUserTransactionEntry getVideoUserTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransactionEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries.
	*
	* @return the number of video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getVideoUserTransactionEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the video user transaction entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @return the video user transaction entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserTransactionEntry updateVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the video user transaction entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @param merge whether to merge the video user transaction entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video user transaction entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.VideoUserTransactionEntry updateVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry,
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
	* Returns all the video user transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries where transactionCode = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries where transactionCode = &#63;.
	*
	* @param transactionCode the transaction code
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByTransactionCode(long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user transaction entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries where date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param date_ the date_
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByDate(
		java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries where date_ = &#63;.
	*
	* @param date_ the date_
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByDate(java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, java.util.Date date_, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	*
	* @param transactionCode the transaction code
	* @param date_ the date_
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByTransactionCode_Date(long transactionCode,
		java.util.Date date_)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user transaction entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user transaction entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the video user transaction entries where receiverId = &#63;.
	*
	* @param receiverId the receiver ID
	* @return the matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the video user transaction entries where receiverId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param receiverId the receiver ID
	* @param start the lower bound of the range of video user transaction entries
	* @param end the upper bound of the range of video user transaction entries (not inclusive)
	* @return the range of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> findByreceiverId(
		long receiverId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of video user transaction entries where receiverId = &#63;.
	*
	* @param receiverId the receiver ID
	* @return the number of matching video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByreceiverId(long receiverId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(
		long transactionCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_VideoUserTransaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countSeachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countSeachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName)
		throws com.liferay.portal.kernel.exception.SystemException;
}