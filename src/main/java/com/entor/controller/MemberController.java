package com.entor.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.entor.entity.Member;
import com.entor.entity.Result;
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

	// 分页查询
	@RequestMapping("/queryByPage")
	@ResponseBody
	public Map<String, Object> queryByPage(
			@RequestParam(value = "limit", required = false, defaultValue = "20") int limit,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page, Member member) {
		PageHelper.startPage(page, limit);
		// 模糊查询语句
		QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
		if (!StringUtils.isEmpty(member.getMemberUsername())) {
			queryWrapper.like("Member_username", member.getMemberUsername());
		}
		if (!StringUtils.isEmpty(member.getMemberName())) {
			queryWrapper.like("Member_name", member.getMemberName());
		}
		List<Member> list = memberService.list(queryWrapper);
		PageInfo<Member> pageInfo = new PageInfo<>(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", pageInfo.getTotal());
		map.put("data", pageInfo.getList());
		return map;
	}

	@RequestMapping("add")
	@ResponseBody
	public Result add(Member member) {
		SimpleHash hash = new SimpleHash("md5", member.getMemberPassword(), "123", 2);
		member.setMemberPassword(hash.toHex());
		memberService.save(member);
		return new Result(0, "数据添加成功！");
	}

	@RequestMapping("update")
	@ResponseBody
	public Result update(Member member) {
		SimpleHash hash = new SimpleHash("md5", member.getMemberPassword(), "123", 2);
		member.setMemberPassword(hash.toHex());
		memberService.updateById(member);
		return new Result(0, "数据修改成功！");
	}

	@RequestMapping("deleteMore")
	@ResponseBody
	public Result deleteMore(String ids) {
		memberService.removeByIds(Arrays.asList(ids.split(",")));
		return new Result(0, "数据删除成功！");
	}

	// 初始化时间格式
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		// 如果客户端传递yyyy-MM-dd格式的字符串，就当做java.util.Date类型处理
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
