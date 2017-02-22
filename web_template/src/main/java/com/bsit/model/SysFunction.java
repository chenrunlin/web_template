package com.bsit.model;
/**
 * Title : Test
 * Description :  
 */
@SuppressWarnings("serial")
public class SysFunction implements java.io.Serializable {
	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 功能名称
	 */
	private String f_fun_name;
	
	/**
	 * 功能url
	 */
	private String f_fun_url;
	
	/**
	 * 功能添加时间
	 */
	private String f_fun_time;
	
	/**
	 * 功能等级
	 */
	private String f_fun_level;
	
	/**
	 * 功能父节点
	 */
	private String f_fun_pid;
	
	/**
	 * 功能父节点
	 */
	private String f_fun_pname;
	
	
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
	*@return: String  功能名称
	*/
 	public String getF_fun_name(){
		return this.f_fun_name;
	}

	/**
	*方法: 设置String
	*@param: String  功能名称
	*/
	public void setF_fun_name(String f_fun_name){
		this.f_fun_name = f_fun_name;
	}
	/**
	*方法: 取得String
	*@return: String  功能url
	*/
 	public String getF_fun_url(){
		return this.f_fun_url;
	}

	/**
	*方法: 设置String
	*@param: String  功能url
	*/
	public void setF_fun_url(String f_fun_url){
		this.f_fun_url = f_fun_url;
	}
	/**
	*方法: 取得String
	*@return: String  功能添加时间
	*/
 	public String getF_fun_time(){
		return this.f_fun_time;
	}

	/**
	*方法: 设置String
	*@param: String  功能添加时间
	*/
	public void setF_fun_time(String f_fun_time){
		this.f_fun_time = f_fun_time;
	}
	
	/**
	*方法: 取得String
	*@return: String  功能等级
	*/
	public String getF_fun_level() {
		return f_fun_level;
	}

	/**
	*方法: 设置String
	*@param: String  功能等级
	*/
	public void setF_fun_level(String f_fun_level) {
		this.f_fun_level = f_fun_level;
	}

	/**
	*方法: 取得String
	*@return: String  功能父节点
	*/
	public String getF_fun_pid() {
		return f_fun_pid;
	}

	/**
	*方法: 设置String
	*@param: String  功能父节点
	*/
	public void setF_fun_pid(String f_fun_pid) {
		this.f_fun_pid = f_fun_pid;
	}

	/**
	*方法: 取得String
	*@return: String  功能父节点
	*/
	public String getF_fun_pname() {
		return f_fun_pname;
	}

	/**
	*方法: 设置String
	*@param: String  功能父节点
	*/
	public void setF_fun_pname(String f_fun_pname) {
		this.f_fun_pname = f_fun_pname;
	}
}
