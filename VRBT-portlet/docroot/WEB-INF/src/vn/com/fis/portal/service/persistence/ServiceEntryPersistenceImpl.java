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

import vn.com.fis.portal.NoSuchServiceEntryException;
import vn.com.fis.portal.model.ServiceEntry;
import vn.com.fis.portal.model.impl.ServiceEntryImpl;
import vn.com.fis.portal.model.impl.ServiceEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the service entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ServiceEntryPersistence
 * @see ServiceEntryUtil
 * @generated
 */
public class ServiceEntryPersistenceImpl extends BasePersistenceImpl<ServiceEntry>
	implements ServiceEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceEntryUtil} to access the service entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_SERVICECODE = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, ServiceEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByserviceCode",
			new String[] { String.class.getName() },
			ServiceEntryModelImpl.SERVICECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICECODE = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByserviceCode",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_SERVICENAME = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, ServiceEntryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByserviceName",
			new String[] { String.class.getName() },
			ServiceEntryModelImpl.SERVICENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SERVICENAME = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByserviceName",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, ServiceEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, ServiceEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { Integer.class.getName() },
			ServiceEntryModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, ServiceEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, ServiceEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the service entry in the entity cache if it is enabled.
	 *
	 * @param serviceEntry the service entry
	 */
	public void cacheResult(ServiceEntry serviceEntry) {
		EntityCacheUtil.putResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryImpl.class, serviceEntry.getPrimaryKey(), serviceEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICECODE,
			new Object[] { serviceEntry.getServiceCode() }, serviceEntry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICENAME,
			new Object[] { serviceEntry.getServiceName() }, serviceEntry);

		serviceEntry.resetOriginalValues();
	}

	/**
	 * Caches the service entries in the entity cache if it is enabled.
	 *
	 * @param serviceEntries the service entries
	 */
	public void cacheResult(List<ServiceEntry> serviceEntries) {
		for (ServiceEntry serviceEntry : serviceEntries) {
			if (EntityCacheUtil.getResult(
						ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
						ServiceEntryImpl.class, serviceEntry.getPrimaryKey()) == null) {
				cacheResult(serviceEntry);
			}
			else {
				serviceEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceEntry serviceEntry) {
		EntityCacheUtil.removeResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryImpl.class, serviceEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(serviceEntry);
	}

	@Override
	public void clearCache(List<ServiceEntry> serviceEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceEntry serviceEntry : serviceEntries) {
			EntityCacheUtil.removeResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServiceEntryImpl.class, serviceEntry.getPrimaryKey());

			clearUniqueFindersCache(serviceEntry);
		}
	}

	protected void clearUniqueFindersCache(ServiceEntry serviceEntry) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICECODE,
			new Object[] { serviceEntry.getServiceCode() });

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICENAME,
			new Object[] { serviceEntry.getServiceName() });
	}

	/**
	 * Creates a new service entry with the primary key. Does not add the service entry to the database.
	 *
	 * @param serviceId the primary key for the new service entry
	 * @return the new service entry
	 */
	public ServiceEntry create(long serviceId) {
		ServiceEntry serviceEntry = new ServiceEntryImpl();

		serviceEntry.setNew(true);
		serviceEntry.setPrimaryKey(serviceId);

		return serviceEntry;
	}

	/**
	 * Removes the service entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param serviceId the primary key of the service entry
	 * @return the service entry that was removed
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry remove(long serviceId)
		throws NoSuchServiceEntryException, SystemException {
		return remove(Long.valueOf(serviceId));
	}

	/**
	 * Removes the service entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service entry
	 * @return the service entry that was removed
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceEntry remove(Serializable primaryKey)
		throws NoSuchServiceEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceEntry serviceEntry = (ServiceEntry)session.get(ServiceEntryImpl.class,
					primaryKey);

			if (serviceEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceEntry);
		}
		catch (NoSuchServiceEntryException nsee) {
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
	protected ServiceEntry removeImpl(ServiceEntry serviceEntry)
		throws SystemException {
		serviceEntry = toUnwrappedModel(serviceEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, serviceEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(serviceEntry);

		return serviceEntry;
	}

	@Override
	public ServiceEntry updateImpl(
		vn.com.fis.portal.model.ServiceEntry serviceEntry, boolean merge)
		throws SystemException {
		serviceEntry = toUnwrappedModel(serviceEntry);

		boolean isNew = serviceEntry.isNew();

		ServiceEntryModelImpl serviceEntryModelImpl = (ServiceEntryModelImpl)serviceEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, serviceEntry, merge);

			serviceEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(serviceEntryModelImpl.getOriginalStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						Integer.valueOf(serviceEntryModelImpl.getStatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryImpl.class, serviceEntry.getPrimaryKey(), serviceEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICECODE,
				new Object[] { serviceEntry.getServiceCode() }, serviceEntry);

			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICENAME,
				new Object[] { serviceEntry.getServiceName() }, serviceEntry);
		}
		else {
			if ((serviceEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SERVICECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceEntryModelImpl.getOriginalServiceCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICECODE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICECODE,
					new Object[] { serviceEntry.getServiceCode() }, serviceEntry);
			}

			if ((serviceEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SERVICENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceEntryModelImpl.getOriginalServiceName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SERVICENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICENAME,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICENAME,
					new Object[] { serviceEntry.getServiceName() }, serviceEntry);
			}
		}

		return serviceEntry;
	}

	protected ServiceEntry toUnwrappedModel(ServiceEntry serviceEntry) {
		if (serviceEntry instanceof ServiceEntryImpl) {
			return serviceEntry;
		}

		ServiceEntryImpl serviceEntryImpl = new ServiceEntryImpl();

		serviceEntryImpl.setNew(serviceEntry.isNew());
		serviceEntryImpl.setPrimaryKey(serviceEntry.getPrimaryKey());

		serviceEntryImpl.setServiceId(serviceEntry.getServiceId());
		serviceEntryImpl.setServiceCode(serviceEntry.getServiceCode());
		serviceEntryImpl.setServiceName(serviceEntry.getServiceName());
		serviceEntryImpl.setDescription(serviceEntry.getDescription());
		serviceEntryImpl.setCreateDate(serviceEntry.getCreateDate());
		serviceEntryImpl.setModifiedDate(serviceEntry.getModifiedDate());
		serviceEntryImpl.setStatus(serviceEntry.getStatus());

		return serviceEntryImpl;
	}

	/**
	 * Returns the service entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service entry
	 * @return the service entry
	 * @throws com.liferay.portal.NoSuchModelException if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the service entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchServiceEntryException} if it could not be found.
	 *
	 * @param serviceId the primary key of the service entry
	 * @return the service entry
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry findByPrimaryKey(long serviceId)
		throws NoSuchServiceEntryException, SystemException {
		ServiceEntry serviceEntry = fetchByPrimaryKey(serviceId);

		if (serviceEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + serviceId);
			}

			throw new NoSuchServiceEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				serviceId);
		}

		return serviceEntry;
	}

	/**
	 * Returns the service entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service entry
	 * @return the service entry, or <code>null</code> if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the service entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param serviceId the primary key of the service entry
	 * @return the service entry, or <code>null</code> if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry fetchByPrimaryKey(long serviceId)
		throws SystemException {
		ServiceEntry serviceEntry = (ServiceEntry)EntityCacheUtil.getResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServiceEntryImpl.class, serviceId);

		if (serviceEntry == _nullServiceEntry) {
			return null;
		}

		if (serviceEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				serviceEntry = (ServiceEntry)session.get(ServiceEntryImpl.class,
						Long.valueOf(serviceId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (serviceEntry != null) {
					cacheResult(serviceEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
						ServiceEntryImpl.class, serviceId, _nullServiceEntry);
				}

				closeSession(session);
			}
		}

		return serviceEntry;
	}

	/**
	 * Returns the service entry where serviceCode = &#63; or throws a {@link vn.com.fis.portal.NoSuchServiceEntryException} if it could not be found.
	 *
	 * @param serviceCode the service code
	 * @return the matching service entry
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry findByserviceCode(String serviceCode)
		throws NoSuchServiceEntryException, SystemException {
		ServiceEntry serviceEntry = fetchByserviceCode(serviceCode);

		if (serviceEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceCode=");
			msg.append(serviceCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServiceEntryException(msg.toString());
		}

		return serviceEntry;
	}

	/**
	 * Returns the service entry where serviceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceCode the service code
	 * @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry fetchByserviceCode(String serviceCode)
		throws SystemException {
		return fetchByserviceCode(serviceCode, true);
	}

	/**
	 * Returns the service entry where serviceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceCode the service code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry fetchByserviceCode(String serviceCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { serviceCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SERVICECODE,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SERVICEENTRY_WHERE);

			if (serviceCode == null) {
				query.append(_FINDER_COLUMN_SERVICECODE_SERVICECODE_1);
			}
			else {
				if (serviceCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICECODE_SERVICECODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICECODE_SERVICECODE_2);
				}
			}

			query.append(ServiceEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (serviceCode != null) {
					qPos.add(serviceCode);
				}

				List<ServiceEntry> list = q.list();

				result = list;

				ServiceEntry serviceEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICECODE,
						finderArgs, list);
				}
				else {
					serviceEntry = list.get(0);

					cacheResult(serviceEntry);

					if ((serviceEntry.getServiceCode() == null) ||
							!serviceEntry.getServiceCode().equals(serviceCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICECODE,
							finderArgs, serviceEntry);
					}
				}

				return serviceEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICECODE,
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
				return (ServiceEntry)result;
			}
		}
	}

	/**
	 * Returns the service entry where serviceName = &#63; or throws a {@link vn.com.fis.portal.NoSuchServiceEntryException} if it could not be found.
	 *
	 * @param serviceName the service name
	 * @return the matching service entry
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry findByserviceName(String serviceName)
		throws NoSuchServiceEntryException, SystemException {
		ServiceEntry serviceEntry = fetchByserviceName(serviceName);

		if (serviceEntry == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serviceName=");
			msg.append(serviceName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchServiceEntryException(msg.toString());
		}

		return serviceEntry;
	}

	/**
	 * Returns the service entry where serviceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceName the service name
	 * @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry fetchByserviceName(String serviceName)
		throws SystemException {
		return fetchByserviceName(serviceName, true);
	}

	/**
	 * Returns the service entry where serviceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceName the service name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching service entry, or <code>null</code> if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry fetchByserviceName(String serviceName,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { serviceName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SERVICENAME,
					finderArgs, this);
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SERVICEENTRY_WHERE);

			if (serviceName == null) {
				query.append(_FINDER_COLUMN_SERVICENAME_SERVICENAME_1);
			}
			else {
				if (serviceName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICENAME_SERVICENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICENAME_SERVICENAME_2);
				}
			}

			query.append(ServiceEntryModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (serviceName != null) {
					qPos.add(serviceName);
				}

				List<ServiceEntry> list = q.list();

				result = list;

				ServiceEntry serviceEntry = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICENAME,
						finderArgs, list);
				}
				else {
					serviceEntry = list.get(0);

					cacheResult(serviceEntry);

					if ((serviceEntry.getServiceName() == null) ||
							!serviceEntry.getServiceName().equals(serviceName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICENAME,
							finderArgs, serviceEntry);
					}
				}

				return serviceEntry;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SERVICENAME,
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
				return (ServiceEntry)result;
			}
		}
	}

	/**
	 * Returns all the service entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceEntry> findBystatus(int status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service entries
	 * @param end the upper bound of the range of service entries (not inclusive)
	 * @return the range of matching service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceEntry> findBystatus(int status, int start, int end)
		throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service entries where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of service entries
	 * @param end the upper bound of the range of service entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceEntry> findBystatus(int status, int start, int end,
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

		List<ServiceEntry> list = (List<ServiceEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICEENTRY_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				list = (List<ServiceEntry>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first service entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service entry
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry findBystatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchServiceEntryException, SystemException {
		List<ServiceEntry> list = findBystatus(status, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service entry
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a matching service entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry findBystatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchServiceEntryException, SystemException {
		int count = countBystatus(status);

		List<ServiceEntry> list = findBystatus(status, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service entries before and after the current service entry in the ordered set where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param serviceId the primary key of the current service entry
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service entry
	 * @throws vn.com.fis.portal.NoSuchServiceEntryException if a service entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceEntry[] findBystatus_PrevAndNext(long serviceId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchServiceEntryException, SystemException {
		ServiceEntry serviceEntry = findByPrimaryKey(serviceId);

		Session session = null;

		try {
			session = openSession();

			ServiceEntry[] array = new ServiceEntryImpl[3];

			array[0] = getBystatus_PrevAndNext(session, serviceEntry, status,
					orderByComparator, true);

			array[1] = serviceEntry;

			array[2] = getBystatus_PrevAndNext(session, serviceEntry, status,
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

	protected ServiceEntry getBystatus_PrevAndNext(Session session,
		ServiceEntry serviceEntry, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICEENTRY_WHERE);

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
			query.append(ServiceEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service entries.
	 *
	 * @return the service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service entries
	 * @param end the upper bound of the range of service entries (not inclusive)
	 * @return the range of service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service entries
	 * @param end the upper bound of the range of service entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceEntry> findAll(int start, int end,
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

		List<ServiceEntry> list = (List<ServiceEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEENTRY.concat(ServiceEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ServiceEntry>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ServiceEntry>)QueryUtil.list(q, getDialect(),
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
	 * Removes the service entry where serviceCode = &#63; from the database.
	 *
	 * @param serviceCode the service code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByserviceCode(String serviceCode)
		throws NoSuchServiceEntryException, SystemException {
		ServiceEntry serviceEntry = findByserviceCode(serviceCode);

		remove(serviceEntry);
	}

	/**
	 * Removes the service entry where serviceName = &#63; from the database.
	 *
	 * @param serviceName the service name
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByserviceName(String serviceName)
		throws NoSuchServiceEntryException, SystemException {
		ServiceEntry serviceEntry = findByserviceName(serviceName);

		remove(serviceEntry);
	}

	/**
	 * Removes all the service entries where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBystatus(int status) throws SystemException {
		for (ServiceEntry serviceEntry : findBystatus(status)) {
			remove(serviceEntry);
		}
	}

	/**
	 * Removes all the service entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ServiceEntry serviceEntry : findAll()) {
			remove(serviceEntry);
		}
	}

	/**
	 * Returns the number of service entries where serviceCode = &#63;.
	 *
	 * @param serviceCode the service code
	 * @return the number of matching service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByserviceCode(String serviceCode) throws SystemException {
		Object[] finderArgs = new Object[] { serviceCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVICECODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEENTRY_WHERE);

			if (serviceCode == null) {
				query.append(_FINDER_COLUMN_SERVICECODE_SERVICECODE_1);
			}
			else {
				if (serviceCode.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICECODE_SERVICECODE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICECODE_SERVICECODE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (serviceCode != null) {
					qPos.add(serviceCode);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVICECODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service entries where serviceName = &#63;.
	 *
	 * @param serviceName the service name
	 * @return the number of matching service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByserviceName(String serviceName) throws SystemException {
		Object[] finderArgs = new Object[] { serviceName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SERVICENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEENTRY_WHERE);

			if (serviceName == null) {
				query.append(_FINDER_COLUMN_SERVICENAME_SERVICENAME_1);
			}
			else {
				if (serviceName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SERVICENAME_SERVICENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SERVICENAME_SERVICENAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (serviceName != null) {
					qPos.add(serviceName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SERVICENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service entries where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countBystatus(int status) throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICEENTRY_WHERE);

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
	 * Returns the number of service entries.
	 *
	 * @return the number of service entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVICEENTRY);

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
	 * Initializes the service entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ServiceEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceEntry>> listenersList = new ArrayList<ModelListener<ServiceEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_SERVICEENTRY = "SELECT serviceEntry FROM ServiceEntry serviceEntry";
	private static final String _SQL_SELECT_SERVICEENTRY_WHERE = "SELECT serviceEntry FROM ServiceEntry serviceEntry WHERE ";
	private static final String _SQL_COUNT_SERVICEENTRY = "SELECT COUNT(serviceEntry) FROM ServiceEntry serviceEntry";
	private static final String _SQL_COUNT_SERVICEENTRY_WHERE = "SELECT COUNT(serviceEntry) FROM ServiceEntry serviceEntry WHERE ";
	private static final String _FINDER_COLUMN_SERVICECODE_SERVICECODE_1 = "serviceEntry.serviceCode IS NULL";
	private static final String _FINDER_COLUMN_SERVICECODE_SERVICECODE_2 = "serviceEntry.serviceCode = ?";
	private static final String _FINDER_COLUMN_SERVICECODE_SERVICECODE_3 = "(serviceEntry.serviceCode IS NULL OR serviceEntry.serviceCode = ?)";
	private static final String _FINDER_COLUMN_SERVICENAME_SERVICENAME_1 = "serviceEntry.serviceName IS NULL";
	private static final String _FINDER_COLUMN_SERVICENAME_SERVICENAME_2 = "serviceEntry.serviceName = ?";
	private static final String _FINDER_COLUMN_SERVICENAME_SERVICENAME_3 = "(serviceEntry.serviceName IS NULL OR serviceEntry.serviceName = ?)";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "serviceEntry.status = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceEntryPersistenceImpl.class);
	private static ServiceEntry _nullServiceEntry = new ServiceEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceEntry> toCacheModel() {
				return _nullServiceEntryCacheModel;
			}
		};

	private static CacheModel<ServiceEntry> _nullServiceEntryCacheModel = new CacheModel<ServiceEntry>() {
			public ServiceEntry toEntityModel() {
				return _nullServiceEntry;
			}
		};
}