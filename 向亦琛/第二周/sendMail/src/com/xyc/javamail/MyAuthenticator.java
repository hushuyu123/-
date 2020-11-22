package com.xyc.javamail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	private String username, password;
	 
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
 
	public MyAuthenticator(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
