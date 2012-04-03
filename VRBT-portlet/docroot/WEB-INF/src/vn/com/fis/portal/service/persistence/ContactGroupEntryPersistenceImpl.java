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

import vn.com.fis.portal.NoSuchContactGroupEntryException;
import vn.com.fis.portal.model.ContactGroupEntry;
import vn.com.fis.portal.model.impl.ContactGroupEntryImpl;
import vn.com.fis.portal.model.impl.ContactGroupEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupEntryPersistence
 * @see ContactGroupEntryUtil
 * @generated
 */
public class ContactGroupEntryPersistenceImpl extends BasePersistenceImpl<ContactGroupEntry>
	implements ContactGroupEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactGroupEntryUtil} to access the contact group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactGroupEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ContactGroupEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId_ContactGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactGroupEntryModelImpl.USERID_COLUMN_BITMASK |
			ContactGroupEntryModelImpl.CONTACTGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_CONTACTGROUPID = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_ContactGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the contact group entry in the entity cache if it is enabled.
	 *
	 * @param contactGroupEntry the contact group entry
	 */
	public void cacheResult(ContactGroupEntry contactGroupEntry) {
		EntityCacheUtil.putResult(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryImpl.class, contactGroupEntry.getPrimaryKey(),
			contactGroupEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
			new Object[] {
				Long.valueOf(contactGroupEntry.getUserId()),
				Long.valueOf(contactGroupEntry.getContactGroupId())
			}, contactGroupEntry);

		contactGroupEntry.resetOriginalValues();
	}

	/**
	 * Caches the contact group entries in the entity cache if it is enabled.
	 *
	 * @param contactGroupEntries the contact group entries
	 */
	public void cacheResult(List<ContactGroupEntry> contactGroupEntries) {
		for (ContactGroupEntry contactGroupEntry : contactGroupEntries) {
			if (EntityCacheUtil.getResult(
						ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactGroupEntryImpl.class,
						contactGroupEntry.getPrimaryKey()) == null) {
				cacheResult(contactGroupEntry);
			}
			else {
				contactGroupEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact group entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactGroupEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactGroupEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact group entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ContactGroupEntry contactGroupEntry) {
		EntityCacheUtil.removeResult(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryImpl.class, contactGroupEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contactGroupEntry);
	}

	@Override
	public void clearCache(List<ContactGroupEntry> contactGroupEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactGroupEntry contactGroupEntry : contactGroupEntries) {
			EntityCacheUtil.removeResult(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactGroupEntryImpl.class, contactGroupEntry.getPrimaryKey());

			clearUniqueFindersCache(contactGroupEntry);
		}
	}

	protected void clearUniqueFindersCache(ContactGroupEntry contactGroupEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
			new Object[] {
				Long.valueOf(contactGroupEntry.getUserId()),
				Long.valueOf(contactGroupEntry.getContactGroupId())
			});
	}

	/**
	 * Creates a new contact group entry with the primary key. Does not add the contact group entry to the database.
	 *
	 * @param contactGroupId the primary key for the new contact group entry
	 * @return the new contact group entry
	 */
	public ContactGroupEntry create(long contactGroupId) {
		ContactGroupEntry contactGroupEntry = new ContactGroupEntryImpl();

		contactGroupEntry.setNew(true);
		contactGroupEntry.setPrimaryKey(contactGroupId);

		return contactGroupEntry;
	}

	/**
	 * Removes the contact group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactGroupId the primary key of the contact group entry
	 * @return the contact group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry remove(long contactGroupId)
		throws NoSuchContactGroupEntryException, SystemException {
		return remove(Long.valueOf(contactGroupId));
	}

	/**
	 * Removes the contact group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact group entry
	 * @return the contact group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupEntry remove(Serializable primaryKey)
		throws NoSuchContactGroupEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactGroupEntry contactGroupEntry = (ContactGroupEntry)session.get(ContactGroupEntryImpl.class,
					primaryKey);

			if (contactGroupEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactGroupEntry);
		}
		catch (NoSuchContactGroupEntryException nsee) {
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
	protected ContactGroupEntry removeImpl(ContactGroupEntry contactGroupEntry)
		throws SystemException {
		contactGroupEntry = toUnwrappedModel(contactGroupEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactGroupEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactGroupEntry);

		return contactGroupEntry;
	}

	@Override
	public ContactGroupEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupEntry contactGroupEntry,
		boolean merge) throws SystemException {
		contactGroupEntry = toUnwrappedModel(contactGroupEntry);

		boolean isNew = contactGroupEntry.isNew();

		ContactGroupEntryModelImpl contactGroupEntryModelImpl = (ContactGroupEntryModelImpl)contactGroupEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactGroupEntry, merge);

			contactGroupEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ContactGroupEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactGroupEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(contactGroupEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupEntryImpl.class, contactGroupEntry.getPrimaryKey(),
			contactGroupEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
				new Object[] {
					Long.valueOf(contactGroupEntry.getUserId()),
					Long.valueOf(contactGroupEntry.getContactGroupId())
				}, contactGroupEntry);
		}
		else {
			if ((contactGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactGroupEntryModelImpl.getOriginalUserId()),
						Long.valueOf(contactGroupEntryModelImpl.getOriginalContactGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_CONTACTGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
					new Object[] {
						Long.valueOf(contactGroupEntry.getUserId()),
						Long.valueOf(contactGroupEntry.getContactGroupId())
					}, contactGroupEntry);
			}
		}

		return contactGroupEntry;
	}

	protected ContactGroupEntry toUnwrappedModel(
		ContactGroupEntry contactGroupEntry) {
		if (contactGroupEntry instanceof ContactGroupEntryImpl) {
			return contactGroupEntry;
		}

		ContactGroupEntryImpl contactGroupEntryImpl = new ContactGroupEntryImpl();

		contactGroupEntryImpl.setNew(contactGroupEntry.isNew());
		contactGroupEntryImpl.setPrimaryKey(contactGroupEntry.getPrimaryKey());

		contactGroupEntryImpl.setContactGroupId(contactGroupEntry.getContactGroupId());
		contactGroupEntryImpl.setContactGroupName(contactGroupEntry.getContactGroupName());
		contactGroupEntryImpl.setDescription(contactGroupEntry.getDescription());
		contactGroupEntryImpl.setContactGroupType(contactGroupEntry.getContactGroupType());
		contactGroupEntryImpl.setUserId(contactGroupEntry.getUserId());

		return contactGroupEntryImpl;
	}

	/**
	 * Returns the contact group entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact group entry
	 * @return the contact group entry
	 * @throws com.liferay.portal.NoSuchModelException if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupEntryException} if it could not be found.
	 *
	 * @param contactGroupId the primary key of the contact group entry
	 * @return the contact group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry findByPrimaryKey(long contactGroupId)
		throws NoSuchContactGroupEntryException, SystemException {
		ContactGroupEntry contactGroupEntry = fetchByPrimaryKey(contactGroupId);

		if (contactGroupEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactGroupId);
			}

			throw new NoSuchContactGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactGroupId);
		}

		return contactGroupEntry;
	}

	/**
	 * Returns the contact group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact group entry
	 * @return the contact group entry, or <code>null</code> if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactGroupId the primary key of the contact group entry
	 * @return the contact group entry, or <code>null</code> if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry fetchByPrimaryKey(long contactGroupId)
		throws SystemException {
		ContactGroupEntry contactGroupEntry = (ContactGroupEntry)EntityCacheUtil.getResult(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactGroupEntryImpl.class, contactGroupId);

		if (contactGroupEntry == _nullContactGroupEntry) {
			return null;
		}

		if (contactGroupEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactGroupEntry = (ContactGroupEntry)session.get(ContactGroupEntryImpl.class,
						Long.valueOf(contactGroupId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactGroupEntry != null) {
					cacheResult(contactGroupEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactGroupEntryImpl.class, contactGroupId,
						_nullContactGroupEntry);
				}

				closeSession(session);
			}
		}

		return contactGroupEntry;
	}

	/**
	 * Returns all the contact group entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupEntry> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ContactGroupEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact group entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of contact group entries
	 * @param end the upper bound of the range of contact group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupEntry> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<ContactGroupEntry> list = (List<ContactGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CONTACTGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ContactGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ContactGroupEntry>)QueryUtil.list(q, getDialect(),
						start, end);
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
	 * Returns the first contact group entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchContactGroupEntryException, SystemException {
		List<ContactGroupEntry> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last contact group entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a matching contact group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchContactGroupEntryException, SystemException {
		int count = countByUserId(userId);

		List<ContactGroupEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the contact group entries before and after the current contact group entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupId the primary key of the current contact group entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupEntryException if a contact group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry[] findByUserId_PrevAndNext(long contactGroupId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchContactGroupEntryException, SystemException {
		ContactGroupEntry contactGroupEntry = findByPrimaryKey(contactGroupId);

		Session session = null;

		try {
			session = openSession();

			ContactGroupEntry[] array = new ContactGroupEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, contactGroupEntry,
					userId, orderByComparator, true);

			array[1] = contactGroupEntry;

			array[2] = getByUserId_PrevAndNext(session, contactGroupEntry,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ContactGroupEntry getByUserId_PrevAndNext(Session session,
		ContactGroupEntry contactGroupEntry, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTGROUPENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(ContactGroupEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactGroupEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactGroupEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public ContactGroupEntry findByUserId_ContactGroupId(long userId,
		long contactGroupId)
		throws NoSuchContactGroupEntryException, SystemException {
		ContactGroupEntry contactGroupEntry = fetchByUserId_ContactGroupId(userId,
				contactGroupId);

		if (contactGroupEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", contactGroupId=");
			msg.append(contactGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactGroupEntryException(msg.toString());
		}

		return contactGroupEntry;
	}

	/**
	 * Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @return the matching contact group entry, or <code>null</code> if a matching contact group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry fetchByUserId_ContactGroupId(long userId,
		long contactGroupId) throws SystemException {
		return fetchByUserId_ContactGroupId(userId, contactGroupId, true);
	}

	/**
	 * Returns the contact group entry where userId = &#63; and contactGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact group entry, or <code>null</code> if a matching contact group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupEntry fetchByUserId_ContactGroupId(long userId,
		long contactGroupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, contactGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_CONTACTGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_CONTACTGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_CONTACTGROUPID_CONTACTGROUPID_2);

			query.append(ContactGroupEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(contactGroupId);

				List<ContactGroupEntry> list = q.list();

				result = list;

				ContactGroupEntry contactGroupEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
						finderArgs, list);
				}
				else {
					contactGroupEntry = list.get(0);

					cacheResult(contactGroupEntry);

					if ((contactGroupEntry.getUserId() != userId) ||
							(contactGroupEntry.getContactGroupId() != contactGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
							finderArgs, contactGroupEntry);
					}
				}

				return contactGroupEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_CONTACTGROUPID,
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
				return (ContactGroupEntry)result;
			}
		}
	}

	/**
	 * Returns all the contact group entries.
	 *
	 * @return the contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ContactGroupEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact group entries
	 * @param end the upper bound of the range of contact group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupEntry> findAll(int start, int end,
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

		List<ContactGroupEntry> list = (List<ContactGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTGROUPENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTGROUPENTRY.concat(ContactGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactGroupEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactGroupEntry>)QueryUtil.list(q,
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
	 * Removes all the contact group entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (ContactGroupEntry contactGroupEntry : findByUserId(userId)) {
			remove(contactGroupEntry);
		}
	}

	/**
	 * Removes the contact group entry where userId = &#63; and contactGroupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ContactGroupId(long userId, long contactGroupId)
		throws NoSuchContactGroupEntryException, SystemException {
		ContactGroupEntry contactGroupEntry = findByUserId_ContactGroupId(userId,
				contactGroupId);

		remove(contactGroupEntry);
	}

	/**
	 * Removes all the contact group entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactGroupEntry contactGroupEntry : findAll()) {
			remove(contactGroupEntry);
		}
	}

	/**
	 * Returns the number of contact group entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact group entries where userId = &#63; and contactGroupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param contactGroupId the contact group ID
	 * @return the number of matching contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ContactGroupId(long userId, long contactGroupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, contactGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_CONTACTGROUPID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_CONTACTGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_CONTACTGROUPID_CONTACTGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(contactGroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_CONTACTGROUPID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact group entries.
	 *
	 * @return the number of contact group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTGROUPENTRY);

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
	 * Initializes the contact group entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ContactGroupEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactGroupEntry>> listenersList = new ArrayList<ModelListener<ContactGroupEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactGroupEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactGroupEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_CONTACTGROUPENTRY = "SELECT contactGroupEntry FROM ContactGroupEntry contactGroupEntry";
	private static final String _SQL_SELECT_CONTACTGROUPENTRY_WHERE = "SELECT contactGroupEntry FROM ContactGroupEntry contactGroupEntry WHERE ";
	private static final String _SQL_COUNT_CONTACTGROUPENTRY = "SELECT COUNT(contactGroupEntry) FROM ContactGroupEntry contactGroupEntry";
	private static final String _SQL_COUNT_CONTACTGROUPENTRY_WHERE = "SELECT COUNT(contactGroupEntry) FROM ContactGroupEntry contactGroupEntry WHERE ";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "contactGroupEntry.userId = ?";
	private static final String _FINDER_COLUMN_USERID_CONTACTGROUPID_USERID_2 = "contactGroupEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_CONTACTGROUPID_CONTACTGROUPID_2 =
		"contactGroupEntry.contactGroupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactGroupEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactGroupEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactGroupEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactGroupEntryPersistenceImpl.class);
	private static ContactGroupEntry _nullContactGroupEntry = new ContactGroupEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactGroupEntry> toCacheModel() {
				return _nullContactGroupEntryCacheModel;
			}
		};

	private static CacheModel<ContactGroupEntry> _nullContactGroupEntryCacheModel =
		new CacheModel<ContactGroupEntry>() {
			public ContactGroupEntry toEntityModel() {
				return _nullContactGroupEntry;
			}
		};
}