package vn.com.fis.portal.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import vn.com.fis.portal.model.ServiceEntry;
import vn.com.fis.portal.model.impl.ServiceEntryImpl;

public class ServiceEntryFinderImpl extends BasePersistenceImpl implements ServiceEntryFinder {
	public final String SEARCH_SQL_ID = ServiceEntryFinderImpl.class.getName()+".search";
	
	public final String SEARCH_COUNT_SQL_ID = ServiceEntryFinderImpl.class.getName()+".searchCount";
	
	private static String START_SERVICE_CODE = "001";
	private static String UPLOAD_SERVICE_PACKAGE_CODE = "002";
	
	public List<ServiceEntry> search(String serviceCode, String serviceName, int status, int start, int end, int searchTypeFlag) throws SystemException {
		
		boolean replaceFlag = true;
		if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		List<ServiceEntry> list = new ArrayList<ServiceEntry>();
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
				
				query.addEntity("TBL_SERVICE", ServiceEntryImpl.class);
				
				QueryPos pos = QueryPos.getInstance(query);
				
				pos.add("%"+serviceCode+"%");
				pos.add(serviceCode);
				
				pos.add("%"+serviceName+"%");
				pos.add(serviceName);
				
				pos.add("%"+status+"%");
				pos.add(status);
				
				list = ((List<ServiceEntry>) QueryUtil.list(query, getDialect(), start, end));
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
	
	public int searchCount(String serviceCode, String serviceName, int status, int searchTypeFlag) throws SystemException {
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
					
			qPos.add("%"+serviceCode+"%");
			qPos.add(serviceCode);
					
			qPos.add("%"+serviceName+"%");
			qPos.add(serviceName);
					
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
	
	public boolean isStartService(String serviceCode) {
		return START_SERVICE_CODE.equals(serviceCode);
	}
	
	public boolean isUploadServicePackage(String serviceCode) {
		return UPLOAD_SERVICE_PACKAGE_CODE.equals(serviceCode);
	}
	
	public String getStartServiceCode() {
		return START_SERVICE_CODE;
	}
	
	public String getUploadServicePackageCode() {
		return UPLOAD_SERVICE_PACKAGE_CODE;
	}
}
