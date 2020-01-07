package com.entor.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entor.entity.Role;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public interface IRoleService extends IService<Role> {

	public List<Role> queryRolesByUsername(String username);

	public List<String> queryRoleNameByUsername(String username);
}
