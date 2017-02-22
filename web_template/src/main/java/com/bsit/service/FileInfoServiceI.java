package com.bsit.service;

import java.util.List;
import java.util.Map;

import com.bsit.model.FileInfo;

/**
 * @ClassName :  
 * @Description :  
 */
public interface FileInfoServiceI{

	void saveFileInfo(FileInfo fileInfo);
	
	FileInfo getFileInfoById(String id);
	
	FileInfo getLatestFileInfoByCondition(Map<String, String> condition);
	
	List<FileInfo> getFileInfoListByProjectName(String project_name);
	
	List<FileInfo> getFileInfoListByCondition(Map<String, String> condition);

}

