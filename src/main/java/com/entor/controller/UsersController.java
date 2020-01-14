package com.entor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.Result;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 展成
 * @since 2020-01-07
 */
@Controller
@RequestMapping("/users")
public class UsersController {

	@RequestMapping("picker")
	public Result picker(String address) {
		System.out.println(address);
		return new Result(0, "数据添加成功！");
	}
}
