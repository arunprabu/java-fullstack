package com.examples.java.core;

import java.util.Arrays;

public class ArraysClassDemo {

	public static void main(String[] args) {
		int[] test = new int[3];
		
		// filling values
//		Arrays.fill(test, 100);
		test[0] = 30;
		test[1] = 50;
		test[2] = 20;
		
		for (int i : test) {
			System.out.println(i);
		}
		

//		int[] test1 = Arrays.copyOf(test, 3);
//		
//		for (int i : test1) {
//			System.out.println(i);
//		}
		
		// Sorting
		Arrays.parallelSort(test);
		
		for (int i : test) {
			System.out.println(i);
		}
		
	}

}
