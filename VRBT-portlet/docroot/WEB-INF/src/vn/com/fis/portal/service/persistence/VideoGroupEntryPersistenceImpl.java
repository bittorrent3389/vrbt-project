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

import vn.com.fis.portal.NoSuchVideoGroupEntryException;
import vn.com.fis.portal.model.VideoGroupEntry;
import vn.com.fis.portal.model.impl.VideoGroupEntryImpl;
import vn.com.fis.portal.model.impl.VideoGroupEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoGroupEntryPersistence
 * @see VideoGroupEntryUtil
 * @generated
 */
public class VideoGroupEntryPersistenceImpl extends BasePersistenceImpl<VideoGroupEntry>
	implements VideoGroupEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoGroupEntryUtil} to access the video group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoGroupEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPNAME =
		new FinderPath(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoGroupEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPNAME =
		new FinderPath(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupName",
			new String[] { String.class.getName() },
			VideoGroupEntryModelImpl.VIDEOGROUPNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPNAME = new FinderPath(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoGroupEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video group entry in the entity cache if it is enabled.
	 *
	 * @param videoGroupEntry the video group entry
	 */
	public void cacheResult(VideoGroupEntry videoGroupEntry) {
		EntityCacheUtil.putResult(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryImpl.class, videoGroupEntry.getPrimaryKey(),
			videoGroupEntry);

		videoGroupEntry.resetOriginalValues();
	}

	/**
	 * Caches the video group entries in the entity cache if it is enabled.
	 *
	 * @param videoGroupEntries the video group entries
	 */
	public void cacheResult(List<VideoGroupEntry> videoGroupEntries) {
		for (VideoGroupEntry videoGroupEntry : videoGroupEntries) {
			if (EntityCacheUtil.getResult(
						VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoGroupEntryImpl.class,
						videoGroupEntry.getPrimaryKey()) == null) {
				cacheResult(videoGroupEntry);
			}
			else {
				videoGroupEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video group entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoGroupEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoGroupEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video group entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoGroupEntry videoGroupEntry) {
		EntityCacheUtil.removeResult(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryImpl.class, videoGroupEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoGroupEntry> videoGroupEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoGroupEntry videoGroupEntry : videoGroupEntries) {
			EntityCacheUtil.removeResult(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoGroupEntryImpl.class, videoGroupEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video group entry with the primary key. Does not add the video group entry to the database.
	 *
	 * @param videoGroupId the primary key for the new video group entry
	 * @return the new video group entry
	 */
	public VideoGroupEntry create(long videoGroupId) {
		VideoGroupEntry videoGroupEntry = new VideoGroupEntryImpl();

		videoGroupEntry.setNew(true);
		videoGroupEntry.setPrimaryKey(videoGroupId);

		return videoGroupEntry;
	}

	/**
	 * Removes the video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoGroupId the primary key of the video group entry
	 * @return the video group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoGroupEntry remove(long videoGroupId)
		throws NoSuchVideoGroupEntryException, SystemException {
		return remove(Long.valueOf(videoGroupId));
	}

	/**
	 * Removes the video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video group entry
	 * @return the video group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoGroupEntry remove(Serializable primaryKey)
		throws NoSuchVideoGroupEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoGroupEntry videoGroupEntry = (VideoGroupEntry)session.get(VideoGroupEntryImpl.class,
					primaryKey);

			if (videoGroupEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoGroupEntry);
		}
		catch (NoSuchVideoGroupEntryException nsee) {
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
	protected VideoGroupEntry removeImpl(VideoGroupEntry videoGroupEntry)
		throws SystemException {
		videoGroupEntry = toUnwrappedModel(videoGroupEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoGroupEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoGroupEntry);

		return videoGroupEntry;
	}

	@Override
	public VideoGroupEntry updateImpl(
		vn.com.fis.portal.model.VideoGroupEntry videoGroupEntry, boolean merge)
		throws SystemException {
		videoGroupEntry = toUnwrappedModel(videoGroupEntry);

		boolean isNew = videoGroupEntry.isNew();

		VideoGroupEntryModelImpl videoGroupEntryModelImpl = (VideoGroupEntryModelImpl)videoGroupEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoGroupEntry, merge);

			videoGroupEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoGroupEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoGroupEntryModelImpl.getOriginalVideoGroupName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPNAME,
					args);

				args = new Object[] { videoGroupEntryModelImpl.getVideoGroupName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoGroupEntryImpl.class, videoGroupEntry.getPrimaryKey(),
			videoGroupEntry);

		return videoGroupEntry;
	}

	protected VideoGroupEntry toUnwrappedModel(VideoGroupEntry videoGroupEntry) {
		if (videoGroupEntry instanceof VideoGroupEntryImpl) {
			return videoGroupEntry;
		}

		VideoGroupEntryImpl videoGroupEntryImpl = new VideoGroupEntryImpl();

		videoGroupEntryImpl.setNew(videoGroupEntry.isNew());
		videoGroupEntryImpl.setPrimaryKey(videoGroupEntry.getPrimaryKey());

		videoGroupEntryImpl.setVideoGroupId(videoGroupEntry.getVideoGroupId());
		videoGroupEntryImpl.setVideoGroupName(videoGroupEntry.getVideoGroupName());
		videoGroupEntryImpl.setDescription(videoGroupEntry.getDescription());

		return videoGroupEntryImpl;
	}

	/**
	 * Returns the video group entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video group entry
	 * @return the video group entry
	 * @throws com.liferay.portal.NoSuchModelException if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoGroupEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoGroupEntryException} if it could not be found.
	 *
	 * @param videoGroupId the primary key of the video group entry
	 * @return the video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoGroupEntry findByPrimaryKey(long videoGroupId)
		throws NoSuchVideoGroupEntryException, SystemException {
		VideoGroupEntry videoGroupEntry = fetchByPrimaryKey(videoGroupId);

		if (videoGroupEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoGroupId);
			}

			throw new NoSuchVideoGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoGroupId);
		}

		return videoGroupEntry;
	}

	/**
	 * Returns the video group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video group entry
	 * @return the video group entry, or <code>null</code> if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoGroupEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoGroupId the primary key of the video group entry
	 * @return the video group entry, or <code>null</code> if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoGroupEntry fetchByPrimaryKey(long videoGroupId)
		throws SystemException {
		VideoGroupEntry videoGroupEntry = (VideoGroupEntry)EntityCacheUtil.getResult(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoGroupEntryImpl.class, videoGroupId);

		if (videoGroupEntry == _nullVideoGroupEntry) {
			return null;
		}

		if (videoGroupEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoGroupEntry = (VideoGroupEntry)session.get(VideoGroupEntryImpl.class,
						Long.valueOf(videoGroupId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoGroupEntry != null) {
					cacheResult(videoGroupEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoGroupEntryImpl.class, videoGroupId,
						_nullVideoGroupEntry);
				}

				closeSession(session);
			}
		}

		return videoGroupEntry;
	}

	/**
	 * Returns all the video group entries where videoGroupName = &#63;.
	 *
	 * @param videoGroupName the video group name
	 * @return the matching video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoGroupEntry> findByGroupName(String videoGroupName)
		throws SystemException {
		return findByGroupName(videoGroupName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video group entries where videoGroupName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupName the video group name
	 * @param start the lower bound of the range of video group entries
	 * @param end the upper bound of the range of video group entries (not inclusive)
	 * @return the range of matching video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoGroupEntry> findByGroupName(String videoGroupName,
		int start, int end) throws SystemException {
		return findByGroupName(videoGroupName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video group entries where videoGroupName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupName the video group name
	 * @param start the lower bound of the range of video group entries
	 * @param end the upper bound of the range of video group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoGroupEntry> findByGroupName(String videoGroupName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPNAME;
			finderArgs = new Object[] { videoGroupName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPNAME;
			finderArgs = new Object[] {
					videoGroupName,
					
					start, end, orderByComparator
				};
		}

		List<VideoGroupEntry> list = (List<VideoGroupEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOGROUPENTRY_WHERE);

			if (videoGroupName == null) {
				query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_1);
			}
			else {
				if (videoGroupName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (videoGroupName != null) {
					qPos.add(videoGroupName);
				}

				list = (List<VideoGroupEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video group entry in the ordered set where videoGroupName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupName the video group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a matching video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoGroupEntry findByGroupName_First(String videoGroupName,
		OrderByComparator orderByComparator)
		throws NoSuchVideoGroupEntryException, SystemException {
		List<VideoGroupEntry> list = findByGroupName(videoGroupName, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoGroupName=");
			msg.append(videoGroupName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video group entry in the ordered set where videoGroupName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupName the video group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a matching video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoGroupEntry findByGroupName_Last(String videoGroupName,
		OrderByComparator orderByComparator)
		throws NoSuchVideoGroupEntryException, SystemException {
		int count = countByGroupName(videoGroupName);

		List<VideoGroupEntry> list = findByGroupName(videoGroupName, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoGroupName=");
			msg.append(videoGroupName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video group entries before and after the current video group entry in the ordered set where videoGroupName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupId the primary key of the current video group entry
	 * @param videoGroupName the video group name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video group entry
	 * @throws vn.com.fis.portal.NoSuchVideoGroupEntryException if a video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoGroupEntry[] findByGroupName_PrevAndNext(long videoGroupId,
		String videoGroupName, OrderByComparator orderByComparator)
		throws NoSuchVideoGroupEntryException, SystemException {
		VideoGroupEntry videoGroupEntry = findByPrimaryKey(videoGroupId);

		Session session = null;

		try {
			session = openSession();

			VideoGroupEntry[] array = new VideoGroupEntryImpl[3];

			array[0] = getByGroupName_PrevAndNext(session, videoGroupEntry,
					videoGroupName, orderByComparator, true);

			array[1] = videoGroupEntry;

			array[2] = getByGroupName_PrevAndNext(session, videoGroupEntry,
					videoGroupName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoGroupEntry getByGroupName_PrevAndNext(Session session,
		VideoGroupEntry videoGroupEntry, String videoGroupName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOGROUPENTRY_WHERE);

		if (videoGroupName == null) {
			query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_1);
		}
		else {
			if (videoGroupName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_2);
			}
		}

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
			query.append(VideoGroupEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (videoGroupName != null) {
			qPos.add(videoGroupName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoGroupEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoGroupEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video group entries.
	 *
	 * @return the video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoGroupEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video group entries
	 * @param end the upper bound of the range of video group entries (not inclusive)
	 * @return the range of video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoGroupEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video group entries
	 * @param end the upper bound of the range of video group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoGroupEntry> findAll(int start, int end,
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

		List<VideoGroupEntry> list = (List<VideoGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOGROUPENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOGROUPENTRY.concat(VideoGroupEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoGroupEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoGroupEntry>)QueryUtil.list(q,
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
	 * Removes all the video group entries where videoGroupName = &#63; from the database.
	 *
	 * @param videoGroupName the video group name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByGroupName(String videoGroupName)
		throws SystemException {
		for (VideoGroupEntry videoGroupEntry : findByGroupName(videoGroupName)) {
			remove(videoGroupEntry);
		}
	}

	/**
	 * Removes all the video group entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoGroupEntry videoGroupEntry : findAll()) {
			remove(videoGroupEntry);
		}
	}

	/**
	 * Returns the number of video group entries where videoGroupName = &#63;.
	 *
	 * @param videoGroupName the video group name
	 * @return the number of matching video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByGroupName(String videoGroupName)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoGroupName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOGROUPENTRY_WHERE);

			if (videoGroupName == null) {
				query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_1);
			}
			else {
				if (videoGroupName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (videoGroupName != null) {
					qPos.add(videoGroupName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video group entries.
	 *
	 * @return the number of video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOGROUPENTRY);

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
	 * Initializes the video group entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.VideoGroupEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoGroupEntry>> listenersList = new ArrayList<ModelListener<VideoGroupEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoGroupEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoGroupEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOGROUPENTRY = "SELECT videoGroupEntry FROM VideoGroupEntry videoGroupEntry";
	private static final String _SQL_SELECT_VIDEOGROUPENTRY_WHERE = "SELECT videoGroupEntry FROM VideoGroupEntry videoGroupEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOGROUPENTRY = "SELECT COUNT(videoGroupEntry) FROM VideoGroupEntry videoGroupEntry";
	private static final String _SQL_COUNT_VIDEOGROUPENTRY_WHERE = "SELECT COUNT(videoGroupEntry) FROM VideoGroupEntry videoGroupEntry WHERE ";
	private static final String _FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_1 = "videoGroupEntry.videoGroupName IS NULL";
	private static final String _FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_2 = "videoGroupEntry.videoGroupName = ?";
	private static final String _FINDER_COLUMN_GROUPNAME_VIDEOGROUPNAME_3 = "(videoGroupEntry.videoGroupName IS NULL OR videoGroupEntry.videoGroupName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoGroupEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoGroupEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoGroupEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoGroupEntryPersistenceImpl.class);
	private static VideoGroupEntry _nullVideoGroupEntry = new VideoGroupEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoGroupEntry> toCacheModel() {
				return _nullVideoGroupEntryCacheModel;
			}
		};

	private static CacheModel<VideoGroupEntry> _nullVideoGroupEntryCacheModel = new CacheModel<VideoGroupEntry>() {
			public VideoGroupEntry toEntityModel() {
				return _nullVideoGroupEntry;
			}
		};
}