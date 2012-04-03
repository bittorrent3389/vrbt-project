package vn.com.fis.portal;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.model.VideoEntry;
import vn.com.fis.portal.model.VideoUserEntry;
import vn.com.fis.portal.portlet.util.System_Notification;
import vn.com.fis.portal.portlet.util.service.UserExtLocalServiceUtil;
import vn.com.fis.portal.portlet.util.service.VideoExtLocalServiceUtil;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil;
import vn.com.fis.portal.service.persistence.VideoEntryFinderImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sun.corba.se.spi.activation._LocatorImplBase;

/**
 * Portlet implementation class MyVideoPortlet
 */
public class MyVideoPortlet extends MVCPortlet {
 	
	public void searchMyVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
	
		String videoName = ParamUtil.getString(actionRequest, "videoName",null);
		int originCode = ParamUtil.getInteger(actionRequest, "originCode",-1);
		int serviceActive = ParamUtil.getInteger(actionRequest, "serviceActive",-1);
		actionResponse.setRenderParameter("videoName", videoName);
		actionResponse.setRenderParameter("originCode", String.valueOf(originCode));
		actionResponse.setRenderParameter("serviceActive", String.valueOf(serviceActive));
		actionResponse.setRenderParameter("jspPage", ParamUtil.getString(actionRequest, "jspPage"));
//		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "jspPage"));
	}
	public void deleteMyVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		//super.processAction(actionRequest, actionResponse);
		long videoId = ParamUtil.getLong(actionRequest, "videoId",0);
		long userId = PortalUtil.getUserId(actionRequest);
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		VideoUserEntry  videoUserEntry =null;
		try {
			videoUserEntry = VideoUserEntryLocalServiceUtil.findByVideoId_UserId(videoId, userId);
			if(videoUserEntry!=null){
				VideoUserEntryLocalServiceUtil.deleteVideoUserEntry(videoUserEntry.getVideoUserId());
			}
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "delete-my-video-error");
			e.printStackTrace();
		}
		SessionMessages.add(actionRequest, "delete-my-video-success");
		
		actionResponse.sendRedirect(redirect);
	}
	
	public void serviceActive(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		long videoId = ParamUtil.getLong(actionRequest, "videoId",0);
		long userId = PortalUtil.getUserId(actionRequest); 
		boolean  inactiveService = ParamUtil.getBoolean(actionRequest, "inactiveService",false);
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		VideoUserEntry  videoUserEntry =null; // 
				try {
					
					videoUserEntry = VideoUserEntryLocalServiceUtil.findByVideoId_UserId(videoId, userId);
					// set serviceActive=1
					if(inactiveService){ //inactive
						videoUserEntry.setServiceActive(0);
					}else{
						videoUserEntry.setServiceActive(1);
					}
					VideoUserEntryLocalServiceUtil.updateVideoUserEntry(videoUserEntry,true);
					
				} catch (Exception e) {
					// TODO: handle exception
					SessionErrors.add(actionRequest, Exception.class.getName());
					return;
				}
				SessionMessages.add(actionRequest, "service-active-successfully");
		actionResponse.sendRedirect(redirect);
	}


	public void sendToFriend(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		long videoId = ParamUtil.getLong(actionRequest, "videoId",0);
		long userId = PortalUtil.getUserId(actionRequest); // sender
		String receiverMobileNumber = ParamUtil.getString(actionRequest, "receiverMobileNumber","");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		if(videoId <1 || userId<1) {
			return ;
		}
		
		
		UserEntry receiver =null; 
		try {
			receiver =UserEntryLocalServiceUtil.findByMobilePhone(receiverMobileNumber);
			if(receiver ==null)  throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "not-found-receiver");
			actionResponse.sendRedirect(redirect);
			return;
		}
		 
		// send exc 
		VideoUserEntry  videoUserEntry =null; // receiver
		try {
			
			videoUserEntry = VideoUserEntryLocalServiceUtil.createVideoUserEntry(CounterLocalServiceUtil.increment(VideoUserEntry.class.getName()));
			videoUserEntry.setUserId(receiver.getUserId());
			videoUserEntry.setSenderId(userId);
			videoUserEntry.setVideoId(videoId);
			videoUserEntry.setDate_(Calendar.getInstance().getTime());
			videoUserEntry.setStartDate(Calendar.getInstance().getTime());
			videoUserEntry.setOriginCode(3);
			videoUserEntry.setStatus(1);
			VideoUserEntryLocalServiceUtil.updateVideoUserEntry(videoUserEntry);
// 	remove video of sender  
//			VideoUserEntryLocalServiceUtil.deleteVideoUserEntry(videoUserId)
			videoUserEntry =	VideoUserEntryLocalServiceUtil.findByVideoId_UserId(videoId, userId);
			VideoUserEntryLocalServiceUtil.deleteVideoUserEntry(videoUserEntry);
			
			
		// send notification messge 
			
			//Send notification to admin (TEST Account)
			try {
				String subject = "New video  received from " + UserExtLocalServiceUtil.getUserExt(PortalUtil.getUserId(actionRequest)).getUserName() + " account";
				 String message = "You received '" + VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName()+"' vrbt from "
										+ UserExtLocalServiceUtil.getUserExt(PortalUtil.getUserId(actionRequest)).getUserName() + " account" ;
				
				new System_Notification().sendNotificationToUser(receiver.getUserId(), subject, message);
				_log.info("a notification sent");
			} catch (Exception e) {
				// TODO: handle exception
				_log.info(e);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, Exception.class.getName());
			actionResponse.sendRedirect(redirect);
			_log.warn(e);
			return;
		}
		SessionMessages.add(actionRequest, "send-to-friend-successfully");
		
	}

	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(MyVideoPortlet.class);
	
}
