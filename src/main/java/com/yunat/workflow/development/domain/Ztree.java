/**
 * 文件名：Ztree.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jun 28, 2013 11:49:15 AM
 *
 * 版权所有：杭州数云股份有限公司
 */
package com.yunat.workflow.development.domain;


/**
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 28, 2013 11:49:15 AM
 */
public class Ztree {
	
	private String id = null;
	
	private String pId = null;
	
	private String taskId = null;
	
	private String name = null;
	
	private String isParent = null;
	
	private String content = null;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
