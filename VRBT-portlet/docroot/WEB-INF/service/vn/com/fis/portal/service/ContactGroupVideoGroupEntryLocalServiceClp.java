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

package vn.com.fis.portal.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author loind
 */
public class ContactGroupVideoGroupEntryLocalServiceClp
	implements ContactGroupVideoGroupEntryLocalService {
	public ContactGroupVideoGroupEntryLocalServiceClp(
		ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addContactGroupVideoGroupEntryMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addContactGroupVideoGroupEntry",
				vn.com.fis.portal.model.ContactGroupVideoGroupEntry.class);

		_createContactGroupVideoGroupEntryMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createContactGroupVideoGroupEntry", long.class);

		_deleteContactGroupVideoGroupEntryMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteContactGroupVideoGroupEntry", long.class);

		_deleteContactGroupVideoGroupEntryMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteContactGroupVideoGroupEntry",
				vn.com.fis.portal.model.ContactGroupVideoGroupEntry.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_fetchContactGroupVideoGroupEntryMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"fetchContactGroupVideoGroupEntry", long.class);

		_getContactGroupVideoGroupEntryMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getContactGroupVideoGroupEntry", long.class);

		_getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getContactGroupVideoGroupEntriesMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getContactGroupVideoGroupEntries", int.class, int.class);

		_getContactGroupVideoGroupEntriesCountMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"getContactGroupVideoGroupEntriesCount");

		_updateContactGroupVideoGroupEntryMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateContactGroupVideoGroupEntry",
				vn.com.fis.portal.model.ContactGroupVideoGroupEntry.class);

		_updateContactGroupVideoGroupEntryMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateContactGroupVideoGroupEntry",
				vn.com.fis.portal.model.ContactGroupVideoGroupEntry.class,
				boolean.class);

		_getBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_findByContactGroup_VideoGroupMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByContactGroup_VideoGroup", long.class, long.class);

		_countByContactGroup_VideoGroupMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByContactGroup_VideoGroup", long.class, long.class);

		_removeByContactGroup_VideoGroupMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"removeByContactGroup_VideoGroup", long.class, long.class);

		_findByContactGroupMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByContactGroup", long.class);

		_findByContactGroupMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"findByContactGroup", long.class, int.class, int.class);

		_countByContactGroupMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"countByContactGroup", long.class);

		_removeByContactGroupMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"removeByContactGroup", long.class);
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry addContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addContactGroupVideoGroupEntryMethodKey0,
				ClpSerializer.translateInput(contactGroupVideoGroupEntry));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry createContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createContactGroupVideoGroupEntryMethodKey1,
				contactGroupVideoGroupEntryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteContactGroupVideoGroupEntryMethodKey2,
				contactGroupVideoGroupEntryId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteContactGroupVideoGroupEntryMethodKey3,
				ClpSerializer.translateInput(contactGroupVideoGroupEntry));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry fetchContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_fetchContactGroupVideoGroupEntryMethodKey8,
				contactGroupVideoGroupEntryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry getContactGroupVideoGroupEntry(
		long contactGroupVideoGroupEntryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getContactGroupVideoGroupEntryMethodKey9,
				contactGroupVideoGroupEntryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> getContactGroupVideoGroupEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getContactGroupVideoGroupEntriesMethodKey11,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int getContactGroupVideoGroupEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getContactGroupVideoGroupEntriesCountMethodKey12);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry updateContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateContactGroupVideoGroupEntryMethodKey13,
				ClpSerializer.translateInput(contactGroupVideoGroupEntry));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry updateContactGroupVideoGroupEntry(
		vn.com.fis.portal.model.ContactGroupVideoGroupEntry contactGroupVideoGroupEntry,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateContactGroupVideoGroupEntryMethodKey14,
				ClpSerializer.translateInput(contactGroupVideoGroupEntry), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey15);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey16,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public vn.com.fis.portal.model.ContactGroupVideoGroupEntry findByContactGroup_VideoGroup(
		long contactGroupId, long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByContactGroup_VideoGroupMethodKey17,
				contactGroupId, videoGroupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException) {
				throw (vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.fis.portal.model.ContactGroupVideoGroupEntry)ClpSerializer.translateOutput(returnObj);
	}

	public int countByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByContactGroup_VideoGroupMethodKey18,
				contactGroupId, videoGroupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public void removeByContactGroup_VideoGroup(long contactGroupId,
		long videoGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException {
		MethodHandler methodHandler = new MethodHandler(_removeByContactGroup_VideoGroupMethodKey19,
				contactGroupId, videoGroupId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException) {
				throw (vn.com.fis.portal.NoSuchContactGroupVideoGroupEntryException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByContactGroupMethodKey20,
				contactGroupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry> findByContactGroup(
		long contactGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findByContactGroupMethodKey21,
				contactGroupId, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.fis.portal.model.ContactGroupVideoGroupEntry>)ClpSerializer.translateOutput(returnObj);
	}

	public int countByContactGroup(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_countByContactGroupMethodKey22,
				contactGroupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public void removeByContactGroup(long contactGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_removeByContactGroupMethodKey23,
				contactGroupId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addContactGroupVideoGroupEntryMethodKey0;
	private MethodKey _createContactGroupVideoGroupEntryMethodKey1;
	private MethodKey _deleteContactGroupVideoGroupEntryMethodKey2;
	private MethodKey _deleteContactGroupVideoGroupEntryMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _fetchContactGroupVideoGroupEntryMethodKey8;
	private MethodKey _getContactGroupVideoGroupEntryMethodKey9;
	private MethodKey _getPersistedModelMethodKey10;
	private MethodKey _getContactGroupVideoGroupEntriesMethodKey11;
	private MethodKey _getContactGroupVideoGroupEntriesCountMethodKey12;
	private MethodKey _updateContactGroupVideoGroupEntryMethodKey13;
	private MethodKey _updateContactGroupVideoGroupEntryMethodKey14;
	private MethodKey _getBeanIdentifierMethodKey15;
	private MethodKey _setBeanIdentifierMethodKey16;
	private MethodKey _findByContactGroup_VideoGroupMethodKey17;
	private MethodKey _countByContactGroup_VideoGroupMethodKey18;
	private MethodKey _removeByContactGroup_VideoGroupMethodKey19;
	private MethodKey _findByContactGroupMethodKey20;
	private MethodKey _findByContactGroupMethodKey21;
	private MethodKey _countByContactGroupMethodKey22;
	private MethodKey _removeByContactGroupMethodKey23;
}