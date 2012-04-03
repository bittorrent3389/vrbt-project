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

import vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException;
import vn.com.fis.portal.model.ContactGroupVideoGroupEntry;
import vn.com.fis.portal.model.impl.ContactGroupVideoGroupEntryImpl;
import vn.com.fis.portal.model.impl.ContactGroupVideoGroupEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact group video group entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ContactGroupVideoGroupEntryPersistence
 * @see ContactGroupVideoGroupEntryUtil
 * @generated
 */
public class ContactGroupVideoGroupEntryPersistenceImpl
	extends BasePersistenceImpl<ContactGroupVideoGroupEntry>
	implements ContactGroupVideoGroupEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ContactGroupVideoGroupEntryUtil} to access the contact group video group entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ContactGroupVideoGroupEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByContactGroup_VideoGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			ContactGroupVideoGroupEntryModelImpl.CONTACTGROUPID_COLUMN_BITMASK |
			ContactGroupVideoGroupEntryModelImpl.VIDEOGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTGROUP_VIDEOGROUP = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactGroup_VideoGroup",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTGROUP =
		new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByContactGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP =
		new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContactGroup",
			new String[] { Long.class.getName() },
			ContactGroupVideoGroupEntryModelImpl.CONTACTGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTGROUP = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactGroup", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOGROUP =
		new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoGroup",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOGROUP =
		new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoGroup",
			new String[] { Long.class.getName() },
			ContactGroupVideoGroupEntryModelImpl.VIDEOGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOGROUP = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVideoGroup", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the contact group video group entry in the entity cache if it is enabled.
	 *
	 * @param contactGroupVideoGroupEntry the contact group video group entry
	 */
	public void cacheResult(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		EntityCacheUtil.putResult(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			contactGroupVideoGroupEntry.getPrimaryKey(),
			contactGroupVideoGroupEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
			new Object[] {
				Long.valueOf(contactGroupVideoGroupEntry.getContactGroupId()),
				Long.valueOf(contactGroupVideoGroupEntry.getVideoGroupId())
			}, contactGroupVideoGroupEntry);

		contactGroupVideoGroupEntry.resetOriginalValues();
	}

	/**
	 * Caches the contact group video group entries in the entity cache if it is enabled.
	 *
	 * @param contactGroupVideoGroupEntries the contact group video group entries
	 */
	public void cacheResult(
		List<ContactGroupVideoGroupEntry> contactGroupVideoGroupEntries) {
		for (ContactGroupVideoGroupEntry contactGroupVideoGroupEntry : contactGroupVideoGroupEntries) {
			if (EntityCacheUtil.getResult(
						ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactGroupVideoGroupEntryImpl.class,
						contactGroupVideoGroupEntry.getPrimaryKey()) == null) {
				cacheResult(contactGroupVideoGroupEntry);
			}
			else {
				contactGroupVideoGroupEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contact group video group entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ContactGroupVideoGroupEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ContactGroupVideoGroupEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contact group video group entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		EntityCacheUtil.removeResult(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			contactGroupVideoGroupEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(contactGroupVideoGroupEntry);
	}

	@Override
	public void clearCache(
		List<ContactGroupVideoGroupEntry> contactGroupVideoGroupEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ContactGroupVideoGroupEntry contactGroupVideoGroupEntry : contactGroupVideoGroupEntries) {
			EntityCacheUtil.removeResult(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactGroupVideoGroupEntryImpl.class,
				contactGroupVideoGroupEntry.getPrimaryKey());

			clearUniqueFindersCache(contactGroupVideoGroupEntry);
		}
	}

	protected void clearUniqueFindersCache(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
			new Object[] {
				Long.valueOf(contactGroupVideoGroupEntry.getContactGroupId()),
				Long.valueOf(contactGroupVideoGroupEntry.getVideoGroupId())
			});
	}

	/**
	 * Creates a new contact group video group entry with the primary key. Does not add the contact group video group entry to the database.
	 *
	 * @param contactGroupVideoGroupEntryId the primary key for the new contact group video group entry
	 * @return the new contact group video group entry
	 */
	public ContactGroupVideoGroupEntry create(
		long contactGroupVideoGroupEntryId) {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = new ContactGroupVideoGroupEntryImpl();

		contactGroupVideoGroupEntry.setNew(true);
		contactGroupVideoGroupEntry.setPrimaryKey(contactGroupVideoGroupEntryId);

		return contactGroupVideoGroupEntry;
	}

	/**
	 * Removes the contact group video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	 * @return the contact group video group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry remove(
		long contactGroupVideoGroupEntryId)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		return remove(Long.valueOf(contactGroupVideoGroupEntryId));
	}

	/**
	 * Removes the contact group video group entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact group video group entry
	 * @return the contact group video group entry that was removed
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupVideoGroupEntry remove(Serializable primaryKey)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = (ContactGroupVideoGroupEntry)session.get(ContactGroupVideoGroupEntryImpl.class,
					primaryKey);

			if (contactGroupVideoGroupEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContactGroupVideoGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(contactGroupVideoGroupEntry);
		}
		catch (NoSuchContactGroupVideoGroupEntryException nsee) {
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
	protected ContactGroupVideoGroupEntry removeImpl(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws SystemException {
		contactGroupVideoGroupEntry = toUnwrappedModel(contactGroupVideoGroupEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, contactGroupVideoGroupEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(contactGroupVideoGroupEntry);

		return contactGroupVideoGroupEntry;
	}

	@Override
	public ContactGroupVideoGroupEntry updateImpl(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry,
		boolean merge) throws SystemException {
		contactGroupVideoGroupEntry = toUnwrappedModel(contactGroupVideoGroupEntry);

		boolean isNew = contactGroupVideoGroupEntry.isNew();

		ContactGroupVideoGroupEntryModelImpl contactGroupVideoGroupEntryModelImpl =
			(ContactGroupVideoGroupEntryModelImpl)contactGroupVideoGroupEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contactGroupVideoGroupEntry, merge);

			contactGroupVideoGroupEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!ContactGroupVideoGroupEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((contactGroupVideoGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactGroupVideoGroupEntryModelImpl.getOriginalContactGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactGroupVideoGroupEntryModelImpl.getContactGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP,
					args);
			}

			if ((contactGroupVideoGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactGroupVideoGroupEntryModelImpl.getOriginalVideoGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOGROUP,
					args);

				args = new Object[] {
						Long.valueOf(contactGroupVideoGroupEntryModelImpl.getVideoGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VIDEOGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
			ContactGroupVideoGroupEntryImpl.class,
			contactGroupVideoGroupEntry.getPrimaryKey(),
			contactGroupVideoGroupEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
				new Object[] {
					Long.valueOf(
						contactGroupVideoGroupEntry.getContactGroupId()),
					Long.valueOf(contactGroupVideoGroupEntry.getVideoGroupId())
				}, contactGroupVideoGroupEntry);
		}
		else {
			if ((contactGroupVideoGroupEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(contactGroupVideoGroupEntryModelImpl.getOriginalContactGroupId()),
						Long.valueOf(contactGroupVideoGroupEntryModelImpl.getOriginalVideoGroupId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTGROUP_VIDEOGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
					new Object[] {
						Long.valueOf(
							contactGroupVideoGroupEntry.getContactGroupId()),
						Long.valueOf(
							contactGroupVideoGroupEntry.getVideoGroupId())
					}, contactGroupVideoGroupEntry);
			}
		}

		return contactGroupVideoGroupEntry;
	}

	protected ContactGroupVideoGroupEntry toUnwrappedModel(
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry) {
		if (contactGroupVideoGroupEntry instanceof ContactGroupVideoGroupEntryImpl) {
			return contactGroupVideoGroupEntry;
		}

		ContactGroupVideoGroupEntryImpl contactGroupVideoGroupEntryImpl = new ContactGroupVideoGroupEntryImpl();

		contactGroupVideoGroupEntryImpl.setNew(contactGroupVideoGroupEntry.isNew());
		contactGroupVideoGroupEntryImpl.setPrimaryKey(contactGroupVideoGroupEntry.getPrimaryKey());

		contactGroupVideoGroupEntryImpl.setContactGroupVideoGroupEntryId(contactGroupVideoGroupEntry.getContactGroupVideoGroupEntryId());
		contactGroupVideoGroupEntryImpl.setContactGroupId(contactGroupVideoGroupEntry.getContactGroupId());
		contactGroupVideoGroupEntryImpl.setVideoGroupId(contactGroupVideoGroupEntry.getVideoGroupId());

		return contactGroupVideoGroupEntryImpl;
	}

	/**
	 * Returns the contact group video group entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact group video group entry
	 * @return the contact group video group entry
	 * @throws com.liferay.portal.NoSuchModelException if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupVideoGroupEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact group video group entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException} if it could not be found.
	 *
	 * @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	 * @return the contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByPrimaryKey(
		long contactGroupVideoGroupEntryId)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = fetchByPrimaryKey(contactGroupVideoGroupEntryId);

		if (contactGroupVideoGroupEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					contactGroupVideoGroupEntryId);
			}

			throw new NoSuchContactGroupVideoGroupEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactGroupVideoGroupEntryId);
		}

		return contactGroupVideoGroupEntry;
	}

	/**
	 * Returns the contact group video group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact group video group entry
	 * @return the contact group video group entry, or <code>null</code> if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ContactGroupVideoGroupEntry fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the contact group video group entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactGroupVideoGroupEntryId the primary key of the contact group video group entry
	 * @return the contact group video group entry, or <code>null</code> if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry fetchByPrimaryKey(
		long contactGroupVideoGroupEntryId) throws SystemException {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = (ContactGroupVideoGroupEntry)EntityCacheUtil.getResult(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
				ContactGroupVideoGroupEntryImpl.class,
				contactGroupVideoGroupEntryId);

		if (contactGroupVideoGroupEntry == _nullContactGroupVideoGroupEntry) {
			return null;
		}

		if (contactGroupVideoGroupEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				contactGroupVideoGroupEntry = (ContactGroupVideoGroupEntry)session.get(ContactGroupVideoGroupEntryImpl.class,
						Long.valueOf(contactGroupVideoGroupEntryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (contactGroupVideoGroupEntry != null) {
					cacheResult(contactGroupVideoGroupEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ContactGroupVideoGroupEntryModelImpl.ENTITY_CACHE_ENABLED,
						ContactGroupVideoGroupEntryImpl.class,
						contactGroupVideoGroupEntryId,
						_nullContactGroupVideoGroupEntry);
				}

				closeSession(session);
			}
		}

		return contactGroupVideoGroupEntry;
	}

	/**
	 * Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or throws a {@link vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException} if it could not be found.
	 *
	 * @param contactGroupId the contact group ID
	 * @param videoGroupId the video group ID
	 * @return the matching contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = fetchByContactGroup_VideoGroup(contactGroupId,
				videoGroupId);

		if (contactGroupVideoGroupEntry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactGroupId=");
			msg.append(contactGroupId);

			msg.append(", videoGroupId=");
			msg.append(videoGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchContactGroupVideoGroupEntryException(msg.toString());
		}

		return contactGroupVideoGroupEntry;
	}

	/**
	 * Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactGroupId the contact group ID
	 * @param videoGroupId the video group ID
	 * @return the matching contact group video group entry, or <code>null</code> if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry fetchByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId) throws SystemException {
		return fetchByContactGroup_VideoGroup(contactGroupId, videoGroupId, true);
	}

	/**
	 * Returns the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactGroupId the contact group ID
	 * @param videoGroupId the video group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching contact group video group entry, or <code>null</code> if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry fetchByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { contactGroupId, videoGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTGROUP_VIDEOGROUP_CONTACTGROUPID_2);

			query.append(_FINDER_COLUMN_CONTACTGROUP_VIDEOGROUP_VIDEOGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactGroupId);

				qPos.add(videoGroupId);

				List<ContactGroupVideoGroupEntry> list = q.list();

				result = list;

				ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
						finderArgs, list);
				}
				else {
					contactGroupVideoGroupEntry = list.get(0);

					cacheResult(contactGroupVideoGroupEntry);

					if ((contactGroupVideoGroupEntry.getContactGroupId() != contactGroupId) ||
							(contactGroupVideoGroupEntry.getVideoGroupId() != videoGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
							finderArgs, contactGroupVideoGroupEntry);
					}
				}

				return contactGroupVideoGroupEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTGROUP_VIDEOGROUP,
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
				return (ContactGroupVideoGroupEntry)result;
			}
		}
	}

	/**
	 * Returns all the contact group video group entries where contactGroupId = &#63;.
	 *
	 * @param contactGroupId the contact group ID
	 * @return the matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId) throws SystemException {
		return findByContactGroup(contactGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact group video group entries where contactGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupId the contact group ID
	 * @param start the lower bound of the range of contact group video group entries
	 * @param end the upper bound of the range of contact group video group entries (not inclusive)
	 * @return the range of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId, int start, int end) throws SystemException {
		return findByContactGroup(contactGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact group video group entries where contactGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupId the contact group ID
	 * @param start the lower bound of the range of contact group video group entries
	 * @param end the upper bound of the range of contact group video group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTGROUP;
			finderArgs = new Object[] { contactGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTGROUP;
			finderArgs = new Object[] {
					contactGroupId,
					
					start, end, orderByComparator
				};
		}

		List<ContactGroupVideoGroupEntry> list = (List<ContactGroupVideoGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactGroupId);

				list = (List<ContactGroupVideoGroupEntry>)QueryUtil.list(q,
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
	 * Returns the first contact group video group entry in the ordered set where contactGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupId the contact group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByContactGroup_First(
		long contactGroupId, OrderByComparator orderByComparator)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		List<ContactGroupVideoGroupEntry> list = findByContactGroup(contactGroupId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactGroupId=");
			msg.append(contactGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactGroupVideoGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last contact group video group entry in the ordered set where contactGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupId the contact group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByContactGroup_Last(
		long contactGroupId, OrderByComparator orderByComparator)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		int count = countByContactGroup(contactGroupId);

		List<ContactGroupVideoGroupEntry> list = findByContactGroup(contactGroupId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactGroupId=");
			msg.append(contactGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactGroupVideoGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the contact group video group entries before and after the current contact group video group entry in the ordered set where contactGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupVideoGroupEntryId the primary key of the current contact group video group entry
	 * @param contactGroupId the contact group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry[] findByContactGroup_PrevAndNext(
		long contactGroupVideoGroupEntryId, long contactGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = findByPrimaryKey(contactGroupVideoGroupEntryId);

		Session session = null;

		try {
			session = openSession();

			ContactGroupVideoGroupEntry[] array = new ContactGroupVideoGroupEntryImpl[3];

			array[0] = getByContactGroup_PrevAndNext(session,
					contactGroupVideoGroupEntry, contactGroupId,
					orderByComparator, true);

			array[1] = contactGroupVideoGroupEntry;

			array[2] = getByContactGroup_PrevAndNext(session,
					contactGroupVideoGroupEntry, contactGroupId,
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

	protected ContactGroupVideoGroupEntry getByContactGroup_PrevAndNext(
		Session session,
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry,
		long contactGroupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

		query.append(_FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactGroupVideoGroupEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactGroupVideoGroupEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contact group video group entries where videoGroupId = &#63;.
	 *
	 * @param videoGroupId the video group ID
	 * @return the matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findByVideoGroup(long videoGroupId)
		throws SystemException {
		return findByVideoGroup(videoGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact group video group entries where videoGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupId the video group ID
	 * @param start the lower bound of the range of contact group video group entries
	 * @param end the upper bound of the range of contact group video group entries (not inclusive)
	 * @return the range of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findByVideoGroup(
		long videoGroupId, int start, int end) throws SystemException {
		return findByVideoGroup(videoGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact group video group entries where videoGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupId the video group ID
	 * @param start the lower bound of the range of contact group video group entries
	 * @param end the upper bound of the range of contact group video group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findByVideoGroup(
		long videoGroupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOGROUP;
			finderArgs = new Object[] { videoGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOGROUP;
			finderArgs = new Object[] {
					videoGroupId,
					
					start, end, orderByComparator
				};
		}

		List<ContactGroupVideoGroupEntry> list = (List<ContactGroupVideoGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOGROUP_VIDEOGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoGroupId);

				list = (List<ContactGroupVideoGroupEntry>)QueryUtil.list(q,
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
	 * Returns the first contact group video group entry in the ordered set where videoGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupId the video group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByVideoGroup_First(
		long videoGroupId, OrderByComparator orderByComparator)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		List<ContactGroupVideoGroupEntry> list = findByVideoGroup(videoGroupId,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoGroupId=");
			msg.append(videoGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactGroupVideoGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last contact group video group entry in the ordered set where videoGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoGroupId the video group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a matching contact group video group entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry findByVideoGroup_Last(
		long videoGroupId, OrderByComparator orderByComparator)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		int count = countByVideoGroup(videoGroupId);

		List<ContactGroupVideoGroupEntry> list = findByVideoGroup(videoGroupId,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("videoGroupId=");
			msg.append(videoGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactGroupVideoGroupEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the contact group video group entries before and after the current contact group video group entry in the ordered set where videoGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactGroupVideoGroupEntryId the primary key of the current contact group video group entry
	 * @param videoGroupId the video group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next contact group video group entry
	 * @throws vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException if a contact group video group entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ContactGroupVideoGroupEntry[] findByVideoGroup_PrevAndNext(
		long contactGroupVideoGroupEntryId, long videoGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = findByPrimaryKey(contactGroupVideoGroupEntryId);

		Session session = null;

		try {
			session = openSession();

			ContactGroupVideoGroupEntry[] array = new ContactGroupVideoGroupEntryImpl[3];

			array[0] = getByVideoGroup_PrevAndNext(session,
					contactGroupVideoGroupEntry, videoGroupId,
					orderByComparator, true);

			array[1] = contactGroupVideoGroupEntry;

			array[2] = getByVideoGroup_PrevAndNext(session,
					contactGroupVideoGroupEntry, videoGroupId,
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

	protected ContactGroupVideoGroupEntry getByVideoGroup_PrevAndNext(
		Session session,
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry,
		long videoGroupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOGROUP_VIDEOGROUPID_2);

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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(contactGroupVideoGroupEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ContactGroupVideoGroupEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the contact group video group entries.
	 *
	 * @return the contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contact group video group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact group video group entries
	 * @param end the upper bound of the range of contact group video group entries (not inclusive)
	 * @return the range of contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contact group video group entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contact group video group entries
	 * @param end the upper bound of the range of contact group video group entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ContactGroupVideoGroupEntry> findAll(int start, int end,
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

		List<ContactGroupVideoGroupEntry> list = (List<ContactGroupVideoGroupEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ContactGroupVideoGroupEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ContactGroupVideoGroupEntry>)QueryUtil.list(q,
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
	 * Removes the contact group video group entry where contactGroupId = &#63; and videoGroupId = &#63; from the database.
	 *
	 * @param contactGroupId the contact group ID
	 * @param videoGroupId the video group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws NoSuchContactGroupVideoGroupEntryException, SystemException {
		ContactGroupVideoGroupEntry contactGroupVideoGroupEntry = findByContactGroup_VideoGroup(contactGroupId,
				videoGroupId);

		remove(contactGroupVideoGroupEntry);
	}

	/**
	 * Removes all the contact group video group entries where contactGroupId = &#63; from the database.
	 *
	 * @param contactGroupId the contact group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactGroup(long contactGroupId)
		throws SystemException {
		for (ContactGroupVideoGroupEntry contactGroupVideoGroupEntry : findByContactGroup(
				contactGroupId)) {
			remove(contactGroupVideoGroupEntry);
		}
	}

	/**
	 * Removes all the contact group video group entries where videoGroupId = &#63; from the database.
	 *
	 * @param videoGroupId the video group ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByVideoGroup(long videoGroupId) throws SystemException {
		for (ContactGroupVideoGroupEntry contactGroupVideoGroupEntry : findByVideoGroup(
				videoGroupId)) {
			remove(contactGroupVideoGroupEntry);
		}
	}

	/**
	 * Removes all the contact group video group entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ContactGroupVideoGroupEntry contactGroupVideoGroupEntry : findAll()) {
			remove(contactGroupVideoGroupEntry);
		}
	}

	/**
	 * Returns the number of contact group video group entries where contactGroupId = &#63; and videoGroupId = &#63;.
	 *
	 * @param contactGroupId the contact group ID
	 * @param videoGroupId the video group ID
	 * @return the number of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId) throws SystemException {
		Object[] finderArgs = new Object[] { contactGroupId, videoGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTGROUP_VIDEOGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTGROUP_VIDEOGROUP_CONTACTGROUPID_2);

			query.append(_FINDER_COLUMN_CONTACTGROUP_VIDEOGROUP_VIDEOGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactGroupId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTGROUP_VIDEOGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact group video group entries where contactGroupId = &#63;.
	 *
	 * @param contactGroupId the contact group ID
	 * @return the number of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactGroup(long contactGroupId)
		throws SystemException {
		Object[] finderArgs = new Object[] { contactGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactGroupId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact group video group entries where videoGroupId = &#63;.
	 *
	 * @param videoGroupId the video group ID
	 * @return the number of matching contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByVideoGroup(long videoGroupId) throws SystemException {
		Object[] finderArgs = new Object[] { videoGroupId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VIDEOGROUP,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CONTACTGROUPVIDEOGROUPENTRY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOGROUP_VIDEOGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VIDEOGROUP,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of contact group video group entries.
	 *
	 * @return the number of contact group video group entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACTGROUPVIDEOGROUPENTRY);

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
	 * Initializes the contact group video group entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ContactGroupVideoGroupEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ContactGroupVideoGroupEntry>> listenersList = new ArrayList<ModelListener<ContactGroupVideoGroupEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ContactGroupVideoGroupEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ContactGroupVideoGroupEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY = "SELECT contactGroupVideoGroupEntry FROM ContactGroupVideoGroupEntry contactGroupVideoGroupEntry";
	private static final String _SQL_SELECT_CONTACTGROUPVIDEOGROUPENTRY_WHERE = "SELECT contactGroupVideoGroupEntry FROM ContactGroupVideoGroupEntry contactGroupVideoGroupEntry WHERE ";
	private static final String _SQL_COUNT_CONTACTGROUPVIDEOGROUPENTRY = "SELECT COUNT(contactGroupVideoGroupEntry) FROM ContactGroupVideoGroupEntry contactGroupVideoGroupEntry";
	private static final String _SQL_COUNT_CONTACTGROUPVIDEOGROUPENTRY_WHERE = "SELECT COUNT(contactGroupVideoGroupEntry) FROM ContactGroupVideoGroupEntry contactGroupVideoGroupEntry WHERE ";
	private static final String _FINDER_COLUMN_CONTACTGROUP_VIDEOGROUP_CONTACTGROUPID_2 =
		"contactGroupVideoGroupEntry.contactGroupId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTGROUP_VIDEOGROUP_VIDEOGROUPID_2 =
		"contactGroupVideoGroupEntry.videoGroupId = ?";
	private static final String _FINDER_COLUMN_CONTACTGROUP_CONTACTGROUPID_2 = "contactGroupVideoGroupEntry.contactGroupId = ?";
	private static final String _FINDER_COLUMN_VIDEOGROUP_VIDEOGROUPID_2 = "contactGroupVideoGroupEntry.videoGroupId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contactGroupVideoGroupEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ContactGroupVideoGroupEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ContactGroupVideoGroupEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ContactGroupVideoGroupEntryPersistenceImpl.class);
	private static ContactGroupVideoGroupEntry _nullContactGroupVideoGroupEntry = new ContactGroupVideoGroupEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ContactGroupVideoGroupEntry> toCacheModel() {
				return _nullContactGroupVideoGroupEntryCacheModel;
			}
		};

	private static CacheModel<ContactGroupVideoGroupEntry> _nullContactGroupVideoGroupEntryCacheModel =
		new CacheModel<ContactGroupVideoGroupEntry>() {
			public ContactGroupVideoGroupEntry toEntityModel() {
				return _nullContactGroupVideoGroupEntry;
			}
		};
}