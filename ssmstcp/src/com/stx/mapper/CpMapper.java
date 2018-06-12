package com.stx.mapper;

import java.util.List;
import java.util.Map;

import com.stx.model.Cp;
import com.stx.model.Type;



public interface CpMapper {
	void save(Cp cp);
	boolean update(Cp cp);
	boolean delete(String id);
	Cp selectById(String id);
	//start:分页查询开始位置
	//length：查询数据的条数
	/*map.put("start",1);
	 *map.put("length",1);
	 *map.put("uid",1);
	 * */
	List<Cp> selectByUser(Map map);
	int getCountByUser(String uid);
	/*map.put("start",1);
	 *map.put("length",1);
	 *map.put("tid",1);
	 * */
	List<Cp> selectByType(Map map);
	int getCountByType(String tid);
	/*map.put("start",1);
	 *map.put("length",1);
	 * */
	List<Cp> selectAll(Map map);
	int getCount();
}
