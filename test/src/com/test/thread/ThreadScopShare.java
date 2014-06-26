package com.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopShare {
	private static int data = 0;
	private static Map<Thread, Integer> map = new HashMap<Thread, Integer>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" put data = "+ data);
					map.put(Thread.currentThread(), data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	static class A{
		public void get(){
			data = map.get(Thread.currentThread());

			System.out.println("A :"+Thread.currentThread().getName()+" get data = "+ data);
		}
	}
	static class B{
		public void get(){
			data = map.get(Thread.currentThread());

			System.out.println("B :"+Thread.currentThread().getName()+" get data = "+ data);
		}
	}
}
