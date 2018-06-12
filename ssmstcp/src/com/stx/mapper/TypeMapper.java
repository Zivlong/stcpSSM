package com.stx.mapper;

import java.util.List;
import java.util.Map;

import com.stx.model.Type;



public interface TypeMapper {
	void save(Type type);
	boolean update(Type type);
	boolean delete(String id);
	Type selectById(String id);
	//start:��ҳ��ѯ��ʼλ��
	//length����ѯ���ݵ�����
	/*map.put("start",1);
	 *map.put("length",1);
	 * */
	List<Type> select(Map map);
	List<Type> selectAll();
	//��ȡ��������������
	int getCount();
}
