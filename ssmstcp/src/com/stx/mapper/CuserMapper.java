package com.stx.mapper;

import java.util.List;
import java.util.Map;

import com.stx.model.Cuser;

public interface CuserMapper {
	void register(Cuser cuser);
	void update(Cuser cuser);
	Cuser login(Cuser cuser);
}
