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

/**
 * @author loind
 */
public interface ServicePackageEntryFinder {
	public java.util.List<vn.com.fis.portal.model.ServicePackageEntry> search(
		java.lang.String ser_pacCode, java.lang.String ser_pacName,
		long serviceId, int status, int start, int end, int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int searchCount(java.lang.String ser_pacCode,
		java.lang.String ser_pacName, long serviceId, int status,
		int searchTypeFlag)
		throws com.liferay.portal.kernel.exception.SystemException;
}