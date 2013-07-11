/**
 * 文件名：WorkflowProperties.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 9, 2013 1:59:40 PM
 *
 * 版权所有：杭州数云信息技术有限公司
 */
package com.yunat.workflow.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>读取配置文件</p>
 *
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 9, 2013 1:59:40 PM
 */
public class WorkflowProperties {

		private Properties properties = new Properties();

		private Map<String, String> map = new HashMap<String, String>();

		protected WorkflowProperties() {
			/*
			 * 读SRC下的配置文件方式 InputStream is =
			 * *.class.getClassLoader().getResourceAsStream("*.properties");
			 * 同级目录
			 * *.class.getResourceAsStream("*.properties");
			 */
			InputStream is = WorkflowProperties.class.getClassLoader().getResourceAsStream("workflow.properties");
			try {
				properties.load(is);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		private static WorkflowProperties instance = null;

		public static WorkflowProperties getInstance() {
			if (instance == null) {
				instance = new WorkflowProperties();
				instance.getConfigs();
			}
			return instance;
		}

		public String getConfig(String name) {
			String value = (String) properties.get(name);
			return value;
		}

		public int getIntConfig(String name) {
			String value = getConfig(name);
			return Integer.valueOf(value).intValue();
		}

		public float getFloatConfig(String name) {
			String value = getConfig(name);
			return Float.valueOf(value).floatValue();
		}

		public double getDoubleConfig(String name) {
			String value = getConfig(name);
			return Double.valueOf(value).doubleValue();
		}

		private void getConfigs() {
			Enumeration e = properties.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				map.put(key, properties.getProperty(key));
			}
		}

		public String getValue(String key) {
			return map.get(key);
		}
}
