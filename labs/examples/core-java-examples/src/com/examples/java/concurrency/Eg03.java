package com.examples.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Thread Example
 * Creation of thread by implementing Callable
 *
 */
public class Eg03{
	
	 public class MyCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				//throw new MyException();
			}
			System.out.println(Thread.currentThread().getName() + " -->Stop thread");
			return "Hello World";
		}
	}

	public static void main(String[] args) {
		Eg03 eg = new Eg03();
		
//		List<Callable<String>> callList = new ArrayList<>();
		Callable<String> c1 = eg.new MyCallable();
				
//		Callable<String> c2 = eg.new MyCallable();
//		callList.add(c1);
//		callList.add(c2);
		
		ExecutorService e = Executors.newFixedThreadPool(1);
//		List<Future<String>> futureList = null;
//		try {
//			futureList = e.invokeAll(callList);
//		} catch (InterruptedException e2) {
//			e2.printStackTrace();
//		}
		Future<String> f = e.submit(c1);
//		for (Future<String> f : futureList) {
			while(!f.isDone()) {
				System.out.println(Thread.currentThread().getName() + " -->Waiting");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			String s = null;
			try {
				s = f.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Reuturned Value:" + s);			
//		}
		
	}
}
