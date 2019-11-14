package cn.springmvc.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.springmvc.model.CaseSystem;
import cn.springmvc.model.Function;
import cn.springmvc.service.ICaseSystemService;

@Controller
@RequestMapping(value = "/system")
public class CaseSystemController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ICaseSystemService caseSystemService;
	
	@RequestMapping(value = "/list.do")
	public String systemlist(Integer pag,Integer pagesize) {
		request.setAttribute("data", caseSystemService.list(pag,pagesize));
		return "system/systemList";
	}
	
	@RequestMapping(value = "/add.do")
	public String addfunc(CaseSystem system) throws UnsupportedEncodingException{
		caseSystemService.add(system);
		return "redirect:list.do";
	}

	@RequestMapping(value = "/toadd.do")
	public String toadd(){
		//request.setAttribute("objs", funcService.toadd());
		return "system/addSystem";
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(String id){
		caseSystemService.delete(id);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/toupdate.do")
	public String toupdatefunc(String id){
		request.setAttribute("data", caseSystemService.getById(id));
		return "system/updateSystem";
	}
	
	@RequestMapping(value = "/update.do")
	public String updatefunc(CaseSystem system){
		caseSystemService.update(system);
		return "redirect:list.do";
	}

}
