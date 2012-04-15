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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ContactGroupVideoGroupEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       ContactGroupVideoGroupEntryLocalService
 * @generated
 */
public class ContactGroupVideoGroupEntryLocalServiceWrapper
	implements ContactGroupVideoGroupEntryLocalService,
		ServiceWrapper<ContactGroupVideoGroupEntryLocalService> {
	public ContactGroupVideoGroupEntryLocalServiceWrapper(
		ContactGroupVideoGroupEntryLocalService contactGroupVideoGroupEntryLocalService) {
		_contactGroupVideoGroupEntryLocalService = contactGroupVideoGroupEntryLocalService;
	}

	/**
	* Adds the contact group video group entry to the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupVideoGroupEntry the contact group video group entry
	* @return the contact group video group entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry addContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.addContactGroupVideoGroupEntry(contactGroupVideoGroupEntry);
	}

	/**
	* Creates a new contact group video group entry with the primary key. Does not add the contact group video group entry to the database.
	*
	* @param contactGroupVideoGroupEntryId the primary key for the new contact group video group entry
	* @return the new contact group video group entry
	*/
	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry createContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId) {
		return _contactGroupVideoGroupEntryLocalService.createContactGroupVideoGroupEntry(contactGroupVideoGroupEntryId);
	}

	/**
	* Deletes the contact group video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	* @throws PortalException if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_contactGroupVideoGroupEntryLocalService.deleteContactGroupVideoGroupEntry(contactGroupVideoGroupEntryId);
	}

	/**
	* Deletes the contact group video group entry from the database. Also notifies the appropriate model listeners.
	*
	* @param contactGroupVideoGroupEntry the contact group video group entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactGroupVideoGroupEntryLocalService.deleteContactGroupVideoGroupEntry(contactGroupVideoGroupEntry);
	}

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
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry fetchContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.fetchContactGroupVideoGroupEntry(contactGroupVideoGroupEntryId);
	}

	/**
	* Returns the contact group video group entry with the primary key.
	*
	* @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	* @return the contact group video group entry
	* @throws PortalException if a contact group video group entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry getContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.getContactGroupVideoGroupEntry(contactGroupVideoGroupEntryId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the contact group video group entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @return the range of contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> getContactGroupVideoGroupEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.getContactGroupVideoGroupEntries(start,
			end);
	}

	/**
	* Returns the number of contact group video group entries.
	*
	* @return the number of contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int getContactGroupVideoGroupEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.getContactGroupVideoGroupEntriesCount();
	}

	/**
	* Updates the contact group video group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactGroupVideoGroupEntry the contact group video group entry
	* @return the contact group video group entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry updateContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.updateContactGroupVideoGroupEntry(contactGroupVideoGroupEntry);
	}

	/**
	* Updates the contact group video group entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param contactGroupVideoGroupEntry the contact group video group entry
	* @param merge whether to merge the contact group video group entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the contact group video group entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry updateContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.updateContactGroupVideoGroupEntry(contactGroupVideoGroupEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _contactGroupVideoGroupEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_contactGroupVideoGroupEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	/**
	* Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException} if it could not be found.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @return the matching contact group video group entry
	* @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		return _contactGroupVideoGroupEntryLocalService.findByContactGroup_VideoGroup(contactGroupId,
			videoGroupId);
	}

	/**
	* Returns the number of contact group video group entries where contactGroupId = &#63; and videoGroupId = &#63;.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @return the number of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.countByContactGroup_VideoGroup(contactGroupId,
			videoGroupId);
	}

	/**
	* Removes the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; from the database.
	*
	* @param contactGroupId the contact group ID
	* @param videoGroupId the video group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		_contactGroupVideoGroupEntryLocalService.removeByContactGroup_VideoGroup(contactGroupId,
			videoGroupId);
	}

	/**
	* Returns all the contact group video group entries where contactGroupId = &#63;.
	*
	* @param contactGroupId the contact group ID
	* @return the matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.findByContactGroup(contactGroupId);
	}

	/**
	* Returns a range of all the contact group video group entries where contactGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param contactGroupId the contact group ID
	* @param start the lower bound of the range of contact group video group entries
	* @param end the upper bound of the range of contact group video group entries (not inclusive)
	* @return the range of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.findByContactGroup(contactGroupId,
			start, end);
	}

	/**
	* Returns the number of contact group video group entries where contactGroupId = &#63;.
	*
	* @param contactGroupId the contact group ID
	* @return the number of matching contact group video group entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByContactGroup(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _contactGroupVideoGroupEntryLocalService.countByContactGroup(contactGroupId);
	}

	/**
	* Removes all the contact group video group entries where contactGroupId = &#63; from the database.
	*
	* @param contactGroupId the contact group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContactGroup(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_contactGroupVideoGroupEntryLocalService.removeByContactGroup(contactGroupId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ContactGroupVideoGroupEntryLocalService getWrappedContactGroupVideoGroupEntryLocalService() {
		return _contactGroupVideoGroupEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedContactGroupVideoGroupEntryLocalService(
		ContactGroupVideoGroupEntryLocalService contactGroupVideoGroupEntryLocalService) {
		_contactGroupVideoGroupEntryLocalService = contactGroupVideoGroupEntryLocalService;
	}

	public ContactGroupVideoGroupEntryLocalService getWrappedService() {
		return _contactGroupVideoGroupEntryLocalService;
	}

	public void setWrappedService(
		ContactGroupVideoGroupEntryLocalService contactGroupVideoGroupEntryLocalService) {
		_contactGroupVideoGroupEntryLocalService = contactGroupVideoGroupEntryLocalService;
	}

	private ContactGroupVideoGroupEntryLocalService _contactGroupVideoGroupEntryLocalService;
}