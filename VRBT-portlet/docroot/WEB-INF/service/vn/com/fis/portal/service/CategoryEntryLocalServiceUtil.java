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
 * The utility for the category entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.CategoryEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see CategoryEntryLocalService
 * @see vn.com.fis.portal.service.base.CategoryEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.CategoryEntryLocalServiceImpl
 * @generated
 */
public class CategoryEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.CategoryEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the category entry to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryEntry the category entry
	* @return the category entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry addCategoryEntry(
		vn.com.fis.portal.model.CategoryEntry categoryEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCategoryEntry(categoryEntry);
	}

	/**
	* Creates a new category entry with the primary key. Does not add the category entry to the database.
	*
	* @param categoryId the primary key for the new category entry
	* @return the new category entry
	*/
	public static vn.com.fis.portal.model.CategoryEntry createCategoryEntry(
		long categoryId) {
		return getService().createCategoryEntry(categoryId);
	}

	/**
	* Deletes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category entry
	* @throws PortalException if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCategoryEntry(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategoryEntry(categoryId);
	}

	/**
	* Deletes the category entry from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryEntry the category entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCategoryEntry(
		vn.com.fis.portal.model.CategoryEntry categoryEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategoryEntry(categoryEntry);
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

	public static vn.com.fis.portal.model.CategoryEntry fetchCategoryEntry(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCategoryEntry(categoryId);
	}

	/**
	* Returns the category entry with the primary key.
	*
	* @param categoryId the primary key of the category entry
	* @return the category entry
	* @throws PortalException if a category entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry getCategoryEntry(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryEntry(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the category entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category entries
	* @param end the upper bound of the range of category entries (not inclusive)
	* @return the range of category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> getCategoryEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryEntries(start, end);
	}

	/**
	* Returns the number of category entries.
	*
	* @return the number of category entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getCategoryEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryEntriesCount();
	}

	/**
	* Updates the category entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryEntry the category entry
	* @return the category entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry updateCategoryEntry(
		vn.com.fis.portal.model.CategoryEntry categoryEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryEntry(categoryEntry);
	}

	/**
	* Updates the category entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryEntry the category entry
	* @param merge whether to merge the category entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry updateCategoryEntry(
		vn.com.fis.portal.model.CategoryEntry categoryEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryEntry(categoryEntry, merge);
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
	* Returns all the category entries where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findByCategoryName(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryName(categoryName);
	}

	/**
	* Returns a range of all the category enties where categoryName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param categoryName the category name
	* @param start the lower bound of the range of category enties
	* @param end the upper bound of the range of category enties (not inclusive)
	* @return the range of matching category enties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEntry> findByCategoryName(
		java.lang.String categoryName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByCategoryName(categoryName, start, end);
	}

	/**
	* Returns the number of category enties where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching category enties
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryName(categoryName);
	}

	/**
	* Returns the category entry where categoryName = &#63; or throws a {@link vn.com.fis.portal.NoSuchCategoryEntryException} if it could not be found.
	*
	* @param categoryName the category name
	* @return the matching category entry
	* @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEntry findByCategoryNameAbsolute(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		return getService().findByCategoryNameAbsolute(categoryName);
	}

	/**
	* Returns the number of category entries where categoryName = &#63;.
	*
	* @param categoryName the category name
	* @return the number of matching category entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryNameAbsolute(java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByCategoryNameAbsolute(categoryName);
	}

	/**
	* Removes the category entry where categoryName = &#63; from the database.
	*
	* @param categoryName the category name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryNameAbsolute(
		java.lang.String categoryName)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchCategoryEntryException {
		getService().removeByCategoryNameAbsolute(categoryName);
	}

	public static void clearService() {
		_service = null;
	}

	public static CategoryEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CategoryEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CategoryEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new CategoryEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CategoryEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CategoryEntryLocalService.class);
		}

		return _service;
	}

	public void setService(CategoryEntryLocalService service) {
		MethodCache.remove(CategoryEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CategoryEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CategoryEntryLocalService.class);
	}

	private static CategoryEntryLocalService _service;
}