package com.ming.upms.system.service;

import com.ming.upms.system.domain.UpmsRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-11 20:08:05
 */
public interface UpmsRoleService {
	
	UpmsRoleDO get(Integer roleId);
	
	List<UpmsRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UpmsRoleDO upmsRole);
	
	int update(UpmsRoleDO upmsRole);
	
	int remove(Integer roleId);
	
	int batchRemove(Integer[] roleIds);
}
