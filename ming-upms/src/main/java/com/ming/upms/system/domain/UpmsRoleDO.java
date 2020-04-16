package com.ming.upms.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 角色
 * 
 * @author ming
 * @email jie_ming514@163.com
 * @date 2020-04-11 20:08:05
 */
public class UpmsRoleDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Integer roleId;
	//角色名称
	private String name;
	//角色标题
	private String title;
	//角色描述
	private String description;
	//创建时间
	private Long ctime;
	//排序
	private Long orders;

	/**
	 * 设置：编号
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * 获取：编号
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * 设置：角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：角色标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：角色标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：角色描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：角色描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCtime(Long ctime) {
		this.ctime = ctime;
	}
	/**
	 * 获取：创建时间
	 */
	public Long getCtime() {
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


	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("UpmsRoleDO{");
		sb.append("roleId=").append(roleId);
		sb.append(", name='").append(name).append('\'');
		sb.append(", title='").append(title).append('\'');
		sb.append(", description='").append(description).append('\'');
		sb.append(", ctime=").append(ctime);
		sb.append(", orders=").append(orders);
		sb.append('}');
		return sb.toString();
	}
}
