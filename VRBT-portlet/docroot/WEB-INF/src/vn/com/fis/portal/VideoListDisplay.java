package vn.com.fis.portal;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.com.fis.portal.portlet.util.System_Notification;
import vn.com.fis.portal.portlet.util.model.RatingExt;
import vn.com.fis.portal.portlet.util.model.UserExt;
import vn.com.fis.portal.portlet.util.model.Video_UserExt;
import vn.com.fis.portal.portlet.util.model.Violation_VideoExt;
import vn.com.fis.portal.portlet.util.service.RatingExtLocalServiceUtil;
import vn.com.fis.portal.portlet.util.service.UserExtLocalServiceUtil;
import vn.com.fis.portal.portlet.util.service.VideoExtLocalServiceUtil;
import vn.com.fis.portal.portlet.util.service.Video_UserExtLocalServiceUtil;
import vn.com.fis.portal.portlet.util.service.ViolationExtLocalServiceUtil;
import vn.com.fis.portal.portlet.util.service.Violation_VideoExtLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoListDisplay
 */
public class VideoListDisplay extends MVCPortlet {
	public void buyVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, IOException {
		long videoId = ParamUtil.getLong(actionRequest, "videoId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		
		try {
			UserExt userExt = UserExtLocalServiceUtil.getUserExt(userId);
			
			Video_UserExt video_UserExt = Video_UserExtLocalServiceUtil.createVideo_UserExt(CounterLocalServiceUtil.increment());
			
			video_UserExt.setVideoId(videoId);
			video_UserExt.setUserId(userId);
			video_UserExt.setOriginCode(2);
			video_UserExt.setDate_(Calendar.getInstance().getTime());
			video_UserExt.setStartDate(Calendar.getInstance().getTime());
			video_UserExt.setServiceActive(0);
			video_UserExt.setStatus(1);
			
			Video_UserExtLocalServiceUtil.addVideo_UserExt(video_UserExt);
			
			//Send notification to admin (TEST Account)
			String subject = "New purchase transaction from " + UserExtLocalServiceUtil.getUserExt(userId).getUserName() + "account";
			String messageToAdmin = "User ID: "+ userId 
								+"; Username: "+ UserExtLocalServiceUtil.getUserExt(userId).getUserName() 
								+"; Mobile: "+ UserExtLocalServiceUtil.getUserExt(userId).getMobilePhone() 
								+"; VRBT ID: "+ videoId 
								+"; VRBT Name: "+ VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName()+".";
			String messageToUser = "You bought '" + VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName()+"' vrbt.";
			
			new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "error-message");
			
			actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirect"));
			return;
		}
	}
	
	public void videoReportToAdmin(ActionRequest actionRequest, ActionResponse actionResponse) {
		long videoId = ParamUtil.getLong(actionRequest, "videoId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		long violationId = ParamUtil.getLong(actionRequest, "violationId");
		
		try {
			Violation_VideoExt violation_VideoExt = Violation_VideoExtLocalServiceUtil.createViolation_VideoExt(CounterLocalServiceUtil.increment());
			
			violation_VideoExt.setVideoId(videoId);
			violation_VideoExt.setViolationId(violationId);
			violation_VideoExt.setUserId(userId);
			violation_VideoExt.setDescription(ViolationExtLocalServiceUtil.getViolationExt(violationId).getTitle());
			violation_VideoExt.setCreateDate(Calendar.getInstance().getTime());
			violation_VideoExt.setStatus(1);
			
			Violation_VideoExtLocalServiceUtil.addViolation_VideoExt(violation_VideoExt);
			
			//Send notification to admin (TEST Account)
			String subject = "A report about '" + VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName() + "' VRBT";
			String messageToAdmin = "User ID: "+ userId 
								+"; Username: "+ UserExtLocalServiceUtil.getUserExt(userId).getUserName() 
								+"; Reason: "+ ViolationExtLocalServiceUtil.getViolationExt(violationId).getTitle()
								+"; VRBT ID: "+ videoId 
								+"; VRBT Name: "+ VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName()+".";
			String messageToUser = "You reported to admin about '"+ VideoExtLocalServiceUtil.getVideoExt(videoId).getVideoName()
					+"' vrbt. Reason: " + ViolationExtLocalServiceUtil.getViolationExt(violationId).getTitle();
			
			new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
		} 
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error-report-message");
		}
	}
	
	public void viewVideoByCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionResponse.setRenderParameter("categoryId", ParamUtil.getString(actionRequest, "categoryId"));
	}
	
	public void videoRating(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException {
		long videoId = ParamUtil.getLong(actionRequest, "videoId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		long rate = ParamUtil.getLong(actionRequest, "rate");		
				
		List<RatingExt> list = RatingExtLocalServiceUtil.findByvideoId_userId_status(videoId, userId, 1);
				
		try {
			for (RatingExt ratingExt : list) {
				ratingExt.setStatus(0);
				RatingExtLocalServiceUtil.updateRatingExt(ratingExt);
			}
			
			RatingExt rating = RatingExtLocalServiceUtil.createRatingExt(CounterLocalServiceUtil.increment());
			rating.setVideoId(videoId);
			rating.setRatingCode(rate);
			rating.setUserId(userId);
			rating.setLastDate(Calendar.getInstance().getTime());
			rating.setStatus(1);
			
			RatingExtLocalServiceUtil.addRatingExt(rating);
		} 
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error-report-message");
		}
	}

}
