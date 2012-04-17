package vn.com.fis.portal.service.persistence;

import java.util.ArrayList;
import java.util.List;

import vn.com.fis.portal.model.NotificationEntry;
import vn.com.fis.portal.model.impl.NotificationEntryImpl;
import vn.com.fis.portal.model.impl.VideoUserTransactionEntryImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;



public class NotificationEntryFinderImpl extends BasePersistenceImpl<NotificationEntry> implements NotificationEntryFinder{

	public final String SQL_getNotificationEntryByUserIdFrom = NotificationEntryFinderImpl.class.getName()	+ 

".getNotificationEntryByUserIdFrom";
	public final String SQL_getNotificationEntryByUserIdCountFrom = NotificationEntryFinderImpl.class.getName()+ 

".getNotificationEntryByUserIdCountFrom";
	
	public final String SQL_getNotificationEntryByUserIdTo = NotificationEntryFinderImpl.class.getName()	+ 

".getNotificationEntryByUserIdTo";
	public final String SQL_getNotificationEntryByUserIdCountTo = NotificationEntryFinderImpl.class.getName()+ 

".getNotificationEntryByUserIdCountTo";

	public List<NotificationEntry> getNotificationEntryByUserId(long usreId,String typeNotification,int start,int end) 

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
			if(typeNotification.equals("NOTIFICATIONUSERIDFROM"))
			{
				sql = CustomSQLUtil.get(SQL_getNotificationEntryByUserIdFrom);
			}
			else
			{
				sql = CustomSQLUtil.get(SQL_getNotificationEntryByUserIdTo);
			}
		

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("NotificationEntry",
					NotificationEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(usreId);
			list = QueryUtil.list(query, getDialect(), start, end);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return list;
	}
	
	public int getNotificationEntryByUserIdCount(long usreId,String typeNotification) throws SystemException {
		
		Session session = null;
		int  count = 0;
		try {
			session = openSession();
			String sql="";
			if(typeNotification.equals("NOTIFICATIONUSERIDFROM"))
			{
				sql = CustomSQLUtil.get(SQL_getNotificationEntryByUserIdCountFrom);
			}
			else
			{
				sql = CustomSQLUtil.get(SQL_getNotificationEntryByUserIdCountTo);
			}
			SQLQuery query = session.createSQLQuery(sql);
			// query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);

			qPos.add(usreId);
			
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

