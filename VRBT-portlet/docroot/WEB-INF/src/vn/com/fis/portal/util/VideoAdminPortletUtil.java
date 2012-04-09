package vn.com.fis.portal.util;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
 

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import vn.com.fis.portal.service.persistence.FolderEntryPersistenceImpl;

public class VideoAdminPortletUtil {
	/*
	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(VideoAdminPortletUtil.class);	
	*//**
	 * @author loind
	 * @param userId 
	 * @param fileSize
	 * @return 
	 * 	
	 *  0 : don't  regiter package 
	 *  1 : fileSize > size of package
	 *  2 ok  
	 * *//*
	public static  int checkPackageSize(long userId, long companyId,long fileSize) throws Exception {
		int statusCode =-1;
		UserEntry userEntry=null;
		
		try {
			userEntry = UserEntryLocalServiceUtil.getUserEntry(userId);
		} catch (Exception e) {
			// TODO: handle exception
			statusCode =-1;
			_log.info(e);
		}
		if(userEntry!=null){
			// check service 
			if(userEntry.getServiceId() <1  ){//|| userEntry.getServiceStatus()==0
				statusCode=-1;
			}else{
				
				if(  userEntry.getServicePackageId()<1){//userEntry.getServicePackageStatus()==0 ||
					statusCode=0;
				}else{
					// compare size 
					try {
						long servicePackageId = userEntry.getServicePackageId();
						Service_PackageExt packageEntry = Service_PackageExtLocalServiceUtil.getService_PackageExt(servicePackageId);
						if(packageEntry!=null){
							if(fileSize < packageEntry.getMaxSize()) statusCode =2;
							else statusCode =1;
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						statusCode=0;
						_log.info(e);
					}
				//}
			}
		}
		return statusCode; 
	}
	
	
	public static  boolean  hasRole(long userId, long companyId,String roleName) throws Exception {
		try {
			long roleId = RoleLocalServiceUtil.getRole(companyId, roleName).getRoleId();
			if(UserLocalServiceUtil.hasRoleUser(roleId, userId)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			_log.info(e);
			return false;
		}
	}
	*/
	
}
