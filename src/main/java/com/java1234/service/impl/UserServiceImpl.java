package com.java1234.service.impl;

import org.springframework.stereotype.Service;

import com.java1234.entity.User;
import com.java1234.repository.UserRepository;
import com.java1234.service.UserService;

import jakarta.annotation.Resource;

/**
 * 用户Service实现类
 * 
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

}
