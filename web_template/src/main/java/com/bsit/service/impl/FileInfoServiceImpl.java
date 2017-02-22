package com.bsit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsit.mapper.FileInfoMapper;
import com.bsit.model.FileInfo;
import com.bsit.service.FileInfoServiceI;

@Service(value="fileInfoService")
public class FileInfoServiceImpl implements FileInfoServiceI {
	
	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Override
	public void saveFileInfo(FileInfo fileInfo) {
		fileInfoMapper.saveFileInfo(fileInfo);
	}
	
	@Override
	public FileInfo getFileInfoById(String id) {
		return fileInfoMapper.getFileInfoById(id);
	}
	
	@Override
	public FileInfo getLatestFileInfoByCondition(Map<String, String> condition) {
		return fileInfoMapper.getLatestFileInfoByCondition(condition);
	}
	
	@Override
	public List<FileInfo> getFileInfoListByProjectName(String project_name) {
		return fileInfoMapper.getFileInfoListByProjectName(project_name);
	}

	@Override
	public List<FileInfo> getFileInfoListByCondition(Map<String, String> condition) {
		return fileInfoMapper.getFileInfoListByCondition(condition);
	}

}

