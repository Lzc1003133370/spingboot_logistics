package com.entor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entor.entity.Member;
import com.entor.service.IMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	private IMemberService memberService;

	@RequestMapping("/index")
	public String index(Map<String, Object> map) {
		Subject sub = SecurityUtils.getSubject();
		String username = sub.getPrincipal().toString();
		map.put("username", username);
		return "/index";
	}

	@RequestMapping("/queryByPage")
	@ResponseBody
	public Map<String, Object> queryByPage(
			@RequestParam(value = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page) {
		PageHelper.startPage(page, limit);
		List<Member> list = memberService.list();
		PageInfo<Member> pageInfo = new PageInfo<>(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	@RequestMapping("/M")
	public String m() {
		return "/member";
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
