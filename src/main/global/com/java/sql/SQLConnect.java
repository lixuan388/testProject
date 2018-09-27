package com.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class SQLConnect {


	static void InitConnectPoolSQL()
	{

	
  	
	}		
	static void InitConnectPoolMySQL()
	{
		
			
	}		 
			
	static public Connection GetConnect()
	{

	//数据库驱动对象
  	String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
  	//数据库连接地址(数据库名)
  	String URL="jdbc:sqlserver://ls.17ecity.cc:58733;databaseName=visadb";
  	//登陆名
  	String USER="visadb";
  	//登陆密码
  	String PWD="visadb2016"; 
    
  	Connection con = null;
  	try {
  		Class.forName(DRIVER);
  	} catch (ClassNotFoundException e) {
	  	// TODO Auto-generated catch block
	  	e.printStackTrace();
  	}
  	try {
  		con=DriverManager.getConnection(URL,USER,PWD);
  	} catch (SQLException e) {
	  	// TODO Auto-generated catch block
	  	e.printStackTrace();
  	}

  	System.out.println(con.toString());
  	try {
			System.out.println(""+con.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	return con;
	}
			
	static public Connection GetMySqlConnect()
	{

		return null;
	}
				
	
	static {
//		InitConnectPool();
	}
			

}
