package com.test.fatctory2;

import com.test.Sender;

public class test {
	public static void main(String[] args) {
		Sender s = SendFactory.produceMail();
		s.send();
	}
}
