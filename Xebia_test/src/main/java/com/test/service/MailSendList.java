package com.test.service;

import java.util.HashSet;
import java.util.Set;

public class MailSendList {
	private static MailSendList mailSendList;
	private Set<String> mailSet;
	
	private MailSendList() {
		this.mailSet = new HashSet<>();
	}
	public Set<String> getMailSet() {
		return mailSet;
	}
	public boolean setMailSet(String mailSet) {
		return this.mailSet.add(mailSet);
	}
	
	public static MailSendList getInstance() {
		if(mailSendList==null)
			mailSendList=new MailSendList();
		return mailSendList;
	}

}
