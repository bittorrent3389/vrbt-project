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
 * The utility for the contact group entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.ContactGroupEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see ContactGroupEntryLocalService
 * @see vn.com.fis.portal.service.base.ContactGroupEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.ContactGroupEntryLocalServiceImpl
 * @generated
 */
public class ContactGroupEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.ContactGroupEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contact group entry to the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupEntry the contact group entry
	* @return the contact group entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry addContactGroupEntry(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactGroupEntry(contactGroupEntry);
	}

	/**
	* Creates a new contact group entry with the primary key. Does not add the contact group entry to the database.
	*
	* @param contactGroupId the primary key for the new contact group entry
	* @return the new contact group entry
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry createContactGroupEntry(
		long contactGroupId) {
		return getService().createContactGroupEntry(contactGroupId);
	}

	/**
	* Deletes the contact group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @throws PortalException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteContactGroupEntry(long contactGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContactGroupEntry(contactGroupId);
	}

	/**
	* Deletes the contact group entry from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupEntry the contact group entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteContactGroupEntry(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContactGroupEntry(contactGroupEntry);
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

	public static vn.com.fis.portal.model.ContactGroupEntry fetchContactGroupEntry(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactGroupEntry(contactGroupId);
	}

	/**
	* Returns the contact group entry with the primary key.
	*
	* @param contactGroupId the primary key of the contact group entry
	* @return the contact group entry
	* @throws PortalException if a contact group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry getContactGroupEntry(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactGroupEntry(contactGroupId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group entries
	* @param end the upper bound of the range of contact group entries (not inclusive)
	* @return the range of contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> getContactGroupEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactGroupEntries(start, end);
	}

	/**
	* Returns the number of contact group entries.
	*
	* @return the number of contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactGroupEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactGroupEntriesCount();
	}

	/**
	* Updates the contact group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactGroupEntry the contact group entry
	* @return the contact group entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry updateContactGroupEntry(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactGroupEntry(contactGroupEntry);
	}

	/**
	* Updates the contact group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactGroupEntry the contact group entry
	* @param merge whether to merge the contact group entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contact group entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry updateContactGroupEntry(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateContactGroupEntry(contactGroupEntry, merge);
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
	* Returns all the contact group entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(userId);
	}

	/**
	* Returns a range of all the contact group entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of contact group entries
	* @param end the upper bound of the range of contact group entries (not inclusive)
	* @return the range of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupEntry> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUserId(userId, start, end);
	}

	/**
	* Returns the number of contact group entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId(userId);
	}

	/**
	* Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupEntry findByUserId_ContactGroupId(
		long userId, long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		return getService().findByUserId_ContactGroupId(userId, contactGroupId);
	}

	/**
	* Returns the number of contact group entries where userId = &#63; and contactGroupId = &#63;.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId_ContactGroupId(long userId,
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByUserId_ContactGroupId(userId, contactGroupId);
	}

	/**
	* Removes the contact group entry where userId = &#63; and contactGroupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId_ContactGroupId(long userId,
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupEntryException {
		getService().removeByUserId_ContactGroupId(userId, contactGroupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactGroupEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactGroupEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ContactGroupEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new ContactGroupEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ContactGroupEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ContactGroupEntryLocalService.class);
		}

		return _service;
	}

	public void setService(ContactGroupEntryLocalService service) {
		MethodCache.remove(ContactGroupEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ContactGroupEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ContactGroupEntryLocalService.class);
	}

	private static ContactGroupEntryLocalService _service;
}