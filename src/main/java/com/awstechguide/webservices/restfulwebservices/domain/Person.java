package com.awstechguide.webservices.restfulwebservices.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("PersonModelFilter")
public class Person {

	private String personId;
	private String personName;
	private String email;
	private Date dateOfBirth;
	private String sSN;
	private boolean status;
		

	public Person(String personId, String personName, String email, Date dateOfBirth, String sSN, boolean status) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.sSN = sSN;
		this.status = status;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getsSN() {
		return sSN;
	}
	public void setsSN(String sSN) {
		this.sSN = sSN;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", SSN=" + sSN + ", status=" + status + "]";
	}
	
	
	
}
