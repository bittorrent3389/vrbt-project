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

import vn.com.fis.portal.NoSuchVideoUserTransactionEntryException;
import vn.com.fis.portal.model.VideoUserTransactionEntry;
import vn.com.fis.portal.model.impl.VideoUserTransactionEntryImpl;
import vn.com.fis.portal.model.impl.VideoUserTransactionEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the video user transaction entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserTransactionEntryPersistence
 * @see VideoUserTransactionEntryUtil
 * @generated
 */
public class VideoUserTransactionEntryPersistenceImpl
	extends BasePersistenceImpl<VideoUserTransactionEntry>
	implements VideoUserTransactionEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoUserTransactionEntryUtil} to access the video user transaction entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoUserTransactionEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTransactionCode",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTransactionCode",
			new String[] { Long.class.getName() },
			VideoUserTransactionEntryModelImpl.TRANSACTIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANSACTIONCODE = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTransactionCode", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] { Date.class.getName() },
			VideoUserTransactionEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATE = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDate", new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTransactionCode_Date",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTransactionCode_Date",
			new String[] { Long.class.getName(), Date.class.getName() },
			VideoUserTransactionEntryModelImpl.TRANSACTIONCODE_COLUMN_BITMASK |
			VideoUserTransactionEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTransactionCode_Date",
			new String[] { Long.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			VideoUserTransactionEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoId",
			new String[] { Long.class.getName() },
			VideoUserTransactionEntryModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOID = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVideoId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIVERID =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByreceiverId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID =
		new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByreceiverId",
			new String[] { Long.class.getName() },
			VideoUserTransactionEntryModelImpl.RECEIVERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVERID = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByreceiverId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the video user transaction entry in the entity cache if it is enabled.
	 *
	 * @param videoUserTransactionEntry the video user transaction entry
	 */
	public void cacheResult(VideoUserTransactionEntry videoUserTransactionEntry) {
		EntityCacheUtil.putResult(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			videoUserTransactionEntry.getPrimaryKey(), videoUserTransactionEntry);

		videoUserTransactionEntry.resetOriginalValues();
	}

	/**
	 * Caches the video user transaction entries in the entity cache if it is enabled.
	 *
	 * @param videoUserTransactionEntries the video user transaction entries
	 */
	public void cacheResult(
		List<VideoUserTransactionEntry> videoUserTransactionEntries) {
		for (VideoUserTransactionEntry videoUserTransactionEntry : videoUserTransactionEntries) {
			if (EntityCacheUtil.getResult(
						VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserTransactionEntryImpl.class,
						videoUserTransactionEntry.getPrimaryKey()) == null) {
				cacheResult(videoUserTransactionEntry);
			}
			else {
				videoUserTransactionEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video user transaction entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoUserTransactionEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoUserTransactionEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video user transaction entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoUserTransactionEntry videoUserTransactionEntry) {
		EntityCacheUtil.removeResult(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			videoUserTransactionEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VideoUserTransactionEntry> videoUserTransactionEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoUserTransactionEntry videoUserTransactionEntry : videoUserTransactionEntries) {
			EntityCacheUtil.removeResult(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserTransactionEntryImpl.class,
				videoUserTransactionEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video user transaction entry with the primary key. Does not add the video user transaction entry to the database.
	 *
	 * @param transactionId the primary key for the new video user transaction entry
	 * @return the new video user transaction entry
	 */
	public VideoUserTransactionEntry create(long transactionId) {
		VideoUserTransactionEntry videoUserTransactionEntry = new VideoUserTransactionEntryImpl();

		videoUserTransactionEntry.setNew(true);
		videoUserTransactionEntry.setPrimaryKey(transactionId);

		return videoUserTransactionEntry;
	}

	/**
	 * Removes the video user transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionId the primary key of the video user transaction entry
	 * @return the video user transaction entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry remove(long transactionId)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		return remove(Long.valueOf(transactionId));
	}

	/**
	 * Removes the video user transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video user transaction entry
	 * @return the video user transaction entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserTransactionEntry remove(Serializable primaryKey)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry videoUserTransactionEntry = (VideoUserTransactionEntry)session.get(VideoUserTransactionEntryImpl.class,
					primaryKey);

			if (videoUserTransactionEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoUserTransactionEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoUserTransactionEntry);
		}
		catch (NoSuchVideoUserTransactionEntryException nsee) {
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
	protected VideoUserTransactionEntry removeImpl(
		VideoUserTransactionEntry videoUserTransactionEntry)
		throws SystemException {
		videoUserTransactionEntry = toUnwrappedModel(videoUserTransactionEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoUserTransactionEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoUserTransactionEntry);

		return videoUserTransactionEntry;
	}

	@Override
	public VideoUserTransactionEntry updateImpl(
		vn.com.fis.portal.model.VideoUserTransactionEntry videoUserTransactionEntry,
		boolean merge) throws SystemException {
		videoUserTransactionEntry = toUnwrappedModel(videoUserTransactionEntry);

		boolean isNew = videoUserTransactionEntry.isNew();

		VideoUserTransactionEntryModelImpl videoUserTransactionEntryModelImpl = (VideoUserTransactionEntryModelImpl)videoUserTransactionEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoUserTransactionEntry, merge);

			videoUserTransactionEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!VideoUserTransactionEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoUserTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getOriginalTransactionCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE,
					args);

				args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getTransactionCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE,
					args);
			}

			if ((videoUserTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						videoUserTransactionEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);

				args = new Object[] {
						videoUserTransactionEntryModelImpl.getDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);
			}

			if ((videoUserTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getOriginalTransactionCode()),
						
						videoUserTransactionEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE,
					args);

				args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getTransactionCode()),
						
						videoUserTransactionEntryModelImpl.getDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE,
					args);
			}

			if ((videoUserTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((videoUserTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getOriginalVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID,
					args);

				args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID,
					args);
			}

			if ((videoUserTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getOriginalReceiverId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIVERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID,
					args);

				args = new Object[] {
						Long.valueOf(videoUserTransactionEntryModelImpl.getReceiverId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RECEIVERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserTransactionEntryImpl.class,
			videoUserTransactionEntry.getPrimaryKey(), videoUserTransactionEntry);

		return videoUserTransactionEntry;
	}

	protected VideoUserTransactionEntry toUnwrappedModel(
		VideoUserTransactionEntry videoUserTransactionEntry) {
		if (videoUserTransactionEntry instanceof VideoUserTransactionEntryImpl) {
			return videoUserTransactionEntry;
		}

		VideoUserTransactionEntryImpl videoUserTransactionEntryImpl = new VideoUserTransactionEntryImpl();

		videoUserTransactionEntryImpl.setNew(videoUserTransactionEntry.isNew());
		videoUserTransactionEntryImpl.setPrimaryKey(videoUserTransactionEntry.getPrimaryKey());

		videoUserTransactionEntryImpl.setTransactionId(videoUserTransactionEntry.getTransactionId());
		videoUserTransactionEntryImpl.setTransactionCode(videoUserTransactionEntry.getTransactionCode());
		videoUserTransactionEntryImpl.setDate_(videoUserTransactionEntry.getDate_());
		videoUserTransactionEntryImpl.setVideoId(videoUserTransactionEntry.getVideoId());
		videoUserTransactionEntryImpl.setUserId(videoUserTransactionEntry.getUserId());
		videoUserTransactionEntryImpl.setReceiverId(videoUserTransactionEntry.getReceiverId());

		return videoUserTransactionEntryImpl;
	}

	/**
	 * Returns the video user transaction entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user transaction entry
	 * @return the video user transaction entry
	 * @throws com.liferay.portal.NoSuchModelException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserTransactionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user transaction entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserTransactionEntryException} if it could not be found.
	 *
	 * @param transactionId the primary key of the video user transaction entry
	 * @return the video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByPrimaryKey(long transactionId)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = fetchByPrimaryKey(transactionId);

		if (videoUserTransactionEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + transactionId);
			}

			throw new NoSuchVideoUserTransactionEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				transactionId);
		}

		return videoUserTransactionEntry;
	}

	/**
	 * Returns the video user transaction entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user transaction entry
	 * @return the video user transaction entry, or <code>null</code> if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserTransactionEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user transaction entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transactionId the primary key of the video user transaction entry
	 * @return the video user transaction entry, or <code>null</code> if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry fetchByPrimaryKey(long transactionId)
		throws SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = (VideoUserTransactionEntry)EntityCacheUtil.getResult(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserTransactionEntryImpl.class, transactionId);

		if (videoUserTransactionEntry == _nullVideoUserTransactionEntry) {
			return null;
		}

		if (videoUserTransactionEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoUserTransactionEntry = (VideoUserTransactionEntry)session.get(VideoUserTransactionEntryImpl.class,
						Long.valueOf(transactionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoUserTransactionEntry != null) {
					cacheResult(videoUserTransactionEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoUserTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserTransactionEntryImpl.class, transactionId,
						_nullVideoUserTransactionEntry);
				}

				closeSession(session);
			}
		}

		return videoUserTransactionEntry;
	}

	/**
	 * Returns all the video user transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode) throws SystemException {
		return findByTransactionCode(transactionCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end) throws SystemException {
		return findByTransactionCode(transactionCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode(
		long transactionCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE;
			finderArgs = new Object[] { transactionCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE;
			finderArgs = new Object[] {
					transactionCode,
					
					start, end, orderByComparator
				};
		}

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first video user transaction entry in the ordered set where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByTransactionCode_First(
		long transactionCode, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		List<VideoUserTransactionEntry> list = findByTransactionCode(transactionCode,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user transaction entry in the ordered set where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByTransactionCode_Last(
		long transactionCode, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		int count = countByTransactionCode(transactionCode);

		List<VideoUserTransactionEntry> list = findByTransactionCode(transactionCode,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current video user transaction entry
	 * @param transactionCode the transaction code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry[] findByTransactionCode_PrevAndNext(
		long transactionId, long transactionCode,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry[] array = new VideoUserTransactionEntryImpl[3];

			array[0] = getByTransactionCode_PrevAndNext(session,
					videoUserTransactionEntry, transactionCode,
					orderByComparator, true);

			array[1] = videoUserTransactionEntry;

			array[2] = getByTransactionCode_PrevAndNext(session,
					videoUserTransactionEntry, transactionCode,
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

	protected VideoUserTransactionEntry getByTransactionCode_PrevAndNext(
		Session session, VideoUserTransactionEntry videoUserTransactionEntry,
		long transactionCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2);

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
			query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(transactionCode);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user transaction entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByDate(Date date_)
		throws SystemException {
		return findByDate(date_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByDate(Date date_, int start,
		int end) throws SystemException {
		return findByDate(date_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByDate(Date date_, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date_, start, end, orderByComparator };
		}

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_DATE_DATE__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first video user transaction entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByDate_First(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		List<VideoUserTransactionEntry> list = findByDate(date_, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user transaction entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByDate_Last(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		int count = countByDate(date_);

		List<VideoUserTransactionEntry> list = findByDate(date_, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current video user transaction entry
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry[] findByDate_PrevAndNext(
		long transactionId, Date date_, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry[] array = new VideoUserTransactionEntryImpl[3];

			array[0] = getByDate_PrevAndNext(session,
					videoUserTransactionEntry, date_, orderByComparator, true);

			array[1] = videoUserTransactionEntry;

			array[2] = getByDate_PrevAndNext(session,
					videoUserTransactionEntry, date_, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoUserTransactionEntry getByDate_PrevAndNext(Session session,
		VideoUserTransactionEntry videoUserTransactionEntry, Date date_,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

		if (date_ == null) {
			query.append(_FINDER_COLUMN_DATE_DATE__1);
		}
		else {
			query.append(_FINDER_COLUMN_DATE_DATE__2);
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
			query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, Date date_) throws SystemException {
		return findByTransactionCode_Date(transactionCode, date_,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, Date date_, int start, int end)
		throws SystemException {
		return findByTransactionCode_Date(transactionCode, date_, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByTransactionCode_Date(
		long transactionCode, Date date_, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE;
			finderArgs = new Object[] { transactionCode, date_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE;
			finderArgs = new Object[] {
					transactionCode, date_,
					
					start, end, orderByComparator
				};
		}

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
				}

				list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first video user transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByTransactionCode_Date_First(
		long transactionCode, Date date_, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		List<VideoUserTransactionEntry> list = findByTransactionCode_Date(transactionCode,
				date_, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(", date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByTransactionCode_Date_Last(
		long transactionCode, Date date_, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		int count = countByTransactionCode_Date(transactionCode, date_);

		List<VideoUserTransactionEntry> list = findByTransactionCode_Date(transactionCode,
				date_, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(", date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current video user transaction entry
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry[] findByTransactionCode_Date_PrevAndNext(
		long transactionId, long transactionCode, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry[] array = new VideoUserTransactionEntryImpl[3];

			array[0] = getByTransactionCode_Date_PrevAndNext(session,
					videoUserTransactionEntry, transactionCode, date_,
					orderByComparator, true);

			array[1] = videoUserTransactionEntry;

			array[2] = getByTransactionCode_Date_PrevAndNext(session,
					videoUserTransactionEntry, transactionCode, date_,
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

	protected VideoUserTransactionEntry getByTransactionCode_Date_PrevAndNext(
		Session session, VideoUserTransactionEntry videoUserTransactionEntry,
		long transactionCode, Date date_, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

		if (date_ == null) {
			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1);
		}
		else {
			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2);
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
			query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(transactionCode);

		if (date_ != null) {
			qPos.add(CalendarUtil.getTimestamp(date_));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user transaction entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByUserId(long userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByUserId(long userId, int start,
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

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first video user transaction entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		List<VideoUserTransactionEntry> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user transaction entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		int count = countByUserId(userId);

		List<VideoUserTransactionEntry> list = findByUserId(userId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current video user transaction entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry[] findByUserId_PrevAndNext(
		long transactionId, long userId, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry[] array = new VideoUserTransactionEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session,
					videoUserTransactionEntry, userId, orderByComparator, true);

			array[1] = videoUserTransactionEntry;

			array[2] = getByUserId_PrevAndNext(session,
					videoUserTransactionEntry, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoUserTransactionEntry getByUserId_PrevAndNext(
		Session session, VideoUserTransactionEntry videoUserTransactionEntry,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

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
			query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user transaction entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByVideoId(long videoId)
		throws SystemException {
		return findByVideoId(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByVideoId(long videoId,
		int start, int end) throws SystemException {
		return findByVideoId(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByVideoId(long videoId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID;
			finderArgs = new Object[] { videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID;
			finderArgs = new Object[] { videoId, start, end, orderByComparator };
		}

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first video user transaction entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByVideoId_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		List<VideoUserTransactionEntry> list = findByVideoId(videoId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user transaction entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByVideoId_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		int count = countByVideoId(videoId);

		List<VideoUserTransactionEntry> list = findByVideoId(videoId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current video user transaction entry
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry[] findByVideoId_PrevAndNext(
		long transactionId, long videoId, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry[] array = new VideoUserTransactionEntryImpl[3];

			array[0] = getByVideoId_PrevAndNext(session,
					videoUserTransactionEntry, videoId, orderByComparator, true);

			array[1] = videoUserTransactionEntry;

			array[2] = getByVideoId_PrevAndNext(session,
					videoUserTransactionEntry, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VideoUserTransactionEntry getByVideoId_PrevAndNext(
		Session session, VideoUserTransactionEntry videoUserTransactionEntry,
		long videoId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOID_VIDEOID_2);

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
			query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user transaction entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByreceiverId(long receiverId)
		throws SystemException {
		return findByreceiverId(receiverId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByreceiverId(long receiverId,
		int start, int end) throws SystemException {
		return findByreceiverId(receiverId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findByreceiverId(long receiverId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RECEIVERID;
			finderArgs = new Object[] { receiverId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RECEIVERID;
			finderArgs = new Object[] { receiverId, start, end, orderByComparator };
		}

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_RECEIVERID_RECEIVERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first video user transaction entry in the ordered set where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByreceiverId_First(long receiverId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		List<VideoUserTransactionEntry> list = findByreceiverId(receiverId, 0,
				1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("receiverId=");
			msg.append(receiverId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user transaction entry in the ordered set where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a matching video user transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry findByreceiverId_Last(long receiverId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		int count = countByreceiverId(receiverId);

		List<VideoUserTransactionEntry> list = findByreceiverId(receiverId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("receiverId=");
			msg.append(receiverId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user transaction entries before and after the current video user transaction entry in the ordered set where receiverId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current video user transaction entry
	 * @param receiverId the receiver ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user transaction entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserTransactionEntryException if a video user transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserTransactionEntry[] findByreceiverId_PrevAndNext(
		long transactionId, long receiverId, OrderByComparator orderByComparator)
		throws NoSuchVideoUserTransactionEntryException, SystemException {
		VideoUserTransactionEntry videoUserTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			VideoUserTransactionEntry[] array = new VideoUserTransactionEntryImpl[3];

			array[0] = getByreceiverId_PrevAndNext(session,
					videoUserTransactionEntry, receiverId, orderByComparator,
					true);

			array[1] = videoUserTransactionEntry;

			array[2] = getByreceiverId_PrevAndNext(session,
					videoUserTransactionEntry, receiverId, orderByComparator,
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

	protected VideoUserTransactionEntry getByreceiverId_PrevAndNext(
		Session session, VideoUserTransactionEntry videoUserTransactionEntry,
		long receiverId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_RECEIVERID_RECEIVERID_2);

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
			query.append(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(receiverId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user transaction entries.
	 *
	 * @return the video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user transaction entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @return the range of video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user transaction entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user transaction entries
	 * @param end the upper bound of the range of video user transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserTransactionEntry> findAll(int start, int end,
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

		List<VideoUserTransactionEntry> list = (List<VideoUserTransactionEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOUSERTRANSACTIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOUSERTRANSACTIONENTRY.concat(VideoUserTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoUserTransactionEntry>)QueryUtil.list(q,
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
	 * Removes all the video user transaction entries where transactionCode = &#63; from the database.
	 *
	 * @param transactionCode the transaction code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTransactionCode(long transactionCode)
		throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findByTransactionCode(
				transactionCode)) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Removes all the video user transaction entries where date_ = &#63; from the database.
	 *
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDate(Date date_) throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findByDate(
				date_)) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Removes all the video user transaction entries where transactionCode = &#63; and date_ = &#63; from the database.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTransactionCode_Date(long transactionCode, Date date_)
		throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findByTransactionCode_Date(
				transactionCode, date_)) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Removes all the video user transaction entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findByUserId(
				userId)) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Removes all the video user transaction entries where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId(long videoId) throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findByVideoId(
				videoId)) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Removes all the video user transaction entries where receiverId = &#63; from the database.
	 *
	 * @param receiverId the receiver ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByreceiverId(long receiverId) throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findByreceiverId(
				receiverId)) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Removes all the video user transaction entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoUserTransactionEntry videoUserTransactionEntry : findAll()) {
			remove(videoUserTransactionEntry);
		}
	}

	/**
	 * Returns the number of video user transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTransactionCode(long transactionCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { transactionCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user transaction entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDate(Date date_) throws SystemException {
		Object[] finderArgs = new Object[] { date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_DATE_DATE__2);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTransactionCode_Date(long transactionCode, Date date_)
		throws SystemException {
		Object[] finderArgs = new Object[] { transactionCode, date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user transaction entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE);

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
	 * Returns the number of video user transaction entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId(long videoId) throws SystemException {
		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEOID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user transaction entries where receiverId = &#63;.
	 *
	 * @param receiverId the receiver ID
	 * @return the number of matching video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByreceiverId(long receiverId) throws SystemException {
		Object[] finderArgs = new Object[] { receiverId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_RECEIVERID_RECEIVERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(receiverId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user transaction entries.
	 *
	 * @return the number of video user transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOUSERTRANSACTIONENTRY);

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
	 * Initializes the video user transaction entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.VideoUserTransactionEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoUserTransactionEntry>> listenersList = new ArrayList<ModelListener<VideoUserTransactionEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoUserTransactionEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoUserTransactionEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOUSERTRANSACTIONENTRY = "SELECT videoUserTransactionEntry FROM VideoUserTransactionEntry videoUserTransactionEntry";
	private static final String _SQL_SELECT_VIDEOUSERTRANSACTIONENTRY_WHERE = "SELECT videoUserTransactionEntry FROM VideoUserTransactionEntry videoUserTransactionEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOUSERTRANSACTIONENTRY = "SELECT COUNT(videoUserTransactionEntry) FROM VideoUserTransactionEntry videoUserTransactionEntry";
	private static final String _SQL_COUNT_VIDEOUSERTRANSACTIONENTRY_WHERE = "SELECT COUNT(videoUserTransactionEntry) FROM VideoUserTransactionEntry videoUserTransactionEntry WHERE ";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2 =
		"videoUserTransactionEntry.transactionCode = ?";
	private static final String _FINDER_COLUMN_DATE_DATE__1 = "videoUserTransactionEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_DATE_DATE__2 = "videoUserTransactionEntry.date_ = ?";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2 =
		"videoUserTransactionEntry.transactionCode = ? AND ";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1 = "videoUserTransactionEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2 = "videoUserTransactionEntry.date_ = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "videoUserTransactionEntry.userId = ?";
	private static final String _FINDER_COLUMN_VIDEOID_VIDEOID_2 = "videoUserTransactionEntry.videoId = ?";
	private static final String _FINDER_COLUMN_RECEIVERID_RECEIVERID_2 = "videoUserTransactionEntry.receiverId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoUserTransactionEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoUserTransactionEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoUserTransactionEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoUserTransactionEntryPersistenceImpl.class);
	private static VideoUserTransactionEntry _nullVideoUserTransactionEntry = new VideoUserTransactionEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoUserTransactionEntry> toCacheModel() {
				return _nullVideoUserTransactionEntryCacheModel;
			}
		};

	private static CacheModel<VideoUserTransactionEntry> _nullVideoUserTransactionEntryCacheModel =
		new CacheModel<VideoUserTransactionEntry>() {
			public VideoUserTransactionEntry toEntityModel() {
				return _nullVideoUserTransactionEntry;
			}
		};
}