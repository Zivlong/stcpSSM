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
		//��ȡ��ǰҳ��
		String page_now=request.getParameter("page_now");
		if(page_now==null){
			page_now="1";
		}
		//�ַ���ת��������
		int pagenow=Integer.parseInt(page_now);
		//��ȡ����������
		int count=mapper.getCount();
		//������ҳ�����
		PageModel page=new PageModel();
		//���÷�ҳ��Ϣ----Ҫ�޸ĵ���Ϣ
		page.setPage("type/select",count,pagenow,5);
		//��ȡ��ǰ��ҳ�Ŀ�ʼ����
		int start=(page.getPage_now()-1)*page.getPage_size();
		//ÿҳ��ѯ��������
		int length=page.getPage_size();
		//����ʼ������ÿҳչʾ���������map����
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
