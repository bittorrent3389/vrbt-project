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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.fis.portal.model.FolderEntry;
import vn.com.fis.portal.service.base.FolderEntryLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.FolderEntryUtil;

/**
 * The implementation of the folder entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.FolderEntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.FolderEntryLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.FolderEntryLocalServiceUtil
 */
public class FolderEntryLocalServiceImpl extends FolderEntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.FolderEntryLocalServiceUtil} to access the folder entry local service.
	 */
	/**
	 * Returns all the folder entries where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @return the matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderName(String folderName)
		throws SystemException {
		return FolderEntryUtil.findByFolderName(folderName);
	}
		/**
	 * Returns a range of all the folder entries where folderName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderName the folder name
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @return the range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderName(String folderName, int start,
		int end) throws SystemException {
		return FolderEntryUtil.findByFolderName(folderName, start, end);
	}
		/**
	 * Returns the number of folder entries where folderName = &#63;.
	 *
	 * @param folderName the folder name
	 * @return the number of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFolderName(String folderName) throws SystemException {
		return FolderEntryUtil.countByFolderName(folderName);
	}


	
	/**
	 * Returns all the folder entries where folderIdParent = &#63;.
	 *
	 * @param folderIdParent the folder ID parent
	 * @return the matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderIdParent(long folderIdParent)
		throws SystemException {
		return FolderEntryUtil.findByFolderIdParent(folderIdParent);
	}
	/**
	 * Returns a range of all the folder entries where folderIdParent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param folderIdParent the folder ID parent
	 * @param start the lower bound of the range of folder entries
	 * @param end the upper bound of the range of folder entries (not inclusive)
	 * @return the range of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<FolderEntry> findByFolderIdParent(long folderIdParent,
		int start, int end) throws SystemException {
		return FolderEntryUtil.findByFolderIdParent(folderIdParent, start, end);
	}
		/**
	 * Returns the number of folder entries where folderIdParent = &#63;.
	 *
	 * @param folderIdParent the folder ID parent
	 * @return the number of matching folder entries
	 * @throws SystemException if a system exception occurred
	 */
	public int countByFolderIdParent(long folderIdParent)
		throws SystemException {
		return FolderEntryUtil.countByFolderIdParent(folderIdParent);
		}
}