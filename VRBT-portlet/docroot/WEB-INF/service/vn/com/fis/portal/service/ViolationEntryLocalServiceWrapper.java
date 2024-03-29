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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ViolationEntryLocalService}.
 * </p>
 *
 * @author    loind
 * @see       ViolationEntryLocalService
 * @generated
 */
public class ViolationEntryLocalServiceWrapper
	implements ViolationEntryLocalService,
		ServiceWrapper<ViolationEntryLocalService> {
	public ViolationEntryLocalServiceWrapper(
		ViolationEntryLocalService violationEntryLocalService) {
		_violationEntryLocalService = violationEntryLocalService;
	}

	/**
	* Adds the violation entry to the database. Also notifies the appropriate model listeners.
	*
	* @param violationEntry the violation entry
	* @return the violation entry that was added
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry addViolationEntry(
		vn.com.fis.portal.model.ViolationEntry violationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.addViolationEntry(violationEntry);
	}

	/**
	* Creates a new violation entry with the primary key. Does not add the violation entry to the database.
	*
	* @param violationId the primary key for the new violation entry
	* @return the new violation entry
	*/
	public vn.com.fis.portal.model.ViolationEntry createViolationEntry(
		long violationId) {
		return _violationEntryLocalService.createViolationEntry(violationId);
	}

	/**
	* Deletes the violation entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param violationId the primary key of the violation entry
	* @throws PortalException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteViolationEntry(long violationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_violationEntryLocalService.deleteViolationEntry(violationId);
	}

	/**
	* Deletes the violation entry from the database. Also notifies the appropriate model listeners.
	*
	* @param violationEntry the violation entry
	* @throws SystemException if a system exception occurred
	*/
	public void deleteViolationEntry(
		vn.com.fis.portal.model.ViolationEntry violationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		_violationEntryLocalService.deleteViolationEntry(violationEntry);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.dynamicQueryCount(dynamicQuery);
	}

	public vn.com.fis.portal.model.ViolationEntry fetchViolationEntry(
		long violationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.fetchViolationEntry(violationId);
	}

	/**
	* Returns the violation entry with the primary key.
	*
	* @param violationId the primary key of the violation entry
	* @return the violation entry
	* @throws PortalException if a violation entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry getViolationEntry(
		long violationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.getViolationEntry(violationId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the violation entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of violation entries
	* @param end the upper bound of the range of violation entries (not inclusive)
	* @return the range of violation entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.fis.portal.model.ViolationEntry> getViolationEntries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.getViolationEntries(start, end);
	}

	/**
	* Returns the number of violation entries.
	*
	* @return the number of violation entries
	* @throws SystemException if a system exception occurred
	*/
	public int getViolationEntriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.getViolationEntriesCount();
	}

	/**
	* Updates the violation entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param violationEntry the violation entry
	* @return the violation entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry updateViolationEntry(
		vn.com.fis.portal.model.ViolationEntry violationEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.updateViolationEntry(violationEntry);
	}

	/**
	* Updates the violation entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param violationEntry the violation entry
	* @param merge whether to merge the violation entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the violation entry that was updated
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.fis.portal.model.ViolationEntry updateViolationEntry(
		vn.com.fis.portal.model.ViolationEntry violationEntry, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.updateViolationEntry(violationEntry,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _violationEntryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_violationEntryLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.findByStatus(status);
	}

	/**
	* Returns the number of violation entries where status = &#63;.
	*
	* @param status the status
	* @return the number of matching violation entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.countByStatus(status);
	}

	public java.util.List<vn.com.fis.portal.model.ViolationEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.findAll();
	}

	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _violationEntryLocalService.countAll();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public ViolationEntryLocalService getWrappedViolationEntryLocalService() {
		return _violationEntryLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedViolationEntryLocalService(
		ViolationEntryLocalService violationEntryLocalService) {
		_violationEntryLocalService = violationEntryLocalService;
	}

	public ViolationEntryLocalService getWrappedService() {
		return _violationEntryLocalService;
	}

	public void setWrappedService(
		ViolationEntryLocalService violationEntryLocalService) {
		_violationEntryLocalService = violationEntryLocalService;
	}

	private ViolationEntryLocalService _violationEntryLocalService;
}