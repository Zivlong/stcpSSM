package com.stx.service;

import javax.servlet.http.HttpServletRequest;

import com.stx.model.Type;

public interface TypeService {
	void select(HttpServletRequest request);
	void save(Type type);
	void delete(HttpServletRequest request);
	void selectById(HttpServletRequest request);
	void update(Type type);
}
