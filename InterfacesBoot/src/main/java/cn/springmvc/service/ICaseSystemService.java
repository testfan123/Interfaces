package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.CaseSystem;


public interface ICaseSystemService {
	
	
	public Map<String,Object> list(Integer pag,Integer pagesize);
	public int add(CaseSystem system);
	public CaseSystem getById(String id);
//	public Map<String,Object> toupdate(String funcid);
	public int update(CaseSystem obj);
	public int delete(String id);
	
	public List<CaseSystem> getAll();
//	public String checkname(String name);
}
