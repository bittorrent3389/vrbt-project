package vn.com.fis.portal.service.persistence;

import java.util.ArrayList;
import java.util.List;

import vn.com.fis.portal.model.VideoEntry;
import vn.com.fis.portal.model.impl.VideoEntryImpl;
import vn.com.fis.portal.model.impl.VideoEntryModelImpl;

 
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery; 


import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;




public class VideoEntryFinderImpl extends BasePersistenceImpl<VideoEntry> implements VideoEntryFinder{

	private static com.liferay.portal.kernel.log.Log _log = LogFactoryUtil.getLog(VideoEntryFinderImpl.class);
	final  String  SEARCH_VIDEO_BY_CATEGORY = VideoEntryFinderImpl.class.getName() +".searchVideoByCategory";
	final  String  SEARCH_VIDEO_BY_CATEGORY_COUNT = VideoEntryFinderImpl.class.getName() +".searchVideoByCategoryCount";
	final  String  SEARCH_VIDEO_BY_CATEGORY_USER = VideoEntryFinderImpl.class.getName() +".searchVideoByCategoryId_UserId";
	final  String  SEARCH_VIDEO_BY_CATEGORY_USER_COUNT = VideoEntryFinderImpl.class.getName() +".searchVideoByCategoryId_UserIdCount";
	
	final  String  SEARCH_VIDEO_BY_CATEGORY_OTHER_USER = VideoEntryFinderImpl.class.getName() +".searchVideoByCategoryId_OtherUserId";
	final  String  SEARCH_VIDEO_BY_CATEGORY_OTHER_USER_COUNT = VideoEntryFinderImpl.class.getName() +".searchVideoByCategoryId_OtherUserIdCount";
	
	
	
	final  String  SEARCH_VIDEO_BY_USER = VideoEntryFinderImpl.class.getName() +".searchVideoByUser";
	final  String  SEARCH_VIDEO_BY_USER_COUNT = VideoEntryFinderImpl.class.getName() +".searchVideoByUserCount";
	
	final  String  SEARCH_VIDEO_BY_VIDEO_NAME__FOLDER_USER = VideoEntryFinderImpl.class.getName() +".searchVideoByVideoName_Folder_User";
	final  String  SEARCH_VIDEO_BY_VIDEO_NAME__FOLDER_USER_COUNT = VideoEntryFinderImpl.class.getName() +".searchVideoByVideoName_Folder_User_Count";
	
	
	final  String  SEARCH_VIDEO_BY_VIDEO_NAME__ORIGINCODE_SERVICEACTIVE = VideoEntryFinderImpl.class.getName() +".searchVideoByVideoName_OriginCode_ServiceActive";
	final  String  SEARCH_VIDEO_BY_VIDEO_NAME__ORIGINCODE_SERVICEACTIVE_COUNT = VideoEntryFinderImpl.class.getName() +".searchVideoByVideoName_OriginCode_ServiceActive_Count";
	
	public List<VideoEntry> searchVideoByCategory(long categoryId ,int start , int end)throws SystemException{
		List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
		Session session = null;
		String sql="";
		try {
			session = openSession();
			
			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_CATEGORY);
			//sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(VideoEntryModelImpl.TABLE_NAME, VideoEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(categoryId);
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			videoEntries = (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return videoEntries;
	}
	
	
	public int searchVideoByCategoryCount(long categoryId )throws SystemException{
		int count=0;
		Session session = null;
		String sql="";
		try {
			session = openSession();

			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_CATEGORY_COUNT);
			//sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery query = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(categoryId);
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			Object  obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return count;
	}
	
	
	public List<VideoEntry> searchVideoByCategory_User(long categoryId, long userId ,int start , int end,boolean andOperator)throws SystemException{
		List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
		Session session = null;
		String sql="";
		try {
			session = openSession();
			
			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_CATEGORY_USER);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(VideoEntryModelImpl.TABLE_NAME, VideoEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add("%"+categoryId+"%");
			qPos.add(categoryId);
			qPos.add("%"+userId+"%");
			qPos.add(userId);
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			videoEntries = (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return videoEntries;
	}
	public int searchVideoByCategory_User_Count(long categoryId,long userId,boolean andOperator )throws SystemException{
		int count=0;
		Session session = null;
		String sql="";
		try {
			session = openSession();

			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_CATEGORY_USER_COUNT);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery query = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add("%"+categoryId+"%");
			qPos.add(categoryId);
			qPos.add("%"+userId+"%");
			qPos.add(userId);
			
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			Object  obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return count;
	}
	// by other user 
	
	public List<VideoEntry> searchVideoByCategory_OtherUser(long categoryId, long userId ,int start , int end,boolean andOperator)throws SystemException{
		List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
		Session session = null;
		String sql="";
		List params = new ArrayList();
		StringBuilder sqlB = null;
		try {
			session = openSession();
			
			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_CATEGORY_OTHER_USER);
			//sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sqlB = new StringBuilder(sql);
			if(categoryId>0) {
				sqlB.append(" AND  VRBT_CATEGORY.CATEGORYID = ? ");
				params.add(categoryId);
			}
			
			SQLQuery query = session.createSQLQuery(sqlB.toString());
			query.addEntity(VideoEntryModelImpl.TABLE_NAME, VideoEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(userId);
			for (int i = 0; i < params.size(); i++) {
				qPos.add(params.get(i));
				
			}
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			videoEntries = (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		//System.out.println("sqlB"+sqlB);
		return videoEntries;
	}
	public int searchVideoByCategory_OtherUser_Count(long categoryId,long userId,boolean andOperator )throws SystemException{
		int count=0;
		Session session = null;
		String sql="";
		List params = new ArrayList();
		StringBuilder sqlB = null;
		try {
			session = openSession();

			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_CATEGORY_OTHER_USER_COUNT);
			//System.out.println("sql"+sql);
			sqlB = new StringBuilder(sql);
			if(categoryId >0) {
				sqlB.append(" AND VRBT_CATEGORY.CATEGORYID = ? ");
				params.add(categoryId);
			}
			sqlB.append(" )");
			
			//sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery query = session.createSQLQuery(sqlB.toString());
			QueryPos qPos = QueryPos.getInstance(query);
			

			qPos.add(userId);
			for (int i = 0; i < params.size(); i++) {
				qPos.add(params.get(i));
			}			
			
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			Object  obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return count;
	}
	// en by other vieo 
	
	public List<VideoEntry> searchVideoByUser(long userId ,int start , int end,boolean andOperator)throws SystemException{
		List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
		Session session = null;
		String sql="";
		try {
			session = openSession();
			
			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_USER);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(VideoEntryModelImpl.TABLE_NAME, VideoEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(userId);
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			videoEntries = (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return videoEntries;
	}
	
	public int searchVideoByUserCount(long userId,boolean andOperator )throws SystemException{
		int count=0;
		Session session = null;
		String sql="";
		try {
			session = openSession();

			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_USER_COUNT);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery query = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(userId);
			
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			Object  obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return count;
	}
	
	
	public List<VideoEntry> searchVideoByVideoName_Folder_User(String videoName, long folderId,long userId ,int start , int end)throws SystemException{
		List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
		Session session = null;
		String sql="";
		try {
			session = openSession();
			
			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_VIDEO_NAME__FOLDER_USER);
			sql = CustomSQLUtil.replaceAndOperator(sql, true);
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(VideoEntryModelImpl.TABLE_NAME, VideoEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(userId);
			qPos.add(folderId);
			qPos.add("%" + videoName +"%");
			qPos.add(videoName);
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			videoEntries = (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return videoEntries;
	}
	public int searchVideoByVideoName_Folder_User_Count(String videoName, long folderId,long userId  )throws SystemException{
		int count=0;
		Session session = null;
		String sql="";
		try {
			session = openSession();

			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_VIDEO_NAME__FOLDER_USER_COUNT);
			sql = CustomSQLUtil.replaceAndOperator(sql, true);
			SQLQuery query = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(userId);
			qPos.add(folderId);
			qPos.add("%" + videoName +"%");
			qPos.add(videoName);
			
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			Object  obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return count;
	}
	
	
	public List<VideoEntry> searchVideoByVideoName_OriginCode_ServiceActive(String videoName,int originCode, int serviceActive,long userId ,int start , int end)throws SystemException{
		List<VideoEntry> videoEntries = new ArrayList<VideoEntry>();
		Session session = null;
		List params = new ArrayList();
		String sql="";
		try {
			session = openSession();
			// add params
						params.add("%" + videoName +"%");
						params.add(videoName);
						params.add(userId);
						
						
			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_VIDEO_NAME__ORIGINCODE_SERVICEACTIVE);
			StringBuilder sqlBuilder = new StringBuilder(sql);
			if(originCode>0){
				sqlBuilder.append("[$AND_OR_CONNECTOR$] ( VRBT_VIDEO_USER.ORIGINCODE = ? )");
				params.add(originCode);
			}
			if(serviceActive>=0){
				sqlBuilder.append("[$AND_OR_CONNECTOR$] ( VRBT_VIDEO_USER.SERVICEACTIVE = ? )");
				params.add(serviceActive);	
			}
					
			sql = CustomSQLUtil.replaceAndOperator(sqlBuilder.toString(), true);
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(VideoEntryModelImpl.TABLE_NAME, VideoEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			for (int i = 0; i < params.size(); i++) {
				qPos.add(params.get(i));
			}
			
			/*qPos.add(userId);
			qPos.add(originCode);
			qPos.add(serviceActive);
			
			qPos.add("%" + videoName +"%");
			qPos.add(videoName);*/
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			videoEntries = (List<VideoEntry>) QueryUtil.list(query, getDialect(), start, end);
			
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return videoEntries;
	}
	
	public int searchVideoByVideoName_OriginCode_ServiceActive_Count(String videoName,int originCode, int serviceActive,long userId)throws SystemException{
		int count=0;
		Session session = null;
		String sql="";
		List params = new ArrayList();
		
		try {
			session = openSession();

			sql = CustomSQLUtil.get(SEARCH_VIDEO_BY_VIDEO_NAME__ORIGINCODE_SERVICEACTIVE_COUNT);
			
			// add params
			params.add("%" + videoName +"%");
			params.add(videoName);
			params.add(userId);
			
			
			StringBuilder sqlBuilder = new StringBuilder(sql);
			if(originCode>0){
				sqlBuilder.append("[$AND_OR_CONNECTOR$] ( VRBT_VIDEO_USER.ORIGINCODE = ? )");
				params.add(originCode);
			}
			if(serviceActive>=0){
				sqlBuilder.append("[$AND_OR_CONNECTOR$] ( VRBT_VIDEO_USER.SERVICEACTIVE = ? )");
				params.add(serviceActive);	
			}
					
			sql = CustomSQLUtil.replaceAndOperator(sqlBuilder.toString(), true);
			
			SQLQuery query = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(query);
			for (int i = 0; i < params.size(); i++) {
				qPos.add(params.get(i));
			}
//			
//			qPos.add(userId);
//			qPos.add(originCode);
//			qPos.add(serviceActive);
//			
//			qPos.add("%" + videoName +"%");
//			qPos.add(videoName);
			
			//query.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			Object  obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		}catch (Exception e) {
			// TODO: handle exception
			throw processException(e);
		}finally{
			closeSession(session);
		}
		return count;
	}
}
