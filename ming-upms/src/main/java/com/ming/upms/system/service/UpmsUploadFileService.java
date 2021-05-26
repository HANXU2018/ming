package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsUploadFileDO;

import java.util.List;
import java.util.Map;

/**
 * 系统
 * 
 * @author HANXU
 * @email 1076998404@qq.com
 * @date 2021-05-26 21:09:30
 */
public interface UpmsUploadFileService {
	
	UpmsUploadFileDO get(Long systemId);
	
	List<UpmsUploadFileDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsUploadFileDO upmsUploadFile);
	
	int update(UpmsUploadFileDO upmsUploadFile);
	
	int remove(Long systemId);
	
	int batchRemove(Long[] systemIds);
}
