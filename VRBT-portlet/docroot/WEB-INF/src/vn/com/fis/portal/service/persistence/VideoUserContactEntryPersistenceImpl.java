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

import vn.com.fis.portal.NoSuchVideoUserContactEntryException;
import vn.com.fis.portal.model.VideoUserContactEntry;
import vn.com.fis.portal.model.impl.VideoUserContactEntryImpl;
import vn.com.fis.portal.model.impl.VideoUserContactEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the video user contact entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see VideoUserContactEntryPersistence
 * @see VideoUserContactEntryUtil
 * @generated
 */
public class VideoUserContactEntryPersistenceImpl extends BasePersistenceImpl<VideoUserContactEntry>
	implements VideoUserContactEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VideoUserContactEntryUtil} to access the video user contact entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VideoUserContactEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID =
		new FinderPath(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContactId_VideoUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID =
		new FinderPath(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByContactId_VideoUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			VideoUserContactEntryModelImpl.CONTACTID_COLUMN_BITMASK |
			VideoUserContactEntryModelImpl.VIDEOUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTID_VIDEOUSERID = new FinderPath(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByContactId_VideoUserId",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryModelImpl.FINDER_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the video user contact entry in the entity cache if it is enabled.
	 *
	 * @param videoUserContactEntry the video user contact entry
	 */
	public void cacheResult(VideoUserContactEntry videoUserContactEntry) {
		EntityCacheUtil.putResult(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			videoUserContactEntry.getPrimaryKey(), videoUserContactEntry);

		videoUserContactEntry.resetOriginalValues();
	}

	/**
	 * Caches the video user contact entries in the entity cache if it is enabled.
	 *
	 * @param videoUserContactEntries the video user contact entries
	 */
	public void cacheResult(List<VideoUserContactEntry> videoUserContactEntries) {
		for (VideoUserContactEntry videoUserContactEntry : videoUserContactEntries) {
			if (EntityCacheUtil.getResult(
						VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserContactEntryImpl.class,
						videoUserContactEntry.getPrimaryKey()) == null) {
				cacheResult(videoUserContactEntry);
			}
			else {
				videoUserContactEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video user contact entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VideoUserContactEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VideoUserContactEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video user contact entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VideoUserContactEntry videoUserContactEntry) {
		EntityCacheUtil.removeResult(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			videoUserContactEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VideoUserContactEntry> videoUserContactEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VideoUserContactEntry videoUserContactEntry : videoUserContactEntries) {
			EntityCacheUtil.removeResult(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserContactEntryImpl.class,
				videoUserContactEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video user contact entry with the primary key. Does not add the video user contact entry to the database.
	 *
	 * @param videoUserContactId the primary key for the new video user contact entry
	 * @return the new video user contact entry
	 */
	public VideoUserContactEntry create(long videoUserContactId) {
		VideoUserContactEntry videoUserContactEntry = new VideoUserContactEntryImpl();

		videoUserContactEntry.setNew(true);
		videoUserContactEntry.setPrimaryKey(videoUserContactId);

		return videoUserContactEntry;
	}

	/**
	 * Removes the video user contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoUserContactId the primary key of the video user contact entry
	 * @return the video user contact entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserContactEntry remove(long videoUserContactId)
		throws NoSuchVideoUserContactEntryException, SystemException {
		return remove(Long.valueOf(videoUserContactId));
	}

	/**
	 * Removes the video user contact entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video user contact entry
	 * @return the video user contact entry that was removed
	 * @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserContactEntry remove(Serializable primaryKey)
		throws NoSuchVideoUserContactEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VideoUserContactEntry videoUserContactEntry = (VideoUserContactEntry)session.get(VideoUserContactEntryImpl.class,
					primaryKey);

			if (videoUserContactEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoUserContactEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(videoUserContactEntry);
		}
		catch (NoSuchVideoUserContactEntryException nsee) {
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
	protected VideoUserContactEntry removeImpl(
		VideoUserContactEntry videoUserContactEntry) throws SystemException {
		videoUserContactEntry = toUnwrappedModel(videoUserContactEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, videoUserContactEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(videoUserContactEntry);

		return videoUserContactEntry;
	}

	@Override
	public VideoUserContactEntry updateImpl(
		vn.com.fis.portal.model.VideoUserContactEntry videoUserContactEntry,
		boolean merge) throws SystemException {
		videoUserContactEntry = toUnwrappedModel(videoUserContactEntry);

		boolean isNew = videoUserContactEntry.isNew();

		VideoUserContactEntryModelImpl videoUserContactEntryModelImpl = (VideoUserContactEntryModelImpl)videoUserContactEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, videoUserContactEntry, merge);

			videoUserContactEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VideoUserContactEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((videoUserContactEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(videoUserContactEntryModelImpl.getOriginalContactId()),
						Long.valueOf(videoUserContactEntryModelImpl.getOriginalVideoUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID_VIDEOUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID,
					args);

				args = new Object[] {
						Long.valueOf(videoUserContactEntryModelImpl.getContactId()),
						Long.valueOf(videoUserContactEntryModelImpl.getVideoUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTID_VIDEOUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID,
					args);
			}
		}

		EntityCacheUtil.putResult(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
			VideoUserContactEntryImpl.class,
			videoUserContactEntry.getPrimaryKey(), videoUserContactEntry);

		return videoUserContactEntry;
	}

	protected VideoUserContactEntry toUnwrappedModel(
		VideoUserContactEntry videoUserContactEntry) {
		if (videoUserContactEntry instanceof VideoUserContactEntryImpl) {
			return videoUserContactEntry;
		}

		VideoUserContactEntryImpl videoUserContactEntryImpl = new VideoUserContactEntryImpl();

		videoUserContactEntryImpl.setNew(videoUserContactEntry.isNew());
		videoUserContactEntryImpl.setPrimaryKey(videoUserContactEntry.getPrimaryKey());

		videoUserContactEntryImpl.setVideoUserContactId(videoUserContactEntry.getVideoUserContactId());
		videoUserContactEntryImpl.setVideoUserId(videoUserContactEntry.getVideoUserId());
		videoUserContactEntryImpl.setContactId(videoUserContactEntry.getContactId());
		videoUserContactEntryImpl.setCompanyId(videoUserContactEntry.getCompanyId());
		videoUserContactEntryImpl.setStartTime(videoUserContactEntry.getStartTime());
		videoUserContactEntryImpl.setEndTime(videoUserContactEntry.getEndTime());
		videoUserContactEntryImpl.setPriority(videoUserContactEntry.getPriority());
		videoUserContactEntryImpl.setStatus(videoUserContactEntry.getStatus());

		return videoUserContactEntryImpl;
	}

	/**
	 * Returns the video user contact entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user contact entry
	 * @return the video user contact entry
	 * @throws com.liferay.portal.NoSuchModelException if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserContactEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user contact entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchVideoUserContactEntryException} if it could not be found.
	 *
	 * @param videoUserContactId the primary key of the video user contact entry
	 * @return the video user contact entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserContactEntry findByPrimaryKey(long videoUserContactId)
		throws NoSuchVideoUserContactEntryException, SystemException {
		VideoUserContactEntry videoUserContactEntry = fetchByPrimaryKey(videoUserContactId);

		if (videoUserContactEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					videoUserContactId);
			}

			throw new NoSuchVideoUserContactEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				videoUserContactId);
		}

		return videoUserContactEntry;
	}

	/**
	 * Returns the video user contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video user contact entry
	 * @return the video user contact entry, or <code>null</code> if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VideoUserContactEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the video user contact entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoUserContactId the primary key of the video user contact entry
	 * @return the video user contact entry, or <code>null</code> if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserContactEntry fetchByPrimaryKey(long videoUserContactId)
		throws SystemException {
		VideoUserContactEntry videoUserContactEntry = (VideoUserContactEntry)EntityCacheUtil.getResult(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
				VideoUserContactEntryImpl.class, videoUserContactId);

		if (videoUserContactEntry == _nullVideoUserContactEntry) {
			return null;
		}

		if (videoUserContactEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				videoUserContactEntry = (VideoUserContactEntry)session.get(VideoUserContactEntryImpl.class,
						Long.valueOf(videoUserContactId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (videoUserContactEntry != null) {
					cacheResult(videoUserContactEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(VideoUserContactEntryModelImpl.ENTITY_CACHE_ENABLED,
						VideoUserContactEntryImpl.class, videoUserContactId,
						_nullVideoUserContactEntry);
				}

				closeSession(session);
			}
		}

		return videoUserContactEntry;
	}

	/**
	 * Returns all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @return the matching video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId) throws SystemException {
		return findByContactId_VideoUserId(contactId, videoUserId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @param start the lower bound of the range of video user contact entries
	 * @param end the upper bound of the range of video user contact entries (not inclusive)
	 * @return the range of matching video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end)
		throws SystemException {
		return findByContactId_VideoUserId(contactId, videoUserId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the video user contact entries where contactId = &#63; and videoUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @param start the lower bound of the range of video user contact entries
	 * @param end the upper bound of the range of video user contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserContactEntry> findByContactId_VideoUserId(
		long contactId, long videoUserId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID;
			finderArgs = new Object[] { contactId, videoUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTACTID_VIDEOUSERID;
			finderArgs = new Object[] {
					contactId, videoUserId,
					
					start, end, orderByComparator
				};
		}

		List<VideoUserContactEntry> list = (List<VideoUserContactEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_VIDEOUSERCONTACTENTRY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTID_VIDEOUSERID_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTID_VIDEOUSERID_VIDEOUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(VideoUserContactEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(videoUserId);

				list = (List<VideoUserContactEntry>)QueryUtil.list(q,
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
	 * Returns the first video user contact entry in the ordered set where contactId = &#63; and videoUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video user contact entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a matching video user contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserContactEntry findByContactId_VideoUserId_First(
		long contactId, long videoUserId, OrderByComparator orderByComparator)
		throws NoSuchVideoUserContactEntryException, SystemException {
		List<VideoUserContactEntry> list = findByContactId_VideoUserId(contactId,
				videoUserId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactId=");
			msg.append(contactId);

			msg.append(", videoUserId=");
			msg.append(videoUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserContactEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last video user contact entry in the ordered set where contactId = &#63; and videoUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video user contact entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a matching video user contact entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserContactEntry findByContactId_VideoUserId_Last(
		long contactId, long videoUserId, OrderByComparator orderByComparator)
		throws NoSuchVideoUserContactEntryException, SystemException {
		int count = countByContactId_VideoUserId(contactId, videoUserId);

		List<VideoUserContactEntry> list = findByContactId_VideoUserId(contactId,
				videoUserId, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactId=");
			msg.append(contactId);

			msg.append(", videoUserId=");
			msg.append(videoUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchVideoUserContactEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the video user contact entries before and after the current video user contact entry in the ordered set where contactId = &#63; and videoUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param videoUserContactId the primary key of the current video user contact entry
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video user contact entry
	 * @throws vn.com.fis.portal.NoSuchVideoUserContactEntryException if a video user contact entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public VideoUserContactEntry[] findByContactId_VideoUserId_PrevAndNext(
		long videoUserContactId, long contactId, long videoUserId,
		OrderByComparator orderByComparator)
		throws NoSuchVideoUserContactEntryException, SystemException {
		VideoUserContactEntry videoUserContactEntry = findByPrimaryKey(videoUserContactId);

		Session session = null;

		try {
			session = openSession();

			VideoUserContactEntry[] array = new VideoUserContactEntryImpl[3];

			array[0] = getByContactId_VideoUserId_PrevAndNext(session,
					videoUserContactEntry, contactId, videoUserId,
					orderByComparator, true);

			array[1] = videoUserContactEntry;

			array[2] = getByContactId_VideoUserId_PrevAndNext(session,
					videoUserContactEntry, contactId, videoUserId,
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

	protected VideoUserContactEntry getByContactId_VideoUserId_PrevAndNext(
		Session session, VideoUserContactEntry videoUserContactEntry,
		long contactId, long videoUserId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEOUSERCONTACTENTRY_WHERE);

		query.append(_FINDER_COLUMN_CONTACTID_VIDEOUSERID_CONTACTID_2);

		query.append(_FINDER_COLUMN_CONTACTID_VIDEOUSERID_VIDEOUSERID_2);

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
			query.append(VideoUserContactEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contactId);

		qPos.add(videoUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(videoUserContactEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VideoUserContactEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the video user contact entries.
	 *
	 * @return the video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserContactEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video user contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user contact entries
	 * @param end the upper bound of the range of video user contact entries (not inclusive)
	 * @return the range of video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserContactEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video user contact entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of video user contact entries
	 * @param end the upper bound of the range of video user contact entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<VideoUserContactEntry> findAll(int start, int end,
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

		List<VideoUserContactEntry> list = (List<VideoUserContactEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIDEOUSERCONTACTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEOUSERCONTACTENTRY.concat(VideoUserContactEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<VideoUserContactEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<VideoUserContactEntry>)QueryUtil.list(q,
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
	 * Removes all the video user contact entries where contactId = &#63; and videoUserId = &#63; from the database.
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByContactId_VideoUserId(long contactId, long videoUserId)
		throws SystemException {
		for (VideoUserContactEntry videoUserContactEntry : findByContactId_VideoUserId(
				contactId, videoUserId)) {
			remove(videoUserContactEntry);
		}
	}

	/**
	 * Removes all the video user contact entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (VideoUserContactEntry videoUserContactEntry : findAll()) {
			remove(videoUserContactEntry);
		}
	}

	/**
	 * Returns the number of video user contact entries where contactId = &#63; and videoUserId = &#63;.
	 *
	 * @param contactId the contact ID
	 * @param videoUserId the video user ID
	 * @return the number of matching video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByContactId_VideoUserId(long contactId, long videoUserId)
		throws SystemException {
		Object[] finderArgs = new Object[] { contactId, videoUserId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONTACTID_VIDEOUSERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEOUSERCONTACTENTRY_WHERE);

			query.append(_FINDER_COLUMN_CONTACTID_VIDEOUSERID_CONTACTID_2);

			query.append(_FINDER_COLUMN_CONTACTID_VIDEOUSERID_VIDEOUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contactId);

				qPos.add(videoUserId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTID_VIDEOUSERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of video user contact entries.
	 *
	 * @return the number of video user contact entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEOUSERCONTACTENTRY);

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
	 * Initializes the video user contact entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.VideoUserContactEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VideoUserContactEntry>> listenersList = new ArrayList<ModelListener<VideoUserContactEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VideoUserContactEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VideoUserContactEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_VIDEOUSERCONTACTENTRY = "SELECT videoUserContactEntry FROM VideoUserContactEntry videoUserContactEntry";
	private static final String _SQL_SELECT_VIDEOUSERCONTACTENTRY_WHERE = "SELECT videoUserContactEntry FROM VideoUserContactEntry videoUserContactEntry WHERE ";
	private static final String _SQL_COUNT_VIDEOUSERCONTACTENTRY = "SELECT COUNT(videoUserContactEntry) FROM VideoUserContactEntry videoUserContactEntry";
	private static final String _SQL_COUNT_VIDEOUSERCONTACTENTRY_WHERE = "SELECT COUNT(videoUserContactEntry) FROM VideoUserContactEntry videoUserContactEntry WHERE ";
	private static final String _FINDER_COLUMN_CONTACTID_VIDEOUSERID_CONTACTID_2 =
		"videoUserContactEntry.contactId = ? AND ";
	private static final String _FINDER_COLUMN_CONTACTID_VIDEOUSERID_VIDEOUSERID_2 =
		"videoUserContactEntry.videoUserId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "videoUserContactEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VideoUserContactEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VideoUserContactEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VideoUserContactEntryPersistenceImpl.class);
	private static VideoUserContactEntry _nullVideoUserContactEntry = new VideoUserContactEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VideoUserContactEntry> toCacheModel() {
				return _nullVideoUserContactEntryCacheModel;
			}
		};

	private static CacheModel<VideoUserContactEntry> _nullVideoUserContactEntryCacheModel =
		new CacheModel<VideoUserContactEntry>() {
			public VideoUserContactEntry toEntityModel() {
				return _nullVideoUserContactEntry;
			}
		};
}