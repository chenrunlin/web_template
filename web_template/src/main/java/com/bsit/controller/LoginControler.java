package com.bsit.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsit.common.consts.Constants;
import com.bsit.common.consts.Status;
import com.bsit.common.utils.DateUtil;
import com.bsit.common.utils.TcpUtil;
import com.bsit.common.utils.WebUtil;
import com.bsit.common.utils.encrypt.MD5Util;
import com.bsit.common.utils.json.SingleObject;
import com.bsit.model.SysUser;
import com.bsit.service.SysUserServiceI;

@Controller
@RequestMapping("/login")
public class LoginControler {
	
	private static Logger logger = LogManager.getLogger(LoginControler.class);
	
	@Autowired
	private SysUserServiceI userService;

	@RequestMapping(method = RequestMethod.GET)
	public String tologin(Model model, HttpServletResponse response) throws Exception {
		return "/login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public SingleObject<String> login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception{
		
		SingleObject<String> singleObject = new SingleObject<String>();
    	
		String userName = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	SysUser user = userService.getSysUserByUserName(userName);
    	
    	if(user == null) {
    		singleObject.setStatusObject(Status.USER_STATUS_LOGIN_ACCOUNT_NOT_EXIST);
    	} else {
    		if (MD5Util.md5(password).equals(user.getPassword())) {
    			WebUtil.setSessionAttr(Constants.USER_SESSION_KEY, user);
        		//修改用户信息
        		user.setLogin_time(DateUtil.formatFromDateTime(new Date()));
    			user.setLogin_times(Integer.parseInt(user.getLogin_times()) + 1 + "" );
        		userService.updateSysUser(user);
        		singleObject.setStatusObject(Status.STATUS_OK);
        		
        		String ip = TcpUtil.getIpAddress(request);
        		logger.info("login successful, The user ip is : " + ip);
    		} else {
    			singleObject.setStatusObject(Status.USER_STATUS_LOGIN_INFO_IS_ERROR);
    		}
    	}
    	return singleObject;
//    	ResponseUtils.renderJson(response, JsonWriter.toJson(singleObject, true));
	}
}
