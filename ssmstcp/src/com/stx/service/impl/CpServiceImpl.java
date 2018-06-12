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
		//��ȡ��½����
		Cuser user=(Cuser)request.getSession().getAttribute("USER");
		
		
		
		//��ȡ��ǰҳ��
		String page_now=request.getParameter("page_now");
		if(page_now==null){
			page_now="1";
		}
		//�ַ���ת��������
		int pagenow=Integer.parseInt(page_now);
		
		
		
		//��ȡ����������
		int count=cpmapper.getCountByUser(user.getId());
		
		
		
		
		
		//������ҳ�����
		PageModel page=new PageModel();
		//���÷�ҳ��Ϣ----Ҫ�޸ĵ���Ϣ
		page.setPage("cp/selectbyuser",count,pagenow,5);
		//��ȡ��ǰ��ҳ�Ŀ�ʼ����
		int start=(page.getPage_now()-1)*page.getPage_size();
		//ÿҳ��ѯ��������
		int length=page.getPage_size();
		//����ʼ������ÿҳչʾ���������map����
		Map map=new HashMap();
		map.put("start", start);
		map.put("length",length );
		map.put("uid", user.getId());
		
		
		List list=cpmapper.selectByUser(map);
		
		//������list��װ��request����
		request.setAttribute("cps", list);
		//����ҳ�����װ��request����
		request.setAttribute("page", page);
	}

	public void save(Cp cp,HttpServletRequest request) {
		// TODO Auto-generated method stub
		//�趨������ֵ
		cp.setId(UUID.randomUUID().toString());
		//��ȡ��¼����ͨ����������ȡuid
		Cuser user=(Cuser)request.getSession().getAttribute("USER");
		cp.setUid(user.getId());
		//�ϴ�ͼƬ����ͼƬ�ı����ַ����
		String pic=FileUtil.upload(cp.getUploadFile(), request);
		cp.setPic(pic);
		//��ȡ�ƶ���ʽ�������ַ���
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String time = format.format(new Date());
        cp.setCreatetime(time);
        //�趨�Ķ�����ֵ
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
		//��ȡid
		String id=request.getParameter("id");
		//����mapper���ѯԭʼ����
		Cp cp=cpmapper.selectById(id);
		//��ԭʼ���ݷ�װ��request����
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
