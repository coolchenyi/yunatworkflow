package com.yunat.workflow.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件名：FileUtils.java
 *
 * 创建人：邱路平 - luping.qiu@huaat.com
 *
 * 创建时间：Jul 3, 2013 11:15:55 AM
 *
 * 版权所有：杭州数云信息技术有限公司
 */

/**
 * <p>
 * 文件读写工具类
 * </p>
 * 
 * @author 邱路平 - luping.qiu@huaat.com
 * @version 1.0 Created on Jul 3, 2013 11:15:55 AM
 */
public class FileUtils {

	/**
	 * <p>
	 * 写文件
	 * </p>
	 * 
	 * @param path文件路径
	 * @param fileName文件名称
	 * @param content文件需要写入的内容
	 * @param append是否追加
	 * @return: String 文件路径
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 3, 2013 11:21:10 AM
	 */
	public static String writerText(String path, String fileName, String content, boolean append) {

		File dirFile = new File(path);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
		if (!path.endsWith("/")) {
			path += "/";
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path + fileName, append));
			bw.write(content);
			bw.flush();
			bw.close();
			return path + fileName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * <p>删除文件</p>
	 * 
	 * @param filePath
	 * @return: void
	 * @author: 邱路平 - luping.qiu@huaat.com
	 * @date: Created on Jul 3, 2013 12:01:21 PM
	 */
	public static void deleteFile(String filePath){
		File f = new File(filePath); 
		if(f.exists()){
		    f.delete();
		}
	}
}
