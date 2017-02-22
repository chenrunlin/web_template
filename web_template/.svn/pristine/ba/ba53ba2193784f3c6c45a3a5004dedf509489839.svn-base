package com.bsit.common.utils.json;

import org.springframework.beans.BeanUtils;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

public class JsonUtils {

	public static String getString(JSONObject jsonObject, String key) {
		return jsonObject.has(key) ? jsonObject.get(key) instanceof JSONNull ? null : jsonObject.getString(key) : null;
	}

	/**
	 * @Title: createJson @Description:json对象装载 @param cls json class @param objects 实体对象 @return json实体 @throws
	 */
	public static <T> T convertToJsonObject(Class<T> cls, Object... objects) {
		T obj = null;
		try {
			obj = cls.newInstance();
			for (Object object : objects) {
				if (object != null) {
					BeanUtils.copyProperties(object, obj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			obj = null;
		}
		return obj;
	}

}
