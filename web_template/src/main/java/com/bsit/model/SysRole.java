package com.bsit.model;
/**
 * Title : Test
 * Description :  
 */
@SuppressWarnings("serial")
public class SysRole implements java.io.Serializable {
	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 角色名称
	 */
	private String r_role_name;
	
	/**
	 * 角色类型
	 */
	private String r_role_type;
	
	/**
	 * 角色添加时间
	 */
	private String r_role_time;
	
	/**
	 * 角色功能id
	 */
	private String r_fun_ids;
	
	/**
	 * 角色描述
	 */
	private String r_role_desc;
	
	
	/**
	*方法: 取得String
	*@return: String  主键
	*/
 	public String getId(){
		return this.id;
	}

	/**
	*方法: 设置String
	*@param: String  主键
	*/
	public void setId(String id){
		this.id = id;
	}
	/**
	*方法: 取得String
	*@return: String  角色名称
	*/
 	public String getR_role_name(){
		return this.r_role_name;
	}

	/**
	*方法: 设置String
	*@param: String  角色名称
	*/
	public void setR_role_name(String r_role_name){
		this.r_role_name = r_role_name;
	}
	
	/**
	*方法: 取得String
	*@return: String  角色类型
	*/
	public String getR_role_type() {
		return r_role_type;
	}

	/**
	*方法: 设置String
	*@param: String  角色类型
	*/
	public void setR_role_type(String r_role_type) {
		this.r_role_type = r_role_type;
	}

	/**
	*方法: 取得String
	*@return: String  角色添加时间
	*/
	public String getR_role_time() {
		return r_role_time;
	}

	/**
	*方法: 设置String
	*@param: String  角色添加时间
	*/
	public void setR_role_time(String r_role_time) {
		this.r_role_time = r_role_time;
	}

	/**
	*方法: 取得String
	*@return: String  角色功能id
	*/
	public String getR_fun_ids() {
		return r_fun_ids;
	}

	/**
	*方法: 设置String
	*@param: String  角色功能id
	*/
	public void setR_fun_ids(String r_fun_ids) {
		this.r_fun_ids = r_fun_ids;
	}

	/**
	*方法: 取得String
	*@return: String  角色描述
	*/
 	public String getR_role_desc(){
		return this.r_role_desc;
	}

	/**
	*方法: 设置String
	*@param: String  角色描述
	*/
	public void setR_role_desc(String r_role_desc){
		this.r_role_desc = r_role_desc;
	}
}


