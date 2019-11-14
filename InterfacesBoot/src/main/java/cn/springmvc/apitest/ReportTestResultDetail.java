package cn.springmvc.apitest;

import cn.springmvc.model.TestCase;
import cn.springmvc.model.TestResultDetail;

/**
 * 数据扩展
 * @author pc
 *
 */
public class ReportTestResultDetail extends TestResultDetail{
	
	private static final long serialVersionUID = 8311254426819244683L;
	private TestCase testcase;
	
	public TestCase getTestcase() {
		return testcase;
	}
	public void setTestcase(TestCase testcase) {
		this.testcase = testcase;
	}


}
