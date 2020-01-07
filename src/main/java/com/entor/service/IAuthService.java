package com.entor.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entor.entity.Auth;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
public interface IAuthService extends IService<Auth> {

	public List<Auth> queryAuthsByUsername(String username);

	public List<String> queryAuthNameByUsername(String username);
}
