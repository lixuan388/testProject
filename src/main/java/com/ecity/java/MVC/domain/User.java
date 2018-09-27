package com.ecity.java.MVC.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private int id;
	private String status;
	private int user_lst;
	private Date date_ins;
	private Date date_lst;
	private String usercode;
	private String username;
	private String password;
	private String depart;
	private int userjob;
	private int id_aco;
	private boolean IsAdmin;
	private String Temp1;
	private String Temp2;
	private String Temp3;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUser_lst() {
		return user_lst;
	}
	public void setUser_lst(int user_lst) {
		this.user_lst = user_lst;
	}
	public Date getDate_ins() {
		return date_ins;
	}
	public void setDate_ins(Date date_ins) {
		this.date_ins = date_ins;
	}
	public Date getDate_lst() {
		return date_lst;
	}
	public void setDate_lst(Date date_lst) {
		this.date_lst = date_lst;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public int getUserjob() {
		return userjob;
	}
	public void setUserjob(int userjob) {
		this.userjob = userjob;
	}
	public int getId_aco() {
		return id_aco;
	}
	public void setId_aco(int id_aco) {
		this.id_aco = id_aco;
	}
	public boolean isIsAdmin() {
		return IsAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		IsAdmin = isAdmin;
	}
	public String getTemp1() {
		return Temp1;
	}
	public void setTemp1(String temp1) {
		Temp1 = temp1;
	}
	public String getTemp2() {
		return Temp2;
	}
	public void setTemp2(String temp2) {
		Temp2 = temp2;
	}
	public String getTemp3() {
		return Temp3;
	}
	public void setTemp3(String temp3) {
		Temp3 = temp3;
	}
	
	
}
