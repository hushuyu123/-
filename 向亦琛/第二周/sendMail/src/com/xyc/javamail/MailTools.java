package com.xyc.javamail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MailTools {
	private String text = "hello world"; // �ı�����
	private String username; // �û��˺�
	private String password; // ��Ȩ��
	private String smtp; // �ʼ����ͷ�����
	//private String pop3; // �ʼ����ܷ�����
	private String from; // ������
	private Set<String> to = new HashSet<String>(); // �ռ����б�
	private String subject; // ���� �൱��ժҪ
	private String fromName; // ����������
	private MyAuthenticator myAuthenticator;
 
	public MailTools(MailToolsBuilder build) {
		this.username = build.username;
		this.password = build.password;
		this.smtp = build.smtp;
		//this.pop3 = build.pop3;
		this.from = build.from;
		this.subject = build.subject;
		this.fromName = build.fromName;
		checkNull(username, "username����Ϊ��");
		checkNull(password, "password����Ϊ��");
 
		this.myAuthenticator = new MyAuthenticator(username, password);
	}
 
	public void addTo(String t) {
		this.to.add(t);
 
	}
 
	public void setText(String text) {
		this.text = text;
	}
 
	public void addTos(Set<String> tos){
		for(String t :tos){
			this.to.add(t);
		}
	}
	// Ҫ�뷢���ʼ�������Ҫ����� �û��� ��Ȩ�� ������ �ռ��� smtp
	public String sendMail() {
		checkNull(from, "from����Ϊ��");
		checkNull(smtp, "smtp����Ϊ��");
		if (to.isEmpty()) {
			throw new IllegalArgumentException("�������ռ���");
		}
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtp);
		props.put("mail.smtp.auth", true);
 
		Session session = Session.getDefaultInstance(props, myAuthenticator);
		MimeMessage msg = new MimeMessage(session);
 
		// �������ݣ����ñ��⣬�����ռ���
		try {
			msg.setText(text);
			msg.setFrom(new InternetAddress(from, fromName, "utf-8"));
			// ����
			for (String t : to) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						t));
			}
 
			if (subject != null) {
				msg.setSubject(subject);
			}
 
		} catch (MessagingException e) {
			return e.getMessage();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// ���ͳ�ȥ
		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
			return e.getMessage();
		}
 
		try {
			transport.connect();
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
			return "����ʧ��";
		}
		return "Ͷ�ݳɹ�";
	}
 
	/** ���ص�ǰ�ռ����б�ĸ��� */
	public Set<String> getToSet() {
		return new HashSet<String>(to);
	}
 
	public String sendMail(String text) {
		this.text = text;
		return sendMail();
	}
 
	private void checkNull(String str, String msg) {
		if (str == null) {
			throw new IllegalArgumentException(msg);
		}
	}
 
	/**
	 * ��������ռ����б�
	 */
	public void clearTo() {
		to.clear();
	}
 
	public static class MailToolsBuilder {
		private String username; // �û��˺�
		private String password; // ��Ȩ��
		private String smtp; // �ʼ����ͷ�����
		private String pop3; // �ʼ����ܷ�����
		private String from; // ������
		private String subject; // ���� �൱��ժҪ
		private String fromName; // ����������
 
		/**
		 * 
		 * @param props
		 *            ��Ҫ�����ļ�ģ�� mail.username mail.password mail.smtp mail.pop3
		 *            mail.fromname
		 * @throws FileNotFoundException 
		 * @throws IOException
		 * 
		 * 
		 */
		public MailToolsBuilder(String path) throws FileNotFoundException, IOException {
			Properties props = new Properties();
			props.load(new FileInputStream(path));
			init(props);
			
		}
 
		public MailToolsBuilder(Properties props) {
			init(props);
		}
 
		private void init(Properties props) {
 
			if (!props.containsKey("mail.username")) {
				throw new IllegalAccessError("�����ļ�����ȱ��mail.username");
			}
			if (!props.containsKey("mail.password")) {
				throw new IllegalAccessError("�����ļ�����ȱ��mail.upassword");
			}
			if (!props.containsKey("mail.smtp")) {
				throw new IllegalAccessError("�����ļ�����ȱ��mail.smtp");
			}
			if (!props.containsKey("mail.pop3")) {
				throw new IllegalAccessError("�����ļ�����ȱ��mail.pop3");
			}
			if (!props.containsKey("mail.fromname")) {
				throw new IllegalAccessError("�����ļ�����ȱ��mail.fromname");
			}
 
			this.username = props.getProperty("mail.username");
			this.password = props.getProperty("mail.password");
			this.smtp = props.getProperty("mail.smtp");
			this.pop3 = props.getProperty("mail.pop3");
			this.fromName = props.getProperty("mail.fromname");
 
			if (props.containsKey("mail.subject")) {
				this.subject = props.getProperty("mail.subject");
			}
			if (props.containsKey("mail.from")) {
				this.from = props.getProperty("mail.from");
			}
		}
 
		public MailToolsBuilder setUsername(String username) {
			this.username = username;
			return this;
		}
 
		public MailToolsBuilder setPassword(String password) {
			this.password = password;
			return this;
		}
 
		public MailToolsBuilder setSmtp(String smtp) {
			this.smtp = smtp;
			return this;
		}
 
		public MailToolsBuilder setPop3(String pop3) {
			this.pop3 = pop3;
			return this;
		}
 
		public MailToolsBuilder setTitle(String fromName) {
			this.fromName = fromName;
			return this;
		}
 
		public MailToolsBuilder setSubject(String subject) {
			this.subject = subject;
			return this;
		}
 
		public MailToolsBuilder setFrom(String from) {
			this.from = from;
			return this;
		}
 
		public MailTools build() {
			return new MailTools(this);
		}
	}
	
//	/**
//	 * ��ȡhtml�ļ�ΪString
//	 * @param htmlFileName
//	 * @return
//	 * @throws Exception
//	 */
//	public static String readHtmlToString(String htmlFileName) throws Exception{
//		InputStream is = null;
//		Reader reader = null;
//		try {
//			is = MailTools.class.getClassLoader().getResourceAsStream(htmlFileName);
//			if (is ==  null) {
//				throw new Exception("δ�ҵ�ģ���ļ�");
//			}
//			reader = new InputStreamReader(is, "UTF-8");  
//			StringBuilder sb = new StringBuilder();
//			int bufferSize = 1024;
//			char[] buffer = new char[bufferSize];
//			int length = 0;
//			while ((length = reader.read(buffer, 0, bufferSize)) != -1){
//				sb.append(buffer, 0, length);
//			}
//			return sb.toString();
//		} finally {
//			try {
//				if (is != null) {
//					is.close();
//				}
//			} catch (IOException e) {
//				System.out.println("�쳣");
//			}
//			try {
//				if (reader != null) {
//					reader.close();
//				}
//			} catch ( IOException e) {
//				System.out.println("�쳣");
//			}
//		}
	//}
}
