package com.ecity.java.MVC.dao.impl;

import com.ecity.java.MVC.dao.IUserDao;
import com.ecity.java.MVC.domain.User;
import com.ecity.java.MVC.util.Utils;
import com.ecity.java.sql.db.DBTable;
import com.java.sql.SQLConnect;

public class UserDaoImpl implements IUserDao {
	
	public User find(String userName, String userPwd) {
		// TODO Auto-generated method stub
		DBTable UserTable=new DBTable(SQLConnect.GetConnect(),"select * from aus_users where aus_usercode='"+userName+"' and aus_password='"+userPwd+"'");
		try
		{
			UserTable.Open();

			System.out.println("UserTable.Open()");
			if (UserTable.next())
			{
				System.out.println("UserTable.next()");
				return Utils.TableToBean(UserTable, "aus_", User.class);
			}
		}
		finally
		{
			UserTable.Free();
		}
		
		return null;
	}
	
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public User find(String userName) {
		// TODO Auto-generated method stub
		DBTable UserTable=new DBTable(SQLConnect.GetConnect(),"select * from aus_users where aus_usercode='"+userName+"' ");
		try
		{
			UserTable.Open();

			System.out.println("UserTable.Open()");
			if (UserTable.next())
			{
				System.out.println("UserTable.next()");
				return Utils.TableToBean(UserTable, "aus_", User.class);
			}
		}
		finally
		{
			UserTable.Free();
		}
		
		return null;
	}
	
}
