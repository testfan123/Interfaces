<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adduser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=path %>/css/houtai.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=path %>/js/jquery-3.3.1.min.js"></script>

  </head>
  
  <body>
   <div id="tanchuk">
  <div class="tan_top"></div>
  <div class="tan_main">
  <form action="case/update.do" method="post">
  	<input type="hidden" name="uuid" value="${data.uuid}">
	<table class="tck" width="213" border="0" cellspacing="0" cellpadding="0">
	   <tr bgcolor=white><td align=right>部&nbsp;&nbsp;门：</td><td>
		<select name="system">
			<c:forEach items="${systemData}" var="d">
				<option value="${d.systemid}" ${data.system==d.systemid? "selected":""}>${d.systemname}</option>
			</c:forEach>
		</select>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>用例名称：</td><td>
		<input class="text_yhm" name="casename" value="${data.casename}" onblur="checkdulname(this.value)" maxlength="32"/><span id="checkname_error"></span>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>地址：</td><td>
			&nbsp;&nbsp;<textarea name="url" style="width:220px;">${data.url}</textarea>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>类型：</td><td>
		  <select name="type">
			 <option value="get"   ${data.type=='get'? "selected":""}>get</option>
			  <option value="post"  ${data.type=='post'? "selected":""}>post</option>
			 <option value="postjson" ${data.type=='postjson'? "selected":""}>postjson</option>
		</select>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>头部：</td><td>
			<input class="text_yhm" name="header" maxlength="32" value="${data.header}"/>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>参数：</td><td>
			<input class="text_yhm" name="params" maxlength="32" value="${data.params}"/>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>检查点：</td><td>
			&nbsp;&nbsp;<textarea name="checkpoint">${data.checkpoint}</textarea>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>关联：</td><td>
			&nbsp;&nbsp;<textarea name="correlation">${data.correlation}</textarea>
		</td></tr>
		<tr bgcolor=white><td class="tc_w108" align=right>开启：</td><td>
		  <select name="run">
			 <option value="Y" ${data.run=='Y'? "selected":""}>是</option>
			 <option value="N" ${data.run=='N'? "selected":""}>否</option>
		</select>
		</td></tr>
		<tr bgcolor=white><td colspan="2" align=center>
			<input type="submit" value="确定" class="queren"/><input type="button" value="取消" class="quxiao" onclick="hiden()"/>
		</td></tr>
	</table>
</form>
</div>
<div class="tan_bottom" style="position: absolute;"></div>
</div>
  </body>
</html>