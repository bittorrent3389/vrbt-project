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

import vn.com.fis.portal.NoSuchVideoUserEntryException;
import vn.com.fis.portal.model.VideoUserEntry;
import vn.com.fis.portal.model.impl.VideoUserEntryImpl;
import vn.com.fis.portal.model.impl.VideoUserEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video user entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserEntryPersistence
 * @see VideoUserEntryUtil
 * @generated
 */
public class VideoUserEntryPersistenceImpl extends BasePersistenceImpl<VideoUserEntry>
	implements VideoUserEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoUserEntryUtil} to access the video user entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoUserEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_VIDEOID =
		new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId_VideoId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID =
		new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId_VideoId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoUserEntryModelImpl.USERID_COLUMN_BITMASK |
			VideoUserEntryModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_VIDEOID = new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId_VideoId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS =
		new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId_VideoId_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS =
		new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId_VideoId_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			VideoUserEntryModelImpl.USERID_COLUMN_BITMASK |
			VideoUserEntryModelImpl.VIDEOID_COLUMN_BITMASK |
			VideoUserEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_VIDEOID_STATUS = new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_VideoId_Status",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video user entry in the entity cache if it is enabled.
	 *
	 * @param videoUserEntry the video user entry
	 */
	public void cacheResult(VideoUserEntry videoUserEntry) {
		EntityCacheUtil.putResult(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryImpl.class, videoUserEntry.getPrimaryKey(),
			videoUserEntry);

		videoUserEntry.resetOriginalValues();
	}

	/**
	 * Caches the video user entries in the entity cache if it is enabled.
	 *
	 * @param videoUserEntries the video user entries
	 */
	public void cacheResult(List<VideoUserEntry> videoUserEntries) {
		for (VideoUserEntry videoUserEntry : videoUserEntries) {
			if (EntityCacheUtil.getResult(
						VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserEntryImpl.class, videoUserEntry.getPrimaryKey()) == null) {
				cacheResult(videoUserEntry);
			}
			else {
				videoUserEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video user entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoUserEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoUserEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video user entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoUserEntry videoUserEntry) {
		EntityCacheUtil.removeResult(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryImpl.class, videoUserEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoUserEntry> videoUserEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoUserEntry videoUserEntry : videoUserEntries) {
			EntityCacheUtil.removeResult(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserEntryImpl.class, videoUserEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video user entry with the primary key. Does not add the video user entry to the database.
	 *
	 * @param videoUserId the primary key for the new video user entry
	 * @return the new video user entry
	 */
	public VideoUserEntry create(long videoUserId) {
		VideoUserEntry videoUserEntry = new VideoUserEntryImpl();

		videoUserEntry.setNew(true);
		videoUserEntry.setPrimaryKey(videoUserId);

		return videoUserEntry;
	}

	/**
	 * Removes the video user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoUserId the primary key of the video user entry
	 * @return the video user entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry remove(long videoUserId)
		throws NoSuchVideoUserEntryException, SystemException {
		return remove(Long.valueOf(videoUserId));
	}

	/**
	 * Removes the video user entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video user entry
	 * @return the video user entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserEntry remove(Serializable primaryKey)
		throws NoSuchVideoUserEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoUserEntry videoUserEntry = (VideoUserEntry)session.get(VideoUserEntryImpl.class,
					primaryKey);

			if (videoUserEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoUserEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoUserEntry);
		}
		catch (NoSuchVideoUserEntryException nsee) {
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
	protected VideoUserEntry removeImpl(VideoUserEntry videoUserEntry)
		throws SystemException {
		videoUserEntry = toUnwrappedModel(videoUserEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoUserEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoUserEntry);

		return videoUserEntry;
	}

	@Override
	public VideoUserEntry updateImpl(
		vn.com.fis.portal.model.VideoUserEntry videoUserEntry, boolean merge)
		throws SystemException {
		videoUserEntry = toUnwrappedModel(videoUserEntry);

		boolean isNew = videoUserEntry.isNew();

		VideoUserEntryModelImpl videoUserEntryModelImpl = (VideoUserEntryModelImpl)videoUserEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoUserEntry, merge);

			videoUserEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoUserEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoUserEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserEntryModelImpl.getOriginalUserId()),
						Long.valueOf(videoUserEntryModelImpl.getOriginalVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID,
					args);

				args = new Object[] {
						Long.valueOf(videoUserEntryModelImpl.getUserId()),
						Long.valueOf(videoUserEntryModelImpl.getVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID,
					args);
			}

			if ((videoUserEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserEntryModelImpl.getOriginalUserId()),
						Long.valueOf(videoUserEntryModelImpl.getOriginalVideoId()),
						Integer.valueOf(videoUserEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS,
					args);

				args = new Object[] {
						Long.valueOf(videoUserEntryModelImpl.getUserId()),
						Long.valueOf(videoUserEntryModelImpl.getVideoId()),
						Integer.valueOf(videoUserEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserEntryImpl.class, videoUserEntry.getPrimaryKey(),
			videoUserEntry);

		return videoUserEntry;
	}

	protected VideoUserEntry toUnwrappedModel(VideoUserEntry videoUserEntry) {
		if (videoUserEntry instanceof VideoUserEntryImpl) {
			return videoUserEntry;
		}

		VideoUserEntryImpl videoUserEntryImpl = new VideoUserEntryImpl();

		videoUserEntryImpl.setNew(videoUserEntry.isNew());
		videoUserEntryImpl.setPrimaryKey(videoUserEntry.getPrimaryKey());

		videoUserEntryImpl.setVideoUserId(videoUserEntry.getVideoUserId());
		videoUserEntryImpl.setVideoId(videoUserEntry.getVideoId());
		videoUserEntryImpl.setUserId(videoUserEntry.getUserId());
		videoUserEntryImpl.setOriginCode(videoUserEntry.getOriginCode());
		videoUserEntryImpl.setDate_(videoUserEntry.getDate_());
		videoUserEntryImpl.setStartDate(videoUserEntry.getStartDate());
		videoUserEntryImpl.setEndDate(videoUserEntry.getEndDate());
		videoUserEntryImpl.setSenderId(videoUserEntry.getSenderId());
		videoUserEntryImpl.setStatus(videoUserEntry.getStatus());

		return videoUserEntryImpl;
	}

	/**
	 * Returns the video user entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user entry
	 * @return the video user entry
	 * @throws com.liferay.portal.NoSuchModelException if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserEntryException} if it could not be found.
	 *
	 * @param videoUserId the primary key of the video user entry
	 * @return the video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry findByPrimaryKey(long videoUserId)
		throws NoSuchVideoUserEntryException, SystemException {
		VideoUserEntry videoUserEntry = fetchByPrimaryKey(videoUserId);

		if (videoUserEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoUserId);
			}

			throw new NoSuchVideoUserEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoUserId);
		}

		return videoUserEntry;
	}

	/**
	 * Returns the video user entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user entry
	 * @return the video user entry, or <code>null</code> if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoUserId the primary key of the video user entry
	 * @return the video user entry, or <code>null</code> if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry fetchByPrimaryKey(long videoUserId)
		throws SystemException {
		VideoUserEntry videoUserEntry = (VideoUserEntry)EntityCacheUtil.getResult(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserEntryImpl.class, videoUserId);

		if (videoUserEntry == _nullVideoUserEntry) {
			return null;
		}

		if (videoUserEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoUserEntry = (VideoUserEntry)session.get(VideoUserEntryImpl.class,
						Long.valueOf(videoUserId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoUserEntry != null) {
					cacheResult(videoUserEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoUserEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserEntryImpl.class, videoUserId,
						_nullVideoUserEntry);
				}

				closeSession(session);
			}
		}

		return videoUserEntry;
	}

	/**
	 * Returns all the video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @return the matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId(long userId, long videoId)
		throws SystemException {
		return findByUserId_VideoId(userId, videoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @return the range of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId(long userId, long videoId,
		int start, int end) throws SystemException {
		return findByUserId_VideoId(userId, videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId(long userId, long videoId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID;
			finderArgs = new Object[] { userId, videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_VIDEOID;
			finderArgs = new Object[] {
					userId, videoId,
					
					start, end, orderByComparator
				};
		}

		List<VideoUserEntry> list = (List<VideoUserEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(videoId);

				list = (List<VideoUserEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video user entry in the ordered set where userId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry findByUserId_VideoId_First(long userId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserEntryException, SystemException {
		List<VideoUserEntry> list = findByUserId_VideoId(userId, videoId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user entry in the ordered set where userId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry findByUserId_VideoId_Last(long userId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserEntryException, SystemException {
		int count = countByUserId_VideoId(userId, videoId);

		List<VideoUserEntry> list = findByUserId_VideoId(userId, videoId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user entries before and after the current video user entry in the ordered set where userId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoUserId the primary key of the current video user entry
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry[] findByUserId_VideoId_PrevAndNext(long videoUserId,
		long userId, long videoId, OrderByComparator orderByComparator)
		throws NoSuchVideoUserEntryException, SystemException {
		VideoUserEntry videoUserEntry = findByPrimaryKey(videoUserId);

		Session session = null;

		try {
			session = openSession();

			VideoUserEntry[] array = new VideoUserEntryImpl[3];

			array[0] = getByUserId_VideoId_PrevAndNext(session, videoUserEntry,
					userId, videoId, orderByComparator, true);

			array[1] = videoUserEntry;

			array[2] = getByUserId_VideoId_PrevAndNext(session, videoUserEntry,
					userId, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoUserEntry getByUserId_VideoId_PrevAndNext(Session session,
		VideoUserEntry videoUserEntry, long userId, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_VIDEOID_USERID_2);

		query.append(_FINDER_COLUMN_USERID_VIDEOID_VIDEOID_2);

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
			query.append(VideoUserEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @return the matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId_Status(long userId,
		long videoId, int status) throws SystemException {
		return findByUserId_VideoId_Status(userId, videoId, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @return the range of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId_Status(long userId,
		long videoId, int status, int start, int end) throws SystemException {
		return findByUserId_VideoId_Status(userId, videoId, status, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findByUserId_VideoId_Status(long userId,
		long videoId, int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS;
			finderArgs = new Object[] { userId, videoId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_VIDEOID_STATUS;
			finderArgs = new Object[] {
					userId, videoId, status,
					
					start, end, orderByComparator
				};
		}

		List<VideoUserEntry> list = (List<VideoUserEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_VIDEOUSERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_VIDEOID_2);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(videoId);

				qPos.add(status);

				list = (List<VideoUserEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video user entry in the ordered set where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry findByUserId_VideoId_Status_First(long userId,
		long videoId, int status, OrderByComparator orderByComparator)
		throws NoSuchVideoUserEntryException, SystemException {
		List<VideoUserEntry> list = findByUserId_VideoId_Status(userId,
				videoId, status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user entry in the ordered set where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a matching video user entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry findByUserId_VideoId_Status_Last(long userId,
		long videoId, int status, OrderByComparator orderByComparator)
		throws NoSuchVideoUserEntryException, SystemException {
		int count = countByUserId_VideoId_Status(userId, videoId, status);

		List<VideoUserEntry> list = findByUserId_VideoId_Status(userId,
				videoId, status, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user entries before and after the current video user entry in the ordered set where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoUserId the primary key of the current video user entry
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserEntryException if a video user entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserEntry[] findByUserId_VideoId_Status_PrevAndNext(
		long videoUserId, long userId, long videoId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserEntryException, SystemException {
		VideoUserEntry videoUserEntry = findByPrimaryKey(videoUserId);

		Session session = null;

		try {
			session = openSession();

			VideoUserEntry[] array = new VideoUserEntryImpl[3];

			array[0] = getByUserId_VideoId_Status_PrevAndNext(session,
					videoUserEntry, userId, videoId, status, orderByComparator,
					true);

			array[1] = videoUserEntry;

			array[2] = getByUserId_VideoId_Status_PrevAndNext(session,
					videoUserEntry, userId, videoId, status, orderByComparator,
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

	protected VideoUserEntry getByUserId_VideoId_Status_PrevAndNext(
		Session session, VideoUserEntry videoUserEntry, long userId,
		long videoId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_USERID_2);

		query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_VIDEOID_2);

		query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_STATUS_2);

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
			query.append(VideoUserEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(videoId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user entries.
	 *
	 * @return the video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @return the range of video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user entries
	 * @param end the upper bound of the range of video user entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserEntry> findAll(int start, int end,
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

		List<VideoUserEntry> list = (List<VideoUserEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOUSERENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOUSERENTRY.concat(VideoUserEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoUserEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoUserEntry>)QueryUtil.list(q,
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
	 * Removes all the video user entries where userId = &#63; and videoId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_VideoId(long userId, long videoId)
		throws SystemException {
		for (VideoUserEntry videoUserEntry : findByUserId_VideoId(userId,
				videoId)) {
			remove(videoUserEntry);
		}
	}

	/**
	 * Removes all the video user entries where userId = &#63; and videoId = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_VideoId_Status(long userId, long videoId,
		int status) throws SystemException {
		for (VideoUserEntry videoUserEntry : findByUserId_VideoId_Status(
				userId, videoId, status)) {
			remove(videoUserEntry);
		}
	}

	/**
	 * Removes all the video user entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoUserEntry videoUserEntry : findAll()) {
			remove(videoUserEntry);
		}
	}

	/**
	 * Returns the number of video user entries where userId = &#63; and videoId = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @return the number of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_VideoId(long userId, long videoId)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, videoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOUSERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(videoId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user entries where userId = &#63; and videoId = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param status the status
	 * @return the number of matching video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_VideoId_Status(long userId, long videoId,
		int status) throws SystemException {
		Object[] finderArgs = new Object[] { userId, videoId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_VIDEOUSERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_USERID_2);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_VIDEOID_2);

			query.append(_FINDER_COLUMN_USERID_VIDEOID_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(videoId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_VIDEOID_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user entries.
	 *
	 * @return the number of video user entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOUSERENTRY);

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
	 * Initializes the video user entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.VideoUserEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoUserEntry>> listenersList = new ArrayList<ModelListener<VideoUserEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoUserEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoUserEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOUSERENTRY = "SELECT videoUserEntry FROM VideoUserEntry videoUserEntry";
	private static final String _SQL_SELECT_VIDEOUSERENTRY_WHERE = "SELECT videoUserEntry FROM VideoUserEntry videoUserEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOUSERENTRY = "SELECT COUNT(videoUserEntry) FROM VideoUserEntry videoUserEntry";
	private static final String _SQL_COUNT_VIDEOUSERENTRY_WHERE = "SELECT COUNT(videoUserEntry) FROM VideoUserEntry videoUserEntry WHERE ";
	private static final String _FINDER_COLUMN_USERID_VIDEOID_USERID_2 = "videoUserEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_VIDEOID_VIDEOID_2 = "videoUserEntry.videoId = ?";
	private static final String _FINDER_COLUMN_USERID_VIDEOID_STATUS_USERID_2 = "videoUserEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_VIDEOID_STATUS_VIDEOID_2 = "videoUserEntry.videoId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_VIDEOID_STATUS_STATUS_2 = "videoUserEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoUserEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoUserEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoUserEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoUserEntryPersistenceImpl.class);
	private static VideoUserEntry _nullVideoUserEntry = new VideoUserEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoUserEntry> toCacheModel() {
				return _nullVideoUserEntryCacheModel;
			}
		};

	private static CacheModel<VideoUserEntry> _nullVideoUserEntryCacheModel = new CacheModel<VideoUserEntry>() {
			public VideoUserEntry toEntityModel() {
				return _nullVideoUserEntry;
			}
		};
}