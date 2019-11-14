package cn.springmvc.apitest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.testng.TestNG;

@Component
public class ScheduledApiTest {

	@Scheduled(cron = "0 0/1 * * * ?") // 每天凌晨两点执行 (0 0 2 * * ?)
	void doSomethingWith() {
		System.out.println("doSomethingWith---------");
		ApiTest.runtime = new Date();
		ApiTest.resultId = UUID.randomUUID().toString();
		TestNG testng = new TestNG();
		List<String> suites = new ArrayList<String>();
		File file = null;
		try {
			file = ResourceUtils.getFile("classpath:testng.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		suites.add(file.getPath());// path to xml..
		testng.setTestSuites(suites);
		testng.run();
	}

}
