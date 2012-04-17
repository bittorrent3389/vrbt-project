package vn.com.fis.portal.portlet.serviceTransactionChartReport;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ServiceTransactionChartReport
 */
public class ServiceTransactionChartReport extends MVCPortlet {
 
	public void viewChart(ActionRequest actionRequest, ActionResponse actionResponse ) {
		actionResponse.setRenderParameter("cbServiceChart", ParamUtil.getString(actionRequest, "cbServiceChart"));
		actionResponse.setRenderParameter("cbServicePackageChart", ParamUtil.getString(actionRequest, "cbServicePackageChart"));
		actionResponse.setRenderParameter("serviceTransactionCode", ParamUtil.getString(actionRequest, "serviceTransactionCode"));
	}
}
