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

import vn.com.fis.portal.NoSuchUserEntryException;
import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.model.impl.UserEntryImpl;
import vn.com.fis.portal.model.impl.UserEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see UserEntryPersistence
 * @see UserEntryUtil
 * @generated
 */
public class UserEntryPersistenceImpl extends BasePersistenceImpl<UserEntry>
	implements UserEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserEntryUtil} to access the user entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USERNAME = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserName",
			new String[] { String.class.getName() },
			UserEntryModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERNAME = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_MOBILENUMBER = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByMobileNumber",
			new String[] { String.class.getName() },
			UserEntryModelImpl.MOBILENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MOBILENUMBER = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMobileNumber",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
			new String[] { Long.class.getName() },
			UserEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSTATUS =
		new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSTATUS =
		new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserStatus",
			new String[] { Integer.class.getName() },
			UserEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERSTATUS = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, UserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the user entry in the entity cache if it is enabled.
	 *
	 * @param userEntry the user entry
	 */
	public void cacheResult(UserEntry userEntry) {
		EntityCacheUtil.putResult(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryImpl.class, userEntry.getPrimaryKey(), userEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
			new Object[] { userEntry.getUserName() }, userEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
			new Object[] { userEntry.getMobileNumber() }, userEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(userEntry.getUserId()) }, userEntry);

		userEntry.resetOriginalValues();
	}

	/**
	 * Caches the user entries in the entity cache if it is enabled.
	 *
	 * @param userEntries the user entries
	 */
	public void cacheResult(List<UserEntry> userEntries) {
		for (UserEntry userEntry : userEntries) {
			if (EntityCacheUtil.getResult(
						UserEntryModelImpl.ENTITY_CACHE_ENABLED,
						UserEntryImpl.class, userEntry.getPrimaryKey()) == null) {
				cacheResult(userEntry);
			}
			else {
				userEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserEntry userEntry) {
		EntityCacheUtil.removeResult(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryImpl.class, userEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(userEntry);
	}

	@Override
	public void clearCache(List<UserEntry> userEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserEntry userEntry : userEntries) {
			EntityCacheUtil.removeResult(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
				UserEntryImpl.class, userEntry.getPrimaryKey());

			clearUniqueFindersCache(userEntry);
		}
	}

	protected void clearUniqueFindersCache(UserEntry userEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERNAME,
			new Object[] { userEntry.getUserName() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
			new Object[] { userEntry.getMobileNumber() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
			new Object[] { Long.valueOf(userEntry.getUserId()) });
	}

	/**
	 * Creates a new user entry with the primary key. Does not add the user entry to the database.
	 *
	 * @param userId the primary key for the new user entry
	 * @return the new user entry
	 */
	public UserEntry create(long userId) {
		UserEntry userEntry = new UserEntryImpl();

		userEntry.setNew(true);
		userEntry.setPrimaryKey(userId);

		return userEntry;
	}

	/**
	 * Removes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the user entry
	 * @return the user entry that was removed
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry remove(long userId)
		throws NoSuchUserEntryException, SystemException {
		return remove(Long.valueOf(userId));
	}

	/**
	 * Removes the user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user entry
	 * @return the user entry that was removed
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntry remove(Serializable primaryKey)
		throws NoSuchUserEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserEntry userEntry = (UserEntry)session.get(UserEntryImpl.class,
					primaryKey);

			if (userEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userEntry);
		}
		catch (NoSuchUserEntryException nsee) {
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
	protected UserEntry removeImpl(UserEntry userEntry)
		throws SystemException {
		userEntry = toUnwrappedModel(userEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, userEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(userEntry);

		return userEntry;
	}

	@Override
	public UserEntry updateImpl(vn.com.fis.portal.model.UserEntry userEntry,
		boolean merge) throws SystemException {
		userEntry = toUnwrappedModel(userEntry);

		boolean isNew = userEntry.isNew();

		UserEntryModelImpl userEntryModelImpl = (UserEntryModelImpl)userEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, userEntry, merge);

			userEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(userEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSTATUS,
					args);

				args = new Object[] {
						Integer.valueOf(userEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
			UserEntryImpl.class, userEntry.getPrimaryKey(), userEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
				new Object[] { userEntry.getUserName() }, userEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
				new Object[] { userEntry.getMobileNumber() }, userEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
				new Object[] { Long.valueOf(userEntry.getUserId()) }, userEntry);
		}
		else {
			if ((userEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userEntryModelImpl.getOriginalUserName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERNAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERNAME, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
					new Object[] { userEntry.getUserName() }, userEntry);
			}

			if ((userEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_MOBILENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userEntryModelImpl.getOriginalMobileNumber()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MOBILENUMBER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
					new Object[] { userEntry.getMobileNumber() }, userEntry);
			}

			if ((userEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(userEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
					new Object[] { Long.valueOf(userEntry.getUserId()) },
					userEntry);
			}
		}

		return userEntry;
	}

	protected UserEntry toUnwrappedModel(UserEntry userEntry) {
		if (userEntry instanceof UserEntryImpl) {
			return userEntry;
		}

		UserEntryImpl userEntryImpl = new UserEntryImpl();

		userEntryImpl.setNew(userEntry.isNew());
		userEntryImpl.setPrimaryKey(userEntry.getPrimaryKey());

		userEntryImpl.setUserId(userEntry.getUserId());
		userEntryImpl.setUserName(userEntry.getUserName());
		userEntryImpl.setMobileNumber(userEntry.getMobileNumber());
		userEntryImpl.setCompanyId(userEntry.getCompanyId());
		userEntryImpl.setCreateDate(userEntry.getCreateDate());
		userEntryImpl.setModifiedDate(userEntry.getModifiedDate());
		userEntryImpl.setStatus(userEntry.getStatus());

		return userEntryImpl;
	}

	/**
	 * Returns the user entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user entry
	 * @return the user entry
	 * @throws com.liferay.portal.NoSuchModelException if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param userId the primary key of the user entry
	 * @return the user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByPrimaryKey(long userId)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = fetchByPrimaryKey(userId);

		if (userEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userId);
			}

			throw new NoSuchUserEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userId);
		}

		return userEntry;
	}

	/**
	 * Returns the user entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user entry
	 * @return the user entry, or <code>null</code> if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the user entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the user entry
	 * @return the user entry, or <code>null</code> if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByPrimaryKey(long userId) throws SystemException {
		UserEntry userEntry = (UserEntry)EntityCacheUtil.getResult(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
				UserEntryImpl.class, userId);

		if (userEntry == _nullUserEntry) {
			return null;
		}

		if (userEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				userEntry = (UserEntry)session.get(UserEntryImpl.class,
						Long.valueOf(userId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (userEntry != null) {
					cacheResult(userEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UserEntryModelImpl.ENTITY_CACHE_ENABLED,
						UserEntryImpl.class, userId, _nullUserEntry);
				}

				closeSession(session);
			}
		}

		return userEntry;
	}

	/**
	 * Returns the user entry where userName = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param userName the user name
	 * @return the matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByUserName(String userName)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = fetchByUserName(userName);

		if (userEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userName=");
			msg.append(userName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserEntryException(msg.toString());
		}

		return userEntry;
	}

	/**
	 * Returns the user entry where userName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userName the user name
	 * @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByUserName(String userName) throws SystemException {
		return fetchByUserName(userName, true);
	}

	/**
	 * Returns the user entry where userName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userName the user name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByUserName(String userName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERNAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERENTRY_WHERE);

			if (userName == null) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
			}
			else {
				if (userName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
				}
			}

			query.append(UserEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (userName != null) {
					qPos.add(userName);
				}

				List<UserEntry> list = q.list();

				result = list;

				UserEntry userEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
						finderArgs, list);
				}
				else {
					userEntry = list.get(0);

					cacheResult(userEntry);

					if ((userEntry.getUserName() == null) ||
							!userEntry.getUserName().equals(userName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERNAME,
							finderArgs, userEntry);
					}
				}

				return userEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERNAME,
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
				return (UserEntry)result;
			}
		}
	}

	/**
	 * Returns the user entry where mobileNumber = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param mobileNumber the mobile number
	 * @return the matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByMobileNumber(String mobileNumber)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = fetchByMobileNumber(mobileNumber);

		if (userEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("mobileNumber=");
			msg.append(mobileNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserEntryException(msg.toString());
		}

		return userEntry;
	}

	/**
	 * Returns the user entry where mobileNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param mobileNumber the mobile number
	 * @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByMobileNumber(String mobileNumber)
		throws SystemException {
		return fetchByMobileNumber(mobileNumber, true);
	}

	/**
	 * Returns the user entry where mobileNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param mobileNumber the mobile number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByMobileNumber(String mobileNumber,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { mobileNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERENTRY_WHERE);

			if (mobileNumber == null) {
				query.append(_FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_1);
			}
			else {
				if (mobileNumber.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_3);
				}
				else {
					query.append(_FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_2);
				}
			}

			query.append(UserEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (mobileNumber != null) {
					qPos.add(mobileNumber);
				}

				List<UserEntry> list = q.list();

				result = list;

				UserEntry userEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
						finderArgs, list);
				}
				else {
					userEntry = list.get(0);

					cacheResult(userEntry);

					if ((userEntry.getMobileNumber() == null) ||
							!userEntry.getMobileNumber().equals(mobileNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
							finderArgs, userEntry);
					}
				}

				return userEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MOBILENUMBER,
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
				return (UserEntry)result;
			}
		}
	}

	/**
	 * Returns the user entry where userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchUserEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByUserId(long userId)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = fetchByUserId(userId);

		if (userEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUserEntryException(msg.toString());
		}

		return userEntry;
	}

	/**
	 * Returns the user entry where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByUserId(long userId) throws SystemException {
		return fetchByUserId(userId, true);
	}

	/**
	 * Returns the user entry where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching user entry, or <code>null</code> if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry fetchByUserId(long userId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_USERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(UserEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				List<UserEntry> list = q.list();

				result = list;

				UserEntry userEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
						finderArgs, list);
				}
				else {
					userEntry = list.get(0);

					cacheResult(userEntry);

					if ((userEntry.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
							finderArgs, userEntry);
					}
				}

				return userEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
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
				return (UserEntry)result;
			}
		}
	}

	/**
	 * Returns all the user entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEntry> findByUserStatus(int status)
		throws SystemException {
		return findByUserStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the user entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @return the range of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEntry> findByUserStatus(int status, int start, int end)
		throws SystemException {
		return findByUserStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEntry> findByUserStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERSTATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERSTATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<UserEntry> list = (List<UserEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_USERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(UserEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<UserEntry>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first user entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByUserStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntryException, SystemException {
		List<UserEntry> list = findByUserStatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last user entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a matching user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry findByUserStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntryException, SystemException {
		int count = countByUserStatus(status);

		List<UserEntry> list = findByUserStatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchUserEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the user entries before and after the current user entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the primary key of the current user entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user entry
	 * @throws vn.com.fis.portal.NoSuchUserEntryException if a user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public UserEntry[] findByUserStatus_PrevAndNext(long userId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = findByPrimaryKey(userId);

		Session session = null;

		try {
			session = openSession();

			UserEntry[] array = new UserEntryImpl[3];

			array[0] = getByUserStatus_PrevAndNext(session, userEntry, status,
					orderByComparator, true);

			array[1] = userEntry;

			array[2] = getByUserStatus_PrevAndNext(session, userEntry, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserEntry getByUserStatus_PrevAndNext(Session session,
		UserEntry userEntry, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERSTATUS_STATUS_2);

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
			query.append(UserEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the user entries.
	 *
	 * @return the user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @return the range of user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of user entries
	 * @param end the upper bound of the range of user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<UserEntry> findAll(int start, int end,
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

		List<UserEntry> list = (List<UserEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERENTRY.concat(UserEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<UserEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<UserEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes the user entry where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserName(String userName)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = findByUserName(userName);

		remove(userEntry);
	}

	/**
	 * Removes the user entry where mobileNumber = &#63; from the database.
	 *
	 * @param mobileNumber the mobile number
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByMobileNumber(String mobileNumber)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = findByMobileNumber(mobileNumber);

		remove(userEntry);
	}

	/**
	 * Removes the user entry where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId)
		throws NoSuchUserEntryException, SystemException {
		UserEntry userEntry = findByUserId(userId);

		remove(userEntry);
	}

	/**
	 * Removes all the user entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserStatus(int status) throws SystemException {
		for (UserEntry userEntry : findByUserStatus(status)) {
			remove(userEntry);
		}
	}

	/**
	 * Removes all the user entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (UserEntry userEntry : findAll()) {
			remove(userEntry);
		}
	}

	/**
	 * Returns the number of user entries where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserName(String userName) throws SystemException {
		Object[] finderArgs = new Object[] { userName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENTRY_WHERE);

			if (userName == null) {
				query.append(_FINDER_COLUMN_USERNAME_USERNAME_1);
			}
			else {
				if (userName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USERNAME_USERNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_USERNAME_USERNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (userName != null) {
					qPos.add(userName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user entries where mobileNumber = &#63;.
	 *
	 * @param mobileNumber the mobile number
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByMobileNumber(String mobileNumber)
		throws SystemException {
		Object[] finderArgs = new Object[] { mobileNumber };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MOBILENUMBER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENTRY_WHERE);

			if (mobileNumber == null) {
				query.append(_FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_1);
			}
			else {
				if (mobileNumber.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_3);
				}
				else {
					query.append(_FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MOBILENUMBER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENTRY_WHERE);

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
	 * Returns the number of user entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserStatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERSTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERSTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of user entries.
	 *
	 * @return the number of user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERENTRY);

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
	 * Initializes the user entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.UserEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserEntry>> listenersList = new ArrayList<ModelListener<UserEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_USERENTRY = "SELECT userEntry FROM UserEntry userEntry";
	private static final String _SQL_SELECT_USERENTRY_WHERE = "SELECT userEntry FROM UserEntry userEntry WHERE ";
	private static final String _SQL_COUNT_USERENTRY = "SELECT COUNT(userEntry) FROM UserEntry userEntry";
	private static final String _SQL_COUNT_USERENTRY_WHERE = "SELECT COUNT(userEntry) FROM UserEntry userEntry WHERE ";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_1 = "userEntry.userName IS NULL";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_2 = "userEntry.userName = ?";
	private static final String _FINDER_COLUMN_USERNAME_USERNAME_3 = "(userEntry.userName IS NULL OR userEntry.userName = ?)";
	private static final String _FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_1 = "userEntry.mobileNumber IS NULL";
	private static final String _FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_2 = "userEntry.mobileNumber = ?";
	private static final String _FINDER_COLUMN_MOBILENUMBER_MOBILENUMBER_3 = "(userEntry.mobileNumber IS NULL OR userEntry.mobileNumber = ?)";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "userEntry.userId = ?";
	private static final String _FINDER_COLUMN_USERSTATUS_STATUS_2 = "userEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserEntryPersistenceImpl.class);
	private static UserEntry _nullUserEntry = new UserEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserEntry> toCacheModel() {
				return _nullUserEntryCacheModel;
			}
		};

	private static CacheModel<UserEntry> _nullUserEntryCacheModel = new CacheModel<UserEntry>() {
			public UserEntry toEntityModel() {
				return _nullUserEntry;
			}
		};
}