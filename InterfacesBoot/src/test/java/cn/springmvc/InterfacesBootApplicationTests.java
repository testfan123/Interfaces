package cn.springmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
/**此处可以是静态引用，也可以不用静态引用，这样就需要在使用方法的时候加上对应的类*/
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.alibaba.fastjson.JSONPath;

import com.alibaba.fastjson.JSONPath;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterfacesBootApplicationTests {

	   @Autowired
	   private WebApplicationContext context;
	   //action web 测试
	   private MockMvc mvc;
	 
	   @Before
	   public void setUp() throws Exception {
	      mvc = MockMvcBuilders.webAppContextSetup(context).build();  //构造MockMvc
	   }
	   
	   //主要作用方便调试
	   @Test
	   public void testReportList() throws Exception {
		     //方式1 
//		      RequestBuilder request = post("/report/result.do")
//		              .contentType(MediaType.APPLICATION_FORM_URLENCODED) //请求类型
//		              .param("pageSize", "10");
//		      
//		      MvcResult mvcResult = mvc.perform(request).andReturn();
//		      int status = mvcResult.getResponse().getStatus();
//		      String content = mvcResult.getResponse().getContentAsString();
//		      System.out.println("返回结果：" + status);
//		      System.out.println(content);
//		      String result =  String.valueOf(JSONPath.read(content, "$.sucess[0]")).trim();
//		      System.out.println(result);
//		      Assert.assertTrue("12".equals(result));
		      
		   //方式2 利用已有的函数 链式写法
	      mvc.perform(post("/report/result.do") // //调用接口
	    		 .contentType(MediaType.APPLICATION_FORM_URLENCODED)
	            .param("pageSize", "10")//传入添加的用户参数 
	            .accept(MediaType.APPLICATION_JSON))  //接收的类型
	            .andExpect(status().isOk())   //判断接收到的状态是否是200
	            .andDo(print())  //打印内容
	            .andExpect(content().string(containsString("sucess")));
	            //.andExpect(jsonPath("$.sucess").isNotEmpty());//使用jsonPath解析返回值，判断具体的内容 

	   }
	   

	@Test
	public void contextLoads() {
	}

}
