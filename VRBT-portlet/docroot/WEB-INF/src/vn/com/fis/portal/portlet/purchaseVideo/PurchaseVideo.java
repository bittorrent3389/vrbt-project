package vn.com.fis.portal.portlet.purchaseVideo;

import java.io.IOException;
import java.util.Calendar;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import vn.com.fis.portal.model.RatingEntry;
import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.model.VideoUserEntry;
import vn.com.fis.portal.model.ViolationVideoEntry;
import vn.com.fis.portal.util.System_Notification;
import vn.com.fis.portal.service.RatingEntryLocalServiceUtil;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil;
import vn.com.fis.portal.service.ViolationEntryLocalServiceUtil;
import vn.com.fis.portal.service.ViolationVideoEntryLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PurchaseVideo
 */
public class PurchaseVideo extends MVCPortlet {
	public void buyVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, IOException {
		long videoId = ParamUtil.getLong(actionRequest, "videoId");
		long userId = ParamUtil.getLong(actionRequest, "userId");
		
		
		try {
			Calendar c = Calendar.getInstance();
			UserEntry userExt = UserEntryLocalServiceUtil.getUserEntry(userId);
			
			VideoUserEntry videoUserEntry = VideoUserEntryLocalServiceUtil.createVideoUserEntry(CounterLocalServiceUtil.increment());
			
			videoUserEntry.setVideoId(videoId);
			videoUserEntry.setUserId(userId);
			videoUserEntry.setOriginCode(2);
			videoUserEntry.setDate_(c.getTime());
			videoUserEntry.setStartDate(c.getTime());
			
			c.add(Calendar.DAY_OF_YEAR, 90);
			videoUserEntry.setEndDate(c.getTime());
			
			videoUserEntry.setStatus(1);
			
			VideoUserEntryLocalServiceUtil.addVideoUserEntry(videoUserEntry);
			
			//Send notification to admin (TEST Account)
//			String subject = "New purchase transaction from " + UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() + "account";
//			String messageToAdmin = "User ID: "+ userId 
//								+"; Username: "+ UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() 
//								+"; Mobile: "+ UserEntryLocalServiceUtil.getUserEntry(userId).getMobileNumber() 
//								+"; VRBT ID: "+ videoId 
//								+"; VRBT Name: "+ VideoEntryLocalServiceUtil.getVideoEntry(videoId).getVideoName()+".";
//			String messageToUser = "You bought '" + VideoEntryLocalServiceUtil.getVideoEntry(videoId).getVideoName()+"' vrbt.";
//			
//			new System_Notification().sendNotification(userId, subject, messageToAdmin, messageToUser);
			
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
			ViolationVideoEntry violation_Video = ViolationVideoEntryLocalServiceUtil.createViolationVideoEntry(CounterLocalServiceUtil.increment());
			
			violation_Video.setVideoId(videoId);
			violation_Video.setViolationId(violationId);
			violation_Video.setUserId(userId);
			violation_Video.setDescription(ViolationEntryLocalServiceUtil.getViolationEntry(violationId).getViolationTitle());
			violation_Video.setDate_(Calendar.getInstance().getTime());
			
			ViolationVideoEntryLocalServiceUtil.addViolationVideoEntry(violation_Video);
			
			//Send notification to admin (TEST Account)
			String subject = "A report about '" + VideoEntryLocalServiceUtil.getVideoEntry(videoId).getVideoName() + "' VRBT";
			String messageToAdmin = "User ID: "+ userId 
								+"; Username: "+ UserEntryLocalServiceUtil.getUserEntry(userId).getUserName() 
								+"; Reason: "+ ViolationEntryLocalServiceUtil.getViolationEntry(violationId).getViolationTitle()
								+"; VRBT ID: "+ videoId 
								+"; VRBT Name: "+ VideoEntryLocalServiceUtil.getVideoEntry(videoId).getVideoName()+".";
			String messageToUser = "You reported to admin about '"+ VideoEntryLocalServiceUtil.getVideoEntry(videoId).getVideoName()
					+"' vrbt. Reason: " + ViolationEntryLocalServiceUtil.getViolationEntry(violationId).getViolationTitle();
			
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
		int rate = ParamUtil.getInteger(actionRequest, "rate");		
				
		RatingEntry userRating = null;
		
			if(RatingEntryLocalServiceUtil.countByVideoId_UserId(videoId, userId) == 1)
				userRating = RatingEntryLocalServiceUtil.findByVideoId_UserId(videoId, userId).get(0);
				
		try {
			if (userRating == null) {
				RatingEntry rating = RatingEntryLocalServiceUtil.createRatingEntry(CounterLocalServiceUtil.increment());
				rating.setVideoId(videoId);
				rating.setCode(rate);
				rating.setUserId(userId);
				rating.setDate_(Calendar.getInstance().getTime());
				
				RatingEntryLocalServiceUtil.addRatingEntry(rating);
			} else {
				userRating.setVideoId(videoId);
				userRating.setCode(rate);
				userRating.setUserId(userId);
				userRating.setDate_(Calendar.getInstance().getTime());
				
				RatingEntryLocalServiceUtil.updateRatingEntry(userRating);
			}
		} 
		catch (Exception e) {
			SessionErrors.add(actionRequest, "error-report-message");
		}
	}
}
