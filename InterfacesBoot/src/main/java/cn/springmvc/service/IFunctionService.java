package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.Function;


public interface IFunctionService {
	
	
	public Map<String,Object> list(Integer pag,Integer pagesize);
	public int add(Function func);
	public List<Function> toadd();
	public Map<String,Object> toupdate(String funcid);
	public int update(Function obj);
	public int delete(String id);
	public String checkname(String name);
}
