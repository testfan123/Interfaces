package cn.springmvc.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.FuncroleMapper;
import cn.springmvc.dao.FunctionMapper;
import cn.springmvc.dao.RoleMapper;
import cn.springmvc.model.Funcrole;
import cn.springmvc.model.Function;
import cn.springmvc.model.FunctionCriteria;
import cn.springmvc.model.Role;
import cn.springmvc.model.RoleCriteria;
import cn.springmvc.service.IFunctionService;


@Service
public class FunctionServiceImpl implements IFunctionService {
	@Autowired
	private FunctionMapper funcmapper;
	
	@Autowired
	private RoleMapper rolemapper;
	
	@Autowired
	private FuncroleMapper funcRole;
	
	public int add(Function func) {
		func.setFuncid(UUID.randomUUID().toString());
		RoleCriteria example=new RoleCriteria();
		example.createCriteria().andStatusEqualTo("super");
		List<Role> roles=rolemapper.selectByExample(example);
		for(Role r:roles){
			Funcrole fr=new Funcrole();
			fr.setFuncid(func.getFuncid());
			fr.setRoleid(r.getRoleid());
			fr.setFuncroleid(UUID.randomUUID().toString());
			funcRole.insert(fr);
		}
		return funcmapper.insert(func);
	}

	public String checkname(String funcname) {
		FunctionCriteria criteria=new FunctionCriteria();
		criteria.createCriteria().andFuncnameEqualTo(funcname);
		List<Function> objs=funcmapper.selectByExample(criteria);
		String s="";
		if(objs.size()>0){
			s="Y";
		}else{
			s="N";
		}
		return s;
	}

	public int delete(String funcid) {
		return funcmapper.deleteByPrimaryKey(funcid);
	}

	public Map<String, Object> list(Integer pag,Integer pagesize) {
		if(pag==null){
			pag=1;
		}
		if(pagesize==null||pagesize==0){
			pagesize=10;
		}
		Map<String, Object> data=new HashMap<String, Object>();
		
		
	    PageHelper.startPage(pag, pagesize);
		FunctionCriteria example=new FunctionCriteria();
		example.setOrderByClause("func_order");
		List<Function> list=funcmapper.selectByExample(example);
	    PageInfo<Function> pageInfo = new PageInfo<Function>(list);
		
		FunctionCriteria example_parent=new FunctionCriteria();
		example_parent.createCriteria().andParentidEqualTo("0");
		List<Function> list_parent=funcmapper.selectByExample(example_parent);
		
		data.put("objs", list);
		data.put("funcs", list_parent);
		data.put("pag", pag);
		data.put("total", pageInfo.getPages());
		data.put("pagesize", pagesize);
		return data;
	}

	public List<Function> toadd() {
		FunctionCriteria example=new FunctionCriteria();
		example.createCriteria().andParentidEqualTo("0");
		List<Function> objs=funcmapper.selectByExample(example);
		return objs;
	}

	public Map<String, Object> toupdate(String funcid) {
		Map<String, Object> data=new HashMap<String, Object>();
		Function func=(Function)funcmapper.selectByPrimaryKey(funcid);
		FunctionCriteria example=new FunctionCriteria();
		example.createCriteria().andParentidEqualTo("0");
		List<Function> objs=funcmapper.selectByExample(example);
		data.put("objs", objs);
		data.put("func", func);
		return data;
	}

	public int update(Function func) {
		Function oldfunc=(Function)funcmapper.selectByPrimaryKey(func.getFuncid());
		oldfunc.setFuncname(func.getFuncname());
		oldfunc.setParentid(func.getParentid());
		oldfunc.setUrl(func.getUrl());
		oldfunc.setFuncOrder(func.getFuncOrder());
		return funcmapper.updateByPrimaryKey(oldfunc);
	}
}