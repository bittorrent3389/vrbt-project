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

package vn.com.fis.portal.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import vn.com.fis.portal.model.ContactEntry;
import vn.com.fis.portal.service.CategoryEntryLocalService;
import vn.com.fis.portal.service.CategoryEntryService;
import vn.com.fis.portal.service.CategoryVideoEntryLocalService;
import vn.com.fis.portal.service.CategoryVideoEntryService;
import vn.com.fis.portal.service.ContactEntryLocalService;
import vn.com.fis.portal.service.ContactEntryService;
import vn.com.fis.portal.service.ContactGroupContactEntryLocalService;
import vn.com.fis.portal.service.ContactGroupContactEntryService;
import vn.com.fis.portal.service.ContactGroupEntryLocalService;
import vn.com.fis.portal.service.ContactGroupEntryService;
import vn.com.fis.portal.service.ContactGroupVideoGroupEntryLocalService;
import vn.com.fis.portal.service.ContactGroupVideoGroupEntryService;
import vn.com.fis.portal.service.FolderEntryLocalService;
import vn.com.fis.portal.service.FolderEntryService;
import vn.com.fis.portal.service.NotificationEntryLocalService;
import vn.com.fis.portal.service.NotificationEntryService;
import vn.com.fis.portal.service.RatingEntryLocalService;
import vn.com.fis.portal.service.RatingEntryService;
import vn.com.fis.portal.service.ServiceEntryLocalService;
import vn.com.fis.portal.service.ServiceEntryService;
import vn.com.fis.portal.service.ServicePackageEntryLocalService;
import vn.com.fis.portal.service.ServicePackageEntryService;
import vn.com.fis.portal.service.ServiceTransactionEntryLocalService;
import vn.com.fis.portal.service.ServiceTransactionEntryService;
import vn.com.fis.portal.service.UserEntryLocalService;
import vn.com.fis.portal.service.UserEntryService;
import vn.com.fis.portal.service.UserServiceEntryLocalService;
import vn.com.fis.portal.service.UserServiceEntryService;
import vn.com.fis.portal.service.VideoEntryLocalService;
import vn.com.fis.portal.service.VideoEntryService;
import vn.com.fis.portal.service.VideoGroupEntryLocalService;
import vn.com.fis.portal.service.VideoGroupEntryService;
import vn.com.fis.portal.service.VideoUserContactEntryLocalService;
import vn.com.fis.portal.service.VideoUserContactEntryService;
import vn.com.fis.portal.service.VideoUserEntryLocalService;
import vn.com.fis.portal.service.VideoUserEntryService;
import vn.com.fis.portal.service.VideoUserTransactionEntryLocalService;
import vn.com.fis.portal.service.VideoUserTransactionEntryService;
import vn.com.fis.portal.service.VideoUserVideoGroupEntryLocalService;
import vn.com.fis.portal.service.VideoUserVideoGroupEntryService;
import vn.com.fis.portal.service.ViolationEntryLocalService;
import vn.com.fis.portal.service.ViolationEntryService;
import vn.com.fis.portal.service.ViolationVideoEntryLocalService;
import vn.com.fis.portal.service.ViolationVideoEntryService;
import vn.com.fis.portal.service.persistence.CategoryEntryPersistence;
import vn.com.fis.portal.service.persistence.CategoryVideoEntryPersistence;
import vn.com.fis.portal.service.persistence.ContactEntryPersistence;
import vn.com.fis.portal.service.persistence.ContactGroupContactEntryPersistence;
import vn.com.fis.portal.service.persistence.ContactGroupEntryPersistence;
import vn.com.fis.portal.service.persistence.ContactGroupVideoGroupEntryPersistence;
import vn.com.fis.portal.service.persistence.FolderEntryPersistence;
import vn.com.fis.portal.service.persistence.NotificationEntryFinder;
import vn.com.fis.portal.service.persistence.NotificationEntryPersistence;
import vn.com.fis.portal.service.persistence.RatingEntryPersistence;
import vn.com.fis.portal.service.persistence.ServiceEntryFinder;
import vn.com.fis.portal.service.persistence.ServiceEntryPersistence;
import vn.com.fis.portal.service.persistence.ServicePackageEntryFinder;
import vn.com.fis.portal.service.persistence.ServicePackageEntryPersistence;
import vn.com.fis.portal.service.persistence.ServiceTransactionEntryFinder;
import vn.com.fis.portal.service.persistence.ServiceTransactionEntryPersistence;
import vn.com.fis.portal.service.persistence.UserEntryFinder;
import vn.com.fis.portal.service.persistence.UserEntryPersistence;
import vn.com.fis.portal.service.persistence.UserServiceEntryPersistence;
import vn.com.fis.portal.service.persistence.VideoEntryPersistence;
import vn.com.fis.portal.service.persistence.VideoGroupEntryPersistence;
import vn.com.fis.portal.service.persistence.VideoUserContactEntryPersistence;
import vn.com.fis.portal.service.persistence.VideoUserEntryPersistence;
import vn.com.fis.portal.service.persistence.VideoUserTransactionEntryFinder;
import vn.com.fis.portal.service.persistence.VideoUserTransactionEntryPersistence;
import vn.com.fis.portal.service.persistence.VideoUserVideoGroupEntryPersistence;
import vn.com.fis.portal.service.persistence.ViolationEntryPersistence;
import vn.com.fis.portal.service.persistence.ViolationVideoEntryPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the contact entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link vn.com.fis.portal.service.impl.ContactEntryLocalServiceImpl}.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.impl.ContactEntryLocalServiceImpl
 * @see vn.com.fis.portal.service.ContactEntryLocalServiceUtil
 * @generated
 */
public abstract class ContactEntryLocalServiceBaseImpl
	implements ContactEntryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link vn.com.fis.portal.service.ContactEntryLocalServiceUtil} to access the contact entry local service.
	 */

	/**
	 * Adds the contact entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry addContactEntry(ContactEntry contactEntry)
		throws SystemException {
		contactEntry.setNew(true);

		contactEntry = contactEntryPersistence.update(contactEntry, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(contactEntry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return contactEntry;
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param contactId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	public ContactEntry createContactEntry(long contactId) {
		return contactEntryPersistence.create(contactId);
	}

	/**
	 * Deletes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact entry
	 * @throws PortalException if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteContactEntry(long contactId)
		throws PortalException, SystemException {
		ContactEntry contactEntry = contactEntryPersistence.remove(contactId);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(contactEntry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Deletes the contact entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactEntry the contact entry
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteContactEntry(ContactEntry contactEntry)
		throws SystemException {
		contactEntryPersistence.remove(contactEntry);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.delete(contactEntry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return contactEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return contactEntryPersistence.findWithDynamicQuery(dynamicQuery,
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return contactEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return contactEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public ContactEntry fetchContactEntry(long contactId)
		throws SystemException {
		return contactEntryPersistence.fetchByPrimaryKey(contactId);
	}

	/**
	 * Returns the contact entry with the primary key.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry
	 * @throws PortalException if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry getContactEntry(long contactId)
		throws PortalException, SystemException {
		return contactEntryPersistence.findByPrimaryKey(contactId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return contactEntryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @return the range of contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactEntry> getContactEntries(int start, int end)
		throws SystemException {
		return contactEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getContactEntriesCount() throws SystemException {
		return contactEntryPersistence.countAll();
	}

	/**
	 * Updates the contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param contactEntry the contact entry
	 * @return the contact entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry updateContactEntry(ContactEntry contactEntry)
		throws SystemException {
		return updateContactEntry(contactEntry, true);
	}

	/**
	 * Updates the contact entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param contactEntry the contact entry
	 * @param merge whether to merge the contact entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the contact entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry updateContactEntry(ContactEntry contactEntry,
		boolean merge) throws SystemException {
		contactEntry.setNew(false);

		contactEntry = contactEntryPersistence.update(contactEntry, merge);

		Indexer indexer = IndexerRegistryUtil.getIndexer(getModelClassName());

		if (indexer != null) {
			try {
				indexer.reindex(contactEntry);
			}
			catch (SearchException se) {
				if (_log.isWarnEnabled()) {
					_log.warn(se, se);
				}
			}
		}

		return contactEntry;
	}

	/**
	 * Returns the category entry local service.
	 *
	 * @return the category entry local service
	 */
	public CategoryEntryLocalService getCategoryEntryLocalService() {
		return categoryEntryLocalService;
	}

	/**
	 * Sets the category entry local service.
	 *
	 * @param categoryEntryLocalService the category entry local service
	 */
	public void setCategoryEntryLocalService(
		CategoryEntryLocalService categoryEntryLocalService) {
		this.categoryEntryLocalService = categoryEntryLocalService;
	}

	/**
	 * Returns the category entry remote service.
	 *
	 * @return the category entry remote service
	 */
	public CategoryEntryService getCategoryEntryService() {
		return categoryEntryService;
	}

	/**
	 * Sets the category entry remote service.
	 *
	 * @param categoryEntryService the category entry remote service
	 */
	public void setCategoryEntryService(
		CategoryEntryService categoryEntryService) {
		this.categoryEntryService = categoryEntryService;
	}

	/**
	 * Returns the category entry persistence.
	 *
	 * @return the category entry persistence
	 */
	public CategoryEntryPersistence getCategoryEntryPersistence() {
		return categoryEntryPersistence;
	}

	/**
	 * Sets the category entry persistence.
	 *
	 * @param categoryEntryPersistence the category entry persistence
	 */
	public void setCategoryEntryPersistence(
		CategoryEntryPersistence categoryEntryPersistence) {
		this.categoryEntryPersistence = categoryEntryPersistence;
	}

	/**
	 * Returns the category video entry local service.
	 *
	 * @return the category video entry local service
	 */
	public CategoryVideoEntryLocalService getCategoryVideoEntryLocalService() {
		return categoryVideoEntryLocalService;
	}

	/**
	 * Sets the category video entry local service.
	 *
	 * @param categoryVideoEntryLocalService the category video entry local service
	 */
	public void setCategoryVideoEntryLocalService(
		CategoryVideoEntryLocalService categoryVideoEntryLocalService) {
		this.categoryVideoEntryLocalService = categoryVideoEntryLocalService;
	}

	/**
	 * Returns the category video entry remote service.
	 *
	 * @return the category video entry remote service
	 */
	public CategoryVideoEntryService getCategoryVideoEntryService() {
		return categoryVideoEntryService;
	}

	/**
	 * Sets the category video entry remote service.
	 *
	 * @param categoryVideoEntryService the category video entry remote service
	 */
	public void setCategoryVideoEntryService(
		CategoryVideoEntryService categoryVideoEntryService) {
		this.categoryVideoEntryService = categoryVideoEntryService;
	}

	/**
	 * Returns the category video entry persistence.
	 *
	 * @return the category video entry persistence
	 */
	public CategoryVideoEntryPersistence getCategoryVideoEntryPersistence() {
		return categoryVideoEntryPersistence;
	}

	/**
	 * Sets the category video entry persistence.
	 *
	 * @param categoryVideoEntryPersistence the category video entry persistence
	 */
	public void setCategoryVideoEntryPersistence(
		CategoryVideoEntryPersistence categoryVideoEntryPersistence) {
		this.categoryVideoEntryPersistence = categoryVideoEntryPersistence;
	}

	/**
	 * Returns the contact entry local service.
	 *
	 * @return the contact entry local service
	 */
	public ContactEntryLocalService getContactEntryLocalService() {
		return contactEntryLocalService;
	}

	/**
	 * Sets the contact entry local service.
	 *
	 * @param contactEntryLocalService the contact entry local service
	 */
	public void setContactEntryLocalService(
		ContactEntryLocalService contactEntryLocalService) {
		this.contactEntryLocalService = contactEntryLocalService;
	}

	/**
	 * Returns the contact entry remote service.
	 *
	 * @return the contact entry remote service
	 */
	public ContactEntryService getContactEntryService() {
		return contactEntryService;
	}

	/**
	 * Sets the contact entry remote service.
	 *
	 * @param contactEntryService the contact entry remote service
	 */
	public void setContactEntryService(ContactEntryService contactEntryService) {
		this.contactEntryService = contactEntryService;
	}

	/**
	 * Returns the contact entry persistence.
	 *
	 * @return the contact entry persistence
	 */
	public ContactEntryPersistence getContactEntryPersistence() {
		return contactEntryPersistence;
	}

	/**
	 * Sets the contact entry persistence.
	 *
	 * @param contactEntryPersistence the contact entry persistence
	 */
	public void setContactEntryPersistence(
		ContactEntryPersistence contactEntryPersistence) {
		this.contactEntryPersistence = contactEntryPersistence;
	}

	/**
	 * Returns the contact group contact entry local service.
	 *
	 * @return the contact group contact entry local service
	 */
	public ContactGroupContactEntryLocalService getContactGroupContactEntryLocalService() {
		return contactGroupContactEntryLocalService;
	}

	/**
	 * Sets the contact group contact entry local service.
	 *
	 * @param contactGroupContactEntryLocalService the contact group contact entry local service
	 */
	public void setContactGroupContactEntryLocalService(
		ContactGroupContactEntryLocalService contactGroupContactEntryLocalService) {
		this.contactGroupContactEntryLocalService = contactGroupContactEntryLocalService;
	}

	/**
	 * Returns the contact group contact entry remote service.
	 *
	 * @return the contact group contact entry remote service
	 */
	public ContactGroupContactEntryService getContactGroupContactEntryService() {
		return contactGroupContactEntryService;
	}

	/**
	 * Sets the contact group contact entry remote service.
	 *
	 * @param contactGroupContactEntryService the contact group contact entry remote service
	 */
	public void setContactGroupContactEntryService(
		ContactGroupContactEntryService contactGroupContactEntryService) {
		this.contactGroupContactEntryService = contactGroupContactEntryService;
	}

	/**
	 * Returns the contact group contact entry persistence.
	 *
	 * @return the contact group contact entry persistence
	 */
	public ContactGroupContactEntryPersistence getContactGroupContactEntryPersistence() {
		return contactGroupContactEntryPersistence;
	}

	/**
	 * Sets the contact group contact entry persistence.
	 *
	 * @param contactGroupContactEntryPersistence the contact group contact entry persistence
	 */
	public void setContactGroupContactEntryPersistence(
		ContactGroupContactEntryPersistence contactGroupContactEntryPersistence) {
		this.contactGroupContactEntryPersistence = contactGroupContactEntryPersistence;
	}

	/**
	 * Returns the contact group entry local service.
	 *
	 * @return the contact group entry local service
	 */
	public ContactGroupEntryLocalService getContactGroupEntryLocalService() {
		return contactGroupEntryLocalService;
	}

	/**
	 * Sets the contact group entry local service.
	 *
	 * @param contactGroupEntryLocalService the contact group entry local service
	 */
	public void setContactGroupEntryLocalService(
		ContactGroupEntryLocalService contactGroupEntryLocalService) {
		this.contactGroupEntryLocalService = contactGroupEntryLocalService;
	}

	/**
	 * Returns the contact group entry remote service.
	 *
	 * @return the contact group entry remote service
	 */
	public ContactGroupEntryService getContactGroupEntryService() {
		return contactGroupEntryService;
	}

	/**
	 * Sets the contact group entry remote service.
	 *
	 * @param contactGroupEntryService the contact group entry remote service
	 */
	public void setContactGroupEntryService(
		ContactGroupEntryService contactGroupEntryService) {
		this.contactGroupEntryService = contactGroupEntryService;
	}

	/**
	 * Returns the contact group entry persistence.
	 *
	 * @return the contact group entry persistence
	 */
	public ContactGroupEntryPersistence getContactGroupEntryPersistence() {
		return contactGroupEntryPersistence;
	}

	/**
	 * Sets the contact group entry persistence.
	 *
	 * @param contactGroupEntryPersistence the contact group entry persistence
	 */
	public void setContactGroupEntryPersistence(
		ContactGroupEntryPersistence contactGroupEntryPersistence) {
		this.contactGroupEntryPersistence = contactGroupEntryPersistence;
	}

	/**
	 * Returns the contact group video group entry local service.
	 *
	 * @return the contact group video group entry local service
	 */
	public ContactGroupVideoGroupEntryLocalService getContactGroupVideoGroupEntryLocalService() {
		return contactGroupVideoGroupEntryLocalService;
	}

	/**
	 * Sets the contact group video group entry local service.
	 *
	 * @param contactGroupVideoGroupEntryLocalService the contact group video group entry local service
	 */
	public void setContactGroupVideoGroupEntryLocalService(
		ContactGroupVideoGroupEntryLocalService contactGroupVideoGroupEntryLocalService) {
		this.contactGroupVideoGroupEntryLocalService = contactGroupVideoGroupEntryLocalService;
	}

	/**
	 * Returns the contact group video group entry remote service.
	 *
	 * @return the contact group video group entry remote service
	 */
	public ContactGroupVideoGroupEntryService getContactGroupVideoGroupEntryService() {
		return contactGroupVideoGroupEntryService;
	}

	/**
	 * Sets the contact group video group entry remote service.
	 *
	 * @param contactGroupVideoGroupEntryService the contact group video group entry remote service
	 */
	public void setContactGroupVideoGroupEntryService(
		ContactGroupVideoGroupEntryService contactGroupVideoGroupEntryService) {
		this.contactGroupVideoGroupEntryService = contactGroupVideoGroupEntryService;
	}

	/**
	 * Returns the contact group video group entry persistence.
	 *
	 * @return the contact group video group entry persistence
	 */
	public ContactGroupVideoGroupEntryPersistence getContactGroupVideoGroupEntryPersistence() {
		return contactGroupVideoGroupEntryPersistence;
	}

	/**
	 * Sets the contact group video group entry persistence.
	 *
	 * @param contactGroupVideoGroupEntryPersistence the contact group video group entry persistence
	 */
	public void setContactGroupVideoGroupEntryPersistence(
		ContactGroupVideoGroupEntryPersistence contactGroupVideoGroupEntryPersistence) {
		this.contactGroupVideoGroupEntryPersistence = contactGroupVideoGroupEntryPersistence;
	}

	/**
	 * Returns the folder entry local service.
	 *
	 * @return the folder entry local service
	 */
	public FolderEntryLocalService getFolderEntryLocalService() {
		return folderEntryLocalService;
	}

	/**
	 * Sets the folder entry local service.
	 *
	 * @param folderEntryLocalService the folder entry local service
	 */
	public void setFolderEntryLocalService(
		FolderEntryLocalService folderEntryLocalService) {
		this.folderEntryLocalService = folderEntryLocalService;
	}

	/**
	 * Returns the folder entry remote service.
	 *
	 * @return the folder entry remote service
	 */
	public FolderEntryService getFolderEntryService() {
		return folderEntryService;
	}

	/**
	 * Sets the folder entry remote service.
	 *
	 * @param folderEntryService the folder entry remote service
	 */
	public void setFolderEntryService(FolderEntryService folderEntryService) {
		this.folderEntryService = folderEntryService;
	}

	/**
	 * Returns the folder entry persistence.
	 *
	 * @return the folder entry persistence
	 */
	public FolderEntryPersistence getFolderEntryPersistence() {
		return folderEntryPersistence;
	}

	/**
	 * Sets the folder entry persistence.
	 *
	 * @param folderEntryPersistence the folder entry persistence
	 */
	public void setFolderEntryPersistence(
		FolderEntryPersistence folderEntryPersistence) {
		this.folderEntryPersistence = folderEntryPersistence;
	}

	/**
	 * Returns the notification entry local service.
	 *
	 * @return the notification entry local service
	 */
	public NotificationEntryLocalService getNotificationEntryLocalService() {
		return notificationEntryLocalService;
	}

	/**
	 * Sets the notification entry local service.
	 *
	 * @param notificationEntryLocalService the notification entry local service
	 */
	public void setNotificationEntryLocalService(
		NotificationEntryLocalService notificationEntryLocalService) {
		this.notificationEntryLocalService = notificationEntryLocalService;
	}

	/**
	 * Returns the notification entry remote service.
	 *
	 * @return the notification entry remote service
	 */
	public NotificationEntryService getNotificationEntryService() {
		return notificationEntryService;
	}

	/**
	 * Sets the notification entry remote service.
	 *
	 * @param notificationEntryService the notification entry remote service
	 */
	public void setNotificationEntryService(
		NotificationEntryService notificationEntryService) {
		this.notificationEntryService = notificationEntryService;
	}

	/**
	 * Returns the notification entry persistence.
	 *
	 * @return the notification entry persistence
	 */
	public NotificationEntryPersistence getNotificationEntryPersistence() {
		return notificationEntryPersistence;
	}

	/**
	 * Sets the notification entry persistence.
	 *
	 * @param notificationEntryPersistence the notification entry persistence
	 */
	public void setNotificationEntryPersistence(
		NotificationEntryPersistence notificationEntryPersistence) {
		this.notificationEntryPersistence = notificationEntryPersistence;
	}

	/**
	 * Returns the notification entry finder.
	 *
	 * @return the notification entry finder
	 */
	public NotificationEntryFinder getNotificationEntryFinder() {
		return notificationEntryFinder;
	}

	/**
	 * Sets the notification entry finder.
	 *
	 * @param notificationEntryFinder the notification entry finder
	 */
	public void setNotificationEntryFinder(
		NotificationEntryFinder notificationEntryFinder) {
		this.notificationEntryFinder = notificationEntryFinder;
	}

	/**
	 * Returns the rating entry local service.
	 *
	 * @return the rating entry local service
	 */
	public RatingEntryLocalService getRatingEntryLocalService() {
		return ratingEntryLocalService;
	}

	/**
	 * Sets the rating entry local service.
	 *
	 * @param ratingEntryLocalService the rating entry local service
	 */
	public void setRatingEntryLocalService(
		RatingEntryLocalService ratingEntryLocalService) {
		this.ratingEntryLocalService = ratingEntryLocalService;
	}

	/**
	 * Returns the rating entry remote service.
	 *
	 * @return the rating entry remote service
	 */
	public RatingEntryService getRatingEntryService() {
		return ratingEntryService;
	}

	/**
	 * Sets the rating entry remote service.
	 *
	 * @param ratingEntryService the rating entry remote service
	 */
	public void setRatingEntryService(RatingEntryService ratingEntryService) {
		this.ratingEntryService = ratingEntryService;
	}

	/**
	 * Returns the rating entry persistence.
	 *
	 * @return the rating entry persistence
	 */
	public RatingEntryPersistence getRatingEntryPersistence() {
		return ratingEntryPersistence;
	}

	/**
	 * Sets the rating entry persistence.
	 *
	 * @param ratingEntryPersistence the rating entry persistence
	 */
	public void setRatingEntryPersistence(
		RatingEntryPersistence ratingEntryPersistence) {
		this.ratingEntryPersistence = ratingEntryPersistence;
	}

	/**
	 * Returns the service entry local service.
	 *
	 * @return the service entry local service
	 */
	public ServiceEntryLocalService getServiceEntryLocalService() {
		return serviceEntryLocalService;
	}

	/**
	 * Sets the service entry local service.
	 *
	 * @param serviceEntryLocalService the service entry local service
	 */
	public void setServiceEntryLocalService(
		ServiceEntryLocalService serviceEntryLocalService) {
		this.serviceEntryLocalService = serviceEntryLocalService;
	}

	/**
	 * Returns the service entry remote service.
	 *
	 * @return the service entry remote service
	 */
	public ServiceEntryService getServiceEntryService() {
		return serviceEntryService;
	}

	/**
	 * Sets the service entry remote service.
	 *
	 * @param serviceEntryService the service entry remote service
	 */
	public void setServiceEntryService(ServiceEntryService serviceEntryService) {
		this.serviceEntryService = serviceEntryService;
	}

	/**
	 * Returns the service entry persistence.
	 *
	 * @return the service entry persistence
	 */
	public ServiceEntryPersistence getServiceEntryPersistence() {
		return serviceEntryPersistence;
	}

	/**
	 * Sets the service entry persistence.
	 *
	 * @param serviceEntryPersistence the service entry persistence
	 */
	public void setServiceEntryPersistence(
		ServiceEntryPersistence serviceEntryPersistence) {
		this.serviceEntryPersistence = serviceEntryPersistence;
	}

	/**
	 * Returns the service entry finder.
	 *
	 * @return the service entry finder
	 */
	public ServiceEntryFinder getServiceEntryFinder() {
		return serviceEntryFinder;
	}

	/**
	 * Sets the service entry finder.
	 *
	 * @param serviceEntryFinder the service entry finder
	 */
	public void setServiceEntryFinder(ServiceEntryFinder serviceEntryFinder) {
		this.serviceEntryFinder = serviceEntryFinder;
	}

	/**
	 * Returns the service package entry local service.
	 *
	 * @return the service package entry local service
	 */
	public ServicePackageEntryLocalService getServicePackageEntryLocalService() {
		return servicePackageEntryLocalService;
	}

	/**
	 * Sets the service package entry local service.
	 *
	 * @param servicePackageEntryLocalService the service package entry local service
	 */
	public void setServicePackageEntryLocalService(
		ServicePackageEntryLocalService servicePackageEntryLocalService) {
		this.servicePackageEntryLocalService = servicePackageEntryLocalService;
	}

	/**
	 * Returns the service package entry remote service.
	 *
	 * @return the service package entry remote service
	 */
	public ServicePackageEntryService getServicePackageEntryService() {
		return servicePackageEntryService;
	}

	/**
	 * Sets the service package entry remote service.
	 *
	 * @param servicePackageEntryService the service package entry remote service
	 */
	public void setServicePackageEntryService(
		ServicePackageEntryService servicePackageEntryService) {
		this.servicePackageEntryService = servicePackageEntryService;
	}

	/**
	 * Returns the service package entry persistence.
	 *
	 * @return the service package entry persistence
	 */
	public ServicePackageEntryPersistence getServicePackageEntryPersistence() {
		return servicePackageEntryPersistence;
	}

	/**
	 * Sets the service package entry persistence.
	 *
	 * @param servicePackageEntryPersistence the service package entry persistence
	 */
	public void setServicePackageEntryPersistence(
		ServicePackageEntryPersistence servicePackageEntryPersistence) {
		this.servicePackageEntryPersistence = servicePackageEntryPersistence;
	}

	/**
	 * Returns the service package entry finder.
	 *
	 * @return the service package entry finder
	 */
	public ServicePackageEntryFinder getServicePackageEntryFinder() {
		return servicePackageEntryFinder;
	}

	/**
	 * Sets the service package entry finder.
	 *
	 * @param servicePackageEntryFinder the service package entry finder
	 */
	public void setServicePackageEntryFinder(
		ServicePackageEntryFinder servicePackageEntryFinder) {
		this.servicePackageEntryFinder = servicePackageEntryFinder;
	}

	/**
	 * Returns the service transaction entry local service.
	 *
	 * @return the service transaction entry local service
	 */
	public ServiceTransactionEntryLocalService getServiceTransactionEntryLocalService() {
		return serviceTransactionEntryLocalService;
	}

	/**
	 * Sets the service transaction entry local service.
	 *
	 * @param serviceTransactionEntryLocalService the service transaction entry local service
	 */
	public void setServiceTransactionEntryLocalService(
		ServiceTransactionEntryLocalService serviceTransactionEntryLocalService) {
		this.serviceTransactionEntryLocalService = serviceTransactionEntryLocalService;
	}

	/**
	 * Returns the service transaction entry remote service.
	 *
	 * @return the service transaction entry remote service
	 */
	public ServiceTransactionEntryService getServiceTransactionEntryService() {
		return serviceTransactionEntryService;
	}

	/**
	 * Sets the service transaction entry remote service.
	 *
	 * @param serviceTransactionEntryService the service transaction entry remote service
	 */
	public void setServiceTransactionEntryService(
		ServiceTransactionEntryService serviceTransactionEntryService) {
		this.serviceTransactionEntryService = serviceTransactionEntryService;
	}

	/**
	 * Returns the service transaction entry persistence.
	 *
	 * @return the service transaction entry persistence
	 */
	public ServiceTransactionEntryPersistence getServiceTransactionEntryPersistence() {
		return serviceTransactionEntryPersistence;
	}

	/**
	 * Sets the service transaction entry persistence.
	 *
	 * @param serviceTransactionEntryPersistence the service transaction entry persistence
	 */
	public void setServiceTransactionEntryPersistence(
		ServiceTransactionEntryPersistence serviceTransactionEntryPersistence) {
		this.serviceTransactionEntryPersistence = serviceTransactionEntryPersistence;
	}

	/**
	 * Returns the service transaction entry finder.
	 *
	 * @return the service transaction entry finder
	 */
	public ServiceTransactionEntryFinder getServiceTransactionEntryFinder() {
		return serviceTransactionEntryFinder;
	}

	/**
	 * Sets the service transaction entry finder.
	 *
	 * @param serviceTransactionEntryFinder the service transaction entry finder
	 */
	public void setServiceTransactionEntryFinder(
		ServiceTransactionEntryFinder serviceTransactionEntryFinder) {
		this.serviceTransactionEntryFinder = serviceTransactionEntryFinder;
	}

	/**
	 * Returns the user entry local service.
	 *
	 * @return the user entry local service
	 */
	public UserEntryLocalService getUserEntryLocalService() {
		return userEntryLocalService;
	}

	/**
	 * Sets the user entry local service.
	 *
	 * @param userEntryLocalService the user entry local service
	 */
	public void setUserEntryLocalService(
		UserEntryLocalService userEntryLocalService) {
		this.userEntryLocalService = userEntryLocalService;
	}

	/**
	 * Returns the user entry remote service.
	 *
	 * @return the user entry remote service
	 */
	public UserEntryService getUserEntryService() {
		return userEntryService;
	}

	/**
	 * Sets the user entry remote service.
	 *
	 * @param userEntryService the user entry remote service
	 */
	public void setUserEntryService(UserEntryService userEntryService) {
		this.userEntryService = userEntryService;
	}

	/**
	 * Returns the user entry persistence.
	 *
	 * @return the user entry persistence
	 */
	public UserEntryPersistence getUserEntryPersistence() {
		return userEntryPersistence;
	}

	/**
	 * Sets the user entry persistence.
	 *
	 * @param userEntryPersistence the user entry persistence
	 */
	public void setUserEntryPersistence(
		UserEntryPersistence userEntryPersistence) {
		this.userEntryPersistence = userEntryPersistence;
	}

	/**
	 * Returns the user entry finder.
	 *
	 * @return the user entry finder
	 */
	public UserEntryFinder getUserEntryFinder() {
		return userEntryFinder;
	}

	/**
	 * Sets the user entry finder.
	 *
	 * @param userEntryFinder the user entry finder
	 */
	public void setUserEntryFinder(UserEntryFinder userEntryFinder) {
		this.userEntryFinder = userEntryFinder;
	}

	/**
	 * Returns the user service entry local service.
	 *
	 * @return the user service entry local service
	 */
	public UserServiceEntryLocalService getUserServiceEntryLocalService() {
		return userServiceEntryLocalService;
	}

	/**
	 * Sets the user service entry local service.
	 *
	 * @param userServiceEntryLocalService the user service entry local service
	 */
	public void setUserServiceEntryLocalService(
		UserServiceEntryLocalService userServiceEntryLocalService) {
		this.userServiceEntryLocalService = userServiceEntryLocalService;
	}

	/**
	 * Returns the user service entry remote service.
	 *
	 * @return the user service entry remote service
	 */
	public UserServiceEntryService getUserServiceEntryService() {
		return userServiceEntryService;
	}

	/**
	 * Sets the user service entry remote service.
	 *
	 * @param userServiceEntryService the user service entry remote service
	 */
	public void setUserServiceEntryService(
		UserServiceEntryService userServiceEntryService) {
		this.userServiceEntryService = userServiceEntryService;
	}

	/**
	 * Returns the user service entry persistence.
	 *
	 * @return the user service entry persistence
	 */
	public UserServiceEntryPersistence getUserServiceEntryPersistence() {
		return userServiceEntryPersistence;
	}

	/**
	 * Sets the user service entry persistence.
	 *
	 * @param userServiceEntryPersistence the user service entry persistence
	 */
	public void setUserServiceEntryPersistence(
		UserServiceEntryPersistence userServiceEntryPersistence) {
		this.userServiceEntryPersistence = userServiceEntryPersistence;
	}

	/**
	 * Returns the video entry local service.
	 *
	 * @return the video entry local service
	 */
	public VideoEntryLocalService getVideoEntryLocalService() {
		return videoEntryLocalService;
	}

	/**
	 * Sets the video entry local service.
	 *
	 * @param videoEntryLocalService the video entry local service
	 */
	public void setVideoEntryLocalService(
		VideoEntryLocalService videoEntryLocalService) {
		this.videoEntryLocalService = videoEntryLocalService;
	}

	/**
	 * Returns the video entry remote service.
	 *
	 * @return the video entry remote service
	 */
	public VideoEntryService getVideoEntryService() {
		return videoEntryService;
	}

	/**
	 * Sets the video entry remote service.
	 *
	 * @param videoEntryService the video entry remote service
	 */
	public void setVideoEntryService(VideoEntryService videoEntryService) {
		this.videoEntryService = videoEntryService;
	}

	/**
	 * Returns the video entry persistence.
	 *
	 * @return the video entry persistence
	 */
	public VideoEntryPersistence getVideoEntryPersistence() {
		return videoEntryPersistence;
	}

	/**
	 * Sets the video entry persistence.
	 *
	 * @param videoEntryPersistence the video entry persistence
	 */
	public void setVideoEntryPersistence(
		VideoEntryPersistence videoEntryPersistence) {
		this.videoEntryPersistence = videoEntryPersistence;
	}

	/**
	 * Returns the video group entry local service.
	 *
	 * @return the video group entry local service
	 */
	public VideoGroupEntryLocalService getVideoGroupEntryLocalService() {
		return videoGroupEntryLocalService;
	}

	/**
	 * Sets the video group entry local service.
	 *
	 * @param videoGroupEntryLocalService the video group entry local service
	 */
	public void setVideoGroupEntryLocalService(
		VideoGroupEntryLocalService videoGroupEntryLocalService) {
		this.videoGroupEntryLocalService = videoGroupEntryLocalService;
	}

	/**
	 * Returns the video group entry remote service.
	 *
	 * @return the video group entry remote service
	 */
	public VideoGroupEntryService getVideoGroupEntryService() {
		return videoGroupEntryService;
	}

	/**
	 * Sets the video group entry remote service.
	 *
	 * @param videoGroupEntryService the video group entry remote service
	 */
	public void setVideoGroupEntryService(
		VideoGroupEntryService videoGroupEntryService) {
		this.videoGroupEntryService = videoGroupEntryService;
	}

	/**
	 * Returns the video group entry persistence.
	 *
	 * @return the video group entry persistence
	 */
	public VideoGroupEntryPersistence getVideoGroupEntryPersistence() {
		return videoGroupEntryPersistence;
	}

	/**
	 * Sets the video group entry persistence.
	 *
	 * @param videoGroupEntryPersistence the video group entry persistence
	 */
	public void setVideoGroupEntryPersistence(
		VideoGroupEntryPersistence videoGroupEntryPersistence) {
		this.videoGroupEntryPersistence = videoGroupEntryPersistence;
	}

	/**
	 * Returns the video user contact entry local service.
	 *
	 * @return the video user contact entry local service
	 */
	public VideoUserContactEntryLocalService getVideoUserContactEntryLocalService() {
		return videoUserContactEntryLocalService;
	}

	/**
	 * Sets the video user contact entry local service.
	 *
	 * @param videoUserContactEntryLocalService the video user contact entry local service
	 */
	public void setVideoUserContactEntryLocalService(
		VideoUserContactEntryLocalService videoUserContactEntryLocalService) {
		this.videoUserContactEntryLocalService = videoUserContactEntryLocalService;
	}

	/**
	 * Returns the video user contact entry remote service.
	 *
	 * @return the video user contact entry remote service
	 */
	public VideoUserContactEntryService getVideoUserContactEntryService() {
		return videoUserContactEntryService;
	}

	/**
	 * Sets the video user contact entry remote service.
	 *
	 * @param videoUserContactEntryService the video user contact entry remote service
	 */
	public void setVideoUserContactEntryService(
		VideoUserContactEntryService videoUserContactEntryService) {
		this.videoUserContactEntryService = videoUserContactEntryService;
	}

	/**
	 * Returns the video user contact entry persistence.
	 *
	 * @return the video user contact entry persistence
	 */
	public VideoUserContactEntryPersistence getVideoUserContactEntryPersistence() {
		return videoUserContactEntryPersistence;
	}

	/**
	 * Sets the video user contact entry persistence.
	 *
	 * @param videoUserContactEntryPersistence the video user contact entry persistence
	 */
	public void setVideoUserContactEntryPersistence(
		VideoUserContactEntryPersistence videoUserContactEntryPersistence) {
		this.videoUserContactEntryPersistence = videoUserContactEntryPersistence;
	}

	/**
	 * Returns the video user entry local service.
	 *
	 * @return the video user entry local service
	 */
	public VideoUserEntryLocalService getVideoUserEntryLocalService() {
		return videoUserEntryLocalService;
	}

	/**
	 * Sets the video user entry local service.
	 *
	 * @param videoUserEntryLocalService the video user entry local service
	 */
	public void setVideoUserEntryLocalService(
		VideoUserEntryLocalService videoUserEntryLocalService) {
		this.videoUserEntryLocalService = videoUserEntryLocalService;
	}

	/**
	 * Returns the video user entry remote service.
	 *
	 * @return the video user entry remote service
	 */
	public VideoUserEntryService getVideoUserEntryService() {
		return videoUserEntryService;
	}

	/**
	 * Sets the video user entry remote service.
	 *
	 * @param videoUserEntryService the video user entry remote service
	 */
	public void setVideoUserEntryService(
		VideoUserEntryService videoUserEntryService) {
		this.videoUserEntryService = videoUserEntryService;
	}

	/**
	 * Returns the video user entry persistence.
	 *
	 * @return the video user entry persistence
	 */
	public VideoUserEntryPersistence getVideoUserEntryPersistence() {
		return videoUserEntryPersistence;
	}

	/**
	 * Sets the video user entry persistence.
	 *
	 * @param videoUserEntryPersistence the video user entry persistence
	 */
	public void setVideoUserEntryPersistence(
		VideoUserEntryPersistence videoUserEntryPersistence) {
		this.videoUserEntryPersistence = videoUserEntryPersistence;
	}

	/**
	 * Returns the video user transaction entry local service.
	 *
	 * @return the video user transaction entry local service
	 */
	public VideoUserTransactionEntryLocalService getVideoUserTransactionEntryLocalService() {
		return videoUserTransactionEntryLocalService;
	}

	/**
	 * Sets the video user transaction entry local service.
	 *
	 * @param videoUserTransactionEntryLocalService the video user transaction entry local service
	 */
	public void setVideoUserTransactionEntryLocalService(
		VideoUserTransactionEntryLocalService videoUserTransactionEntryLocalService) {
		this.videoUserTransactionEntryLocalService = videoUserTransactionEntryLocalService;
	}

	/**
	 * Returns the video user transaction entry remote service.
	 *
	 * @return the video user transaction entry remote service
	 */
	public VideoUserTransactionEntryService getVideoUserTransactionEntryService() {
		return videoUserTransactionEntryService;
	}

	/**
	 * Sets the video user transaction entry remote service.
	 *
	 * @param videoUserTransactionEntryService the video user transaction entry remote service
	 */
	public void setVideoUserTransactionEntryService(
		VideoUserTransactionEntryService videoUserTransactionEntryService) {
		this.videoUserTransactionEntryService = videoUserTransactionEntryService;
	}

	/**
	 * Returns the video user transaction entry persistence.
	 *
	 * @return the video user transaction entry persistence
	 */
	public VideoUserTransactionEntryPersistence getVideoUserTransactionEntryPersistence() {
		return videoUserTransactionEntryPersistence;
	}

	/**
	 * Sets the video user transaction entry persistence.
	 *
	 * @param videoUserTransactionEntryPersistence the video user transaction entry persistence
	 */
	public void setVideoUserTransactionEntryPersistence(
		VideoUserTransactionEntryPersistence videoUserTransactionEntryPersistence) {
		this.videoUserTransactionEntryPersistence = videoUserTransactionEntryPersistence;
	}

	/**
	 * Returns the video user transaction entry finder.
	 *
	 * @return the video user transaction entry finder
	 */
	public VideoUserTransactionEntryFinder getVideoUserTransactionEntryFinder() {
		return videoUserTransactionEntryFinder;
	}

	/**
	 * Sets the video user transaction entry finder.
	 *
	 * @param videoUserTransactionEntryFinder the video user transaction entry finder
	 */
	public void setVideoUserTransactionEntryFinder(
		VideoUserTransactionEntryFinder videoUserTransactionEntryFinder) {
		this.videoUserTransactionEntryFinder = videoUserTransactionEntryFinder;
	}

	/**
	 * Returns the video user video group entry local service.
	 *
	 * @return the video user video group entry local service
	 */
	public VideoUserVideoGroupEntryLocalService getVideoUserVideoGroupEntryLocalService() {
		return videoUserVideoGroupEntryLocalService;
	}

	/**
	 * Sets the video user video group entry local service.
	 *
	 * @param videoUserVideoGroupEntryLocalService the video user video group entry local service
	 */
	public void setVideoUserVideoGroupEntryLocalService(
		VideoUserVideoGroupEntryLocalService videoUserVideoGroupEntryLocalService) {
		this.videoUserVideoGroupEntryLocalService = videoUserVideoGroupEntryLocalService;
	}

	/**
	 * Returns the video user video group entry remote service.
	 *
	 * @return the video user video group entry remote service
	 */
	public VideoUserVideoGroupEntryService getVideoUserVideoGroupEntryService() {
		return videoUserVideoGroupEntryService;
	}

	/**
	 * Sets the video user video group entry remote service.
	 *
	 * @param videoUserVideoGroupEntryService the video user video group entry remote service
	 */
	public void setVideoUserVideoGroupEntryService(
		VideoUserVideoGroupEntryService videoUserVideoGroupEntryService) {
		this.videoUserVideoGroupEntryService = videoUserVideoGroupEntryService;
	}

	/**
	 * Returns the video user video group entry persistence.
	 *
	 * @return the video user video group entry persistence
	 */
	public VideoUserVideoGroupEntryPersistence getVideoUserVideoGroupEntryPersistence() {
		return videoUserVideoGroupEntryPersistence;
	}

	/**
	 * Sets the video user video group entry persistence.
	 *
	 * @param videoUserVideoGroupEntryPersistence the video user video group entry persistence
	 */
	public void setVideoUserVideoGroupEntryPersistence(
		VideoUserVideoGroupEntryPersistence videoUserVideoGroupEntryPersistence) {
		this.videoUserVideoGroupEntryPersistence = videoUserVideoGroupEntryPersistence;
	}

	/**
	 * Returns the violation entry local service.
	 *
	 * @return the violation entry local service
	 */
	public ViolationEntryLocalService getViolationEntryLocalService() {
		return violationEntryLocalService;
	}

	/**
	 * Sets the violation entry local service.
	 *
	 * @param violationEntryLocalService the violation entry local service
	 */
	public void setViolationEntryLocalService(
		ViolationEntryLocalService violationEntryLocalService) {
		this.violationEntryLocalService = violationEntryLocalService;
	}

	/**
	 * Returns the violation entry remote service.
	 *
	 * @return the violation entry remote service
	 */
	public ViolationEntryService getViolationEntryService() {
		return violationEntryService;
	}

	/**
	 * Sets the violation entry remote service.
	 *
	 * @param violationEntryService the violation entry remote service
	 */
	public void setViolationEntryService(
		ViolationEntryService violationEntryService) {
		this.violationEntryService = violationEntryService;
	}

	/**
	 * Returns the violation entry persistence.
	 *
	 * @return the violation entry persistence
	 */
	public ViolationEntryPersistence getViolationEntryPersistence() {
		return violationEntryPersistence;
	}

	/**
	 * Sets the violation entry persistence.
	 *
	 * @param violationEntryPersistence the violation entry persistence
	 */
	public void setViolationEntryPersistence(
		ViolationEntryPersistence violationEntryPersistence) {
		this.violationEntryPersistence = violationEntryPersistence;
	}

	/**
	 * Returns the violation video entry local service.
	 *
	 * @return the violation video entry local service
	 */
	public ViolationVideoEntryLocalService getViolationVideoEntryLocalService() {
		return violationVideoEntryLocalService;
	}

	/**
	 * Sets the violation video entry local service.
	 *
	 * @param violationVideoEntryLocalService the violation video entry local service
	 */
	public void setViolationVideoEntryLocalService(
		ViolationVideoEntryLocalService violationVideoEntryLocalService) {
		this.violationVideoEntryLocalService = violationVideoEntryLocalService;
	}

	/**
	 * Returns the violation video entry remote service.
	 *
	 * @return the violation video entry remote service
	 */
	public ViolationVideoEntryService getViolationVideoEntryService() {
		return violationVideoEntryService;
	}

	/**
	 * Sets the violation video entry remote service.
	 *
	 * @param violationVideoEntryService the violation video entry remote service
	 */
	public void setViolationVideoEntryService(
		ViolationVideoEntryService violationVideoEntryService) {
		this.violationVideoEntryService = violationVideoEntryService;
	}

	/**
	 * Returns the violation video entry persistence.
	 *
	 * @return the violation video entry persistence
	 */
	public ViolationVideoEntryPersistence getViolationVideoEntryPersistence() {
		return violationVideoEntryPersistence;
	}

	/**
	 * Sets the violation video entry persistence.
	 *
	 * @param violationVideoEntryPersistence the violation video entry persistence
	 */
	public void setViolationVideoEntryPersistence(
		ViolationVideoEntryPersistence violationVideoEntryPersistence) {
		this.violationVideoEntryPersistence = violationVideoEntryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("vn.com.fis.portal.model.ContactEntry",
			contactEntryLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"vn.com.fis.portal.model.ContactEntry");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	protected Class<?> getModelClass() {
		return ContactEntry.class;
	}

	protected String getModelClassName() {
		return ContactEntry.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = contactEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CategoryEntryLocalService.class)
	protected CategoryEntryLocalService categoryEntryLocalService;
	@BeanReference(type = CategoryEntryService.class)
	protected CategoryEntryService categoryEntryService;
	@BeanReference(type = CategoryEntryPersistence.class)
	protected CategoryEntryPersistence categoryEntryPersistence;
	@BeanReference(type = CategoryVideoEntryLocalService.class)
	protected CategoryVideoEntryLocalService categoryVideoEntryLocalService;
	@BeanReference(type = CategoryVideoEntryService.class)
	protected CategoryVideoEntryService categoryVideoEntryService;
	@BeanReference(type = CategoryVideoEntryPersistence.class)
	protected CategoryVideoEntryPersistence categoryVideoEntryPersistence;
	@BeanReference(type = ContactEntryLocalService.class)
	protected ContactEntryLocalService contactEntryLocalService;
	@BeanReference(type = ContactEntryService.class)
	protected ContactEntryService contactEntryService;
	@BeanReference(type = ContactEntryPersistence.class)
	protected ContactEntryPersistence contactEntryPersistence;
	@BeanReference(type = ContactGroupContactEntryLocalService.class)
	protected ContactGroupContactEntryLocalService contactGroupContactEntryLocalService;
	@BeanReference(type = ContactGroupContactEntryService.class)
	protected ContactGroupContactEntryService contactGroupContactEntryService;
	@BeanReference(type = ContactGroupContactEntryPersistence.class)
	protected ContactGroupContactEntryPersistence contactGroupContactEntryPersistence;
	@BeanReference(type = ContactGroupEntryLocalService.class)
	protected ContactGroupEntryLocalService contactGroupEntryLocalService;
	@BeanReference(type = ContactGroupEntryService.class)
	protected ContactGroupEntryService contactGroupEntryService;
	@BeanReference(type = ContactGroupEntryPersistence.class)
	protected ContactGroupEntryPersistence contactGroupEntryPersistence;
	@BeanReference(type = ContactGroupVideoGroupEntryLocalService.class)
	protected ContactGroupVideoGroupEntryLocalService contactGroupVideoGroupEntryLocalService;
	@BeanReference(type = ContactGroupVideoGroupEntryService.class)
	protected ContactGroupVideoGroupEntryService contactGroupVideoGroupEntryService;
	@BeanReference(type = ContactGroupVideoGroupEntryPersistence.class)
	protected ContactGroupVideoGroupEntryPersistence contactGroupVideoGroupEntryPersistence;
	@BeanReference(type = FolderEntryLocalService.class)
	protected FolderEntryLocalService folderEntryLocalService;
	@BeanReference(type = FolderEntryService.class)
	protected FolderEntryService folderEntryService;
	@BeanReference(type = FolderEntryPersistence.class)
	protected FolderEntryPersistence folderEntryPersistence;
	@BeanReference(type = NotificationEntryLocalService.class)
	protected NotificationEntryLocalService notificationEntryLocalService;
	@BeanReference(type = NotificationEntryService.class)
	protected NotificationEntryService notificationEntryService;
	@BeanReference(type = NotificationEntryPersistence.class)
	protected NotificationEntryPersistence notificationEntryPersistence;
	@BeanReference(type = NotificationEntryFinder.class)
	protected NotificationEntryFinder notificationEntryFinder;
	@BeanReference(type = RatingEntryLocalService.class)
	protected RatingEntryLocalService ratingEntryLocalService;
	@BeanReference(type = RatingEntryService.class)
	protected RatingEntryService ratingEntryService;
	@BeanReference(type = RatingEntryPersistence.class)
	protected RatingEntryPersistence ratingEntryPersistence;
	@BeanReference(type = ServiceEntryLocalService.class)
	protected ServiceEntryLocalService serviceEntryLocalService;
	@BeanReference(type = ServiceEntryService.class)
	protected ServiceEntryService serviceEntryService;
	@BeanReference(type = ServiceEntryPersistence.class)
	protected ServiceEntryPersistence serviceEntryPersistence;
	@BeanReference(type = ServiceEntryFinder.class)
	protected ServiceEntryFinder serviceEntryFinder;
	@BeanReference(type = ServicePackageEntryLocalService.class)
	protected ServicePackageEntryLocalService servicePackageEntryLocalService;
	@BeanReference(type = ServicePackageEntryService.class)
	protected ServicePackageEntryService servicePackageEntryService;
	@BeanReference(type = ServicePackageEntryPersistence.class)
	protected ServicePackageEntryPersistence servicePackageEntryPersistence;
	@BeanReference(type = ServicePackageEntryFinder.class)
	protected ServicePackageEntryFinder servicePackageEntryFinder;
	@BeanReference(type = ServiceTransactionEntryLocalService.class)
	protected ServiceTransactionEntryLocalService serviceTransactionEntryLocalService;
	@BeanReference(type = ServiceTransactionEntryService.class)
	protected ServiceTransactionEntryService serviceTransactionEntryService;
	@BeanReference(type = ServiceTransactionEntryPersistence.class)
	protected ServiceTransactionEntryPersistence serviceTransactionEntryPersistence;
	@BeanReference(type = ServiceTransactionEntryFinder.class)
	protected ServiceTransactionEntryFinder serviceTransactionEntryFinder;
	@BeanReference(type = UserEntryLocalService.class)
	protected UserEntryLocalService userEntryLocalService;
	@BeanReference(type = UserEntryService.class)
	protected UserEntryService userEntryService;
	@BeanReference(type = UserEntryPersistence.class)
	protected UserEntryPersistence userEntryPersistence;
	@BeanReference(type = UserEntryFinder.class)
	protected UserEntryFinder userEntryFinder;
	@BeanReference(type = UserServiceEntryLocalService.class)
	protected UserServiceEntryLocalService userServiceEntryLocalService;
	@BeanReference(type = UserServiceEntryService.class)
	protected UserServiceEntryService userServiceEntryService;
	@BeanReference(type = UserServiceEntryPersistence.class)
	protected UserServiceEntryPersistence userServiceEntryPersistence;
	@BeanReference(type = VideoEntryLocalService.class)
	protected VideoEntryLocalService videoEntryLocalService;
	@BeanReference(type = VideoEntryService.class)
	protected VideoEntryService videoEntryService;
	@BeanReference(type = VideoEntryPersistence.class)
	protected VideoEntryPersistence videoEntryPersistence;
	@BeanReference(type = VideoGroupEntryLocalService.class)
	protected VideoGroupEntryLocalService videoGroupEntryLocalService;
	@BeanReference(type = VideoGroupEntryService.class)
	protected VideoGroupEntryService videoGroupEntryService;
	@BeanReference(type = VideoGroupEntryPersistence.class)
	protected VideoGroupEntryPersistence videoGroupEntryPersistence;
	@BeanReference(type = VideoUserContactEntryLocalService.class)
	protected VideoUserContactEntryLocalService videoUserContactEntryLocalService;
	@BeanReference(type = VideoUserContactEntryService.class)
	protected VideoUserContactEntryService videoUserContactEntryService;
	@BeanReference(type = VideoUserContactEntryPersistence.class)
	protected VideoUserContactEntryPersistence videoUserContactEntryPersistence;
	@BeanReference(type = VideoUserEntryLocalService.class)
	protected VideoUserEntryLocalService videoUserEntryLocalService;
	@BeanReference(type = VideoUserEntryService.class)
	protected VideoUserEntryService videoUserEntryService;
	@BeanReference(type = VideoUserEntryPersistence.class)
	protected VideoUserEntryPersistence videoUserEntryPersistence;
	@BeanReference(type = VideoUserTransactionEntryLocalService.class)
	protected VideoUserTransactionEntryLocalService videoUserTransactionEntryLocalService;
	@BeanReference(type = VideoUserTransactionEntryService.class)
	protected VideoUserTransactionEntryService videoUserTransactionEntryService;
	@BeanReference(type = VideoUserTransactionEntryPersistence.class)
	protected VideoUserTransactionEntryPersistence videoUserTransactionEntryPersistence;
	@BeanReference(type = VideoUserTransactionEntryFinder.class)
	protected VideoUserTransactionEntryFinder videoUserTransactionEntryFinder;
	@BeanReference(type = VideoUserVideoGroupEntryLocalService.class)
	protected VideoUserVideoGroupEntryLocalService videoUserVideoGroupEntryLocalService;
	@BeanReference(type = VideoUserVideoGroupEntryService.class)
	protected VideoUserVideoGroupEntryService videoUserVideoGroupEntryService;
	@BeanReference(type = VideoUserVideoGroupEntryPersistence.class)
	protected VideoUserVideoGroupEntryPersistence videoUserVideoGroupEntryPersistence;
	@BeanReference(type = ViolationEntryLocalService.class)
	protected ViolationEntryLocalService violationEntryLocalService;
	@BeanReference(type = ViolationEntryService.class)
	protected ViolationEntryService violationEntryService;
	@BeanReference(type = ViolationEntryPersistence.class)
	protected ViolationEntryPersistence violationEntryPersistence;
	@BeanReference(type = ViolationVideoEntryLocalService.class)
	protected ViolationVideoEntryLocalService violationVideoEntryLocalService;
	@BeanReference(type = ViolationVideoEntryService.class)
	protected ViolationVideoEntryService violationVideoEntryService;
	@BeanReference(type = ViolationVideoEntryPersistence.class)
	protected ViolationVideoEntryPersistence violationVideoEntryPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static Log _log = LogFactoryUtil.getLog(ContactEntryLocalServiceBaseImpl.class);
	private String _beanIdentifier;
}