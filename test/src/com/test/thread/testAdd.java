package com.test.thread;

public class testAdd {
	int a = 1;
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
					testAdd testAdd = new testAdd();
					testAdd.add(12);
					testAdd.print();
			}
		}).start();
		}
	}
	public void print(){
		System.out.println(a);
	}
	
	public synchronized void add(int value){
		this.a+=value;
	}
}
