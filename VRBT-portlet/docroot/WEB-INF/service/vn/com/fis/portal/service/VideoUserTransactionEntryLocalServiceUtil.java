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
 * The utility for the video user transaction entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.VideoUserTransactionEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see VideoUserTransactionEntryLocalService
 * @see vn.com.fis.portal.service.base.VideoUserTransactionEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.VideoUserTransactionEntryLocalServiceImpl
 * @generated
 */
public class VideoUserTransactionEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.VideoUserTransactionEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the video user transaction entry to the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @return the video user transaction entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry addVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVideoUserTransactionEntry(videoUserTransactionEntry);
	}

	/**
	* Creates a new video user transaction entry with the primary key. Does not add the video user transaction entry to the database.
	*
	* @param transactionId the primary key for the new video user transaction entry
	* @return the new video user transaction entry
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry createVideoUserTransactionEntry(
		long transactionId) {
		return getService().createVideoUserTransactionEntry(transactionId);
	}

	/**
	* Deletes the video user transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @throws PortalException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVideoUserTransactionEntry(long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVideoUserTransactionEntry(transactionId);
	}

	/**
	* Deletes the video user transaction entry from the database. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVideoUserTransactionEntry(videoUserTransactionEntry);
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

	public static vn.com.fis.portal.model.VideoUserTransactionEntry fetchVideoUserTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVideoUserTransactionEntry(transactionId);
	}

	/**
	* Returns the video user transaction entry with the primary key.
	*
	* @param transactionId the primary key of the video user transaction entry
	* @return the video user transaction entry
	* @throws PortalException if a video user transaction entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry getVideoUserTransactionEntry(
		long transactionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoUserTransactionEntry(transactionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransactionEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoUserTransactionEntries(start, end);
	}

	/**
	* Returns the number of video user transaction entries.
	*
	* @return the number of video user transaction entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getVideoUserTransactionEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVideoUserTransactionEntriesCount();
	}

	/**
	* Updates the video user transaction entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @return the video user transaction entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry updateVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVideoUserTransactionEntry(videoUserTransactionEntry);
	}

	/**
	* Updates the video user transaction entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param videoUserTransactionEntry the video user transaction entry
	* @param merge whether to merge the video user transaction entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the video user transaction entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.VideoUserTransactionEntry updateVideoUserTransactionEntry(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVideoUserTransactionEntry(videoUserTransactionEntry,
			merge);
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

	public static int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(
		long transactionCode) {
		return getService()
				   .getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(transactionCode);
	}

	public static int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(transactionCode,
			startDate, endDate);
	}

	public static int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(uploadId,
			transactionCode);
	}

	public static int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,
			transactionCode, startDate, endDate);
	}

	public static int getCount_VideoUserTransaction_By_TransactionCode(
		long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_VideoUserTransaction_By_TransactionCode(transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(
		long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVideoUserTransaction_By_TransactionCode(transactionCode,
			start, end);
	}

	public static int getCount_VideoUserTransaction_By_transactionCode_And_Date(
		long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_VideoUserTransaction_By_transactionCode_And_Date(transactionCode,
			startDate, endDate);
	}

	public static int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_VideoUserTransaction_By_UserId_And_TransactionCode(uploadId,
			transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVideoUserTransaction_By_UserId_And_TransactionCode(uploadId,
			transactionCode, start, end);
	}

	public static int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(uploadId,
			transactionCode, startDate, endDate);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVideoUserTransaction_By_UploaderId_And_TransactionCode(uploadId,
			transactionCode, start, end);
	}

	public static int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(
		long uploadId, long transactionCode, java.lang.String startDate,
		java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(uploadId,
			transactionCode, startDate, endDate);
	}

	public static int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(
		long uploadId, long transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(uploadId,
			transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .seachVideoUserTransactionEntryByCondition(userName,
			videoName, transactionCode, start, end);
	}

	public static int countSeachVideoUserTransactionEntryByCondition(
		java.lang.String userName, java.lang.String videoName,
		java.lang.String transactionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countSeachVideoUserTransactionEntryByCondition(userName,
			videoName, transactionCode);
	}

	public static java.util.List<vn.com.fis.portal.model.VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .seachThirdPartyVideoUserTransactionEntryByCondition(trasactionCode,
			userId, videoName, start, end);
	}

	public static int countSeachThirdPartyVideoUserTransactionEntryByCondition(
		int trasactionCode, long userId, java.lang.String videoName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countSeachThirdPartyVideoUserTransactionEntryByCondition(trasactionCode,
			userId, videoName);
	}

	public static void clearService() {
		_service = null;
	}

	public static VideoUserTransactionEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VideoUserTransactionEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					VideoUserTransactionEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new VideoUserTransactionEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(VideoUserTransactionEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(VideoUserTransactionEntryLocalService.class);
		}

		return _service;
	}

	public void setService(VideoUserTransactionEntryLocalService service) {
		MethodCache.remove(VideoUserTransactionEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(VideoUserTransactionEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(VideoUserTransactionEntryLocalService.class);
	}

	private static VideoUserTransactionEntryLocalService _service;
}