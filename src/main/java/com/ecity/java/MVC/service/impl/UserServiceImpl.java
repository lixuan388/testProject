package com.ecity.java.MVC.service.impl;

import com.ecity.java.MVC.dao.IUserDao;
import com.ecity.java.MVC.dao.impl.UserDaoImpl;
import com.ecity.java.MVC.domain.User;
import com.ecity.java.MVC.exception.UserExistException;
import com.ecity.java.MVC.service.IUserService;

public class UserServiceImpl implements IUserService {
	
  private IUserDao userDao = new UserDaoImpl();

  public void registerUser(User user) throws UserExistException {
    if (userDao.find(user.getUsername())!=null) {
        //checked exception 
        //unchecked exception
        //这里抛编译时异常的原因：是我想上一层程序处理这个异常，以给用户一个友好提示
        throw new UserExistException("注册的用户名已存在！！！");
    }
    userDao.add(user);
}

public User loginUser(String userName, String userPwd) {
    return userDao.find(userName, userPwd);
}
  

	
}
