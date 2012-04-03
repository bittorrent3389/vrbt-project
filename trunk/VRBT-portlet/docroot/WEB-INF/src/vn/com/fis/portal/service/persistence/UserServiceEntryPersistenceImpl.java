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

import vn.com.fis.portal.NoSuchUserServiceEntryException;
import vn.com.fis.portal.model.UserServiceEntry;
import vn.com.fis.portal.model.impl.UserServiceEntryImpl;
import vn.com.fis.portal.model.impl.UserServiceEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user service entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see UserServiceEntryPersistence
 * @see UserServiceEntryUtil
 * @generated
 */
public class UserServiceEntryPersistenceImpl extends BasePersistenceImpl<UserServiceEntry>
	implements UserServiceEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserServiceEntryUtil} to access the user service entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserServiceEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID_SERVICEID = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED,
			UserServiceEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId_ServiceId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserServiceEntryModelImpl.USERID_COLUMN_BITMASK |
			UserServiceEntryModelImpl.SERVICEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_SERVICEID = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_ServiceId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED,
			UserServiceEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId_ServicePackageId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserServiceEntryModelImpl.USERID_COLUMN_BITMASK |
			UserServiceEntryModelImpl.SERVICEPACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_SERVICEPACKAGEID = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_ServicePackageId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID =
		new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED,
			UserServiceEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUserId_ServiceId_PackageId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			UserServiceEntryModelImpl.USERID_COLUMN_BITMASK |
			UserServiceEntryModelImpl.SERVICEID_COLUMN_BITMASK |
			UserServiceEntryModelImpl.SERVICEPACKAGEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_SERVICEID_PACKAGEID =
		new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_ServiceId_PackageId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED,
			UserServiceEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED,
			UserServiceEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the user service entry in the entity cache if it is enabled.
	 *
	 * @param userServiceEntry the user service entry
	 */
	public void cacheResult(UserServiceEntry userServiceEntry) {
		EntityCacheUtil.putResult(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryImpl.class, userServiceEntry.getPrimaryKey(),
			userServiceEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
			new Object[] {
				Long.valueOf(userServiceEntry.getUserId()),
				Long.valueOf(userServiceEntry.getServiceId())
			}, userServiceEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
			new Object[] {
				Long.valueOf(userServiceEntry.getUserId()),
				Long.valueOf(userServiceEntry.getServicePackageId())
			}, userServiceEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
			new Object[] {
				Long.valueOf(userServiceEntry.getUserId()),
				Long.valueOf(userServiceEntry.getServiceId()),
				Long.valueOf(userServiceEntry.getServicePackageId())
			}, userServiceEntry);

		userServiceEntry.resetOriginalValues();
	}

	/**
	 * Caches the user service entries in the entity cache if it is enabled.
	 *
	 * @param userServiceEntries the user service entries
	 */
	public void cacheResult(List<UserServiceEntry> userServiceEntries) {
		for (UserServiceEntry userServiceEntry : userServiceEntries) {
			if (EntityCacheUtil.getResult(
						UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
						UserServiceEntryImpl.class,
						userServiceEntry.getPrimaryKey()) == null) {
				cacheResult(userServiceEntry);
			}
			else {
				userServiceEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user service entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserServiceEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserServiceEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user service entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserServiceEntry userServiceEntry) {
		EntityCacheUtil.removeResult(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryImpl.class, userServiceEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userServiceEntry);
	}

	@Override
	public void clearCache(List<UserServiceEntry> userServiceEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserServiceEntry userServiceEntry : userServiceEntries) {
			EntityCacheUtil.removeResult(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
				UserServiceEntryImpl.class, userServiceEntry.getPrimaryKey());

			clearUniqueFindersCache(userServiceEntry);
		}
	}

	protected void clearUniqueFindersCache(UserServiceEntry userServiceEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
			new Object[] {
				Long.valueOf(userServiceEntry.getUserId()),
				Long.valueOf(userServiceEntry.getServiceId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
			new Object[] {
				Long.valueOf(userServiceEntry.getUserId()),
				Long.valueOf(userServiceEntry.getServicePackageId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
			new Object[] {
				Long.valueOf(userServiceEntry.getUserId()),
				Long.valueOf(userServiceEntry.getServiceId()),
				Long.valueOf(userServiceEntry.getServicePackageId())
			});
	}

	/**
	 * Creates a new user service entry with the primary key. Does not add the user service entry to the database.
	 *
	 * @param userServiceId the primary key for the new user service entry
	 * @return the new user service entry
	 */
	public UserServiceEntry create(long userServiceId) {
		UserServiceEntry userServiceEntry = new UserServiceEntryImpl();

		userServiceEntry.setNew(true);
		userServiceEntry.setPrimaryKey(userServiceId);

		return userServiceEntry;
	}

	/**
	 * Removes the user service entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userServiceId the primary key of the user service entry
	 * @return the user service entry that was removed
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry remove(long userServiceId)
		throws NoSuchUserServiceEntryException, SystemException {
		return remove(Long.valueOf(userServiceId));
	}

	/**
	 * Removes the user service entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user service entry
	 * @return the user service entry that was removed
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserServiceEntry remove(Serializable primaryKey)
		throws NoSuchUserServiceEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserServiceEntry userServiceEntry = (UserServiceEntry)session.get(UserServiceEntryImpl.class,
					primaryKey);

			if (userServiceEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserServiceEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userServiceEntry);
		}
		catch (NoSuchUserServiceEntryException nsee) {
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
	protected UserServiceEntry removeImpl(UserServiceEntry userServiceEntry)
		throws SystemException {
		userServiceEntry = toUnwrappedModel(userServiceEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userServiceEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userServiceEntry);

		return userServiceEntry;
	}

	@Override
	public UserServiceEntry updateImpl(
		vn.com.fis.portal.model.UserServiceEntry userServiceEntry, boolean merge)
		throws SystemException {
		userServiceEntry = toUnwrappedModel(userServiceEntry);

		boolean isNew = userServiceEntry.isNew();

		UserServiceEntryModelImpl userServiceEntryModelImpl = (UserServiceEntryModelImpl)userServiceEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userServiceEntry, merge);

			userServiceEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserServiceEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserServiceEntryImpl.class, userServiceEntry.getPrimaryKey(),
			userServiceEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
				new Object[] {
					Long.valueOf(userServiceEntry.getUserId()),
					Long.valueOf(userServiceEntry.getServiceId())
				}, userServiceEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
				new Object[] {
					Long.valueOf(userServiceEntry.getUserId()),
					Long.valueOf(userServiceEntry.getServicePackageId())
				}, userServiceEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
				new Object[] {
					Long.valueOf(userServiceEntry.getUserId()),
					Long.valueOf(userServiceEntry.getServiceId()),
					Long.valueOf(userServiceEntry.getServicePackageId())
				}, userServiceEntry);
		}
		else {
			if ((userServiceEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID_SERVICEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userServiceEntryModelImpl.getOriginalUserId()),
						Long.valueOf(userServiceEntryModelImpl.getOriginalServiceId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_SERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
					new Object[] {
						Long.valueOf(userServiceEntry.getUserId()),
						Long.valueOf(userServiceEntry.getServiceId())
					}, userServiceEntry);
			}

			if ((userServiceEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userServiceEntryModelImpl.getOriginalUserId()),
						Long.valueOf(userServiceEntryModelImpl.getOriginalServicePackageId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_SERVICEPACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
					new Object[] {
						Long.valueOf(userServiceEntry.getUserId()),
						Long.valueOf(userServiceEntry.getServicePackageId())
					}, userServiceEntry);
			}

			if ((userServiceEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userServiceEntryModelImpl.getOriginalUserId()),
						Long.valueOf(userServiceEntryModelImpl.getOriginalServiceId()),
						Long.valueOf(userServiceEntryModelImpl.getOriginalServicePackageId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_SERVICEID_PACKAGEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
					new Object[] {
						Long.valueOf(userServiceEntry.getUserId()),
						Long.valueOf(userServiceEntry.getServiceId()),
						Long.valueOf(userServiceEntry.getServicePackageId())
					}, userServiceEntry);
			}
		}

		return userServiceEntry;
	}

	protected UserServiceEntry toUnwrappedModel(
		UserServiceEntry userServiceEntry) {
		if (userServiceEntry instanceof UserServiceEntryImpl) {
			return userServiceEntry;
		}

		UserServiceEntryImpl userServiceEntryImpl = new UserServiceEntryImpl();

		userServiceEntryImpl.setNew(userServiceEntry.isNew());
		userServiceEntryImpl.setPrimaryKey(userServiceEntry.getPrimaryKey());

		userServiceEntryImpl.setUserServiceId(userServiceEntry.getUserServiceId());
		userServiceEntryImpl.setUserId(userServiceEntry.getUserId());
		userServiceEntryImpl.setServiceId(userServiceEntry.getServiceId());
		userServiceEntryImpl.setServiceStatus(userServiceEntry.getServiceStatus());
		userServiceEntryImpl.setServiceStartDate(userServiceEntry.getServiceStartDate());
		userServiceEntryImpl.setServiceStopDate(userServiceEntry.getServiceStopDate());
		userServiceEntryImpl.setServicePackageId(userServiceEntry.getServicePackageId());
		userServiceEntryImpl.setPackageDate(userServiceEntry.getPackageDate());

		return userServiceEntryImpl;
	}

	/**
	 * Returns the user service entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user service entry
	 * @return the user service entry
	 * @throws com.liferay.portal.NoSuchModelException if a user service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserServiceEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user service entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userServiceId the primary key of the user service entry
	 * @return the user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a user service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByPrimaryKey(long userServiceId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = fetchByPrimaryKey(userServiceId);

		if (userServiceEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userServiceId);
			}

			throw new NoSuchUserServiceEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userServiceId);
		}

		return userServiceEntry;
	}

	/**
	 * Returns the user service entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user service entry
	 * @return the user service entry, or <code>null</code> if a user service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserServiceEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user service entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userServiceId the primary key of the user service entry
	 * @return the user service entry, or <code>null</code> if a user service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByPrimaryKey(long userServiceId)
		throws SystemException {
		UserServiceEntry userServiceEntry = (UserServiceEntry)EntityCacheUtil.getResult(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
				UserServiceEntryImpl.class, userServiceId);

		if (userServiceEntry == _nullUserServiceEntry) {
			return null;
		}

		if (userServiceEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userServiceEntry = (UserServiceEntry)session.get(UserServiceEntryImpl.class,
						Long.valueOf(userServiceId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userServiceEntry != null) {
					cacheResult(userServiceEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
						UserServiceEntryImpl.class, userServiceId,
						_nullUserServiceEntry);
				}

				closeSession(session);
			}
		}

		return userServiceEntry;
	}

	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @return the matching user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByUserId_ServiceId(long userId, long serviceId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = fetchByUserId_ServiceId(userId,
				serviceId);

		if (userServiceEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", serviceId=");
			msg.append(serviceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserServiceEntryException(msg.toString());
		}

		return userServiceEntry;
	}

	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByUserId_ServiceId(long userId, long serviceId)
		throws SystemException {
		return fetchByUserId_ServiceId(userId, serviceId, true);
	}

	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByUserId_ServiceId(long userId,
		long serviceId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, serviceId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERSERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_SERVICEID_2);

			query.append(UserServiceEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(serviceId);

				List<UserServiceEntry> list = q.list();

				result = list;

				UserServiceEntry userServiceEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
						finderArgs, list);
				}
				else {
					userServiceEntry = list.get(0);

					cacheResult(userServiceEntry);

					if ((userServiceEntry.getUserId() != userId) ||
							(userServiceEntry.getServiceId() != serviceId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
							finderArgs, userServiceEntry);
					}
				}

				return userServiceEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID,
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
				return (UserServiceEntry)result;
			}
		}
	}

	/**
	 * Returns the user service entry where userId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @return the matching user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = fetchByUserId_ServicePackageId(userId,
				servicePackageId);

		if (userServiceEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", servicePackageId=");
			msg.append(servicePackageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserServiceEntryException(msg.toString());
		}

		return userServiceEntry;
	}

	/**
	 * Returns the user service entry where userId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByUserId_ServicePackageId(long userId,
		long servicePackageId) throws SystemException {
		return fetchByUserId_ServicePackageId(userId, servicePackageId, true);
	}

	/**
	 * Returns the user service entry where userId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByUserId_ServicePackageId(long userId,
		long servicePackageId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, servicePackageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERSERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_SERVICEPACKAGEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEPACKAGEID_SERVICEPACKAGEID_2);

			query.append(UserServiceEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(servicePackageId);

				List<UserServiceEntry> list = q.list();

				result = list;

				UserServiceEntry userServiceEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
						finderArgs, list);
				}
				else {
					userServiceEntry = list.get(0);

					cacheResult(userServiceEntry);

					if ((userServiceEntry.getUserId() != userId) ||
							(userServiceEntry.getServicePackageId() != servicePackageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
							finderArgs, userServiceEntry);
					}
				}

				return userServiceEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEPACKAGEID,
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
				return (UserServiceEntry)result;
			}
		}
	}

	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserServiceEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @return the matching user service entry
	 * @throws vn.com.fis.portal.NoSuchUserServiceEntryException if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry findByUserId_ServiceId_PackageId(long userId,
		long serviceId, long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = fetchByUserId_ServiceId_PackageId(userId,
				serviceId, servicePackageId);

		if (userServiceEntry == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", serviceId=");
			msg.append(serviceId);

			msg.append(", servicePackageId=");
			msg.append(servicePackageId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserServiceEntryException(msg.toString());
		}

		return userServiceEntry;
	}

	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByUserId_ServiceId_PackageId(long userId,
		long serviceId, long servicePackageId) throws SystemException {
		return fetchByUserId_ServiceId_PackageId(userId, serviceId,
			servicePackageId, true);
	}

	/**
	 * Returns the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user service entry, or <code>null</code> if a matching user service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserServiceEntry fetchByUserId_ServiceId_PackageId(long userId,
		long serviceId, long servicePackageId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, serviceId, servicePackageId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_USERSERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_SERVICEID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_SERVICEPACKAGEID_2);

			query.append(UserServiceEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(serviceId);

				qPos.add(servicePackageId);

				List<UserServiceEntry> list = q.list();

				result = list;

				UserServiceEntry userServiceEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
						finderArgs, list);
				}
				else {
					userServiceEntry = list.get(0);

					cacheResult(userServiceEntry);

					if ((userServiceEntry.getUserId() != userId) ||
							(userServiceEntry.getServiceId() != serviceId) ||
							(userServiceEntry.getServicePackageId() != servicePackageId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
							finderArgs, userServiceEntry);
					}
				}

				return userServiceEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID_SERVICEID_PACKAGEID,
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
				return (UserServiceEntry)result;
			}
		}
	}

	/**
	 * Returns all the user service entries.
	 *
	 * @return the user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserServiceEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user service entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user service entries
	 * @param end the upper bound of the range of user service entries (not inclusive)
	 * @return the range of user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserServiceEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user service entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user service entries
	 * @param end the upper bound of the range of user service entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserServiceEntry> findAll(int start, int end,
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

		List<UserServiceEntry> list = (List<UserServiceEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERSERVICEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERSERVICEENTRY.concat(UserServiceEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserServiceEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserServiceEntry>)QueryUtil.list(q,
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
	 * Removes the user service entry where userId = &#63; and serviceId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ServiceId(long userId, long serviceId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = findByUserId_ServiceId(userId,
				serviceId);

		remove(userServiceEntry);
	}

	/**
	 * Removes the user service entry where userId = &#63; and servicePackageId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ServicePackageId(long userId,
		long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = findByUserId_ServicePackageId(userId,
				servicePackageId);

		remove(userServiceEntry);
	}

	/**
	 * Removes the user service entry where userId = &#63; and serviceId = &#63; and servicePackageId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId)
		throws NoSuchUserServiceEntryException, SystemException {
		UserServiceEntry userServiceEntry = findByUserId_ServiceId_PackageId(userId,
				serviceId, servicePackageId);

		remove(userServiceEntry);
	}

	/**
	 * Removes all the user service entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserServiceEntry userServiceEntry : findAll()) {
			remove(userServiceEntry);
		}
	}

	/**
	 * Returns the number of user service entries where userId = &#63; and serviceId = &#63;.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @return the number of matching user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ServiceId(long userId, long serviceId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, serviceId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_SERVICEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_SERVICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(serviceId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_SERVICEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user service entries where userId = &#63; and servicePackageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param servicePackageId the service package ID
	 * @return the number of matching user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ServicePackageId(long userId, long servicePackageId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, servicePackageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_SERVICEPACKAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERSERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_SERVICEPACKAGEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEPACKAGEID_SERVICEPACKAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(servicePackageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_SERVICEPACKAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user service entries where userId = &#63; and serviceId = &#63; and servicePackageId = &#63;.
	 *
	 * @param userId the user ID
	 * @param serviceId the service ID
	 * @param servicePackageId the service package ID
	 * @return the number of matching user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_ServiceId_PackageId(long userId, long serviceId,
		long servicePackageId) throws SystemException {
		Object[] finderArgs = new Object[] { userId, serviceId, servicePackageId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_SERVICEID_PACKAGEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_USERSERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_SERVICEID_2);

			query.append(_FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_SERVICEPACKAGEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(serviceId);

				qPos.add(servicePackageId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_SERVICEID_PACKAGEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user service entries.
	 *
	 * @return the number of user service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERSERVICEENTRY);

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
	 * Initializes the user service entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.UserServiceEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserServiceEntry>> listenersList = new ArrayList<ModelListener<UserServiceEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserServiceEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserServiceEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_USERSERVICEENTRY = "SELECT userServiceEntry FROM UserServiceEntry userServiceEntry";
	private static final String _SQL_SELECT_USERSERVICEENTRY_WHERE = "SELECT userServiceEntry FROM UserServiceEntry userServiceEntry WHERE ";
	private static final String _SQL_COUNT_USERSERVICEENTRY = "SELECT COUNT(userServiceEntry) FROM UserServiceEntry userServiceEntry";
	private static final String _SQL_COUNT_USERSERVICEENTRY_WHERE = "SELECT COUNT(userServiceEntry) FROM UserServiceEntry userServiceEntry WHERE ";
	private static final String _FINDER_COLUMN_USERID_SERVICEID_USERID_2 = "userServiceEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_SERVICEID_SERVICEID_2 = "userServiceEntry.serviceId = ?";
	private static final String _FINDER_COLUMN_USERID_SERVICEPACKAGEID_USERID_2 = "userServiceEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_SERVICEPACKAGEID_SERVICEPACKAGEID_2 =
		"userServiceEntry.servicePackageId = ?";
	private static final String _FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_USERID_2 =
		"userServiceEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_SERVICEID_2 =
		"userServiceEntry.serviceId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_SERVICEID_PACKAGEID_SERVICEPACKAGEID_2 =
		"userServiceEntry.servicePackageId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userServiceEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserServiceEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserServiceEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserServiceEntryPersistenceImpl.class);
	private static UserServiceEntry _nullUserServiceEntry = new UserServiceEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserServiceEntry> toCacheModel() {
				return _nullUserServiceEntryCacheModel;
			}
		};

	private static CacheModel<UserServiceEntry> _nullUserServiceEntryCacheModel = new CacheModel<UserServiceEntry>() {
			public UserServiceEntry toEntityModel() {
				return _nullUserServiceEntry;
			}
		};
}