package vn.com.fis.portal.portlet.servicePackageTransactionChartReport;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ServicePackageTransactionChartReport
 */
public class ServicePackageTransactionChartReport extends MVCPortlet {
 
	public void viewChart(ActionRequest actionRequest, ActionResponse actionResponse ) {
		actionResponse.setRenderParameter("cbServiceChart", ParamUtil.getString(actionRequest, "cbServiceChart"));
		actionResponse.setRenderParameter("cbServicePackageChart", ParamUtil.getString(actionRequest, "cbServicePackageChart"));
		actionResponse.setRenderParameter("serviceTransactionCode", ParamUtil.getString(actionRequest, "serviceTransactionCode"));
	}
}
