package com.test;

public class Factory {
	public Sender create(String name){
		if(name.equals("sms")){
			return new SmsSender();
		}else if(name.equals("mail")){
			return new MailSender();
		}else{
			return null;
		}
	}
}
