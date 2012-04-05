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

package vn.com.fis.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.com.fis.portal.model.ServiceTransactionEntry;
import vn.com.fis.portal.model.ServiceTransactionEntryModel;
import vn.com.fis.portal.model.ServiceTransactionEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the ServiceTransactionEntry service. Represents a row in the &quot;TBL_SERVICE_TRANSACTION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.fis.portal.model.ServiceTransactionEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ServiceTransactionEntryImpl}.
 * </p>
 *
 * @author loind
 * @see ServiceTransactionEntryImpl
 * @see vn.com.fis.portal.model.ServiceTransactionEntry
 * @see vn.com.fis.portal.model.ServiceTransactionEntryModel
 * @generated
 */
@JSON(strict = true)
public class ServiceTransactionEntryModelImpl extends BaseModelImpl<ServiceTransactionEntry>
	implements ServiceTransactionEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a service transaction entry model instance should use the {@link vn.com.fis.portal.model.ServiceTransactionEntry} interface instead.
	 */
	public static final String TABLE_NAME = "TBL_SERVICE_TRANSACTION";
	public static final Object[][] TABLE_COLUMNS = {
			{ "transactionId", Types.BIGINT },
			{ "transactionCode", Types.INTEGER },
			{ "date_", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "serviceId", Types.BIGINT },
			{ "serviceStatus", Types.INTEGER },
			{ "serviceStartDate", Types.TIMESTAMP },
			{ "serviceStopDate", Types.TIMESTAMP },
			{ "serviceEndDate", Types.TIMESTAMP },
			{ "servicePackageId", Types.BIGINT },
			{ "packageDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table TBL_SERVICE_TRANSACTION (transactionId LONG not null primary key,transactionCode INTEGER,date_ DATE null,userId LONG,serviceId LONG,serviceStatus INTEGER,serviceStartDate DATE null,serviceStopDate DATE null,serviceEndDate DATE null,servicePackageId LONG,packageDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table TBL_SERVICE_TRANSACTION";
	public static final String ORDER_BY_JPQL = " ORDER BY serviceTransactionEntry.date_ ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TBL_SERVICE_TRANSACTION.date_ ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.fis.portal.model.ServiceTransactionEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.fis.portal.model.ServiceTransactionEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.fis.portal.model.ServiceTransactionEntry"),
			true);
	public static long DATE__COLUMN_BITMASK = 1L;
	public static long TRANSACTIONCODE_COLUMN_BITMASK = 2L;
	public static long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ServiceTransactionEntry toModel(
		ServiceTransactionEntrySoap soapModel) {
		ServiceTransactionEntry model = new ServiceTransactionEntryImpl();

		model.setTransactionId(soapModel.getTransactionId());
		model.setTransactionCode(soapModel.getTransactionCode());
		model.setDate_(soapModel.getDate_());
		model.setUserId(soapModel.getUserId());
		model.setServiceId(soapModel.getServiceId());
		model.setServiceStatus(soapModel.getServiceStatus());
		model.setServiceStartDate(soapModel.getServiceStartDate());
		model.setServiceStopDate(soapModel.getServiceStopDate());
		model.setServiceEndDate(soapModel.getServiceEndDate());
		model.setServicePackageId(soapModel.getServicePackageId());
		model.setPackageDate(soapModel.getPackageDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ServiceTransactionEntry> toModels(
		ServiceTransactionEntrySoap[] soapModels) {
		List<ServiceTransactionEntry> models = new ArrayList<ServiceTransactionEntry>(soapModels.length);

		for (ServiceTransactionEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.fis.portal.model.ServiceTransactionEntry"));

	public ServiceTransactionEntryModelImpl() {
	}

	public long getPrimaryKey() {
		return _transactionId;
	}

	public void setPrimaryKey(long primaryKey) {
		setTransactionId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_transactionId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ServiceTransactionEntry.class;
	}

	public String getModelClassName() {
		return ServiceTransactionEntry.class.getName();
	}

	@JSON
	public long getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(long transactionId) {
		_transactionId = transactionId;
	}

	@JSON
	public int getTransactionCode() {
		return _transactionCode;
	}

	public void setTransactionCode(int transactionCode) {
		_columnBitmask |= TRANSACTIONCODE_COLUMN_BITMASK;

		if (!_setOriginalTransactionCode) {
			_setOriginalTransactionCode = true;

			_originalTransactionCode = _transactionCode;
		}

		_transactionCode = transactionCode;
	}

	public int getOriginalTransactionCode() {
		return _originalTransactionCode;
	}

	@JSON
	public Date getDate_() {
		return _date_;
	}

	public void setDate_(Date date_) {
		_columnBitmask = -1L;

		if (_originalDate_ == null) {
			_originalDate_ = _date_;
		}

		_date_ = date_;
	}

	public Date getOriginalDate_() {
		return _originalDate_;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	public long getServiceId() {
		return _serviceId;
	}

	public void setServiceId(long serviceId) {
		_serviceId = serviceId;
	}

	@JSON
	public int getServiceStatus() {
		return _serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		_serviceStatus = serviceStatus;
	}

	@JSON
	public Date getServiceStartDate() {
		return _serviceStartDate;
	}

	public void setServiceStartDate(Date serviceStartDate) {
		_serviceStartDate = serviceStartDate;
	}

	@JSON
	public Date getServiceStopDate() {
		return _serviceStopDate;
	}

	public void setServiceStopDate(Date serviceStopDate) {
		_serviceStopDate = serviceStopDate;
	}

	@JSON
	public Date getServiceEndDate() {
		return _serviceEndDate;
	}

	public void setServiceEndDate(Date serviceEndDate) {
		_serviceEndDate = serviceEndDate;
	}

	@JSON
	public long getServicePackageId() {
		return _servicePackageId;
	}

	public void setServicePackageId(long servicePackageId) {
		_servicePackageId = servicePackageId;
	}

	@JSON
	public Date getPackageDate() {
		return _packageDate;
	}

	public void setPackageDate(Date packageDate) {
		_packageDate = packageDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ServiceTransactionEntry toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ServiceTransactionEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(0,
					ServiceTransactionEntry.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		ServiceTransactionEntryImpl serviceTransactionEntryImpl = new ServiceTransactionEntryImpl();

		serviceTransactionEntryImpl.setTransactionId(getTransactionId());
		serviceTransactionEntryImpl.setTransactionCode(getTransactionCode());
		serviceTransactionEntryImpl.setDate_(getDate_());
		serviceTransactionEntryImpl.setUserId(getUserId());
		serviceTransactionEntryImpl.setServiceId(getServiceId());
		serviceTransactionEntryImpl.setServiceStatus(getServiceStatus());
		serviceTransactionEntryImpl.setServiceStartDate(getServiceStartDate());
		serviceTransactionEntryImpl.setServiceStopDate(getServiceStopDate());
		serviceTransactionEntryImpl.setServiceEndDate(getServiceEndDate());
		serviceTransactionEntryImpl.setServicePackageId(getServicePackageId());
		serviceTransactionEntryImpl.setPackageDate(getPackageDate());

		serviceTransactionEntryImpl.resetOriginalValues();

		return serviceTransactionEntryImpl;
	}

	public int compareTo(ServiceTransactionEntry serviceTransactionEntry) {
		int value = 0;

		value = DateUtil.compareTo(getDate_(),
				serviceTransactionEntry.getDate_());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ServiceTransactionEntry serviceTransactionEntry = null;

		try {
			serviceTransactionEntry = (ServiceTransactionEntry)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = serviceTransactionEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ServiceTransactionEntryModelImpl serviceTransactionEntryModelImpl = this;

		serviceTransactionEntryModelImpl._originalTransactionCode = serviceTransactionEntryModelImpl._transactionCode;

		serviceTransactionEntryModelImpl._setOriginalTransactionCode = false;

		serviceTransactionEntryModelImpl._originalDate_ = serviceTransactionEntryModelImpl._date_;

		serviceTransactionEntryModelImpl._originalUserId = serviceTransactionEntryModelImpl._userId;

		serviceTransactionEntryModelImpl._setOriginalUserId = false;

		serviceTransactionEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ServiceTransactionEntry> toCacheModel() {
		ServiceTransactionEntryCacheModel serviceTransactionEntryCacheModel = new ServiceTransactionEntryCacheModel();

		serviceTransactionEntryCacheModel.transactionId = getTransactionId();

		serviceTransactionEntryCacheModel.transactionCode = getTransactionCode();

		Date date_ = getDate_();

		if (date_ != null) {
			serviceTransactionEntryCacheModel.date_ = date_.getTime();
		}
		else {
			serviceTransactionEntryCacheModel.date_ = Long.MIN_VALUE;
		}

		serviceTransactionEntryCacheModel.userId = getUserId();

		serviceTransactionEntryCacheModel.serviceId = getServiceId();

		serviceTransactionEntryCacheModel.serviceStatus = getServiceStatus();

		Date serviceStartDate = getServiceStartDate();

		if (serviceStartDate != null) {
			serviceTransactionEntryCacheModel.serviceStartDate = serviceStartDate.getTime();
		}
		else {
			serviceTransactionEntryCacheModel.serviceStartDate = Long.MIN_VALUE;
		}

		Date serviceStopDate = getServiceStopDate();

		if (serviceStopDate != null) {
			serviceTransactionEntryCacheModel.serviceStopDate = serviceStopDate.getTime();
		}
		else {
			serviceTransactionEntryCacheModel.serviceStopDate = Long.MIN_VALUE;
		}

		Date serviceEndDate = getServiceEndDate();

		if (serviceEndDate != null) {
			serviceTransactionEntryCacheModel.serviceEndDate = serviceEndDate.getTime();
		}
		else {
			serviceTransactionEntryCacheModel.serviceEndDate = Long.MIN_VALUE;
		}

		serviceTransactionEntryCacheModel.servicePackageId = getServicePackageId();

		Date packageDate = getPackageDate();

		if (packageDate != null) {
			serviceTransactionEntryCacheModel.packageDate = packageDate.getTime();
		}
		else {
			serviceTransactionEntryCacheModel.packageDate = Long.MIN_VALUE;
		}

		return serviceTransactionEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{transactionId=");
		sb.append(getTransactionId());
		sb.append(", transactionCode=");
		sb.append(getTransactionCode());
		sb.append(", date_=");
		sb.append(getDate_());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", serviceId=");
		sb.append(getServiceId());
		sb.append(", serviceStatus=");
		sb.append(getServiceStatus());
		sb.append(", serviceStartDate=");
		sb.append(getServiceStartDate());
		sb.append(", serviceStopDate=");
		sb.append(getServiceStopDate());
		sb.append(", serviceEndDate=");
		sb.append(getServiceEndDate());
		sb.append(", servicePackageId=");
		sb.append(getServicePackageId());
		sb.append(", packageDate=");
		sb.append(getPackageDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("vn.com.fis.portal.model.ServiceTransactionEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>transactionId</column-name><column-value><![CDATA[");
		sb.append(getTransactionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionCode</column-name><column-value><![CDATA[");
		sb.append(getTransactionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_</column-name><column-value><![CDATA[");
		sb.append(getDate_());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceId</column-name><column-value><![CDATA[");
		sb.append(getServiceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceStatus</column-name><column-value><![CDATA[");
		sb.append(getServiceStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceStartDate</column-name><column-value><![CDATA[");
		sb.append(getServiceStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceStopDate</column-name><column-value><![CDATA[");
		sb.append(getServiceStopDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceEndDate</column-name><column-value><![CDATA[");
		sb.append(getServiceEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>servicePackageId</column-name><column-value><![CDATA[");
		sb.append(getServicePackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packageDate</column-name><column-value><![CDATA[");
		sb.append(getPackageDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ServiceTransactionEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ServiceTransactionEntry.class
		};
	private long _transactionId;
	private int _transactionCode;
	private int _originalTransactionCode;
	private boolean _setOriginalTransactionCode;
	private Date _date_;
	private Date _originalDate_;
	private long _userId;
	private String _userUuid;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private long _serviceId;
	private int _serviceStatus;
	private Date _serviceStartDate;
	private Date _serviceStopDate;
	private Date _serviceEndDate;
	private long _servicePackageId;
	private Date _packageDate;
	private transient ExpandoBridge _expandoBridge;
	private long _columnBitmask;
	private ServiceTransactionEntry _escapedModelProxy;
}