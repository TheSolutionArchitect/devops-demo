package com.awstechguide.webservices.restfulwebservices.service;

import java.util.List;
import java.util.Optional;

import com.awstechguide.webservices.restfulwebservices.domain.Task;
import com.awstechguide.webservices.restfulwebservices.domain.User;

public interface UserService {	
	String SERVICE_NAME="users";
	String findAll="findall";
	String findOne="findone";
	
	String jpa="jpa";
	String add="add";
	String delete="delete";
	String task="task";
	
	List<User> findAll();
	User findUser(String userId);
	User save(User user);
	List<User> findAllfromH2();
	Optional<User> findByIdFromH2(Integer id);
	void deleteUser(Integer id);
	User saveUser(User user);
	List<Task> getTasksByUserId(Integer id);
	Task saveTask(Integer id, Task task);

}
