package com.examples.java.concurrency;

public class RunnableEx implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
		
	}
	
}
