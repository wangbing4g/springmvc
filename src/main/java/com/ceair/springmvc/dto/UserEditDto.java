/**
 * 
 */
package com.ceair.springmvc.dto;

import c.c.p.web.search.annotations.Equal;


/**
 * @author Administrator
 *
 */
public class UserEditDto {
	
	@Equal
	private Long id;

	private String userName;

	private String password;

	private String salty;

	private String email;

	private String telphone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalty() {
		return salty;
	}

	public void setSalty(String salty) {
		this.salty = salty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	

}
