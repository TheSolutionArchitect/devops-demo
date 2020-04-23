package com.awstechguide.webservices.restfulwebservices.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awstechguide.webservices.restfulwebservices.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
