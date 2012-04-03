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

		EntityCacheUtil.putResult(ServiceEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceEntryImpl.class, serviceEntry.getPrimaryKey(), serviceEntry);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SERVICECODE,
				new Object[] { serviceEntry.getServiceCode() }, serviceEntry);
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