package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.TestResult;
import cn.springmvc.model.TestResultDetail;

public interface ITestResultService {

	List<TestResult> getTestReuslt(int pagesize);
	
	public void addResult(TestResult result, List<TestResultDetail> details);

}