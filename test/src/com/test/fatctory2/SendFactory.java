package com.test.fatctory2;

import com.test.MailSender;
import com.test.Sender;
import com.test.SmsSender;

public class SendFactory {
	public static Sender produceSms(){
		return new SmsSender();
	}
	public static Sender produceMail(){
		return new MailSender();
	}
}
