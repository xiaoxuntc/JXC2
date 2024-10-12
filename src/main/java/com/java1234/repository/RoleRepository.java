package com.java1234.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java1234.entity.Role;

/**
 * 角色Repository接口
 * @author Administrator
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{

	/**
	 * 根据用户id查角色集合
	 * @param id
	 * @return
	 */
	@Query(value="SELECT r.* FROM t_user u,t_role r,t_user_role ur WHERE ur.`user_id`=u.`id` AND ur.`role_id`=r.`id` AND u.`id`=?1",nativeQuery=true)
	public List<Role> findByUserId(Integer id);
}
