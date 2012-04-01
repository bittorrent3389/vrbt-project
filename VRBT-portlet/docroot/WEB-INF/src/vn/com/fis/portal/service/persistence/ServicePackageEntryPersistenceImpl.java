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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Integer.class.getName() },
			ServicePackageEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEID =
		new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByserviceId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID =
		new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByserviceId",
			new String[] { Long.class.getName() },
			ServicePackageEntryModelImpl.SERVICEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEID = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByserviceId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEID_STATUS =
		new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByserviceId_Status",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID_STATUS =
		new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByserviceId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ServicePackageEntryModelImpl.SERVICEID_COLUMN_BITMASK |
			ServicePackageEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEID_STATUS = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByserviceId_Status",
			new String[] { Long.class.getName(), Integer.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByservicePackageCode",
			new String[] { String.class.getName() },
			ServicePackageEntryModelImpl.SERVICEPACKAGECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEPACKAGECODE = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByservicePackageCode", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED,
			ServicePackageEntryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByservicePackageName",
			new String[] { String.class.getName() },
			ServicePackageEntryModelImpl.SERVICEPACKAGENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICEPACKAGENAME = new FinderPath(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByservicePackageName", new String[] { String.class.getName() });
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

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
			new Object[] { servicePackageEntry.getServicePackageCode() },
			servicePackageEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
			new Object[] { servicePackageEntry.getServicePackageName() },
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

		clearUniqueFindersCache(servicePackageEntry);
	}

	@Override
	public void clearCache(List<ServicePackageEntry> servicePackageEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServicePackageEntry servicePackageEntry : servicePackageEntries) {
			EntityCacheUtil.removeResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServicePackageEntryImpl.class,
				servicePackageEntry.getPrimaryKey());

			clearUniqueFindersCache(servicePackageEntry);
		}
	}

	protected void clearUniqueFindersCache(
		ServicePackageEntry servicePackageEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
			new Object[] { servicePackageEntry.getServicePackageCode() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
			new Object[] { servicePackageEntry.getServicePackageName() });
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

		boolean isNew = servicePackageEntry.isNew();

		ServicePackageEntryModelImpl servicePackageEntryModelImpl = (ServicePackageEntryModelImpl)servicePackageEntry;

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

		if (isNew || !ServicePackageEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((servicePackageEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(servicePackageEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Integer.valueOf(servicePackageEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((servicePackageEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(servicePackageEntryModelImpl.getOriginalServiceId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID,
					args);

				args = new Object[] {
						Long.valueOf(servicePackageEntryModelImpl.getServiceId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID,
					args);
			}

			if ((servicePackageEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(servicePackageEntryModelImpl.getOriginalServiceId()),
						Integer.valueOf(servicePackageEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID_STATUS,
					args);

				args = new Object[] {
						Long.valueOf(servicePackageEntryModelImpl.getServiceId()),
						Integer.valueOf(servicePackageEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEID_STATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ServicePackageEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServicePackageEntryImpl.class, servicePackageEntry.getPrimaryKey(),
			servicePackageEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
				new Object[] { servicePackageEntry.getServicePackageCode() },
				servicePackageEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
				new Object[] { servicePackageEntry.getServicePackageName() },
				servicePackageEntry);
		}
		else {
			if ((servicePackageEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						servicePackageEntryModelImpl.getOriginalServicePackageCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEPACKAGECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
					new Object[] { servicePackageEntry.getServicePackageCode() },
					servicePackageEntry);
			}

			if ((servicePackageEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						servicePackageEntryModelImpl.getOriginalServicePackageName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICEPACKAGENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
					new Object[] { servicePackageEntry.getServicePackageName() },
					servicePackageEntry);
			}
		}

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
	 * Returns all the service package entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findBystatus(int status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service package entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @return the range of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findBystatus(int status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service package entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findBystatus(int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ServicePackageEntry> list = (List<ServicePackageEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ServicePackageEntry>)QueryUtil.list(q,
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
	 * Returns the first service package entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findBystatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		List<ServicePackageEntry> list = findBystatus(status, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServicePackageEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service package entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findBystatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		int count = countBystatus(status);

		List<ServicePackageEntry> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServicePackageEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service package entries before and after the current service package entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param servicePackageId the primary key of the current service package entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry[] findBystatus_PrevAndNext(
		long servicePackageId, int status, OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = findByPrimaryKey(servicePackageId);

		Session session = null;

		try {
			session = openSession();

			ServicePackageEntry[] array = new ServicePackageEntryImpl[3];

			array[0] = getBystatus_PrevAndNext(session, servicePackageEntry,
					status, orderByComparator, true);

			array[1] = servicePackageEntry;

			array[2] = getBystatus_PrevAndNext(session, servicePackageEntry,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServicePackageEntry getBystatus_PrevAndNext(Session session,
		ServicePackageEntry servicePackageEntry, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

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
			query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(servicePackageEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServicePackageEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service package entries where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @return the matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findByserviceId(long serviceId)
		throws SystemException {
		return findByserviceId(serviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the service package entries where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @return the range of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findByserviceId(long serviceId, int start,
		int end) throws SystemException {
		return findByserviceId(serviceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service package entries where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findByserviceId(long serviceId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID;
			finderArgs = new Object[] { serviceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEID;
			finderArgs = new Object[] { serviceId, start, end, orderByComparator };
		}

		List<ServicePackageEntry> list = (List<ServicePackageEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceId);

				list = (List<ServicePackageEntry>)QueryUtil.list(q,
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
	 * Returns the first service package entry in the ordered set where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByserviceId_First(long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		List<ServicePackageEntry> list = findByserviceId(serviceId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceId=");
			msg.append(serviceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServicePackageEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service package entry in the ordered set where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByserviceId_Last(long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		int count = countByserviceId(serviceId);

		List<ServicePackageEntry> list = findByserviceId(serviceId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceId=");
			msg.append(serviceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServicePackageEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service package entries before and after the current service package entry in the ordered set where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param servicePackageId the primary key of the current service package entry
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry[] findByserviceId_PrevAndNext(
		long servicePackageId, long serviceId,
		OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = findByPrimaryKey(servicePackageId);

		Session session = null;

		try {
			session = openSession();

			ServicePackageEntry[] array = new ServicePackageEntryImpl[3];

			array[0] = getByserviceId_PrevAndNext(session, servicePackageEntry,
					serviceId, orderByComparator, true);

			array[1] = servicePackageEntry;

			array[2] = getByserviceId_PrevAndNext(session, servicePackageEntry,
					serviceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServicePackageEntry getByserviceId_PrevAndNext(Session session,
		ServicePackageEntry servicePackageEntry, long serviceId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

		query.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

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
			query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(servicePackageEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServicePackageEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service package entries where serviceId = &#63; and status = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @return the matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findByserviceId_Status(long serviceId,
		int status) throws SystemException {
		return findByserviceId_Status(serviceId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service package entries where serviceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @return the range of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findByserviceId_Status(long serviceId,
		int status, int start, int end) throws SystemException {
		return findByserviceId_Status(serviceId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service package entries where serviceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @param start the lower bound of the range of service package entries
	 * @param end the upper bound of the range of service package entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServicePackageEntry> findByserviceId_Status(long serviceId,
		int status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SERVICEID_STATUS;
			finderArgs = new Object[] { serviceId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SERVICEID_STATUS;
			finderArgs = new Object[] {
					serviceId, status,
					
					start, end, orderByComparator
				};
		}

		List<ServicePackageEntry> list = (List<ServicePackageEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_SERVICEID_STATUS_SERVICEID_2);

			query.append(_FINDER_COLUMN_SERVICEID_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceId);

				qPos.add(status);

				list = (List<ServicePackageEntry>)QueryUtil.list(q,
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
	 * Returns the first service package entry in the ordered set where serviceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByserviceId_Status_First(long serviceId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		List<ServicePackageEntry> list = findByserviceId_Status(serviceId,
				status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceId=");
			msg.append(serviceId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServicePackageEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service package entry in the ordered set where serviceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByserviceId_Status_Last(long serviceId,
		int status, OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		int count = countByserviceId_Status(serviceId, status);

		List<ServicePackageEntry> list = findByserviceId_Status(serviceId,
				status, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceId=");
			msg.append(serviceId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServicePackageEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service package entries before and after the current service package entry in the ordered set where serviceId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param servicePackageId the primary key of the current service package entry
	 * @param serviceId the service ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a service package entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry[] findByserviceId_Status_PrevAndNext(
		long servicePackageId, long serviceId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = findByPrimaryKey(servicePackageId);

		Session session = null;

		try {
			session = openSession();

			ServicePackageEntry[] array = new ServicePackageEntryImpl[3];

			array[0] = getByserviceId_Status_PrevAndNext(session,
					servicePackageEntry, serviceId, status, orderByComparator,
					true);

			array[1] = servicePackageEntry;

			array[2] = getByserviceId_Status_PrevAndNext(session,
					servicePackageEntry, serviceId, status, orderByComparator,
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

	protected ServicePackageEntry getByserviceId_Status_PrevAndNext(
		Session session, ServicePackageEntry servicePackageEntry,
		long serviceId, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

		query.append(_FINDER_COLUMN_SERVICEID_STATUS_SERVICEID_2);

		query.append(_FINDER_COLUMN_SERVICEID_STATUS_STATUS_2);

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
			query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(serviceId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(servicePackageEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServicePackageEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns the service package entry where servicePackageCode = &#63; or throws a {@link vn.com.fis.portal.NoSuchServicePackageEntryException} if it could not be found.
	 *
	 * @param servicePackageCode the service package code
	 * @return the matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByservicePackageCode(
		String servicePackageCode)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = fetchByservicePackageCode(servicePackageCode);

		if (servicePackageEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("servicePackageCode=");
			msg.append(servicePackageCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServicePackageEntryException(msg.toString());
		}

		return servicePackageEntry;
	}

	/**
	 * Returns the service package entry where servicePackageCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param servicePackageCode the service package code
	 * @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry fetchByservicePackageCode(
		String servicePackageCode) throws SystemException {
		return fetchByservicePackageCode(servicePackageCode, true);
	}

	/**
	 * Returns the service package entry where servicePackageCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param servicePackageCode the service package code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry fetchByservicePackageCode(
		String servicePackageCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { servicePackageCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

			if (servicePackageCode == null) {
				query.append(_FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_1);
			}
			else {
				if (servicePackageCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_2);
				}
			}

			query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (servicePackageCode != null) {
					qPos.add(servicePackageCode);
				}

				List<ServicePackageEntry> list = q.list();

				result = list;

				ServicePackageEntry servicePackageEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
						finderArgs, list);
				}
				else {
					servicePackageEntry = list.get(0);

					cacheResult(servicePackageEntry);

					if ((servicePackageEntry.getServicePackageCode() == null) ||
							!servicePackageEntry.getServicePackageCode()
													.equals(servicePackageCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
							finderArgs, servicePackageEntry);
					}
				}

				return servicePackageEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGECODE,
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
				return (ServicePackageEntry)result;
			}
		}
	}

	/**
	 * Returns the service package entry where servicePackageName = &#63; or throws a {@link vn.com.fis.portal.NoSuchServicePackageEntryException} if it could not be found.
	 *
	 * @param servicePackageName the service package name
	 * @return the matching service package entry
	 * @throws vn.com.fis.portal.NoSuchServicePackageEntryException if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry findByservicePackageName(
		String servicePackageName)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = fetchByservicePackageName(servicePackageName);

		if (servicePackageEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("servicePackageName=");
			msg.append(servicePackageName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServicePackageEntryException(msg.toString());
		}

		return servicePackageEntry;
	}

	/**
	 * Returns the service package entry where servicePackageName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param servicePackageName the service package name
	 * @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry fetchByservicePackageName(
		String servicePackageName) throws SystemException {
		return fetchByservicePackageName(servicePackageName, true);
	}

	/**
	 * Returns the service package entry where servicePackageName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param servicePackageName the service package name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service package entry, or <code>null</code> if a matching service package entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServicePackageEntry fetchByservicePackageName(
		String servicePackageName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { servicePackageName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SERVICEPACKAGEENTRY_WHERE);

			if (servicePackageName == null) {
				query.append(_FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_1);
			}
			else {
				if (servicePackageName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_2);
				}
			}

			query.append(ServicePackageEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (servicePackageName != null) {
					qPos.add(servicePackageName);
				}

				List<ServicePackageEntry> list = q.list();

				result = list;

				ServicePackageEntry servicePackageEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
						finderArgs, list);
				}
				else {
					servicePackageEntry = list.get(0);

					cacheResult(servicePackageEntry);

					if ((servicePackageEntry.getServicePackageName() == null) ||
							!servicePackageEntry.getServicePackageName()
													.equals(servicePackageName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
							finderArgs, servicePackageEntry);
					}
				}

				return servicePackageEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICEPACKAGENAME,
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
				return (ServicePackageEntry)result;
			}
		}
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
	 * Removes all the service package entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBystatus(int status) throws SystemException {
		for (ServicePackageEntry servicePackageEntry : findBystatus(status)) {
			remove(servicePackageEntry);
		}
	}

	/**
	 * Removes all the service package entries where serviceId = &#63; from the database.
	 *
	 * @param serviceId the service ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByserviceId(long serviceId) throws SystemException {
		for (ServicePackageEntry servicePackageEntry : findByserviceId(
				serviceId)) {
			remove(servicePackageEntry);
		}
	}

	/**
	 * Removes all the service package entries where serviceId = &#63; and status = &#63; from the database.
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByserviceId_Status(long serviceId, int status)
		throws SystemException {
		for (ServicePackageEntry servicePackageEntry : findByserviceId_Status(
				serviceId, status)) {
			remove(servicePackageEntry);
		}
	}

	/**
	 * Removes the service package entry where servicePackageCode = &#63; from the database.
	 *
	 * @param servicePackageCode the service package code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByservicePackageCode(String servicePackageCode)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = findByservicePackageCode(servicePackageCode);

		remove(servicePackageEntry);
	}

	/**
	 * Removes the service package entry where servicePackageName = &#63; from the database.
	 *
	 * @param servicePackageName the service package name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByservicePackageName(String servicePackageName)
		throws NoSuchServicePackageEntryException, SystemException {
		ServicePackageEntry servicePackageEntry = findByservicePackageName(servicePackageName);

		remove(servicePackageEntry);
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
	 * Returns the number of service package entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countBystatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEPACKAGEENTRY_WHERE);

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
	 * Returns the number of service package entries where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @return the number of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByserviceId(long serviceId) throws SystemException {
		Object[] finderArgs = new Object[] { serviceId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVICEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEPACKAGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVICEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service package entries where serviceId = &#63; and status = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param status the status
	 * @return the number of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByserviceId_Status(long serviceId, int status)
		throws SystemException {
		Object[] finderArgs = new Object[] { serviceId, status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVICEID_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICEPACKAGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_SERVICEID_STATUS_SERVICEID_2);

			query.append(_FINDER_COLUMN_SERVICEID_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(serviceId);

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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVICEID_STATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service package entries where servicePackageCode = &#63;.
	 *
	 * @param servicePackageCode the service package code
	 * @return the number of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByservicePackageCode(String servicePackageCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { servicePackageCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVICEPACKAGECODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEPACKAGEENTRY_WHERE);

			if (servicePackageCode == null) {
				query.append(_FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_1);
			}
			else {
				if (servicePackageCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (servicePackageCode != null) {
					qPos.add(servicePackageCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVICEPACKAGECODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service package entries where servicePackageName = &#63;.
	 *
	 * @param servicePackageName the service package name
	 * @return the number of matching service package entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByservicePackageName(String servicePackageName)
		throws SystemException {
		Object[] finderArgs = new Object[] { servicePackageName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVICEPACKAGENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEPACKAGEENTRY_WHERE);

			if (servicePackageName == null) {
				query.append(_FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_1);
			}
			else {
				if (servicePackageName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (servicePackageName != null) {
					qPos.add(servicePackageName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVICEPACKAGENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
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

	@BeanReference(type = CategoryEntyPersistence.class)
	protected CategoryEntyPersistence categoryEntyPersistence;
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
	private static final String _SQL_SELECT_SERVICEPACKAGEENTRY_WHERE = "SELECT servicePackageEntry FROM ServicePackageEntry servicePackageEntry WHERE ";
	private static final String _SQL_COUNT_SERVICEPACKAGEENTRY = "SELECT COUNT(servicePackageEntry) FROM ServicePackageEntry servicePackageEntry";
	private static final String _SQL_COUNT_SERVICEPACKAGEENTRY_WHERE = "SELECT COUNT(servicePackageEntry) FROM ServicePackageEntry servicePackageEntry WHERE ";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "servicePackageEntry.status = ?";
	private static final String _FINDER_COLUMN_SERVICEID_SERVICEID_2 = "servicePackageEntry.serviceId = ?";
	private static final String _FINDER_COLUMN_SERVICEID_STATUS_SERVICEID_2 = "servicePackageEntry.serviceId = ? AND ";
	private static final String _FINDER_COLUMN_SERVICEID_STATUS_STATUS_2 = "servicePackageEntry.status = ?";
	private static final String _FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_1 =
		"servicePackageEntry.servicePackageCode IS NULL";
	private static final String _FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_2 =
		"servicePackageEntry.servicePackageCode = ?";
	private static final String _FINDER_COLUMN_SERVICEPACKAGECODE_SERVICEPACKAGECODE_3 =
		"(servicePackageEntry.servicePackageCode IS NULL OR servicePackageEntry.servicePackageCode = ?)";
	private static final String _FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_1 =
		"servicePackageEntry.servicePackageName IS NULL";
	private static final String _FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_2 =
		"servicePackageEntry.servicePackageName = ?";
	private static final String _FINDER_COLUMN_SERVICEPACKAGENAME_SERVICEPACKAGENAME_3 =
		"(servicePackageEntry.servicePackageName IS NULL OR servicePackageEntry.servicePackageName = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "servicePackageEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServicePackageEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServicePackageEntry exists with the key {";
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