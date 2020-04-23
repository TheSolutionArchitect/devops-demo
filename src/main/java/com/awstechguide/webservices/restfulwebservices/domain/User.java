package com.awstechguide.webservices.restfulwebservices.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description="User Model")
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String userId;
	@Size(min=2, message="Name should have more than two chars")
	@ApiModelProperty(notes="User Name should be more than 2 chars")
	private String userName;
	private String email;
	
	//@JsonIgnore // to filter this field from reponse
	private Date activeFromDt;	
	@Future
	@ApiModelProperty(notes="Expiry date should be future date")
	private Date expiryDt;
	private boolean active;

	@OneToMany(mappedBy="user")
	private List<Task> tasks;
	
	public User(Integer id, String userId,
			@Size(min = 2, message = "Name should have more than two chars") String userName, String email,
			Date activeFromDt, @Future Date expiryDt, boolean active) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.activeFromDt = activeFromDt;
		this.expiryDt = expiryDt;
		this.active = active;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	public Date getActiveFromDt() {
		return activeFromDt;
	}
	public void setActiveFromDt(Date activeFromDt) {
		this.activeFromDt = activeFromDt;
	}
	public Date getExpiryDt() {
		return expiryDt;
	}
	public void setExpiryDt(Date expiryDt) {
		this.expiryDt = expiryDt;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", userName=" + userName + ", email=" + email
				+ ", activeFromDt=" + activeFromDt + ", expiryDt=" + expiryDt + ", active=" + active + "]";
	}
	

	
}
