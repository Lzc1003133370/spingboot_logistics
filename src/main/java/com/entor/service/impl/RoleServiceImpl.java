package com.entor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.Role;
import com.entor.mapper.RoleMapper;
import com.entor.service.IRoleService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> queryRolesByUsername(String username) {
		return roleMapper.queryRolesByUsername(username);
	}

	@Override
	public List<String> queryRoleNameByUsername(String username) {
		return roleMapper.queryRoleNameByUsername(username);
	}

}
