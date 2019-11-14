package cn.springmvc.apitest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cn.springmvc.dao.TParmetersMapper;
import cn.springmvc.dao.TestCaseMapper;
import cn.springmvc.model.TParmeters;
import cn.springmvc.model.TestCase;
import cn.springmvc.model.TestCaseCriteria;
import cn.springmvc.model.TestResultDetail;
import cn.springmvc.utils.CheckPointUtils;
import cn.springmvc.utils.CorrelationUtils;
import cn.springmvc.utils.DbCheck;
import cn.springmvc.utils.HttpClientUtils;
import cn.springmvc.utils.InterceptorUtils;
import cn.springmvc.utils.MapUtils;

//没有和spring集成
public class ApiTest {
	// 最终结果,保留到数据库
	public static List<TestResultDetail> alldetailResult = new ArrayList<TestResultDetail>();
	public static int testPassed = 0;
	public static int testFailed = 0;
	public static int testSkip = 0;
	public static Date runtime;
	public static String resultId;

	@Test(dataProvider = "apitest")
	public void parameterIntTest(TParmeters coverage) {
		System.out.println(Thread.currentThread().getName() + " " + coverage);
		// 添加关联数据
		CorrelationUtils.addCorrelationObject(coverage);
		List<TestResultDetail> detailsResult = new ArrayList<TestResultDetail>();
		// 从数据库查询testcase
		TestCaseMapper testCaseMapper = SpringContextUtils.getBean(TestCaseMapper.class);
		TestCaseCriteria c = new TestCaseCriteria();
		c.createCriteria().andRunEqualTo("Y");
		List<TestCase> totestList = testCaseMapper.selectByExample(c);
		for (TestCase testCase : totestList) {
			//TestResultDetail testResultDetail = new TestResultDetail();
			ReportTestResultDetail testResultDetail = new ReportTestResultDetail();
			if ("Y".equals(testCase.getRun())) {
				long start = System.currentTimeMillis();
				String http_result = null;
				String checkresult = null;
				try {
					// 前置处理器
					InterceptorUtils.doBefore(testCase);
					// 关联替换
					CorrelationUtils.replace(testCase);
					System.out.println(testCase);
					if ("get".equalsIgnoreCase(testCase.getType())) {
						http_result = HttpClientUtils.doGet(testCase.getUrl(),  
								MapUtils.covertStringToMp2(testCase.getHeader()));
					} else if ("post".equalsIgnoreCase(testCase.getType())) {
						http_result = HttpClientUtils.doPost(testCase.getUrl(), 
						        MapUtils.covertStringToMp1(testCase.getParams()),
								MapUtils.covertStringToMp2(testCase.getHeader()));
					} else if ("postjson".equalsIgnoreCase(testCase.getType())) {
						http_result = HttpClientUtils.doPostJson(testCase.getUrl(), testCase.getParams(),
								MapUtils.covertStringToMp2(testCase.getHeader()));
					}
					System.out.println(http_result);
					CorrelationUtils.addCorrelation(http_result, testCase.getCorrelation());
					// 结果检查
					CheckResult resultCheck = CheckPointUtils.check(http_result, testCase.getCheckpoint());
					// 数据库检查
					CheckResult dbcheckResult=DbCheck.check(testCase);
					
					if((resultCheck==CheckResult.SUCCESS||resultCheck==CheckResult.SKIP)&&(dbcheckResult==CheckResult.SUCCESS||dbcheckResult==CheckResult.DBSKIP)) {
						testPassed++;
						testResultDetail.setFlag("Y");
					}if(resultCheck==CheckResult.FAIL||dbcheckResult==CheckResult.DBFAIL) {
						testFailed++;
						testResultDetail.setFlag("N");
					}
					
					String allcheckResult =resultCheck.getMsg()+";"+dbcheckResult.getMsg();
					testResultDetail.setCheckResult(allcheckResult);
					System.out.println(resultCheck);
					
				}catch (Exception e) {
					e.printStackTrace();
					checkresult=e.getLocalizedMessage();//获取异常信息  
					System.out.println(" exception "+checkresult);
					testResultDetail.setFlag("N");
					testFailed++;
				} finally {
					long time = System.currentTimeMillis() - start;
					testResultDetail.setResultDetailId(UUID.randomUUID().toString());
					testResultDetail.setCaseId(testCase.getUuid());
					testResultDetail.setCaseDesc(testCase.getUrl());
					testResultDetail.setSystem(testCase.getSystem());
					testResultDetail.setResultId(resultId);
					testResultDetail.setTaketime(time);
					testResultDetail.setRuntime(runtime);
					if(checkresult==null) {
						checkresult="出异常了";
					}
					testResultDetail.setCheckResult(checkresult);
					
					testResultDetail.setTestcase(testCase);
					//保留当前结果
					detailsResult.add(testResultDetail);
				}
			}else {
				testSkip++;
			}
		}
		CorrelationUtils.clear();
		alldetailResult.addAll(detailsResult);
	}

	@DataProvider(name = "apitest", parallel = true)
	public Iterator<Object[]> coverageProvider() {
		List<Object[]> dataProvider = new ArrayList<Object[]>();
//		List<Map<String, Object>> list = getCoveragemap();
//		for (Map<String, Object> map : list) {
//			dataProvider.add(new Object[] { map });
//		}
		
		List<TParmeters>  list =getParmeters();
		for (TParmeters tParmeters : list) {
			dataProvider.add(new Object[] { tParmeters });
		}
		return dataProvider.iterator();
	}


	
	private List<TParmeters> getParmeters() {
		TParmetersMapper tParmetersMapper = SpringContextUtils.getBean(TParmetersMapper.class);
		return tParmetersMapper.selectByExample(null);
	}
	

	private List<Map<String, Object>> getCoveragemap() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("loginname", "abc");
		map.put("loginpass", "abc");
		list.add(map);
		return list;
	}
	

	public static String testCase(TestCase testCase) {
		// 关联替换
		String http_result=null;
		//CorrelationUtils.replace(testCase);
		try {
		System.out.println(testCase);
		if ("get".equalsIgnoreCase(testCase.getType())) {
			http_result = HttpClientUtils.doGet(testCase.getUrl(),  
					MapUtils.covertStringToMp2(testCase.getHeader()));
		} else if ("post".equalsIgnoreCase(testCase.getType())) {
			http_result = HttpClientUtils.doPost(testCase.getUrl(), 
			        MapUtils.covertStringToMp1(testCase.getParams()),
					MapUtils.covertStringToMp2(testCase.getHeader()));
		} else if ("postjson".equalsIgnoreCase(testCase.getType())) {
			http_result = HttpClientUtils.doPostJson(testCase.getUrl(), testCase.getParams(),
					MapUtils.covertStringToMp2(testCase.getHeader()));
		}
		// 结果检查
		if(http_result!=null) {
			CheckResult resultCheck = CheckPointUtils.check(http_result, testCase.getCheckpoint());
			http_result = resultCheck.getMsg();
		}
		}catch (Exception e) {
			http_result=e.getMessage();
		}
		return http_result;
	}


}
