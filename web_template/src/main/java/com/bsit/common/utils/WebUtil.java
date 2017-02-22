package com.bsit.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bsit.common.consts.Constants;
import com.bsit.model.SysUser;

public class WebUtil {

	/**
	 * @MethodName:
	 * @Description:
	 * @author : chenrl
	 * @data: 2015年4月22日 上午11:14:50
	 * @param
	 * @return：
	 */
	public static SysUser getUser() {
		HttpServletRequest request = getRequest();
		return (SysUser) request.getSession().getAttribute(
				Constants.USER_SESSION_KEY);
	}

	/**
	 * 获取request请求
	 */
	public static HttpServletRequest getRequest() {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) ra)
				.getRequest();
		return request;
	}

	/**
	 * 设置session信息
	 * 
	 * */
	public static void setSessionAttr(String key, Object val) {
		if (!StringUtil.isEmpty(key)) {
			HttpServletRequest request = getRequest();
			request.getSession().setAttribute(key, val);
		} else {
			throw new NullPointerException("key or val is null !...");
		}
	}

	/**
	 * 移除session
	 */
	public static void removeSessionAtt(String key) {
		if (!StringUtil.isEmpty(key)) {
			HttpServletRequest request = getRequest();
			request.getSession().removeAttribute(key);
		} else {
			throw new NullPointerException("key is null...");
		}
	}

	public static String getRealPath(String basepath) {
		HttpServletRequest request = getRequest();
		String realPath = request.getSession().getServletContext()
				.getRealPath(basepath);
		return realPath;
	}

	public static int getMax(int[] values) {
		int tmp = Integer.MIN_VALUE;
		if (null != values) {
			tmp = values[0];
			for (int i = 0; i < values.length; i++) {
				if (tmp < values[i]) {
					tmp = values[i];
				}
			}
		}
		return tmp;
	}

	public static String getCurrentTime(String str) {
		String strcurrenttime = "";
		SimpleDateFormat format = new SimpleDateFormat(str);
		if (format != null) {
			strcurrenttime = format.format(new Date());
		}
		return strcurrenttime;
	}

	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date()));
	}
}
