package cn.springmvc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.springmvc.utils.SpringFreemarkerUtils;

@RunWith(SpringRunner.class)
@SpringBootTest  //springboot junit单元测试
public class FreemarkerTest {
	
	@Test
	public void test() {
        Map<String,Object> map = new HashMap<String, Object>();
    	String strValue = "this is String";
		Date myDate  = new Date();
		Object[] objectArray = new Object[]{1,"str",1.2};
		Set<Object> setData = new HashSet<Object>();
		setData.add("dataValue1");
		setData.add("dataValue2");
		setData.add("dataValue3");
		
		List<String> strList = new ArrayList<String>();
		strList.add("字符串1");
		strList.add("字符串2");
		strList.add("字符串3");
		
		Map<String, Object> paramMp = new HashMap<String, Object>();
		paramMp.put("key1", "value1");
		paramMp.put("key2", "value2");
		paramMp.put("key3", "value3");
		
		map.put("strValue", strValue);
		map.put("objectArray", objectArray);
		map.put("strList", strList);
		map.put("paramMp", paramMp);
		map.put("myDate", myDate);
		map.put("setData", setData);
		//从当前spring获取freemarker jstl标签更简化 不需要request 模板替换技术
		String reString  = SpringFreemarkerUtils.covertMapToFileString(map, "test.ftl");
		System.out.println(reString);
		try {
			FileUtils.write(new File("test-new.xml"), reString,"utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
