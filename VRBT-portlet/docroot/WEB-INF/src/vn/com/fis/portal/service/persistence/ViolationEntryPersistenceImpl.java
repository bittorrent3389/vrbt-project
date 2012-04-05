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

import vn.com.fis.portal.NoSuchViolationEntryException;
import vn.com.fis.portal.model.ViolationEntry;
import vn.com.fis.portal.model.impl.ViolationEntryImpl;
import vn.com.fis.portal.model.impl.ViolationEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the violation entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ViolationEntryPersistence
 * @see ViolationEntryUtil
 * @generated
 */
public class ViolationEntryPersistenceImpl extends BasePersistenceImpl<ViolationEntry>
	implements ViolationEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ViolationEntryUtil} to access the violation entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ViolationEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitle",
			new String[] { String.class.getName() },
			ViolationEntryModelImpl.VIOLATIONTITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ViolationEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED,
			ViolationEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the violation entry in the entity cache if it is enabled.
	 *
	 * @param violationEntry the violation entry
	 */
	public void cacheResult(ViolationEntry violationEntry) {
		EntityCacheUtil.putResult(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryImpl.class, violationEntry.getPrimaryKey(),
			violationEntry);

		violationEntry.resetOriginalValues();
	}

	/**
	 * Caches the violation entries in the entity cache if it is enabled.
	 *
	 * @param violationEntries the violation entries
	 */
	public void cacheResult(List<ViolationEntry> violationEntries) {
		for (ViolationEntry violationEntry : violationEntries) {
			if (EntityCacheUtil.getResult(
						ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
						ViolationEntryImpl.class, violationEntry.getPrimaryKey()) == null) {
				cacheResult(violationEntry);
			}
			else {
				violationEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all violation entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ViolationEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ViolationEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the violation entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ViolationEntry violationEntry) {
		EntityCacheUtil.removeResult(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryImpl.class, violationEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ViolationEntry> violationEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ViolationEntry violationEntry : violationEntries) {
			EntityCacheUtil.removeResult(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
				ViolationEntryImpl.class, violationEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new violation entry with the primary key. Does not add the violation entry to the database.
	 *
	 * @param violationId the primary key for the new violation entry
	 * @return the new violation entry
	 */
	public ViolationEntry create(long violationId) {
		ViolationEntry violationEntry = new ViolationEntryImpl();

		violationEntry.setNew(true);
		violationEntry.setPrimaryKey(violationId);

		return violationEntry;
	}

	/**
	 * Removes the violation entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param violationId the primary key of the violation entry
	 * @return the violation entry that was removed
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry remove(long violationId)
		throws NoSuchViolationEntryException, SystemException {
		return remove(Long.valueOf(violationId));
	}

	/**
	 * Removes the violation entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the violation entry
	 * @return the violation entry that was removed
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViolationEntry remove(Serializable primaryKey)
		throws NoSuchViolationEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ViolationEntry violationEntry = (ViolationEntry)session.get(ViolationEntryImpl.class,
					primaryKey);

			if (violationEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchViolationEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(violationEntry);
		}
		catch (NoSuchViolationEntryException nsee) {
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
	protected ViolationEntry removeImpl(ViolationEntry violationEntry)
		throws SystemException {
		violationEntry = toUnwrappedModel(violationEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, violationEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(violationEntry);

		return violationEntry;
	}

	@Override
	public ViolationEntry updateImpl(
		vn.com.fis.portal.model.ViolationEntry violationEntry, boolean merge)
		throws SystemException {
		violationEntry = toUnwrappedModel(violationEntry);

		boolean isNew = violationEntry.isNew();

		ViolationEntryModelImpl violationEntryModelImpl = (ViolationEntryModelImpl)violationEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, violationEntry, merge);

			violationEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ViolationEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((violationEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						violationEntryModelImpl.getOriginalViolationTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { violationEntryModelImpl.getViolationTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}

			if ((violationEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(violationEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Integer.valueOf(violationEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
			ViolationEntryImpl.class, violationEntry.getPrimaryKey(),
			violationEntry);

		return violationEntry;
	}

	protected ViolationEntry toUnwrappedModel(ViolationEntry violationEntry) {
		if (violationEntry instanceof ViolationEntryImpl) {
			return violationEntry;
		}

		ViolationEntryImpl violationEntryImpl = new ViolationEntryImpl();

		violationEntryImpl.setNew(violationEntry.isNew());
		violationEntryImpl.setPrimaryKey(violationEntry.getPrimaryKey());

		violationEntryImpl.setViolationId(violationEntry.getViolationId());
		violationEntryImpl.setViolationTitle(violationEntry.getViolationTitle());
		violationEntryImpl.setDescription(violationEntry.getDescription());
		violationEntryImpl.setStatus(violationEntry.getStatus());

		return violationEntryImpl;
	}

	/**
	 * Returns the violation entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the violation entry
	 * @return the violation entry
	 * @throws com.liferay.portal.NoSuchModelException if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViolationEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the violation entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchViolationEntryException} if it could not be found.
	 *
	 * @param violationId the primary key of the violation entry
	 * @return the violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry findByPrimaryKey(long violationId)
		throws NoSuchViolationEntryException, SystemException {
		ViolationEntry violationEntry = fetchByPrimaryKey(violationId);

		if (violationEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + violationId);
			}

			throw new NoSuchViolationEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				violationId);
		}

		return violationEntry;
	}

	/**
	 * Returns the violation entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the violation entry
	 * @return the violation entry, or <code>null</code> if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ViolationEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the violation entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param violationId the primary key of the violation entry
	 * @return the violation entry, or <code>null</code> if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry fetchByPrimaryKey(long violationId)
		throws SystemException {
		ViolationEntry violationEntry = (ViolationEntry)EntityCacheUtil.getResult(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
				ViolationEntryImpl.class, violationId);

		if (violationEntry == _nullViolationEntry) {
			return null;
		}

		if (violationEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				violationEntry = (ViolationEntry)session.get(ViolationEntryImpl.class,
						Long.valueOf(violationId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (violationEntry != null) {
					cacheResult(violationEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ViolationEntryModelImpl.ENTITY_CACHE_ENABLED,
						ViolationEntryImpl.class, violationId,
						_nullViolationEntry);
				}

				closeSession(session);
			}
		}

		return violationEntry;
	}

	/**
	 * Returns all the violation entries where violationTitle = &#63;.
	 *
	 * @param violationTitle the violation title
	 * @return the matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findByTitle(String violationTitle)
		throws SystemException {
		return findByTitle(violationTitle, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation entries where violationTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationTitle the violation title
	 * @param start the lower bound of the range of violation entries
	 * @param end the upper bound of the range of violation entries (not inclusive)
	 * @return the range of matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findByTitle(String violationTitle, int start,
		int end) throws SystemException {
		return findByTitle(violationTitle, start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation entries where violationTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationTitle the violation title
	 * @param start the lower bound of the range of violation entries
	 * @param end the upper bound of the range of violation entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findByTitle(String violationTitle, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { violationTitle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] {
					violationTitle,
					
					start, end, orderByComparator
				};
		}

		List<ViolationEntry> list = (List<ViolationEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIOLATIONENTRY_WHERE);

			if (violationTitle == null) {
				query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_1);
			}
			else {
				if (violationTitle.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ViolationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (violationTitle != null) {
					qPos.add(violationTitle);
				}

				list = (List<ViolationEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first violation entry in the ordered set where violationTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationTitle the violation title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry findByTitle_First(String violationTitle,
		OrderByComparator orderByComparator)
		throws NoSuchViolationEntryException, SystemException {
		List<ViolationEntry> list = findByTitle(violationTitle, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("violationTitle=");
			msg.append(violationTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViolationEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last violation entry in the ordered set where violationTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationTitle the violation title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry findByTitle_Last(String violationTitle,
		OrderByComparator orderByComparator)
		throws NoSuchViolationEntryException, SystemException {
		int count = countByTitle(violationTitle);

		List<ViolationEntry> list = findByTitle(violationTitle, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("violationTitle=");
			msg.append(violationTitle);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViolationEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the violation entries before and after the current violation entry in the ordered set where violationTitle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationId the primary key of the current violation entry
	 * @param violationTitle the violation title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry[] findByTitle_PrevAndNext(long violationId,
		String violationTitle, OrderByComparator orderByComparator)
		throws NoSuchViolationEntryException, SystemException {
		ViolationEntry violationEntry = findByPrimaryKey(violationId);

		Session session = null;

		try {
			session = openSession();

			ViolationEntry[] array = new ViolationEntryImpl[3];

			array[0] = getByTitle_PrevAndNext(session, violationEntry,
					violationTitle, orderByComparator, true);

			array[1] = violationEntry;

			array[2] = getByTitle_PrevAndNext(session, violationEntry,
					violationTitle, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ViolationEntry getByTitle_PrevAndNext(Session session,
		ViolationEntry violationEntry, String violationTitle,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIOLATIONENTRY_WHERE);

		if (violationTitle == null) {
			query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_1);
		}
		else {
			if (violationTitle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_2);
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
			query.append(ViolationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (violationTitle != null) {
			qPos.add(violationTitle);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(violationEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ViolationEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the violation entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of violation entries
	 * @param end the upper bound of the range of violation entries (not inclusive)
	 * @return the range of matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of violation entries
	 * @param end the upper bound of the range of violation entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findByStatus(int status, int start, int end,
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

		List<ViolationEntry> list = (List<ViolationEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIOLATIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ViolationEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ViolationEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first violation entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchViolationEntryException, SystemException {
		List<ViolationEntry> list = findByStatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViolationEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last violation entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a matching violation entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchViolationEntryException, SystemException {
		int count = countByStatus(status);

		List<ViolationEntry> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchViolationEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the violation entries before and after the current violation entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param violationId the primary key of the current violation entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next violation entry
	 * @throws vn.com.fis.portal.NoSuchViolationEntryException if a violation entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ViolationEntry[] findByStatus_PrevAndNext(long violationId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchViolationEntryException, SystemException {
		ViolationEntry violationEntry = findByPrimaryKey(violationId);

		Session session = null;

		try {
			session = openSession();

			ViolationEntry[] array = new ViolationEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(session, violationEntry, status,
					orderByComparator, true);

			array[1] = violationEntry;

			array[2] = getByStatus_PrevAndNext(session, violationEntry, status,
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

	protected ViolationEntry getByStatus_PrevAndNext(Session session,
		ViolationEntry violationEntry, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIOLATIONENTRY_WHERE);

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
			query.append(ViolationEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(violationEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ViolationEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the violation entries.
	 *
	 * @return the violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the violation entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation entries
	 * @param end the upper bound of the range of violation entries (not inclusive)
	 * @return the range of violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the violation entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of violation entries
	 * @param end the upper bound of the range of violation entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ViolationEntry> findAll(int start, int end,
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

		List<ViolationEntry> list = (List<ViolationEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIOLATIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIOLATIONENTRY.concat(ViolationEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ViolationEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ViolationEntry>)QueryUtil.list(q,
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
	 * Removes all the violation entries where violationTitle = &#63; from the database.
	 *
	 * @param violationTitle the violation title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTitle(String violationTitle) throws SystemException {
		for (ViolationEntry violationEntry : findByTitle(violationTitle)) {
			remove(violationEntry);
		}
	}

	/**
	 * Removes all the violation entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStatus(int status) throws SystemException {
		for (ViolationEntry violationEntry : findByStatus(status)) {
			remove(violationEntry);
		}
	}

	/**
	 * Removes all the violation entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ViolationEntry violationEntry : findAll()) {
			remove(violationEntry);
		}
	}

	/**
	 * Returns the number of violation entries where violationTitle = &#63;.
	 *
	 * @param violationTitle the violation title
	 * @return the number of matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTitle(String violationTitle) throws SystemException {
		Object[] finderArgs = new Object[] { violationTitle };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIOLATIONENTRY_WHERE);

			if (violationTitle == null) {
				query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_1);
			}
			else {
				if (violationTitle.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_VIOLATIONTITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (violationTitle != null) {
					qPos.add(violationTitle);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of violation entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIOLATIONENTRY_WHERE);

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
	 * Returns the number of violation entries.
	 *
	 * @return the number of violation entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIOLATIONENTRY);

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
	 * Initializes the violation entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ViolationEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ViolationEntry>> listenersList = new ArrayList<ModelListener<ViolationEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ViolationEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ViolationEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIOLATIONENTRY = "SELECT violationEntry FROM ViolationEntry violationEntry";
	private static final String _SQL_SELECT_VIOLATIONENTRY_WHERE = "SELECT violationEntry FROM ViolationEntry violationEntry WHERE ";
	private static final String _SQL_COUNT_VIOLATIONENTRY = "SELECT COUNT(violationEntry) FROM ViolationEntry violationEntry";
	private static final String _SQL_COUNT_VIOLATIONENTRY_WHERE = "SELECT COUNT(violationEntry) FROM ViolationEntry violationEntry WHERE ";
	private static final String _FINDER_COLUMN_TITLE_VIOLATIONTITLE_1 = "violationEntry.violationTitle IS NULL";
	private static final String _FINDER_COLUMN_TITLE_VIOLATIONTITLE_2 = "violationEntry.violationTitle = ?";
	private static final String _FINDER_COLUMN_TITLE_VIOLATIONTITLE_3 = "(violationEntry.violationTitle IS NULL OR violationEntry.violationTitle = ?)";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "violationEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "violationEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ViolationEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ViolationEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ViolationEntryPersistenceImpl.class);
	private static ViolationEntry _nullViolationEntry = new ViolationEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ViolationEntry> toCacheModel() {
				return _nullViolationEntryCacheModel;
			}
		};

	private static CacheModel<ViolationEntry> _nullViolationEntryCacheModel = new CacheModel<ViolationEntry>() {
			public ViolationEntry toEntityModel() {
				return _nullViolationEntry;
			}
		};
}