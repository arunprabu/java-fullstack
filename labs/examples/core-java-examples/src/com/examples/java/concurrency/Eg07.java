package com.examples.java.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.examples.java.concurrency.pc3.Consumer;
import com.examples.java.concurrency.pc3.Producer;

/**
 * Thread Example
 * Producer Consumer using BlockingQueue
 *
 */
public class Eg07 {
	public static void main(String[] args) {
		BlockingQueue<Double> q = new LinkedBlockingQueue<Double>(5);
		Consumer c = new Consumer(q);
		Producer p = new Producer(q);
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(p);
		t2.start();
		t1.start();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
	}
}
