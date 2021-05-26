package com.ming.admin.controller.system.upms;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.upms.system.domain.UpmsUploadFileDO;
import com.ming.upms.system.service.UpmsUploadFileService;
import ${common-package}.utils.PageUtils;
import ${common-package}.utils.Query;
import ${common-package}.utils.R;

/**
 * 系统
 *
 * @author HANXU
 * @email 1076998404@qq.com
 * @date 2021-05-26 21:09:30
 */

@Controller
@RequestMapping("/system/upmsUploadFile")
public class UpmsUploadFileController {
	@Autowired
	private UpmsUploadFileService upmsUploadFileService;

	@GetMapping()
	@RequiresPermissions("system:upmsUploadFile:read")
	String UpmsUploadFile(){
	    return "system/upmsUploadFile/upmsUploadFile";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:upmsUploadFile:read")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UpmsUploadFileDO> upmsUploadFileList = upmsUploadFileService.list(query);
		int total = upmsUploadFileService.count(query);
		PageUtils pageUtils = new PageUtils(upmsUploadFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("system:upmsUploadFile:add")
	String add(){
	    return "system/upmsUploadFile/add";
	}

	@GetMapping("/edit/{systemId}")
	@RequiresPermissions("system:upmsUploadFile:edit")
	String edit(@PathVariable("systemId") Long systemId,Model model){
		UpmsUploadFileDO upmsUploadFile = upmsUploadFileService.get(systemId);
		model.addAttribute("upmsUploadFile", upmsUploadFile);
	    return "system/upmsUploadFile/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:upmsUploadFile:add")
	public R save( UpmsUploadFileDO upmsUploadFile){
		if(upmsUploadFileService.save(upmsUploadFile)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:upmsUploadFile:edit")
	public R update( UpmsUploadFileDO upmsUploadFile){
		upmsUploadFileService.update(upmsUploadFile);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:upmsUploadFile:remove")
	public R remove( Long systemId){
		if(upmsUploadFileService.remove(systemId)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:upmsUploadFile:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] systemIds){
		upmsUploadFileService.batchRemove(systemIds);
		return R.ok();
	}

}
