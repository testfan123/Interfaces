<p>测试时间:${result.runtime?datetime}</p>
<h2><font color="red">接口有错误！</font></h2>
<h1><font color="blue">成功:${result.sucess}</font>&nbsp;&nbsp;<font color="red">失败:${result.fail}</font></h1>
<#list reportlist as report>
         <#if report.flag == 'N'>
            ${report.caseDesc}</br>
		<font color="red"> 错误原因:${(report.checkResult)!'没有数据'}</font>&nbsp;&nbsp;参数：${(report.testcase.params)!''}&nbsp;&nbsp;检查点：${(report.testcase.checkpoint)!''}</br>
		</#if>
</#list>