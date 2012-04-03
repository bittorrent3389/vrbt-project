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

import vn.com.fis.portal.NoSuchViolationVideoEntryException;
import vn.com.fis.portal.model.ViolationVideoEntry;
import vn.com.fis.portal.model.impl.ViolationVideoEntryImpl;
import vn.com.fis.portal.model.impl.ViolationVideoEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the violation video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ViolationVideoEntryPersistence
 * @see ViolationVideoEntryUtil
 * @generated
 */
public class ViolationVideoEntryPersistenceImpl extends BasePersistenceImpl<ViolationVideoEntry>
	implements ViolationVideoEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ViolationVideoEntryUtil} to access the violation video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ViolationVideoEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID_USERID =
		new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoId_UserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_USERID =
		new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoId_UserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ViolationVideoEntryModelImpl.VIDEOID_COLUMN_BITMASK |
			ViolationVideoEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOID_USERID = new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoId_UserId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION = new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationVideoEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVideo_User_Violation",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ViolationVideoEntryModelImpl.VIDEOID_COLUMN_BITMASK |
			ViolationVideoEntryModelImpl.USERID_COLUMN_BITMASK |
			ViolationVideoEntryModelImpl.VIOLATIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO_USER_VIOLATION = new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVideo_User_Violation",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the violation video entry in the entity cache if it is enabled.
	 *
	 * @param violationVideoEntry the violation video entry
	 */
	public void cacheResult(ViolationVideoEntry violationVideoEntry) {
		EntityCacheUtil.putResult(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryImpl.class, violationVideoEntry.getPrimaryKey(),
			violationVideoEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
			new Object[] {
				Long.valueOf(violationVideoEntry.getVideoId()),
				Long.valueOf(violationVideoEntry.getUserId()),
				Long.valueOf(violationVideoEntry.getViolationId())
			}, violationVideoEntry);

		violationVideoEntry.resetOriginalValues();
	}

	/**
	 * Caches the violation video entries in the entity cache if it is enabled.
	 *
	 * @param violationVideoEntries the violation video entries
	 */
	public void cacheResult(List<ViolationVideoEntry> violationVideoEntries) {
		for (ViolationVideoEntry violationVideoEntry : violationVideoEntries) {
			if (EntityCacheUtil.getResult(
						ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						ViolationVideoEntryImpl.class,
						violationVideoEntry.getPrimaryKey()) == null) {
				cacheResult(violationVideoEntry);
			}
			else {
				violationVideoEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all violation video entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ViolationVideoEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ViolationVideoEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the violation video entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ViolationVideoEntry violationVideoEntry) {
		EntityCacheUtil.removeResult(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryImpl.class, violationVideoEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(violationVideoEntry);
	}

	@Override
	public void clearCache(List<ViolationVideoEntry> violationVideoEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ViolationVideoEntry violationVideoEntry : violationVideoEntries) {
			EntityCacheUtil.removeResult(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				ViolationVideoEntryImpl.class,
				violationVideoEntry.getPrimaryKey());

			clearUniqueFindersCache(violationVideoEntry);
		}
	}

	protected void clearUniqueFindersCache(
		ViolationVideoEntry violationVideoEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
			new Object[] {
				Long.valueOf(violationVideoEntry.getVideoId()),
				Long.valueOf(violationVideoEntry.getUserId()),
				Long.valueOf(violationVideoEntry.getViolationId())
			});
	}

	/**
	 * Creates a new violation video entry with the primary key. Does not add the violation video entry to the database.
	 *
	 * @param violationVideoId the primary key for the new violation video entry
	 * @return the new violation video entry
	 */
	public ViolationVideoEntry create(long violationVideoId) {
		ViolationVideoEntry violationVideoEntry = new ViolationVideoEntryImpl();

		violationVideoEntry.setNew(true);
		violationVideoEntry.setPrimaryKey(violationVideoId);

		return violationVideoEntry;
	}

	/**
	 * Removes the violation video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param violationVideoId the primary key of the violation video entry
	 * @return the violation video entry that was removed
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry remove(long violationVideoId)
		throws NoSuchViolationVideoEntryException, SystemException {
		return remove(Long.valueOf(violationVideoId));
	}

	/**
	 * Removes the violation video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the violation video entry
	 * @return the violation video entry that was removed
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViolationVideoEntry remove(Serializable primaryKey)
		throws NoSuchViolationVideoEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViolationVideoEntry violationVideoEntry = (ViolationVideoEntry)session.get(ViolationVideoEntryImpl.class,
					primaryKey);

			if (violationVideoEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchViolationVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(violationVideoEntry);
		}
		catch (NoSuchViolationVideoEntryException nsee) {
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
	protected ViolationVideoEntry removeImpl(
		ViolationVideoEntry violationVideoEntry) throws SystemException {
		violationVideoEntry = toUnwrappedModel(violationVideoEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, violationVideoEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(violationVideoEntry);

		return violationVideoEntry;
	}

	@Override
	public ViolationVideoEntry updateImpl(
		vn.com.fis.portal.model.ViolationVideoEntry violationVideoEntry,
		boolean merge) throws SystemException {
		violationVideoEntry = toUnwrappedModel(violationVideoEntry);

		boolean isNew = violationVideoEntry.isNew();

		ViolationVideoEntryModelImpl violationVideoEntryModelImpl = (ViolationVideoEntryModelImpl)violationVideoEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, violationVideoEntry, merge);

			violationVideoEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ViolationVideoEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((violationVideoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(violationVideoEntryModelImpl.getOriginalVideoId()),
						Long.valueOf(violationVideoEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_USERID,
					args);

				args = new Object[] {
						Long.valueOf(violationVideoEntryModelImpl.getVideoId()),
						Long.valueOf(violationVideoEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationVideoEntryImpl.class, violationVideoEntry.getPrimaryKey(),
			violationVideoEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
				new Object[] {
					Long.valueOf(violationVideoEntry.getVideoId()),
					Long.valueOf(violationVideoEntry.getUserId()),
					Long.valueOf(violationVideoEntry.getViolationId())
				}, violationVideoEntry);
		}
		else {
			if ((violationVideoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(violationVideoEntryModelImpl.getOriginalVideoId()),
						Long.valueOf(violationVideoEntryModelImpl.getOriginalUserId()),
						Long.valueOf(violationVideoEntryModelImpl.getOriginalViolationId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEO_USER_VIOLATION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
					new Object[] {
						Long.valueOf(violationVideoEntry.getVideoId()),
						Long.valueOf(violationVideoEntry.getUserId()),
						Long.valueOf(violationVideoEntry.getViolationId())
					}, violationVideoEntry);
			}
		}

		return violationVideoEntry;
	}

	protected ViolationVideoEntry toUnwrappedModel(
		ViolationVideoEntry violationVideoEntry) {
		if (violationVideoEntry instanceof ViolationVideoEntryImpl) {
			return violationVideoEntry;
		}

		ViolationVideoEntryImpl violationVideoEntryImpl = new ViolationVideoEntryImpl();

		violationVideoEntryImpl.setNew(violationVideoEntry.isNew());
		violationVideoEntryImpl.setPrimaryKey(violationVideoEntry.getPrimaryKey());

		violationVideoEntryImpl.setViolationVideoId(violationVideoEntry.getViolationVideoId());
		violationVideoEntryImpl.setViolationId(violationVideoEntry.getViolationId());
		violationVideoEntryImpl.setVideoId(violationVideoEntry.getVideoId());
		violationVideoEntryImpl.setUserId(violationVideoEntry.getUserId());
		violationVideoEntryImpl.setDate_(violationVideoEntry.getDate_());
		violationVideoEntryImpl.setDescription(violationVideoEntry.getDescription());

		return violationVideoEntryImpl;
	}

	/**
	 * Returns the violation video entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the violation video entry
	 * @return the violation video entry
	 * @throws com.liferay.portal.NoSuchModelException if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViolationVideoEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the violation video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchViolationVideoEntryException} if it could not be found.
	 *
	 * @param violationVideoId the primary key of the violation video entry
	 * @return the violation video entry
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry findByPrimaryKey(long violationVideoId)
		throws NoSuchViolationVideoEntryException, SystemException {
		ViolationVideoEntry violationVideoEntry = fetchByPrimaryKey(violationVideoId);

		if (violationVideoEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + violationVideoId);
			}

			throw new NoSuchViolationVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				violationVideoId);
		}

		return violationVideoEntry;
	}

	/**
	 * Returns the violation video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the violation video entry
	 * @return the violation video entry, or <code>null</code> if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViolationVideoEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the violation video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param violationVideoId the primary key of the violation video entry
	 * @return the violation video entry, or <code>null</code> if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry fetchByPrimaryKey(long violationVideoId)
		throws SystemException {
		ViolationVideoEntry violationVideoEntry = (ViolationVideoEntry)EntityCacheUtil.getResult(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				ViolationVideoEntryImpl.class, violationVideoId);

		if (violationVideoEntry == _nullViolationVideoEntry) {
			return null;
		}

		if (violationVideoEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				violationVideoEntry = (ViolationVideoEntry)session.get(ViolationVideoEntryImpl.class,
						Long.valueOf(violationVideoId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (violationVideoEntry != null) {
					cacheResult(violationVideoEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ViolationVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						ViolationVideoEntryImpl.class, violationVideoId,
						_nullViolationVideoEntry);
				}

				closeSession(session);
			}
		}

		return violationVideoEntry;
	}

	/**
	 * Returns all the violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findByVideoId_UserId(long videoId,
		long userId) throws SystemException {
		return findByVideoId_UserId(videoId, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of violation video entries
	 * @param end the upper bound of the range of violation video entries (not inclusive)
	 * @return the range of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findByVideoId_UserId(long videoId,
		long userId, int start, int end) throws SystemException {
		return findByVideoId_UserId(videoId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of violation video entries
	 * @param end the upper bound of the range of violation video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findByVideoId_UserId(long videoId,
		long userId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_USERID;
			finderArgs = new Object[] { videoId, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID_USERID;
			finderArgs = new Object[] {
					videoId, userId,
					
					start, end, orderByComparator
				};
		}

		List<ViolationVideoEntry> list = (List<ViolationVideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIOLATIONVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_USERID_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOID_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ViolationVideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(userId);

				list = (List<ViolationVideoEntry>)QueryUtil.list(q,
						getDialect(), start, end);
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
	 * Returns the first violation video entry in the ordered set where videoId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation video entry
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry findByVideoId_UserId_First(long videoId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchViolationVideoEntryException, SystemException {
		List<ViolationVideoEntry> list = findByVideoId_UserId(videoId, userId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViolationVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last violation video entry in the ordered set where videoId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation video entry
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry findByVideoId_UserId_Last(long videoId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchViolationVideoEntryException, SystemException {
		int count = countByVideoId_UserId(videoId, userId);

		List<ViolationVideoEntry> list = findByVideoId_UserId(videoId, userId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViolationVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the violation video entries before and after the current violation video entry in the ordered set where videoId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationVideoId the primary key of the current violation video entry
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation video entry
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a violation video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry[] findByVideoId_UserId_PrevAndNext(
		long violationVideoId, long videoId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchViolationVideoEntryException, SystemException {
		ViolationVideoEntry violationVideoEntry = findByPrimaryKey(violationVideoId);

		Session session = null;

		try {
			session = openSession();

			ViolationVideoEntry[] array = new ViolationVideoEntryImpl[3];

			array[0] = getByVideoId_UserId_PrevAndNext(session,
					violationVideoEntry, videoId, userId, orderByComparator,
					true);

			array[1] = violationVideoEntry;

			array[2] = getByVideoId_UserId_PrevAndNext(session,
					violationVideoEntry, videoId, userId, orderByComparator,
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

	protected ViolationVideoEntry getByVideoId_UserId_PrevAndNext(
		Session session, ViolationVideoEntry violationVideoEntry, long videoId,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIOLATIONVIDEOENTRY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOID_USERID_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOID_USERID_USERID_2);

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
			query.append(ViolationVideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(violationVideoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ViolationVideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or throws a {@link vn.com.fis.portal.NoSuchViolationVideoEntryException} if it could not be found.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @return the matching violation video entry
	 * @throws vn.com.fis.portal.NoSuchViolationVideoEntryException if a matching violation video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry findByVideo_User_Violation(long videoId,
		long userId, long violationId)
		throws NoSuchViolationVideoEntryException, SystemException {
		ViolationVideoEntry violationVideoEntry = fetchByVideo_User_Violation(videoId,
				userId, violationId);

		if (violationVideoEntry == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", violationId=");
			msg.append(violationId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchViolationVideoEntryException(msg.toString());
		}

		return violationVideoEntry;
	}

	/**
	 * Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @return the matching violation video entry, or <code>null</code> if a matching violation video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry fetchByVideo_User_Violation(long videoId,
		long userId, long violationId) throws SystemException {
		return fetchByVideo_User_Violation(videoId, userId, violationId, true);
	}

	/**
	 * Returns the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching violation video entry, or <code>null</code> if a matching violation video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationVideoEntry fetchByVideo_User_Violation(long videoId,
		long userId, long violationId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoId, userId, violationId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_VIOLATIONVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_USER_VIOLATION_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEO_USER_VIOLATION_USERID_2);

			query.append(_FINDER_COLUMN_VIDEO_USER_VIOLATION_VIOLATIONID_2);

			query.append(ViolationVideoEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(userId);

				qPos.add(violationId);

				List<ViolationVideoEntry> list = q.list();

				result = list;

				ViolationVideoEntry violationVideoEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
						finderArgs, list);
				}
				else {
					violationVideoEntry = list.get(0);

					cacheResult(violationVideoEntry);

					if ((violationVideoEntry.getVideoId() != videoId) ||
							(violationVideoEntry.getUserId() != userId) ||
							(violationVideoEntry.getViolationId() != violationId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
							finderArgs, violationVideoEntry);
					}
				}

				return violationVideoEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEO_USER_VIOLATION,
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
				return (ViolationVideoEntry)result;
			}
		}
	}

	/**
	 * Returns all the violation video entries.
	 *
	 * @return the violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation video entries
	 * @param end the upper bound of the range of violation video entries (not inclusive)
	 * @return the range of violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation video entries
	 * @param end the upper bound of the range of violation video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationVideoEntry> findAll(int start, int end,
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

		List<ViolationVideoEntry> list = (List<ViolationVideoEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIOLATIONVIDEOENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIOLATIONVIDEOENTRY.concat(ViolationVideoEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ViolationVideoEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViolationVideoEntry>)QueryUtil.list(q,
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
	 * Removes all the violation video entries where videoId = &#63; and userId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId_UserId(long videoId, long userId)
		throws SystemException {
		for (ViolationVideoEntry violationVideoEntry : findByVideoId_UserId(
				videoId, userId)) {
			remove(violationVideoEntry);
		}
	}

	/**
	 * Removes the violation video entry where videoId = &#63; and userId = &#63; and violationId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideo_User_Violation(long videoId, long userId,
		long violationId)
		throws NoSuchViolationVideoEntryException, SystemException {
		ViolationVideoEntry violationVideoEntry = findByVideo_User_Violation(videoId,
				userId, violationId);

		remove(violationVideoEntry);
	}

	/**
	 * Removes all the violation video entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ViolationVideoEntry violationVideoEntry : findAll()) {
			remove(violationVideoEntry);
		}
	}

	/**
	 * Returns the number of violation video entries where videoId = &#63; and userId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the number of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId_UserId(long videoId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOID_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIOLATIONVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_USERID_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOID_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEOID_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of violation video entries where videoId = &#63; and userId = &#63; and violationId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param violationId the violation ID
	 * @return the number of matching violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideo_User_Violation(long videoId, long userId,
		long violationId) throws SystemException {
		Object[] finderArgs = new Object[] { videoId, userId, violationId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEO_USER_VIOLATION,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VIOLATIONVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_USER_VIOLATION_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEO_USER_VIOLATION_USERID_2);

			query.append(_FINDER_COLUMN_VIDEO_USER_VIOLATION_VIOLATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(userId);

				qPos.add(violationId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEO_USER_VIOLATION,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of violation video entries.
	 *
	 * @return the number of violation video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIOLATIONVIDEOENTRY);

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
	 * Initializes the violation video entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ViolationVideoEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViolationVideoEntry>> listenersList = new ArrayList<ModelListener<ViolationVideoEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViolationVideoEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ViolationVideoEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIOLATIONVIDEOENTRY = "SELECT violationVideoEntry FROM ViolationVideoEntry violationVideoEntry";
	private static final String _SQL_SELECT_VIOLATIONVIDEOENTRY_WHERE = "SELECT violationVideoEntry FROM ViolationVideoEntry violationVideoEntry WHERE ";
	private static final String _SQL_COUNT_VIOLATIONVIDEOENTRY = "SELECT COUNT(violationVideoEntry) FROM ViolationVideoEntry violationVideoEntry";
	private static final String _SQL_COUNT_VIOLATIONVIDEOENTRY_WHERE = "SELECT COUNT(violationVideoEntry) FROM ViolationVideoEntry violationVideoEntry WHERE ";
	private static final String _FINDER_COLUMN_VIDEOID_USERID_VIDEOID_2 = "violationVideoEntry.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOID_USERID_USERID_2 = "violationVideoEntry.userId = ?";
	private static final String _FINDER_COLUMN_VIDEO_USER_VIOLATION_VIDEOID_2 = "violationVideoEntry.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEO_USER_VIOLATION_USERID_2 = "violationVideoEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEO_USER_VIOLATION_VIOLATIONID_2 =
		"violationVideoEntry.violationId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "violationVideoEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ViolationVideoEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ViolationVideoEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ViolationVideoEntryPersistenceImpl.class);
	private static ViolationVideoEntry _nullViolationVideoEntry = new ViolationVideoEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ViolationVideoEntry> toCacheModel() {
				return _nullViolationVideoEntryCacheModel;
			}
		};

	private static CacheModel<ViolationVideoEntry> _nullViolationVideoEntryCacheModel =
		new CacheModel<ViolationVideoEntry>() {
			public ViolationVideoEntry toEntityModel() {
				return _nullViolationVideoEntry;
			}
		};
}