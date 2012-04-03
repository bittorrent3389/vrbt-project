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

import vn.com.fis.portal.NoSuchNotificationEntryException;
import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.model.impl.NotificationEntryImpl;
import vn.com.fis.portal.model.impl.NotificationEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the notification entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see NotificationEntryPersistence
 * @see NotificationEntryUtil
 * @generated
 */
public class NotificationEntryPersistenceImpl extends BasePersistenceImpl<NotificationEntry>
	implements NotificationEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NotificationEntryUtil} to access the notification entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NotificationEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDFROM_USERIDTO =
		new FinderPath(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryModelImpl.FINDER_CACHE_ENABLED,
			NotificationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdFrom_UserIdTo",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDFROM_USERIDTO =
		new FinderPath(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryModelImpl.FINDER_CACHE_ENABLED,
			NotificationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdFrom_UserIdTo",
			new String[] { Long.class.getName(), Long.class.getName() },
			NotificationEntryModelImpl.USERIDFROM_COLUMN_BITMASK |
			NotificationEntryModelImpl.USERIDTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDFROM_USERIDTO = new FinderPath(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdFrom_UserIdTo",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryModelImpl.FINDER_CACHE_ENABLED,
			NotificationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryModelImpl.FINDER_CACHE_ENABLED,
			NotificationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the notification entry in the entity cache if it is enabled.
	 *
	 * @param notificationEntry the notification entry
	 */
	public void cacheResult(NotificationEntry notificationEntry) {
		EntityCacheUtil.putResult(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryImpl.class, notificationEntry.getPrimaryKey(),
			notificationEntry);

		notificationEntry.resetOriginalValues();
	}

	/**
	 * Caches the notification entries in the entity cache if it is enabled.
	 *
	 * @param notificationEntries the notification entries
	 */
	public void cacheResult(List<NotificationEntry> notificationEntries) {
		for (NotificationEntry notificationEntry : notificationEntries) {
			if (EntityCacheUtil.getResult(
						NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
						NotificationEntryImpl.class,
						notificationEntry.getPrimaryKey()) == null) {
				cacheResult(notificationEntry);
			}
			else {
				notificationEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notification entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(NotificationEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(NotificationEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the notification entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NotificationEntry notificationEntry) {
		EntityCacheUtil.removeResult(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryImpl.class, notificationEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<NotificationEntry> notificationEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NotificationEntry notificationEntry : notificationEntries) {
			EntityCacheUtil.removeResult(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
				NotificationEntryImpl.class, notificationEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new notification entry with the primary key. Does not add the notification entry to the database.
	 *
	 * @param notificationId the primary key for the new notification entry
	 * @return the new notification entry
	 */
	public NotificationEntry create(long notificationId) {
		NotificationEntry notificationEntry = new NotificationEntryImpl();

		notificationEntry.setNew(true);
		notificationEntry.setPrimaryKey(notificationId);

		return notificationEntry;
	}

	/**
	 * Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationId the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NotificationEntry remove(long notificationId)
		throws NoSuchNotificationEntryException, SystemException {
		return remove(Long.valueOf(notificationId));
	}

	/**
	 * Removes the notification entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification entry
	 * @return the notification entry that was removed
	 * @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationEntry remove(Serializable primaryKey)
		throws NoSuchNotificationEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			NotificationEntry notificationEntry = (NotificationEntry)session.get(NotificationEntryImpl.class,
					primaryKey);

			if (notificationEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(notificationEntry);
		}
		catch (NoSuchNotificationEntryException nsee) {
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
	protected NotificationEntry removeImpl(NotificationEntry notificationEntry)
		throws SystemException {
		notificationEntry = toUnwrappedModel(notificationEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, notificationEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(notificationEntry);

		return notificationEntry;
	}

	@Override
	public NotificationEntry updateImpl(
		vn.com.fis.portal.model.NotificationEntry notificationEntry,
		boolean merge) throws SystemException {
		notificationEntry = toUnwrappedModel(notificationEntry);

		boolean isNew = notificationEntry.isNew();

		NotificationEntryModelImpl notificationEntryModelImpl = (NotificationEntryModelImpl)notificationEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, notificationEntry, merge);

			notificationEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !NotificationEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((notificationEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDFROM_USERIDTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(notificationEntryModelImpl.getOriginalUserIdFrom()),
						Long.valueOf(notificationEntryModelImpl.getOriginalUserIdTo())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDFROM_USERIDTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDFROM_USERIDTO,
					args);

				args = new Object[] {
						Long.valueOf(notificationEntryModelImpl.getUserIdFrom()),
						Long.valueOf(notificationEntryModelImpl.getUserIdTo())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDFROM_USERIDTO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDFROM_USERIDTO,
					args);
			}
		}

		EntityCacheUtil.putResult(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
			NotificationEntryImpl.class, notificationEntry.getPrimaryKey(),
			notificationEntry);

		return notificationEntry;
	}

	protected NotificationEntry toUnwrappedModel(
		NotificationEntry notificationEntry) {
		if (notificationEntry instanceof NotificationEntryImpl) {
			return notificationEntry;
		}

		NotificationEntryImpl notificationEntryImpl = new NotificationEntryImpl();

		notificationEntryImpl.setNew(notificationEntry.isNew());
		notificationEntryImpl.setPrimaryKey(notificationEntry.getPrimaryKey());

		notificationEntryImpl.setNotificationId(notificationEntry.getNotificationId());
		notificationEntryImpl.setUserIdFrom(notificationEntry.getUserIdFrom());
		notificationEntryImpl.setUserIdTo(notificationEntry.getUserIdTo());
		notificationEntryImpl.setSubject(notificationEntry.getSubject());
		notificationEntryImpl.setMessage(notificationEntry.getMessage());
		notificationEntryImpl.setCreateDate(notificationEntry.getCreateDate());
		notificationEntryImpl.setStatus(notificationEntry.getStatus());

		return notificationEntryImpl;
	}

	/**
	 * Returns the notification entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification entry
	 * @return the notification entry
	 * @throws com.liferay.portal.NoSuchModelException if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the notification entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchNotificationEntryException} if it could not be found.
	 *
	 * @param notificationId the primary key of the notification entry
	 * @return the notification entry
	 * @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NotificationEntry findByPrimaryKey(long notificationId)
		throws NoSuchNotificationEntryException, SystemException {
		NotificationEntry notificationEntry = fetchByPrimaryKey(notificationId);

		if (notificationEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + notificationId);
			}

			throw new NoSuchNotificationEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				notificationId);
		}

		return notificationEntry;
	}

	/**
	 * Returns the notification entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification entry
	 * @return the notification entry, or <code>null</code> if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public NotificationEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the notification entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification entry
	 * @return the notification entry, or <code>null</code> if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NotificationEntry fetchByPrimaryKey(long notificationId)
		throws SystemException {
		NotificationEntry notificationEntry = (NotificationEntry)EntityCacheUtil.getResult(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
				NotificationEntryImpl.class, notificationId);

		if (notificationEntry == _nullNotificationEntry) {
			return null;
		}

		if (notificationEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				notificationEntry = (NotificationEntry)session.get(NotificationEntryImpl.class,
						Long.valueOf(notificationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (notificationEntry != null) {
					cacheResult(notificationEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(NotificationEntryModelImpl.ENTITY_CACHE_ENABLED,
						NotificationEntryImpl.class, notificationId,
						_nullNotificationEntry);
				}

				closeSession(session);
			}
		}

		return notificationEntry;
	}

	/**
	 * Returns all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @return the matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findByUserIdFrom_UserIdTo(long userIdFrom,
		long userIdTo) throws SystemException {
		return findByUserIdFrom_UserIdTo(userIdFrom, userIdTo,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findByUserIdFrom_UserIdTo(long userIdFrom,
		long userIdTo, int start, int end) throws SystemException {
		return findByUserIdFrom_UserIdTo(userIdFrom, userIdTo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findByUserIdFrom_UserIdTo(long userIdFrom,
		long userIdTo, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDFROM_USERIDTO;
			finderArgs = new Object[] { userIdFrom, userIdTo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDFROM_USERIDTO;
			finderArgs = new Object[] {
					userIdFrom, userIdTo,
					
					start, end, orderByComparator
				};
		}

		List<NotificationEntry> list = (List<NotificationEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDFROM_2);

			query.append(_FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdFrom);

				qPos.add(userIdTo);

				list = (List<NotificationEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first notification entry in the ordered set where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification entry
	 * @throws vn.com.fis.portal.NoSuchNotificationEntryException if a matching notification entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NotificationEntry findByUserIdFrom_UserIdTo_First(long userIdFrom,
		long userIdTo, OrderByComparator orderByComparator)
		throws NoSuchNotificationEntryException, SystemException {
		List<NotificationEntry> list = findByUserIdFrom_UserIdTo(userIdFrom,
				userIdTo, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userIdFrom=");
			msg.append(userIdFrom);

			msg.append(", userIdTo=");
			msg.append(userIdTo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNotificationEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last notification entry in the ordered set where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification entry
	 * @throws vn.com.fis.portal.NoSuchNotificationEntryException if a matching notification entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NotificationEntry findByUserIdFrom_UserIdTo_Last(long userIdFrom,
		long userIdTo, OrderByComparator orderByComparator)
		throws NoSuchNotificationEntryException, SystemException {
		int count = countByUserIdFrom_UserIdTo(userIdFrom, userIdTo);

		List<NotificationEntry> list = findByUserIdFrom_UserIdTo(userIdFrom,
				userIdTo, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userIdFrom=");
			msg.append(userIdFrom);

			msg.append(", userIdTo=");
			msg.append(userIdTo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchNotificationEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the notification entries before and after the current notification entry in the ordered set where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param notificationId the primary key of the current notification entry
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification entry
	 * @throws vn.com.fis.portal.NoSuchNotificationEntryException if a notification entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public NotificationEntry[] findByUserIdFrom_UserIdTo_PrevAndNext(
		long notificationId, long userIdFrom, long userIdTo,
		OrderByComparator orderByComparator)
		throws NoSuchNotificationEntryException, SystemException {
		NotificationEntry notificationEntry = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			NotificationEntry[] array = new NotificationEntryImpl[3];

			array[0] = getByUserIdFrom_UserIdTo_PrevAndNext(session,
					notificationEntry, userIdFrom, userIdTo, orderByComparator,
					true);

			array[1] = notificationEntry;

			array[2] = getByUserIdFrom_UserIdTo_PrevAndNext(session,
					notificationEntry, userIdFrom, userIdTo, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected NotificationEntry getByUserIdFrom_UserIdTo_PrevAndNext(
		Session session, NotificationEntry notificationEntry, long userIdFrom,
		long userIdTo, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NOTIFICATIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDFROM_2);

		query.append(_FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDTO_2);

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
			query.append(NotificationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userIdFrom);

		qPos.add(userIdTo);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(notificationEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<NotificationEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the notification entries.
	 *
	 * @return the notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @return the range of notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notification entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of notification entries
	 * @param end the upper bound of the range of notification entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<NotificationEntry> findAll(int start, int end,
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

		List<NotificationEntry> list = (List<NotificationEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_NOTIFICATIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATIONENTRY.concat(NotificationEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<NotificationEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<NotificationEntry>)QueryUtil.list(q,
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
	 * Removes all the notification entries where userIdFrom = &#63; and userIdTo = &#63; from the database.
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserIdFrom_UserIdTo(long userIdFrom, long userIdTo)
		throws SystemException {
		for (NotificationEntry notificationEntry : findByUserIdFrom_UserIdTo(
				userIdFrom, userIdTo)) {
			remove(notificationEntry);
		}
	}

	/**
	 * Removes all the notification entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (NotificationEntry notificationEntry : findAll()) {
			remove(notificationEntry);
		}
	}

	/**
	 * Returns the number of notification entries where userIdFrom = &#63; and userIdTo = &#63;.
	 *
	 * @param userIdFrom the user ID from
	 * @param userIdTo the user ID to
	 * @return the number of matching notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserIdFrom_UserIdTo(long userIdFrom, long userIdTo)
		throws SystemException {
		Object[] finderArgs = new Object[] { userIdFrom, userIdTo };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERIDFROM_USERIDTO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NOTIFICATIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDFROM_2);

			query.append(_FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userIdFrom);

				qPos.add(userIdTo);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERIDFROM_USERIDTO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of notification entries.
	 *
	 * @return the number of notification entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NOTIFICATIONENTRY);

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
	 * Initializes the notification entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.NotificationEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<NotificationEntry>> listenersList = new ArrayList<ModelListener<NotificationEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<NotificationEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(NotificationEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_NOTIFICATIONENTRY = "SELECT notificationEntry FROM NotificationEntry notificationEntry";
	private static final String _SQL_SELECT_NOTIFICATIONENTRY_WHERE = "SELECT notificationEntry FROM NotificationEntry notificationEntry WHERE ";
	private static final String _SQL_COUNT_NOTIFICATIONENTRY = "SELECT COUNT(notificationEntry) FROM NotificationEntry notificationEntry";
	private static final String _SQL_COUNT_NOTIFICATIONENTRY_WHERE = "SELECT COUNT(notificationEntry) FROM NotificationEntry notificationEntry WHERE ";
	private static final String _FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDFROM_2 = "notificationEntry.userIdFrom = ? AND ";
	private static final String _FINDER_COLUMN_USERIDFROM_USERIDTO_USERIDTO_2 = "notificationEntry.userIdTo = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "notificationEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NotificationEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NotificationEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(NotificationEntryPersistenceImpl.class);
	private static NotificationEntry _nullNotificationEntry = new NotificationEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<NotificationEntry> toCacheModel() {
				return _nullNotificationEntryCacheModel;
			}
		};

	private static CacheModel<NotificationEntry> _nullNotificationEntryCacheModel =
		new CacheModel<NotificationEntry>() {
			public NotificationEntry toEntityModel() {
				return _nullNotificationEntry;
			}
		};
}