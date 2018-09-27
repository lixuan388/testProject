package com.ecity.java.MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ecity.java.sql.db.DBTable;

public class CreateDataModuleByTable {
	

	public static void main(String[] args) {
		new CreateDataModuleByTable().PrintMSSql("aus_users","aus_");
	}
	
	public void PrintMSSql(String TableName,String TablePerfix)
	{
		DBTable table=new DBTable(GetConnect(),"select * from "+TableName +" where 1<>1");
		try
		{
			table.Open();
			System.out.println("//TableName:"+TableName);
			try {
				
				
				int ColumnCount=table.getColumnCount();
				System.out.println("//ColumnCount:"+ColumnCount);
				for (int i =1;i<=ColumnCount;i++)
				{
					String FieldName=table.getColumnLabel(i).replaceAll(TablePerfix, "");
					int ColumnType=table.getColumnType(i);
					String ColumnTypeName="";
					switch (ColumnType) {
						case java.sql.Types.NVARCHAR:
						case java.sql.Types.CHAR:
						case java.sql.Types.VARCHAR:
							ColumnTypeName="String";
							break;
						case java.sql.Types.BIT:
							ColumnTypeName="boolean";
							break;
						case java.sql.Types.INTEGER:
							ColumnTypeName="int";
							break;
						case java.sql.Types.DATE:
						case java.sql.Types.TIMESTAMP:
							ColumnTypeName="Date";
							break;
						default:
							System.err.println(FieldName+"//ColumnType:"+ColumnType);
							return;
					}
//					System.out.println(ColumnType);
					System.out.println("private "+ColumnTypeName+" "+FieldName+";");
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		finally
		{
			table.Close();
		}
		
	}
	public Connection GetConnect()
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


  	return con;
	}
			
}
