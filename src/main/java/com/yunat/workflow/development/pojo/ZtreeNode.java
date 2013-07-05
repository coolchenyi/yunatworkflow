package com.yunat.workflow.development.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>开发中心树</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:08:38 PM
 */
@Entity
@Table(name = "ztree")
public class ZtreeNode {

	@Id
	@Column(name = "id")
	private String id = null;
	
	@Column(name = "pid")
	private String pid = null;
	
	@Column(name = "task_id")
	private String task_id = null;
	
	@Column(name = "name")
	private String name = null;
	
	@Column(name = "type")
	private String type = null;
	
	@Column(name = "content")
	private String content = null;
	
	@Column(name = "owner")
	private String owner = null;
	
	@Column(name = "roler")
	private String roler = null;
	
	@Column(name = "group_id")
	private String group_id = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getRoler() {
		return roler;
	}

	public void setRoler(String roler) {
		this.roler = roler;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	
}
