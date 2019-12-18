package com.test.model;

public class MailReq {
	private String emailAddress;
	private String message;
	private Boolean isFrieds;

	public Boolean getIsFrieds() {
		return isFrieds;
	}

	public void setIsFrieds(Boolean isFrieds) {
		this.isFrieds = isFrieds;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MailReq [emailAddress=" + emailAddress + ", message=" + message + ", isFrieds=" + isFrieds + "]";
	}

}
