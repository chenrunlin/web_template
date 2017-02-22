package com.bsit.common.utils.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class SHAUtils {
	
	static Logger logger = LoggerFactory.getLogger(SHAUtils.class);
	
	public static String sign(String content) {
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder();
		return shaPasswordEncoder.encodePassword(content, null);
	}
		
	public static boolean verify(String content, String sign) {
		if(logger.isDebugEnabled()) {
			logger.debug("verify(..) IN => {content: " + content + ", sign: " + sign + "}");
		}
		try {
			String signed = sign(content);
			if(logger.isDebugEnabled()) {
				logger.debug("verify(..) content => " + content + ", content sign => " + signed);
			}
			return signed.equals(sign);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = "123456";
		System.out.println(SHAUtils.sign(s));
	}
}
