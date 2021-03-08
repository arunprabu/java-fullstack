package com.examples.java.concurrency;

/**
 * Thread Example
 * Creation of thread by implementing Runnable
 *
 */
public class Eg02 {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");		
		Runnable r1 = new Runnable() {
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
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
