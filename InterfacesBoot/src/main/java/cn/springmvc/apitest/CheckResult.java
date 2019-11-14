package cn.springmvc.apitest;

/**
 * 检查点枚举使用  高级的静态类
 * @author
 *
 */
public enum CheckResult {
	
	SUCCESS(true, "检查点检查成功"), 
	FAIL(false, "检查点检查失败"), 
	SKIP(false, "没有设置检查点"),
	ISVALID(true, "不是json格式数据"),
	EMPTY(false, "检查值提取为空，校验失败"),
	DBERROR(false, "数据库检查点失败"),
	DBSKIP(true, "没有设置数据库检查点"),
	DBFAIL(false, "数据库检查失败");
	
	
	
	private boolean result;
    private String msg;
    
	
	private CheckResult(boolean result, String msg) {
		this.result = result;
		this.msg = msg;
	}
	
	public boolean isResult() {
		return result;
	}
	
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
