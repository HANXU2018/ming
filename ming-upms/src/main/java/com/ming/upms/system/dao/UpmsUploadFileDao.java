package com.ming.upms.system.dao;

import com.ming.upms.system.domain.UpmsUploadFileDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 系统
 * @author HANXU
 * @email 1076998404@qq.com
 * @date 2021-05-26 21:09:30
 */
@Mapper
public interface UpmsUploadFileDao {

	UpmsUploadFileDO get(Long systemId);
	
	List<UpmsUploadFileDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(UpmsUploadFileDO upmsUploadFile);
	
	int update(UpmsUploadFileDO upmsUploadFile);
	
	int remove(Long system_id);
	
	int batchRemove(Long[] systemIds);
}
