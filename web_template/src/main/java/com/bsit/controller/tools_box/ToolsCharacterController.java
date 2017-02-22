package com.bsit.controller.tools_box;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tools")
public class ToolsCharacterController{
	
	@RequestMapping(value="/tools_character", method = RequestMethod.GET)
	public String tools_character(Model model, HttpServletResponse response) throws Exception {
		return "/tools_box/tools_character";
	}

	
 	
}