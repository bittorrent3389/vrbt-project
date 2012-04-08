package vn.com.fis.portal.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ManagerThirdPartyTransaction
 */
public class ManagerThirdPartyTransaction extends MVCPortlet {
	public void seachVideoUserTransactionEntry(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		if (!ParamUtil.getString(actionRequest, "UserName").equals("null")
				&& !ParamUtil.getString(actionRequest, "UserName").equals("")) {
			actionResponse.setRenderParameter("UserName",
					ParamUtil.getString(actionRequest, "UserName"));
			
		}
		if (!ParamUtil.getString(actionRequest, "VideoName").equals("null")
				&& !ParamUtil.getString(actionRequest, "VideoName").equals("")) {
			actionResponse.setRenderParameter("VideoName",
					ParamUtil.getString(actionRequest, "VideoName"));
		}
		if (!ParamUtil.getString(actionRequest, "Transaction").equals("null")
				&& !ParamUtil.getString(actionRequest, "Transaction")
						.equals("")) {
			actionResponse.setRenderParameter("Transaction",
					ParamUtil.getString(actionRequest, "Transaction"));

		}
	
	}

}
