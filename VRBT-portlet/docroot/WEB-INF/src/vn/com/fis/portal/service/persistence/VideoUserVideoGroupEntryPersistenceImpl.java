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

import vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException;
import vn.com.fis.portal.model.VideoUserVideoGroupEntry;
import vn.com.fis.portal.model.impl.VideoUserVideoGroupEntryImpl;
import vn.com.fis.portal.model.impl.VideoUserVideoGroupEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video user video group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserVideoGroupEntryPersistence
 * @see VideoUserVideoGroupEntryUtil
 * @generated
 */
public class VideoUserVideoGroupEntryPersistenceImpl extends BasePersistenceImpl<VideoUserVideoGroupEntry>
	implements VideoUserVideoGroupEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoUserVideoGroupEntryUtil} to access the video user video group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoUserVideoGroupEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP = new FinderPath(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserVideoGroupEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVideoUser_VideoGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoUserVideoGroupEntryModelImpl.VIDEOUSERID_COLUMN_BITMASK |
			VideoUserVideoGroupEntryModelImpl.VIDEOGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOUSER_VIDEOGROUP = new FinderPath(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVideoUser_VideoGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video user video group entry in the entity cache if it is enabled.
	 *
	 * @param videoUserVideoGroupEntry the video user video group entry
	 */
	public void cacheResult(VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		EntityCacheUtil.putResult(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryImpl.class,
			videoUserVideoGroupEntry.getPrimaryKey(), videoUserVideoGroupEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
			new Object[] {
				Long.valueOf(videoUserVideoGroupEntry.getVideoUserId()),
				Long.valueOf(videoUserVideoGroupEntry.getVideoGroupId())
			}, videoUserVideoGroupEntry);

		videoUserVideoGroupEntry.resetOriginalValues();
	}

	/**
	 * Caches the video user video group entries in the entity cache if it is enabled.
	 *
	 * @param videoUserVideoGroupEntries the video user video group entries
	 */
	public void cacheResult(
		List<VideoUserVideoGroupEntry> videoUserVideoGroupEntries) {
		for (VideoUserVideoGroupEntry videoUserVideoGroupEntry : videoUserVideoGroupEntries) {
			if (EntityCacheUtil.getResult(
						VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserVideoGroupEntryImpl.class,
						videoUserVideoGroupEntry.getPrimaryKey()) == null) {
				cacheResult(videoUserVideoGroupEntry);
			}
			else {
				videoUserVideoGroupEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video user video group entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoUserVideoGroupEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoUserVideoGroupEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video user video group entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		EntityCacheUtil.removeResult(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryImpl.class,
			videoUserVideoGroupEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(videoUserVideoGroupEntry);
	}

	@Override
	public void clearCache(
		List<VideoUserVideoGroupEntry> videoUserVideoGroupEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoUserVideoGroupEntry videoUserVideoGroupEntry : videoUserVideoGroupEntries) {
			EntityCacheUtil.removeResult(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserVideoGroupEntryImpl.class,
				videoUserVideoGroupEntry.getPrimaryKey());

			clearUniqueFindersCache(videoUserVideoGroupEntry);
		}
	}

	protected void clearUniqueFindersCache(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
			new Object[] {
				Long.valueOf(videoUserVideoGroupEntry.getVideoUserId()),
				Long.valueOf(videoUserVideoGroupEntry.getVideoGroupId())
			});
	}

	/**
	 * Creates a new video user video group entry with the primary key. Does not add the video user video group entry to the database.
	 *
	 * @param videoUserVideoGroupID the primary key for the new video user video group entry
	 * @return the new video user video group entry
	 */
	public VideoUserVideoGroupEntry create(long videoUserVideoGroupID) {
		VideoUserVideoGroupEntry videoUserVideoGroupEntry = new VideoUserVideoGroupEntryImpl();

		videoUserVideoGroupEntry.setNew(true);
		videoUserVideoGroupEntry.setPrimaryKey(videoUserVideoGroupID);

		return videoUserVideoGroupEntry;
	}

	/**
	 * Removes the video user video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoUserVideoGroupID the primary key of the video user video group entry
	 * @return the video user video group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry remove(long videoUserVideoGroupID)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		return remove(Long.valueOf(videoUserVideoGroupID));
	}

	/**
	 * Removes the video user video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video user video group entry
	 * @return the video user video group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserVideoGroupEntry remove(Serializable primaryKey)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoUserVideoGroupEntry videoUserVideoGroupEntry = (VideoUserVideoGroupEntry)session.get(VideoUserVideoGroupEntryImpl.class,
					primaryKey);

			if (videoUserVideoGroupEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoUserVideoGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoUserVideoGroupEntry);
		}
		catch (NoSuchVideoUserVideoGroupEntryException nsee) {
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
	protected VideoUserVideoGroupEntry removeImpl(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry)
		throws SystemException {
		videoUserVideoGroupEntry = toUnwrappedModel(videoUserVideoGroupEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoUserVideoGroupEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoUserVideoGroupEntry);

		return videoUserVideoGroupEntry;
	}

	@Override
	public VideoUserVideoGroupEntry updateImpl(
		vn.com.fis.portal.model.VideoUserVideoGroupEntry videoUserVideoGroupEntry,
		boolean merge) throws SystemException {
		videoUserVideoGroupEntry = toUnwrappedModel(videoUserVideoGroupEntry);

		boolean isNew = videoUserVideoGroupEntry.isNew();

		VideoUserVideoGroupEntryModelImpl videoUserVideoGroupEntryModelImpl = (VideoUserVideoGroupEntryModelImpl)videoUserVideoGroupEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoUserVideoGroupEntry, merge);

			videoUserVideoGroupEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoUserVideoGroupEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserVideoGroupEntryImpl.class,
			videoUserVideoGroupEntry.getPrimaryKey(), videoUserVideoGroupEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
				new Object[] {
					Long.valueOf(videoUserVideoGroupEntry.getVideoUserId()),
					Long.valueOf(videoUserVideoGroupEntry.getVideoGroupId())
				}, videoUserVideoGroupEntry);
		}
		else {
			if ((videoUserVideoGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserVideoGroupEntryModelImpl.getOriginalVideoUserId()),
						Long.valueOf(videoUserVideoGroupEntryModelImpl.getOriginalVideoGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOUSER_VIDEOGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
					new Object[] {
						Long.valueOf(videoUserVideoGroupEntry.getVideoUserId()),
						Long.valueOf(videoUserVideoGroupEntry.getVideoGroupId())
					}, videoUserVideoGroupEntry);
			}
		}

		return videoUserVideoGroupEntry;
	}

	protected VideoUserVideoGroupEntry toUnwrappedModel(
		VideoUserVideoGroupEntry videoUserVideoGroupEntry) {
		if (videoUserVideoGroupEntry instanceof VideoUserVideoGroupEntryImpl) {
			return videoUserVideoGroupEntry;
		}

		VideoUserVideoGroupEntryImpl videoUserVideoGroupEntryImpl = new VideoUserVideoGroupEntryImpl();

		videoUserVideoGroupEntryImpl.setNew(videoUserVideoGroupEntry.isNew());
		videoUserVideoGroupEntryImpl.setPrimaryKey(videoUserVideoGroupEntry.getPrimaryKey());

		videoUserVideoGroupEntryImpl.setVideoUserVideoGroupID(videoUserVideoGroupEntry.getVideoUserVideoGroupID());
		videoUserVideoGroupEntryImpl.setVideoUserId(videoUserVideoGroupEntry.getVideoUserId());
		videoUserVideoGroupEntryImpl.setVideoGroupId(videoUserVideoGroupEntry.getVideoGroupId());

		return videoUserVideoGroupEntryImpl;
	}

	/**
	 * Returns the video user video group entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user video group entry
	 * @return the video user video group entry
	 * @throws com.liferay.portal.NoSuchModelException if a video user video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserVideoGroupEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	 *
	 * @param videoUserVideoGroupID the primary key of the video user video group entry
	 * @return the video user video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a video user video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry findByPrimaryKey(long videoUserVideoGroupID)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		VideoUserVideoGroupEntry videoUserVideoGroupEntry = fetchByPrimaryKey(videoUserVideoGroupID);

		if (videoUserVideoGroupEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					videoUserVideoGroupID);
			}

			throw new NoSuchVideoUserVideoGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoUserVideoGroupID);
		}

		return videoUserVideoGroupEntry;
	}

	/**
	 * Returns the video user video group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user video group entry
	 * @return the video user video group entry, or <code>null</code> if a video user video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserVideoGroupEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user video group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoUserVideoGroupID the primary key of the video user video group entry
	 * @return the video user video group entry, or <code>null</code> if a video user video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry fetchByPrimaryKey(
		long videoUserVideoGroupID) throws SystemException {
		VideoUserVideoGroupEntry videoUserVideoGroupEntry = (VideoUserVideoGroupEntry)EntityCacheUtil.getResult(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserVideoGroupEntryImpl.class, videoUserVideoGroupID);

		if (videoUserVideoGroupEntry == _nullVideoUserVideoGroupEntry) {
			return null;
		}

		if (videoUserVideoGroupEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoUserVideoGroupEntry = (VideoUserVideoGroupEntry)session.get(VideoUserVideoGroupEntryImpl.class,
						Long.valueOf(videoUserVideoGroupID));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoUserVideoGroupEntry != null) {
					cacheResult(videoUserVideoGroupEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoUserVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserVideoGroupEntryImpl.class,
						videoUserVideoGroupID, _nullVideoUserVideoGroupEntry);
				}

				closeSession(session);
			}
		}

		return videoUserVideoGroupEntry;
	}

	/**
	 * Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException} if it could not be found.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @return the matching video user video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserVideoGroupEntryException if a matching video user video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry findByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		VideoUserVideoGroupEntry videoUserVideoGroupEntry = fetchByVideoUser_VideoGroup(videoUserId,
				videoGroupId);

		if (videoUserVideoGroupEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoUserId=");
			msg.append(videoUserId);

			msg.append(", videoGroupId=");
			msg.append(videoGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVideoUserVideoGroupEntryException(msg.toString());
		}

		return videoUserVideoGroupEntry;
	}

	/**
	 * Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @return the matching video user video group entry, or <code>null</code> if a matching video user video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry fetchByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId) throws SystemException {
		return fetchByVideoUser_VideoGroup(videoUserId, videoGroupId, true);
	}

	/**
	 * Returns the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching video user video group entry, or <code>null</code> if a matching video user video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserVideoGroupEntry fetchByVideoUser_VideoGroup(
		long videoUserId, long videoGroupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoUserId, videoGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VIDEOUSERVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOUSER_VIDEOGROUP_VIDEOUSERID_2);

			query.append(_FINDER_COLUMN_VIDEOUSER_VIDEOGROUP_VIDEOGROUPID_2);

			query.append(VideoUserVideoGroupEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoUserId);

				qPos.add(videoGroupId);

				List<VideoUserVideoGroupEntry> list = q.list();

				result = list;

				VideoUserVideoGroupEntry videoUserVideoGroupEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
						finderArgs, list);
				}
				else {
					videoUserVideoGroupEntry = list.get(0);

					cacheResult(videoUserVideoGroupEntry);

					if ((videoUserVideoGroupEntry.getVideoUserId() != videoUserId) ||
							(videoUserVideoGroupEntry.getVideoGroupId() != videoGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
							finderArgs, videoUserVideoGroupEntry);
					}
				}

				return videoUserVideoGroupEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEOUSER_VIDEOGROUP,
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
				return (VideoUserVideoGroupEntry)result;
			}
		}
	}

	/**
	 * Returns all the video user video group entries.
	 *
	 * @return the video user video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserVideoGroupEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user video group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user video group entries
	 * @param end the upper bound of the range of video user video group entries (not inclusive)
	 * @return the range of video user video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserVideoGroupEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user video group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user video group entries
	 * @param end the upper bound of the range of video user video group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video user video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserVideoGroupEntry> findAll(int start, int end,
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

		List<VideoUserVideoGroupEntry> list = (List<VideoUserVideoGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOUSERVIDEOGROUPENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOUSERVIDEOGROUPENTRY.concat(VideoUserVideoGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoUserVideoGroupEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoUserVideoGroupEntry>)QueryUtil.list(q,
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
	 * Removes the video user video group entry where videoUserId = &#63; and videoGroupId = &#63; from the database.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoUser_VideoGroup(long videoUserId, long videoGroupId)
		throws NoSuchVideoUserVideoGroupEntryException, SystemException {
		VideoUserVideoGroupEntry videoUserVideoGroupEntry = findByVideoUser_VideoGroup(videoUserId,
				videoGroupId);

		remove(videoUserVideoGroupEntry);
	}

	/**
	 * Removes all the video user video group entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoUserVideoGroupEntry videoUserVideoGroupEntry : findAll()) {
			remove(videoUserVideoGroupEntry);
		}
	}

	/**
	 * Returns the number of video user video group entries where videoUserId = &#63; and videoGroupId = &#63;.
	 *
	 * @param videoUserId the video user ID
	 * @param videoGroupId the video group ID
	 * @return the number of matching video user video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoUser_VideoGroup(long videoUserId, long videoGroupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoUserId, videoGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOUSER_VIDEOGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOUSERVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOUSER_VIDEOGROUP_VIDEOUSERID_2);

			query.append(_FINDER_COLUMN_VIDEOUSER_VIDEOGROUP_VIDEOGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoUserId);

				qPos.add(videoGroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEOUSER_VIDEOGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user video group entries.
	 *
	 * @return the number of video user video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOUSERVIDEOGROUPENTRY);

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
	 * Initializes the video user video group entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.VideoUserVideoGroupEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoUserVideoGroupEntry>> listenersList = new ArrayList<ModelListener<VideoUserVideoGroupEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoUserVideoGroupEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoUserVideoGroupEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOUSERVIDEOGROUPENTRY = "SELECT videoUserVideoGroupEntry FROM VideoUserVideoGroupEntry videoUserVideoGroupEntry";
	private static final String _SQL_SELECT_VIDEOUSERVIDEOGROUPENTRY_WHERE = "SELECT videoUserVideoGroupEntry FROM VideoUserVideoGroupEntry videoUserVideoGroupEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOUSERVIDEOGROUPENTRY = "SELECT COUNT(videoUserVideoGroupEntry) FROM VideoUserVideoGroupEntry videoUserVideoGroupEntry";
	private static final String _SQL_COUNT_VIDEOUSERVIDEOGROUPENTRY_WHERE = "SELECT COUNT(videoUserVideoGroupEntry) FROM VideoUserVideoGroupEntry videoUserVideoGroupEntry WHERE ";
	private static final String _FINDER_COLUMN_VIDEOUSER_VIDEOGROUP_VIDEOUSERID_2 =
		"videoUserVideoGroupEntry.videoUserId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOUSER_VIDEOGROUP_VIDEOGROUPID_2 =
		"videoUserVideoGroupEntry.videoGroupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoUserVideoGroupEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoUserVideoGroupEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoUserVideoGroupEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoUserVideoGroupEntryPersistenceImpl.class);
	private static VideoUserVideoGroupEntry _nullVideoUserVideoGroupEntry = new VideoUserVideoGroupEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoUserVideoGroupEntry> toCacheModel() {
				return _nullVideoUserVideoGroupEntryCacheModel;
			}
		};

	private static CacheModel<VideoUserVideoGroupEntry> _nullVideoUserVideoGroupEntryCacheModel =
		new CacheModel<VideoUserVideoGroupEntry>() {
			public VideoUserVideoGroupEntry toEntityModel() {
				return _nullVideoUserVideoGroupEntry;
			}
		};
}