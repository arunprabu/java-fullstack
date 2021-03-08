package com.examples.java.exception;

public class ExceptionEx {

	public static void main(String[] args) {

		try {
			compute();
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e)
		{
			System.out.println("Exception: " +  e.getMessage());
			e.printStackTrace();			
		}		
		finally {
			System.out.println("Finally invoked");
		}
		// System.out.println(countries[4]);
	}
	
	public static int compute() throws CustomException 
	{
		// throws arithmetic exception
		// int a = 10 / 0;
		// System.out.println(a);
		
		// throws custom exception
		throw new CustomException("Custom exception triggered");		
	}
}
