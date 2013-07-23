/**
 * 文件名：MyMessageInbound.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 2, 2013 4:08:32 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.development.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yunat.workflow.common.FileUtils;
import com.yunat.workflow.common.WorkflowProperties;
import com.yunat.workflow.development.service.DevelopmentService;

/**
 * <p>
 * [描述信息：说明类的基本功能]
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 2, 2013 4:08:32 PM
 */
@Service
public class MyMessageInbound extends MessageInbound {

	private String ssid = null;

	@Autowired
	private DevelopmentService developmentService;

	public MyMessageInbound() {
	}

	/**
	 * @param ssid
	 */
	public MyMessageInbound(String ssid) {
		super();
		this.ssid = ssid;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	/**
	 * <p>
	 * [描述方法实现的功能]
	 * </p>
	 * 
	 * @see org.apache.catalina.websocket.MessageInbound#onBinaryMessage(java.nio.ByteBuffer)
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 2, 2013 4:08:32 PM
	 */
	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * <p>
	 * [描述方法实现的功能]
	 * </p>
	 * 
	 * @see org.apache.catalina.websocket.MessageInbound#onTextMessage(java.nio.CharBuffer)
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 2, 2013 4:08:32 PM
	 */
	@Override
	protected void onTextMessage(CharBuffer msg) throws IOException {
		MessageInbound messageInbound = InitServlet.getSocketList().get(
				this.ssid);
		WsOutbound outbound = messageInbound.getWsOutbound();
		String path = WorkflowProperties.getInstance().getValue("sqlpath");
		System.out.println(msg.toString());
		String type = msg.toString().split("%:%")[0];
		String content = msg.toString().split("%:%")[1];
		String task_id = msg.toString().split("%:%")[2];
//		content = developmentService.ruleApply(task_id, content);
		String filePath = FileUtils.writerText(path, this.ssid + ".sql", content, false);
		String cmd = null;
		if (type.equals("hive")) {
			cmd = "hive -f " + filePath;
		}
		Runtime run = Runtime.getRuntime();// 返回与当前 Java 应用程序相关的运行时对象
		Process executor = run.exec(cmd);// 启动另一个进程来执行命令
		StreamGobbler errorGobbler = new StreamGobbler(executor.getErrorStream(), "", outbound);
		StreamGobbler outputGobbler = new StreamGobbler(executor.getInputStream(), ">", outbound);
		errorGobbler.start();
		outputGobbler.start();
		try {
			int ret = executor.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// CharBuffer buffer = CharBuffer.wrap(msg);
		// outbound.writeTextMessage(buffer);
		outbound.flush();
		FileUtils.deleteFile(filePath);
		// for (MessageInbound messageInbound : InitServlet.getSocketList()) {
		// CharBuffer buffer = CharBuffer.wrap(msg);
		// WsOutbound outbound = messageInbound.getWsOutbound();
		// outbound.writeTextMessage(buffer);
		// CharBuffer charBuffer = CharBuffer.wrap("hello good!");
		// outbound.writeTextMessage(charBuffer);
		// outbound.flush();
		// }

	}

	@Override
	protected void onClose(int status) {
		// InitServlet.getSocketList().remove(this);
		InitServlet.getSocketList().remove(this.ssid);
		super.onClose(status);
	}

	@Override
	protected void onOpen(WsOutbound outbound) {
		super.onOpen(outbound);
		InitServlet.getSocketList().put(this.ssid, this);
		// InitServlet.getSocketList().add(this);
	}

	public static class StreamGobbler extends Thread {
		InputStream is;
		String type;
		WsOutbound outbound;

		StreamGobbler(InputStream is, String type, WsOutbound outbound) {
			this.is = is;
			this.type = type;
			this.outbound = outbound;
		}

		public void run() {
			try {
				CharBuffer buffer = null;
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					buffer = CharBuffer.wrap(line + "\r\n");
					outbound.writeTextMessage(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

}
