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
 * The utility for the category enty local service. This utility wraps {@link vn.com.fis.portal.service.impl.CategoryEntyLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see CategoryEntyLocalService
 * @see vn.com.fis.portal.service.base.CategoryEntyLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.CategoryEntyLocalServiceImpl
 * @generated
 */
public class CategoryEntyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.CategoryEntyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the category enty to the database. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @return the category enty that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEnty addCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCategoryEnty(categoryEnty);
	}

	/**
	* Creates a new category enty with the primary key. Does not add the category enty to the database.
	*
	* @param categoryId the primary key for the new category enty
	* @return the new category enty
	*/
	public static vn.com.fis.portal.model.CategoryEnty createCategoryEnty(
		long categoryId) {
		return getService().createCategoryEnty(categoryId);
	}

	/**
	* Deletes the category enty with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the category enty
	* @throws PortalException if a category enty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCategoryEnty(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategoryEnty(categoryId);
	}

	/**
	* Deletes the category enty from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteCategoryEnty(categoryEnty);
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

	public static vn.com.fis.portal.model.CategoryEnty fetchCategoryEnty(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCategoryEnty(categoryId);
	}

	/**
	* Returns the category enty with the primary key.
	*
	* @param categoryId the primary key of the category enty
	* @return the category enty
	* @throws PortalException if a category enty with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEnty getCategoryEnty(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryEnty(categoryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the category enties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of category enties
	* @param end the upper bound of the range of category enties (not inclusive)
	* @return the range of category enties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.CategoryEnty> getCategoryEnties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryEnties(start, end);
	}

	/**
	* Returns the number of category enties.
	*
	* @return the number of category enties
	* @throws SystemException if a system exception occurred
	*/
	public static int getCategoryEntiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryEntiesCount();
	}

	/**
	* Updates the category enty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @return the category enty that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEnty updateCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryEnty(categoryEnty);
	}

	/**
	* Updates the category enty in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoryEnty the category enty
	* @param merge whether to merge the category enty with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the category enty that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.CategoryEnty updateCategoryEnty(
		vn.com.fis.portal.model.CategoryEnty categoryEnty, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoryEnty(categoryEnty, merge);
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

	public static CategoryEntyLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CategoryEntyLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					CategoryEntyLocalService.class.getName(), portletClassLoader);

			_service = new CategoryEntyLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(CategoryEntyLocalServiceUtil.class,
				"_service");
			MethodCache.remove(CategoryEntyLocalService.class);
		}

		return _service;
	}

	public void setService(CategoryEntyLocalService service) {
		MethodCache.remove(CategoryEntyLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(CategoryEntyLocalServiceUtil.class,
			"_service");
		MethodCache.remove(CategoryEntyLocalService.class);
	}

	private static CategoryEntyLocalService _service;
}