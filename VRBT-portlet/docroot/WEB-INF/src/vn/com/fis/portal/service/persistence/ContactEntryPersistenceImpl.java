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

import vn.com.fis.portal.NoSuchContactEntryException;
import vn.com.fis.portal.model.ContactEntry;
import vn.com.fis.portal.model.impl.ContactEntryImpl;
import vn.com.fis.portal.model.impl.ContactEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactEntryPersistence
 * @see ContactEntryUtil
 * @generated
 */
public class ContactEntryPersistenceImpl extends BasePersistenceImpl<ContactEntry>
	implements ContactEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactEntryUtil} to access the contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER = new FinderPath(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryModelImpl.FINDER_CACHE_ENABLED, ContactEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId_MobileNumber",
			new String[] { Long.class.getName(), String.class.getName() },
			ContactEntryModelImpl.USERID_COLUMN_BITMASK |
			ContactEntryModelImpl.MOBILENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_MOBILENUMBER = new FinderPath(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_MobileNumber",
			new String[] { Long.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryModelImpl.FINDER_CACHE_ENABLED, ContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryModelImpl.FINDER_CACHE_ENABLED, ContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the contact entry in the entity cache if it is enabled.
	 *
	 * @param contactEntry the contact entry
	 */
	public void cacheResult(ContactEntry contactEntry) {
		EntityCacheUtil.putResult(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryImpl.class, contactEntry.getPrimaryKey(), contactEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
			new Object[] {
				Long.valueOf(contactEntry.getUserId()),
				
			contactEntry.getMobileNumber()
			}, contactEntry);

		contactEntry.resetOriginalValues();
	}

	/**
	 * Caches the contact entries in the entity cache if it is enabled.
	 *
	 * @param contactEntries the contact entries
	 */
	public void cacheResult(List<ContactEntry> contactEntries) {
		for (ContactEntry contactEntry : contactEntries) {
			if (EntityCacheUtil.getResult(
						ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactEntryImpl.class, contactEntry.getPrimaryKey()) == null) {
				cacheResult(contactEntry);
			}
			else {
				contactEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactEntry contactEntry) {
		EntityCacheUtil.removeResult(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryImpl.class, contactEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contactEntry);
	}

	@Override
	public void clearCache(List<ContactEntry> contactEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactEntry contactEntry : contactEntries) {
			EntityCacheUtil.removeResult(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactEntryImpl.class, contactEntry.getPrimaryKey());

			clearUniqueFindersCache(contactEntry);
		}
	}

	protected void clearUniqueFindersCache(ContactEntry contactEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
			new Object[] {
				Long.valueOf(contactEntry.getUserId()),
				
			contactEntry.getMobileNumber()
			});
	}

	/**
	 * Creates a new contact entry with the primary key. Does not add the contact entry to the database.
	 *
	 * @param contactId the primary key for the new contact entry
	 * @return the new contact entry
	 */
	public ContactEntry create(long contactId) {
		ContactEntry contactEntry = new ContactEntryImpl();

		contactEntry.setNew(true);
		contactEntry.setPrimaryKey(contactId);

		return contactEntry;
	}

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry remove(long contactId)
		throws NoSuchContactEntryException, SystemException {
		return remove(Long.valueOf(contactId));
	}

	/**
	 * Removes the contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact entry
	 * @return the contact entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactEntry remove(Serializable primaryKey)
		throws NoSuchContactEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactEntry contactEntry = (ContactEntry)session.get(ContactEntryImpl.class,
					primaryKey);

			if (contactEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactEntry);
		}
		catch (NoSuchContactEntryException nsee) {
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
	protected ContactEntry removeImpl(ContactEntry contactEntry)
		throws SystemException {
		contactEntry = toUnwrappedModel(contactEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactEntry);

		return contactEntry;
	}

	@Override
	public ContactEntry updateImpl(
		vn.com.fis.portal.model.ContactEntry contactEntry, boolean merge)
		throws SystemException {
		contactEntry = toUnwrappedModel(contactEntry);

		boolean isNew = contactEntry.isNew();

		ContactEntryModelImpl contactEntryModelImpl = (ContactEntryModelImpl)contactEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactEntry, merge);

			contactEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactEntryImpl.class, contactEntry.getPrimaryKey(), contactEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
				new Object[] {
					Long.valueOf(contactEntry.getUserId()),
					
				contactEntry.getMobileNumber()
				}, contactEntry);
		}
		else {
			if ((contactEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactEntryModelImpl.getOriginalUserId()),
						
						contactEntryModelImpl.getOriginalMobileNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_MOBILENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
					new Object[] {
						Long.valueOf(contactEntry.getUserId()),
						
					contactEntry.getMobileNumber()
					}, contactEntry);
			}
		}

		return contactEntry;
	}

	protected ContactEntry toUnwrappedModel(ContactEntry contactEntry) {
		if (contactEntry instanceof ContactEntryImpl) {
			return contactEntry;
		}

		ContactEntryImpl contactEntryImpl = new ContactEntryImpl();

		contactEntryImpl.setNew(contactEntry.isNew());
		contactEntryImpl.setPrimaryKey(contactEntry.getPrimaryKey());

		contactEntryImpl.setContactId(contactEntry.getContactId());
		contactEntryImpl.setContactName(contactEntry.getContactName());
		contactEntryImpl.setMobileNumber(contactEntry.getMobileNumber());
		contactEntryImpl.setUserId(contactEntry.getUserId());

		return contactEntryImpl;
	}

	/**
	 * Returns the contact entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact entry
	 * @return the contact entry
	 * @throws com.liferay.portal.NoSuchModelException if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry
	 * @throws vn.com.fis.portal.NoSuchContactEntryException if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry findByPrimaryKey(long contactId)
		throws NoSuchContactEntryException, SystemException {
		ContactEntry contactEntry = fetchByPrimaryKey(contactId);

		if (contactEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
			}

			throw new NoSuchContactEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactId);
		}

		return contactEntry;
	}

	/**
	 * Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact entry
	 * @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact entry
	 * @return the contact entry, or <code>null</code> if a contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry fetchByPrimaryKey(long contactId)
		throws SystemException {
		ContactEntry contactEntry = (ContactEntry)EntityCacheUtil.getResult(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactEntryImpl.class, contactId);

		if (contactEntry == _nullContactEntry) {
			return null;
		}

		if (contactEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactEntry = (ContactEntry)session.get(ContactEntryImpl.class,
						Long.valueOf(contactId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactEntry != null) {
					cacheResult(contactEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactEntryImpl.class, contactId, _nullContactEntry);
				}

				closeSession(session);
			}
		}

		return contactEntry;
	}

	/**
	 * Returns the contact entry where userId = &#63; and mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @return the matching contact entry
	 * @throws vn.com.fis.portal.NoSuchContactEntryException if a matching contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry findByUserId_MobileNumber(long userId,
		String mobileNumber)
		throws NoSuchContactEntryException, SystemException {
		ContactEntry contactEntry = fetchByUserId_MobileNumber(userId,
				mobileNumber);

		if (contactEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", mobileNumber=");
			msg.append(mobileNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactEntryException(msg.toString());
		}

		return contactEntry;
	}

	/**
	 * Returns the contact entry where userId = &#63; and mobileNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry fetchByUserId_MobileNumber(long userId,
		String mobileNumber) throws SystemException {
		return fetchByUserId_MobileNumber(userId, mobileNumber, true);
	}

	/**
	 * Returns the contact entry where userId = &#63; and mobileNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact entry, or <code>null</code> if a matching contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactEntry fetchByUserId_MobileNumber(long userId,
		String mobileNumber, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, mobileNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTACTENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_USERID_2);

			if (mobileNumber == null) {
				query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_1);
			}
			else {
				if (mobileNumber.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_2);
				}
			}

			query.append(ContactEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (mobileNumber != null) {
					qPos.add(mobileNumber);
				}

				List<ContactEntry> list = q.list();

				result = list;

				ContactEntry contactEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
						finderArgs, list);
				}
				else {
					contactEntry = list.get(0);

					cacheResult(contactEntry);

					if ((contactEntry.getUserId() != userId) ||
							(contactEntry.getMobileNumber() == null) ||
							!contactEntry.getMobileNumber().equals(mobileNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
							finderArgs, contactEntry);
					}
				}

				return contactEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_MOBILENUMBER,
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
				return (ContactEntry)result;
			}
		}
	}

	/**
	 * Returns all the contact entries.
	 *
	 * @return the contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ContactEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact entries
	 * @param end the upper bound of the range of contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactEntry> findAll(int start, int end,
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

		List<ContactEntry> list = (List<ContactEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTENTRY.concat(ContactEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactEntry>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes the contact entry where userId = &#63; and mobileNumber = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_MobileNumber(long userId, String mobileNumber)
		throws NoSuchContactEntryException, SystemException {
		ContactEntry contactEntry = findByUserId_MobileNumber(userId,
				mobileNumber);

		remove(contactEntry);
	}

	/**
	 * Removes all the contact entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactEntry contactEntry : findAll()) {
			remove(contactEntry);
		}
	}

	/**
	 * Returns the number of contact entries where userId = &#63; and mobileNumber = &#63;.
	 *
	 * @param userId the user ID
	 * @param mobileNumber the mobile number
	 * @return the number of matching contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_MobileNumber(long userId, String mobileNumber)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, mobileNumber };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_MOBILENUMBER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_USERID_2);

			if (mobileNumber == null) {
				query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_1);
			}
			else {
				if (mobileNumber.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (mobileNumber != null) {
					qPos.add(mobileNumber);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_MOBILENUMBER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact entries.
	 *
	 * @return the number of contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTENTRY);

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
	 * Initializes the contact entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ContactEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactEntry>> listenersList = new ArrayList<ModelListener<ContactEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_CONTACTENTRY = "SELECT contactEntry FROM ContactEntry contactEntry";
	private static final String _SQL_SELECT_CONTACTENTRY_WHERE = "SELECT contactEntry FROM ContactEntry contactEntry WHERE ";
	private static final String _SQL_COUNT_CONTACTENTRY = "SELECT COUNT(contactEntry) FROM ContactEntry contactEntry";
	private static final String _SQL_COUNT_CONTACTENTRY_WHERE = "SELECT COUNT(contactEntry) FROM ContactEntry contactEntry WHERE ";
	private static final String _FINDER_COLUMN_USERID_MOBILENUMBER_USERID_2 = "contactEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_1 =
		"contactEntry.mobileNumber IS NULL";
	private static final String _FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_2 =
		"contactEntry.mobileNumber = ?";
	private static final String _FINDER_COLUMN_USERID_MOBILENUMBER_MOBILENUMBER_3 =
		"(contactEntry.mobileNumber IS NULL OR contactEntry.mobileNumber = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactEntryPersistenceImpl.class);
	private static ContactEntry _nullContactEntry = new ContactEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactEntry> toCacheModel() {
				return _nullContactEntryCacheModel;
			}
		};

	private static CacheModel<ContactEntry> _nullContactEntryCacheModel = new CacheModel<ContactEntry>() {
			public ContactEntry toEntityModel() {
				return _nullContactEntry;
			}
		};
}