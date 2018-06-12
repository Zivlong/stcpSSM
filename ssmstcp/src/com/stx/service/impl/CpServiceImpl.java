package com.stx.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.stx.mapper.CpMapper;
import com.stx.mapper.TypeMapper;
import com.stx.model.Cp;
import com.stx.model.Cuser;
import com.stx.model.PageModel;
import com.stx.service.CpService;
import com.stx.util.FileUtil;
@Service
@Transactional
public class CpServiceImpl implements CpService{
	@Resource
	private CpMapper cpmapper;
	
	@Resource
	private TypeMapper typemapper;

	public void selectByUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//获取登陆对象
		Cuser user=(Cuser)request.getSession().getAttribute("USER");
		
		
		
		//获取当前页数
		String page_now=request.getParameter("page_now");
		if(page_now==null){
			page_now="1";
		}
		//字符串转换成数字
		int pagenow=Integer.parseInt(page_now);
		
		
		
		//获取数据总条数
		int count=cpmapper.getCountByUser(user.getId());
		
		
		
		
		
		//创建分页类对象
		PageModel page=new PageModel();
		//设置分页信息----要修改的信息
		page.setPage("cp/selectbyuser",count,pagenow,5);
		//调取当前分页的开始条数
		int start=(page.getPage_now()-1)*page.getPage_size();
		//每页查询数据条数
		int length=page.getPage_size();
		//将开始条数和每页展示条数存放于map对象
		Map map=new HashMap();
		map.put("start", start);
		map.put("length",length );
		map.put("uid", user.getId());
		
		
		List list=cpmapper.selectByUser(map);
		
		//将数据list封装到request对象
		request.setAttribute("cps", list);
		//将分页对象封装到request对象
		request.setAttribute("page", page);
	}

	public void save(Cp cp,HttpServletRequest request) {
		// TODO Auto-generated method stub
		//设定主键的值
		cp.setId(UUID.randomUUID().toString());
		//获取登录对象，通过对象来获取uid
		Cuser user=(Cuser)request.getSession().getAttribute("USER");
		cp.setUid(user.getId());
		//上传图片，将图片的保存地址返回
		String pic=FileUtil.upload(cp.getUploadFile(), request);
		cp.setPic(pic);
		//获取制定格式的日期字符串
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String time = format.format(new Date());
        cp.setCreatetime(time);
        //设定阅读量的值
        cp.setYdl(0);
        cpmapper.save(cp);
	}

	public void getType(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List list=typemapper.selectAll();
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getCpById(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//获取id
		String id=request.getParameter("id");
		//调用mapper层查询原始数据
		Cp cp=cpmapper.selectById(id);
		//将原始数据封装到request对象
		request.setAttribute("cp", cp);
	}

	public void update(Cp cp,HttpServletRequest request) {
		// TODO Auto-generated method stub
		MultipartFile file=cp.getUploadFile();
		System.out.println(file.getSize());
		if(file.getSize()>0){
			String pic=FileUtil.upload(cp.getUploadFile(), request);
			cp.setPic(pic);
		}
		cpmapper.update(cp);
		

	}
}
