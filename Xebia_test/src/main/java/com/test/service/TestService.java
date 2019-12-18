package com.test.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.test.constant.TestConstant;

@Service
public class TestService {
	@Autowired
	private JavaMailSender javaMailSender;
	private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

	public String calculateSalesTax(String input) {
		Double amount = null;
		Double taxAmount = 0.00;
		Double totalAmount = 0.00;
		String output = "";
		String inputArry[] = input.split("\n");
		for (String data : inputArry) {
			amount = Double.parseDouble(data.substring(data.indexOf(" at ") + 4));
			
			if (data.substring(2, data.indexOf(" at ")).equals(TestConstant.BOOK_CAT[0])
					|| (data.substring(2, data.indexOf(" at ")).trim().equals(TestConstant.FOOD_CAT[0]))
					||(data.substring(2, data.indexOf(" at ")).trim().equals(TestConstant.FOOD_CAT[1]))) {
				if(data.substring(2, data.indexOf(" at ")).trim().indexOf("imported")!=-1) {
				output = output + data.substring(2, data.indexOf(" at ")) + " : " + decimalFormat.format(amount+(amount * TestConstant.IMPORT_TAX / 100)) + "\n";
				totalAmount = totalAmount + (amount+(amount * TestConstant.IMPORT_TAX / 100));
				}
				else{
					output = output + data.substring(2, data.indexOf(" at ")) + " : " + decimalFormat.format(amount) + "\n";
					totalAmount = totalAmount + amount;
					}
					
			} else {
				if(data.substring(2, data.indexOf(" at ")).trim().indexOf("imported")!=-1) {
				output = output + data.substring(2, data.indexOf(" at ")) + " : "
						+ decimalFormat.format(amount + (amount * (TestConstant.SALES_TAX +TestConstant.IMPORT_TAX)/ 100)) + "\n";
				totalAmount = totalAmount + (amount + (amount * (TestConstant.SALES_TAX +TestConstant.IMPORT_TAX) / 100));
				taxAmount = taxAmount + (amount * (TestConstant.SALES_TAX +TestConstant.IMPORT_TAX) / 100);
				}
				else {

					output = output + data.substring(2, data.indexOf(" at ")) + " : "
							+ decimalFormat.format(amount + (amount * TestConstant.SALES_TAX / 100)) + "\n";
					totalAmount = totalAmount + (amount + (amount * 10 / 100));
					taxAmount = taxAmount + (amount * 10 / 100);
					
				}

			}
		}

		return output + "Sales Taxes: " + decimalFormat.format(taxAmount) + "\n Total:" + decimalFormat.format(totalAmount);
	}

	public String shortestPalindrome(String input) {
		StringBuffer buffer = new StringBuffer(input);
		String reverse = buffer.reverse().toString();
		if (input.equals(reverse))
			return input;
		return input + reverse.substring(1);
	}

	public void sendMail(String emailAddress, String message) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(emailAddress);
		msg.setSubject("Testing Of Xebia IT Architects, Pune");
		msg.setText(message);
		javaMailSender.send(msg);
	}

	public void sendMail(String emailAddress, String message, String[][] friendsArray) {
		String friendList = "";
		String newMailList = "";
		MailSendList mailSendList = MailSendList.getInstance();
		for (int i = 0; i < TestConstant.FRIENDS.length; i++) {
			if (TestConstant.FRIENDS[i][0].equals(emailAddress))
				friendList = TestConstant.FRIENDS[i][1];
		}
		for (String mailId : friendList.split(",")) {
			if (mailSendList.setMailSet(mailId))
				newMailList += mailId + ",";
		}
		if (newMailList.length() != 0) {
			newMailList = newMailList.substring(0, newMailList.length() - 1);
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(emailAddress);
			msg.setCc(newMailList);
			msg.setSubject("Testing Of Xebia IT Architects, Pune");
			msg.setText(message);

			javaMailSender.send(msg);
		}

	}
}
