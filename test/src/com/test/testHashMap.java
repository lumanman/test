package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class testHashMap {
	public static void main(String[] args) throws InterruptedException {
		final HashMap<String ,String > map  = new HashMap();
		Thread t = new Thread(new Runnable(){

			@Override
			public void run() {
				final int j =0;
					for (int i=0;i<1000;i++){
						new Thread(new Runnable(){
							public void run(){
								map.put(UUID.randomUUID().toString(), "");
							}
						},"tft"+i).start();
					}
				
			}
			
		},"tft");
		t.start();
		t.join();
	}
}
