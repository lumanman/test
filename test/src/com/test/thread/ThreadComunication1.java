package com.test.thread;

public class ThreadComunication1 {
	public static void main(String[] args) {
		final yewu yewu = new yewu();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					yewu.m1(i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					yewu.m2(i);
				}
			}
		}).start();
	}

}
class yewu{
	private boolean isrun = true;
	public synchronized void m1(int j ){
		while (isrun) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=1;i<=1;i++){
			System.out.println("m1 "+i +" of "+j);
		}
		isrun = true;
		this.notify();
	}
	public synchronized void m2(int j ){
		while (!isrun) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=1;i<=2;i++){
			System.out.println("m2 "+i +" of "+j);
		}
		isrun = false;
		this.notify();
	}
}
