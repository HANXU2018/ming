package com.ming.upms.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ming.upms.system.dao.UpmsUploadFileDao;
import com.ming.upms.system.domain.UpmsUploadFileDO;
import com.ming.upms.system.service.UpmsUploadFileService;



@Service
public class UpmsUploadFileServiceImpl implements UpmsUploadFileService {
	@Autowired
	private UpmsUploadFileDao upmsUploadFileDao;
	
	@Override
	public UpmsUploadFileDO get(Long systemId){
		return upmsUploadFileDao.get(systemId);
	}
	
	@Override
	public List<UpmsUploadFileDO> list(Map<String, Object> map){
		return upmsUploadFileDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return upmsUploadFileDao.count(map);
	}
	
	@Override
	public int save(UpmsUploadFileDO upmsUploadFile){
		return upmsUploadFileDao.save(upmsUploadFile);
	}
	
	@Override
	public int update(UpmsUploadFileDO upmsUploadFile){
		return upmsUploadFileDao.update(upmsUploadFile);
	}
	
	@Override
	public int remove(Long systemId){
		return upmsUploadFileDao.remove(systemId);
	}
	
	@Override
	public int batchRemove(Long[] systemIds){
		return upmsUploadFileDao.batchRemove(systemIds);
	}
	
}
