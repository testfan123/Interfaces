package cn.springmvc.utils;

import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import cn.springmvc.apitest.SpringContextUtils;
import freemarker.template.Template;

public class SpringFreemarkerUtils {
	
	public static String covertMapToFileString(Map<String, Object> map, String fileName) {
		FreeMarkerConfigurer freeMarkerConfigurer = SpringContextUtils.getBean(FreeMarkerConfigurer.class);
		Template template;
		String text = null;
		try {
			template = freeMarkerConfigurer.getConfiguration().getTemplate(fileName);
			// map中的key，对应模板中的${key}表达式
			text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}

}
