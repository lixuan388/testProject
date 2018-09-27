package com.ecity.java.MVC.exception;

public class UserExistException extends Exception {
	public UserExistException(String ExceptionMsg)
	{
		super(ExceptionMsg);
	}
}
