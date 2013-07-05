/**
 * 文件名：InitServlet.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 2, 2013 4:13:03 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.development.websocket;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.catalina.websocket.MessageInbound;

/**
 * <p>[描述信息：说明类的基本功能]</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 2, 2013 4:13:03 PM
 */
public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4003325424023664658L;
	
	private static Map<String,MessageInbound> socketList;    
    
    public void init(ServletConfig config) throws ServletException {    
        InitServlet.socketList = new HashMap<String,MessageInbound>();    
        super.init(config);    
        System.out.println("Server start============");    
    }    
        
    public static Map<String,MessageInbound> getSocketList() {    
        return InitServlet.socketList;    
    }    
}
