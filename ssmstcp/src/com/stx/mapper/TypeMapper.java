package com.stx.mapper;

import java.util.List;
import java.util.Map;

import com.stx.model.Type;



public interface TypeMapper {
	void save(Type type);
	boolean update(Type type);
	boolean delete(String id);
	Type selectById(String id);
	//start:分页查询开始位置
	//length：查询数据的条数
	/*map.put("start",1);
	 *map.put("length",1);
	 * */
	List<Type> select(Map map);
	List<Type> selectAll();
	//获取表内数据总条数
	int getCount();
}
