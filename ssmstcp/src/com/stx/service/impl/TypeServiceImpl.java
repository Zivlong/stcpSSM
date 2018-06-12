package com.stx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stx.mapper.TypeMapper;
import com.stx.model.PageModel;
import com.stx.model.Type;
import com.stx.service.TypeService;
@Service
@Transactional
public class TypeServiceImpl implements TypeService{
	@Resource
	private TypeMapper mapper;

	public void select(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//获取当前页数
		String page_now=request.getParameter("page_now");
		if(page_now==null){
			page_now="1";
		}
		//字符串转换成数字
		int pagenow=Integer.parseInt(page_now);
		//获取数据总条数
		int count=mapper.getCount();
		//创建分页类对象
		PageModel page=new PageModel();
		//设置分页信息----要修改的信息
		page.setPage("type/select",count,pagenow,5);
		//调取当前分页的开始条数
		int start=(page.getPage_now()-1)*page.getPage_size();
		//每页查询数据条数
		int length=page.getPage_size();
		//将开始条数和每页展示条数存放于map对象
		Map map=new HashMap();
		map.put("start", start);
		map.put("length",length );
		
		List list=mapper.select(map);
		request.setAttribute("types", list);
		request.setAttribute("page", page);
		
	}

	public void save(Type type) {
		// TODO Auto-generated method stub
		type.setId(UUID.randomUUID().toString());
		mapper.save(type);
	}

	public void delete(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		mapper.delete(id);
		
	}

	public void selectById(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		Type type=mapper.selectById(id);
		request.setAttribute("type", type);
	}

	public void update(Type type) {
		// TODO Auto-generated method stub
		mapper.update(type);
	}
}
