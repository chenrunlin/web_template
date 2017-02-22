package com.bsit.service;

import java.util.List;
import java.util.Map;

import com.bsit.model.SysFunction;

/**
 * @ClassName :  
 * @Description :  
 */
public interface SysFunctionServiceI{

	/**
	 * 添加对象
	 */
	void saveSysFunction(SysFunction sysFunction);
	
	/**
	 * 根据id修改对象属性
	 */
	void updateSysFunction(SysFunction sysFunction);
	
	/**
	 * 根据id获取对象
	 */
	SysFunction getSysFunctionById(String id);
	
	/**
	 * 根据root节点
	 */
	SysFunction getRootFunction();
	
	/**
	 * 根据pid获取子对象
	 */
	List<SysFunction> getSonFunctionByPid(String pid);
	
	/**
	 * 获取所有对象
	 */
	List<SysFunction> getTotalSysFunctionList();
	
	/**
	 * 获取所有父功能
	 */
	List<SysFunction> getTotalParentfunctionList();
	
	/**
	 * 根据条件获取对象
	 */
	List<SysFunction> getSysFunctionListByCondition(Map<String, String> condition);
	
	/**
	 * 根据id获取对象
	 */
	void deleteSysFunctionById(String id);
	
	/**
	 * 根据功能序号获取对象
	 */
	SysFunction validateFunSeq(String fun_seq);
	
	

}

