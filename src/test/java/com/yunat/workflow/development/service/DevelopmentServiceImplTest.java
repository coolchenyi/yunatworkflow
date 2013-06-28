/**
 * 文件名：DevelopmentServiceImplTest.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jun 27, 2013 4:04:57 PM
 *
 * 版权所有：杭州数云股份有限公司
 */
package com.yunat.workflow.development.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jun 27, 2013 4:04:57 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:workflow-servlet.xml"})
public class DevelopmentServiceImplTest extends AbstractJUnit4SpringContextTests{

	@Resource
    private DevelopmentService developmentService;
	
	@Test
	public void queryZtreeNodetest() {
		developmentService.queryZtreeNode();
	}

}
