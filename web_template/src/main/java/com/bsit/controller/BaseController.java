package com.bsit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base")
public class BaseController{

	@RequestMapping("/{folder}/{file}")
    public String jsp(@PathVariable(value = "folder") String folder, @PathVariable(value = "file") String file) {
        return folder + "/" + file;
    }
	
}
