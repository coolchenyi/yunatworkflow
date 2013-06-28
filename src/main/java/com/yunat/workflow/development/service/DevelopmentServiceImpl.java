/**
 * 文件名：DevelopmentServiceImpl.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jun 26, 2013 6:44:44 PM
 *
 * 版权所有：杭州数云股份有限公司
 */
package com.yunat.workflow.development.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yunat.workflow.development.dao.ZtreeNodeDAO;
import com.yunat.workflow.development.pojo.ZtreeNode;

/**
 * <p>
 * 开发中心相关业务接口实现
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 26, 2013 6:44:44 PM
 */
@Service
public class DevelopmentServiceImpl implements DevelopmentService {
	
	@Autowired
	private ZtreeNodeDAO ztreeNodeDAO;

	/**
	 * <p>
	 * 查询树接口实现
	 * </p>
	 * 
	 * @see com.yunat.workflow.development.service.DevelopmentService#queryZtreeNodeList()
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jun 26, 2013 6:44:44 PM
	 */
	@Transactional
	public String queryZtreeNode() {
		List<ZtreeNode> ztreeNodeList = ztreeNodeDAO.queryZtreeNodeList();
		StringBuffer nodes = new StringBuffer();
		for(ZtreeNode zn:ztreeNodeList){
			nodes.append("id:"+zn.getTid());
			nodes.append(",");
			nodes.append("pid:"+zn.getPid());
			nodes.append(",");
			nodes.append("name:"+zn.getName());
			nodes.append(";");
		}
		System.out.println(nodes.toString());
		return nodes.toString();
	}

}
