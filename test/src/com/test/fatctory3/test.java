package com.test.fatctory3;

public class test {
	public static void main(String[] args) {
		Provider p = new MailProvider();
		p.create().send();
	}
}
