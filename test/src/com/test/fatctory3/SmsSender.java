package com.test.fatctory3;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("sms sender!");
	}

}
