package cn.springmvc.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.listener.ObjectCache;
import cn.springmvc.model.TParmeters;
import cn.springmvc.model.TestCase;
import cn.springmvc.service.impl.BaseService;

@Controller
@RequestMapping(value = "/parmeters")
public class TestParmetersController {
	
	@Resource(name="parmetersService")
	BaseService testCaseService;
	
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value = "/list.do")
	public String caselist(Integer pag,Integer pagesize) {
		request.setAttribute("data", testCaseService.list(pag,pagesize));
		return "parmeters/parmetersList";
	}
	
	//页面展现前数据准备
	@RequestMapping(value = "/toadd.do")
	public String toaddcase(){
		return "parmeters/addParmeters";
	}
	
	//addParmeters 点击确认
	@RequestMapping(value = "/add.do")
	public String add(TParmeters tParmeters) {
		tParmeters.setUid(UUID.randomUUID().toString());
		testCaseService.add(tParmeters);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/toupdate.do")
	public String toupdate(String id){
		request.setAttribute("data", testCaseService.getById(id));
		return "parmeters/updateParmeters";
	}

	@RequestMapping(value = "/update.do")
	public String update(TParmeters tParmeters){
		testCaseService.update(tParmeters);
		//页面从新加载刷新
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(String Id){
		testCaseService.delete(Id);
		return "redirect:list.do";
	}

}
