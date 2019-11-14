package cn.springmvc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.CaseSystemMapper;
import cn.springmvc.dao.FunctionMapper;
import cn.springmvc.model.CaseSystem;
import cn.springmvc.model.CaseSystemCriteria;
import cn.springmvc.service.ICaseSystemService;

@Service
public class CaseSystemServiceImpl implements ICaseSystemService{
	@Autowired
	private CaseSystemMapper caseSystemMapper;
	

	public Map<String, Object> list(Integer pag,Integer pagesize) {
		if(pag==null){
			pag=1;
		}
		if(pagesize==null||pagesize==0){
			pagesize=10;
		}
		Map<String, Object> data=new HashMap<String, Object>();
		
		
	    PageHelper.startPage(pag, pagesize);
	    CaseSystemCriteria example=new CaseSystemCriteria();
		List<CaseSystem> list=caseSystemMapper.selectByExample(example);
	    PageInfo<CaseSystem> pageInfo = new PageInfo<CaseSystem>(list);
		
		data.put("objs", list);
		data.put("pag", pag);
		data.put("total", pageInfo.getPages());
		data.put("pagesize", pagesize);
		return data;
	}


	@Override
	public int add(CaseSystem system) {
		system.setSystemid(UUID.randomUUID().toString());
		return caseSystemMapper.insert(system);
	}


	@Override
	public int delete(String id) {
		return caseSystemMapper.deleteByPrimaryKey(id);
	}


	@Override
	public CaseSystem getById(String id) {
		return caseSystemMapper.selectByPrimaryKey(id);
	}


	@Override
	public int update(CaseSystem obj) {
		return caseSystemMapper.updateByPrimaryKey(obj);
	}


	@Override
	public List<CaseSystem> getAll() {
		return caseSystemMapper.selectByExample(null);
	}

}
