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

package vn.com.fis.portal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.dao.orm.CustomSQLUtil;

import vn.com.fis.portal.model.ServiceTransactionEntry;
import vn.com.fis.portal.model.impl.ServiceTransactionEntryImpl;
import vn.com.fis.portal.service.base.ServiceTransactionEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.ServiceTransactionEntryFinderUtil;
import vn.com.fis.portal.service.persistence.ServiceTransactionEntryUtil;

/**
 * The implementation of the service transaction entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.ServiceTransactionEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.ServiceTransactionEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.ServiceTransactionEntryLocalServiceUtil
 */
public class ServiceTransactionEntryLocalServiceImpl
	extends ServiceTransactionEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.ServiceTransactionEntryLocalServiceUtil} to access the service transaction entry local service.
	 */
	/**
	 * Returns all the service transaction entries where transactionCode = &#63;.
	 *
	 * @param transactionCode the transaction code
	 * @return the matching service transaction entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<ServiceTransactionEntry> findByTransactionCode(
		int transactionCode) throws SystemException {
		return ServiceTransactionEntryUtil.findByTransactionCode(transactionCode);
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
		return ServiceTransactionEntryUtil.countByTransactionCode(transactionCode);
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
		return ServiceTransactionEntryUtil.findByTransactionCode_Date(transactionCode, date_);
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
		return ServiceTransactionEntryUtil.findByTransactionCode_Date(transactionCode, date_, start, end);
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
		return ServiceTransactionEntryUtil.countByTransactionCode_Date(transactionCode, date_);
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
		return ServiceTransactionEntryUtil.findByUserId_TransactionCode_Date(userId, transactionCode, date_);
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
		return ServiceTransactionEntryUtil.findByUserId_TransactionCode_Date(userId, transactionCode, date_, start, end);
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
		return ServiceTransactionEntryUtil.countByUserId_TransactionCode_Date(userId, transactionCode, date_);
	}
	
	public List<ServiceTransactionEntry> search(long transactionCode, long serviceId, long servicePackageId, int start, int end, int searchTypeFlag) 
			throws SystemException {
		return ServiceTransactionEntryFinderUtil.search(transactionCode, serviceId, servicePackageId, start, end, searchTypeFlag);
	}
	
	public int searchCount(long transactionCode, long serviceId, long servicePackageId, int searchTypeFlag) throws SystemException {
		return ServiceTransactionEntryFinderUtil.searchCount(transactionCode, serviceId, servicePackageId, searchTypeFlag);
	}
}