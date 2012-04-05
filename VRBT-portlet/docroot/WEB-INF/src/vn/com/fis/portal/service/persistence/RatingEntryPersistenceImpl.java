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

import vn.com.fis.portal.NoSuchRatingEntryException;
import vn.com.fis.portal.model.RatingEntry;
import vn.com.fis.portal.model.impl.RatingEntryImpl;
import vn.com.fis.portal.model.impl.RatingEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the rating entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see RatingEntryPersistence
 * @see RatingEntryUtil
 * @generated
 */
public class RatingEntryPersistenceImpl extends BasePersistenceImpl<RatingEntry>
	implements RatingEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RatingEntryUtil} to access the rating entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RatingEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID =
		new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoId",
			new String[] { Long.class.getName() },
			RatingEntryModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOID = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] { Date.class.getName() },
			RatingEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			RatingEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_VIDEOID_USERID = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByVideoId_UserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			RatingEntryModelImpl.VIDEOID_COLUMN_BITMASK |
			RatingEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOID_USERID = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoId_UserId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID_CODE =
		new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoId_Code",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_CODE =
		new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoId_Code",
			new String[] { Long.class.getName(), Integer.class.getName() },
			RatingEntryModelImpl.VIDEOID_COLUMN_BITMASK |
			RatingEntryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOID_CODE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoId_Code",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGCODE =
		new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRatingCode",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCODE =
		new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRatingCode",
			new String[] { Integer.class.getName() },
			RatingEntryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RATINGCODE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRatingCode",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_USER_VIDEO_CODE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUser_Video_Code",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			RatingEntryModelImpl.USERID_COLUMN_BITMASK |
			RatingEntryModelImpl.VIDEOID_COLUMN_BITMASK |
			RatingEntryModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER_VIDEO_CODE = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUser_Video_Code",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, RatingEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the rating entry in the entity cache if it is enabled.
	 *
	 * @param ratingEntry the rating entry
	 */
	public void cacheResult(RatingEntry ratingEntry) {
		EntityCacheUtil.putResult(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryImpl.class, ratingEntry.getPrimaryKey(), ratingEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
			new Object[] {
				Long.valueOf(ratingEntry.getVideoId()),
				Long.valueOf(ratingEntry.getUserId())
			}, ratingEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
			new Object[] {
				Long.valueOf(ratingEntry.getUserId()),
				Long.valueOf(ratingEntry.getVideoId()),
				Integer.valueOf(ratingEntry.getCode())
			}, ratingEntry);

		ratingEntry.resetOriginalValues();
	}

	/**
	 * Caches the rating entries in the entity cache if it is enabled.
	 *
	 * @param ratingEntries the rating entries
	 */
	public void cacheResult(List<RatingEntry> ratingEntries) {
		for (RatingEntry ratingEntry : ratingEntries) {
			if (EntityCacheUtil.getResult(
						RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
						RatingEntryImpl.class, ratingEntry.getPrimaryKey()) == null) {
				cacheResult(ratingEntry);
			}
			else {
				ratingEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rating entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RatingEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RatingEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rating entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RatingEntry ratingEntry) {
		EntityCacheUtil.removeResult(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryImpl.class, ratingEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ratingEntry);
	}

	@Override
	public void clearCache(List<RatingEntry> ratingEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RatingEntry ratingEntry : ratingEntries) {
			EntityCacheUtil.removeResult(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
				RatingEntryImpl.class, ratingEntry.getPrimaryKey());

			clearUniqueFindersCache(ratingEntry);
		}
	}

	protected void clearUniqueFindersCache(RatingEntry ratingEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
			new Object[] {
				Long.valueOf(ratingEntry.getVideoId()),
				Long.valueOf(ratingEntry.getUserId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
			new Object[] {
				Long.valueOf(ratingEntry.getUserId()),
				Long.valueOf(ratingEntry.getVideoId()),
				Integer.valueOf(ratingEntry.getCode())
			});
	}

	/**
	 * Creates a new rating entry with the primary key. Does not add the rating entry to the database.
	 *
	 * @param ratingId the primary key for the new rating entry
	 * @return the new rating entry
	 */
	public RatingEntry create(long ratingId) {
		RatingEntry ratingEntry = new RatingEntryImpl();

		ratingEntry.setNew(true);
		ratingEntry.setPrimaryKey(ratingId);

		return ratingEntry;
	}

	/**
	 * Removes the rating entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ratingId the primary key of the rating entry
	 * @return the rating entry that was removed
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry remove(long ratingId)
		throws NoSuchRatingEntryException, SystemException {
		return remove(Long.valueOf(ratingId));
	}

	/**
	 * Removes the rating entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rating entry
	 * @return the rating entry that was removed
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingEntry remove(Serializable primaryKey)
		throws NoSuchRatingEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RatingEntry ratingEntry = (RatingEntry)session.get(RatingEntryImpl.class,
					primaryKey);

			if (ratingEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRatingEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ratingEntry);
		}
		catch (NoSuchRatingEntryException nsee) {
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
	protected RatingEntry removeImpl(RatingEntry ratingEntry)
		throws SystemException {
		ratingEntry = toUnwrappedModel(ratingEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ratingEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ratingEntry);

		return ratingEntry;
	}

	@Override
	public RatingEntry updateImpl(
		vn.com.fis.portal.model.RatingEntry ratingEntry, boolean merge)
		throws SystemException {
		ratingEntry = toUnwrappedModel(ratingEntry);

		boolean isNew = ratingEntry.isNew();

		RatingEntryModelImpl ratingEntryModelImpl = (RatingEntryModelImpl)ratingEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ratingEntry, merge);

			ratingEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RatingEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getOriginalVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID,
					args);

				args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID,
					args);
			}

			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ratingEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);

				args = new Object[] { ratingEntryModelImpl.getDate_() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);
			}

			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getOriginalVideoId()),
						Integer.valueOf(ratingEntryModelImpl.getOriginalCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID_CODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_CODE,
					args);

				args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getVideoId()),
						Integer.valueOf(ratingEntryModelImpl.getCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID_CODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_CODE,
					args);
			}

			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(ratingEntryModelImpl.getOriginalCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCODE,
					args);

				args = new Object[] {
						Integer.valueOf(ratingEntryModelImpl.getCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RATINGCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
			RatingEntryImpl.class, ratingEntry.getPrimaryKey(), ratingEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
				new Object[] {
					Long.valueOf(ratingEntry.getVideoId()),
					Long.valueOf(ratingEntry.getUserId())
				}, ratingEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
				new Object[] {
					Long.valueOf(ratingEntry.getUserId()),
					Long.valueOf(ratingEntry.getVideoId()),
					Integer.valueOf(ratingEntry.getCode())
				}, ratingEntry);
		}
		else {
			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VIDEOID_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getOriginalVideoId()),
						Long.valueOf(ratingEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID_USERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
					new Object[] {
						Long.valueOf(ratingEntry.getVideoId()),
						Long.valueOf(ratingEntry.getUserId())
					}, ratingEntry);
			}

			if ((ratingEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USER_VIDEO_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(ratingEntryModelImpl.getOriginalUserId()),
						Long.valueOf(ratingEntryModelImpl.getOriginalVideoId()),
						Integer.valueOf(ratingEntryModelImpl.getOriginalCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER_VIDEO_CODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
					new Object[] {
						Long.valueOf(ratingEntry.getUserId()),
						Long.valueOf(ratingEntry.getVideoId()),
						Integer.valueOf(ratingEntry.getCode())
					}, ratingEntry);
			}
		}

		return ratingEntry;
	}

	protected RatingEntry toUnwrappedModel(RatingEntry ratingEntry) {
		if (ratingEntry instanceof RatingEntryImpl) {
			return ratingEntry;
		}

		RatingEntryImpl ratingEntryImpl = new RatingEntryImpl();

		ratingEntryImpl.setNew(ratingEntry.isNew());
		ratingEntryImpl.setPrimaryKey(ratingEntry.getPrimaryKey());

		ratingEntryImpl.setRatingId(ratingEntry.getRatingId());
		ratingEntryImpl.setVideoId(ratingEntry.getVideoId());
		ratingEntryImpl.setUserId(ratingEntry.getUserId());
		ratingEntryImpl.setCode(ratingEntry.getCode());
		ratingEntryImpl.setDate_(ratingEntry.getDate_());

		return ratingEntryImpl;
	}

	/**
	 * Returns the rating entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating entry
	 * @return the rating entry
	 * @throws com.liferay.portal.NoSuchModelException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the rating entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	 *
	 * @param ratingId the primary key of the rating entry
	 * @return the rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByPrimaryKey(long ratingId)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = fetchByPrimaryKey(ratingId);

		if (ratingEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ratingId);
			}

			throw new NoSuchRatingEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ratingId);
		}

		return ratingEntry;
	}

	/**
	 * Returns the rating entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rating entry
	 * @return the rating entry, or <code>null</code> if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RatingEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the rating entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ratingId the primary key of the rating entry
	 * @return the rating entry, or <code>null</code> if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry fetchByPrimaryKey(long ratingId)
		throws SystemException {
		RatingEntry ratingEntry = (RatingEntry)EntityCacheUtil.getResult(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
				RatingEntryImpl.class, ratingId);

		if (ratingEntry == _nullRatingEntry) {
			return null;
		}

		if (ratingEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ratingEntry = (RatingEntry)session.get(RatingEntryImpl.class,
						Long.valueOf(ratingId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ratingEntry != null) {
					cacheResult(ratingEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(RatingEntryModelImpl.ENTITY_CACHE_ENABLED,
						RatingEntryImpl.class, ratingId, _nullRatingEntry);
				}

				closeSession(session);
			}
		}

		return ratingEntry;
	}

	/**
	 * Returns all the rating entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId(long videoId)
		throws SystemException {
		return findByVideoId(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId(long videoId, int start, int end)
		throws SystemException {
		return findByVideoId(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId(long videoId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<RatingEntry> list = (List<RatingEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByVideoId_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		List<RatingEntry> list = findByVideoId(videoId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last rating entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByVideoId_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		int count = countByVideoId(videoId);

		List<RatingEntry> list = findByVideoId(videoId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the rating entries before and after the current rating entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ratingId the primary key of the current rating entry
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry[] findByVideoId_PrevAndNext(long ratingId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByPrimaryKey(ratingId);

		Session session = null;

		try {
			session = openSession();

			RatingEntry[] array = new RatingEntryImpl[3];

			array[0] = getByVideoId_PrevAndNext(session, ratingEntry, videoId,
					orderByComparator, true);

			array[1] = ratingEntry;

			array[2] = getByVideoId_PrevAndNext(session, ratingEntry, videoId,
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

	protected RatingEntry getByVideoId_PrevAndNext(Session session,
		RatingEntry ratingEntry, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGENTRY_WHERE);

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
			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the rating entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByDate(Date date_) throws SystemException {
		return findByDate(date_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByDate(Date date_, int start, int end)
		throws SystemException {
		return findByDate(date_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByDate(Date date_, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<RatingEntry> list = (List<RatingEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

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
				query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByDate_First(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		List<RatingEntry> list = findByDate(date_, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last rating entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByDate_Last(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		int count = countByDate(date_);

		List<RatingEntry> list = findByDate(date_, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the rating entries before and after the current rating entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ratingId the primary key of the current rating entry
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry[] findByDate_PrevAndNext(long ratingId, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByPrimaryKey(ratingId);

		Session session = null;

		try {
			session = openSession();

			RatingEntry[] array = new RatingEntryImpl[3];

			array[0] = getByDate_PrevAndNext(session, ratingEntry, date_,
					orderByComparator, true);

			array[1] = ratingEntry;

			array[2] = getByDate_PrevAndNext(session, ratingEntry, date_,
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

	protected RatingEntry getByDate_PrevAndNext(Session session,
		RatingEntry ratingEntry, Date date_,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGENTRY_WHERE);

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
			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(ratingEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the rating entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<RatingEntry> list = (List<RatingEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		List<RatingEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last rating entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		int count = countByUserId(userId);

		List<RatingEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the rating entries before and after the current rating entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ratingId the primary key of the current rating entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry[] findByUserId_PrevAndNext(long ratingId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByPrimaryKey(ratingId);

		Session session = null;

		try {
			session = openSession();

			RatingEntry[] array = new RatingEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, ratingEntry, userId,
					orderByComparator, true);

			array[1] = ratingEntry;

			array[2] = getByUserId_PrevAndNext(session, ratingEntry, userId,
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

	protected RatingEntry getByUserId_PrevAndNext(Session session,
		RatingEntry ratingEntry, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGENTRY_WHERE);

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
			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the rating entry where videoId = &#63; and userId = &#63; or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByVideoId_UserId(long videoId, long userId)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = fetchByVideoId_UserId(videoId, userId);

		if (ratingEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRatingEntryException(msg.toString());
		}

		return ratingEntry;
	}

	/**
	 * Returns the rating entry where videoId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the matching rating entry, or <code>null</code> if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry fetchByVideoId_UserId(long videoId, long userId)
		throws SystemException {
		return fetchByVideoId_UserId(videoId, userId, true);
	}

	/**
	 * Returns the rating entry where videoId = &#63; and userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rating entry, or <code>null</code> if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry fetchByVideoId_UserId(long videoId, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { videoId, userId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_USERID_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOID_USERID_USERID_2);

			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(userId);

				List<RatingEntry> list = q.list();

				result = list;

				RatingEntry ratingEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
						finderArgs, list);
				}
				else {
					ratingEntry = list.get(0);

					cacheResult(ratingEntry);

					if ((ratingEntry.getVideoId() != videoId) ||
							(ratingEntry.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
							finderArgs, ratingEntry);
					}
				}

				return ratingEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VIDEOID_USERID,
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
				return (RatingEntry)result;
			}
		}
	}

	/**
	 * Returns all the rating entries where videoId = &#63; and code = &#63;.
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId_Code(long videoId, int code)
		throws SystemException {
		return findByVideoId_Code(videoId, code, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating entries where videoId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId_Code(long videoId, int code,
		int start, int end) throws SystemException {
		return findByVideoId_Code(videoId, code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating entries where videoId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByVideoId_Code(long videoId, int code,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID_CODE;
			finderArgs = new Object[] { videoId, code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID_CODE;
			finderArgs = new Object[] {
					videoId, code,
					
					start, end, orderByComparator
				};
		}

		List<RatingEntry> list = (List<RatingEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_CODE_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOID_CODE_CODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(code);

				list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating entry in the ordered set where videoId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByVideoId_Code_First(long videoId, int code,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		List<RatingEntry> list = findByVideoId_Code(videoId, code, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last rating entry in the ordered set where videoId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByVideoId_Code_Last(long videoId, int code,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		int count = countByVideoId_Code(videoId, code);

		List<RatingEntry> list = findByVideoId_Code(videoId, code, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the rating entries before and after the current rating entry in the ordered set where videoId = &#63; and code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ratingId the primary key of the current rating entry
	 * @param videoId the video ID
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry[] findByVideoId_Code_PrevAndNext(long ratingId,
		long videoId, int code, OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByPrimaryKey(ratingId);

		Session session = null;

		try {
			session = openSession();

			RatingEntry[] array = new RatingEntryImpl[3];

			array[0] = getByVideoId_Code_PrevAndNext(session, ratingEntry,
					videoId, code, orderByComparator, true);

			array[1] = ratingEntry;

			array[2] = getByVideoId_Code_PrevAndNext(session, ratingEntry,
					videoId, code, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RatingEntry getByVideoId_Code_PrevAndNext(Session session,
		RatingEntry ratingEntry, long videoId, int code,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGENTRY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOID_CODE_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOID_CODE_CODE_2);

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
			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(code);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the rating entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByRatingCode(int code)
		throws SystemException {
		return findByRatingCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByRatingCode(int code, int start, int end)
		throws SystemException {
		return findByRatingCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating entries where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findByRatingCode(int code, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RATINGCODE;
			finderArgs = new Object[] { code };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RATINGCODE;
			finderArgs = new Object[] { code, start, end, orderByComparator };
		}

		List<RatingEntry> list = (List<RatingEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_RATINGCODE_CODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(code);

				list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first rating entry in the ordered set where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByRatingCode_First(int code,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		List<RatingEntry> list = findByRatingCode(code, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last rating entry in the ordered set where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByRatingCode_Last(int code,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		int count = countByRatingCode(code);

		List<RatingEntry> list = findByRatingCode(code, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchRatingEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the rating entries before and after the current rating entry in the ordered set where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param ratingId the primary key of the current rating entry
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a rating entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry[] findByRatingCode_PrevAndNext(long ratingId, int code,
		OrderByComparator orderByComparator)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByPrimaryKey(ratingId);

		Session session = null;

		try {
			session = openSession();

			RatingEntry[] array = new RatingEntryImpl[3];

			array[0] = getByRatingCode_PrevAndNext(session, ratingEntry, code,
					orderByComparator, true);

			array[1] = ratingEntry;

			array[2] = getByRatingCode_PrevAndNext(session, ratingEntry, code,
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

	protected RatingEntry getByRatingCode_PrevAndNext(Session session,
		RatingEntry ratingEntry, int code, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RATINGENTRY_WHERE);

		query.append(_FINDER_COLUMN_RATINGCODE_CODE_2);

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
			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(code);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ratingEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RatingEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or throws a {@link vn.com.fis.portal.NoSuchRatingEntryException} if it could not be found.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @return the matching rating entry
	 * @throws vn.com.fis.portal.NoSuchRatingEntryException if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry findByUser_Video_Code(long userId, long videoId, int code)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = fetchByUser_Video_Code(userId, videoId, code);

		if (ratingEntry == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(", code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRatingEntryException(msg.toString());
		}

		return ratingEntry;
	}

	/**
	 * Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @return the matching rating entry, or <code>null</code> if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry fetchByUser_Video_Code(long userId, long videoId,
		int code) throws SystemException {
		return fetchByUser_Video_Code(userId, videoId, code, true);
	}

	/**
	 * Returns the rating entry where userId = &#63; and videoId = &#63; and code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rating entry, or <code>null</code> if a matching rating entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public RatingEntry fetchByUser_Video_Code(long userId, long videoId,
		int code, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { userId, videoId, code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_USER_VIDEO_CODE_USERID_2);

			query.append(_FINDER_COLUMN_USER_VIDEO_CODE_VIDEOID_2);

			query.append(_FINDER_COLUMN_USER_VIDEO_CODE_CODE_2);

			query.append(RatingEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(videoId);

				qPos.add(code);

				List<RatingEntry> list = q.list();

				result = list;

				RatingEntry ratingEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
						finderArgs, list);
				}
				else {
					ratingEntry = list.get(0);

					cacheResult(ratingEntry);

					if ((ratingEntry.getUserId() != userId) ||
							(ratingEntry.getVideoId() != videoId) ||
							(ratingEntry.getCode() != code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
							finderArgs, ratingEntry);
					}
				}

				return ratingEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USER_VIDEO_CODE,
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
				return (RatingEntry)result;
			}
		}
	}

	/**
	 * Returns all the rating entries.
	 *
	 * @return the rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rating entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @return the range of rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rating entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of rating entries
	 * @param end the upper bound of the range of rating entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<RatingEntry> findAll(int start, int end,
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

		List<RatingEntry> list = (List<RatingEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RATINGENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RATINGENTRY.concat(RatingEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<RatingEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rating entries where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId(long videoId) throws SystemException {
		for (RatingEntry ratingEntry : findByVideoId(videoId)) {
			remove(ratingEntry);
		}
	}

	/**
	 * Removes all the rating entries where date_ = &#63; from the database.
	 *
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDate(Date date_) throws SystemException {
		for (RatingEntry ratingEntry : findByDate(date_)) {
			remove(ratingEntry);
		}
	}

	/**
	 * Removes all the rating entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (RatingEntry ratingEntry : findByUserId(userId)) {
			remove(ratingEntry);
		}
	}

	/**
	 * Removes the rating entry where videoId = &#63; and userId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId_UserId(long videoId, long userId)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByVideoId_UserId(videoId, userId);

		remove(ratingEntry);
	}

	/**
	 * Removes all the rating entries where videoId = &#63; and code = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId_Code(long videoId, int code)
		throws SystemException {
		for (RatingEntry ratingEntry : findByVideoId_Code(videoId, code)) {
			remove(ratingEntry);
		}
	}

	/**
	 * Removes all the rating entries where code = &#63; from the database.
	 *
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRatingCode(int code) throws SystemException {
		for (RatingEntry ratingEntry : findByRatingCode(code)) {
			remove(ratingEntry);
		}
	}

	/**
	 * Removes the rating entry where userId = &#63; and videoId = &#63; and code = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUser_Video_Code(long userId, long videoId, int code)
		throws NoSuchRatingEntryException, SystemException {
		RatingEntry ratingEntry = findByUser_Video_Code(userId, videoId, code);

		remove(ratingEntry);
	}

	/**
	 * Removes all the rating entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (RatingEntry ratingEntry : findAll()) {
			remove(ratingEntry);
		}
	}

	/**
	 * Returns the number of rating entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId(long videoId) throws SystemException {
		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

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
	 * Returns the number of rating entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDate(Date date_) throws SystemException {
		Object[] finderArgs = new Object[] { date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

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
	 * Returns the number of rating entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

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
	 * Returns the number of rating entries where videoId = &#63; and userId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param userId the user ID
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId_UserId(long videoId, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoId, userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOID_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

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
	 * Returns the number of rating entries where videoId = &#63; and code = &#63;.
	 *
	 * @param videoId the video ID
	 * @param code the code
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId_Code(long videoId, int code)
		throws SystemException {
		Object[] finderArgs = new Object[] { videoId, code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOID_CODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_CODE_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOID_CODE_CODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(code);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEOID_CODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of rating entries where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRatingCode(int code) throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RATINGCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_RATINGCODE_CODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(code);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RATINGCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of rating entries where userId = &#63; and videoId = &#63; and code = &#63;.
	 *
	 * @param userId the user ID
	 * @param videoId the video ID
	 * @param code the code
	 * @return the number of matching rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUser_Video_Code(long userId, long videoId, int code)
		throws SystemException {
		Object[] finderArgs = new Object[] { userId, videoId, code };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USER_VIDEO_CODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_RATINGENTRY_WHERE);

			query.append(_FINDER_COLUMN_USER_VIDEO_CODE_USERID_2);

			query.append(_FINDER_COLUMN_USER_VIDEO_CODE_VIDEOID_2);

			query.append(_FINDER_COLUMN_USER_VIDEO_CODE_CODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(videoId);

				qPos.add(code);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USER_VIDEO_CODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of rating entries.
	 *
	 * @return the number of rating entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RATINGENTRY);

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
	 * Initializes the rating entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.RatingEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RatingEntry>> listenersList = new ArrayList<ModelListener<RatingEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RatingEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RatingEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_RATINGENTRY = "SELECT ratingEntry FROM RatingEntry ratingEntry";
	private static final String _SQL_SELECT_RATINGENTRY_WHERE = "SELECT ratingEntry FROM RatingEntry ratingEntry WHERE ";
	private static final String _SQL_COUNT_RATINGENTRY = "SELECT COUNT(ratingEntry) FROM RatingEntry ratingEntry";
	private static final String _SQL_COUNT_RATINGENTRY_WHERE = "SELECT COUNT(ratingEntry) FROM RatingEntry ratingEntry WHERE ";
	private static final String _FINDER_COLUMN_VIDEOID_VIDEOID_2 = "ratingEntry.videoId = ?";
	private static final String _FINDER_COLUMN_DATE_DATE__1 = "ratingEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_DATE_DATE__2 = "ratingEntry.date_ = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "ratingEntry.userId = ?";
	private static final String _FINDER_COLUMN_VIDEOID_USERID_VIDEOID_2 = "ratingEntry.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOID_USERID_USERID_2 = "ratingEntry.userId = ?";
	private static final String _FINDER_COLUMN_VIDEOID_CODE_VIDEOID_2 = "ratingEntry.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOID_CODE_CODE_2 = "ratingEntry.code = ?";
	private static final String _FINDER_COLUMN_RATINGCODE_CODE_2 = "ratingEntry.code = ?";
	private static final String _FINDER_COLUMN_USER_VIDEO_CODE_USERID_2 = "ratingEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USER_VIDEO_CODE_VIDEOID_2 = "ratingEntry.videoId = ? AND ";
	private static final String _FINDER_COLUMN_USER_VIDEO_CODE_CODE_2 = "ratingEntry.code = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ratingEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RatingEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RatingEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RatingEntryPersistenceImpl.class);
	private static RatingEntry _nullRatingEntry = new RatingEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RatingEntry> toCacheModel() {
				return _nullRatingEntryCacheModel;
			}
		};

	private static CacheModel<RatingEntry> _nullRatingEntryCacheModel = new CacheModel<RatingEntry>() {
			public RatingEntry toEntityModel() {
				return _nullRatingEntry;
			}
		};
}