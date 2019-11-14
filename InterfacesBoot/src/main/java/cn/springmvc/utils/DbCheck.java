package cn.springmvc.utils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;

import cn.springmvc.apitest.CheckResult;
import cn.springmvc.apitest.SpringContextUtils;
import cn.springmvc.model.TestCase;


public class DbCheck {

	public static CheckResult check(TestCase testcase) {
		if (StringUtils.isEmpty(testcase.getDbchecksql()) || StringUtils.isEmpty(testcase.getDbexpected())) {
			return CheckResult.DBSKIP;
		}
		String newsql = RegexMatches.replaceForString(testcase.getDbchecksql());
		testcase.setDbchecksql(newsql);
		testcase.setDbexpected(RegexMatches.replace(testcase.getDbexpected()));
		JdbcTemplate jdbcTemplate=SpringContextUtils.getBean(JdbcTemplate.class);
		//QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			System.out.println(testcase.getDbchecksql());
			//Map map = runner.query(testcase.getDbchecksql(), new MapHandler());
			Map map=jdbcTemplate.queryForMap(testcase.getDbchecksql());
			if (map == null || map.isEmpty()) {
				return CheckResult.DBFAIL;
			}
			String jsonStr = JSON.toJSONString(map);
			System.out.println("数据库json---" + jsonStr);
			CheckResult checkResult = CheckPointUtils.check(jsonStr, testcase.getDbexpected());
			return checkResult;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String addSingleQuotes(String str) {
		return "'" + str + "'";
	}

	public static void main(String[] args) {
		String mString = "{\"msg\":\"登录成功\",\"uid\":\"test111\",\"code\":\"1\"}";
		String save = "id=$.uid;mymsg=$.msg";
		CorrelationUtils.addCorrelation(mString, save);

		TestCase testCase = new TestCase();
		String sql = "select uid from t_user where uid=${id}";
		testCase.setDbchecksql(sql);
		testCase.setDbexpected("$.uid=test");
		CheckResult checkResult = check(testCase);
		System.out.println(" check " + checkResult + " msg__ " + checkResult.getMsg());
		System.out.println(JSON.toJSONString(testCase));

	}

}
