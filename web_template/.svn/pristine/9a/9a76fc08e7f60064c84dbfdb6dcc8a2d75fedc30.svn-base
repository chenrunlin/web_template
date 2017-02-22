package com.bsit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bsit.common.utils.DateUtil;
import com.bsit.common.utils.StringUtil;
import com.bsit.common.utils.encrypt.MD5Util;
import com.bsit.model.SysRole;
import com.bsit.model.SysUser;
import com.bsit.service.SysRoleServiceI;
import com.bsit.service.SysUserServiceI;

@Controller
@RequestMapping("/sysUser")
public class SysUserController{

	private static Logger logger = LogManager.getLogger(SysUserController.class);
	@Autowired
	private SysUserServiceI sysUserService;
	@Autowired
	private SysRoleServiceI sysRoleService;
	
	/**
	 * @Description: 用户管理页面
	 */
	@RequestMapping(value="to_list", method = RequestMethod.GET)
	public String to_list(Model model){
		return "sys_manage/sys_user_list";
	}
	
	/**
	 * @Description: 获取列表
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="getSysUserList", method = RequestMethod.POST)
	@ResponseBody
	public List<SysUser> getSysUserList(HttpServletRequest request) throws Exception{
		List<SysUser> sys_userList = new ArrayList<SysUser>();
		sys_userList = sysUserService.getTotalSysUserList();
		return sys_userList;
	}
	
	/**
	 * @Description: 到添加页面
	 */
	@RequestMapping(value = "to_add", method = RequestMethod.GET)
	public String to_add(Model model){
		return "sys_manage/sys_user_add";
	}
	
	/**
	 * @Description: 到修改页面
	 */
	@RequestMapping(value = "to_update/{id}", method = RequestMethod.GET)
	public String to_update(@PathVariable("id") String id, Model model){
		if(StringUtil.isEmpty(id)){
			logger.error("功能修改：主键为空");
			return "fail";
		}else{
			SysUser sys_user = sysUserService.getSysUserById(id);
			model.addAttribute("sys_user", sys_user);
			return "sys_manage/sys_user_add";
		}
	}
	
	/**
 	 * 保存
	 * @throws Exception 
 	 */
 	@RequestMapping(value = "saveSysUser", method = RequestMethod.POST)
	public String saveSysUser(SysUser sys_user) throws Exception {
		if (sys_user == null) {
			logger.error("用户保存：用户对象为空");
			return "fail";
		} else {
			sys_user.setCreate_time(DateUtil.formatFromDateTime(new Date()));
			if(StringUtil.isEmpty(sys_user.getId())) {
				sys_user.setId(UUID.randomUUID().toString());
				sys_user.setLogin_times("0");
				sys_user.setStatus("0"); 
				sys_user.setLogin_time("0000-00-00 00:00:00");
				sys_user.setPassword(MD5Util.md5(sys_user.getPassword()));
				sysUserService.saveSysUser(sys_user);
			} else {
				SysUser user = sysUserService.getSysUserById(sys_user.getId());
				if(user != null){
					user.setUsername(sys_user.getUsername());
					user.setRole_id(sys_user.getRole_id());
					user.setPassword(MD5Util.md5(sys_user.getPassword()));
					sysUserService.updateSysUser(user);
				}
			}
		}
		return "sys_manage/sys_user_list";
	}
	
	/**
 	 * @Description: 删除
 	 * @return String
 	 */
 	@RequestMapping(value = "/deleteSysUser" , method = RequestMethod.POST)
 	@ResponseBody
	public String deleteSysUser(@RequestParam(value="id", required=true) String id, Model model) {
		if(StringUtil.isEmpty(id)){
			logger.error("功能删除：id为空");
			return "fail";
		}else{
			sysUserService.delete_sys_user(id);
			return "success";
		}
	}
 	
 	@RequestMapping(value = "/getTotalRoleList" , method = RequestMethod.POST)
 	@ResponseBody
 	public List<SysRole> getTotalRoleList(){
 		List<SysRole> sys_roleList = new ArrayList<SysRole>();
 		sys_roleList = sysRoleService.getTotalSysRoleList();
		return sys_roleList;
 	}
	
}
