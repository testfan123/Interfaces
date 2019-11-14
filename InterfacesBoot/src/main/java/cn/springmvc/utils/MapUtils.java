package cn.springmvc.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


public class MapUtils {

	public static Map<String, Object> covertStringToMp1(String str) {
		if(StringUtils.isEmpty(str)) {
			return null;
		}
		Map<String, Object> paramMp = new LinkedHashMap<String, Object>();
		String[] key_array = str.split("&");
		for (String keys : key_array) {
			String[] kStrings = keys.split("=");
			String key = kStrings[0];
			String value = kStrings[1];
			paramMp.put(key, value);
		}
		return paramMp;
	}
	
	public static Map<String, Object> covertStringToMp2(String str) {
		if(StringUtils.isEmpty(str)) {
			return null;
		}
		System.out.println("covertStringToMp2： "+str);
		Map<String, Object> paramMp = new LinkedHashMap<String, Object>();
		String[] key_array = str.split(";");
		for (String keys : key_array) {
			String[] kStrings = keys.split("=");
			String value="";
			String key="";
			if(kStrings.length>1) {
			  key = kStrings[0];
			  value = kStrings[1];
			}
			paramMp.put(key, value);
		}
		return paramMp;
	}

}
