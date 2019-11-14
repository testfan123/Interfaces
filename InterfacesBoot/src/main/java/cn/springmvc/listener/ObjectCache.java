package cn.springmvc.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.springmvc.model.CaseSystem;


public class ObjectCache {
	
	private static Map<String,Object> map =new HashMap<String,Object>();
	
	public static void addCache(String key, Object value){
		map.put(key, value);
	}
	
	public static Object get(String key){
		if(map.containsKey(key)){
			return  map.get(key);
		}
		return null;
	}
	
	public static void removeCache(String key){
		if(map.containsKey(key)){
			map.remove(key);
		}
	}
	
	public static List<CaseSystem> getAllSystem() {
		List<CaseSystem> list = new ArrayList<CaseSystem>();
		Set<String> set = map.keySet();
		for (String key : set) {
			Object object = map.get(key);
			if(object instanceof CaseSystem) {
				list.add((CaseSystem)object);
			}
		}
		return list;
	}
	
	public static String getSystemName(String id) {
		Object object = get(id);
		if(object!=null &&object instanceof CaseSystem) {
			return ((CaseSystem)object).getSystemname();
		}
		return "";
	}

}
