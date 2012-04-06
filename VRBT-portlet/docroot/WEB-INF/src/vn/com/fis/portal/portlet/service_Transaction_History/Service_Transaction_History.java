package vn.com.fis.portal.portlet.service_Transaction_History;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Service_Transaction_History
 */
public class Service_Transaction_History extends MVCPortlet {
	public void searchTransactionHistory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("cbServiceChart", ParamUtil.getString(actionRequest, "cbServiceChart"));
		actionResponse.setRenderParameter("cbServicePackageChart", ParamUtil.getString(actionRequest, "cbServicePackageChart"));
		actionResponse.setRenderParameter("serviceTransactionCode", ParamUtil.getString(actionRequest, "serviceTransactionCode"));
	}
	
	public void viewChart(ActionRequest actionRequest, ActionResponse actionResponse ) {
		actionResponse.setRenderParameter("cbServiceChart", ParamUtil.getString(actionRequest, "cbServiceChart"));
		actionResponse.setRenderParameter("cbServicePackageChart", ParamUtil.getString(actionRequest, "cbServicePackageChart"));
		actionResponse.setRenderParameter("serviceTransactionCode", ParamUtil.getString(actionRequest, "serviceTransactionCode"));
	}

}
