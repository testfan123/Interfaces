package cn.springmvc.utils;

import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import cn.springmvc.model.TestCase;


public class InterceptorUtils {
	
	public static void doBefore(TestCase tescase) {
		if(StringUtils.isEmpty(tescase.getBeforefunc())) {
			return;
		}
		tescase.setBeforefunc(RegexMatches.replace(tescase.getBeforefunc()));
		Map<String, Object> beforeMap=MapUtils.covertStringToMp2(tescase.getBeforefunc());
		Set<String> keys =beforeMap.keySet();
		for (String key : keys) {
			if(key.contains("md5")) {
				String codecvalue =DigestUtils.md5Hex(beforeMap.get(key).toString());
				CorrelationUtils.addCorrelationKeyValue(key, codecvalue);
			}if(key.contains("sha1")) {
				String codecvalue =DigestUtils.sha512Hex(beforeMap.get(key).toString());
				CorrelationUtils.addCorrelationKeyValue(key, codecvalue);
			}
		}
	}
	
//	public static void doAfer(TestCase tescase) {
//		if("数据1要在数据2".equals(tescase.getBeforeFunc())) {
//			
//		}
//	}
//	
	
	public static void doAfter(TestCase tescase) {
//		if("id2包含id1") {
//			
//		}
	}
	

}
