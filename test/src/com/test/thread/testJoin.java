package com.test.thread;

public class testJoin implements Runnable{
	
	  public static int a = 0;  
	  
	    public void run() {  
	        for (int k = 0; k < 10; k++) {  
	            a = a + 1;  
	            System.out.println(Thread.currentThread().getName()+"  k =   "+k );
	        }  
	    }  
	  
	    public static void main(String[] args) throws Exception {  
	        Runnable r = new testJoin();  
	        Thread t = new Thread(r,"A");  
	        Thread tb = new Thread(r,"B");  
	        t.start();
	       // t.join();
	        tb.start();
	        tb.join();
	        System.out.println(a);  
	    }         
	}  