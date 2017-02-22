package com.bsit.common.consts;

public enum Status {
	
	STATUS_OK("1", "访问成功"), STATUS_ERROR("-1", "访问错误"),
	
	USER_STATUS_LOGIN_INFO_IS_ERROR("1001", "用户名或密码错误"), 
	USER_STATUS_LOGIN_ACCOUNT_NOT_EXIST("1002", "账号不存在");
	
	
	private String code;
	
	private String msg;

	private Status(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
