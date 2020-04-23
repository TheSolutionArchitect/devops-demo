package com.awstechguide.webservices.restfulwebservices.domain;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserProfile {
	
	/*
	 * public UserProfile() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * public UserProfile(List<User> user) { super(); this.user = user; }
	 */

	List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
