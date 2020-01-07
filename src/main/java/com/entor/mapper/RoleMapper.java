package com.entor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entor.entity.Role;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public interface RoleMapper extends BaseMapper<Role> {

	@Select("SELECT r.* FROM member AS m , role AS r , member_role AS mr WHERE m.member_id = mr.member_id AND r.role_id = mr.role_id AND m.Member_username = #{username}")
	public List<Role> queryRolesByUsername(@Param("username") String username);

	@Select("SELECT r.name FROM member AS m , role AS r , member_role AS mr WHERE m.member_id = mr.member_id AND r.role_id = mr.role_id AND m.Member_username = #{username}")
	public List<String> queryRoleNameByUsername(@Param("username") String username);
}
