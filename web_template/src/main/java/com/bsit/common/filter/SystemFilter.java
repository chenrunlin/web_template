package com.bsit.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bsit.common.utils.WebUtil;
import com.bsit.model.SysUser;

public class SystemFilter implements Filter {

	// 不过滤的请求集合
	private String noFilterReqStr[];
	// 登录页面请求
	private String toLoginReq;

	public void init(FilterConfig filterConfig) throws ServletException {
		String ignorePathStr = filterConfig.getInitParameter("noFilterReq");
		toLoginReq = filterConfig.getInitParameter("toLoginReq");
		if (null != ignorePathStr) {
			noFilterReqStr = ignorePathStr.split(";");
		}
	}

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		SysUser user = WebUtil.getUser();

		String reqPath = request.getServletPath(); // 当前请求的路径
		String url = String.valueOf(request.getRequestURL()); // 当前请求的全路径
		String uri = request.getRequestURI(); // 项目名称+当前请求路径
		String contextPath = request.getContextPath(); // 项目名称

		// 包含，不需要过滤
		// 如果用户信息为空，就转到登录界面
		if (need2Filter(noFilterReqStr, reqPath)) {
			if ("/".equals(reqPath)) {
				url = url.replace(uri, "");
				//	response.sendRedirect(url + contextPath + toLoginReq);
				response.getWriter().write("<script>top.location.href = '" + url + contextPath + toLoginReq + "'</script>");
			} else {
				chain.doFilter(req, res);
			}
		}
		// 需要过滤
		else {
			// 还未登录，返回登录
			if (user == null) {
				url = url.replace(uri, "");
				//	response.sendRedirect(url + contextPath + toLoginReq);
				response.getWriter().write("<script>top.location.href = '" + url + contextPath + toLoginReq + "'</script>");
			} else {// 已经登录，可直接访问
				chain.doFilter(req, res);
			}
		}
	}

	/**
	 * 是否要进行过滤 ,/;/logon;/static/;/register true 包含，不需要过滤 false 不包含,需要过滤
	 * */
	private boolean need2Filter(String[] ignorePath, String reqPath) {
		boolean flag = false;
		if (reqPath.equals("/")) {
			flag = true;
		} else {
			if (null != ignorePath && ignorePath.length > 0) {
				// "/" 不做处理,故从1开始
				for (int i = 1; i < ignorePath.length; i++) {
					// 如果不需过滤的请求集合包含 要请求的地址
					if (reqPath.contains(ignorePath[i])) {// 包含
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}
}
