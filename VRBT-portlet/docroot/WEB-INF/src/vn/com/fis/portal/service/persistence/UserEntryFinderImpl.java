package vn.com.fis.portal.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import vn.com.fis.portal.model.UserEntry;
import vn.com.fis.portal.model.impl.UserEntryImpl;


public class UserEntryFinderImpl extends BasePersistenceImpl<UserEntry> implements
UserEntryFinder{
	
	public final String SQL_getUserEntryByUserName = UserEntryFinderImpl.class
			.getName()
			+ ".getUserEntryByUserName";
	
	public UserEntry getUserEntryByUserName(String username) {
		UserEntry userExt = null;
		// / This stuff is basic set up
		Session session = null;

		try {
			session = openSession();
			// Here ends the basic set up;
			String sql = "";
			// now we build the query. Note that we use the name of the tables
			// from the database!
			sql = CustomSQLUtil.get(SQL_getUserEntryByUserName);
			System.out.println("sql: " + sql);
			System.out.println("username: " + username);

			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("UserEntry", UserEntryImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(username);
			List list = QueryUtil.list(query, getDialect(), 0, 100);
			System.out.println("list.size(): " + list.size());
			userExt = (UserEntry) QueryUtil.list(query, getDialect(), 0, 100)
					.get(0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			closeSession(session);
		}

		return userExt;
	}
}
