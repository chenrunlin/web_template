package com.bsit.controller.tools_box;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsit.common.properties.ParamProperties;
import com.bsit.common.utils.DateUtil;
import com.bsit.common.utils.StringUtil;
import com.bsit.common.utils.qrcode.QrcodeImgUtil;

@Controller
@RequestMapping("/tools")
public class ToolsQrCodeController{
	
	@RequestMapping(value="/tools_qrcode", method = RequestMethod.GET)
	public String tools_qrcode(Model model, HttpServletResponse response) throws Exception {
		String savePath = ParamProperties.getPropertiesValueByKey("param.properties", "qrcode_save_path");
		String imgName = "qr_code.png";
		String fullPath = savePath + File.separator + imgName;
		model.addAttribute("qr_path", fullPath);
		return "/tools_box/tools_qrcode";
	}
	
	@RequestMapping(value="/create_qrcode", method = RequestMethod.POST)
	@ResponseBody
	public String create_qrcode(Model model, HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String text = request.getParameter("text");			//内容
		String level = request.getParameter("level");		//纠错级别
		String scale = request.getParameter("scale");		//尺寸
		String margin = request.getParameter("margin");		//边距
		String isTrans = request.getParameter("isTrans");	//背景透明
		//
		String savePath = ParamProperties.getPropertiesValueByKey("param.properties", "qrcode_save_path");
		String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF" + savePath);
		String imgName = "qr-1_" + DateUtil.getCurrentDateTime() + StringUtil.genRandomStr(8) + ".png";
		//
		if (StringUtil.isEmpty(text)) {
			text = "hello world";
		} 
		if (StringUtil.isEmpty(level)) {
			text = "M";
		} 
		if (StringUtil.isEmpty(text)) {
			text = "150";
		} 
		try{
			QrcodeImgUtil.createQrcodeImg(text, level.charAt(0), Integer.parseInt(scale), margin, isTrans, realPath, imgName);
		} catch (Exception e) {
			imgName = "qr_code.png";
		}
		return savePath + File.separator + imgName;
	}
	
	

	
 	
}