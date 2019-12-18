package com.test.model;

public class MailResp {
	private String mailList;
	private String failMailList;
	private String message;

	public String getMailList() {
		return mailList;
	}

	public void setMailList(String mailList) {
		this.mailList = mailList;
	}

	public String getFailMailList() {
		return failMailList;
	}

	public void setFailMailList(String failMailList) {
		this.failMailList = failMailList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MailResp [mailList=" + mailList + ", failMailList=" + failMailList + ", message=" + message + "]";
	}

}
