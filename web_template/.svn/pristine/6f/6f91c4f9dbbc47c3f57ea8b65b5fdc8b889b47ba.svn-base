package com.bsit.controller.tools_box;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsit.common.utils.encrypt.MD5Util;

@Controller
@RequestMapping("/tools")
public class ToolsCommonController{
	
	@RequestMapping(value="/tools_common", method = RequestMethod.GET)
	public String tools_common(Model model, HttpServletResponse response) throws Exception {
		return "/tools_box/tools_common";
	}
	
	@RequestMapping(value="/tools_ref", method = RequestMethod.GET)
	public String tools_ref(Model model, HttpServletResponse response) throws Exception {
		return "/tools_box/tools_reference";
	}
	
	@RequestMapping(value="/tools_format", method = RequestMethod.GET)
	public String tools_format(Model model, HttpServletResponse response) throws Exception {
		return "/tools_box/tools_format";
	}
	
	
	@RequestMapping(value="/md5", method = RequestMethod.POST)
	@ResponseBody
	public String md5(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String text = request.getParameter("text");
		String half = request.getParameter("half");
    	if(half.equals("16")) {
    		return MD5Util.md516(text);
    	}
    	return MD5Util.md5(text);
	}
	
	@RequestMapping(value="/uuid", method = RequestMethod.POST)
	@ResponseBody
	public String uuid(Model model, HttpServletResponse response){
    	return UUID.randomUUID().toString();
	}
 	
}