package cn.springmvc.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.springmvc.apitest.ApiTest;
import cn.springmvc.listener.ObjectCache;
import cn.springmvc.model.TestCase;
import cn.springmvc.service.ITestCaseService;


@Controller
@RequestMapping(value = "/case")
public class TestCaseAction {

	@Autowired
	private HttpServletRequest request;
	
//	@Autowired
//	private ITestCaseService testCaseService;
	
	@Autowired
	private ITestCaseService testCaseService;
	
	
	@RequestMapping(value = "/caselist.do")
	public String caselist(Integer pag,Integer pagesize) {
		System.out.println("pag "+pag +" pagesize"+pagesize);
		request.setAttribute("data", testCaseService.list(pag,pagesize));
		return "case/caseList";
	}
	
	@RequestMapping(value = "/delete.do")
	public String delete(String caseId){
		testCaseService.delete(caseId);
		return "redirect:caselist.do";
	}
	
	@RequestMapping(value = "/toaddCase.do")
	public String toaddcase(){
		request.setAttribute("data", ObjectCache.getAllSystem());
		return "case/addCase";
	}
	
	
	@RequestMapping(value = "/addcase.do")
	public String addcase(TestCase testCase) {
		testCase.setUuid(UUID.randomUUID().toString());
		testCaseService.add(testCase);
		return "redirect:caselist.do";
	}
	
	
	@RequestMapping(value = "/toupdate.do")
	public String toupdate(String caseId){
		request.setAttribute("data", testCaseService.getById(caseId));
		request.setAttribute("systemData", ObjectCache.getAllSystem());
		//request.setAttribute("systemData", DeptCache.getAllDept());
		return "case/updateCase";
	}

	@RequestMapping(value = "/update.do")
	public String update(TestCase testCase){
		testCaseService.update(testCase);
		//页面从新加载刷新
		return "redirect:caselist.do";
	}
	
	@RequestMapping(value = "/apitest.do")
	public String testApi(String caseId) {
		System.out.println("caseId "+caseId);
		TestCase testCase = testCaseService.getById(caseId);
		if(testCase!=null) {
		String result=	ApiTest.testCase(testCase);
		//结果保存到数据库
		testCase.setTestresult(result);
		testCaseService.update(testCase);
	 }
	 return "redirect:caselist.do";
	}
	
}
