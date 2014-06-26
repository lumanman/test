package com.test.thread;

public class ThreadComunication {
	public static void main(String[] args) {
		final Busseness b = new Busseness();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 50; i++) {
					b.sub(i);
				}

			}
		}).start();

		for (int i = 0; i < 50; i++) {
			b.main(i);
		}
	}
}

class Busseness {
	private boolean isrun = true;

	public synchronized void main(int i) {
		if (isrun) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			for (int j = 0; j < 100; j++) {
				System.out.println("main thread:" + j + " of  " + i);
			}
			isrun = true;
			this.notify();
	}

	public synchronized void sub(int i) {
		if (!isrun) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int j = 0; j < 10; j++) {
			System.out.println("sub thread:" + j + " of  " + i);
		}
		isrun = false;
		this.notify();
		
	}
}