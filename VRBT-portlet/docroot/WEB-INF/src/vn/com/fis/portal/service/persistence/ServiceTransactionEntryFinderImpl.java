package vn.com.fis.portal.service.persistence;

import java.util.ArrayList;
import java.util.List;

import vn.com.fis.portal.model.ServiceTransactionEntry;
import vn.com.fis.portal.model.impl.ServiceTransactionEntryImpl;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ServiceTransactionEntryFinderImpl extends BasePersistenceImpl implements ServiceTransactionEntryFinder {
	public final String SEARCH_SQL_ID = ServiceTransactionEntryFinderImpl.class.getName()+".search";
	public final String SEARCH_SERVICE_SQL_ID = ServiceTransactionEntryFinderImpl.class.getName()+".searchServiceAll";
	public final String SEARCH_SERVICE_PAC_SQL_ID = ServiceTransactionEntryFinderImpl.class.getName()+".searchServicePacAll";
	
	public final String SEARCH_COUNT_SQL_ID = ServiceTransactionEntryFinderImpl.class.getName()+".searchCount";
	public final String SEARCH_SERVICE_COUNT_SQL_ID = ServiceTransactionEntryFinderImpl.class.getName()+".searchServiceCountAll";
	public final String SEARCH_SERVICE_PAC_COUNT_SQL_ID = ServiceTransactionEntryFinderImpl.class.getName()+".searchServicePacCountAll";
	
	public List<ServiceTransactionEntry> searchService(long transactionCode, long serviceId, long servicePackageId, int start, int end, int searchTypeFlag) 
			throws SystemException {
		
		boolean replaceFlag = true;
		if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		List<ServiceTransactionEntry> list = new ArrayList<ServiceTransactionEntry>();
		// / This stuff is basic set up
		Session session = null;
		
		try {
				session = openSession();
				// Here ends the basic set up;
				String sql = "";
				
				// now we build the query. Note that we use the name of the tables
				// from the database!
				
				if (transactionCode == 0 && serviceId == 0 && servicePackageId == 0) {
					sql = CustomSQLUtil.get(SEARCH_SERVICE_SQL_ID);
					//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag);
					SQLQuery query = session.createSQLQuery(sql);
				
					query.addEntity("TBL_SERVICE_TRANSACTION", ServiceTransactionEntryImpl.class);

					list = ((List<ServiceTransactionEntry>) QueryUtil.list(query, getDialect(), start, end));
					
				} else {
					sql = CustomSQLUtil.get(SEARCH_SQL_ID);
					//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag);
					SQLQuery query = session.createSQLQuery(sql);
					
					QueryPos pos = QueryPos.getInstance(query);
					
					pos.add(transactionCode);
				
					query.addEntity("TBL_SERVICE_TRANSACTION", ServiceTransactionEntryImpl.class);

					list = ((List<ServiceTransactionEntry>) QueryUtil.list(query, getDialect(), start, end));
				}
				
		} 
		catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
			throw processException(e);
		}
		finally{
			closeSession(session);
		}
		
		System.out.println("search size service transaction = " + list.size());
		return list;
	}
	
	public int searchServiceCount(long transactionCode, long serviceId, long servicePackageId, int searchTypeFlag) throws SystemException {
		// / This stuff is basic set up
		boolean replaceFlag=true; if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		
		Session session = null;
		int  count = 0;
		
		try {
			session = openSession();
			// Here ends the basic set up;
			// FinderCacheUtil.get
			String sql = "";
			
			// now we build the query. Note that we use the name of the tables
			// from the database!
			
			if (transactionCode == 0 && serviceId == 0 && servicePackageId == 0) {
				sql = CustomSQLUtil.get(SEARCH_SERVICE_COUNT_SQL_ID);
				//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag); // AND
				SQLQuery query = session.createSQLQuery(sql);
					
				Object  obj = query.uniqueResult();
				count = Integer.valueOf(obj.toString());
			}else {
				sql = CustomSQLUtil.get(SEARCH_COUNT_SQL_ID);
				//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag); // AND
				SQLQuery query = session.createSQLQuery(sql);
				
				QueryPos pos = QueryPos.getInstance(query);
				
				pos.add(transactionCode);
					
				Object  obj = query.uniqueResult();
				count = Integer.valueOf(obj.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw processException(e);
		} finally {
			closeSession(session);
		}
				
		return count;
	}
	
	public List<ServiceTransactionEntry> searchServicePac(long transactionCode, long serviceId, long servicePackageId, int start, int end, int searchTypeFlag) 
			throws SystemException {
		
		boolean replaceFlag = true;
		if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		List<ServiceTransactionEntry> list = new ArrayList<ServiceTransactionEntry>();
		// / This stuff is basic set up
		Session session = null;
		
		try {
				session = openSession();
				// Here ends the basic set up;
				String sql = "";
				
				// now we build the query. Note that we use the name of the tables
				// from the database!
				
				if (transactionCode == 0 && serviceId == 0 && servicePackageId == 0) {
					sql = CustomSQLUtil.get(SEARCH_SERVICE_PAC_SQL_ID);
					//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag);
					SQLQuery query = session.createSQLQuery(sql);
				
					query.addEntity("TBL_SERVICE_TRANSACTION", ServiceTransactionEntryImpl.class);

					list = ((List<ServiceTransactionEntry>) QueryUtil.list(query, getDialect(), start, end));
					
				} else {
					sql = CustomSQLUtil.get(SEARCH_SQL_ID);
					//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag);
					SQLQuery query = session.createSQLQuery(sql);
					
					QueryPos pos = QueryPos.getInstance(query);
					
					pos.add(transactionCode);
				
					query.addEntity("TBL_SERVICE_TRANSACTION", ServiceTransactionEntryImpl.class);

					list = ((List<ServiceTransactionEntry>) QueryUtil.list(query, getDialect(), start, end));
				}
				
		} 
		catch (Exception e) {
			// TODO: handle exception			
			e.printStackTrace();
			throw processException(e);
		}
		finally{
			closeSession(session);
		}
		
		System.out.println("search size service transaction = " + list.size());
		return list;
	}
	
	public int searchServicePacCount(long transactionCode, long serviceId, long servicePackageId, int searchTypeFlag) throws SystemException {
		// / This stuff is basic set up
		boolean replaceFlag=true; if (searchTypeFlag==0) replaceFlag=false;
		// 1 = true (AND), 0= flase(OR)
		
		Session session = null;
		int  count = 0;
		
		try {
			session = openSession();
			// Here ends the basic set up;
			// FinderCacheUtil.get
			String sql = "";
			
			// now we build the query. Note that we use the name of the tables
			// from the database!
			
			if (transactionCode == 0 && serviceId == 0 && servicePackageId == 0) {
				sql = CustomSQLUtil.get(SEARCH_SERVICE_PAC_COUNT_SQL_ID);
				//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag); // AND
				SQLQuery query = session.createSQLQuery(sql);
					
				Object  obj = query.uniqueResult();
				count = Integer.valueOf(obj.toString());
			}else {
				sql = CustomSQLUtil.get(SEARCH_COUNT_SQL_ID);
				//sql = CustomSQLUtil.replaceAndOperator(sql, replaceFlag); // AND
				SQLQuery query = session.createSQLQuery(sql);
				
				QueryPos pos = QueryPos.getInstance(query);
				
				pos.add(transactionCode);
					
				Object  obj = query.uniqueResult();
				count = Integer.valueOf(obj.toString());
			}
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
