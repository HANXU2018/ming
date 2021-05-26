package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 系统
 * 
 * @author HANXU
 * @email 1076998404@qq.com
 * @date 2021-05-26 21:09:30
 */
public class UpmsUploadFileDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long systemId;
	//所属用户

	private String userId;
	//根目录
	private String basepath;
	//状态(-1:黑名单,1:正常)
	private Integer status;
	//文件名称
	private String name;
	//密码
	private String salt;
	//系统描述
	private String description;
	//创建时间
	private Date ctime;
	//排序
	private Long orders;

	/**
	 * 设置：编号
	 */
	public void setSystemId(Long systemId) {
		this.systemId = systemId;
	}
	/**
	 * 获取：编号
	 */
	public Long getSystemId() {
		return systemId;
	}
	/**
	 * 设置：所属用户

	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：所属用户

	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：根目录
	 */
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	/**
	 * 获取：根目录
	 */
	public String getBasepath() {
		return basepath;
	}
	/**
	 * 设置：状态(-1:黑名单,1:正常)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态(-1:黑名单,1:正常)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：文件名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：文件名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：密码
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}
	/**
	 * 获取：密码
	 */
	public String getSalt() {
		return salt;
	}
	/**
	 * 设置：系统描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：系统描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCtime() {
		return ctime;
	}
	/**
	 * 设置：排序
	 */
	public void setOrders(Long orders) {
		this.orders = orders;
	}
	/**
	 * 获取：排序
	 */
	public Long getOrders() {
		return orders;
	}
}
