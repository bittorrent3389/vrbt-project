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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import vn.com.fis.portal.model.CategoryEntryClp;
import vn.com.fis.portal.model.CategoryVideoEntryClp;
import vn.com.fis.portal.model.ContactEntryClp;
import vn.com.fis.portal.model.ContactGroupContactEntryClp;
import vn.com.fis.portal.model.ContactGroupEntryClp;
import vn.com.fis.portal.model.ContactGroupVideoGroupEntryClp;
import vn.com.fis.portal.model.FolderEntryClp;
import vn.com.fis.portal.model.NotificationEntryClp;
import vn.com.fis.portal.model.RatingEntryClp;
import vn.com.fis.portal.model.ServiceEntryClp;
import vn.com.fis.portal.model.ServicePackageEntryClp;
import vn.com.fis.portal.model.ServiceTransactionEntryClp;
import vn.com.fis.portal.model.UserEntryClp;
import vn.com.fis.portal.model.UserServiceEntryClp;
import vn.com.fis.portal.model.VideoEntryClp;
import vn.com.fis.portal.model.VideoGroupEntryClp;
import vn.com.fis.portal.model.VideoUserContactEntryClp;
import vn.com.fis.portal.model.VideoUserEntryClp;
import vn.com.fis.portal.model.VideoUserTransactionEntryClp;
import vn.com.fis.portal.model.VideoUserVideoGroupEntryClp;
import vn.com.fis.portal.model.ViolationEntryClp;
import vn.com.fis.portal.model.ViolationVideoEntryClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"VRBT-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"VRBT-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "VRBT-portlet";
			}

			return _servletContextName;
		}
	}

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CategoryEntryClp.class.getName())) {
			return translateInputCategoryEntry(oldModel);
		}

		if (oldModelClassName.equals(CategoryVideoEntryClp.class.getName())) {
			return translateInputCategoryVideoEntry(oldModel);
		}

		if (oldModelClassName.equals(ContactEntryClp.class.getName())) {
			return translateInputContactEntry(oldModel);
		}

		if (oldModelClassName.equals(
					ContactGroupContactEntryClp.class.getName())) {
			return translateInputContactGroupContactEntry(oldModel);
		}

		if (oldModelClassName.equals(ContactGroupEntryClp.class.getName())) {
			return translateInputContactGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(
					ContactGroupVideoGroupEntryClp.class.getName())) {
			return translateInputContactGroupVideoGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(FolderEntryClp.class.getName())) {
			return translateInputFolderEntry(oldModel);
		}

		if (oldModelClassName.equals(NotificationEntryClp.class.getName())) {
			return translateInputNotificationEntry(oldModel);
		}

		if (oldModelClassName.equals(RatingEntryClp.class.getName())) {
			return translateInputRatingEntry(oldModel);
		}

		if (oldModelClassName.equals(ServiceEntryClp.class.getName())) {
			return translateInputServiceEntry(oldModel);
		}

		if (oldModelClassName.equals(ServicePackageEntryClp.class.getName())) {
			return translateInputServicePackageEntry(oldModel);
		}

		if (oldModelClassName.equals(ServiceTransactionEntryClp.class.getName())) {
			return translateInputServiceTransactionEntry(oldModel);
		}

		if (oldModelClassName.equals(UserEntryClp.class.getName())) {
			return translateInputUserEntry(oldModel);
		}

		if (oldModelClassName.equals(UserServiceEntryClp.class.getName())) {
			return translateInputUserServiceEntry(oldModel);
		}

		if (oldModelClassName.equals(VideoEntryClp.class.getName())) {
			return translateInputVideoEntry(oldModel);
		}

		if (oldModelClassName.equals(VideoGroupEntryClp.class.getName())) {
			return translateInputVideoGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(VideoUserContactEntryClp.class.getName())) {
			return translateInputVideoUserContactEntry(oldModel);
		}

		if (oldModelClassName.equals(VideoUserEntryClp.class.getName())) {
			return translateInputVideoUserEntry(oldModel);
		}

		if (oldModelClassName.equals(
					VideoUserTransactionEntryClp.class.getName())) {
			return translateInputVideoUserTransactionEntry(oldModel);
		}

		if (oldModelClassName.equals(
					VideoUserVideoGroupEntryClp.class.getName())) {
			return translateInputVideoUserVideoGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(ViolationEntryClp.class.getName())) {
			return translateInputViolationEntry(oldModel);
		}

		if (oldModelClassName.equals(ViolationVideoEntryClp.class.getName())) {
			return translateInputViolationVideoEntry(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCategoryEntry(BaseModel<?> oldModel) {
		CategoryEntryClp oldCplModel = (CategoryEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.CategoryEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCategoryId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCategoryName",
						new Class[] { String.class });

				String value1 = oldCplModel.getCategoryName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getStatus());

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputCategoryVideoEntry(BaseModel<?> oldModel) {
		CategoryVideoEntryClp oldCplModel = (CategoryVideoEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.CategoryVideoEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setCategoryViceoId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getCategoryViceoId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setCategoryId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getCategoryId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setVideoId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getVideoId());

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputContactEntry(BaseModel<?> oldModel) {
		ContactEntryClp oldCplModel = (ContactEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ContactEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setContactId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getContactId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setContactName",
						new Class[] { String.class });

				String value1 = oldCplModel.getContactName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMobileNumber",
						new Class[] { String.class });

				String value2 = oldCplModel.getMobileNumber();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputContactGroupContactEntry(
		BaseModel<?> oldModel) {
		ContactGroupContactEntryClp oldCplModel = (ContactGroupContactEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ContactGroupContactEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setContactGroupContactId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getContactGroupContactId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setContactId",
						new Class[] { String.class });

				String value1 = oldCplModel.getContactId();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setContactGroupId",
						new Class[] { String.class });

				String value2 = oldCplModel.getContactGroupId();

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputContactGroupEntry(BaseModel<?> oldModel) {
		ContactGroupEntryClp oldCplModel = (ContactGroupEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ContactGroupEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setContactGroupId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getContactGroupId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setContactGroupName",
						new Class[] { String.class });

				String value1 = oldCplModel.getContactGroupName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setContactGroupType",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getContactGroupType());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputContactGroupVideoGroupEntry(
		BaseModel<?> oldModel) {
		ContactGroupVideoGroupEntryClp oldCplModel = (ContactGroupVideoGroupEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ContactGroupVideoGroupEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setContactGroupVideoGroupEntryId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getContactGroupVideoGroupEntryId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setContactGroupId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getContactGroupId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setVideoGroupId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getVideoGroupId());

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputFolderEntry(BaseModel<?> oldModel) {
		FolderEntryClp oldCplModel = (FolderEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.FolderEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setFolderId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getFolderId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setFolderName",
						new Class[] { String.class });

				String value1 = oldCplModel.getFolderName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value3 = oldCplModel.getCreateDate();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getModifiedDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setFolderIdParent",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getFolderIdParent());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getUserId());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputNotificationEntry(BaseModel<?> oldModel) {
		NotificationEntryClp oldCplModel = (NotificationEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.NotificationEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setNotificationId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getNotificationId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserIdFrom",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserIdFrom());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserIdTo",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserIdTo());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setSubject",
						new Class[] { String.class });

				String value3 = oldCplModel.getSubject();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setMessage",
						new Class[] { String.class });

				String value4 = oldCplModel.getMessage();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getCreateDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getStatus());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputRatingEntry(BaseModel<?> oldModel) {
		RatingEntryClp oldCplModel = (RatingEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.RatingEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setRatingId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getRatingId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVideoId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getVideoId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCode",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getCode());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDate_",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getDate_();

				method4.invoke(newModel, value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputServiceEntry(BaseModel<?> oldModel) {
		ServiceEntryClp oldCplModel = (ServiceEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ServiceEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setServiceId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getServiceId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setServiceCode",
						new Class[] { String.class });

				String value1 = oldCplModel.getServiceCode();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setServiceName",
						new Class[] { String.class });

				String value2 = oldCplModel.getServiceName();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value3 = oldCplModel.getDescription();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreateDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getStatus());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputServicePackageEntry(
		BaseModel<?> oldModel) {
		ServicePackageEntryClp oldCplModel = (ServicePackageEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ServicePackageEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setServicePackageId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getServicePackageId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setServicePackageName",
						new Class[] { String.class });

				String value1 = oldCplModel.getServicePackageName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setServicePackageCode",
						new Class[] { String.class });

				String value2 = oldCplModel.getServicePackageCode();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value3 = oldCplModel.getDescription();

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setTotalFile",
						new Class[] { Integer.TYPE });

				Integer value4 = new Integer(oldCplModel.getTotalFile());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getCreateDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getModifiedDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setServiceId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getServiceId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getStatus());

				method8.invoke(newModel, value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputServiceTransactionEntry(
		BaseModel<?> oldModel) {
		ServiceTransactionEntryClp oldCplModel = (ServiceTransactionEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ServiceTransactionEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setTransactionId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getTransactionId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTransactionCode",
						new Class[] { Integer.TYPE });

				Integer value1 = new Integer(oldCplModel.getTransactionCode());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDate_",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getDate_();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setServiceId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getServiceId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setServiceStatus",
						new Class[] { Integer.TYPE });

				Integer value5 = new Integer(oldCplModel.getServiceStatus());

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setServiceStartDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getServiceStartDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setServiceEndDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getServiceEndDate();

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setServicePackageId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getServicePackageId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setPackageDate",
						new Class[] { Date.class });

				Date value9 = oldCplModel.getPackageDate();

				method9.invoke(newModel, value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputUserEntry(BaseModel<?> oldModel) {
		UserEntryClp oldCplModel = (UserEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.UserEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getUserId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserName",
						new Class[] { String.class });

				String value1 = oldCplModel.getUserName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setMobileNumber",
						new Class[] { String.class });

				String value2 = oldCplModel.getMobileNumber();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setCreateDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getCreateDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setModifiedDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getModifiedDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getStatus());

				method6.invoke(newModel, value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputUserServiceEntry(BaseModel<?> oldModel) {
		UserServiceEntryClp oldCplModel = (UserServiceEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.UserServiceEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setUserServiceId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getUserServiceId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setServiceId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getServiceId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setServiceStatus",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getServiceStatus());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setServiceStartDate",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getServiceStartDate();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setServiceStopDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getServiceStopDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setServicePackageId",
						new Class[] { Long.TYPE });

				Long value6 = new Long(oldCplModel.getServicePackageId());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setPackageDate",
						new Class[] { Date.class });

				Date value7 = oldCplModel.getPackageDate();

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputVideoEntry(BaseModel<?> oldModel) {
		VideoEntryClp oldCplModel = (VideoEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.VideoEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setVideoId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getVideoId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVideoName",
						new Class[] { String.class });

				String value1 = oldCplModel.getVideoName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setViewCount",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getViewCount());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDate_",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getDate_();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setSmallImageUrl",
						new Class[] { String.class });

				String value5 = oldCplModel.getSmallImageUrl();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setLargeImageUrl",
						new Class[] { String.class });

				String value6 = oldCplModel.getLargeImageUrl();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setAccessModifier",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getAccessModifier());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setUploaderId",
						new Class[] { Long.TYPE });

				Long value8 = new Long(oldCplModel.getUploaderId());

				method8.invoke(newModel, value8);

				Method method9 = newModelClass.getMethod("setFolderId",
						new Class[] { Long.TYPE });

				Long value9 = new Long(oldCplModel.getFolderId());

				method9.invoke(newModel, value9);

				Method method10 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value10 = new Integer(oldCplModel.getStatus());

				method10.invoke(newModel, value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputVideoGroupEntry(BaseModel<?> oldModel) {
		VideoGroupEntryClp oldCplModel = (VideoGroupEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.VideoGroupEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setVideoGroupId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getVideoGroupId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVideoGroupName",
						new Class[] { String.class });

				String value1 = oldCplModel.getVideoGroupName();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputVideoUserContactEntry(
		BaseModel<?> oldModel) {
		VideoUserContactEntryClp oldCplModel = (VideoUserContactEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.VideoUserContactEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setVideoUserContactId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getVideoUserContactId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVideoUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getVideoUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setContactId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getContactId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setCompanyId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getCompanyId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setStartTime",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getStartTime();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setEndTime",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getEndTime();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setPriority",
						new Class[] { Integer.TYPE });

				Integer value6 = new Integer(oldCplModel.getPriority());

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value7 = new Integer(oldCplModel.getStatus());

				method7.invoke(newModel, value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputVideoUserEntry(BaseModel<?> oldModel) {
		VideoUserEntryClp oldCplModel = (VideoUserEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.VideoUserEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setVideoUserId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getVideoUserId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVideoId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getVideoId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getUserId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setOriginCode",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getOriginCode());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDate_",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getDate_();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setStartDate",
						new Class[] { Date.class });

				Date value5 = oldCplModel.getStartDate();

				method5.invoke(newModel, value5);

				Method method6 = newModelClass.getMethod("setEndDate",
						new Class[] { Date.class });

				Date value6 = oldCplModel.getEndDate();

				method6.invoke(newModel, value6);

				Method method7 = newModelClass.getMethod("setSenderId",
						new Class[] { Long.TYPE });

				Long value7 = new Long(oldCplModel.getSenderId());

				method7.invoke(newModel, value7);

				Method method8 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value8 = new Integer(oldCplModel.getStatus());

				method8.invoke(newModel, value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputVideoUserTransactionEntry(
		BaseModel<?> oldModel) {
		VideoUserTransactionEntryClp oldCplModel = (VideoUserTransactionEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.VideoUserTransactionEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setTransactionId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getTransactionId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setTransactionCode",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getTransactionCode());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDate_",
						new Class[] { Date.class });

				Date value2 = oldCplModel.getDate_();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setVideoId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getVideoId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value4 = new Long(oldCplModel.getUserId());

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setReceiverId",
						new Class[] { Long.TYPE });

				Long value5 = new Long(oldCplModel.getReceiverId());

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputVideoUserVideoGroupEntry(
		BaseModel<?> oldModel) {
		VideoUserVideoGroupEntryClp oldCplModel = (VideoUserVideoGroupEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.VideoUserVideoGroupEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setVideoUserVideoGroupID",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getVideoUserVideoGroupID());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setVideoUserId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getVideoUserId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setVideoGroupId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getVideoGroupId());

				method2.invoke(newModel, value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputViolationEntry(BaseModel<?> oldModel) {
		ViolationEntryClp oldCplModel = (ViolationEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ViolationEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setViolationId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getViolationId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setViolationTitle",
						new Class[] { String.class });

				String value1 = oldCplModel.getViolationTitle();

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value2 = oldCplModel.getDescription();

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setStatus",
						new Class[] { Integer.TYPE });

				Integer value3 = new Integer(oldCplModel.getStatus());

				method3.invoke(newModel, value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInputViolationVideoEntry(
		BaseModel<?> oldModel) {
		ViolationVideoEntryClp oldCplModel = (ViolationVideoEntryClp)oldModel;

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				Class<?> newModelClass = Class.forName("vn.com.fis.portal.model.impl.ViolationVideoEntryImpl",
						true, _classLoader);

				Object newModel = newModelClass.newInstance();

				Method method0 = newModelClass.getMethod("setViolationVideoId",
						new Class[] { Long.TYPE });

				Long value0 = new Long(oldCplModel.getViolationVideoId());

				method0.invoke(newModel, value0);

				Method method1 = newModelClass.getMethod("setViolationId",
						new Class[] { Long.TYPE });

				Long value1 = new Long(oldCplModel.getViolationId());

				method1.invoke(newModel, value1);

				Method method2 = newModelClass.getMethod("setVideoId",
						new Class[] { Long.TYPE });

				Long value2 = new Long(oldCplModel.getVideoId());

				method2.invoke(newModel, value2);

				Method method3 = newModelClass.getMethod("setUserId",
						new Class[] { Long.TYPE });

				Long value3 = new Long(oldCplModel.getUserId());

				method3.invoke(newModel, value3);

				Method method4 = newModelClass.getMethod("setDate_",
						new Class[] { Date.class });

				Date value4 = oldCplModel.getDate_();

				method4.invoke(newModel, value4);

				Method method5 = newModelClass.getMethod("setDescription",
						new Class[] { String.class });

				String value5 = oldCplModel.getDescription();

				method5.invoke(newModel, value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.CategoryEntryImpl")) {
			return translateOutputCategoryEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.CategoryVideoEntryImpl")) {
			return translateOutputCategoryVideoEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ContactEntryImpl")) {
			return translateOutputContactEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ContactGroupContactEntryImpl")) {
			return translateOutputContactGroupContactEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ContactGroupEntryImpl")) {
			return translateOutputContactGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ContactGroupVideoGroupEntryImpl")) {
			return translateOutputContactGroupVideoGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.FolderEntryImpl")) {
			return translateOutputFolderEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.NotificationEntryImpl")) {
			return translateOutputNotificationEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.RatingEntryImpl")) {
			return translateOutputRatingEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ServiceEntryImpl")) {
			return translateOutputServiceEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ServicePackageEntryImpl")) {
			return translateOutputServicePackageEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ServiceTransactionEntryImpl")) {
			return translateOutputServiceTransactionEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.UserEntryImpl")) {
			return translateOutputUserEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.UserServiceEntryImpl")) {
			return translateOutputUserServiceEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.VideoEntryImpl")) {
			return translateOutputVideoEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.VideoGroupEntryImpl")) {
			return translateOutputVideoGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.VideoUserContactEntryImpl")) {
			return translateOutputVideoUserContactEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.VideoUserEntryImpl")) {
			return translateOutputVideoUserEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.VideoUserTransactionEntryImpl")) {
			return translateOutputVideoUserTransactionEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.VideoUserVideoGroupEntryImpl")) {
			return translateOutputVideoUserVideoGroupEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ViolationEntryImpl")) {
			return translateOutputViolationEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"vn.com.fis.portal.model.impl.ViolationVideoEntryImpl")) {
			return translateOutputViolationVideoEntry(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutputCategoryEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CategoryEntryClp newModel = new CategoryEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value0);

				Method method1 = oldModelClass.getMethod("getCategoryName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setCategoryName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getStatus");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputCategoryVideoEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				CategoryVideoEntryClp newModel = new CategoryVideoEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getCategoryViceoId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setCategoryViceoId(value0);

				Method method1 = oldModelClass.getMethod("getCategoryId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setCategoryId(value1);

				Method method2 = oldModelClass.getMethod("getVideoId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setVideoId(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputContactEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ContactEntryClp newModel = new ContactEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getContactId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setContactId(value0);

				Method method1 = oldModelClass.getMethod("getContactName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setContactName(value1);

				Method method2 = oldModelClass.getMethod("getMobileNumber");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMobileNumber(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputContactGroupContactEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ContactGroupContactEntryClp newModel = new ContactGroupContactEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getContactGroupContactId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setContactGroupContactId(value0);

				Method method1 = oldModelClass.getMethod("getContactId");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setContactId(value1);

				Method method2 = oldModelClass.getMethod("getContactGroupId");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setContactGroupId(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputContactGroupEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ContactGroupEntryClp newModel = new ContactGroupEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getContactGroupId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setContactGroupId(value0);

				Method method1 = oldModelClass.getMethod("getContactGroupName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setContactGroupName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getContactGroupType");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setContactGroupType(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputContactGroupVideoGroupEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ContactGroupVideoGroupEntryClp newModel = new ContactGroupVideoGroupEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getContactGroupVideoGroupEntryId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setContactGroupVideoGroupEntryId(value0);

				Method method1 = oldModelClass.getMethod("getContactGroupId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setContactGroupId(value1);

				Method method2 = oldModelClass.getMethod("getVideoGroupId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setVideoGroupId(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputFolderEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				FolderEntryClp newModel = new FolderEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getFolderId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setFolderId(value0);

				Method method1 = oldModelClass.getMethod("getFolderName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setFolderName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getCreateDate");

				Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value3);

				Method method4 = oldModelClass.getMethod("getModifiedDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value4);

				Method method5 = oldModelClass.getMethod("getFolderIdParent");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setFolderIdParent(value5);

				Method method6 = oldModelClass.getMethod("getUserId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setUserId(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputNotificationEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				NotificationEntryClp newModel = new NotificationEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getNotificationId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setNotificationId(value0);

				Method method1 = oldModelClass.getMethod("getUserIdFrom");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserIdFrom(value1);

				Method method2 = oldModelClass.getMethod("getUserIdTo");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserIdTo(value2);

				Method method3 = oldModelClass.getMethod("getSubject");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setSubject(value3);

				Method method4 = oldModelClass.getMethod("getMessage");

				String value4 = (String)method4.invoke(oldModel, (Object[])null);

				newModel.setMessage(value4);

				Method method5 = oldModelClass.getMethod("getCreateDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value5);

				Method method6 = oldModelClass.getMethod("getStatus");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputRatingEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				RatingEntryClp newModel = new RatingEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getRatingId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setRatingId(value0);

				Method method1 = oldModelClass.getMethod("getVideoId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setVideoId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getCode");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setCode(value3);

				Method method4 = oldModelClass.getMethod("getDate_");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setDate_(value4);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputServiceEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ServiceEntryClp newModel = new ServiceEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getServiceId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setServiceId(value0);

				Method method1 = oldModelClass.getMethod("getServiceCode");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setServiceCode(value1);

				Method method2 = oldModelClass.getMethod("getServiceName");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setServiceName(value2);

				Method method3 = oldModelClass.getMethod("getDescription");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setDescription(value3);

				Method method4 = oldModelClass.getMethod("getCreateDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getStatus");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputServicePackageEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ServicePackageEntryClp newModel = new ServicePackageEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getServicePackageId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setServicePackageId(value0);

				Method method1 = oldModelClass.getMethod(
						"getServicePackageName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setServicePackageName(value1);

				Method method2 = oldModelClass.getMethod(
						"getServicePackageCode");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setServicePackageCode(value2);

				Method method3 = oldModelClass.getMethod("getDescription");

				String value3 = (String)method3.invoke(oldModel, (Object[])null);

				newModel.setDescription(value3);

				Method method4 = oldModelClass.getMethod("getTotalFile");

				Integer value4 = (Integer)method4.invoke(oldModel,
						(Object[])null);

				newModel.setTotalFile(value4);

				Method method5 = oldModelClass.getMethod("getCreateDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value5);

				Method method6 = oldModelClass.getMethod("getModifiedDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value6);

				Method method7 = oldModelClass.getMethod("getServiceId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setServiceId(value7);

				Method method8 = oldModelClass.getMethod("getStatus");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputServiceTransactionEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ServiceTransactionEntryClp newModel = new ServiceTransactionEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getTransactionId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setTransactionId(value0);

				Method method1 = oldModelClass.getMethod("getTransactionCode");

				Integer value1 = (Integer)method1.invoke(oldModel,
						(Object[])null);

				newModel.setTransactionCode(value1);

				Method method2 = oldModelClass.getMethod("getDate_");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setDate_(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getServiceId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setServiceId(value4);

				Method method5 = oldModelClass.getMethod("getServiceStatus");

				Integer value5 = (Integer)method5.invoke(oldModel,
						(Object[])null);

				newModel.setServiceStatus(value5);

				Method method6 = oldModelClass.getMethod("getServiceStartDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setServiceStartDate(value6);

				Method method7 = oldModelClass.getMethod("getServiceEndDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setServiceEndDate(value7);

				Method method8 = oldModelClass.getMethod("getServicePackageId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setServicePackageId(value8);

				Method method9 = oldModelClass.getMethod("getPackageDate");

				Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

				newModel.setPackageDate(value9);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputUserEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				UserEntryClp newModel = new UserEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUserId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setUserId(value0);

				Method method1 = oldModelClass.getMethod("getUserName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setUserName(value1);

				Method method2 = oldModelClass.getMethod("getMobileNumber");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setMobileNumber(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getCreateDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setCreateDate(value4);

				Method method5 = oldModelClass.getMethod("getModifiedDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setModifiedDate(value5);

				Method method6 = oldModelClass.getMethod("getStatus");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value6);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputUserServiceEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				UserServiceEntryClp newModel = new UserServiceEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getUserServiceId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setUserServiceId(value0);

				Method method1 = oldModelClass.getMethod("getUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setUserId(value1);

				Method method2 = oldModelClass.getMethod("getServiceId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setServiceId(value2);

				Method method3 = oldModelClass.getMethod("getServiceStatus");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setServiceStatus(value3);

				Method method4 = oldModelClass.getMethod("getServiceStartDate");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setServiceStartDate(value4);

				Method method5 = oldModelClass.getMethod("getServiceStopDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setServiceStopDate(value5);

				Method method6 = oldModelClass.getMethod("getServicePackageId");

				Long value6 = (Long)method6.invoke(oldModel, (Object[])null);

				newModel.setServicePackageId(value6);

				Method method7 = oldModelClass.getMethod("getPackageDate");

				Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

				newModel.setPackageDate(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputVideoEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VideoEntryClp newModel = new VideoEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getVideoId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setVideoId(value0);

				Method method1 = oldModelClass.getMethod("getVideoName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setVideoName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getViewCount");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setViewCount(value3);

				Method method4 = oldModelClass.getMethod("getDate_");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setDate_(value4);

				Method method5 = oldModelClass.getMethod("getSmallImageUrl");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setSmallImageUrl(value5);

				Method method6 = oldModelClass.getMethod("getLargeImageUrl");

				String value6 = (String)method6.invoke(oldModel, (Object[])null);

				newModel.setLargeImageUrl(value6);

				Method method7 = oldModelClass.getMethod("getAccessModifier");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setAccessModifier(value7);

				Method method8 = oldModelClass.getMethod("getUploaderId");

				Long value8 = (Long)method8.invoke(oldModel, (Object[])null);

				newModel.setUploaderId(value8);

				Method method9 = oldModelClass.getMethod("getFolderId");

				Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

				newModel.setFolderId(value9);

				Method method10 = oldModelClass.getMethod("getStatus");

				Integer value10 = (Integer)method10.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value10);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputVideoGroupEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VideoGroupEntryClp newModel = new VideoGroupEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getVideoGroupId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setVideoGroupId(value0);

				Method method1 = oldModelClass.getMethod("getVideoGroupName");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setVideoGroupName(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputVideoUserContactEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VideoUserContactEntryClp newModel = new VideoUserContactEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getVideoUserContactId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setVideoUserContactId(value0);

				Method method1 = oldModelClass.getMethod("getVideoUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setVideoUserId(value1);

				Method method2 = oldModelClass.getMethod("getContactId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setContactId(value2);

				Method method3 = oldModelClass.getMethod("getCompanyId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setCompanyId(value3);

				Method method4 = oldModelClass.getMethod("getStartTime");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setStartTime(value4);

				Method method5 = oldModelClass.getMethod("getEndTime");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setEndTime(value5);

				Method method6 = oldModelClass.getMethod("getPriority");

				Integer value6 = (Integer)method6.invoke(oldModel,
						(Object[])null);

				newModel.setPriority(value6);

				Method method7 = oldModelClass.getMethod("getStatus");

				Integer value7 = (Integer)method7.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value7);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputVideoUserEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VideoUserEntryClp newModel = new VideoUserEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getVideoUserId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setVideoUserId(value0);

				Method method1 = oldModelClass.getMethod("getVideoId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setVideoId(value1);

				Method method2 = oldModelClass.getMethod("getUserId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setUserId(value2);

				Method method3 = oldModelClass.getMethod("getOriginCode");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setOriginCode(value3);

				Method method4 = oldModelClass.getMethod("getDate_");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setDate_(value4);

				Method method5 = oldModelClass.getMethod("getStartDate");

				Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

				newModel.setStartDate(value5);

				Method method6 = oldModelClass.getMethod("getEndDate");

				Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

				newModel.setEndDate(value6);

				Method method7 = oldModelClass.getMethod("getSenderId");

				Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

				newModel.setSenderId(value7);

				Method method8 = oldModelClass.getMethod("getStatus");

				Integer value8 = (Integer)method8.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value8);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputVideoUserTransactionEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VideoUserTransactionEntryClp newModel = new VideoUserTransactionEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getTransactionId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setTransactionId(value0);

				Method method1 = oldModelClass.getMethod("getTransactionCode");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setTransactionCode(value1);

				Method method2 = oldModelClass.getMethod("getDate_");

				Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

				newModel.setDate_(value2);

				Method method3 = oldModelClass.getMethod("getVideoId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setVideoId(value3);

				Method method4 = oldModelClass.getMethod("getUserId");

				Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

				newModel.setUserId(value4);

				Method method5 = oldModelClass.getMethod("getReceiverId");

				Long value5 = (Long)method5.invoke(oldModel, (Object[])null);

				newModel.setReceiverId(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputVideoUserVideoGroupEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				VideoUserVideoGroupEntryClp newModel = new VideoUserVideoGroupEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod(
						"getVideoUserVideoGroupID");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setVideoUserVideoGroupID(value0);

				Method method1 = oldModelClass.getMethod("getVideoUserId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setVideoUserId(value1);

				Method method2 = oldModelClass.getMethod("getVideoGroupId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setVideoGroupId(value2);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputViolationEntry(BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ViolationEntryClp newModel = new ViolationEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getViolationId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setViolationId(value0);

				Method method1 = oldModelClass.getMethod("getViolationTitle");

				String value1 = (String)method1.invoke(oldModel, (Object[])null);

				newModel.setViolationTitle(value1);

				Method method2 = oldModelClass.getMethod("getDescription");

				String value2 = (String)method2.invoke(oldModel, (Object[])null);

				newModel.setDescription(value2);

				Method method3 = oldModelClass.getMethod("getStatus");

				Integer value3 = (Integer)method3.invoke(oldModel,
						(Object[])null);

				newModel.setStatus(value3);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	public static Object translateOutputViolationVideoEntry(
		BaseModel<?> oldModel) {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(_classLoader);

			try {
				ViolationVideoEntryClp newModel = new ViolationVideoEntryClp();

				Class<?> oldModelClass = oldModel.getClass();

				Method method0 = oldModelClass.getMethod("getViolationVideoId");

				Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

				newModel.setViolationVideoId(value0);

				Method method1 = oldModelClass.getMethod("getViolationId");

				Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

				newModel.setViolationId(value1);

				Method method2 = oldModelClass.getMethod("getVideoId");

				Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

				newModel.setVideoId(value2);

				Method method3 = oldModelClass.getMethod("getUserId");

				Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

				newModel.setUserId(value3);

				Method method4 = oldModelClass.getMethod("getDate_");

				Date value4 = (Date)method4.invoke(oldModel, (Object[])null);

				newModel.setDate_(value4);

				Method method5 = oldModelClass.getMethod("getDescription");

				String value5 = (String)method5.invoke(oldModel, (Object[])null);

				newModel.setDescription(value5);

				return newModel;
			}
			catch (Exception e) {
				_log.error(e, e);
			}
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}

		return oldModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
	private static String _servletContextName;
}