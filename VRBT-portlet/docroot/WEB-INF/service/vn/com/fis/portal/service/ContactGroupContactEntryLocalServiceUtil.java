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
 * The utility for the contact group contact entry local service. This utility wraps {@link vn.com.fis.portal.service.impl.ContactGroupContactEntryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see ContactGroupContactEntryLocalService
 * @see vn.com.fis.portal.service.base.ContactGroupContactEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.impl.ContactGroupContactEntryLocalServiceImpl
 * @generated
 */
public class ContactGroupContactEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.fis.portal.service.impl.ContactGroupContactEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the contact group contact entry to the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupContactEntry the contact group contact entry
	* @return the contact group contact entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupContactEntry addContactGroupContactEntry(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addContactGroupContactEntry(contactGroupContactEntry);
	}

	/**
	* Creates a new contact group contact entry with the primary key. Does not add the contact group contact entry to the database.
	*
	* @param contactGroupContactId the primary key for the new contact group contact entry
	* @return the new contact group contact entry
	*/
	public static vn.com.fis.portal.model.ContactGroupContactEntry createContactGroupContactEntry(
		long contactGroupContactId) {
		return getService().createContactGroupContactEntry(contactGroupContactId);
	}

	/**
	* Deletes the contact group contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupContactId the primary key of the contact group contact entry
	* @throws PortalException if a contact group contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteContactGroupContactEntry(
		long contactGroupContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContactGroupContactEntry(contactGroupContactId);
	}

	/**
	* Deletes the contact group contact entry from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupContactEntry the contact group contact entry
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteContactGroupContactEntry(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteContactGroupContactEntry(contactGroupContactEntry);
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

	public static vn.com.fis.portal.model.ContactGroupContactEntry fetchContactGroupContactEntry(
		long contactGroupContactId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchContactGroupContactEntry(contactGroupContactId);
	}

	/**
	* Returns the contact group contact entry with the primary key.
	*
	* @param contactGroupContactId the primary key of the contact group contact entry
	* @return the contact group contact entry
	* @throws PortalException if a contact group contact entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupContactEntry getContactGroupContactEntry(
		long contactGroupContactId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactGroupContactEntry(contactGroupContactId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact group contact entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group contact entries
	* @param end the upper bound of the range of contact group contact entries (not inclusive)
	* @return the range of contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.fis.portal.model.ContactGroupContactEntry> getContactGroupContactEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactGroupContactEntries(start, end);
	}

	/**
	* Returns the number of contact group contact entries.
	*
	* @return the number of contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static int getContactGroupContactEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getContactGroupContactEntriesCount();
	}

	/**
	* Updates the contact group contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactGroupContactEntry the contact group contact entry
	* @return the contact group contact entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupContactEntry updateContactGroupContactEntry(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateContactGroupContactEntry(contactGroupContactEntry);
	}

	/**
	* Updates the contact group contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactGroupContactEntry the contact group contact entry
	* @param merge whether to merge the contact group contact entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contact group contact entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupContactEntry updateContactGroupContactEntry(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateContactGroupContactEntry(contactGroupContactEntry,
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

	/**
	* Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupContactEntryException} if it could not be found.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @return the matching contact group contact entry
	* @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a matching contact group contact entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.fis.portal.model.ContactGroupContactEntry findByContactId_ContactGroupId(
		java.lang.String contactId, java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupContactEntryException {
		return getService()
				   .findByContactId_ContactGroupId(contactId, contactGroupId);
	}

	/**
	* Returns the number of contact group contact entries where contactId = &#63; and contactGroupId = &#63;.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group contact entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContactId_ContactGroupId(
		java.lang.String contactId, java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .countByContactId_ContactGroupId(contactId, contactGroupId);
	}

	/**
	* Removes the contact group contact entry where contactId = &#63; and contactGroupId = &#63; from the database.
	*
	* @param contactId the contact ID
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContactId_ContactGroupId(
		java.lang.String contactId, java.lang.String contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupContactEntryException {
		getService().removeByContactId_ContactGroupId(contactId, contactGroupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ContactGroupContactEntryLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ContactGroupContactEntryLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ContactGroupContactEntryLocalService.class.getName(),
					portletClassLoader);

			_service = new ContactGroupContactEntryLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ContactGroupContactEntryLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ContactGroupContactEntryLocalService.class);
		}

		return _service;
	}

	public void setService(ContactGroupContactEntryLocalService service) {
		MethodCache.remove(ContactGroupContactEntryLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ContactGroupContactEntryLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ContactGroupContactEntryLocalService.class);
	}

	private static ContactGroupContactEntryLocalService _service;
}