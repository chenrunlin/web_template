package com.bsit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsit.mapper.SysFunctionMapper;
import com.bsit.model.SysFunction;
import com.bsit.service.SysFunctionServiceI;

/**
 * @ClassName :  
 * @Description :  
 */
@Service(value="sysFunctionService")
public class SysFunctionServiceImpl implements SysFunctionServiceI {

	@Autowired
	private SysFunctionMapper sysFunctionMapper;
 	
 	/**
	 * 添加对象
	 */
 	public void saveSysFunction(SysFunction sysFunction){
 		sysFunctionMapper.saveSysFunction(sysFunction);
 	}
 	
 	/**
	 * 根据id修改对象属性
	 */
 	public void updateSysFunction(SysFunction sysFunction){
 		sysFunctionMapper.updateSysFunction(sysFunction);
 	}
 	
 	/**
	 * 根据id获取对象
	 */
 	public SysFunction getSysFunctionById(String id){
 		return sysFunctionMapper.getSysFunctionById(id);
 	}
 	
	public SysFunction getRootFunction() {
		return sysFunctionMapper.getRootFunction();
	}

	public List<SysFunction> getSonFunctionByPid(String pid) {
		return sysFunctionMapper.getSonFunctionByPid(pid);
	}
 	
 	/**
	 * 获取所有对象
	 */
 	public List<SysFunction> getTotalSysFunctionList(){
 		return sysFunctionMapper.getTotalSysFunctionList();
 	}
 	
	public List<SysFunction> getTotalParentfunctionList() {
		return sysFunctionMapper.getTotalParentfunctionList();
	}
 	
 	/**
	 * 根据条件获取对象
	 */
 	public List<SysFunction> getSysFunctionListByCondition(Map<String, String> condition){
 		return sysFunctionMapper.getSysFunctionListByCondition(condition);
 	}
 	
 	/**
	 * 根据id获取对象
	 */
 	public void deleteSysFunctionById(String id){
 		sysFunctionMapper.deleteSysFunctionById(id);
 	}

	@Override
	public SysFunction validateFunSeq(String fun_seq) {
		return sysFunctionMapper.validateFunSeq(fun_seq);
	}

}

