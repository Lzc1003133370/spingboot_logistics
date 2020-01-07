package com.entor.realm;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entor.entity.Member;
import com.entor.service.IAuthService;
import com.entor.service.IMemberService;
import com.entor.service.IRoleService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private IMemberService memberService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IAuthService authService;

	@Autowired
	private SessionDAO sessionDAO;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 这里做权限控制
		// 获取用户名
		String username = principals.getPrimaryPrincipal().toString();
		// 获取所有的角色名称
		List<String> roleList = roleService.queryRoleNameByUsername(username);
		// 获取所有的权限名称
		List<String> authList = authService.queryAuthNameByUsername(username);
		// 创建权限对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 添加角色
		info.addRoles(roleList);
		// 添加权限
		info.addStringPermissions(authList);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户名
		String username = token.getPrincipal().toString();
		// 获取密码
		String password = new String((char[]) token.getCredentials());
		QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("Member_username", username);
		queryWrapper.eq("Member_password", password);
		Member member = memberService.getOne(queryWrapper);
		if (member == null) {
			throw new AuthenticationException("用户名或密码错误！");
		}
		// 这里做登录控制
		Collection<Session> list = sessionDAO.getActiveSessions();

		for (Session s : list) {
			Object username2 = String.valueOf(s.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
			if (username.equals(username2)) {
				s.setTimeout(0);
				break;
			}
		}
		return new SimpleAuthenticationInfo(username, password, "user");
	}
}
