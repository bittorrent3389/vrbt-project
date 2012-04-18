package vn.com.fis.portal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.portlet.RenderRequest;
import vn.com.fis.portal.service.UserEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

public class VRBTLibrary {

	public boolean checkPermission(long userId,long groupId,long roleId)
	{
		boolean isAllow = false;
		
		try{
			if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
			{
				isAllow = true;
			}
		}catch(Exception e)
		{	
			System.out.println("Network-Operator role does not exist.");
			isAllow = false;
		}
		
		return isAllow;
	}
	
	public String checkLogin(long userId,RenderRequest renderRequest,String staff)
	{
		String isAllow = "";
		long companyId = 0;
		long roleId = 0;
		
		if((userId+"").equals("null")||(userId+"").equals("")||(userId+"").equals("10158"))
		{
			//userId="0";
			
			return "Please login";
		}
		else
		{
			try{
				companyId = PortalUtil.getCompanyId(renderRequest);
				String[] staffArr = staff.split("#");
				for(int i = 0;i<staffArr.length;i++)
				{
					roleId = RoleLocalServiceUtil.getRole(companyId, staffArr[i]).getRoleId();
					
					if(UserLocalServiceUtil.hasRoleUser(roleId, userId))
					{
						isAllow = "Success";
						return isAllow;
					}
					else
					{
						isAllow = "You don't have permission";
					}
				}
			}catch(Exception e)
			{	
				e.printStackTrace();
				isAllow = "Network-Operator role does not exist";
			}
		}
		return isAllow;
	}
	
	public String returnTransactionCode(long transactionCode)
	{
		String transactionCodeName="";
		if(transactionCode==1)
		{
			transactionCodeName ="upload";
		}
		else if(transactionCode==2)
		{
			transactionCodeName = "purchase";
		}
		else if(transactionCode==3)
		{
			transactionCodeName = "send";
		}
		else
		{
			transactionCodeName = "receive";
		}
		return transactionCodeName;
	}
	
	public String returnUserName(long userId)
	{
		String userName ="";
		if(!String.valueOf(userId).equals("0")&&!String.valueOf(userId).equals("null")&&!String.valueOf(userId).equals(""))
		{
			try {
				userName = UserEntryLocalServiceUtil.getUserEntry(userId).getUserName();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userName;
	}
	
	public static String convertDateToString(Date date, String format) {
		    SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
			    return mySimpleDateFormat.format(date);
			}
			 
			public static Date convertStringToDate(String dateStr, String format) {
			    SimpleDateFormat mySimpleDateFormat = new SimpleDateFormat(format);
			    try {
			        return mySimpleDateFormat.parse(dateStr);
			    } catch (ParseException e) {
			        return null;
			    }
			}
	
}
