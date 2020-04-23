package com.awstechguide.webservices.restfulwebservices.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.awstechguide.webservices.restfulwebservices.domain.Task;
import com.awstechguide.webservices.restfulwebservices.domain.User;
import com.awstechguide.webservices.restfulwebservices.exception.UserNotFoundException;
import com.awstechguide.webservices.restfulwebservices.service.TaskRepository;
import com.awstechguide.webservices.restfulwebservices.service.UserRepository;
import com.awstechguide.webservices.restfulwebservices.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	static int counter=3;
	
	static List<User> nu = new ArrayList<User>();	
	public UserServiceImpl() {
		super();
		nu.add(new User(1, "1","Som", "som@awstechguide.com", new Date(), new Date(), true));
		nu.add(new User(2, "2","Alex", "info@awstechguide.com", new Date(), new Date(), true));
		nu.add(new User(3, "3","Alan", "alan@awstechguide.com", new Date(), new Date(), true));
	}


	@Override
	public List<User> findAll(){
		
		return nu;
	}
	
	@Override
	public List<User> findAllfromH2() {
		return userRepository.findAll();
	}
	
	@Override
	public Optional<User> findByIdFromH2(Integer id){
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	@Override
	public User saveUser(User user) {		
		return userRepository.save(user);
	}
	
	@Override
	public User findUser(String userId) {
		boolean found=false;
		for(User ur : nu) {
			if (ur.getUserId().equalsIgnoreCase(userId)) {
				found=true;
				return ur;
			}
		}
		if(!found) {
			throw new UserNotFoundException("User Not found:"+userId);
		}
		return null;
	}
	
	@Override
	public User save(User user) {
		user.setUserId(Integer.toString(++counter));
		nu.add(user);		
		return user;
	}
	
	@Override
	public List<Task> getTasksByUserId(Integer id){
		return userRepository.findById(id).get().getTasks();
	}
	
	@Override
	public Task saveTask(Integer id, Task task) {		
		Optional<User> usr=userRepository.findById(id);
		if(!usr.isPresent()) {
			throw new UserNotFoundException("id:"+id);
		}
		User user = usr.get();
		task.setUser(user);
		return taskRepository.save(task);
	}
}
