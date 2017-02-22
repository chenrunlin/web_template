package com.bsit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsit.mapper.SysRoleMapper;
import com.bsit.model.SysRole;
import com.bsit.service.SysRoleServiceI;

/**
 * @ClassName :  
 * @Description :  
 */
@Service(value="sysRoleService")
public class SysRoleServiceImpl implements SysRoleServiceI {

	@Autowired
	private SysRoleMapper sysRoleMapper;
 	
 	/**
	 * 添加对象
	 */
 	public void saveSysRole(SysRole sysRole){
 		sysRoleMapper.saveSysRole(sysRole);
 	}
 	
 	/**
	 * 根据id修改对象属性
	 */
 	public void updateSysRole(SysRole sysRole){
 		sysRoleMapper.updateSysRole(sysRole);
 	}
 	
 	/**
	 * 根据id修改角色功能
	 */
	@Override
	public void updateRoleFun(SysRole sysRole) {
		sysRoleMapper.updateRoleFun(sysRole);
	}
 	
 	/**
	 * 根据id获取对象
	 */
 	public SysRole getSysRoleById(String id){
 		return sysRoleMapper.getSysRoleById(id);
 	}
 	
 	/**
	 * 获取所有对象
	 */
 	public List<SysRole> getTotalSysRoleList(){
 		return sysRoleMapper.getTotalSysRoleList();
 	}
 	
 	/**
	 * 根据条件获取对象
	 */
 	public List<SysRole> getSysRoleListByCondition(Map<String, String> condition){
 		return sysRoleMapper.getSysRoleListByCondition(condition);
 	}
 	
 	/**
	 * 根据id删除对象
	 */
 	public void deleteSysRoleById(String id){
 		sysRoleMapper.deleteSysRoleById(id);
 	}

 	/**
	 * 根据type获取对象
	 */
	@Override
	public List<SysRole> getSysRoleByType(String type) {
		return sysRoleMapper.getSysRoleByType(type);
	}

}

