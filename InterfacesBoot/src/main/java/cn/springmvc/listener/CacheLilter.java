package cn.springmvc.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.springmvc.model.CaseSystem;
import cn.springmvc.service.ICaseSystemService;


public class CacheLilter implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ICaseSystemService systemService = (ICaseSystemService) WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(ICaseSystemService.class);
		List<CaseSystem> caseSystems = systemService.getAll();
		for (CaseSystem caseSystem : caseSystems) {
			ObjectCache.addCache(caseSystem.getSystemid(), caseSystem);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
