package com.stx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stx.model.Cuser;
import com.stx.service.CuserService;

@Controller
@RequestMapping("/cuser")
public class CuserController {
	@Autowired
	private CuserService service;
	@RequestMapping("/register")
	public String register(HttpServletRequest request,Cuser cuser){
		service.register(request, cuser);
		return "/page/login.jsp";
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Cuser cuser){
		boolean b=service.login(request, cuser);
		if(b){
			return "/index.jsp";
		}else{
			return "/page/login.jsp";
		}
		
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		request.getSession().removeAttribute("USER");
		return "/index.jsp";
	}
	
	
}
