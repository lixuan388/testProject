package com.ecity.java.MVC.dao;

import com.ecity.java.MVC.domain.User;

public interface  IUserDao {
  /**
   * 根据用户名和密码来查找用户
   * @param userName
   * @param userPwd
   * @return 查到到的用户
   */
  User find(String userName, String userPwd);

  /**
   * 添加用户
   * @param user
   */
  void add(User user);

  /**根据用户名来查找用户
   * @param userName
   * @return 查到到的用户
   */
  User find(String userName);
}
