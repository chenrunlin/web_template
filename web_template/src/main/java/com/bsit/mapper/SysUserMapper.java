package com.bsit.mapper;

import java.util.List;
import java.util.Map;

import com.bsit.model.SysUser;

public interface SysUserMapper {
	
	/**
	 * 添加用户
	 */
	void saveSysUser(SysUser user);
	
	/**
	 * 登录
	 */
	SysUser login(Map<String, String> map);
	
	/**
	 * 根据id获取对象
	 */
	SysUser getSysUserById(String id);
	
	/**
	 * 根据userName获取对象
	 */
	SysUser getSysUserByUserName(String userName);
	
	/**
	 * 根据条件获取对象
	 */
	List<SysUser> getSysUserListByCondition(Map<String, String> condition);
	
	/**
	 * 获取所有对象
	 */
	List<SysUser> getTotalSysUserList();
	
	/**
	 * 修改用户信息
	 */
	void updateSysUser(SysUser sysUser);
	
	/**
	 * 修改用户密码
	 */
	void modifyUserPwd(SysUser sysUser);
	
	/**
	 * 删除用户
	 */
	void delete_sys_user(String id);
	
}
