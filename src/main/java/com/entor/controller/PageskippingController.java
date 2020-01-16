package com.entor.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//前台页面跳转Controller
@Controller
@RequestMapping("ym")
public class PageskippingController {

	// 模板视图加载
	@RequestMapping("/member.html")
	public ModelAndView member() {
		return new ModelAndView("member");
	}

	@RequestMapping("/waybill.html")
	public ModelAndView waybill() {
		return new ModelAndView("waybill");
	}

	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		Subject sub = SecurityUtils.getSubject();
		String username = sub.getPrincipal().toString();
		map.put("username", username);
		return "/index";
	}

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
			return "redirect:index";
		} catch (Exception e) {
			return "redirect:login";
		}
	}
}
