package com.bsit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.alibaba.fastjson.JSONArray;
import com.bsit.common.utils.DateUtil;
import com.bsit.common.utils.StringUtil;
import com.bsit.model.SysFunction;
import com.bsit.model.SysRole;
import com.bsit.model.TreeNode;
import com.bsit.service.SysFunctionServiceI;
import com.bsit.service.SysRoleServiceI;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController{
	
	private static Logger logger = LogManager.getLogger(SysRoleController.class);
	
	@Autowired
	private SysRoleServiceI sysRoleService;
	@Autowired
	private SysFunctionServiceI sysFunctionService;

	/**
	 * @Description: 到列表页面
	 */
	@RequestMapping(value="to_list", method = RequestMethod.GET)
	public String to_list(Model model){
		return "sys_manage/sys_role_list";
	}
	
	/**
	 * @Description: 获取列表
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="getSysRoleList", method = RequestMethod.POST)
	@ResponseBody
	public List<SysRole> getSysRoleList(HttpServletRequest request) throws Exception{
		List<SysRole> sysRoleList = sysRoleService.getTotalSysRoleList();
		return sysRoleList;
	}
	
	/**
	 * @Description: 到添加页面
	 */
	@RequestMapping(value = "to_add", method = RequestMethod.GET)
	public String to_add(Model model){
		return "sys_manage/sys_role_add";
	}
	
	/**
	 * @Description: 到修改页面
	 */
	@RequestMapping(value = "to_update/{id}", method = RequestMethod.GET)
	public String to_update(@PathVariable("id") String id, Model model){
		if(StringUtil.isEmpty(id)){
			logger.error("主键为空");
			return "fail";
		}else{
			SysRole sys_role = sysRoleService.getSysRoleById(id);
			model.addAttribute("sys_role", sys_role);
			return "sys_manage/sys_role_add";
		}
	}
	
	/**
 	 * 保存
 	 */
 	@RequestMapping(value = "saveSysRole", method = RequestMethod.POST)
	public String saveSysRole(SysRole sysRole) {
		if (sysRole == null) {
			logger.error("角色保存：角色对象为空");
			return "fail";
		} else {
			sysRole.setR_role_time(DateUtil.getNow());
			if(StringUtil.isEmpty(sysRole.getId())) {
				sysRole.setId(UUID.randomUUID().toString());
				sysRoleService.saveSysRole(sysRole);
			} else {
				sysRoleService.updateSysRole(sysRole);
			}
		}
		return "sys_manage/sys_role_list";
	}
 	
 	/**
 	 * @Description: 删除
 	 * @return String
 	 */
 	@RequestMapping(value = "/deleteSysRole" , method = RequestMethod.POST)
 	@ResponseBody
	public String deleteSysRole(@RequestParam(value="id", required=true) String id, Model model) {
		if(StringUtil.isEmpty(id)){
			logger.error("角色删除：id为空");
			return "fail";
		}else{
			sysRoleService.deleteSysRoleById(id);
			return "success";
		}
	}
 	
 	/**
 	 * @Description: 前往角色权限分配页面
 	 * @return String
 	 * @throws Exception 
 	 */
 	@RequestMapping(value = "/to_role_fun/{id}" , method = RequestMethod.GET)
 	public String to_role_fun(@PathVariable("id") String id, Model model) throws Exception{
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		Map<String, String> condition = new HashMap<String, String>(); 		//定义一个map
		SysRole role = sysRoleService.getSysRoleById(id);
		//根节点
		condition.put("condition", "where t.f_fun_level = '0'");
		List<SysFunction> funList = sysFunctionService.getSysFunctionListByCondition(condition);
		if (null == funList || funList.size() == 0) {
			return "sys_manage/sys_role_fun";
		}
		for (SysFunction rootFun : funList) {
			//一级节点
			List<SysFunction> sonList = sysFunctionService.getSonFunctionByPid(rootFun.getId());
			if(null == sonList || sonList.size() == 0) {
				break ;
			}
			for (SysFunction sonFun : sonList) {
				TreeNode sonNode = new TreeNode();
				sonNode.setId(sonFun.getId());
				sonNode.setpId(sonFun.getF_fun_pid());
				sonNode.setName(sonFun.getF_fun_name());
				sonNode.setOpen(true);
				treeList.add(sonNode);
				
				//二级节点
				List<SysFunction> grandSonList = sysFunctionService.getSonFunctionByPid(sonNode.getId());
				if(null == sonList || sonList.size() == 0) {
					break ;
				}
				for (SysFunction grandSonFun : grandSonList) {
					TreeNode grandSonNode = new TreeNode();
					grandSonNode.setId(grandSonFun.getId());
					grandSonNode.setpId(grandSonFun.getF_fun_pid());
					grandSonNode.setName(grandSonFun.getF_fun_name());
					grandSonNode.setOpen(true);
					if(!StringUtil.isEmpty(role.getR_fun_ids()) && role.getR_fun_ids().contains(grandSonFun.getId())){
						grandSonNode.setChecked(true);
					}
					treeList.add(grandSonNode);
				}
			}
		}
		SysRole sys_role = sysRoleService.getSysRoleById(id);
		model.addAttribute("sys_role", sys_role);
		model.addAttribute("treeList", JSONArray.toJSON(treeList));
 		return "sys_manage/sys_role_fun";
 	}
 	
 	@RequestMapping(value = "/updateRoleFun", method = RequestMethod.POST)
    @ResponseBody 
 	public String updateRoleFun(@RequestParam(value="id", required=true) String id,
 			@RequestParam(value="funIds", required=true) String funIds){
 		SysRole sys_role = sysRoleService.getSysRoleById(id);
 		sys_role.setR_fun_ids(funIds);
 		sysRoleService.updateRoleFun(sys_role);
 		return "success";
 	}
}