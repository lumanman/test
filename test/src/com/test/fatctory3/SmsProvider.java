package com.test.fatctory3;

public class SmsProvider implements Provider{

	@Override
	public Sender create() {
		// TODO Auto-generated method stub
		return new SmsSender();
	}

}
