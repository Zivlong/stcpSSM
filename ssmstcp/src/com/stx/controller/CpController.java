package com.stx.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stx.model.Cp;
import com.stx.service.CpService;

@Controller
@RequestMapping("/cp")
public class CpController {
	@Autowired
	private CpService service;
	@RequestMapping("/selectbyuser")
	public String selectByUser(HttpServletRequest request){
		service.selectByUser(request);
		return "/page/cp_list.jsp";
	}
	@RequestMapping("/save")
	public String save(Cp cp,HttpServletRequest request){
		service.save(cp, request);
		return "redirect:/cp/selectbyuser";
	}
	@RequestMapping("/gettype")
	public void getType(HttpServletRequest request,HttpServletResponse response){
		service.getType(request, response);
	}
	@RequestMapping("/getcpbyid")
	public String getCpById(HttpServletRequest request){
		//控制层调用服务层方法
		service.getCpById(request);
		//接下来创建编辑页面，编辑页面和新增页面很相似，所以。。。。你们知道怎么做了！！！！
		return "/page/cp_edit.jsp";
	}
	@RequestMapping("/update")
	public String update(Cp cp,HttpServletRequest request){
		service.update(cp, request);
		return "redirect:/cp/selectbyuser";
	}
}
