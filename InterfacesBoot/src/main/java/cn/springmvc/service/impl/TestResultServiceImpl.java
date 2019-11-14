package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.springmvc.dao.TestResultDetailMapper;
import cn.springmvc.dao.TestResultMapper;
import cn.springmvc.model.TestResult;
import cn.springmvc.model.TestResultCriteria;
import cn.springmvc.model.TestResultDetail;
import cn.springmvc.service.ITestResultService;

@Service
public class TestResultServiceImpl implements ITestResultService {
	
	@Autowired
	TestResultMapper testResultMapper;
	
	@Autowired
	TestResultDetailMapper testResultDetailMapper;
	
	
	@Override
	public List<TestResult> getTestReuslt(int pagesize) {
		PageHelper.startPage(1, pagesize);
		TestResultCriteria example = new TestResultCriteria();
		example.setOrderByClause("runtime desc");
		List<TestResult> list = testResultMapper.selectByExample(example);
		PageInfo<TestResult> pageInfo = new PageInfo<TestResult>(list);
		List<TestResult> pagelist = pageInfo.getList();
		return pagelist;
	}


	@Override
	@Transactional //事务
	public void addResult(TestResult result, List<TestResultDetail> details) {
		System.out.println("add addResult-----"+result);
		testResultMapper.insert(result);
		//扩展批量插入
		testResultDetailMapper.batchInsert(details);
	}
}
