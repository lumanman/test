package com.test.fatctory1;

import com.test.Sender;

public class test {
	public static void main(String[] args) {
		SendFactory f = new SendFactory();
		Sender s = f.produceSms();
		s.send();
	}
}
