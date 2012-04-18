package vn.com.fis.portal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import oracle.net.aso.f;


import vn.com.fis.portal.model.CategoryVideoEntry;
import vn.com.fis.portal.model.FolderEntry;
import vn.com.fis.portal.model.VideoEntry;
import vn.com.fis.portal.model.VideoEntryModel;
import vn.com.fis.portal.model.VideoUserEntry;

import vn.com.fis.portal.service.CategoryVideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.FolderEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoEntryLocalServiceUtil;
import vn.com.fis.portal.service.VideoUserEntryLocalServiceUtil;
import vn.com.fis.portal.service.persistence.VideoEntryFinderImpl;
import vn.com.fis.portal.util.VideoAdminPortletUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.process.ProcessException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class VideoAdminPortlet
 */
public class VideoAdminPortlet extends MVCPortlet {
	/*private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(VideoAdminPortlet.class);

	
	
	public static final String VIDEO_DIR = "videos";
	public static final String SMALL_IMAGE_URL = "/html/themes/control_panel/images/file_system/large/video.png";
	public static final String LARGE_IMAGE_URL = "/html/themes/control_panel/images/file_system/large/video.png";
	public static final int  ORIGIN_CODE_UPLOAD = 1;
	

	
	public void deleteMyUploadVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		long videoId = ParamUtil.getLong(actionRequest, "videoId");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		long userId = PortalUtil.getUserId(actionRequest);
		
		if(userId<1) return ; 
		try {
			// check Constraint
			VideoEntryLocalServiceUtil.deleteVideoEntry(videoId);
			
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "delete-video-error");
			e.printStackTrace();
		}
		SessionMessages.add(actionRequest, "delete-video-success");
		actionResponse.sendRedirect(redirect);
	}
	
	
	public void deleteMyVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		long videoId = ParamUtil.getLong(actionRequest, "videoId");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		long userId = PortalUtil.getUserId(actionRequest);
		
		if(userId<1) return ; 
		try {
			// check Constraint
			VideoEntryLocalServiceUtil.deleteVideoEntry(videoId);
			
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "delete-video-error");
			e.printStackTrace();
		}
		SessionMessages.add(actionRequest, "delete-video-success");
		actionResponse.sendRedirect(redirect);
	}
	 
	public void deleteFolder(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		long currFolderId = ParamUtil.getLong(actionRequest, "currFolderId");
		long userId = PortalUtil.getUserId(actionRequest);
		if(userId<1) return ; 
		try {
			FolderEntryLocalServiceUtil.deleteFolderEntry(folderId);
			SessionMessages.add(actionRequest, "delete-folder-success");
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "delete-folder-error");
			_log.error(e,e);
		}
		actionResponse.setRenderParameter("currFolderId", String.valueOf(currFolderId));
		
	}
	
	
	public void renameFolder(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
	
		String folderName = ParamUtil.getString(actionRequest, "folderName");
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		long currFolderId = ParamUtil.getLong(actionRequest, "currFolderId");
		
		FolderEntry folderEntry = null;
		long userId = PortalUtil.getUserId(actionRequest);
		if(userId<1) return;
		try {
			folderEntry = FolderEntryLocalServiceUtil.fetchFolderEntry(folderId);
			folderEntry.setUserId(userId);
			folderEntry.setFolderName(folderName);
//			folderEntry.setFolderParentId(currFolderId);
			folderEntry.setFolderIdParent(currFolderId);
			folderEntry.setModifiedDate(Calendar.getInstance().getTime());
			FolderEntryLocalServiceUtil.updateFolderEntry(folderEntry);
			SessionMessages.add(actionRequest, "renme-folder-success");
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "rename-folder-error");
			_log.error(e,e);
		}
		actionResponse.setRenderParameter("currFolderId", String.valueOf(currFolderId));
		
		
	}
	
	
	public void addSubFolder(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String folderName = ParamUtil.getString(actionRequest, "folderName");
		long currFolderId = ParamUtil.getLong(actionRequest, "currFolderId");
		FolderEntry folderEntry = null;
		long userId = PortalUtil.getUserId(actionRequest);
		if(userId<1) return ; 
		try {
			folderEntry = FolderEntryLocalServiceUtil.createFolderEntry(CounterLocalServiceUtil.increment(FolderEntry.class.getName()));
			folderEntry.setUserId(userId);
			folderEntry.setFolderName(folderName);
			folderEntry.setFolderIdParent(currFolderId);
			folderEntry.setCreateDate(Calendar.getInstance().getTime());
			folderEntry.setModifiedDate(Calendar.getInstance().getTime());
			FolderEntryLocalServiceUtil.updateFolderEntry(folderEntry);
			SessionMessages.add(actionRequest, "add-subfolder-success");
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "add-subfolder-error");
			_log.error(e,e);
		}
		actionResponse.setRenderParameter("currFolderId", String.valueOf(currFolderId));
	}
	
	
	public void uploadVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		long userId = PortalUtil.getUserId(actionRequest);
		
		String realPath = PortalUtil.getPortalWebDir();
		File root = new File(realPath);
		realPath = root.getParent();
		byte[] bytes = null;
		PortletContext portletContext = actionRequest.getPortletSession().getPortletContext();
		long folderId = 0;
		try{ 
			
		    UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		    String sourceFileName =uploadRequest.getFileName("fileName");
		    String  videoName = ParamUtil.getString(uploadRequest, "videoName");
		    String  description = ParamUtil.getString(uploadRequest, "description");
		    long[]  categoryIds= ParamUtil.getLongValues(uploadRequest, "categoryId");
		    
		    folderId = ParamUtil.getLong(uploadRequest, "folderId");
			
			File file = uploadRequest.getFile("fileName");
			String extFile ="";
			try {
				bytes = FileUtil.getBytes(file);
				} catch (IOException e2) {			
					_log.warn(e2);
				}
				File newFile=null;
				if ((bytes != null) && (bytes.length > 0)) {
					int statusCode=-1;
				// check role and size
					try {
					 boolean role = VideoAdminPortletUtil.hasRole(userId,PortalUtil.getCompanyId(actionRequest), "Subscriber");
					 if(role){ // is a Subscriber then check file size 
						   statusCode = VideoAdminPortletUtil.checkPackageSize(userId,PortalUtil.getCompanyId(actionRequest), bytes.length);
						 switch (statusCode) {
						 	case -1: SessionErrors.add(actionRequest, "do-not-service-or-stopped-service");
						 	break;
						 	case 0: SessionErrors.add(actionRequest, "do-not-register-service-package");
						 	break;
						 	case 1: SessionErrors.add(actionRequest, "file-size-more-than-package-size");
						 	break;
						 	case 2: //ok 
						 	break;
						 default:
						 	SessionErrors.add(actionRequest, "unknown-case");
							break;
						}
						 _log.info("statusCode "+ statusCode);
						 _log.info("role "+ role);
						 _log.info("size "+ bytes.length);
						 // end switch -case
						 if(statusCode!=2){
							
							 actionResponse.setRenderParameter("currFolderId", String.valueOf(folderId));
							 return;
						 }
					 }
					} catch (Exception e) {
						// TODO: handle exception
						_log.info(e);
					}
				
				String path="";
				try {
				path= pathBuilder(actionRequest,actionResponse);
				File newDir = new File(realPath +"/"+ path);
				if(!newDir.exists()) newDir.mkdirs();
				_log.info(newDir.toString());
				long timeMillis= Calendar.getInstance().getTimeInMillis();
				
				//long ranDomNumber = Random.class.
				extFile = FileUtil.getExtension(file.getName());
				String newNameFile = String.valueOf(timeMillis)+"." +extFile;
				newFile = new File(newDir,newNameFile);//sourceFileName
				path =   path+ "/"+newNameFile.toString();
				_log.info(path);
				FileInputStream fileInputStream = new FileInputStream(file);
				FileOutputStream fileOutputStream = new FileOutputStream(newFile);			
				fileInputStream.read(bytes);				
				fileOutputStream.write(bytes, 0, bytes.length);					
				fileOutputStream.close();
				fileInputStream.close();
				
				// cont.... 
				// insert videoEntry
				VideoEntry videoEntry=null;
				VideoUserEntry videoUserEntry = null;
				try {
					long videoId = CounterLocalServiceUtil.increment(VideoEntry.class.getName());
					videoEntry = VideoEntryLocalServiceUtil.createVideoEntry(videoId);
					videoEntry.setVideoName(videoName);
					videoEntry.setVideoUrl(path);
					videoEntry.setDescription(description);
					videoEntry.setFolderId(folderId);
					videoEntry.setUploaderId(userId);
					videoEntry.setSmallImageUrl(SMALL_IMAGE_URL);
					videoEntry.setLargeImageUrl(LARGE_IMAGE_URL);
					
					
					VideoEntryLocalServiceUtil.updateVideoEntry(videoEntry);
					
					// insert to user_video
					videoUserEntry = VideoUserEntryLocalServiceUtil.createVideoUserEntry(CounterLocalServiceUtil.increment(VideoUserEntry.class.getName()));
					videoUserEntry.setUserId(userId);
					videoUserEntry.setVideoId(videoId);
					videoUserEntry.setDate_(Calendar.getInstance().getTime());
					videoUserEntry.setOriginCode(ORIGIN_CODE_UPLOAD);
					VideoUserEntryLocalServiceUtil.updateVideoUserEntry(videoUserEntry);
					
					
					// insert cate_video 
					insertCategoryVideo(categoryIds, videoId);
					
					SessionMessages.add(actionRequest, "upload-video-success");
				} catch (Exception e) {
					_log.warn(e);
					SessionErrors.add(actionRequest, "upload-video-error");
					//throw new Exception(e.getMessage());
				}
				
				// end insert 
					}catch (FileNotFoundException e) {
							_log.warn(e);
						}
						catch (IOException e1){
							_log.warn(e1);
						}
					}
		        
				} catch (Exception e) {
					_log.warn(e);
				}
		actionResponse.setRenderParameter("currFolderId", String.valueOf(folderId));
		//actionResponse.setRenderParameter("jspPage",v);
	}
	
	
	
	public void insertVideo(String path,ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		long companyId = PortalUtil.getCompanyId(actionRequest);
		long userId = PortalUtil.getUserId(actionRequest);
		Calendar toDay = Calendar.getInstance();
		VideoEntry videoEntry=null;
		
		String videoName = ParamUtil.getString(actionRequest, "videoName");
		String description = ParamUtil.getString(actionRequest, "description");
		long folderId = ParamUtil.getLong(actionRequest, "folderId");
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String sourceFileName =uploadRequest.getFileName("fileName");
		File file = uploadRequest.getFile("fileName");
	
		byte[]	bytes = FileUtil.getBytes(file);
		if ((bytes == null) || (bytes.length <=0)) {return ;}
		
				try {
					videoEntry = VideoEntryLocalServiceUtil.createVideoEntry(CounterLocalServiceUtil.increment());
					videoEntry.setVideoName(videoName);
					videoEntry.setVideoUrl(path);
					videoEntry.setDescription(description);
					videoEntry.setFolderId(folderId);
					videoEntry.setUploaderId(userId);
					videoEntry.setSmallImageUrl(SMALL_IMAGE_URL);
					videoEntry.setLargeImageUrl(LARGE_IMAGE_URL);
//					videoEntry.setSize(bytes.length);
					
					VideoEntryLocalServiceUtil.updateVideoEntry(videoEntry);
				} catch (Exception e) {
					e.printStackTrace();
					SessionErrors.add(actionRequest, "upload-video-error");
					throw new Exception(e.getMessage());
				}
		SessionMessages.add(actionRequest, "upload-video-success");
	}
	
	public static String pathBuilder(ActionRequest actionRequest,ActionResponse actionResponse){
			long companyId = PortalUtil.getCompanyId(actionRequest);
			long userId = PortalUtil.getUserId(actionRequest);
			// path building 
			Calendar toDay = Calendar.getInstance();
			int year = toDay.get(Calendar.YEAR);
			int month = toDay.get(Calendar.MONTH);
			//month = month+1;// 0-11
			int day= toDay.get(Calendar.DAY_OF_MONTH);
			int hour= toDay.get(Calendar.HOUR_OF_DAY);
			int minute= toDay.get(Calendar.MINUTE);
			
			//StringBuilder path = new StringBuilder(realPath);
			StringBuilder path = new StringBuilder();
			path.append(VIDEO_DIR);
			path.append("/"+companyId);
			path.append("/"+userId);
			path.append("/"+year);
			path.append("/"+month);
			path.append("/"+day);
			path.append("/"+hour);
			path.append("/"+minute);
			
		return path.toString();
	}
	
	public static void insertCategoryVideo(long[] categoryId , long videoId) throws Exception {
		if(categoryId==null || categoryId.length==0){ return ;}
		CategoryVideoEntry cateVideoEntry = null;
		for (int i = 0; i < categoryId.length; i++) {
			try {
				cateVideoEntry = CategoryVideoEntryLocalServiceUtil.createCategoryVideoEntry(CounterLocalServiceUtil.increment(CategoryVideoEntry.class.getName()));
				cateVideoEntry.setVideoId(videoId);
				cateVideoEntry.setCategoryId(categoryId[i]);
				CategoryVideoEntryLocalServiceUtil.updateCategoryVideoEntry(cateVideoEntry);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void removeCategoryVideoByVideoId(long videoId) throws Exception {
		if(videoId==0){ return ;}
		
		CategoryVideoEntry cateVideoEntry = null;
		List<CategoryVideoEntry> cateVideoEntries = new ArrayList<CategoryVideoEntry>();
		
		
			try {
				cateVideoEntries = CategoryVideoEntryLocalServiceUtil.findByVideoId(videoId);
				
				for (int i = 0; i < cateVideoEntries.size(); i++) {
					try {
//						CategoryVideoEntryLocalServiceUtil.deleteCateVideoEntry(cateVideoEntries.get(i).getVideoCategoryId());
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				CategoryVideoEntryLocalServiceUtil.updateCategoryVideoEntry(cateVideoEntry);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
	
	public void editVideo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		// TODO Auto-generated method stub
		String videoName = ParamUtil.getString(actionRequest, "videoName",null);
		String description = ParamUtil.getString(actionRequest, "description",null);
		String redirectCurr = ParamUtil.getString(actionRequest, "redirectCurr");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long videoId = ParamUtil.getLong(actionRequest, "videoId",0);
		long[] categoryIds = ParamUtil.getLongValues(actionRequest, "categoryIds");
		
		long userId = PortalUtil.getUserId(actionRequest);
		if(videoId<1|| userId<1) {return;}
		VideoEntry videoEntry = null;
		try {
			// update 
			videoEntry = VideoEntryLocalServiceUtil.getVideoEntry(videoId);
			videoEntry.setUploaderId(userId);
			videoEntry.setVideoName(videoName);
			videoEntry.setDescription(description);
			VideoEntryLocalServiceUtil.updateVideoEntry(videoEntry);
			
		// remove all catevideo by videoId
			removeCategoryVideoByVideoId(videoId);
		// reinsert catevideo by cateIds  and videoId
			insertCategoryVideo(categoryIds, videoId);
			// update category
			SessionMessages.add(actionRequest, "edit-video-successfully");
			actionResponse.sendRedirect(redirect);
		} catch (Exception e) {
			// TODO: handle exception
			SessionErrors.add(actionRequest, "edit-video-error");
			actionResponse.sendRedirect(redirectCurr);
			return;
		}
	}*/
}
