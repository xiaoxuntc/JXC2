package com.java1234.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java1234.entity.Role;
import com.java1234.repository.RoleRepository;
import com.java1234.service.RoleService;

import jakarta.annotation.Resource;

/**
 * 角色Service实现类
 * @author Administrator
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> findByUserId(Integer id) {
		return roleRepository.findByUserId(id);
	}

	@Override
	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}

}
