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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import vn.com.fis.portal.NoSuchVideoEntryException;
import vn.com.fis.portal.model.VideoEntry;
import vn.com.fis.portal.model.impl.VideoEntryImpl;
import vn.com.fis.portal.model.impl.VideoEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoEntryPersistence
 * @see VideoEntryUtil
 * @generated
 */
public class VideoEntryPersistenceImpl extends BasePersistenceImpl<VideoEntry>
	implements VideoEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoEntryUtil} to access the video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEUPLOAD =
		new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateUpload",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEUPLOAD =
		new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDateUpload",
			new String[] { Date.class.getName() },
			VideoEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATEUPLOAD = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDateUpload",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADERID =
		new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploaderId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID =
		new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUploaderId",
			new String[] { Long.class.getName() },
			VideoEntryModelImpl.UPLOADERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPLOADERID = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUploaderId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADERID_FOLDER =
		new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUploaderId_Folder",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID_FOLDER =
		new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUploaderId_Folder",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoEntryModelImpl.UPLOADERID_COLUMN_BITMASK |
			VideoEntryModelImpl.FOLDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UPLOADERID_FOLDER = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUploaderId_Folder",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, VideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video entry in the entity cache if it is enabled.
	 *
	 * @param videoEntry the video entry
	 */
	public void cacheResult(VideoEntry videoEntry) {
		EntityCacheUtil.putResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryImpl.class, videoEntry.getPrimaryKey(), videoEntry);

		videoEntry.resetOriginalValues();
	}

	/**
	 * Caches the video entries in the entity cache if it is enabled.
	 *
	 * @param videoEntries the video entries
	 */
	public void cacheResult(List<VideoEntry> videoEntries) {
		for (VideoEntry videoEntry : videoEntries) {
			if (EntityCacheUtil.getResult(
						VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoEntryImpl.class, videoEntry.getPrimaryKey()) == null) {
				cacheResult(videoEntry);
			}
			else {
				videoEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoEntry videoEntry) {
		EntityCacheUtil.removeResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryImpl.class, videoEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoEntry> videoEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoEntry videoEntry : videoEntries) {
			EntityCacheUtil.removeResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoEntryImpl.class, videoEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video entry with the primary key. Does not add the video entry to the database.
	 *
	 * @param videoId the primary key for the new video entry
	 * @return the new video entry
	 */
	public VideoEntry create(long videoId) {
		VideoEntry videoEntry = new VideoEntryImpl();

		videoEntry.setNew(true);
		videoEntry.setPrimaryKey(videoId);

		return videoEntry;
	}

	/**
	 * Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoId the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry remove(long videoId)
		throws NoSuchVideoEntryException, SystemException {
		return remove(Long.valueOf(videoId));
	}

	/**
	 * Removes the video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video entry
	 * @return the video entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoEntry remove(Serializable primaryKey)
		throws NoSuchVideoEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoEntry videoEntry = (VideoEntry)session.get(VideoEntryImpl.class,
					primaryKey);

			if (videoEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoEntry);
		}
		catch (NoSuchVideoEntryException nsee) {
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
	protected VideoEntry removeImpl(VideoEntry videoEntry)
		throws SystemException {
		videoEntry = toUnwrappedModel(videoEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoEntry);

		return videoEntry;
	}

	@Override
	public VideoEntry updateImpl(
		vn.com.fis.portal.model.VideoEntry videoEntry, boolean merge)
		throws SystemException {
		videoEntry = toUnwrappedModel(videoEntry);

		boolean isNew = videoEntry.isNew();

		VideoEntryModelImpl videoEntryModelImpl = (VideoEntryModelImpl)videoEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoEntry, merge);

			videoEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEUPLOAD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATEUPLOAD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEUPLOAD,
					args);

				args = new Object[] { videoEntryModelImpl.getDate_() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATEUPLOAD,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEUPLOAD,
					args);
			}

			if ((videoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoEntryModelImpl.getOriginalUploaderId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID,
					args);

				args = new Object[] {
						Long.valueOf(videoEntryModelImpl.getUploaderId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID,
					args);
			}

			if ((videoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID_FOLDER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoEntryModelImpl.getOriginalUploaderId()),
						Long.valueOf(videoEntryModelImpl.getOriginalFolderId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADERID_FOLDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID_FOLDER,
					args);

				args = new Object[] {
						Long.valueOf(videoEntryModelImpl.getUploaderId()),
						Long.valueOf(videoEntryModelImpl.getFolderId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UPLOADERID_FOLDER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID_FOLDER,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoEntryImpl.class, videoEntry.getPrimaryKey(), videoEntry);

		return videoEntry;
	}

	protected VideoEntry toUnwrappedModel(VideoEntry videoEntry) {
		if (videoEntry instanceof VideoEntryImpl) {
			return videoEntry;
		}

		VideoEntryImpl videoEntryImpl = new VideoEntryImpl();

		videoEntryImpl.setNew(videoEntry.isNew());
		videoEntryImpl.setPrimaryKey(videoEntry.getPrimaryKey());

		videoEntryImpl.setVideoId(videoEntry.getVideoId());
		videoEntryImpl.setVideoName(videoEntry.getVideoName());
		videoEntryImpl.setDescription(videoEntry.getDescription());
		videoEntryImpl.setVideoUrl(videoEntry.getVideoUrl());
		videoEntryImpl.setViewCount(videoEntry.getViewCount());
		videoEntryImpl.setDate_(videoEntry.getDate_());
		videoEntryImpl.setSmallImageUrl(videoEntry.getSmallImageUrl());
		videoEntryImpl.setLargeImageUrl(videoEntry.getLargeImageUrl());
		videoEntryImpl.setAccessModifier(videoEntry.getAccessModifier());
		videoEntryImpl.setUploaderId(videoEntry.getUploaderId());
		videoEntryImpl.setFolderId(videoEntry.getFolderId());
		videoEntryImpl.setStatus(videoEntry.getStatus());

		return videoEntryImpl;
	}

	/**
	 * Returns the video entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video entry
	 * @return the video entry
	 * @throws com.liferay.portal.NoSuchModelException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoEntryException} if it could not be found.
	 *
	 * @param videoId the primary key of the video entry
	 * @return the video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByPrimaryKey(long videoId)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = fetchByPrimaryKey(videoId);

		if (videoEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + videoId);
			}

			throw new NoSuchVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoId);
		}

		return videoEntry;
	}

	/**
	 * Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video entry
	 * @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoId the primary key of the video entry
	 * @return the video entry, or <code>null</code> if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry fetchByPrimaryKey(long videoId) throws SystemException {
		VideoEntry videoEntry = (VideoEntry)EntityCacheUtil.getResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoEntryImpl.class, videoId);

		if (videoEntry == _nullVideoEntry) {
			return null;
		}

		if (videoEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoEntry = (VideoEntry)session.get(VideoEntryImpl.class,
						Long.valueOf(videoId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoEntry != null) {
					cacheResult(videoEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoEntryImpl.class, videoId, _nullVideoEntry);
				}

				closeSession(session);
			}
		}

		return videoEntry;
	}

	/**
	 * Returns all the video entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByDateUpload(Date date_)
		throws SystemException {
		return findByDateUpload(date_, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByDateUpload(Date date_, int start, int end)
		throws SystemException {
		return findByDateUpload(date_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByDateUpload(Date date_, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEUPLOAD;
			finderArgs = new Object[] { date_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEUPLOAD;
			finderArgs = new Object[] { date_, start, end, orderByComparator };
		}

		List<VideoEntry> list = (List<VideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_DATEUPLOAD_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_DATEUPLOAD_DATE__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
				}

				list = (List<VideoEntry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByDateUpload_First(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		List<VideoEntry> list = findByDateUpload(date_, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByDateUpload_Last(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		int count = countByDateUpload(date_);

		List<VideoEntry> list = findByDateUpload(date_, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video entries before and after the current video entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the primary key of the current video entry
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry[] findByDateUpload_PrevAndNext(long videoId, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VideoEntry[] array = new VideoEntryImpl[3];

			array[0] = getByDateUpload_PrevAndNext(session, videoEntry, date_,
					orderByComparator, true);

			array[1] = videoEntry;

			array[2] = getByDateUpload_PrevAndNext(session, videoEntry, date_,
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

	protected VideoEntry getByDateUpload_PrevAndNext(Session session,
		VideoEntry videoEntry, Date date_, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

		if (date_ == null) {
			query.append(_FINDER_COLUMN_DATEUPLOAD_DATE__1);
		}
		else {
			query.append(_FINDER_COLUMN_DATEUPLOAD_DATE__2);
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
			query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (date_ != null) {
			qPos.add(CalendarUtil.getTimestamp(date_));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video entries where uploaderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId(long uploaderId)
		throws SystemException {
		return findByUploaderId(uploaderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video entries where uploaderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId(long uploaderId, int start, int end)
		throws SystemException {
		return findByUploaderId(uploaderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries where uploaderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId(long uploaderId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID;
			finderArgs = new Object[] { uploaderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADERID;
			finderArgs = new Object[] { uploaderId, start, end, orderByComparator };
		}

		List<VideoEntry> list = (List<VideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_UPLOADERID_UPLOADERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(uploaderId);

				list = (List<VideoEntry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video entry in the ordered set where uploaderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByUploaderId_First(long uploaderId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		List<VideoEntry> list = findByUploaderId(uploaderId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uploaderId=");
			msg.append(uploaderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video entry in the ordered set where uploaderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByUploaderId_Last(long uploaderId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		int count = countByUploaderId(uploaderId);

		List<VideoEntry> list = findByUploaderId(uploaderId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uploaderId=");
			msg.append(uploaderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video entries before and after the current video entry in the ordered set where uploaderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the primary key of the current video entry
	 * @param uploaderId the uploader ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry[] findByUploaderId_PrevAndNext(long videoId,
		long uploaderId, OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VideoEntry[] array = new VideoEntryImpl[3];

			array[0] = getByUploaderId_PrevAndNext(session, videoEntry,
					uploaderId, orderByComparator, true);

			array[1] = videoEntry;

			array[2] = getByUploaderId_PrevAndNext(session, videoEntry,
					uploaderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoEntry getByUploaderId_PrevAndNext(Session session,
		VideoEntry videoEntry, long uploaderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

		query.append(_FINDER_COLUMN_UPLOADERID_UPLOADERID_2);

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
			query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(uploaderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @return the matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId_Folder(long uploaderId,
		long folderId) throws SystemException {
		return findByUploaderId_Folder(uploaderId, folderId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId_Folder(long uploaderId,
		long folderId, int start, int end) throws SystemException {
		return findByUploaderId_Folder(uploaderId, folderId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findByUploaderId_Folder(long uploaderId,
		long folderId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UPLOADERID_FOLDER;
			finderArgs = new Object[] { uploaderId, folderId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UPLOADERID_FOLDER;
			finderArgs = new Object[] {
					uploaderId, folderId,
					
					start, end, orderByComparator
				};
		}

		List<VideoEntry> list = (List<VideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_UPLOADERID_FOLDER_UPLOADERID_2);

			query.append(_FINDER_COLUMN_UPLOADERID_FOLDER_FOLDERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(uploaderId);

				qPos.add(folderId);

				list = (List<VideoEntry>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first video entry in the ordered set where uploaderId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByUploaderId_Folder_First(long uploaderId,
		long folderId, OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		List<VideoEntry> list = findByUploaderId_Folder(uploaderId, folderId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uploaderId=");
			msg.append(uploaderId);

			msg.append(", folderId=");
			msg.append(folderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video entry in the ordered set where uploaderId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a matching video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry findByUploaderId_Folder_Last(long uploaderId,
		long folderId, OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		int count = countByUploaderId_Folder(uploaderId, folderId);

		List<VideoEntry> list = findByUploaderId_Folder(uploaderId, folderId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uploaderId=");
			msg.append(uploaderId);

			msg.append(", folderId=");
			msg.append(folderId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video entries before and after the current video entry in the ordered set where uploaderId = &#63; and folderId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the primary key of the current video entry
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video entry
	 * @throws vn.com.fis.portal.NoSuchVideoEntryException if a video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoEntry[] findByUploaderId_Folder_PrevAndNext(long videoId,
		long uploaderId, long folderId, OrderByComparator orderByComparator)
		throws NoSuchVideoEntryException, SystemException {
		VideoEntry videoEntry = findByPrimaryKey(videoId);

		Session session = null;

		try {
			session = openSession();

			VideoEntry[] array = new VideoEntryImpl[3];

			array[0] = getByUploaderId_Folder_PrevAndNext(session, videoEntry,
					uploaderId, folderId, orderByComparator, true);

			array[1] = videoEntry;

			array[2] = getByUploaderId_Folder_PrevAndNext(session, videoEntry,
					uploaderId, folderId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoEntry getByUploaderId_Folder_PrevAndNext(Session session,
		VideoEntry videoEntry, long uploaderId, long folderId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOENTRY_WHERE);

		query.append(_FINDER_COLUMN_UPLOADERID_FOLDER_UPLOADERID_2);

		query.append(_FINDER_COLUMN_UPLOADERID_FOLDER_FOLDERID_2);

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
			query.append(VideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(uploaderId);

		qPos.add(folderId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video entries.
	 *
	 * @return the video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @return the range of video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video entries
	 * @param end the upper bound of the range of video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoEntry> findAll(int start, int end,
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

		List<VideoEntry> list = (List<VideoEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOENTRY.concat(VideoEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video entries where date_ = &#63; from the database.
	 *
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDateUpload(Date date_) throws SystemException {
		for (VideoEntry videoEntry : findByDateUpload(date_)) {
			remove(videoEntry);
		}
	}

	/**
	 * Removes all the video entries where uploaderId = &#63; from the database.
	 *
	 * @param uploaderId the uploader ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUploaderId(long uploaderId) throws SystemException {
		for (VideoEntry videoEntry : findByUploaderId(uploaderId)) {
			remove(videoEntry);
		}
	}

	/**
	 * Removes all the video entries where uploaderId = &#63; and folderId = &#63; from the database.
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUploaderId_Folder(long uploaderId, long folderId)
		throws SystemException {
		for (VideoEntry videoEntry : findByUploaderId_Folder(uploaderId,
				folderId)) {
			remove(videoEntry);
		}
	}

	/**
	 * Removes all the video entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoEntry videoEntry : findAll()) {
			remove(videoEntry);
		}
	}

	/**
	 * Returns the number of video entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the number of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDateUpload(Date date_) throws SystemException {
		Object[] finderArgs = new Object[] { date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATEUPLOAD,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOENTRY_WHERE);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_DATEUPLOAD_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_DATEUPLOAD_DATE__2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATEUPLOAD,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video entries where uploaderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @return the number of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUploaderId(long uploaderId) throws SystemException {
		Object[] finderArgs = new Object[] { uploaderId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UPLOADERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_UPLOADERID_UPLOADERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(uploaderId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPLOADERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video entries where uploaderId = &#63; and folderId = &#63;.
	 *
	 * @param uploaderId the uploader ID
	 * @param folderId the folder ID
	 * @return the number of matching video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUploaderId_Folder(long uploaderId, long folderId)
		throws SystemException {
		Object[] finderArgs = new Object[] { uploaderId, folderId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UPLOADERID_FOLDER,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_UPLOADERID_FOLDER_UPLOADERID_2);

			query.append(_FINDER_COLUMN_UPLOADERID_FOLDER_FOLDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(uploaderId);

				qPos.add(folderId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UPLOADERID_FOLDER,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video entries.
	 *
	 * @return the number of video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOENTRY);

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
	 * Initializes the video entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.VideoEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoEntry>> listenersList = new ArrayList<ModelListener<VideoEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOENTRY = "SELECT videoEntry FROM VideoEntry videoEntry";
	private static final String _SQL_SELECT_VIDEOENTRY_WHERE = "SELECT videoEntry FROM VideoEntry videoEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOENTRY = "SELECT COUNT(videoEntry) FROM VideoEntry videoEntry";
	private static final String _SQL_COUNT_VIDEOENTRY_WHERE = "SELECT COUNT(videoEntry) FROM VideoEntry videoEntry WHERE ";
	private static final String _FINDER_COLUMN_DATEUPLOAD_DATE__1 = "videoEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_DATEUPLOAD_DATE__2 = "videoEntry.date_ = ?";
	private static final String _FINDER_COLUMN_UPLOADERID_UPLOADERID_2 = "videoEntry.uploaderId = ?";
	private static final String _FINDER_COLUMN_UPLOADERID_FOLDER_UPLOADERID_2 = "videoEntry.uploaderId = ? AND ";
	private static final String _FINDER_COLUMN_UPLOADERID_FOLDER_FOLDERID_2 = "videoEntry.folderId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoEntryPersistenceImpl.class);
	private static VideoEntry _nullVideoEntry = new VideoEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoEntry> toCacheModel() {
				return _nullVideoEntryCacheModel;
			}
		};

	private static CacheModel<VideoEntry> _nullVideoEntryCacheModel = new CacheModel<VideoEntry>() {
			public VideoEntry toEntityModel() {
				return _nullVideoEntry;
			}
		};
}