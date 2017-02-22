package com.bsit.webservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsit.mapper.SysUserMapper;
import com.bsit.model.SysUser;
import com.bsit.webservice.SysUserWebServiceI;

@Service("userWebService")
public class SysUserWebServiceImpl implements SysUserWebServiceI{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getSysUserByUserName(String username) {
		return sysUserMapper.getSysUserByUserName(username);
	}

}
