package vn.com.fis.portal.service.persistence;

import java.util.ArrayList;
import java.util.List;

import vn.com.fis.portal.model.CategoryEntry;
import vn.com.fis.portal.model.ServiceEntry;
import vn.com.fis.portal.model.impl.CategoryEntryImpl;
import vn.com.fis.portal.model.impl.ServiceEntryImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class CategoryEntryFinderImpl extends BasePersistenceImpl<CategoryEntry> implements CategoryEntryFinder {
	 
}
