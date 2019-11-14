package cn.springmvc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
/**
 * 关联工具类
 */
import com.alibaba.fastjson.JSONPath;

import cn.springmvc.model.TestCase;

public class CorrelationUtils {

	

	private static ThreadLocal<Map<String, Object>> correlationMp = new ThreadLocal<Map<String, Object>>() {
		public Map<String, Object> initialValue() {
			return new LinkedHashMap<String, Object>();
		}
	};


	public static void replace(TestCase testcase) {
		if (testcase.getUrl() != null) {
			testcase.setUrl(RegexMatches.replace(testcase.getUrl()));
		}

		if (testcase.getHeader() != null) {
			testcase.setHeader(RegexMatches.replace(testcase.getHeader()));
		}
		if (testcase.getParams() != null) {
			testcase.setParams(RegexMatches.replace(testcase.getParams()));
		}
	}


	public static Object getCorrelationValue(String key) {
		Object value =correlationMp.get().get(key);
		if (value==null) {
			return "";
		}
		return value;
	}
	
	public static void clear() {
		correlationMp.get().clear();
	}

	public static void addCorrelationKeyValue(String key, Object value) {
		correlationMp.get().put(key, value);
		System.out.println("addCorrelationKeyValue " + correlationMp);
	}

	/**
	 * 将对象放到map
	 * 
	 * @param bean
	 */
	public static void addCorrelationObject(Object bean) {
		  //map数据类型
		if (bean instanceof Map) {
			Map<String, Object> map = (Map) bean;
			Set<String> keys = map.keySet();
			for (String key : keys) {
				correlationMp.get().put(key, map.get(key));
			}
		} else {
			// 普通对象 反射类的属性
			Field[] fields = bean.getClass().getDeclaredFields();
			for (Field f : fields) {
				try {
					if("serialVersionUID".equals(f.getName())) {
						continue;
					}
					correlationMp.get().put(f.getName(), BeanUtils.getProperty(bean, f.getName()));
				} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("addCorrelationObject " + correlationMp);
	}

	/**
	 * 提取json 数据到map
	 * 
	 * @param json
	 * @param correlation
	 */
	public static void addCorrelation(String json, String correlation) {
		if (StringUtils.isEmpty(json) || StringUtils.isEmpty(correlation)) {
			return;
		}
		Map<String, Object> paramMp = MapUtils.covertStringToMp2(correlation);
		Set<String> keys = paramMp.keySet();
		for (String key : keys) {
			Object jsonObject = JSONPath.read(json, paramMp.get(key).toString());
			// 多值处理
			if (jsonObject instanceof List) {
				List<Object> list = (List<Object>) jsonObject;
				int count = 0;
				for (Object object : list) {
					correlationMp.get().put(key + "_g" + count++, object);
				}
			} else {
				// 单个
				correlationMp.get().put(key, jsonObject);
			}

		}
		System.out.println(correlationMp);
	}

	public static void main(String[] args) {
		// String mString =
		// "{\"msg\":\"登录成功\",\"uid\":\"E2BBEDC09FAA4406B8D85C96DF6281CF\",\"code\":\"1\"}";
		// String save = "id=$.uid;mymsg=$.msg";

		String jsonString2 = "{\"code\":\"1\",\"data\":[{\"name\":\"testfan0\",\"pwd\":\"pwd0\"},{\"name\":\"testfan1\",\"pwd\":\"pwd1\"},{\"name\":\"testfan2\",\"pwd\":\"pwd2\"}]}";
		String save = "name=$..name;pwd=$..pwd";
		addCorrelation(jsonString2, save);
		TestCase testCase = new TestCase();
		testCase.setUrl("http://www.baidu.com?pid=${id}&test=${name_g1}");
		replace(testCase);
		System.out.println(JSON.toJSONString(testCase));
	}

}
