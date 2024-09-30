package com.java1234.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java1234.entity.User;
import com.java1234.util.StringUtil;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



/**
 * 用户Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * 用户登录判断
	 * @param imageCode
	 * @param user
	 * @param bindingResult
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public Map<String,Object> login(String imageCode,@Valid User user,BindingResult bindingResult,HttpSession session){
		Map<String,Object> map=new HashMap<String,Object>();
		if(StringUtil.isEmpty(imageCode)){
			map.put("success", false);
			map.put("errorInfo", "请输入验证码!");
			return map;
		}
		if(!session.getAttribute("checkcode").equals(imageCode)){
			map.put("success", false);
			map.put("errorInfo", "验证码输入错误!");
			return map;
		}
		if(bindingResult.hasErrors()){
			map.put("success", false);
			map.put("errorInfo", bindingResult.getFieldError().getDefaultMessage());
			return map;
		}
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), user.getPassword());
		try{
			subject.login(token);
			map.put("success", true);
			return map;
		}catch(Exception e){
			e.printStackTrace();
			map.put("success", false);
			map.put("errorInfo", "用户名或者密码错误!");
			return map;
		}
	}
}
