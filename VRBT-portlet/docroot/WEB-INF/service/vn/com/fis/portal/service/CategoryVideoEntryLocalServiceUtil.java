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
 * The utility for the category video entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.CategoryVideoEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see CategoryVideoEntryLocalService
 * @see vn.com.fis.portal.service.base.CategoryVideoEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.CategoryVideoEntryLocalServiceImpl
 * @generated
 */
public class CategoryVideoEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.CategoryVideoEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the category video entry to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @return the category video entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry addCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCategoryVideoEntry(categoryVideoEntry);
	}

	/**
	* Creates a new category video entry with the primary key. Does not add the category video entry to the database.
	*
	* @param categoryViceoId the primary key for the new category video entry
	* @return the new category video entry
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry createCategoryVideoEntry(
		long categoryViceoId) {
		return getService().createCategoryVideoEntry(categoryViceoId);
	}

	/**
	* Deletes the category video entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @throws PortalException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCategoryVideoEntry(long categoryViceoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategoryVideoEntry(categoryViceoId);
	}

	/**
	* Deletes the category video entry from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategoryVideoEntry(categoryVideoEntry);
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

	public static vn.com.fis.portal.model.CategoryVideoEntry fetchCategoryVideoEntry(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCategoryVideoEntry(categoryViceoId);
	}

	/**
	* Returns the category video entry with the primary key.
	*
	* @param categoryViceoId the primary key of the category video entry
	* @return the category video entry
	* @throws PortalException if a category video entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry getCategoryVideoEntry(
		long categoryViceoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryVideoEntry(categoryViceoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the category video entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> getCategoryVideoEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryVideoEntries(start, end);
	}

	/**
	* Returns the number of category video entries.
	*
	* @return the number of category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getCategoryVideoEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryVideoEntriesCount();
	}

	/**
	* Updates the category video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @return the category video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry updateCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryVideoEntry(categoryVideoEntry);
	}

	/**
	* Updates the category video entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryVideoEntry the category video entry
	* @param merge whether to merge the category video entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category video entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryVideoEntry updateCategoryVideoEntry(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryVideoEntry(categoryVideoEntry, merge);
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
	* Returns all the category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByC_V(categoryId, videoId);
	}

	/**
	* Returns a range of all the category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByC_V(
		long categoryId, long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByC_V(categoryId, videoId, start, end);
	}

	/**
	* Returns the number of category video entries where categoryId = &#63; and videoId = &#63;.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_V(long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByC_V(categoryId, videoId);
	}

	/**
	* Removes all the category video entries where categoryId = &#63; and videoId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_V(long categoryId, long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByC_V(categoryId, videoId);
	}

	/**
	* Returns all the category video entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByVideoId(
		long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByVideoId(videoId);
	}

	/**
	* Returns a range of all the category video entries where videoId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param videoId the video ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByVideoId(
		long videoId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByVideoId(videoId, start, end);
	}

	/**
	* Returns the number of category video entries where videoId = &#63;.
	*
	* @param videoId the video ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByVideoId(videoId);
	}

	/**
	* Removes all the category video entries where videoId = &#63; from the database.
	*
	* @param videoId the video ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByVideoId(long videoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByVideoId(videoId);
	}

	/**
	* Returns all the category video entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryId(categoryId);
	}

	/**
	* Returns a range of all the category video entries where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of category video entries
	* @param end the upper bound of the range of category video entries (not inclusive)
	* @return the range of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryVideoEntry> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryId(categoryId, start, end);
	}

	/**
	* Returns the number of category video entries where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching category video entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryId(categoryId);
	}

	/**
	* Removes all the category video entries where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByCategoryId(categoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CategoryVideoEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CategoryVideoEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CategoryVideoEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new CategoryVideoEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CategoryVideoEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CategoryVideoEntryLocalService.class);
		}

		return _service;
	}

	public void setService(CategoryVideoEntryLocalService service) {
		MethodCache.remove(CategoryVideoEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CategoryVideoEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CategoryVideoEntryLocalService.class);
	}

	private static CategoryVideoEntryLocalService _service;
}