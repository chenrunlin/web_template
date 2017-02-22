package com.bsit.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.bsit.common.utils.StringUtil;
import com.bsit.model.FileInfo;
import com.bsit.model.TreeNode;
import com.bsit.service.FileInfoServiceI;

@Controller
@RequestMapping("/fileInfo")
public class FileInfoController{
	
	@Autowired
	private FileInfoServiceI fileInfoService;

	/**
	 * @Description: 到列表页面
	 */
	@RequestMapping(value="to_list", method = RequestMethod.GET)
	public String to_list(Model model){
		return "file_system/file_list";
	}
	
	/**
	 * @Description: 获取列表
	 * @return Map<String,Object>
	 */
	@RequestMapping(value="getFileInfoListByCondition", method = RequestMethod.POST)
	@ResponseBody
	public List<FileInfo> getFileInfoListByCondition(HttpServletRequest request) throws Exception{
		String merchant_no = request.getParameter("merchant_no");
		String project_name = request.getParameter("project_name");
		String file_type = request.getParameter("file_type");
		Map<String, String> condition = new HashMap<String, String>();//条件
		String str = "where 1 = 1 ";
		if(!StringUtil.isEmpty(merchant_no)){
			str += "and t.merchant_no like '%" + merchant_no + "%' ";
		}
		if(!StringUtil.isEmpty(project_name)){
			str += "and t.project_name = '" + project_name + "' ";
		}
		if(!StringUtil.isEmpty(file_type)){
			str += "and t.file_type = '" + file_type + "' ";
		}
		str += "order by CONVERT(t.version_num, SIGNED) DESC";
		condition.put("condition", str);
		List<FileInfo> fileInfoList = fileInfoService.getFileInfoListByCondition(condition);
		return fileInfoList;
	}
	
	/**
	 * @Description: 到添加页面
	 */
	@RequestMapping(value = "to_add", method = RequestMethod.GET)
	public String to_add(Model model){
		return "file_system/file_add";
	}
	
	/**
	 * @Description: 到列表页面
	 */
	@RequestMapping(value="to_mer_file/{id}", method = RequestMethod.GET)
	public String to_mer_file(@PathVariable("id") String id, Model model){
		FileInfo file = fileInfoService.getFileInfoById(id);
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		TreeNode rootNode = new TreeNode();
		rootNode.setId("123");
		rootNode.setName("所有商户");
		rootNode.setOpen(true);
		rootNode.setpId("-1");
		treeList.add(rootNode);
		
		TreeNode node1 = new TreeNode();
		node1.setId("11223344556677999");
		node1.setName("11223344556677999");
		node1.setOpen(true);
		node1.setpId("123");
		treeList.add(node1);
		
		TreeNode node2 = new TreeNode();
		node2.setId("99988877766655544");
		node2.setName("99988877766655544");
		node2.setOpen(true);
		node2.setpId("123");
		treeList.add(node2);
		
		model.addAttribute("file", file);
		model.addAttribute("treeList", JSONArray.toJSON(treeList));
		return "tree";
	}
 	
}