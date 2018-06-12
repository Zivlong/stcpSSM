package com.stx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.model.Cp;

public interface CpService {
	void selectByUser(HttpServletRequest request);
	void save(Cp cp,HttpServletRequest request);
	void getType(HttpServletRequest request,HttpServletResponse response);
	void getCpById(HttpServletRequest request);
	void update(Cp cp,HttpServletRequest request);
}
