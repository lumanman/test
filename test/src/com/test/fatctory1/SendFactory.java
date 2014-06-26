package com.test.fatctory1;

import com.test.MailSender;
import com.test.Sender;
import com.test.SmsSender;

public class SendFactory {
	public Sender produceSms(){
		return new SmsSender();
	}
	public Sender produceMail(){
		return new MailSender();
	}
}
