package com.entor.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.mapper.MemberMapper;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberMapper memberMapper;

	@RequestMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping("/logout")
	public String logout() {
		Subject sub = SecurityUtils.getSubject();
		sub.logout();
		return "/login";
	}

	@RequestMapping("/loginCheck")
	public String loginCheck(String username, String password) {
		SimpleHash hash = new SimpleHash("md5", password, "123", 2);
		String password1 = hash.toHex();
		System.out.println("经过md5和两次加密盐后的密码:" + password1);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password1);
		Subject sub = SecurityUtils.getSubject();
		try {
			sub.login(token);
			return "/hellow";
		} catch (Exception e) {
			return "redirect:login";
		}
	}
}
