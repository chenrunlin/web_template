package com.bsit.mapper;

import java.util.List;
import java.util.Map;

import com.bsit.model.SysRole;

/**
 * @ClassName :  
 * @Description :  
 */
public interface SysRoleMapper{

	/**
	 * 添加对象
	 */
	void saveSysRole(SysRole sysRole);
	
	/**
	 * 根据id修改对象属性
	 */
	void updateSysRole(SysRole sysRole);
	
	/**
	 * 根据id修改角色功能
	 */
	void updateRoleFun(SysRole sysRole);
	
	/**
	 * 根据id获取对象
	 */
	SysRole getSysRoleById(String id);
	
	/**
	 * 根据type获取对象
	 */
	List<SysRole> getSysRoleByType(String type);
	
	/**
	 * 获取所有对象
	 */
	List<SysRole> getTotalSysRoleList();
	
	/**
	 * 根据条件获取对象
	 */
	List<SysRole> getSysRoleListByCondition(Map<String, String> condition);
	
	/**
	 * 根据id获取对象
	 */
	void deleteSysRoleById(String id);

}
