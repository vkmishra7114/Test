package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.constant.TestConstant;
import com.test.model.MailReq;
import com.test.model.MailResp;
import com.test.service.TestService;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {
	@Autowired
	private TestService testService;

	@ApiOperation(value = "this api is use to Calculate Sale Tex", response = String.class)
	@RequestMapping(path = "calculateTax", method = RequestMethod.POST, consumes = {
			MediaType.TEXT_PLAIN_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE })
	public String getSalexTax(@RequestBody String data) {
		return testService.calculateSalesTax(data);
	}

	@ApiOperation(value = "this api is use to get shortest Pelindrom", response = String.class)
	@RequestMapping(path = "getShotestPallindrom", method = RequestMethod.POST, consumes = {
			MediaType.TEXT_PLAIN_VALUE }, produces = { MediaType.TEXT_PLAIN_VALUE })
	public String getshortestPalindrom(@RequestBody String input) {
		return testService.shortestPalindrome(input);
	}

	@ApiOperation(value = "this api is use to Mail send", response = MailResp.class)
	@RequestMapping(path = "sentMail", method = RequestMethod.POST)
	public MailResp sentMail(@RequestBody MailReq input) {
		MailResp resp = new MailResp();
		resp.setMailList(input.getEmailAddress());
		String friendList = "";
		if (input.getIsFrieds()) {
			for (int i = 0; i < TestConstant.FRIENDS.length; i++) {
				if (TestConstant.FRIENDS[i][0].equals(input.getEmailAddress()))
					friendList = TestConstant.FRIENDS[i][1];
			}
			if (friendList.length() != 0) {

				testService.sendMail(input.getEmailAddress(), input.getMessage(), TestConstant.FRIENDS);
			} else
				resp.setMessage("Friend is not found");
		} else
			testService.sendMail(input.getEmailAddress(), input.getMessage());
		return new MailResp();
	}
}
