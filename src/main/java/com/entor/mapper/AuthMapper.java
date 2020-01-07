package com.entor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entor.entity.Auth;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public interface AuthMapper extends BaseMapper<Auth> {

	@Select("SELECT a.* FROM member AS m , role_auth AS ra , auth AS a , member_role AS mr WHERE m.member_id = mr.member_id AND mr.role_id = ra.role_id AND ra.auth_id = a.power_id AND m.Member_username = #{username}")
	public List<Auth> queryAuthsByUsername(@Param("username") String username);

	@Select("SELECT a.power_name FROM member AS m , role_auth AS ra , auth AS a , member_role AS mr WHERE m.member_id = mr.member_id AND mr.role_id = ra.role_id AND ra.auth_id = a.power_id AND m.Member_username = #{username}")
	public List<String> queryAuthNameByUsername(@Param("username") String username);
}
