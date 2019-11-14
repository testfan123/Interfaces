package cn.springmvc.service;

import java.util.List;
import java.util.Map;

import cn.springmvc.model.TestCase;

public interface ITestCaseService {

	Map<String, Object> list(Integer pag, Integer pagesize);
	
	void delete(String caseId);

	void add(TestCase testcase);

	TestCase getById(String caseId);

	int update(TestCase testCase);

}