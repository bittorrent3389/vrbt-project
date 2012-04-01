package vn.com.fis.portal.service.persistence;

import java.util.ArrayList;
import java.util.List;

import vn.com.fis.portal.model.ServicePackageEntry;
import vn.com.fis.portal.model.impl.ServicePackageEntryImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ServicePackageEntryFinderImpl extends BasePersistenceImpl implements ServicePackageEntryFinder {
	public final String SEARCH_SQL_ID = ServicePackageEntryFinderImpl.class.getName()+".search";
	
	public final String SEARCH_COUNT_SQL_ID = ServicePackageEntryFinderImpl.class.getName()+".searchCount";
	
	public List<ServicePackageEntry> search(String ser_pacCode, String ser_pacName, long serviceId, int status, int start, int end, int searchTypeFlag) throws SystemException {
		
		boolean replaceFlag = true;
		if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		List<ServicePackageEntry> list = new ArrayList<ServicePackageEntry>();
		// / This stuff is basic set up
		Session session = null;
		
		try {
				session = openSession();
				// Here ends the basic set up;
				String sql = "";
				// now we build the query. Note that we use the name of the tables
				// from the database!
				sql = CustomSQLUtil.get(SEARCH_SQL_ID);
				sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag);
				SQLQuery query = session.createSQLQuery(sql);
				
				query.addEntity("TBL_SERVICE_PACKAGE", ServicePackageEntryImpl.class);
				
				QueryPos pos = QueryPos.getInstance(query);
				
				pos.add("%"+ser_pacCode+"%");
				pos.add(ser_pacCode);
				
				pos.add("%"+ser_pacName+"%");
				pos.add(ser_pacName);
				
				if(serviceId == 0){
					pos.add("");
					pos.add("");
					System.out.println("NULL DAY");
				}else{
					pos.add("%"+serviceId+"%");
					pos.add(serviceId);
				}		
				
				pos.add("%"+status+"%");
				pos.add(status);
				
				list = ((List<ServicePackageEntry>) QueryUtil.list(query, getDialect(), start, end));
		} 
		catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
			throw processException(e);
		}
		finally{
			closeSession(session);
		}
		
		System.out.println("search size service package = " + list.size());
		return list;
	}
	
	public int searchCount(String ser_pacCode, String ser_pacName, long serviceId, int status, int searchTypeFlag) throws SystemException {
		// / This stuff is basic set up
		boolean replaceFlag=true; if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		Session session = null;
		int  count = 0;
		try {
			session = openSession();
			// Here ends the basic set up;
			// FinderCacheUtil.get

			// now we build the query. Note that we use the name of the tables
			// from the database!
			String sql = CustomSQLUtil.get(SEARCH_COUNT_SQL_ID);
			sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag); // AND
			SQLQuery query = session.createSQLQuery(sql);
			//	query.addEntity("vrbt_service", ServiceImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
					
			qPos.add("%"+ser_pacCode+"%");
			qPos.add(ser_pacCode);
					
			qPos.add("%"+ser_pacName+"%");
			qPos.add(ser_pacName);
			
			if(serviceId == 0){
				qPos.add("");
				qPos.add("");
				System.out.println("NULL DAY");
			}else{
				qPos.add("%"+serviceId+"%");
				qPos.add(serviceId);
			}			
					
			qPos.add("%"+status+"%");
			qPos.add(status);
					
			Object  obj = query.uniqueResult();
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
