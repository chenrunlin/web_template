package com.bsit.common.utils.json;

import com.bsit.common.consts.Status;
import com.bsit.common.utils.DateUtil;

public class AbstractJsonObject implements java.io.Serializable {

	private static final long serialVersionUID = -9220795754053729481L;
	
	// 异常信息代码
	private String code;
	// 异常信息
	private String msg;
	// 异常信息时间
	@SuppressWarnings("unused")
	private String time;
	
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
	public String getTime() {
		return DateUtil.getNow();
	}
	public void setStatusObject(Status statusObject) {
		this.code = statusObject.getCode();
		this.msg = statusObject.getMsg();
	}

}
