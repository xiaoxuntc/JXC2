package com.java1234.service;

import java.util.List;
import java.util.Optional;

import com.java1234.entity.Role;

/**
 * 角色Service接口
 * @author Administrator
 *
 */
public interface RoleService {

	/**
	 * 根据用户id查角色集合
	 * @param id
	 * @return
	 */
	public List<Role> findByUserId(Integer id);
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public Optional<Role> findById(Integer id);
}
