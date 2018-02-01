package com.bsit.webservice;


import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.bsit.model.SysUser;

public class SysUserWebServiceTest {
	
	private static Logger logger = LogManager.getLogger(SysUserWebServiceTest.class);
	
	private SysUserWebServiceI service;
    
    @Before
    public void initParam()
    {
        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(SysUserWebServiceI.class);
        factoryBean.setAddress("http://localhost:8080/web_template/ws/userWebService?wsdl");
        
        service = (SysUserWebServiceI)factoryBean.create();
    }
    
//    @Test
    public void testGetUser(){
    	SysUser user = service.getSysUserByUserName("admin");
    	if (user == null) {
			logger.info("用户不存在");
		} else {
			logger.info("用户存在，用户名为：" + user.getUsername());
		}
    }

}
