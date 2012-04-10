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

import vn.com.fis.portal.NoSuchCategoryVideoEntryException;
import vn.com.fis.portal.model.CategoryVideoEntry;
import vn.com.fis.portal.model.impl.CategoryVideoEntryImpl;
import vn.com.fis.portal.model.impl.CategoryVideoEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the category video entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see CategoryVideoEntryPersistence
 * @see CategoryVideoEntryUtil
 * @generated
 */
public class CategoryVideoEntryPersistenceImpl extends BasePersistenceImpl<CategoryVideoEntry>
	implements CategoryVideoEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryVideoEntryUtil} to access the category video entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryVideoEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_V = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_V",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_V = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_V",
			new String[] { Long.class.getName(), Long.class.getName() },
			CategoryVideoEntryModelImpl.CATEGORYID_COLUMN_BITMASK |
			CategoryVideoEntryModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_V = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_V",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOID = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID =
		new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoId",
			new String[] { Long.class.getName() },
			CategoryVideoEntryModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOID = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] { Long.class.getName() },
			CategoryVideoEntryModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryVideoEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the category video entry in the entity cache if it is enabled.
	 *
	 * @param categoryVideoEntry the category video entry
	 */
	public void cacheResult(CategoryVideoEntry categoryVideoEntry) {
		EntityCacheUtil.putResult(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryImpl.class, categoryVideoEntry.getPrimaryKey(),
			categoryVideoEntry);

		categoryVideoEntry.resetOriginalValues();
	}

	/**
	 * Caches the category video entries in the entity cache if it is enabled.
	 *
	 * @param categoryVideoEntries the category video entries
	 */
	public void cacheResult(List<CategoryVideoEntry> categoryVideoEntries) {
		for (CategoryVideoEntry categoryVideoEntry : categoryVideoEntries) {
			if (EntityCacheUtil.getResult(
						CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryVideoEntryImpl.class,
						categoryVideoEntry.getPrimaryKey()) == null) {
				cacheResult(categoryVideoEntry);
			}
			else {
				categoryVideoEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all category video entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoryVideoEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoryVideoEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category video entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryVideoEntry categoryVideoEntry) {
		EntityCacheUtil.removeResult(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryImpl.class, categoryVideoEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CategoryVideoEntry> categoryVideoEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoryVideoEntry categoryVideoEntry : categoryVideoEntries) {
			EntityCacheUtil.removeResult(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryVideoEntryImpl.class, categoryVideoEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new category video entry with the primary key. Does not add the category video entry to the database.
	 *
	 * @param categoryViceoId the primary key for the new category video entry
	 * @return the new category video entry
	 */
	public CategoryVideoEntry create(long categoryViceoId) {
		CategoryVideoEntry categoryVideoEntry = new CategoryVideoEntryImpl();

		categoryVideoEntry.setNew(true);
		categoryVideoEntry.setPrimaryKey(categoryViceoId);

		return categoryVideoEntry;
	}

	/**
	 * Removes the category video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryViceoId the primary key of the category video entry
	 * @return the category video entry that was removed
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry remove(long categoryViceoId)
		throws NoSuchCategoryVideoEntryException, SystemException {
		return remove(Long.valueOf(categoryViceoId));
	}

	/**
	 * Removes the category video entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category video entry
	 * @return the category video entry that was removed
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryVideoEntry remove(Serializable primaryKey)
		throws NoSuchCategoryVideoEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CategoryVideoEntry categoryVideoEntry = (CategoryVideoEntry)session.get(CategoryVideoEntryImpl.class,
					primaryKey);

			if (categoryVideoEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoryVideoEntry);
		}
		catch (NoSuchCategoryVideoEntryException nsee) {
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
	protected CategoryVideoEntry removeImpl(
		CategoryVideoEntry categoryVideoEntry) throws SystemException {
		categoryVideoEntry = toUnwrappedModel(categoryVideoEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, categoryVideoEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(categoryVideoEntry);

		return categoryVideoEntry;
	}

	@Override
	public CategoryVideoEntry updateImpl(
		vn.com.fis.portal.model.CategoryVideoEntry categoryVideoEntry,
		boolean merge) throws SystemException {
		categoryVideoEntry = toUnwrappedModel(categoryVideoEntry);

		boolean isNew = categoryVideoEntry.isNew();

		CategoryVideoEntryModelImpl categoryVideoEntryModelImpl = (CategoryVideoEntryModelImpl)categoryVideoEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, categoryVideoEntry, merge);

			categoryVideoEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CategoryVideoEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((categoryVideoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_V.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(categoryVideoEntryModelImpl.getOriginalCategoryId()),
						Long.valueOf(categoryVideoEntryModelImpl.getOriginalVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_V,
					args);

				args = new Object[] {
						Long.valueOf(categoryVideoEntryModelImpl.getCategoryId()),
						Long.valueOf(categoryVideoEntryModelImpl.getVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_V, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_V,
					args);
			}

			if ((categoryVideoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(categoryVideoEntryModelImpl.getOriginalVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID,
					args);

				args = new Object[] {
						Long.valueOf(categoryVideoEntryModelImpl.getVideoId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOID,
					args);
			}

			if ((categoryVideoEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(categoryVideoEntryModelImpl.getOriginalCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] {
						Long.valueOf(categoryVideoEntryModelImpl.getCategoryId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryVideoEntryImpl.class, categoryVideoEntry.getPrimaryKey(),
			categoryVideoEntry);

		return categoryVideoEntry;
	}

	protected CategoryVideoEntry toUnwrappedModel(
		CategoryVideoEntry categoryVideoEntry) {
		if (categoryVideoEntry instanceof CategoryVideoEntryImpl) {
			return categoryVideoEntry;
		}

		CategoryVideoEntryImpl categoryVideoEntryImpl = new CategoryVideoEntryImpl();

		categoryVideoEntryImpl.setNew(categoryVideoEntry.isNew());
		categoryVideoEntryImpl.setPrimaryKey(categoryVideoEntry.getPrimaryKey());

		categoryVideoEntryImpl.setCategoryViceoId(categoryVideoEntry.getCategoryViceoId());
		categoryVideoEntryImpl.setCategoryId(categoryVideoEntry.getCategoryId());
		categoryVideoEntryImpl.setVideoId(categoryVideoEntry.getVideoId());

		return categoryVideoEntryImpl;
	}

	/**
	 * Returns the category video entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category video entry
	 * @return the category video entry
	 * @throws com.liferay.portal.NoSuchModelException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryVideoEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the category video entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchCategoryVideoEntryException} if it could not be found.
	 *
	 * @param categoryViceoId the primary key of the category video entry
	 * @return the category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByPrimaryKey(long categoryViceoId)
		throws NoSuchCategoryVideoEntryException, SystemException {
		CategoryVideoEntry categoryVideoEntry = fetchByPrimaryKey(categoryViceoId);

		if (categoryVideoEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryViceoId);
			}

			throw new NoSuchCategoryVideoEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryViceoId);
		}

		return categoryVideoEntry;
	}

	/**
	 * Returns the category video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category video entry
	 * @return the category video entry, or <code>null</code> if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryVideoEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the category video entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryViceoId the primary key of the category video entry
	 * @return the category video entry, or <code>null</code> if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry fetchByPrimaryKey(long categoryViceoId)
		throws SystemException {
		CategoryVideoEntry categoryVideoEntry = (CategoryVideoEntry)EntityCacheUtil.getResult(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryVideoEntryImpl.class, categoryViceoId);

		if (categoryVideoEntry == _nullCategoryVideoEntry) {
			return null;
		}

		if (categoryVideoEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				categoryVideoEntry = (CategoryVideoEntry)session.get(CategoryVideoEntryImpl.class,
						Long.valueOf(categoryViceoId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (categoryVideoEntry != null) {
					cacheResult(categoryVideoEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CategoryVideoEntryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryVideoEntryImpl.class, categoryViceoId,
						_nullCategoryVideoEntry);
				}

				closeSession(session);
			}
		}

		return categoryVideoEntry;
	}

	/**
	 * Returns all the category video entries where categoryId = &#63; and videoId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @return the matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByC_V(long categoryId, long videoId)
		throws SystemException {
		return findByC_V(categoryId, videoId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category video entries where categoryId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @return the range of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByC_V(long categoryId, long videoId,
		int start, int end) throws SystemException {
		return findByC_V(categoryId, videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category video entries where categoryId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByC_V(long categoryId, long videoId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_V;
			finderArgs = new Object[] { categoryId, videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_V;
			finderArgs = new Object[] {
					categoryId, videoId,
					
					start, end, orderByComparator
				};
		}

		List<CategoryVideoEntry> list = (List<CategoryVideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CATEGORYVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_V_CATEGORYID_2);

			query.append(_FINDER_COLUMN_C_V_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(videoId);

				list = (List<CategoryVideoEntry>)QueryUtil.list(q,
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
	 * Returns the first category video entry in the ordered set where categoryId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByC_V_First(long categoryId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		List<CategoryVideoEntry> list = findByC_V(categoryId, videoId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last category video entry in the ordered set where categoryId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByC_V_Last(long categoryId, long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		int count = countByC_V(categoryId, videoId);

		List<CategoryVideoEntry> list = findByC_V(categoryId, videoId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(", videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the category video entries before and after the current category video entry in the ordered set where categoryId = &#63; and videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryViceoId the primary key of the current category video entry
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry[] findByC_V_PrevAndNext(long categoryViceoId,
		long categoryId, long videoId, OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		CategoryVideoEntry categoryVideoEntry = findByPrimaryKey(categoryViceoId);

		Session session = null;

		try {
			session = openSession();

			CategoryVideoEntry[] array = new CategoryVideoEntryImpl[3];

			array[0] = getByC_V_PrevAndNext(session, categoryVideoEntry,
					categoryId, videoId, orderByComparator, true);

			array[1] = categoryVideoEntry;

			array[2] = getByC_V_PrevAndNext(session, categoryVideoEntry,
					categoryId, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryVideoEntry getByC_V_PrevAndNext(Session session,
		CategoryVideoEntry categoryVideoEntry, long categoryId, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORYVIDEOENTRY_WHERE);

		query.append(_FINDER_COLUMN_C_V_CATEGORYID_2);

		query.append(_FINDER_COLUMN_C_V_VIDEOID_2);

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
			query.append(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(categoryVideoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryVideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the category video entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByVideoId(long videoId)
		throws SystemException {
		return findByVideoId(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category video entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @return the range of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByVideoId(long videoId, int start,
		int end) throws SystemException {
		return findByVideoId(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category video entries where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByVideoId(long videoId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<CategoryVideoEntry> list = (List<CategoryVideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CATEGORYVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOID_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				list = (List<CategoryVideoEntry>)QueryUtil.list(q,
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
	 * Returns the first category video entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByVideoId_First(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		List<CategoryVideoEntry> list = findByVideoId(videoId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last category video entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByVideoId_Last(long videoId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		int count = countByVideoId(videoId);

		List<CategoryVideoEntry> list = findByVideoId(videoId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoId=");
			msg.append(videoId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the category video entries before and after the current category video entry in the ordered set where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryViceoId the primary key of the current category video entry
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry[] findByVideoId_PrevAndNext(
		long categoryViceoId, long videoId, OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		CategoryVideoEntry categoryVideoEntry = findByPrimaryKey(categoryViceoId);

		Session session = null;

		try {
			session = openSession();

			CategoryVideoEntry[] array = new CategoryVideoEntryImpl[3];

			array[0] = getByVideoId_PrevAndNext(session, categoryVideoEntry,
					videoId, orderByComparator, true);

			array[1] = categoryVideoEntry;

			array[2] = getByVideoId_PrevAndNext(session, categoryVideoEntry,
					videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryVideoEntry getByVideoId_PrevAndNext(Session session,
		CategoryVideoEntry categoryVideoEntry, long videoId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORYVIDEOENTRY_WHERE);

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
			query.append(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(categoryVideoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryVideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the category video entries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByCategoryId(long categoryId)
		throws SystemException {
		return findByCategoryId(categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category video entries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @return the range of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByCategoryId(long categoryId,
		int start, int end) throws SystemException {
		return findByCategoryId(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category video entries where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findByCategoryId(long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<CategoryVideoEntry> list = (List<CategoryVideoEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CATEGORYVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<CategoryVideoEntry>)QueryUtil.list(q,
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
	 * Returns the first category video entry in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		List<CategoryVideoEntry> list = findByCategoryId(categoryId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last category video entry in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a matching category video entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry findByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		int count = countByCategoryId(categoryId);

		List<CategoryVideoEntry> list = findByCategoryId(categoryId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryVideoEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the category video entries before and after the current category video entry in the ordered set where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryViceoId the primary key of the current category video entry
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category video entry
	 * @throws vn.com.fis.portal.NoSuchCategoryVideoEntryException if a category video entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryVideoEntry[] findByCategoryId_PrevAndNext(
		long categoryViceoId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryVideoEntryException, SystemException {
		CategoryVideoEntry categoryVideoEntry = findByPrimaryKey(categoryViceoId);

		Session session = null;

		try {
			session = openSession();

			CategoryVideoEntry[] array = new CategoryVideoEntryImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session, categoryVideoEntry,
					categoryId, orderByComparator, true);

			array[1] = categoryVideoEntry;

			array[2] = getByCategoryId_PrevAndNext(session, categoryVideoEntry,
					categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryVideoEntry getByCategoryId_PrevAndNext(Session session,
		CategoryVideoEntry categoryVideoEntry, long categoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORYVIDEOENTRY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
			query.append(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(categoryVideoEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryVideoEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the category video entries.
	 *
	 * @return the category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @return the range of category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the category video entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category video entries
	 * @param end the upper bound of the range of category video entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryVideoEntry> findAll(int start, int end,
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

		List<CategoryVideoEntry> list = (List<CategoryVideoEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORYVIDEOENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYVIDEOENTRY.concat(CategoryVideoEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CategoryVideoEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CategoryVideoEntry>)QueryUtil.list(q,
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
	 * Removes all the category video entries where categoryId = &#63; and videoId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_V(long categoryId, long videoId)
		throws SystemException {
		for (CategoryVideoEntry categoryVideoEntry : findByC_V(categoryId,
				videoId)) {
			remove(categoryVideoEntry);
		}
	}

	/**
	 * Removes all the category video entries where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoId(long videoId) throws SystemException {
		for (CategoryVideoEntry categoryVideoEntry : findByVideoId(videoId)) {
			remove(categoryVideoEntry);
		}
	}

	/**
	 * Removes all the category video entries where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryId(long categoryId) throws SystemException {
		for (CategoryVideoEntry categoryVideoEntry : findByCategoryId(
				categoryId)) {
			remove(categoryVideoEntry);
		}
	}

	/**
	 * Removes all the category video entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CategoryVideoEntry categoryVideoEntry : findAll()) {
			remove(categoryVideoEntry);
		}
	}

	/**
	 * Returns the number of category video entries where categoryId = &#63; and videoId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param videoId the video ID
	 * @return the number of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_V(long categoryId, long videoId)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryId, videoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_V,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CATEGORYVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_C_V_CATEGORYID_2);

			query.append(_FINDER_COLUMN_C_V_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_V, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of category video entries where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoId(long videoId) throws SystemException {
		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYVIDEOENTRY_WHERE);

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
	 * Returns the number of category video entries where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryId(long categoryId) throws SystemException {
		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYVIDEOENTRY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of category video entries.
	 *
	 * @return the number of category video entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORYVIDEOENTRY);

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
	 * Initializes the category video entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.CategoryVideoEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CategoryVideoEntry>> listenersList = new ArrayList<ModelListener<CategoryVideoEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CategoryVideoEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CategoryVideoEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_CATEGORYVIDEOENTRY = "SELECT categoryVideoEntry FROM CategoryVideoEntry categoryVideoEntry";
	private static final String _SQL_SELECT_CATEGORYVIDEOENTRY_WHERE = "SELECT categoryVideoEntry FROM CategoryVideoEntry categoryVideoEntry WHERE ";
	private static final String _SQL_COUNT_CATEGORYVIDEOENTRY = "SELECT COUNT(categoryVideoEntry) FROM CategoryVideoEntry categoryVideoEntry";
	private static final String _SQL_COUNT_CATEGORYVIDEOENTRY_WHERE = "SELECT COUNT(categoryVideoEntry) FROM CategoryVideoEntry categoryVideoEntry WHERE ";
	private static final String _FINDER_COLUMN_C_V_CATEGORYID_2 = "categoryVideoEntry.categoryId = ? AND ";
	private static final String _FINDER_COLUMN_C_V_VIDEOID_2 = "categoryVideoEntry.videoId = ?";
	private static final String _FINDER_COLUMN_VIDEOID_VIDEOID_2 = "categoryVideoEntry.videoId = ?";
	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "categoryVideoEntry.categoryId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryVideoEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoryVideoEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CategoryVideoEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoryVideoEntryPersistenceImpl.class);
	private static CategoryVideoEntry _nullCategoryVideoEntry = new CategoryVideoEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CategoryVideoEntry> toCacheModel() {
				return _nullCategoryVideoEntryCacheModel;
			}
		};

	private static CacheModel<CategoryVideoEntry> _nullCategoryVideoEntryCacheModel =
		new CacheModel<CategoryVideoEntry>() {
			public CategoryVideoEntry toEntityModel() {
				return _nullCategoryVideoEntry;
			}
		};
}