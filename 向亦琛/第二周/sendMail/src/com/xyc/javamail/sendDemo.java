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
		mailTools.setText("尊敬的用户，您本月已用流量xxx剩余流量xxx，已用话费xxx ，剩余花费xxx");		
		String str = mailTools.sendMail();
		System.out.println(str);	
		
	
	}

}
