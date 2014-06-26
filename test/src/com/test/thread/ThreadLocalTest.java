package com.test.thread;

import java.util.Date;
import java.util.Random;

public class ThreadLocalTest {
	private static ThreadLocal<Long> x = new ThreadLocal<Long>();
	private static ThreadLocal<u> uD = new ThreadLocal<u>();
	private static Long data = 0L;
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Long data = System.currentTimeMillis()+new Random().nextLong();
					System.out.println(Thread.currentThread().getName()+" put data = "+ data);
					x.set(data);
					u.get().setAge(data+"");
					u.get().setName("name"+data);
		/*			u u =new u();
					u.setAge(data+"");
					u.setName("name"+data);
					uD.set(u);*/
					new A().get();  
					new B().get();
				}  
			}).start();
		}
	}
	static class A{
		public void get(){
			long data =x.get();
			u u= com.test.thread.u.get();
			System.out.println("A :"+Thread.currentThread().getName()+" get data = "+ data);
			System.out.println("A :"+Thread.currentThread().getName()+" get name = "+ u.getName()+"  age  ="+u.getAge());

		}
	}
	static class B{
		public void get(){
			long data =x.get();
			u u= com.test.thread.u.get();

			System.out.println("B :"+Thread.currentThread().getName()+" get data = "+ data);
			System.out.println("B :"+Thread.currentThread().getName()+" get name = "+ u.getName()+"  age  ="+u.getAge());
		}
	}
}
class u{
	private u (){
		
	}
	public synchronized static u get(){
		u u = map.get();
		if(u==null){
			u= new u();
			map.set(u);
		}
		return u;
	}
	
	private static ThreadLocal<u> map = new ThreadLocal<u>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	String name ;
	String age ;
}
