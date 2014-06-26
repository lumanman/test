package com.test.thread;

public class PC {
		public static void main(String[] args) {
			g g = new g();
			p p = new p(g);
			c c = new c(g);
			
			new Thread(p).start();
			new Thread(c).start();
		}
}
class e{
	private int id ;
	public e(int id){
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id ="+id;
	}
}
class g{
	int index = 0;
	e[] es = new e[10];
	public synchronized void add(e e1){
		while(index == es.length){
			try {
				this.wait();
				System.out.println("is full");
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		this.notify();
		es[index] = e1;
		index++;
		System.out.println("add " +e1 +" all is "+index);
	}
	public synchronized void sub(){
		while(index == 0 ){
			try {
				this.wait();
				System.out.println("is empty");
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		this.notify();
		index--;
		System.out.println("sub " +es[index] +" all is "+index);
	}
}
class p implements  Runnable{
	 g g ;
	 public p (g g){
		 this.g=g;
	 }
	public void run() {
		for(int i=1;i<21;i++){
			g.add(new e(i));
			try {
				Thread.sleep(500*(int)Math.random());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
class c implements  Runnable{
	g g ;
	public c (g g){
		this.g=g;
	}
	public void run() {
		for(int i=1;i<21;i++){
			g.sub();
			try {
				Thread.sleep(600*(int)Math.random());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}