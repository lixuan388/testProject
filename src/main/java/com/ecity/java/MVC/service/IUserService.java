package com.ecity.java.MVC.service;

import com.ecity.java.MVC.domain.User;
import com.ecity.java.MVC.exception.UserExistException;

public interface IUserService {
  /**
   * 提供注册服务
   * @param user
   * @throws UserExistException
   */
  void registerUser(User user) throws UserExistException;

  /**
   * 提供登录服务
   * @param userName
   * @param userPwd
   * @return
   */
  User loginUser(String userName, String userPwd);
}
