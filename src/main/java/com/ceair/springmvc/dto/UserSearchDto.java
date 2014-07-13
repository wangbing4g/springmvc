/**
 * 
 */
package com.ceair.springmvc.dto;

import c.c.p.web.search.annotations.ForSearch;
import c.c.p.web.search.annotations.LikeAnyWhere;

/**
 * @author Administrator
 *
 */
@ForSearch
public class UserSearchDto {
	
	@LikeAnyWhere
	private String userName;

	@LikeAnyWhere
	private String email;

	@LikeAnyWhere
	private String telphone;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
