package com.awstechguide.webservices.restfulwebservices;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.awstechguide.webservices.restfulwebservices.configuration.AppConfig;
import com.awstechguide.webservices.restfulwebservices.domain.Task;
import com.awstechguide.webservices.restfulwebservices.domain.User;
import com.awstechguide.webservices.restfulwebservices.domain.UserProfile;
import com.awstechguide.webservices.restfulwebservices.service.UserService;

@RestController
@RequestMapping(UserService.SERVICE_NAME)
public class UserController {

	@Autowired
	private UserProfile userProfile;
	
	@Autowired
	private AppConfig appconfig;
		
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public UserProfile getAll() {
		userProfile.setUsers(userService.findAll());
		System.out.println("host ***: "+appconfig.getHost());
		System.out.println("J_host ***: "+appconfig.getJ_host());
		return userProfile;
	}
	
	@GetMapping("/"+ UserService.jpa)
	public UserProfile getAllFromH2() {
		userProfile.setUsers(userService.findAllfromH2());
		return userProfile;
	}
	
	@GetMapping("/{id}/"+ UserService.jpa)
	public UserProfile getUserFromH2(@PathVariable Integer id) {		
		List<User> list = new ArrayList<User>();
		list.add(userService.findByIdFromH2(id).get());
		userProfile.setUsers(list);
		return userProfile;
	}
	
	@DeleteMapping("/{id}/"+ UserService.jpa +"/"+ UserService.delete)
	public void deleteUserFromH2(@PathVariable Integer id) {		
		userService.deleteUser(id);
	}

	@PostMapping("/"+UserService.jpa +"/"+ UserService.add)
	public UserProfile saveUser(@Valid @RequestBody User user) {
		List<User> list = new ArrayList<User>();
		list.add(userService.saveUser(user));
		userProfile.setUsers(list);
		return userProfile;
	}
	
	@GetMapping("/{userId}/" + UserService.findOne)
	public User getUser(@PathVariable String userId) {		
		return userService.findUser(userId);
	}
	
	
	@PostMapping("/")
	public void save(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}")
				.buildAndExpand(savedUser.getUserId()).toUri();
		ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{id}/"+ UserService.task)
	public List<Task> getTasksByUserId(@PathVariable Integer id){		
		return userService.getTasksByUserId(id);		
	}
	
	@PostMapping("/{id}/save/"+ UserService.task)
	public Task saveTask(@PathVariable Integer id , @RequestBody Task task) { 		 
		 return userService.saveTask(id, task);
	}
}
