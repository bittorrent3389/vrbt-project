package vn.com.fis.portal.service.persistence;

import java.util.List;

import javax.transaction.Transaction;

import vn.com.fis.portal.model.VideoUserTransactionEntry;
import vn.com.fis.portal.model.impl.VideoUserTransactionEntryImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class VideoUserTransactionEntryFinderImpl extends
BasePersistenceImpl<VideoUserTransactionEntry> implements VideoUserTransactionEntryFinder {
	
	
	public final String SQL_getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode";
	public final String SQL_getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date";
	public final String SQL_getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode";
	public final String SQL_getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date";
	public final String SQL_getCount_VideoUserTransaction_By_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_VideoUserTransaction_By_TransactionCode";
	public final String SQL_getVideoUserTransaction_By_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getVideoUserTransaction_By_TransactionCode";
	public final String SQL_getCount_VideoUserTransaction_By_transactionCode_And_Date = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_VideoUserTransaction_By_transactionCode_And_Date";
	public final String SQL_getCount_VideoUserTransaction_By_UserId_And_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_VideoUserTransaction_By_UserId_And_TransactionCode";
	public final String SQL_getVideoUserTransaction_By_UserId_And_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getVideoUserTransaction_By_UserId_And_TransactionCode";
	public final String SQL_getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date";
	public final String SQL_getVideoUserTransaction_By_UploaderId_And_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getVideoUserTransaction_By_UploaderId_And_TransactionCode";
	public final String SQL_getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date";
	public final String SQL_getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode = VideoUserTransactionEntryFinderImpl.class
			.getName()
			+ ".getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode";
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode(long transactionCode)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_Destinct_Tbl_Video_User_Transaction_By_TransactionCode);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(transactionCode);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public int getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date(long transactionCode,String startDate,String endDate)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_Destinct_VideoUserTransaction_By_transactionCode_And_Date);
//			System.out.println(sql);
			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(transactionCode);
			qPos.add(startDate);
			qPos.add(endDate);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public int getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode(long uploadId,long transactionCode)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_Destinct_Tbl_Video_User_Transaction_By_UploaderId_And_TransactionCode);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(uploadId);
			qPos.add(transactionCode);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public int getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(long uploadId,long transactionCode,String startDate,String endDate)

			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_Destinct_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(uploadId);
			qPos.add(transactionCode);
			qPos.add(startDate);
			qPos.add(endDate);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}

	public int getCount_VideoUserTransaction_By_TransactionCode(long transactionCode)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_VideoUserTransaction_By_TransactionCode);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(transactionCode);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public List<VideoUserTransactionEntry> getVideoUserTransaction_By_TransactionCode(long transactionCode,int start,int end)
			throws SystemException {

		List list = null;
		// / This stuff is basic set up
		Session session = null;

		try {
			session = openSession();
			// Here ends the basic set up;x`
			String sql = "";
			// now we build the query. Note that we use the name of the tables
			// from the database!
			sql = CustomSQLUtil
					.get(SQL_getVideoUserTransaction_By_TransactionCode);
		

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("VideoUserTransactionEntry",
					VideoUserTransactionEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(transactionCode);
			list = QueryUtil.list(query, getDialect(), start, end);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return list;
	}
	
	public int getCount_VideoUserTransaction_By_transactionCode_And_Date(long transactionCode,String startDate,String endDate)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_VideoUserTransaction_By_transactionCode_And_Date);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(transactionCode);
			qPos.add(startDate);
			qPos.add(endDate);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public int getCount_VideoUserTransaction_By_UserId_And_TransactionCode(long uploadId,long transactionCode)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_VideoUserTransaction_By_UserId_And_TransactionCode);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(uploadId);
			qPos.add(transactionCode);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public List<VideoUserTransactionEntry> getVideoUserTransaction_By_UserId_And_TransactionCode(long uploadId,long transactionCode,int start,int end)
			throws SystemException {

		List list = null;
		// / This stuff is basic set up
		Session session = null;

		try {
			session = openSession();
			// Here ends the basic set up;x`
			String sql = "";
			// now we build the query. Note that we use the name of the tables
			// from the database!
			sql = CustomSQLUtil
					.get(SQL_getVideoUserTransaction_By_UserId_And_TransactionCode);
		

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("VideoUserTransactionEntry",
					VideoUserTransactionEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(uploadId);
			qPos.add(transactionCode);
			
			list = QueryUtil.list(query, getDialect(), start, end);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return list;
	}

	public int getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date(long uploadId,long transactionCode,String startDate,String endDate)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_VideoUserTransaction_By_UserId_And_transactionCode_And_Date);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(uploadId);
			qPos.add(transactionCode);
			qPos.add(startDate);
			qPos.add(endDate);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public List<VideoUserTransactionEntry> getVideoUserTransaction_By_UploaderId_And_TransactionCode(long uploadId,long transactionCode,int start,int end)
			throws SystemException {

		List list = null;
		// / This stuff is basic set up
		Session session = null;

		try {
			session = openSession();
			// Here ends the basic set up;x`
			String sql = "";
			// now we build the query. Note that we use the name of the tables
			// from the database!
			sql = CustomSQLUtil
					.get(SQL_getVideoUserTransaction_By_UploaderId_And_TransactionCode);
		

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("VideoUserTransactionEntry",
					VideoUserTransactionEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			
			qPos.add(uploadId);
			qPos.add(transactionCode);
			
			list = QueryUtil.list(query, getDialect(), start, end);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return list;
	}
	
	public int getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date(long uploadId,long transactionCode,String startDate,String endDate)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_VideoUserTransaction_By_UploaderId_And_transactionCode_And_Date);

			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(uploadId);
			qPos.add(transactionCode);
			qPos.add(startDate);
			qPos.add(endDate);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public int getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode(long uploadId,long transactionCode)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			String sql = CustomSQLUtil
					.get(SQL_getCount_VideoUserTransaction_By_UploaderId_And_TransactionCode);
//			System.out.println("sql:"+sql);
			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(uploadId);
			qPos.add(transactionCode);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	
	public List<VideoUserTransactionEntry> seachVideoUserTransactionEntryByCondition(
			String userName, String videoName, String transactionCode,
			int start, int end) {
		
		List list = null;
		// / This stuff is basic set up
		Session session = null;

		try {
			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String sql = "SELECT  tbl_video_user_transaction.*    from tbl_user , tbl_video ,tbl_video_user_transaction  where tbl_user.userid=tbl_video_user_transaction.userid and tbl_video.videoid=tbl_video_user_transaction.videoid ";
			// ---------Condition-------------
			String condition = "";
			if (!userName.equals("") && !userName.equals("null")) {
				condition = " and tbl_user.username = '" + userName + "'";

			}
			if (!videoName.equals("") && !videoName.equals("null")) {
				condition += " and upper(tbl_video.videoname) like  '%" + videoName.toUpperCase()
						+ "%' ";
			}
			if (!transactionCode.equals("") && !transactionCode.equals("null")
					&& !transactionCode.equals("-1")) {
				condition += " and tbl_video_user_transaction.transactioncode = '"
						+ transactionCode + "' ";
			}

			SQLQuery query = session.createSQLQuery(sql + condition);
			query.addEntity("VideoUserTransactionEntry",
					VideoUserTransactionEntryImpl.class);

			list = QueryUtil.list(query, getDialect(), start, end);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return list;
	}
	public int countSeachVideoUserTransactionEntryByCondition(String userName, String videoName, String transactionCode)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			// Here ends the basic set up;

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String sql = "SELECT  count(*)    from tbl_user , tbl_video ,tbl_video_user_transaction  where tbl_user.userid=tbl_video_user_transaction.userid and tbl_video.videoid=tbl_video_user_transaction.videoid ";
			// ---------Condition-------------
			String condition = "";
			if (!userName.equals("") && !userName.equals("null")) {
				condition = " and tbl_user.username = '" + userName + "'";

			}
			if (!videoName.equals("") && !videoName.equals("null")) {
				condition += " and upper(tbl_video.videoname) like  '%" + videoName.toUpperCase()
						+ "%' ";
			}
			if (!transactionCode.equals("") && !transactionCode.equals("null")
					&& !transactionCode.equals("-1")) {
				condition += " and tbl_video_user_transaction.transactioncode = '"
						+ transactionCode + "' ";
			}

			SQLQuery query = session.createSQLQuery(sql + condition);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
	
	public List<VideoUserTransactionEntry> seachThirdPartyVideoUserTransactionEntryByCondition(
			int trasactionCode, long userId, String videoName, int start,
			int end) {
		List list = null;
		// / This stuff is basic set up
		Session session = null;

		try {
			session = openSession();
			// Here ends the basic set up;
			// ---------Condition-------------
			String condition = "";
			if (userId > 0) {
				condition = " tbl_video.uploaderid = " + userId + "";

			}
			if (!videoName.equals("") && !videoName.equals("null")) {
				if (condition.equals("") || condition.equals(" ")
						|| condition.equals("null")) {
					condition += " upper(tbl_video.videoname) like  '%"
							+ videoName.toUpperCase() + "%' ";
				} else {
					condition += "and upper(tbl_video.videoname) like  '%" + videoName.toUpperCase()
							+ "%' ";
				}
			}
			String strtransaction="";
			if(trasactionCode>0)
			{
				strtransaction = " tvut.transactioncode= "+ trasactionCode+" and ";
			}
			
			String sql = "select tvut.* from tbl_video_user_transaction tvut where "+strtransaction+" tvut.videoid in(select tbl_video.videoid from tbl_video where "
					+ condition + ")";

			
//			System.out.println("sql: "+sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("VideoUserTransactionEntry",
					VideoUserTransactionEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			list = QueryUtil.list(query, getDialect(), start, end);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return list;
	}
	public int countSeachThirdPartyVideoUserTransactionEntryByCondition(int trasactionCode, long userId, String videoName)
			throws SystemException {

		Session session = null;
		int count = 0;
		try {
			session = openSession();
			// Here ends the basic set up;
			// ---------Condition-------------
			String condition = "";
			if (userId > 0) {
				condition = " tbl_video.uploaderid = " + userId + "";

			}
			if (!videoName.equals("") && !videoName.equals("null")) {
				if (condition.equals("") || condition.equals(" ")
						|| condition.equals("null")) {
					condition += " upper(tbl_video.videoname) like  '%"
							+ videoName.toUpperCase() + "%' ";
				} else {
					condition += "and upper(tbl_video.videoname) like  '%" + videoName.toUpperCase()
							+ "%' ";
				}
			}
			String strtransaction="";
			if(trasactionCode>0)
			{
				strtransaction = " tvut.transactioncode= "+ trasactionCode+" and ";
			}
			
			String sql = "select count(*) from tbl_video_user_transaction tvut where "+strtransaction+" tvut.videoid in(select tbl_video.videoid from tbl_video where "
					+ condition + ")";

			
//			System.out.println("sql: "+sql);
			SQLQuery query = session.createSQLQuery(sql);

			Object obj = query.uniqueResult();
			count = Integer.valueOf(obj.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}

		return count;
	}
}
