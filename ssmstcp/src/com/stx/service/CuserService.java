package com.stx.service;

import javax.servlet.http.HttpServletRequest;

import com.stx.model.Cuser;

public interface CuserService {
	void register(HttpServletRequest request,Cuser cuser);
	boolean login(HttpServletRequest request,Cuser cuser);
}
