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

package vn.com.fis.portal.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.fis.portal.NoSuchContactGroupContactEntryException;
import vn.com.fis.portal.model.ContactGroupContactEntry;
import vn.com.fis.portal.model.impl.ContactGroupContactEntryImpl;
import vn.com.fis.portal.model.impl.ContactGroupContactEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact group contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupContactEntryPersistence
 * @see ContactGroupContactEntryUtil
 * @generated
 */
public class ContactGroupContactEntryPersistenceImpl extends BasePersistenceImpl<ContactGroupContactEntry>
	implements ContactGroupContactEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactGroupContactEntryUtil} to access the contact group contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactGroupContactEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID =
		new FinderPath(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupContactEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByContactId_ContactGroupId",
			new String[] { String.class.getName(), String.class.getName() },
			ContactGroupContactEntryModelImpl.CONTACTID_COLUMN_BITMASK |
			ContactGroupContactEntryModelImpl.CONTACTGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTID_CONTACTGROUPID =
		new FinderPath(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactId_ContactGroupId",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the contact group contact entry in the entity cache if it is enabled.
	 *
	 * @param contactGroupContactEntry the contact group contact entry
	 */
	public void cacheResult(ContactGroupContactEntry contactGroupContactEntry) {
		EntityCacheUtil.putResult(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryImpl.class,
			contactGroupContactEntry.getPrimaryKey(), contactGroupContactEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
			new Object[] {
				contactGroupContactEntry.getContactId(),
				
			contactGroupContactEntry.getContactGroupId()
			}, contactGroupContactEntry);

		contactGroupContactEntry.resetOriginalValues();
	}

	/**
	 * Caches the contact group contact entries in the entity cache if it is enabled.
	 *
	 * @param contactGroupContactEntries the contact group contact entries
	 */
	public void cacheResult(
		List<ContactGroupContactEntry> contactGroupContactEntries) {
		for (ContactGroupContactEntry contactGroupContactEntry : contactGroupContactEntries) {
			if (EntityCacheUtil.getResult(
						ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactGroupContactEntryImpl.class,
						contactGroupContactEntry.getPrimaryKey()) == null) {
				cacheResult(contactGroupContactEntry);
			}
			else {
				contactGroupContactEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact group contact entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactGroupContactEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactGroupContactEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact group contact entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactGroupContactEntry contactGroupContactEntry) {
		EntityCacheUtil.removeResult(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryImpl.class,
			contactGroupContactEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contactGroupContactEntry);
	}

	@Override
	public void clearCache(
		List<ContactGroupContactEntry> contactGroupContactEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactGroupContactEntry contactGroupContactEntry : contactGroupContactEntries) {
			EntityCacheUtil.removeResult(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactGroupContactEntryImpl.class,
				contactGroupContactEntry.getPrimaryKey());

			clearUniqueFindersCache(contactGroupContactEntry);
		}
	}

	protected void clearUniqueFindersCache(
		ContactGroupContactEntry contactGroupContactEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
			new Object[] {
				contactGroupContactEntry.getContactId(),
				
			contactGroupContactEntry.getContactGroupId()
			});
	}

	/**
	 * Creates a new contact group contact entry with the primary key. Does not add the contact group contact entry to the database.
	 *
	 * @param contactGroupContactId the primary key for the new contact group contact entry
	 * @return the new contact group contact entry
	 */
	public ContactGroupContactEntry create(long contactGroupContactId) {
		ContactGroupContactEntry contactGroupContactEntry = new ContactGroupContactEntryImpl();

		contactGroupContactEntry.setNew(true);
		contactGroupContactEntry.setPrimaryKey(contactGroupContactId);

		return contactGroupContactEntry;
	}

	/**
	 * Removes the contact group contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactGroupContactId the primary key of the contact group contact entry
	 * @return the contact group contact entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a contact group contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupContactEntry remove(long contactGroupContactId)
		throws NoSuchContactGroupContactEntryException, SystemException {
		return remove(Long.valueOf(contactGroupContactId));
	}

	/**
	 * Removes the contact group contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact group contact entry
	 * @return the contact group contact entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a contact group contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupContactEntry remove(Serializable primaryKey)
		throws NoSuchContactGroupContactEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactGroupContactEntry contactGroupContactEntry = (ContactGroupContactEntry)session.get(ContactGroupContactEntryImpl.class,
					primaryKey);

			if (contactGroupContactEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactGroupContactEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactGroupContactEntry);
		}
		catch (NoSuchContactGroupContactEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ContactGroupContactEntry removeImpl(
		ContactGroupContactEntry contactGroupContactEntry)
		throws SystemException {
		contactGroupContactEntry = toUnwrappedModel(contactGroupContactEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactGroupContactEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactGroupContactEntry);

		return contactGroupContactEntry;
	}

	@Override
	public ContactGroupContactEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupContactEntry contactGroupContactEntry,
		boolean merge) throws SystemException {
		contactGroupContactEntry = toUnwrappedModel(contactGroupContactEntry);

		boolean isNew = contactGroupContactEntry.isNew();

		ContactGroupContactEntryModelImpl contactGroupContactEntryModelImpl = (ContactGroupContactEntryModelImpl)contactGroupContactEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactGroupContactEntry, merge);

			contactGroupContactEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactGroupContactEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupContactEntryImpl.class,
			contactGroupContactEntry.getPrimaryKey(), contactGroupContactEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
				new Object[] {
					contactGroupContactEntry.getContactId(),
					
				contactGroupContactEntry.getContactGroupId()
				}, contactGroupContactEntry);
		}
		else {
			if ((contactGroupContactEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						contactGroupContactEntryModelImpl.getOriginalContactId(),
						
						contactGroupContactEntryModelImpl.getOriginalContactGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID_CONTACTGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
					new Object[] {
						contactGroupContactEntry.getContactId(),
						
					contactGroupContactEntry.getContactGroupId()
					}, contactGroupContactEntry);
			}
		}

		return contactGroupContactEntry;
	}

	protected ContactGroupContactEntry toUnwrappedModel(
		ContactGroupContactEntry contactGroupContactEntry) {
		if (contactGroupContactEntry instanceof ContactGroupContactEntryImpl) {
			return contactGroupContactEntry;
		}

		ContactGroupContactEntryImpl contactGroupContactEntryImpl = new ContactGroupContactEntryImpl();

		contactGroupContactEntryImpl.setNew(contactGroupContactEntry.isNew());
		contactGroupContactEntryImpl.setPrimaryKey(contactGroupContactEntry.getPrimaryKey());

		contactGroupContactEntryImpl.setContactGroupContactId(contactGroupContactEntry.getContactGroupContactId());
		contactGroupContactEntryImpl.setContactId(contactGroupContactEntry.getContactId());
		contactGroupContactEntryImpl.setContactGroupId(contactGroupContactEntry.getContactGroupId());

		return contactGroupContactEntryImpl;
	}

	/**
	 * Returns the contact group contact entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact group contact entry
	 * @return the contact group contact entry
	 * @throws com.liferay.portal.NoSuchModelException if a contact group contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupContactEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact group contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupContactEntryException} if it could not be found.
	 *
	 * @param contactGroupContactId the primary key of the contact group contact entry
	 * @return the contact group contact entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupContactEntryException if a contact group contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupContactEntry findByPrimaryKey(long contactGroupContactId)
		throws NoSuchContactGroupContactEntryException, SystemException {
		ContactGroupContactEntry contactGroupContactEntry = fetchByPrimaryKey(contactGroupContactId);

		if (contactGroupContactEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					contactGroupContactId);
			}

			throw new NoSuchContactGroupContactEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactGroupContactId);
		}

		return contactGroupContactEntry;
	}

	/**
	 * Returns the contact group contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact group contact entry
	 * @return the contact group contact entry, or <code>null</code> if a contact group contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupContactEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact group contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactGroupContactId the primary key of the contact group contact entry
	 * @return the contact group contact entry, or <code>null</code> if a contact group contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupContactEntry fetchByPrimaryKey(
		long contactGroupContactId) throws SystemException {
		ContactGroupContactEntry contactGroupContactEntry = (ContactGroupContactEntry)EntityCacheUtil.getResult(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactGroupContactEntryImpl.class, contactGroupContactId);

		if (contactGroupContactEntry == _nullContactGroupContactEntry) {
			return null;
		}

		if (contactGroupContactEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactGroupContactEntry = (ContactGroupContactEntry)session.get(ContactGroupContactEntryImpl.class,
						Long.valueOf(contactGroupContactId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactGroupContactEntry != null) {
					cacheResult(contactGroupContactEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactGroupContactEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactGroupContactEntryImpl.class,
						contactGroupContactId, _nullContactGroupContactEntry);
				}

				closeSession(session);
			}
		}

		return contactGroupContactEntry;
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
	public ContactGroupContactEntry findByContactId_ContactGroupId(
		String contactId, String contactGroupId)
		throws NoSuchContactGroupContactEntryException, SystemException {
		ContactGroupContactEntry contactGroupContactEntry = fetchByContactId_ContactGroupId(contactId,
				contactGroupId);

		if (contactGroupContactEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactId=");
			msg.append(contactId);

			msg.append(", contactGroupId=");
			msg.append(contactGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactGroupContactEntryException(msg.toString());
		}

		return contactGroupContactEntry;
	}

	/**
	 * Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @return the matching contact group contact entry, or <code>null</code> if a matching contact group contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupContactEntry fetchByContactId_ContactGroupId(
		String contactId, String contactGroupId) throws SystemException {
		return fetchByContactId_ContactGroupId(contactId, contactGroupId, true);
	}

	/**
	 * Returns the contact group contact entry where contactId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact group contact entry, or <code>null</code> if a matching contact group contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupContactEntry fetchByContactId_ContactGroupId(
		String contactId, String contactGroupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { contactId, contactGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTACTGROUPCONTACTENTRY_WHERE);

			if (contactId == null) {
				query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_1);
			}
			else {
				if (contactId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_2);
				}
			}

			if (contactGroupId == null) {
				query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_1);
			}
			else {
				if (contactGroupId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_2);
				}
			}

			query.append(ContactGroupContactEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (contactId != null) {
					qPos.add(contactId);
				}

				if (contactGroupId != null) {
					qPos.add(contactGroupId);
				}

				List<ContactGroupContactEntry> list = q.list();

				result = list;

				ContactGroupContactEntry contactGroupContactEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
						finderArgs, list);
				}
				else {
					contactGroupContactEntry = list.get(0);

					cacheResult(contactGroupContactEntry);

					if ((contactGroupContactEntry.getContactId() == null) ||
							!contactGroupContactEntry.getContactId()
														 .equals(contactId) ||
							(contactGroupContactEntry.getContactGroupId() == null) ||
							!contactGroupContactEntry.getContactGroupId()
														 .equals(contactGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
							finderArgs, contactGroupContactEntry);
					}
				}

				return contactGroupContactEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTID_CONTACTGROUPID,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ContactGroupContactEntry)result;
			}
		}
	}

	/**
	 * Returns all the contact group contact entries.
	 *
	 * @return the contact group contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupContactEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ContactGroupContactEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact group contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact group contact entries
	 * @param end the upper bound of the range of contact group contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact group contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupContactEntry> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ContactGroupContactEntry> list = (List<ContactGroupContactEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTGROUPCONTACTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTGROUPCONTACTENTRY.concat(ContactGroupContactEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactGroupContactEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactGroupContactEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes the contact group contact entry where contactId = &#63; and contactGroupId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactId_ContactGroupId(String contactId,
		String contactGroupId)
		throws NoSuchContactGroupContactEntryException, SystemException {
		ContactGroupContactEntry contactGroupContactEntry = findByContactId_ContactGroupId(contactId,
				contactGroupId);

		remove(contactGroupContactEntry);
	}

	/**
	 * Removes all the contact group contact entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactGroupContactEntry contactGroupContactEntry : findAll()) {
			remove(contactGroupContactEntry);
		}
	}

	/**
	 * Returns the number of contact group contact entries where contactId = &#63; and contactGroupId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param contactGroupId the contact group ID
	 * @return the number of matching contact group contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactId_ContactGroupId(String contactId,
		String contactGroupId) throws SystemException {
		Object[] finderArgs = new Object[] { contactId, contactGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTID_CONTACTGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTGROUPCONTACTENTRY_WHERE);

			if (contactId == null) {
				query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_1);
			}
			else {
				if (contactId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_2);
				}
			}

			if (contactGroupId == null) {
				query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_1);
			}
			else {
				if (contactGroupId.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_3);
				}
				else {
					query.append(_FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (contactId != null) {
					qPos.add(contactId);
				}

				if (contactGroupId != null) {
					qPos.add(contactGroupId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTID_CONTACTGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact group contact entries.
	 *
	 * @return the number of contact group contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTGROUPCONTACTENTRY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the contact group contact entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ContactGroupContactEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactGroupContactEntry>> listenersList = new ArrayList<ModelListener<ContactGroupContactEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactGroupContactEntry>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ContactGroupContactEntryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoryEntryPersistence.class)
	protected CategoryEntryPersistence categoryEntryPersistence;
	@BeanReference(type = CategoryVideoEntryPersistence.class)
	protected CategoryVideoEntryPersistence categoryVideoEntryPersistence;
	@BeanReference(type = ContactEntryPersistence.class)
	protected ContactEntryPersistence contactEntryPersistence;
	@BeanReference(type = ContactGroupContactEntryPersistence.class)
	protected ContactGroupContactEntryPersistence contactGroupContactEntryPersistence;
	@BeanReference(type = ContactGroupEntryPersistence.class)
	protected ContactGroupEntryPersistence contactGroupEntryPersistence;
	@BeanReference(type = ContactGroupVideoGroupEntryPersistence.class)
	protected ContactGroupVideoGroupEntryPersistence contactGroupVideoGroupEntryPersistence;
	@BeanReference(type = FolderEntryPersistence.class)
	protected FolderEntryPersistence folderEntryPersistence;
	@BeanReference(type = NotificationEntryPersistence.class)
	protected NotificationEntryPersistence notificationEntryPersistence;
	@BeanReference(type = RatingEntryPersistence.class)
	protected RatingEntryPersistence ratingEntryPersistence;
	@BeanReference(type = ServiceEntryPersistence.class)
	protected ServiceEntryPersistence serviceEntryPersistence;
	@BeanReference(type = ServicePackageEntryPersistence.class)
	protected ServicePackageEntryPersistence servicePackageEntryPersistence;
	@BeanReference(type = ServiceTransactionEntryPersistence.class)
	protected ServiceTransactionEntryPersistence serviceTransactionEntryPersistence;
	@BeanReference(type = UserEntryPersistence.class)
	protected UserEntryPersistence userEntryPersistence;
	@BeanReference(type = UserServiceEntryPersistence.class)
	protected UserServiceEntryPersistence userServiceEntryPersistence;
	@BeanReference(type = VideoEntryPersistence.class)
	protected VideoEntryPersistence videoEntryPersistence;
	@BeanReference(type = VideoGroupEntryPersistence.class)
	protected VideoGroupEntryPersistence videoGroupEntryPersistence;
	@BeanReference(type = VideoUserContactEntryPersistence.class)
	protected VideoUserContactEntryPersistence videoUserContactEntryPersistence;
	@BeanReference(type = VideoUserEntryPersistence.class)
	protected VideoUserEntryPersistence videoUserEntryPersistence;
	@BeanReference(type = VideoUserTransactionEntryPersistence.class)
	protected VideoUserTransactionEntryPersistence videoUserTransactionEntryPersistence;
	@BeanReference(type = VideoUserVideoGroupEntryPersistence.class)
	protected VideoUserVideoGroupEntryPersistence videoUserVideoGroupEntryPersistence;
	@BeanReference(type = ViolationEntryPersistence.class)
	protected ViolationEntryPersistence violationEntryPersistence;
	@BeanReference(type = ViolationVideoEntryPersistence.class)
	protected ViolationVideoEntryPersistence violationVideoEntryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CONTACTGROUPCONTACTENTRY = "SELECT contactGroupContactEntry FROM ContactGroupContactEntry contactGroupContactEntry";
	private static final String _SQL_SELECT_CONTACTGROUPCONTACTENTRY_WHERE = "SELECT contactGroupContactEntry FROM ContactGroupContactEntry contactGroupContactEntry WHERE ";
	private static final String _SQL_COUNT_CONTACTGROUPCONTACTENTRY = "SELECT COUNT(contactGroupContactEntry) FROM ContactGroupContactEntry contactGroupContactEntry";
	private static final String _SQL_COUNT_CONTACTGROUPCONTACTENTRY_WHERE = "SELECT COUNT(contactGroupContactEntry) FROM ContactGroupContactEntry contactGroupContactEntry WHERE ";
	private static final String _FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_1 =
		"contactGroupContactEntry.contactId IS NULL AND ";
	private static final String _FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_2 =
		"contactGroupContactEntry.contactId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTID_3 =
		"(contactGroupContactEntry.contactId IS NULL OR contactGroupContactEntry.contactId = ?) AND ";
	private static final String _FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_1 =
		"contactGroupContactEntry.contactGroupId IS NULL";
	private static final String _FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_2 =
		"contactGroupContactEntry.contactGroupId = ?";
	private static final String _FINDER_COLUMN_CONTACTID_CONTACTGROUPID_CONTACTGROUPID_3 =
		"(contactGroupContactEntry.contactGroupId IS NULL OR contactGroupContactEntry.contactGroupId = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactGroupContactEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactGroupContactEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactGroupContactEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactGroupContactEntryPersistenceImpl.class);
	private static ContactGroupContactEntry _nullContactGroupContactEntry = new ContactGroupContactEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactGroupContactEntry> toCacheModel() {
				return _nullContactGroupContactEntryCacheModel;
			}
		};

	private static CacheModel<ContactGroupContactEntry> _nullContactGroupContactEntryCacheModel =
		new CacheModel<ContactGroupContactEntry>() {
			public ContactGroupContactEntry toEntityModel() {
				return _nullContactGroupContactEntry;
			}
		};
}