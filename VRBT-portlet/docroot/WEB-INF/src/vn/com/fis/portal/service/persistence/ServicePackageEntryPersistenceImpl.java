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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.fis.portal.NoSuchServicePackageEntryException;
import vn.com.fis.portal.model.ServicePackageEntry;
import vn.com.fis.portal.model.impl.ServicePackageEntryImpl;
import vn.com.fis.portal.model.impl.ServicePackageEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service package entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ServicePackageEntryPersistence
 * @see ServicePackageEntryUtil
 * @generated
 */
public class ServicePackageEntryPersistenceImpl extends BasePersistenceImpl<ServicePackageEntry>
	implements ServicePackageEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServicePackageEntryUtil} to access the service package entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServicePackageEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the service package entry in the entity cache if it is enabled.
	 *
	 * @param servicePackageEntry the service package entry
	 */
	public void cacheResult(ServicePackageEntry servicePackageEntry) {
		EntityCacheUtil.putResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryImpl.class, servicePackageEntry.getPrimaryKey(),
			servicePackageEntry);

		servicePackageEntry.resetOriginalValues();
	}

	/**
	 * Caches the service package entries in the entity cache if it is enabled.
	 *
	 * @param servicePackageEntries the service package entries
	 */
	public void cacheResult(List<ServicePackageEntry> servicePackageEntries) {
		for (ServicePackageEntry servicePackageEntry : servicePackageEntries) {
			if (EntityCacheUtil.getResult(
						ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
						ServicePackageEntryImpl.class,
						servicePackageEntry.getPrimaryKey()) == null) {
				cacheResult(servicePackageEntry);
			}
			else {
				servicePackageEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service package entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServicePackageEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServicePackageEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service package entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServicePackageEntry servicePackageEntry) {
		EntityCacheUtil.removeResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryImpl.class, servicePackageEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ServicePackageEntry> servicePackageEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServicePackageEntry servicePackageEntry : servicePackageEntries) {
			EntityCacheUtil.removeResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServicePackageEntryImpl.class,
				servicePackageEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service package entry with the primary key. Does not add the service package entry to the database.
	 *
	 * @param servicePackageId the primary key for the new service package entry
	 * @return the new service package entry
	 */
	public ServicePackageEntry create(long servicePackageId) {
		ServicePackageEntry servicePackageEntry = new ServicePackageEntryImpl();

		servicePackageEntry.setNew(true);
		servicePackageEntry.setPrimaryKey(servicePackageId);

		return servicePackageEntry;
	}

	/**
	 * Removes the service package entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param servicePackageId the primary key of the service package entry
	 * @return the service package entry that was removed
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry remove(long servicePackageId)
		throws NoSuchServicePackageEntryException, SystemException {
		return remove(Long.valueOf(servicePackageId));
	}

	/**
	 * Removes the service package entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service package entry
	 * @return the service package entry that was removed
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServicePackageEntry remove(Serializable primaryKey)
		throws NoSuchServicePackageEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServicePackageEntry servicePackageEntry = (ServicePackageEntry)session.get(ServicePackageEntryImpl.class,
					primaryKey);

			if (servicePackageEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServicePackageEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(servicePackageEntry);
		}
		catch (NoSuchServicePackageEntryException nsee) {
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
	protected ServicePackageEntry removeImpl(
		ServicePackageEntry servicePackageEntry) throws SystemException {
		servicePackageEntry = toUnwrappedModel(servicePackageEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, servicePackageEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(servicePackageEntry);

		return servicePackageEntry;
	}

	@Override
	public ServicePackageEntry updateImpl(
		vn.com.fis.portal.model.ServicePackageEntry servicePackageEntry,
		boolean merge) throws SystemException {
		servicePackageEntry = toUnwrappedModel(servicePackageEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, servicePackageEntry, merge);

			servicePackageEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		EntityCacheUtil.putResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryImpl.class, servicePackageEntry.getPrimaryKey(),
			servicePackageEntry);

		return servicePackageEntry;
	}

	protected ServicePackageEntry toUnwrappedModel(
		ServicePackageEntry servicePackageEntry) {
		if (servicePackageEntry instanceof ServicePackageEntryImpl) {
			return servicePackageEntry;
		}

		ServicePackageEntryImpl servicePackageEntryImpl = new ServicePackageEntryImpl();

		servicePackageEntryImpl.setNew(servicePackageEntry.isNew());
		servicePackageEntryImpl.setPrimaryKey(servicePackageEntry.getPrimaryKey());

		servicePackageEntryImpl.setServicePackageId(servicePackageEntry.getServicePackageId());
		servicePackageEntryImpl.setServicePackageName(servicePackageEntry.getServicePackageName());
		servicePackageEntryImpl.setServicePackageCode(servicePackageEntry.getServicePackageCode());
		servicePackageEntryImpl.setDescription(servicePackageEntry.getDescription());
		servicePackageEntryImpl.setTotalFile(servicePackageEntry.getTotalFile());
		servicePackageEntryImpl.setCreateDate(servicePackageEntry.getCreateDate());
		servicePackageEntryImpl.setModifiedDate(servicePackageEntry.getModifiedDate());
		servicePackageEntryImpl.setServiceId(servicePackageEntry.getServiceId());
		servicePackageEntryImpl.setStatus(servicePackageEntry.getStatus());

		return servicePackageEntryImpl;
	}

	/**
	 * Returns the service package entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service package entry
	 * @return the service package entry
	 * @throws com.liferay.portal.NoSuchModelException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServicePackageEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the service package entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchServicePackageEntryException} if it could not be found.
	 *
	 * @param servicePackageId the primary key of the service package entry
	 * @return the service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByPrimaryKey(long servicePackageId)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = fetchByPrimaryKey(servicePackageId);

		if (servicePackageEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + servicePackageId);
			}

			throw new NoSuchServicePackageEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				servicePackageId);
		}

		return servicePackageEntry;
	}

	/**
	 * Returns the service package entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service package entry
	 * @return the service package entry, or <code>null</code> if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServicePackageEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the service package entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param servicePackageId the primary key of the service package entry
	 * @return the service package entry, or <code>null</code> if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry fetchByPrimaryKey(long servicePackageId)
		throws SystemException {
		ServicePackageEntry servicePackageEntry = (ServicePackageEntry)EntityCacheUtil.getResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServicePackageEntryImpl.class, servicePackageId);

		if (servicePackageEntry == _nullServicePackageEntry) {
			return null;
		}

		if (servicePackageEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				servicePackageEntry = (ServicePackageEntry)session.get(ServicePackageEntryImpl.class,
						Long.valueOf(servicePackageId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (servicePackageEntry != null) {
					cacheResult(servicePackageEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
						ServicePackageEntryImpl.class, servicePackageId,
						_nullServicePackageEntry);
				}

				closeSession(session);
			}
		}

		return servicePackageEntry;
	}

	/**
	 * Returns all the service package entries.
	 *
	 * @return the service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service package entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @return the range of service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service package entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findAll(int start, int end,
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

		List<ServicePackageEntry> list = (List<ServicePackageEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEPACKAGEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEPACKAGEENTRY.concat(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ServicePackageEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ServicePackageEntry>)QueryUtil.list(q,
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
	 * Removes all the service package entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ServicePackageEntry servicePackageEntry : findAll()) {
			remove(servicePackageEntry);
		}
	}

	/**
	 * Returns the number of service package entries.
	 *
	 * @return the number of service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVICEPACKAGEENTRY);

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
	 * Initializes the service package entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ServicePackageEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServicePackageEntry>> listenersList = new ArrayList<ModelListener<ServicePackageEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServicePackageEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServicePackageEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_SERVICEPACKAGEENTRY = "SELECT servicePackageEntry FROM ServicePackageEntry servicePackageEntry";
	private static final String _SQL_COUNT_SERVICEPACKAGEENTRY = "SELECT COUNT(servicePackageEntry) FROM ServicePackageEntry servicePackageEntry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "servicePackageEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServicePackageEntry exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServicePackageEntryPersistenceImpl.class);
	private static ServicePackageEntry _nullServicePackageEntry = new ServicePackageEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServicePackageEntry> toCacheModel() {
				return _nullServicePackageEntryCacheModel;
			}
		};

	private static CacheModel<ServicePackageEntry> _nullServicePackageEntryCacheModel =
		new CacheModel<ServicePackageEntry>() {
			public ServicePackageEntry toEntityModel() {
				return _nullServicePackageEntry;
			}
		};
}