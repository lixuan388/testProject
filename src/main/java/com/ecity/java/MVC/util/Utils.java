package com.ecity.java.MVC.util;

import org.apache.commons.beanutils.BeanUtils;

import com.ecity.java.sql.db.DBTable;

public class Utils {
	
	public static <T> T TableToBean(DBTable table,String prefix,Class<T> c){
		try{
				T bean = c.newInstance();
				int ColumnCount=table.getColumnCount();
//				System.out.println("ColumnCount:"+ColumnCount);
				for (int i=1;i<=ColumnCount;i++)
				{
					String FieldName = table.getColumnLabel(i);
					Object FieldValue=table.GetValue(FieldName);
					String PropertyName=FieldName.replaceAll(prefix, "");
//					System.out.println("PropertyName:"+PropertyName+"/FieldValue:"+FieldValue);
					BeanUtils.setProperty(bean, PropertyName, FieldValue);
				}
				return bean;
			}catch (Exception e) {
					throw new RuntimeException(e);
			}
	}
	
}
