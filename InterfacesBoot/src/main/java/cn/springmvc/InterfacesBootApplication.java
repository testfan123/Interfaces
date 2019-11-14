package cn.springmvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import cn.springmvc.listener.CacheLilter;

@SpringBootApplication
@ServletComponentScan
@MapperScan("cn.springmvc.dao")
@EnableScheduling
//读取传统bean
@ImportResource(value={
		"classpath:/META-INF/serverContext.xml",
})
public class InterfacesBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterfacesBootApplication.class, args);
	}

	@Bean // 注册Listener
	public ServletListenerRegistrationBean<CacheLilter> servletListenerRegistrationBean() {
		return new ServletListenerRegistrationBean<CacheLilter>(new CacheLilter());
	}

//	@Bean // 注册Filter
//	public FilterRegistrationBean filterRegistrationBean() {
//		return new FilterRegistrationBean(new LoginFilter());
//	}
}
