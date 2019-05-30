package com.pro.jwt.JwtSpringsecurity.service;

import java.util.List;

import com.pro.jwt.JwtSpringsecurity.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
