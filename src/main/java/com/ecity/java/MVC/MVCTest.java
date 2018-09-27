package com.ecity.java.MVC;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.ecity.java.MVC.dao.IUserDao;
import com.ecity.java.MVC.dao.impl.UserDaoImpl;
import com.ecity.java.MVC.domain.User;

public class MVCTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("MVCTest");
		IUserDao userDao = new UserDaoImpl();
				
		User user=userDao.find("admin");
		System.out.println("--user--");
		System.out.println("userID:"+user.getId());
		System.out.println("userName:"+user.getUsername());
		System.out.println("userCode:"+user.getUsercode());
		System.out.println("password:"+user.getPassword());

		
		
		try {
			System.out.println("--BeanUtils.getProperty--");
			System.out.println("id:"+BeanUtils.getProperty(user, "id"));
			System.out.println("username:"+BeanUtils.getProperty(user, "username"));
			System.out.println("usercode:"+BeanUtils.getProperty(user, "usercode"));
			System.out.println("password:"+BeanUtils.getProperty(user, "password"));
			System.out.println("isAdmin:"+BeanUtils.getProperty(user, "isAdmin"));
			
			
//		// 注册字符串到日期的转换器
//			ConvertUtils.register(new DateLocaleConverter(), Date.class);
//			BeanUtils.copyProperties(user, formbean);//把表单的数据填充到javabean中
			 
			 
			 
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {

			System.out.println("--BeanUtils.describe--");
			Map <String,Object> m=BeanUtils.describe(user);
			Iterator<String> i=m.keySet().iterator();
			while (i.hasNext())
			{
				System.out.println(i.next());
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
