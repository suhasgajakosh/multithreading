package com.reentrantlocks;

public class Runner {

	private int count = 0;

	private void increment() {
		for (int i = 0; i < 1000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		increment();
	}

	public void secondThread() throws InterruptedException {
		increment();
	}

	public void completed() {
		System.out.println("Count is : " + count);
	}

}
