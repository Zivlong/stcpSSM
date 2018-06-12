package com.stx.service.impl;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stx.mapper.CuserMapper;
import com.stx.model.Cuser;
import com.stx.service.CuserService;
import com.stx.util.FileUtil;

@Service
@Transactional
public class CuserServiceImpl implements CuserService{
	@Resource
	private CuserMapper mapper;

	public void register(HttpServletRequest request, Cuser cuser) {
		// TODO Auto-generated method stub
		cuser.setId(UUID.randomUUID().toString());
		cuser.setType("1");
		String pic=FileUtil.upload(cuser.getUploadFile(), request);
		cuser.setPic(pic);
		mapper.register(cuser);
	}

	public boolean login(HttpServletRequest request, Cuser cuser) {
		Cuser user=mapper.login(cuser);
		if(user!=null){
			request.getSession().setAttribute("USER", user);
			return true;
		}else{
			return false;
		}
		
	}
}
