package com.pro.jwt.JwtSpringsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.pro.jwt.JwtSpringsecurity.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmailIgnoreCase(String username);
	
}
