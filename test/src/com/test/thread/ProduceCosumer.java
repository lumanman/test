package com.test.thread;

public class ProduceCosumer {
	public static void main(String[] args) {
		Kuang k = new Kuang();
		Producer p = new Producer(k);
		Cosumer c = new Cosumer(k);
		new Thread(p).start();
		new Thread(c).start();
	}
}

class Mb {
	private String id;

	public Mb(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id ==" + id;
	}
}

class Kuang {
	int index = 0;
	Mb mbs[] = new Mb[10];

	public synchronized void fangMb(Mb mb) {
		while (index == mbs.length) {
			try {
				this.wait();
				System.out.println("不能放了，已经满了！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		mbs[index] = mb;
		index++;
		System.out.println("生产了 :" + mb + " 目前有 " + index);
	}

	public synchronized Mb quMb() {
		while (index == 0) {
			try {
				this.wait();
				System.out.println("不能取了，已经没有了！");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		System.out.println("吃了 :" + mbs[index] + " 目前有 " + index);
		return mbs[index];
	}
}

class Producer implements Runnable {
	Kuang k = new Kuang();

	public Producer(Kuang k) {
		this.k = k;
	}

	@Override
	public void run() {
		for (int i = 1; i < 21; i++) {
			Mb mb = new Mb(i + "");
			k.fangMb(mb);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Cosumer implements Runnable {
	Kuang k = new Kuang();

	public Cosumer(Kuang k) {
		this.k = k;
	}

	@Override
	public void run() {
		for (int i = 1; i < 21; i++) {
			Mb mb = k.quMb();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}