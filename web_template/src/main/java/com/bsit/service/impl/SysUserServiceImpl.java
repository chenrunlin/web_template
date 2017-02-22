package com.bsit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsit.mapper.SysUserMapper;
import com.bsit.model.SysUser;
import com.bsit.service.SysUserServiceI;

/**
 * @ClassName :
 * @Description :
 */
@Service(value = "userService")
public class SysUserServiceImpl implements SysUserServiceI {

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public void saveSysUser(SysUser user){
		userMapper.saveSysUser(user);
	}
	
	@Override
	public SysUser login(Map<String, String> map) {
		return userMapper.login(map);
	}

	@Override
	public SysUser getSysUserById(String id) {
		return userMapper.getSysUserById(id);
	}
	
	@Override
	public SysUser getSysUserByUserName(String userName) {
		return userMapper.getSysUserByUserName(userName);
	}

	@Override
	public List<SysUser> getSysUserListByCondition(Map<String, String> condition) {
		return userMapper.getSysUserListByCondition(condition);
	}

	@Override
	public List<SysUser> getTotalSysUserList() {
		return userMapper.getTotalSysUserList();
	}

	@Override
	public void modifyUserPwd(SysUser sysUser) {
		userMapper.modifyUserPwd(sysUser);
	}

	@Override
	public void updateSysUser(SysUser sysUser) {
		userMapper.updateSysUser(sysUser);
	}

	@Override
	public void delete_sys_user(String id) {
		userMapper.delete_sys_user(id);
	}

}
