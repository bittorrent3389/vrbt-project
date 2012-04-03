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
import com.liferay.portal.kernel.util.CalendarUtil;
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

import vn.com.fis.portal.NoSuchServiceTransactionEntryException;
import vn.com.fis.portal.model.ServiceTransactionEntry;
import vn.com.fis.portal.model.impl.ServiceTransactionEntryImpl;
import vn.com.fis.portal.model.impl.ServiceTransactionEntryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the service transaction entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author loind
 * @see ServiceTransactionEntryPersistence
 * @see ServiceTransactionEntryUtil
 * @generated
 */
public class ServiceTransactionEntryPersistenceImpl extends BasePersistenceImpl<ServiceTransactionEntry>
	implements ServiceTransactionEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ServiceTransactionEntryUtil} to access the service transaction entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ServiceTransactionEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] { Date.class.getName() },
			ServiceTransactionEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATE = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTransactionCode",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTransactionCode",
			new String[] { Integer.class.getName() },
			ServiceTransactionEntryModelImpl.TRANSACTIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANSACTIONCODE = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTransactionCode", new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTransactionCode_Date",
			new String[] {
				Integer.class.getName(), Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTransactionCode_Date",
			new String[] { Integer.class.getName(), Date.class.getName() },
			ServiceTransactionEntryModelImpl.TRANSACTIONCODE_COLUMN_BITMASK |
			ServiceTransactionEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTransactionCode_Date",
			new String[] { Integer.class.getName(), Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId_TransactionCode_Date",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId_TransactionCode_Date",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName()
			},
			ServiceTransactionEntryModelImpl.USERID_COLUMN_BITMASK |
			ServiceTransactionEntryModelImpl.TRANSACTIONCODE_COLUMN_BITMASK |
			ServiceTransactionEntryModelImpl.DATE__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID_TRANSACTIONCODE_DATE =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserId_TransactionCode_Date",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Date.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			ServiceTransactionEntryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the service transaction entry in the entity cache if it is enabled.
	 *
	 * @param serviceTransactionEntry the service transaction entry
	 */
	public void cacheResult(ServiceTransactionEntry serviceTransactionEntry) {
		EntityCacheUtil.putResult(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			serviceTransactionEntry.getPrimaryKey(), serviceTransactionEntry);

		serviceTransactionEntry.resetOriginalValues();
	}

	/**
	 * Caches the service transaction entries in the entity cache if it is enabled.
	 *
	 * @param serviceTransactionEntries the service transaction entries
	 */
	public void cacheResult(
		List<ServiceTransactionEntry> serviceTransactionEntries) {
		for (ServiceTransactionEntry serviceTransactionEntry : serviceTransactionEntries) {
			if (EntityCacheUtil.getResult(
						ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
						ServiceTransactionEntryImpl.class,
						serviceTransactionEntry.getPrimaryKey()) == null) {
				cacheResult(serviceTransactionEntry);
			}
			else {
				serviceTransactionEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all service transaction entries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ServiceTransactionEntryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ServiceTransactionEntryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service transaction entry.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ServiceTransactionEntry serviceTransactionEntry) {
		EntityCacheUtil.removeResult(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			serviceTransactionEntry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ServiceTransactionEntry> serviceTransactionEntries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ServiceTransactionEntry serviceTransactionEntry : serviceTransactionEntries) {
			EntityCacheUtil.removeResult(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServiceTransactionEntryImpl.class,
				serviceTransactionEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new service transaction entry with the primary key. Does not add the service transaction entry to the database.
	 *
	 * @param transactionId the primary key for the new service transaction entry
	 * @return the new service transaction entry
	 */
	public ServiceTransactionEntry create(long transactionId) {
		ServiceTransactionEntry serviceTransactionEntry = new ServiceTransactionEntryImpl();

		serviceTransactionEntry.setNew(true);
		serviceTransactionEntry.setPrimaryKey(transactionId);

		return serviceTransactionEntry;
	}

	/**
	 * Removes the service transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param transactionId the primary key of the service transaction entry
	 * @return the service transaction entry that was removed
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry remove(long transactionId)
		throws NoSuchServiceTransactionEntryException, SystemException {
		return remove(Long.valueOf(transactionId));
	}

	/**
	 * Removes the service transaction entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service transaction entry
	 * @return the service transaction entry that was removed
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceTransactionEntry remove(Serializable primaryKey)
		throws NoSuchServiceTransactionEntryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ServiceTransactionEntry serviceTransactionEntry = (ServiceTransactionEntry)session.get(ServiceTransactionEntryImpl.class,
					primaryKey);

			if (serviceTransactionEntry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceTransactionEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(serviceTransactionEntry);
		}
		catch (NoSuchServiceTransactionEntryException nsee) {
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
	protected ServiceTransactionEntry removeImpl(
		ServiceTransactionEntry serviceTransactionEntry)
		throws SystemException {
		serviceTransactionEntry = toUnwrappedModel(serviceTransactionEntry);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, serviceTransactionEntry);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(serviceTransactionEntry);

		return serviceTransactionEntry;
	}

	@Override
	public ServiceTransactionEntry updateImpl(
		vn.com.fis.portal.model.ServiceTransactionEntry serviceTransactionEntry,
		boolean merge) throws SystemException {
		serviceTransactionEntry = toUnwrappedModel(serviceTransactionEntry);

		boolean isNew = serviceTransactionEntry.isNew();

		ServiceTransactionEntryModelImpl serviceTransactionEntryModelImpl = (ServiceTransactionEntryModelImpl)serviceTransactionEntry;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, serviceTransactionEntry, merge);

			serviceTransactionEntry.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ServiceTransactionEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((serviceTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						serviceTransactionEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);

				args = new Object[] { serviceTransactionEntryModelImpl.getDate_() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE,
					args);
			}

			if ((serviceTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(serviceTransactionEntryModelImpl.getOriginalTransactionCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE,
					args);

				args = new Object[] {
						Integer.valueOf(serviceTransactionEntryModelImpl.getTransactionCode())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE,
					args);
			}

			if ((serviceTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(serviceTransactionEntryModelImpl.getOriginalTransactionCode()),
						
						serviceTransactionEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE,
					args);

				args = new Object[] {
						Integer.valueOf(serviceTransactionEntryModelImpl.getTransactionCode()),
						
						serviceTransactionEntryModelImpl.getDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE,
					args);
			}

			if ((serviceTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(serviceTransactionEntryModelImpl.getOriginalUserId()),
						Integer.valueOf(serviceTransactionEntryModelImpl.getOriginalTransactionCode()),
						
						serviceTransactionEntryModelImpl.getOriginalDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_TRANSACTIONCODE_DATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE,
					args);

				args = new Object[] {
						Long.valueOf(serviceTransactionEntryModelImpl.getUserId()),
						Integer.valueOf(serviceTransactionEntryModelImpl.getTransactionCode()),
						
						serviceTransactionEntryModelImpl.getDate_()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID_TRANSACTIONCODE_DATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE,
					args);
			}

			if ((serviceTransactionEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(serviceTransactionEntryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(serviceTransactionEntryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
			ServiceTransactionEntryImpl.class,
			serviceTransactionEntry.getPrimaryKey(), serviceTransactionEntry);

		return serviceTransactionEntry;
	}

	protected ServiceTransactionEntry toUnwrappedModel(
		ServiceTransactionEntry serviceTransactionEntry) {
		if (serviceTransactionEntry instanceof ServiceTransactionEntryImpl) {
			return serviceTransactionEntry;
		}

		ServiceTransactionEntryImpl serviceTransactionEntryImpl = new ServiceTransactionEntryImpl();

		serviceTransactionEntryImpl.setNew(serviceTransactionEntry.isNew());
		serviceTransactionEntryImpl.setPrimaryKey(serviceTransactionEntry.getPrimaryKey());

		serviceTransactionEntryImpl.setTransactionId(serviceTransactionEntry.getTransactionId());
		serviceTransactionEntryImpl.setTransactionCode(serviceTransactionEntry.getTransactionCode());
		serviceTransactionEntryImpl.setDate_(serviceTransactionEntry.getDate_());
		serviceTransactionEntryImpl.setUserId(serviceTransactionEntry.getUserId());
		serviceTransactionEntryImpl.setServiceId(serviceTransactionEntry.getServiceId());
		serviceTransactionEntryImpl.setServiceStatus(serviceTransactionEntry.getServiceStatus());
		serviceTransactionEntryImpl.setServiceStartDate(serviceTransactionEntry.getServiceStartDate());
		serviceTransactionEntryImpl.setServiceEndDate(serviceTransactionEntry.getServiceEndDate());
		serviceTransactionEntryImpl.setServicePackageId(serviceTransactionEntry.getServicePackageId());
		serviceTransactionEntryImpl.setPackageDate(serviceTransactionEntry.getPackageDate());

		return serviceTransactionEntryImpl;
	}

	/**
	 * Returns the service transaction entry with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the service transaction entry
	 * @return the service transaction entry
	 * @throws com.liferay.portal.NoSuchModelException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceTransactionEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the service transaction entry with the primary key or throws a {@link vn.com.fis.portal.NoSuchServiceTransactionEntryException} if it could not be found.
	 *
	 * @param transactionId the primary key of the service transaction entry
	 * @return the service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByPrimaryKey(long transactionId)
		throws NoSuchServiceTransactionEntryException, SystemException {
		ServiceTransactionEntry serviceTransactionEntry = fetchByPrimaryKey(transactionId);

		if (serviceTransactionEntry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + transactionId);
			}

			throw new NoSuchServiceTransactionEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				transactionId);
		}

		return serviceTransactionEntry;
	}

	/**
	 * Returns the service transaction entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service transaction entry
	 * @return the service transaction entry, or <code>null</code> if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ServiceTransactionEntry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the service transaction entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param transactionId the primary key of the service transaction entry
	 * @return the service transaction entry, or <code>null</code> if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry fetchByPrimaryKey(long transactionId)
		throws SystemException {
		ServiceTransactionEntry serviceTransactionEntry = (ServiceTransactionEntry)EntityCacheUtil.getResult(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
				ServiceTransactionEntryImpl.class, transactionId);

		if (serviceTransactionEntry == _nullServiceTransactionEntry) {
			return null;
		}

		if (serviceTransactionEntry == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				serviceTransactionEntry = (ServiceTransactionEntry)session.get(ServiceTransactionEntryImpl.class,
						Long.valueOf(transactionId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (serviceTransactionEntry != null) {
					cacheResult(serviceTransactionEntry);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ServiceTransactionEntryModelImpl.ENTITY_CACHE_ENABLED,
						ServiceTransactionEntryImpl.class, transactionId,
						_nullServiceTransactionEntry);
				}

				closeSession(session);
			}
		}

		return serviceTransactionEntry;
	}

	/**
	 * Returns all the service transaction entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByDate(Date date_)
		throws SystemException {
		return findByDate(date_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service transaction entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @return the range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByDate(Date date_, int start,
		int end) throws SystemException {
		return findByDate(date_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service transaction entries where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByDate(Date date_, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATE;
			finderArgs = new Object[] { date_, start, end, orderByComparator };
		}

		List<ServiceTransactionEntry> list = (List<ServiceTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_DATE_DATE__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
				}

				list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first service transaction entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByDate_First(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		List<ServiceTransactionEntry> list = findByDate(date_, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service transaction entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByDate_Last(Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		int count = countByDate(date_);

		List<ServiceTransactionEntry> list = findByDate(date_, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service transaction entries before and after the current service transaction entry in the ordered set where date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current service transaction entry
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry[] findByDate_PrevAndNext(
		long transactionId, Date date_, OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		ServiceTransactionEntry serviceTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			ServiceTransactionEntry[] array = new ServiceTransactionEntryImpl[3];

			array[0] = getByDate_PrevAndNext(session, serviceTransactionEntry,
					date_, orderByComparator, true);

			array[1] = serviceTransactionEntry;

			array[2] = getByDate_PrevAndNext(session, serviceTransactionEntry,
					date_, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceTransactionEntry getByDate_PrevAndNext(Session session,
		ServiceTransactionEntry serviceTransactionEntry, Date date_,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

		if (date_ == null) {
			query.append(_FINDER_COLUMN_DATE_DATE__1);
		}
		else {
			query.append(_FINDER_COLUMN_DATE_DATE__2);
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
			query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (date_ != null) {
			qPos.add(CalendarUtil.getTimestamp(date_));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode(
		int transactionCode) throws SystemException {
		return findByTransactionCode(transactionCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service transaction entries where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @return the range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode(
		int transactionCode, int start, int end) throws SystemException {
		return findByTransactionCode(transactionCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service transaction entries where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode(
		int transactionCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE;
			finderArgs = new Object[] { transactionCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE;
			finderArgs = new Object[] {
					transactionCode,
					
					start, end, orderByComparator
				};
		}

		List<ServiceTransactionEntry> list = (List<ServiceTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first service transaction entry in the ordered set where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByTransactionCode_First(
		int transactionCode, OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		List<ServiceTransactionEntry> list = findByTransactionCode(transactionCode,
				0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service transaction entry in the ordered set where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByTransactionCode_Last(
		int transactionCode, OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		int count = countByTransactionCode(transactionCode);

		List<ServiceTransactionEntry> list = findByTransactionCode(transactionCode,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service transaction entries before and after the current service transaction entry in the ordered set where transactionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current service transaction entry
	 * @param transactionCode the transaction code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry[] findByTransactionCode_PrevAndNext(
		long transactionId, int transactionCode,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		ServiceTransactionEntry serviceTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			ServiceTransactionEntry[] array = new ServiceTransactionEntryImpl[3];

			array[0] = getByTransactionCode_PrevAndNext(session,
					serviceTransactionEntry, transactionCode,
					orderByComparator, true);

			array[1] = serviceTransactionEntry;

			array[2] = getByTransactionCode_PrevAndNext(session,
					serviceTransactionEntry, transactionCode,
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

	protected ServiceTransactionEntry getByTransactionCode_PrevAndNext(
		Session session, ServiceTransactionEntry serviceTransactionEntry,
		int transactionCode, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2);

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
			query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(transactionCode);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, Date date_) throws SystemException {
		return findByTransactionCode_Date(transactionCode, date_,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @return the range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, Date date_, int start, int end)
		throws SystemException {
		return findByTransactionCode_Date(transactionCode, date_, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the service transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode_Date(
		int transactionCode, Date date_, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE;
			finderArgs = new Object[] { transactionCode, date_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TRANSACTIONCODE_DATE;
			finderArgs = new Object[] {
					transactionCode, date_,
					
					start, end, orderByComparator
				};
		}

		List<ServiceTransactionEntry> list = (List<ServiceTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
				}

				list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first service transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByTransactionCode_Date_First(
		int transactionCode, Date date_, OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		List<ServiceTransactionEntry> list = findByTransactionCode_Date(transactionCode,
				date_, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(", date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByTransactionCode_Date_Last(
		int transactionCode, Date date_, OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		int count = countByTransactionCode_Date(transactionCode, date_);

		List<ServiceTransactionEntry> list = findByTransactionCode_Date(transactionCode,
				date_, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("transactionCode=");
			msg.append(transactionCode);

			msg.append(", date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service transaction entries before and after the current service transaction entry in the ordered set where transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current service transaction entry
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry[] findByTransactionCode_Date_PrevAndNext(
		long transactionId, int transactionCode, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		ServiceTransactionEntry serviceTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			ServiceTransactionEntry[] array = new ServiceTransactionEntryImpl[3];

			array[0] = getByTransactionCode_Date_PrevAndNext(session,
					serviceTransactionEntry, transactionCode, date_,
					orderByComparator, true);

			array[1] = serviceTransactionEntry;

			array[2] = getByTransactionCode_Date_PrevAndNext(session,
					serviceTransactionEntry, transactionCode, date_,
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

	protected ServiceTransactionEntry getByTransactionCode_Date_PrevAndNext(
		Session session, ServiceTransactionEntry serviceTransactionEntry,
		int transactionCode, Date date_, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

		if (date_ == null) {
			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1);
		}
		else {
			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2);
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
			query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(transactionCode);

		if (date_ != null) {
			qPos.add(CalendarUtil.getTimestamp(date_));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, Date date_) throws SystemException {
		return findByUserId_TransactionCode_Date(userId, transactionCode,
			date_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @return the range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, Date date_, int start, int end)
		throws SystemException {
		return findByUserId_TransactionCode_Date(userId, transactionCode,
			date_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByUserId_TransactionCode_Date(
		long userId, int transactionCode, Date date_, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE;
			finderArgs = new Object[] { userId, transactionCode, date_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID_TRANSACTIONCODE_DATE;
			finderArgs = new Object[] {
					userId, transactionCode, date_,
					
					start, end, orderByComparator
				};
		}

		List<ServiceTransactionEntry> list = (List<ServiceTransactionEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_USERID_2);

			query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(transactionCode);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
				}

				list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first service transaction entry in the ordered set where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByUserId_TransactionCode_Date_First(
		long userId, int transactionCode, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		List<ServiceTransactionEntry> list = findByUserId_TransactionCode_Date(userId,
				transactionCode, date_, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", transactionCode=");
			msg.append(transactionCode);

			msg.append(", date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service transaction entry in the ordered set where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByUserId_TransactionCode_Date_Last(
		long userId, int transactionCode, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		int count = countByUserId_TransactionCode_Date(userId, transactionCode,
				date_);

		List<ServiceTransactionEntry> list = findByUserId_TransactionCode_Date(userId,
				transactionCode, date_, count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", transactionCode=");
			msg.append(transactionCode);

			msg.append(", date_=");
			msg.append(date_);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service transaction entries before and after the current service transaction entry in the ordered set where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current service transaction entry
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry[] findByUserId_TransactionCode_Date_PrevAndNext(
		long transactionId, long userId, int transactionCode, Date date_,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		ServiceTransactionEntry serviceTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			ServiceTransactionEntry[] array = new ServiceTransactionEntryImpl[3];

			array[0] = getByUserId_TransactionCode_Date_PrevAndNext(session,
					serviceTransactionEntry, userId, transactionCode, date_,
					orderByComparator, true);

			array[1] = serviceTransactionEntry;

			array[2] = getByUserId_TransactionCode_Date_PrevAndNext(session,
					serviceTransactionEntry, userId, transactionCode, date_,
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

	protected ServiceTransactionEntry getByUserId_TransactionCode_Date_PrevAndNext(
		Session session, ServiceTransactionEntry serviceTransactionEntry,
		long userId, int transactionCode, Date date_,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_USERID_2);

		query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

		if (date_ == null) {
			query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__1);
		}
		else {
			query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__2);
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
			query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(transactionCode);

		if (date_ != null) {
			qPos.add(CalendarUtil.getTimestamp(date_));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service transaction entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service transaction entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @return the range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByUserId(long userId, int start,
		int end) throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service transaction entries where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByUserId(long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ServiceTransactionEntry> list = (List<ServiceTransactionEntry>)FinderCacheUtil.getResult(finderPath,
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

			query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
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
	 * Returns the first service transaction entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		List<ServiceTransactionEntry> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the last service transaction entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a matching service transaction entry could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		int count = countByUserId(userId);

		List<ServiceTransactionEntry> list = findByUserId(userId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchServiceTransactionEntryException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Returns the service transaction entries before and after the current service transaction entry in the ordered set where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param transactionId the primary key of the current service transaction entry
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service transaction entry
	 * @throws vn.com.fis.portal.NoSuchServiceTransactionEntryException if a service transaction entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ServiceTransactionEntry[] findByUserId_PrevAndNext(
		long transactionId, long userId, OrderByComparator orderByComparator)
		throws NoSuchServiceTransactionEntryException, SystemException {
		ServiceTransactionEntry serviceTransactionEntry = findByPrimaryKey(transactionId);

		Session session = null;

		try {
			session = openSession();

			ServiceTransactionEntry[] array = new ServiceTransactionEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session,
					serviceTransactionEntry, userId, orderByComparator, true);

			array[1] = serviceTransactionEntry;

			array[2] = getByUserId_PrevAndNext(session,
					serviceTransactionEntry, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceTransactionEntry getByUserId_PrevAndNext(Session session,
		ServiceTransactionEntry serviceTransactionEntry, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE);

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
			query.append(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(serviceTransactionEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ServiceTransactionEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the service transaction entries.
	 *
	 * @return the service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service transaction entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @return the range of service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service transaction entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of service transaction entries
	 * @param end the upper bound of the range of service transaction entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findAll(int start, int end,
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

		List<ServiceTransactionEntry> list = (List<ServiceTransactionEntry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SERVICETRANSACTIONENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICETRANSACTIONENTRY.concat(ServiceTransactionEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ServiceTransactionEntry>)QueryUtil.list(q,
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
	 * Removes all the service transaction entries where date_ = &#63; from the database.
	 *
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDate(Date date_) throws SystemException {
		for (ServiceTransactionEntry serviceTransactionEntry : findByDate(date_)) {
			remove(serviceTransactionEntry);
		}
	}

	/**
	 * Removes all the service transaction entries where transactionCode = &#63; from the database.
	 *
	 * @param transactionCode the transaction code
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTransactionCode(int transactionCode)
		throws SystemException {
		for (ServiceTransactionEntry serviceTransactionEntry : findByTransactionCode(
				transactionCode)) {
			remove(serviceTransactionEntry);
		}
	}

	/**
	 * Removes all the service transaction entries where transactionCode = &#63; and date_ = &#63; from the database.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTransactionCode_Date(int transactionCode, Date date_)
		throws SystemException {
		for (ServiceTransactionEntry serviceTransactionEntry : findByTransactionCode_Date(
				transactionCode, date_)) {
			remove(serviceTransactionEntry);
		}
	}

	/**
	 * Removes all the service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId_TransactionCode_Date(long userId,
		int transactionCode, Date date_) throws SystemException {
		for (ServiceTransactionEntry serviceTransactionEntry : findByUserId_TransactionCode_Date(
				userId, transactionCode, date_)) {
			remove(serviceTransactionEntry);
		}
	}

	/**
	 * Removes all the service transaction entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUserId(long userId) throws SystemException {
		for (ServiceTransactionEntry serviceTransactionEntry : findByUserId(
				userId)) {
			remove(serviceTransactionEntry);
		}
	}

	/**
	 * Removes all the service transaction entries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ServiceTransactionEntry serviceTransactionEntry : findAll()) {
			remove(serviceTransactionEntry);
		}
	}

	/**
	 * Returns the number of service transaction entries where date_ = &#63;.
	 *
	 * @param date_ the date_
	 * @return the number of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDate(Date date_) throws SystemException {
		Object[] finderArgs = new Object[] { date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICETRANSACTIONENTRY_WHERE);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_DATE_DATE__2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the number of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTransactionCode(int transactionCode)
		throws SystemException {
		Object[] finderArgs = new Object[] { transactionCode };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service transaction entries where transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the number of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTransactionCode_Date(int transactionCode, Date date_)
		throws SystemException {
		Object[] finderArgs = new Object[] { transactionCode, date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(transactionCode);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANSACTIONCODE_DATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service transaction entries where userId = &#63; and transactionCode = &#63; and date_ = &#63;.
	 *
	 * @param userId the user ID
	 * @param transactionCode the transaction code
	 * @param date_ the date_
	 * @return the number of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId_TransactionCode_Date(long userId,
		int transactionCode, Date date_) throws SystemException {
		Object[] finderArgs = new Object[] { userId, transactionCode, date_ };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID_TRANSACTIONCODE_DATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SERVICETRANSACTIONENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_USERID_2);

			query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2);

			if (date_ == null) {
				query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__1);
			}
			else {
				query.append(_FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(transactionCode);

				if (date_ != null) {
					qPos.add(CalendarUtil.getTimestamp(date_));
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID_TRANSACTIONCODE_DATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of service transaction entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SERVICETRANSACTIONENTRY_WHERE);

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
	 * Returns the number of service transaction entries.
	 *
	 * @return the number of service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SERVICETRANSACTIONENTRY);

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
	 * Initializes the service transaction entry persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.fis.portal.model.ServiceTransactionEntry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ServiceTransactionEntry>> listenersList = new ArrayList<ModelListener<ServiceTransactionEntry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ServiceTransactionEntry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ServiceTransactionEntryImpl.class.getName());
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
	private static final String _SQL_SELECT_SERVICETRANSACTIONENTRY = "SELECT serviceTransactionEntry FROM ServiceTransactionEntry serviceTransactionEntry";
	private static final String _SQL_SELECT_SERVICETRANSACTIONENTRY_WHERE = "SELECT serviceTransactionEntry FROM ServiceTransactionEntry serviceTransactionEntry WHERE ";
	private static final String _SQL_COUNT_SERVICETRANSACTIONENTRY = "SELECT COUNT(serviceTransactionEntry) FROM ServiceTransactionEntry serviceTransactionEntry";
	private static final String _SQL_COUNT_SERVICETRANSACTIONENTRY_WHERE = "SELECT COUNT(serviceTransactionEntry) FROM ServiceTransactionEntry serviceTransactionEntry WHERE ";
	private static final String _FINDER_COLUMN_DATE_DATE__1 = "serviceTransactionEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_DATE_DATE__2 = "serviceTransactionEntry.date_ = ?";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_TRANSACTIONCODE_2 =
		"serviceTransactionEntry.transactionCode = ?";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2 =
		"serviceTransactionEntry.transactionCode = ? AND ";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__1 = "serviceTransactionEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_TRANSACTIONCODE_DATE_DATE__2 = "serviceTransactionEntry.date_ = ?";
	private static final String _FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_USERID_2 =
		"serviceTransactionEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_TRANSACTIONCODE_2 =
		"serviceTransactionEntry.transactionCode = ? AND ";
	private static final String _FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__1 =
		"serviceTransactionEntry.date_ IS NULL";
	private static final String _FINDER_COLUMN_USERID_TRANSACTIONCODE_DATE_DATE__2 =
		"serviceTransactionEntry.date_ = ?";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "serviceTransactionEntry.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "serviceTransactionEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ServiceTransactionEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ServiceTransactionEntry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ServiceTransactionEntryPersistenceImpl.class);
	private static ServiceTransactionEntry _nullServiceTransactionEntry = new ServiceTransactionEntryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ServiceTransactionEntry> toCacheModel() {
				return _nullServiceTransactionEntryCacheModel;
			}
		};

	private static CacheModel<ServiceTransactionEntry> _nullServiceTransactionEntryCacheModel =
		new CacheModel<ServiceTransactionEntry>() {
			public ServiceTransactionEntry toEntityModel() {
				return _nullServiceTransactionEntry;
			}
		};
}