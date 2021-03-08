package com.examples.java.concurrency;

/**
 * Thread Example
 * Creation of thread by extending Thread
 */
public class Eg01 extends Thread{
	
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

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		Eg01 t1 = new Eg01();
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
