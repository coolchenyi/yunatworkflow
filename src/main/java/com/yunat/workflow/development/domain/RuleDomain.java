/**
 * 文件名：RuleDomain.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 4, 2013 4:05:04 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.development.domain;


/**
 * <p>
 * 规则信息
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 4, 2013 4:05:04 PM
 */
public class RuleDomain {
	
	private String rid = null;
	
	private String task_id = null;
	
	private String rule_type = null;
	
	private String original_value = null;
	
	private String new_value = null;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getRule_type() {
		return rule_type;
	}

	public void setRule_type(String rule_type) {
		this.rule_type = rule_type;
	}


	public String getOriginal_value() {
		return original_value;
	}

	public void setOriginal_value(String original_value) {
		this.original_value = original_value;
	}

	public String getNew_value() {
		return new_value;
	}

	public void setNew_value(String new_value) {
		this.new_value = new_value;
	}

}
