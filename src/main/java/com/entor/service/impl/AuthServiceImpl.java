package com.entor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entor.entity.Auth;
import com.entor.mapper.AuthMapper;
import com.entor.service.IAuthService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
@Service
public class AuthServiceImpl extends ServiceImpl<AuthMapper, Auth> implements IAuthService {

	@Autowired
	private AuthMapper authMapper;

	@Override
	public List<Auth> queryAuthsByUsername(String username) {
		return authMapper.queryAuthsByUsername(username);
	}

	@Override
	public List<String> queryAuthNameByUsername(String username) {
		return authMapper.queryAuthNameByUsername(username);
	}

}
