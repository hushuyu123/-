package com.xyc.javamail;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.xyc.javamail.MailTools;
import com.xyc.javamail.MailTools.MailToolsBuilder;

public class sendDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String to = "1745374073@qq.com";
		MailTools mailTools = new MailToolsBuilder("conf/config.properties").build();
		mailTools.addTo(to);
		mailTools.setText("�𾴵��û�����������������xxxʣ������xxx�����û���xxx ��ʣ�໨��xxx");		
		String str = mailTools.sendMail();
		System.out.println(str);	
		
	
	}

}
