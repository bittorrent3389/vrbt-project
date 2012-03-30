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

import vn.com.fis.portal.model.CategoryEnty;
import vn.com.fis.portal.service.base.CategoryEntyLocalServiceBaseImpl;
import vn.com.fis.portal.service.persistence.CategoryEntyUtil;

/**
 * The implementation of the category enty local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link vn.com.fis.portal.service.CategoryEntyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author loind
 * @see vn.com.fis.portal.service.base.CategoryEntyLocalServiceBaseImpl
 * @see vn.com.fis.portal.service.CategoryEntyLocalServiceUtil
 */
public class CategoryEntyLocalServiceImpl
	extends CategoryEntyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link vn.com.fis.portal.service.CategoryEntyLocalServiceUtil} to access the category enty local service.
	 */
	
	/**
	 * Returns all the category enties where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the matching category enties
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEnty> findByCategoryName(String categoryName)
		throws SystemException {
		return CategoryEntyUtil.findByCategoryName(categoryName);
	}
	
	
	/**
	 * Returns a range of all the category enties where categoryName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param categoryName the category name
	 * @param start the lower bound of the range of category enties
	 * @param end the upper bound of the range of category enties (not inclusive)
	 * @return the range of matching category enties
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoryEnty> findByCategoryName(String categoryName,
		int start, int end) throws SystemException {
		return CategoryEntyUtil.findByCategoryName(categoryName, start, end);
	}

	/**
	 * Returns the number of category enties where categoryName = &#63;.
	 *
	 * @param categoryName the category name
	 * @return the number of matching category enties
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCategoryName(String categoryName)
		throws SystemException {
		return CategoryEntyUtil.countByCategoryName(categoryName);
	}
	
}