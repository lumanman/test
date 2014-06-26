package com.test.fatctory3;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("send mail");
	}

}
