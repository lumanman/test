package com.test.fatctory3;

public class MailProvider implements Provider{

	@Override
	public Sender create() {
		return new MailSender();
	}
	
}
