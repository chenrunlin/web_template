package com.bsit.common.utils.encrypt;

import java.net.URLDecoder;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSAUtils {
	
	public static final String RSA_ALGORITHM = "RSA";  
	
	
	private final static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZPuGeEJCAEmFyucFxJDxaoltH" + 
			"Hfzbgao6riTy1UP2kJGWIDsF1N2keqItLyZ9VPx21k5uMqxaOCSQ0uEPihpkdxuY" + 
			"kbAs1FAs3hFUIBupe/DblEYhfuuzLj5b7ZE0pC94RCPtavybVD5PZg5uJ3F3QZdx" +
			"BOMB2HZ64hDEZeY8kwIDAQAB";
	
	private final static String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANk+4Z4QkIASYXK5" + 
			"wXEkPFqiW0cd/NuBqjquJPLVQ/aQkZYgOwXU3aR6oi0vJn1U/HbWTm4yrFo4JJDS" +
			"4Q+KGmR3G5iRsCzUUCzeEVQgG6l78NuURiF+67MuPlvtkTSkL3hEI+1q/JtUPk9m" +
			"Dm4ncXdBl3EE4wHYdnriEMRl5jyTAgMBAAECgYEAvJXcjzU76yGJnGjqJshY6CjG" +
			"ae77QKXH21au1moRrGmFKDhkZESL/ytBu02R8PykiJiyzvCIM21HOL0HCFFPZEpL" +
			"EyKEU8arCknztbICy/ILB8tzHlOKdr+7rAzRalNDlEUVhYpX2Qgc2Tp7UevoPbnO" +
			"DwaDGVLWtoOp/QNSaeECQQD/iDObtF9uqyb+r7rNxlv7QxZPOUuVbNA1BZfJYFJf" +
			"X6Xu97JwiLjOXJP+FlMLZhBZW8Mom77LcxHSTfKVGJojAkEA2aS69YJQhIhE6k+0" +
			"ZNRupi41xbt1BfHNUu2zcLaIYtXKXXHEmziQ/Z0mCF4kbXx9KumhRHHG7qX19WmH" +
			"5mVi0QJAffN1dKbobxUfiGO30NuX1PZRVcVo8wMKcUgLc+/tSiNMF8ixhHRvmw/Y" +
			"xmHclv68yj7HqAl0drWGMEHJcyIIPwJAGS+W8xJBfxTF5NeUaJast05hqqAmyqlQ" +
			"uWgIe+KjpcxXvriLp+rD3JVy8UTzsjfVxEGFCAainrtV2zB7KY5SAQJAbXAD3RbU" +
			"dq9a8keMjG5iU3ZeEaChUokV8eP9Z4oIiijinD4+3ZCBAuxEgu5g9Ss7Bv1ABrgg" +
			"a7kActaL+aI3hw==";
	
	private static KeySpec getPublicKeySpec() {
		byte[] keyBytes = Base64.decode(PUBLIC_KEY);
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        return x509EncodedKeySpec;
	}
	
	private static KeySpec getPrivateKeySpec() {
		byte[] keyBytes = Base64.decode(PRIVATE_KEY);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);    // 取得私钥  
        return pkcs8KeySpec;
	}
	
	// 公钥加密
	public static String encryptByPublicKey(String message) throws Exception {
		byte[] data = message.getBytes("UTF-8");
		KeySpec keySpec = getPublicKeySpec();
		KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(keySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encrypeBytes = cipher.doFinal(data);
		String encryptText = Base64.encode(encrypeBytes);
        return encryptText;
    }  
	
	// 私钥解密
	public static String decryptByPrivateKey(String message) throws Exception {  
		byte[] data = Base64.decode(message);
		KeySpec keySpec = getPrivateKeySpec();
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);          
        Key privateKey = keyFactory.generatePrivate(keySpec);  
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); 
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
        byte[] decryptBytes = cipher.doFinal(data);
        return new String(decryptBytes, "UTF-8");
    }  
	
	// 私钥加密
	public static String encryptByPrivateKey(String message) throws Exception{
		byte[] data = message.getBytes("UTF-8");
		KeySpec keySpec = getPrivateKeySpec();
		KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
		Key privateKey = keyFactory.generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encrypeBytes = cipher.doFinal(data);
		String encryptText = Base64.encode(encrypeBytes);
        return encryptText;
    }
	
	// 公钥解密
	public static String decryptByPublicKey(String message)throws Exception {
		byte[] data = Base64.decode(message);
		KeySpec keySpec = getPublicKeySpec();
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);          
        Key publicKey = keyFactory.generatePublic(keySpec);  
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding"); 
        cipher.init(Cipher.DECRYPT_MODE, publicKey);  
        byte[] decryptBytes = cipher.doFinal(data);  
        return new String(decryptBytes, "UTF-8");
    }
	
//	// 公钥加密
//	public static byte[] encryptByPublicKey(byte[] data) throws Exception {  
//		KeySpec keySpec = getPublicKeySpec();
//		KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
//        Key publicKey = keyFactory.generatePublic(keySpec);
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        return cipher.doFinal(data);
//    }  
//	
//	// 私钥解密
//	public static byte[] decryptByPrivateKey(byte[] data) throws Exception {  
//		KeySpec keySpec = getPrivateKeySpec();
//        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);          
//        Key privateKey = keyFactory.generatePrivate(keySpec);  
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());    // 对数据解密  
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
//        return cipher.doFinal(data);  
//    }
	
	
//	// 私钥加密
//	public static byte[] encryptByPrivateKey(byte[] data) throws Exception{
//		KeySpec keySpec = getPrivateKeySpec();
//        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);          
//        Key privateKey = keyFactory.generatePrivate(keySpec);  
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
//        return cipher.doFinal(data);
//    }
//	
//	// 公钥解密
//	public static byte[] decryptByPublicKey(byte[] data)throws Exception{
//		KeySpec keySpec = getPublicKeySpec();
//		KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
//        Key publicKey = keyFactory.generatePublic(keySpec);
//        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
//        cipher.init(Cipher.DECRYPT_MODE, publicKey);
//        return cipher.doFinal(data);
//    }
	
	private static void iosTest(String text) throws Exception {
		text = URLDecoder.decode(text, "UTF-8");
		String decryptText = decryptByPrivateKey(text);
		System.out.println("解密后的结果=>" + decryptText);
	}
	
	public static void main(String[] args) throws Exception {
//		String message = "Hello，你好，这是什么？";
//		System.out.println("plain=>" + message);
//		byte[] byteMessage = message.getBytes();
//		byte[] byteEncrypt = encryptByPublicKey(byteMessage);
//		System.out.println("encrypt byte => " + byteEncrypt);
//		String encryptMessage = Base64.encode(byteEncrypt);
//		System.out.println("encrypt=>" + encryptMessage);
//		byte[] bytes = Base64.decode(encryptMessage);
//		System.out.println("encrypt byte => " + bytes);
//		byte[] byteDecrypt = decryptByPrivateKey(bytes);
//		System.out.println(new String(byteDecrypt));
		
		
//		String message = "123";
//		System.out.println("加密前的结果=>" + message);
//		String encryptText = encryptByPrivateKey(message);
//		System.out.println("加密后的结果=>" + encryptText);
//		System.out.println("解密后的结果=>" + decryptByPublicKey(encryptText));
		
		iosTest("OJTtUrV5tDE%2B6oMlE1syOlI0SooKJBKVwgtulxmT4KbTEyzQlfjnhp1LhCA5HrVkEevh%2BAxj1FsnmCMfD7jLczUz2iVv%2B%2Fp04iKmBWiluOAb6reZQnzFrix4HQSFJfHHLfQHMqweoFnGhwJcMRw3eDaaXju3FUxLlbc8tnkOeDM%3D");
		iosTest("xbR%2FccRlqwiNiv%2FqFKaSj1nA8dIJ6wbaTYYkVmCYWv%2BLyLgsL%2FD4VDIzkGMsvbWxO%2BX04idQSWlN2w2e8cipI0ASYZI2fa%2FODFAr%2FGm3iWQaeb%2FE3sR%2BT3rgCsgJmWbAs754G8nGygqyOaou5NjHe7pBxcUms4yZKpJO04XxaJ4%3D");
		iosTest("WDG%2FChH6sInSimZUdy6bW8%2Bt3Ztn%2BLFjLKdqAw0rEKQHuYYHQUkwVnikQFVAT3e%2BipUO2TJkp8lAhyOYRG8LgGEDXh0jFyks5O2FfN%2BbV3LOHLxqoyloizVF%2BmO76K2Vs1pp8XEgVTtFjE5zpOAzAN86YOVDk80kWjol2Mn%2FVPU%3D");
		
		iosTest("LzjONfc07SQvyJ7xtAXHrGlpnHp2QfWJ9VvGUOyO9kCD4R5gV%2FgrB%2Fs23qVceiG0wXnwNvSdNyFKxLQmau7QLfrXBLdg5cPIWiYrUal6PHDRLSVUnFFGUHmBMAXPYndPSArUjj%2F04LJniB6RAfaVCHjTg4fRHu2yxiUS6By8h94%3D");
	
	}
	
//	private static Key getPublicKey() throws Exception {
//		byte[] keyBytes = Base64.decode(PUBLIC_KEY);
//        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);
//        Key publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
//        return publicKey;
//	}
//	
//	private static Key getPrivateKey() throws Exception {
//		byte[] keyBytes = Base64.decode(PRIVATE_KEY);
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);    // 取得私钥  
//        KeyFactory keyFactory = KeyFactory.getInstance(RSA_ALGORITHM);          
//        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
//        return privateKey;
//	}
	
//	public static void main(String[] args) throws Exception {  
//        String str = "liguoliang.com，你好";          
//        PrivateKey privateKey = (PrivateKey) getPrivateKey();
//        PublicKey publicKey = (PublicKey) getPublicKey();
//        
//        System.out.println("privateKey: " + privateKey);  
//        System.out.println("PublicKey: " + publicKey);  
//  
//        System.out.println("Original message: [" + str + "]");  
//          
//        // init cipher  
//        Cipher cipher;  
//        cipher = Cipher.getInstance("RSA");  
//          
//        // Encrypt  
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
//        byte[] encryptedMsg = cipher.doFinal(str.getBytes());  
//        System.out.println("Encrypted message: [" + new String(encryptedMsg) + "]");  
//  
//        // Decrypt  
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
//        byte[] decryptedMsg = cipher.doFinal(encryptedMsg);  
//        System.out.println("Decrypted message: [" + new String(decryptedMsg) + "]");  
//    }  
	
}
