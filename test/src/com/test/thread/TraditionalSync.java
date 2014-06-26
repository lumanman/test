package com.test.thread;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class TraditionalSync {
	public static void main(String[] args) {
		new TraditionalSync().init();
	}
	public void init(){
		final outputer outputer = new outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.print("aaaaaaaaaaaaaa");
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(21);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.print("zzzzzzzzzzzzzzz");
				}
			}
		}).start();
	}
	
	class outputer{
		public synchronized void print(String name){
			  PrintStream out;
			try {
				out = new PrintStream("c:/test.txt");
				System.setOut(out);  
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			int len = name.length();
			for(int i=0;i<len;i++){
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}

