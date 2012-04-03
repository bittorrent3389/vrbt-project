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

import vn.com.fis.portal.NoSuchFolderEntryException;
import vn.com.fis.portal.model.FolderEntry;
import vn.com.fis.portal.model.impl.FolderEntryImpl;
import vn.com.fis.portal.model.impl.FolderEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the folder entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see FolderEntryPersistence
 * @see FolderEntryUtil
 * @generated
 */
public class FolderEntryPersistenceImpl extends BasePersistenceImpl<FolderEntry>
	implements FolderEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FolderEntryUtil} to access the folder entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FolderEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLDERNAME =
		new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFolderName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME =
		new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFolderName",
			new String[] { String.class.getName() },
			FolderEntryModelImpl.FOLDERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FOLDERNAME = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFolderName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLDERIDPARENT =
		new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFolderIdParent",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERIDPARENT =
		new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFolderIdParent",
			new String[] { Long.class.getName() },
			FolderEntryModelImpl.FOLDERIDPARENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FOLDERIDPARENT = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFolderIdParent",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			FolderEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, FolderEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the folder entry in the entity cache if it is enabled.
	 *
	 * @param folderEntry the folder entry
	 */
	public void cacheResult(FolderEntry folderEntry) {
		EntityCacheUtil.putResult(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryImpl.class, folderEntry.getPrimaryKey(), folderEntry);

		folderEntry.resetOriginalValues();
	}

	/**
	 * Caches the folder entries in the entity cache if it is enabled.
	 *
	 * @param folderEntries the folder entries
	 */
	public void cacheResult(List<FolderEntry> folderEntries) {
		for (FolderEntry folderEntry : folderEntries) {
			if (EntityCacheUtil.getResult(
						FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
						FolderEntryImpl.class, folderEntry.getPrimaryKey()) == null) {
				cacheResult(folderEntry);
			}
			else {
				folderEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all folder entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FolderEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FolderEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the folder entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FolderEntry folderEntry) {
		EntityCacheUtil.removeResult(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryImpl.class, folderEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FolderEntry> folderEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FolderEntry folderEntry : folderEntries) {
			EntityCacheUtil.removeResult(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
				FolderEntryImpl.class, folderEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new folder entry with the primary key. Does not add the folder entry to the database.
	 *
	 * @param folderId the primary key for the new folder entry
	 * @return the new folder entry
	 */
	public FolderEntry create(long folderId) {
		FolderEntry folderEntry = new FolderEntryImpl();

		folderEntry.setNew(true);
		folderEntry.setPrimaryKey(folderId);

		return folderEntry;
	}

	/**
	 * Removes the folder entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param folderId the primary key of the folder entry
	 * @return the folder entry that was removed
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry remove(long folderId)
		throws NoSuchFolderEntryException, SystemException {
		return remove(Long.valueOf(folderId));
	}

	/**
	 * Removes the folder entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the folder entry
	 * @return the folder entry that was removed
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FolderEntry remove(Serializable primaryKey)
		throws NoSuchFolderEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FolderEntry folderEntry = (FolderEntry)session.get(FolderEntryImpl.class,
					primaryKey);

			if (folderEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFolderEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(folderEntry);
		}
		catch (NoSuchFolderEntryException nsee) {
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
	protected FolderEntry removeImpl(FolderEntry folderEntry)
		throws SystemException {
		folderEntry = toUnwrappedModel(folderEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, folderEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(folderEntry);

		return folderEntry;
	}

	@Override
	public FolderEntry updateImpl(
		vn.com.fis.portal.model.FolderEntry folderEntry, boolean merge)
		throws SystemException {
		folderEntry = toUnwrappedModel(folderEntry);

		boolean isNew = folderEntry.isNew();

		FolderEntryModelImpl folderEntryModelImpl = (FolderEntryModelImpl)folderEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, folderEntry, merge);

			folderEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FolderEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((folderEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						folderEntryModelImpl.getOriginalFolderName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FOLDERNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME,
					args);

				args = new Object[] { folderEntryModelImpl.getFolderName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FOLDERNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME,
					args);
			}

			if ((folderEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERIDPARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(folderEntryModelImpl.getOriginalFolderIdParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FOLDERIDPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERIDPARENT,
					args);

				args = new Object[] {
						Long.valueOf(folderEntryModelImpl.getFolderIdParent())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FOLDERIDPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERIDPARENT,
					args);
			}

			if ((folderEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(folderEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(folderEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
			FolderEntryImpl.class, folderEntry.getPrimaryKey(), folderEntry);

		return folderEntry;
	}

	protected FolderEntry toUnwrappedModel(FolderEntry folderEntry) {
		if (folderEntry instanceof FolderEntryImpl) {
			return folderEntry;
		}

		FolderEntryImpl folderEntryImpl = new FolderEntryImpl();

		folderEntryImpl.setNew(folderEntry.isNew());
		folderEntryImpl.setPrimaryKey(folderEntry.getPrimaryKey());

		folderEntryImpl.setFolderId(folderEntry.getFolderId());
		folderEntryImpl.setFolderName(folderEntry.getFolderName());
		folderEntryImpl.setDescription(folderEntry.getDescription());
		folderEntryImpl.setCreateDate(folderEntry.getCreateDate());
		folderEntryImpl.setModifiedDate(folderEntry.getModifiedDate());
		folderEntryImpl.setFolderIdParent(folderEntry.getFolderIdParent());
		folderEntryImpl.setUserId(folderEntry.getUserId());

		return folderEntryImpl;
	}

	/**
	 * Returns the folder entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the folder entry
	 * @return the folder entry
	 * @throws com.liferay.portal.NoSuchModelException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FolderEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the folder entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchFolderEntryException} if it could not be found.
	 *
	 * @param folderId the primary key of the folder entry
	 * @return the folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByPrimaryKey(long folderId)
		throws NoSuchFolderEntryException, SystemException {
		FolderEntry folderEntry = fetchByPrimaryKey(folderId);

		if (folderEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + folderId);
			}

			throw new NoSuchFolderEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				folderId);
		}

		return folderEntry;
	}

	/**
	 * Returns the folder entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the folder entry
	 * @return the folder entry, or <code>null</code> if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FolderEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the folder entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param folderId the primary key of the folder entry
	 * @return the folder entry, or <code>null</code> if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry fetchByPrimaryKey(long folderId)
		throws SystemException {
		FolderEntry folderEntry = (FolderEntry)EntityCacheUtil.getResult(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
				FolderEntryImpl.class, folderId);

		if (folderEntry == _nullFolderEntry) {
			return null;
		}

		if (folderEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				folderEntry = (FolderEntry)session.get(FolderEntryImpl.class,
						Long.valueOf(folderId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (folderEntry != null) {
					cacheResult(folderEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FolderEntryModelImpl.ENTITY_CACHE_ENABLED,
						FolderEntryImpl.class, folderId, _nullFolderEntry);
				}

				closeSession(session);
			}
		}

		return folderEntry;
	}

	/**
	 * Returns all the folder entries where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @return the matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderName(String folderName)
		throws SystemException {
		return findByFolderName(folderName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the folder entries where folderName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderName the folder name
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @return the range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderName(String folderName, int start,
		int end) throws SystemException {
		return findByFolderName(folderName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the folder entries where folderName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderName the folder name
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderName(String folderName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERNAME;
			finderArgs = new Object[] { folderName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLDERNAME;
			finderArgs = new Object[] { folderName, start, end, orderByComparator };
		}

		List<FolderEntry> list = (List<FolderEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FOLDERENTRY_WHERE);

			if (folderName == null) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1);
			}
			else {
				if (folderName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FolderEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (folderName != null) {
					qPos.add(folderName);
				}

				list = (List<FolderEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first folder entry in the ordered set where folderName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByFolderName_First(String folderName,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		List<FolderEntry> list = findByFolderName(folderName, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("folderName=");
			msg.append(folderName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFolderEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last folder entry in the ordered set where folderName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByFolderName_Last(String folderName,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		int count = countByFolderName(folderName);

		List<FolderEntry> list = findByFolderName(folderName, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("folderName=");
			msg.append(folderName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFolderEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the folder entries before and after the current folder entry in the ordered set where folderName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderId the primary key of the current folder entry
	 * @param folderName the folder name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry[] findByFolderName_PrevAndNext(long folderId,
		String folderName, OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		FolderEntry folderEntry = findByPrimaryKey(folderId);

		Session session = null;

		try {
			session = openSession();

			FolderEntry[] array = new FolderEntryImpl[3];

			array[0] = getByFolderName_PrevAndNext(session, folderEntry,
					folderName, orderByComparator, true);

			array[1] = folderEntry;

			array[2] = getByFolderName_PrevAndNext(session, folderEntry,
					folderName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FolderEntry getByFolderName_PrevAndNext(Session session,
		FolderEntry folderEntry, String folderName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FOLDERENTRY_WHERE);

		if (folderName == null) {
			query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1);
		}
		else {
			if (folderName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2);
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
			query.append(FolderEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (folderName != null) {
			qPos.add(folderName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(folderEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FolderEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the folder entries where folderIdParent = &#63;.
	 *
	 * @param folderIdParent the folder ID parent
	 * @return the matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderIdParent(long folderIdParent)
		throws SystemException {
		return findByFolderIdParent(folderIdParent, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the folder entries where folderIdParent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderIdParent the folder ID parent
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @return the range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderIdParent(long folderIdParent,
		int start, int end) throws SystemException {
		return findByFolderIdParent(folderIdParent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the folder entries where folderIdParent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderIdParent the folder ID parent
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderIdParent(long folderIdParent,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FOLDERIDPARENT;
			finderArgs = new Object[] { folderIdParent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FOLDERIDPARENT;
			finderArgs = new Object[] {
					folderIdParent,
					
					start, end, orderByComparator
				};
		}

		List<FolderEntry> list = (List<FolderEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FOLDERENTRY_WHERE);

			query.append(_FINDER_COLUMN_FOLDERIDPARENT_FOLDERIDPARENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FolderEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(folderIdParent);

				list = (List<FolderEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first folder entry in the ordered set where folderIdParent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderIdParent the folder ID parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByFolderIdParent_First(long folderIdParent,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		List<FolderEntry> list = findByFolderIdParent(folderIdParent, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("folderIdParent=");
			msg.append(folderIdParent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFolderEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last folder entry in the ordered set where folderIdParent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderIdParent the folder ID parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByFolderIdParent_Last(long folderIdParent,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		int count = countByFolderIdParent(folderIdParent);

		List<FolderEntry> list = findByFolderIdParent(folderIdParent,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("folderIdParent=");
			msg.append(folderIdParent);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFolderEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the folder entries before and after the current folder entry in the ordered set where folderIdParent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderId the primary key of the current folder entry
	 * @param folderIdParent the folder ID parent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry[] findByFolderIdParent_PrevAndNext(long folderId,
		long folderIdParent, OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		FolderEntry folderEntry = findByPrimaryKey(folderId);

		Session session = null;

		try {
			session = openSession();

			FolderEntry[] array = new FolderEntryImpl[3];

			array[0] = getByFolderIdParent_PrevAndNext(session, folderEntry,
					folderIdParent, orderByComparator, true);

			array[1] = folderEntry;

			array[2] = getByFolderIdParent_PrevAndNext(session, folderEntry,
					folderIdParent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected FolderEntry getByFolderIdParent_PrevAndNext(Session session,
		FolderEntry folderEntry, long folderIdParent,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FOLDERENTRY_WHERE);

		query.append(_FINDER_COLUMN_FOLDERIDPARENT_FOLDERIDPARENT_2);

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
			query.append(FolderEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(folderIdParent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(folderEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FolderEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the folder entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the folder entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @return the range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the folder entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByUserId(long userId, int start, int end,
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

		List<FolderEntry> list = (List<FolderEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_FOLDERENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(FolderEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<FolderEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first folder entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		List<FolderEntry> list = findByUserId(userId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFolderEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last folder entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a matching folder entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		int count = countByUserId(userId);

		List<FolderEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchFolderEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the folder entries before and after the current folder entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderId the primary key of the current folder entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next folder entry
	 * @throws vn.com.fis.portal.NoSuchFolderEntryException if a folder entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FolderEntry[] findByUserId_PrevAndNext(long folderId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFolderEntryException, SystemException {
		FolderEntry folderEntry = findByPrimaryKey(folderId);

		Session session = null;

		try {
			session = openSession();

			FolderEntry[] array = new FolderEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, folderEntry, userId,
					orderByComparator, true);

			array[1] = folderEntry;

			array[2] = getByUserId_PrevAndNext(session, folderEntry, userId,
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

	protected FolderEntry getByUserId_PrevAndNext(Session session,
		FolderEntry folderEntry, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FOLDERENTRY_WHERE);

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
			query.append(FolderEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(folderEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FolderEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the folder entries.
	 *
	 * @return the folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the folder entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @return the range of folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the folder entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findAll(int start, int end,
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

		List<FolderEntry> list = (List<FolderEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FOLDERENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FOLDERENTRY.concat(FolderEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FolderEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FolderEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the folder entries where folderName = &#63; from the database.
	 *
	 * @param folderName the folder name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFolderName(String folderName) throws SystemException {
		for (FolderEntry folderEntry : findByFolderName(folderName)) {
			remove(folderEntry);
		}
	}

	/**
	 * Removes all the folder entries where folderIdParent = &#63; from the database.
	 *
	 * @param folderIdParent the folder ID parent
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByFolderIdParent(long folderIdParent)
		throws SystemException {
		for (FolderEntry folderEntry : findByFolderIdParent(folderIdParent)) {
			remove(folderEntry);
		}
	}

	/**
	 * Removes all the folder entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (FolderEntry folderEntry : findByUserId(userId)) {
			remove(folderEntry);
		}
	}

	/**
	 * Removes all the folder entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FolderEntry folderEntry : findAll()) {
			remove(folderEntry);
		}
	}

	/**
	 * Returns the number of folder entries where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @return the number of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFolderName(String folderName) throws SystemException {
		Object[] finderArgs = new Object[] { folderName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FOLDERNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FOLDERENTRY_WHERE);

			if (folderName == null) {
				query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1);
			}
			else {
				if (folderName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (folderName != null) {
					qPos.add(folderName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FOLDERNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of folder entries where folderIdParent = &#63;.
	 *
	 * @param folderIdParent the folder ID parent
	 * @return the number of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFolderIdParent(long folderIdParent)
		throws SystemException {
		Object[] finderArgs = new Object[] { folderIdParent };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FOLDERIDPARENT,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FOLDERENTRY_WHERE);

			query.append(_FINDER_COLUMN_FOLDERIDPARENT_FOLDERIDPARENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(folderIdParent);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FOLDERIDPARENT,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of folder entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FOLDERENTRY_WHERE);

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
	 * Returns the number of folder entries.
	 *
	 * @return the number of folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FOLDERENTRY);

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
	 * Initializes the folder entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.FolderEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FolderEntry>> listenersList = new ArrayList<ModelListener<FolderEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FolderEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FolderEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_FOLDERENTRY = "SELECT folderEntry FROM FolderEntry folderEntry";
	private static final String _SQL_SELECT_FOLDERENTRY_WHERE = "SELECT folderEntry FROM FolderEntry folderEntry WHERE ";
	private static final String _SQL_COUNT_FOLDERENTRY = "SELECT COUNT(folderEntry) FROM FolderEntry folderEntry";
	private static final String _SQL_COUNT_FOLDERENTRY_WHERE = "SELECT COUNT(folderEntry) FROM FolderEntry folderEntry WHERE ";
	private static final String _FINDER_COLUMN_FOLDERNAME_FOLDERNAME_1 = "folderEntry.folderName IS NULL";
	private static final String _FINDER_COLUMN_FOLDERNAME_FOLDERNAME_2 = "folderEntry.folderName = ?";
	private static final String _FINDER_COLUMN_FOLDERNAME_FOLDERNAME_3 = "(folderEntry.folderName IS NULL OR folderEntry.folderName = ?)";
	private static final String _FINDER_COLUMN_FOLDERIDPARENT_FOLDERIDPARENT_2 = "folderEntry.folderIdParent = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "folderEntry.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "folderEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FolderEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FolderEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FolderEntryPersistenceImpl.class);
	private static FolderEntry _nullFolderEntry = new FolderEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FolderEntry> toCacheModel() {
				return _nullFolderEntryCacheModel;
			}
		};

	private static CacheModel<FolderEntry> _nullFolderEntryCacheModel = new CacheModel<FolderEntry>() {
			public FolderEntry toEntityModel() {
				return _nullFolderEntry;
			}
		};
}