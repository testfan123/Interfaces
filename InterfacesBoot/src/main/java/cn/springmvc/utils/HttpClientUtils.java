package cn.springmvc.utils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {

	private static HttpHost proxy = new HttpHost("192.168.2.219", 8888, "http");
	// 配置信息
	private static RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(30000)
			 //.setProxy(proxy)
			.build();
	// 连接池最大并发连接数
	private static PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
	static {
		manager.setMaxTotal(1000);
	}

	// 实例化CloseableHttpClient对象
	private static CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(manager)
			.setDefaultRequestConfig(defaultRequestConfig).build();

	public static String doGet(String url, Map<String, Object> header) {
		// 默认配置，包括连接池
		// CloseableHttpClient httpclient = HttpClients.createDefault();
		// 构造请求
		HttpGet httpGet = new HttpGet(url);
		HttpEntity httpEntity = null;
		try {
			if (header != null) {
				Set<String> headerSet = header.keySet();
				for (String key : headerSet) {
					httpGet.addHeader(key, header.get(key).toString());
				}
			}
			// 丢到池子里面
			CloseableHttpResponse response = httpclient.execute(httpGet);
			httpEntity = response.getEntity();
			// 处理返回结果
			String result = EntityUtils.toString(httpEntity, "utf-8");
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭连接
				EntityUtils.consume(httpEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 重载
	public static String doPost(String url, Map<String, Object> params) {
		return doPost(url, params, null);
	}
	
	public static String doPost(String url, Map<String, Object> params, Map<String, Object> header) {
		HttpEntity reponseHttpEntity = null;
		try {
			HttpPost httpPost = new HttpPost();
			httpPost.setURI(new URI(url));
			// 设置头部
			if (header != null) {
				Set<String> headerSet = header.keySet();
				for (String key : headerSet) {
					httpPost.addHeader(key, header.get(key).toString());
				}
			}
			// 设置参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			if(params!=null&&!params.isEmpty()) {
				Set<String> keys = params.keySet();
				for (String key : keys) {
					Object value = params.get(key);
					nvps.add(new BasicNameValuePair(key, value.toString()));
				}
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
			}
			

			HttpResponse response = httpclient.execute(httpPost);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) { // 请求成功
				reponseHttpEntity = response.getEntity();
				String result = EntityUtils.toString(reponseHttpEntity, "utf-8");

				return result;
			} else { //
				System.out.println("状态码：" + code);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		} finally {
			try {
				// 关闭连接
				EntityUtils.consume(reponseHttpEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * post请求（用于请求json格式的参数）
	 * 
	 * @param url
	 * @param params
	 * @param header
	 * @return
	 */
	public static String doPostJson(String url, String params, Map<String, Object> header) {
		HttpPost httpPost = new HttpPost(url);// 创建httpPost
		// httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		String charSet = "UTF-8";
		StringEntity entity = new StringEntity(params, charSet);
		httpPost.setEntity(entity);
		CloseableHttpResponse response = null;
		HttpEntity responseEntity = null;
		try {
			// 设置头部
			if (header != null) {
				Set<String> headerSet = header.keySet();
				for (String key : headerSet) {
					httpPost.addHeader(key, header.get(key).toString());
				}
			}
			response = httpclient.execute(httpPost);
			StatusLine status = response.getStatusLine();
			int state = status.getStatusCode();
			if (state == HttpStatus.SC_OK) {
				responseEntity = response.getEntity();
				String jsonString = EntityUtils.toString(responseEntity);
				return jsonString;
			} else {
				// logger.error("请求返回:"+state+"("+url+")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(responseEntity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String[] args) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("method", "loginMobile");
//		params.put("loginname", "abc");
//		params.put("loginpass", "abc");
//		String result = doPost("http://118.24.13.38:8080/goods/UserServlet", params);
//		System.out.println(result);

		System.out.println(doPostJson("http://118.24.13.38:8080/goods/json2", "{\"count\":3}", MapUtils.covertStringToMp2("token=61b3590090982a0185dda9d3bd793b46")));
	}

}
