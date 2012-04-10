package vn.com.fis.portal.portlet.categoryAdmin;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;


import vn.com.fis.portal.model.CategoryEntry;
import vn.com.fis.portal.service.CategoryEntryLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CategoryAdmin
 */
public class CategoryAdmin extends MVCPortlet {
	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(CategoryAdmin.class);
	
	public void addCategory(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String categoryName = ParamUtil.getString(actionRequest, "categoryName","");
		String description = ParamUtil.getString(actionRequest, "description","");
		int status = ParamUtil.getInteger(actionRequest, "status",0);
		if(Validator.isNull(categoryName)){
			SessionErrors.add(actionRequest, "category-name-is-not-null");
			return;
		}
		CategoryEntry categoryEntry = null;
		try {
			if(CategoryEntryLocalServiceUtil.countByCategoryNameAbsolute(categoryName) >0 ){
				SessionErrors.add(actionRequest, "category-name-is-exist");
				return;
			}
			// ok 
			categoryEntry = CategoryEntryLocalServiceUtil.createCategoryEntry(CounterLocalServiceUtil.increment(CategoryEntry.class.getName()));
			categoryEntry.setCategoryName(categoryName);
			categoryEntry.setDescription(description);
			categoryEntry.setStatus(status);
			CategoryEntryLocalServiceUtil.updateCategoryEntry(categoryEntry);
			SessionMessages.add(actionRequest, "category-entry-add-successfully");
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "category-entry-add-error");
			_log.error(e, e);
		}
		return;
	}

}
