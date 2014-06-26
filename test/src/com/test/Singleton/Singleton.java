package com.test.Singleton;

public class Singleton {
	private static Singleton single = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (single == null) {
			synchronized (single) {
				if (single == null) {
					single = new Singleton();
				}
			}
		}
		return single;
	}

	public Object readResolve() {
		return single;
	}
}
