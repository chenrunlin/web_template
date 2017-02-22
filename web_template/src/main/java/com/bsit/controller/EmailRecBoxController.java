package com.bsit.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/email")
public class EmailRecBoxController{
	
	@RequestMapping(value="/rec_list", method = RequestMethod.GET)
	public String rec_list(Model model, HttpServletResponse response) throws Exception {
		return "/box_email/box_email_rec";
	}
	
	@RequestMapping(value="/write", method = RequestMethod.GET)
	public String write(Model model, HttpServletResponse response) throws Exception {
		return "/box_email/box_email_write";
	}
	
 	
}