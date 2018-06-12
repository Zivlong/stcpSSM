package com.stx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stx.model.Type;
import com.stx.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {
	@Autowired
	private TypeService service;
	@RequestMapping("/select")
	public String select(HttpServletRequest request){
		service.select(request);
		return "/page/t_list.jsp";
	}
	@RequestMapping("/save")
	public String save(Type type){
		service.save(type);
		return "redirect:/type/select";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request){
		service.delete(request);
		return "redirect:/type/select";
	}
	@RequestMapping("/selectbyid")
	public String selectById(HttpServletRequest request){
		service.selectById(request);
		return "/page/t_edit.jsp";
	}
	@RequestMapping("/update")
	public String update(Type type){
		service.update(type);
		return "redirect:/type/select";
	}
}






