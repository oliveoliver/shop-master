package cn.it.shop.web;

import java.io.Serializable;
import java.math.BigDecimal;

public class User implements Serializable{
	private String login;
	//private String name;
	private String pass; 
	private String sex;
	private String phone;
	private String email;
	private String money;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
/*	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	/*@Override
	public String toString() {
		return "User [login=" + login + ", name=" + name + ", pass=" + pass + ", sex=" + sex + ", phone=" + phone
				+ ", email=" + email + "]";
	}*/
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String login, String pass, String sex, String phone, String email,String money) {
		this.login = login;
		//this.name = name;
		this.pass = pass;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.money = money;
	}
	
	
	
}
