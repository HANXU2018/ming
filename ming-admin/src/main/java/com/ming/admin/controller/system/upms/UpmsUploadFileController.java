package com.ming.admin.controller.system.upms;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ming.admin.controller.common.BaseController;
import com.ming.common.domain.Tree;
import com.ming.common.utils.PageUtils;
import com.ming.common.utils.Query;
import com.ming.common.utils.R;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsPermissionService;
import com.ming.upms.system.service.UpmsUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ming.upms.system.domain.UpmsUploadFileDO;
import com.ming.upms.system.service.UpmsUploadFileService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import static com.ming.upms.common.util.ShiroUtils.getUser;
import static com.ming.upms.common.util.ShiroUtils.getUserId;


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
    private UpmsUserService upmsUserService;

    @Autowired
    private UpmsPermissionService upmsPermissionService;
    @Autowired
    private UpmsUploadFileService upmsUploadFileService;

    @GetMapping()
    @RequiresPermissions("system:upmsUploadFile:read")
    String UpmsUploadFile() {
        return "system/upmsUploadFile/upmsUploadFile";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:upmsUploadFile:read")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UpmsUploadFileDO> upmsUploadFileList = upmsUploadFileService.list(query);
        int total = upmsUploadFileService.count(query);
        PageUtils pageUtils = new PageUtils(upmsUploadFileList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:upmsUploadFile:add")
    String add(Model model) {
        //获取用户资源
        UpmsUserDO user = getUser();
        model.addAttribute("user", user);
        return "system/upmsUploadFile/add";
    }

    @GetMapping("/edit/{systemId}")
    @RequiresPermissions("system:upmsUploadFile:edit")
    String edit(@PathVariable("systemId") Long systemId, Model model) {
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
    public R save(UpmsUploadFileDO upmsUploadFile) {
        if (upmsUploadFileService.save(upmsUploadFile) > 0) {
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
    public R update(UpmsUploadFileDO upmsUploadFile) {
        upmsUploadFileService.update(upmsUploadFile);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:upmsUploadFile:remove")
    public R remove(Long systemId) {
        if (upmsUploadFileService.remove(systemId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:upmsUploadFile:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] systemIds) {
        upmsUploadFileService.batchRemove(systemIds);
        return R.ok();
    }

    //单一文件上传
    @RequestMapping("/fileupload")
    @RequiresPermissions("system:upmsUploadFile:add")
    public String uploadFile(@RequestParam("file00") MultipartFile file,@RequestParam("Key") String key, Model model){
        String msg="";
        try {
            if(file.isEmpty()){
                model.addAttribute("msg","上传失败，请选择文件！");
                return "index";
            }
            String filename = file.getOriginalFilename();
            //String filePath = request.getServletContext().getRealPath("/upload");
            String filePath = ResourceUtils.getURL("classpath:").getPath()+"static/";
            //避免文件重复覆盖
            String uuid= UUID.randomUUID().toString().replaceAll("-", "");
            //时间戳分类文件
            String time =  new SimpleDateFormat("YYYY-MM").format(new Date());

            String realPath = filePath+time+"/"+uuid+filename;
            msg = time+"/"+uuid+filename;
            File dest = new File(realPath);
            //检测是否存在目录，无，则创建
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();//新建文件夹 多级目录
            }
            file.transferTo(dest);//文件写入
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将src路径发送至html页面
        model.addAttribute("filename", "/images/rotPhoto/"+msg);
        //获取用户资源
        UpmsUserDO user = getUser();
        model.addAttribute("user", user);
        model.addAttribute("Key", key);
        return "system/upmsUploadFile/add";
    }

    @PostMapping("/download")
    public String  testDownload(HttpServletResponse response , Model model) {
        //待下载文件名
        String fileName = "1.png";
        //设置为png格式的文件
        response.setHeader("content-type", "image/png");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File("D:/upload/" + fileName )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            //出现异常返回给页面失败的信息
            model.addAttribute("result","下载失败");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //成功后返回成功信息
        model.addAttribute("result","下载成功");
        return "employee/EmployeeDownloadFile";
    }
}
