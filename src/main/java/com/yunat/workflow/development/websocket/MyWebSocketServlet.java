/**
 * 文件名：MyWebSocketServlet.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 2, 2013 4:07:21 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.development.websocket;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

import com.yunat.workflow.common.SpringContext;

import com.yunat.workflow.common.SpringContext;

/**
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 2, 2013 4:07:21 PM
 */
public class MyWebSocketServlet extends WebSocketServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1489497194786023110L;

	/**
	 * <p>[描述方法实现的功能]</p>
	 * 
	 * @see org.apache.catalina.websocket.WebSocketServlet#createWebSocketInbound(java.lang.String, javax.servlet.http.HttpServletRequest)
	 * @author: 邱路平 - luping.qiu@huaat.com 
	 * @date: Created on Jul 2, 2013 4:07:22 PM
	 */
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,HttpServletRequest arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg1.getSession().getId().toString()); 
		MyMessageInbound bean = (MyMessageInbound) SpringContext.getContext().getBean("myMessageInbound");
		bean.setSsid(arg1.getSession().getId().toString());
		return bean;
//        return new MyMessageInbound(arg1.getSession().getId().toString());  
	}

}
