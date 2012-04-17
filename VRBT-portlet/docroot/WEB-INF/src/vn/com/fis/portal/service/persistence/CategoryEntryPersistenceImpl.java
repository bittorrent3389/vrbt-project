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

import vn.com.fis.portal.NoSuchCategoryEntryException;
import vn.com.fis.portal.model.CategoryEntry;
import vn.com.fis.portal.model.impl.CategoryEntryImpl;
import vn.com.fis.portal.model.impl.CategoryEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the category entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see CategoryEntryPersistence
 * @see CategoryEntryUtil
 * @generated
 */
public class CategoryEntryPersistenceImpl extends BasePersistenceImpl<CategoryEntry>
	implements CategoryEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoryEntryUtil} to access the category entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoryEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategoryName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategoryName", new String[] { String.class.getName() },
			CategoryEntryModelImpl.CATEGORYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCategoryNameAbsolute",
			new String[] { String.class.getName() },
			CategoryEntryModelImpl.CATEGORYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAMEABSOLUTE = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryNameAbsolute",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBystatus", new String[] { Integer.class.getName() },
			CategoryEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED,
			CategoryEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the category entry in the entity cache if it is enabled.
	 *
	 * @param categoryEntry the category entry
	 */
	public void cacheResult(CategoryEntry categoryEntry) {
		EntityCacheUtil.putResult(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryImpl.class, categoryEntry.getPrimaryKey(),
			categoryEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
			new Object[] { categoryEntry.getCategoryName() }, categoryEntry);

		categoryEntry.resetOriginalValues();
	}

	/**
	 * Caches the category entries in the entity cache if it is enabled.
	 *
	 * @param categoryEntries the category entries
	 */
	public void cacheResult(List<CategoryEntry> categoryEntries) {
		for (CategoryEntry categoryEntry : categoryEntries) {
			if (EntityCacheUtil.getResult(
						CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryEntryImpl.class, categoryEntry.getPrimaryKey()) == null) {
				cacheResult(categoryEntry);
			}
			else {
				categoryEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all category entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoryEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoryEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the category entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoryEntry categoryEntry) {
		EntityCacheUtil.removeResult(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryImpl.class, categoryEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(categoryEntry);
	}

	@Override
	public void clearCache(List<CategoryEntry> categoryEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoryEntry categoryEntry : categoryEntries) {
			EntityCacheUtil.removeResult(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryEntryImpl.class, categoryEntry.getPrimaryKey());

			clearUniqueFindersCache(categoryEntry);
		}
	}

	protected void clearUniqueFindersCache(CategoryEntry categoryEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
			new Object[] { categoryEntry.getCategoryName() });
	}

	/**
	 * Creates a new category entry with the primary key. Does not add the category entry to the database.
	 *
	 * @param categoryId the primary key for the new category entry
	 * @return the new category entry
	 */
	public CategoryEntry create(long categoryId) {
		CategoryEntry categoryEntry = new CategoryEntryImpl();

		categoryEntry.setNew(true);
		categoryEntry.setPrimaryKey(categoryId);

		return categoryEntry;
	}

	/**
	 * Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry remove(long categoryId)
		throws NoSuchCategoryEntryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the category entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the category entry
	 * @return the category entry that was removed
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryEntry remove(Serializable primaryKey)
		throws NoSuchCategoryEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CategoryEntry categoryEntry = (CategoryEntry)session.get(CategoryEntryImpl.class,
					primaryKey);

			if (categoryEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoryEntry);
		}
		catch (NoSuchCategoryEntryException nsee) {
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
	protected CategoryEntry removeImpl(CategoryEntry categoryEntry)
		throws SystemException {
		categoryEntry = toUnwrappedModel(categoryEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, categoryEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(categoryEntry);

		return categoryEntry;
	}

	@Override
	public CategoryEntry updateImpl(
		vn.com.fis.portal.model.CategoryEntry categoryEntry, boolean merge)
		throws SystemException {
		categoryEntry = toUnwrappedModel(categoryEntry);

		boolean isNew = categoryEntry.isNew();

		CategoryEntryModelImpl categoryEntryModelImpl = (CategoryEntryModelImpl)categoryEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, categoryEntry, merge);

			categoryEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CategoryEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((categoryEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						categoryEntryModelImpl.getOriginalCategoryName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);

				args = new Object[] { categoryEntryModelImpl.getCategoryName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);
			}

			if ((categoryEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(categoryEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Integer.valueOf(categoryEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
			CategoryEntryImpl.class, categoryEntry.getPrimaryKey(),
			categoryEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
				new Object[] { categoryEntry.getCategoryName() }, categoryEntry);
		}
		else {
			if ((categoryEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						categoryEntryModelImpl.getOriginalCategoryName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAMEABSOLUTE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
					new Object[] { categoryEntry.getCategoryName() },
					categoryEntry);
			}
		}

		return categoryEntry;
	}

	protected CategoryEntry toUnwrappedModel(CategoryEntry categoryEntry) {
		if (categoryEntry instanceof CategoryEntryImpl) {
			return categoryEntry;
		}

		CategoryEntryImpl categoryEntryImpl = new CategoryEntryImpl();

		categoryEntryImpl.setNew(categoryEntry.isNew());
		categoryEntryImpl.setPrimaryKey(categoryEntry.getPrimaryKey());

		categoryEntryImpl.setCategoryId(categoryEntry.getCategoryId());
		categoryEntryImpl.setCategoryName(categoryEntry.getCategoryName());
		categoryEntryImpl.setDescription(categoryEntry.getDescription());
		categoryEntryImpl.setStatus(categoryEntry.getStatus());

		return categoryEntryImpl;
	}

	/**
	 * Returns the category entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the category entry
	 * @return the category entry
	 * @throws com.liferay.portal.NoSuchModelException if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the category entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchCategoryEntryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry findByPrimaryKey(long categoryId)
		throws NoSuchCategoryEntryException, SystemException {
		CategoryEntry categoryEntry = fetchByPrimaryKey(categoryId);

		if (categoryEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchCategoryEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return categoryEntry;
	}

	/**
	 * Returns the category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the category entry
	 * @return the category entry, or <code>null</code> if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoryEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the category entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the category entry
	 * @return the category entry, or <code>null</code> if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry fetchByPrimaryKey(long categoryId)
		throws SystemException {
		CategoryEntry categoryEntry = (CategoryEntry)EntityCacheUtil.getResult(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
				CategoryEntryImpl.class, categoryId);

		if (categoryEntry == _nullCategoryEntry) {
			return null;
		}

		if (categoryEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				categoryEntry = (CategoryEntry)session.get(CategoryEntryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (categoryEntry != null) {
					cacheResult(categoryEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CategoryEntryModelImpl.ENTITY_CACHE_ENABLED,
						CategoryEntryImpl.class, categoryId, _nullCategoryEntry);
				}

				closeSession(session);
			}
		}

		return categoryEntry;
	}

	/**
	 * Returns all the category entries where categoryName LIKE &#63;.
	 *
	 * @param categoryName the category name
	 * @return the matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findByCategoryName(String categoryName)
		throws SystemException {
		return findByCategoryName(categoryName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category entries where categoryName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findByCategoryName(String categoryName,
		int start, int end) throws SystemException {
		return findByCategoryName(categoryName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category entries where categoryName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findByCategoryName(String categoryName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] { categoryName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] {
					categoryName,
					
					start, end, orderByComparator
				};
		}

		List<CategoryEntry> list = (List<CategoryEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else {
				if (categoryName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryName != null) {
					qPos.add(categoryName);
				}

				list = (List<CategoryEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first category entry in the ordered set where categoryName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry findByCategoryName_First(String categoryName,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryEntryException, SystemException {
		List<CategoryEntry> list = findByCategoryName(categoryName, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryName=");
			msg.append(categoryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last category entry in the ordered set where categoryName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry findByCategoryName_Last(String categoryName,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryEntryException, SystemException {
		int count = countByCategoryName(categoryName);

		List<CategoryEntry> list = findByCategoryName(categoryName, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryName=");
			msg.append(categoryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where categoryName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param categoryName the category name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry[] findByCategoryName_PrevAndNext(long categoryId,
		String categoryName, OrderByComparator orderByComparator)
		throws NoSuchCategoryEntryException, SystemException {
		CategoryEntry categoryEntry = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CategoryEntry[] array = new CategoryEntryImpl[3];

			array[0] = getByCategoryName_PrevAndNext(session, categoryEntry,
					categoryName, orderByComparator, true);

			array[1] = categoryEntry;

			array[2] = getByCategoryName_PrevAndNext(session, categoryEntry,
					categoryName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CategoryEntry getByCategoryName_PrevAndNext(Session session,
		CategoryEntry categoryEntry, String categoryName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

		if (categoryName == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
		}
		else {
			if (categoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
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
			query.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (categoryName != null) {
			qPos.add(categoryName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(categoryEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the category entry where categoryName = &#63; or throws a {@link vn.com.fis.portal.NoSuchCategoryEntryException} if it could not be found.
	 *
	 * @param categoryName the category name
	 * @return the matching category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry findByCategoryNameAbsolute(String categoryName)
		throws NoSuchCategoryEntryException, SystemException {
		CategoryEntry categoryEntry = fetchByCategoryNameAbsolute(categoryName);

		if (categoryEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryName=");
			msg.append(categoryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCategoryEntryException(msg.toString());
		}

		return categoryEntry;
	}

	/**
	 * Returns the category entry where categoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryName the category name
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry fetchByCategoryNameAbsolute(String categoryName)
		throws SystemException {
		return fetchByCategoryNameAbsolute(categoryName, true);
	}

	/**
	 * Returns the category entry where categoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryName the category name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching category entry, or <code>null</code> if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry fetchByCategoryNameAbsolute(String categoryName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { categoryName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_1);
			}
			else {
				if (categoryName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_2);
				}
			}

			query.append(CategoryEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryName != null) {
					qPos.add(categoryName);
				}

				List<CategoryEntry> list = q.list();

				result = list;

				CategoryEntry categoryEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
						finderArgs, list);
				}
				else {
					categoryEntry = list.get(0);

					cacheResult(categoryEntry);

					if ((categoryEntry.getCategoryName() == null) ||
							!categoryEntry.getCategoryName().equals(categoryName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
							finderArgs, categoryEntry);
					}
				}

				return categoryEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CATEGORYNAMEABSOLUTE,
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
				return (CategoryEntry)result;
			}
		}
	}

	/**
	 * Returns all the category entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findBystatus(int status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findBystatus(int status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the category entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findBystatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<CategoryEntry> list = (List<CategoryEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<CategoryEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first category entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry findBystatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryEntryException, SystemException {
		List<CategoryEntry> list = findBystatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last category entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a matching category entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry findBystatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryEntryException, SystemException {
		int count = countBystatus(status);

		List<CategoryEntry> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchCategoryEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the category entries before and after the current category entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryId the primary key of the current category entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next category entry
	 * @throws vn.com.fis.portal.NoSuchCategoryEntryException if a category entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoryEntry[] findBystatus_PrevAndNext(long categoryId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchCategoryEntryException, SystemException {
		CategoryEntry categoryEntry = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			CategoryEntry[] array = new CategoryEntryImpl[3];

			array[0] = getBystatus_PrevAndNext(session, categoryEntry, status,
					orderByComparator, true);

			array[1] = categoryEntry;

			array[2] = getBystatus_PrevAndNext(session, categoryEntry, status,
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

	protected CategoryEntry getBystatus_PrevAndNext(Session session,
		CategoryEntry categoryEntry, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CATEGORYENTRY_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(CategoryEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(categoryEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CategoryEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the category entries.
	 *
	 * @return the category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @return the range of category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the category entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of category entries
	 * @param end the upper bound of the range of category entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of category entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEntry> findAll(int start, int end,
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

		List<CategoryEntry> list = (List<CategoryEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORYENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORYENTRY.concat(CategoryEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CategoryEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CategoryEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the category entries where categoryName LIKE &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryName(String categoryName)
		throws SystemException {
		for (CategoryEntry categoryEntry : findByCategoryName(categoryName)) {
			remove(categoryEntry);
		}
	}

	/**
	 * Removes the category entry where categoryName = &#63; from the database.
	 *
	 * @param categoryName the category name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCategoryNameAbsolute(String categoryName)
		throws NoSuchCategoryEntryException, SystemException {
		CategoryEntry categoryEntry = findByCategoryNameAbsolute(categoryName);

		remove(categoryEntry);
	}

	/**
	 * Removes all the category entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBystatus(int status) throws SystemException {
		for (CategoryEntry categoryEntry : findBystatus(status)) {
			remove(categoryEntry);
		}
	}

	/**
	 * Removes all the category entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CategoryEntry categoryEntry : findAll()) {
			remove(categoryEntry);
		}
	}

	/**
	 * Returns the number of category entries where categoryName LIKE &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryName(String categoryName)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1);
			}
			else {
				if (categoryName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryName != null) {
					qPos.add(categoryName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of category entries where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryNameAbsolute(String categoryName)
		throws SystemException {
		Object[] finderArgs = new Object[] { categoryName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYNAMEABSOLUTE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			if (categoryName == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_1);
			}
			else {
				if (categoryName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (categoryName != null) {
					qPos.add(categoryName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYNAMEABSOLUTE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of category entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching category entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countBystatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CATEGORYENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of category entries.
	 *
	 * @return the number of category entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORYENTRY);

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
	 * Initializes the category entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.CategoryEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CategoryEntry>> listenersList = new ArrayList<ModelListener<CategoryEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CategoryEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CategoryEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_CATEGORYENTRY = "SELECT categoryEntry FROM CategoryEntry categoryEntry";
	private static final String _SQL_SELECT_CATEGORYENTRY_WHERE = "SELECT categoryEntry FROM CategoryEntry categoryEntry WHERE ";
	private static final String _SQL_COUNT_CATEGORYENTRY = "SELECT COUNT(categoryEntry) FROM CategoryEntry categoryEntry";
	private static final String _SQL_COUNT_CATEGORYENTRY_WHERE = "SELECT COUNT(categoryEntry) FROM CategoryEntry categoryEntry WHERE ";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_1 = "categoryEntry.categoryName LIKE NULL";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_2 = "lower(categoryEntry.categoryName) LIKE lower(CAST_TEXT(?))";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORYNAME_3 = "(categoryEntry.categoryName IS NULL OR lower(categoryEntry.categoryName) LIKE lower(CAST_TEXT(?)))";
	private static final String _FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_1 =
		"categoryEntry.categoryName IS NULL";
	private static final String _FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_2 =
		"categoryEntry.categoryName = ?";
	private static final String _FINDER_COLUMN_CATEGORYNAMEABSOLUTE_CATEGORYNAME_3 =
		"(categoryEntry.categoryName IS NULL OR categoryEntry.categoryName = ?)";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "categoryEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoryEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoryEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CategoryEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoryEntryPersistenceImpl.class);
	private static CategoryEntry _nullCategoryEntry = new CategoryEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CategoryEntry> toCacheModel() {
				return _nullCategoryEntryCacheModel;
			}
		};

	private static CacheModel<CategoryEntry> _nullCategoryEntryCacheModel = new CacheModel<CategoryEntry>() {
			public CategoryEntry toEntityModel() {
				return _nullCategoryEntry;
			}
		};
}