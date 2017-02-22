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

import com.bsit.common.utils.DateUtil;
import com.bsit.common.utils.StringUtil;
import com.bsit.model.SysFunction;
import com.bsit.model.TreeView;
import com.bsit.service.SysFunctionServiceI;
import com.bsit.service.SysRoleServiceI;
import com.sdicons.json.mapper.JSONMapper;
import com.sdicons.json.mapper.MapperException;

@Controller
@RequestMapping("/sysFunction")
public class SysFunctionController{

	private static Logger logger = LogManager.getLogger(SysFunctionController.class);
	@Autowired
	private SysFunctionServiceI sysFunctionService;
	@Autowired
	private SysRoleServiceI sysRoleService;
	
	/**
	 * @throws MapperException 
	 * @Description: 到列表页面
	 */
	@RequestMapping(value="to_list", method = RequestMethod.GET)
	public String to_list(Model model) throws MapperException{
/*		String json = initFunTreeView();
		model.addAttribute("treeView", json);*/
		return "sys_manage/sys_function_list";
	}
	
	/**
	 * @Description: bootstrap-treeView 获取功能树
	 * @return Map<String,Object>
	 * @throws MapperException 
	 */
	@RequestMapping(value="getSysFunctionTree", method = RequestMethod.POST)
	@ResponseBody
	public String getSysFunctionTree() throws MapperException{
		return initFunTreeView();
	}
	
	/**
	 * @Description: 组织数据成功能树
	 * @return Map<String,Object>
	 * @throws MapperException 
	 */
	private String initFunTreeView() throws MapperException{
		Map<String, String> condition = new HashMap<String, String>(); 		//定义一个map
		//二级菜单
		condition.put("condition", "where t.f_fun_level = '0'");
		List<SysFunction> funList = sysFunctionService.getSysFunctionListByCondition(condition);
		TreeView root = new TreeView();
		if (null == funList || funList.size() == 0) {
			return "";
		}
		for (SysFunction fun : funList) {
			root.setTags(fun.getId());
			root.setText(fun.getF_fun_name());
			List<SysFunction> sonList = sysFunctionService.getSonFunctionByPid(fun.getId());
			if (null != sonList && sonList.size() != 0) {
				for (SysFunction son : sonList) {
					TreeView sonView = new TreeView();
					sonView.setTags(son.getId());
					sonView.setText(son.getF_fun_name());
					root.addChild(sonView);
					
					List<SysFunction> grandSonList = sysFunctionService.getSonFunctionByPid(son.getId());
					if (null != grandSonList && grandSonList.size() != 0) {
						for (SysFunction grandSon : grandSonList) {
							TreeView grandSonView = new TreeView();
							grandSonView.setTags(grandSon.getId());
							grandSonView.setText(grandSon.getF_fun_name());
							sonView.addChild(grandSonView);
						}
					}
				}
			}
		}
		String json = JSONMapper.toJSON(root).render(false);
		return json;
	}
	
	/**
	 * @Description: 获取列表
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="getSysFunctionListById", method = RequestMethod.POST)
	@ResponseBody
	public List<SysFunction> getSysFunctionListById(@RequestParam(value="id", required=true) String id, 
			HttpServletRequest request) throws Exception{
		List<SysFunction> sysFunctionList = new ArrayList<SysFunction>();
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("condition", "where t.id = '" + id + "' or t.f_fun_pid = '" + id + "' order by t.f_fun_level ASC, t.f_fun_time ASC");
		sysFunctionList = sysFunctionService.getSysFunctionListByCondition(condition);
		return sysFunctionList;
	}
	
	/**
	 * @Description: 到添加页面
	 */
	@RequestMapping(value = "to_add", method = RequestMethod.GET)
	public String to_add(Model model){
		return "sys_manage/sys_function_add";
	}
	
	@RequestMapping(value = "loadParentSysFun", method = RequestMethod.GET)
	@ResponseBody
	public List<SysFunction> loadParentSysFun(){
		List<SysFunction> sysFunctionList = new ArrayList<SysFunction>();
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("condition", "where t.f_fun_level = '0' or t.f_fun_level = '1' order by t.f_fun_level ASC, t.f_fun_time ASC");
		sysFunctionList = sysFunctionService.getSysFunctionListByCondition(condition);
		return sysFunctionList;
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
			SysFunction sys_function = sysFunctionService.getSysFunctionById(id);
			model.addAttribute("sys_function", sys_function);
			return "sys_manage/sys_function_add";
		}
	}
	
	/**
 	 * 保存
 	 */
 	@RequestMapping(value = "saveSysFunction", method = RequestMethod.POST)
	public String saveSysFunction(SysFunction sys_function) {
		if (sys_function == null) {
			logger.error("功能保存：功能对象为空");
			return "fail";
		} else {
			SysFunction parFunction = sysFunctionService.getSysFunctionById(sys_function.getF_fun_pid());
			sys_function.setF_fun_level((Integer.parseInt(parFunction.getF_fun_level()) + 1) + "");
			sys_function.setF_fun_time(DateUtil.getNow());
			if(StringUtil.isEmpty(sys_function.getId())) {
				sys_function.setId(UUID.randomUUID().toString());
				sysFunctionService.saveSysFunction(sys_function);
			} else {
				sysFunctionService.updateSysFunction(sys_function);
			}
		}
		return "redirect:/sysFunction/to_list";
	}
	
	/**
 	 * @Description: 删除
 	 * @return String
 	 */
 	@RequestMapping(value = "/deleteSysFunction" , method = RequestMethod.GET)
 	@ResponseBody
	public String deleteSysFunction(@RequestParam(value="id", required=true) String id, Model model) {
		if(StringUtil.isEmpty(id)){
			return "fail";
		}else{
			sysFunctionService.deleteSysFunctionById(id);
			return "success";
		}
	}
 	
 	@RequestMapping(value = "/getTotalParentfunctionList" , method = RequestMethod.POST)
 	@ResponseBody
 	public List<SysFunction> getTotalParentfunctionList(){
 		List<SysFunction> sys_functionList = new ArrayList<SysFunction>();
		sys_functionList = sysFunctionService.getTotalParentfunctionList();
		return sys_functionList;
 	}
	
}
