package com.java1234.service;

import com.java1234.entity.User;

/**
 * 用户Service接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 根据用户名查找用户实体
	 * @param userName
	 * @return
	 */
	public User findByUserName(String userName);
}
