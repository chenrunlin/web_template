package com.bsit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bsit.common.consts.Constants;
import com.bsit.common.utils.WebUtil;
import com.bsit.model.LeftMenu;
import com.bsit.model.SysFunction;
import com.bsit.service.SysFunctionServiceI;
import com.bsit.service.SysRoleServiceI;

@Controller
@RequestMapping("/sysInit")
public class SysInitController{
	
	@Autowired
	private SysRoleServiceI sysRoleService;
	@Autowired
	private SysFunctionServiceI sysFunctionService;
	
	@RequestMapping(value="/init", method = RequestMethod.GET)
	public String to_list(Model model){
		Map<String, String> condition = new HashMap<String, String>(); 		//定义一个map
		//根节点
		condition.put("condition", "where t.f_fun_level = '0'");
		List<SysFunction> funList = sysFunctionService.getSysFunctionListByCondition(condition);
		if (null == funList || funList.size() == 0) {
			return "index";
		}
		List<LeftMenu> menus = new ArrayList<LeftMenu>();
		for (SysFunction rootFun : funList) {
			//一级节点
			List<SysFunction> sonList = sysFunctionService.getSonFunctionByPid(rootFun.getId());
			if(null == sonList || sonList.size() == 0) {
				break ;
			}
			for (SysFunction sonFun : sonList) {
				LeftMenu menu = new LeftMenu();
				//二级节点
				List<SysFunction> grandSonList = sysFunctionService.getSonFunctionByPid(sonFun.getId());
				if(null == sonList || sonList.size() == 0) {
					break ;
				}
				
				List<SysFunction> sonMenus = new ArrayList<SysFunction>();
				for (SysFunction grandSonFun : grandSonList) {
					LeftMenu grandSonMenu = new LeftMenu();
					grandSonMenu.setMenu(grandSonFun);
					sonMenus.add(grandSonFun);
				}
				menu.setMenu(sonFun);
				menu.setSonMenu(grandSonList);
				menus.add(menu);
			}
		}
		model.addAttribute("menus", menus);
		return "index";
	}
	
	@RequestMapping(value="/blank", method=RequestMethod.GET)
    public String blank(){
    	return "blank";
    } 
	
    @RequestMapping(value="/exit", method=RequestMethod.GET)
    public String exitSys(){
    	WebUtil.removeSessionAtt(Constants.USER_SESSION_KEY);
    	return "login";
    }  

}