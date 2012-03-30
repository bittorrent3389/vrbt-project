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
 * The utility for the rating entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.RatingEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see RatingEntryLocalService
 * @see vn.com.fis.portal.service.base.RatingEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.RatingEntryLocalServiceImpl
 * @generated
 */
public class RatingEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.RatingEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the rating entry to the database. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @return the rating entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.RatingEntry addRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRatingEntry(ratingEntry);
	}

	/**
	* Creates a new rating entry with the primary key. Does not add the rating entry to the database.
	*
	* @param ratingId the primary key for the new rating entry
	* @return the new rating entry
	*/
	public static vn.com.fis.portal.model.RatingEntry createRatingEntry(
		long ratingId) {
		return getService().createRatingEntry(ratingId);
	}

	/**
	* Deletes the rating entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingId the primary key of the rating entry
	* @throws PortalException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteRatingEntry(long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRatingEntry(ratingId);
	}

	/**
	* Deletes the rating entry from the database. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRatingEntry(ratingEntry);
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

	public static vn.com.fis.portal.model.RatingEntry fetchRatingEntry(
		long ratingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRatingEntry(ratingId);
	}

	/**
	* Returns the rating entry with the primary key.
	*
	* @param ratingId the primary key of the rating entry
	* @return the rating entry
	* @throws PortalException if a rating entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.RatingEntry getRatingEntry(
		long ratingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingEntry(ratingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.com.fis.portal.model.RatingEntry> getRatingEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingEntries(start, end);
	}

	/**
	* Returns the number of rating entries.
	*
	* @return the number of rating entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getRatingEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRatingEntriesCount();
	}

	/**
	* Updates the rating entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @return the rating entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.RatingEntry updateRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRatingEntry(ratingEntry);
	}

	/**
	* Updates the rating entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ratingEntry the rating entry
	* @param merge whether to merge the rating entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the rating entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.RatingEntry updateRatingEntry(
		vn.com.fis.portal.model.RatingEntry ratingEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRatingEntry(ratingEntry, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static RatingEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RatingEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					RatingEntryLocalService.class.getName(), portletClassLoader);

			_service = new RatingEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(RatingEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(RatingEntryLocalService.class);
		}

		return _service;
	}

	public void setService(RatingEntryLocalService service) {
		MethodCache.remove(RatingEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(RatingEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(RatingEntryLocalService.class);
	}

	private static RatingEntryLocalService _service;
}