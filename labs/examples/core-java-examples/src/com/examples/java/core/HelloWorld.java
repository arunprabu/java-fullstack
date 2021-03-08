package com.examples.java.core;

/**
 * Contains core java language constructs overview
 */
public class HelloWorld {

	// Constant declaration
	static final int NO_OF_MONTHS_IN_YEAR = 12;

	// to be executed once during class loading
	static {
		System.out.println("Static initializer block..");
	}
	
	// to be executed during instance creation
	{
		System.out.println("Instance initializer block..");
	}		

	public static void main(String[] args) {
		System.out.println("Hello World!");

		// Data Types => Primitive and Non-Primitive
		// Primitive => byte, short, int, long, float, double, char, boolean

		// 1 byte - 8 bits -> 2^8 -> 256
		byte bmin = -128;
		byte bmax = 127;

		// 2 bytes - 16 bits -> 2^16 -> 65536
		short smin = -32768;
		short smax = 32767;

		// 4 bytes - 32 bits -> 2^32 -> 4294967296
		int imin = -2147483648;
		int imax = 2147483647;

		// 8 bytes - 64 bits -> 2^64 -> 18446744073709551616
		long lmin = -9223372036854775808L;
		long lmax = 9223372036854775807L;

		// min - 1.4E-45; max - 3.4028235E38
		float fvalue = 4294967296.55f; // 4 bytes

		// min - 4.9E-324; max - 1.7976931348623157E308
		double dvalue = 4324353453454294967296.5563458888888888876f; // 8 bytes

		char e = 'a'; // 2 bytes

		boolean flag = true; // 1 bit

		// Non-primitive Data Types => Arrays, String, Object
		
		String helloWorldMsg = "Hello World";

		// Variable Types
		// 1) Primitive Variable
		// 2) Reference Variable

		// Operators

		// Arithmatic operators: +, -, *, /, %, ++, --
		// Relational operators: ==, !=, >, <, >=, <=
		// Logical operations: &&, ||, !
		// Bitwise operators: &, |, ^, ~, <<, >>, >>>
		// Assignment operators: =, +=, -=, *=, /=, %=, <<=, >>=, &=, ^=, |=
		// Conditional operator: (expr) ? value if true : value if false
		// instanceOf => ( Object reference variable ) instanceof (class/interface type)

		int a = 2; // 0010
		int b = 2; // 0010 => 0010
		
		// Bit-wise AND operation
		System.out.println("\n" + "Bit-wise operator example...");
		System.out.println(a & b);

		System.out.println("\n" + "Ternary operator example...");
		System.out.println(a == b ? "a and b are equal" : "a and b are not equal");

		// control structure
		// if/else
		System.out.println("\n" + "if..else example...");
		if (a == b) {
			System.out.println("a and b are equal");
		} else {
			System.out.println("a and b are not equal");
		}

		// switch..case statement
		System.out.println("\n" + "switch..case example...");	
		switch (a) {
		case 1:
			System.out.println("a has value 1");
			break;
		case 2:
			System.out.println("a has value 2");
			break;
		default:
			System.out.println("a has value " + a);
		}
		
		// Array -> store the data sequentially
		// Declaration
		int[] nos;
		// Instantiation
		// Initialization
		nos = new int[] {10,20,30};  // -> 4 * 10 -> 40 bytes mem alloted
	
		// Loop control
		// while
		System.out.println("\n" + "while loop example...");	
		int index = 0;
		while(index < nos.length)
		{
			System.out.println(nos[index]);
			index++;
		}
		
		System.out.println("\n" + "do..while loop example...");	
		index = 0;
		// do while
		do
		{
			System.out.println(nos[index]);
			index++;
		}
		while(index < nos.length);
		
		// for
		System.out.println("\n" + "for loop with control structure example...");	
		for(int i = 0; i < nos.length; i++)
		{		
				// switch case control structure
				switch (i) {
				case 0:
					System.out.println(nos[i]);
					// breaks switch-case execution flow
					break;

				default:
					break;
				}
				
				// if-else control structure
				if(i == 1)
				{
					System.out.println(nos[i]);
					// breaks the loop
					break;
				}
				else
				{
					// continues the loop iteration
					continue;
				}
		}
		
		System.out.println("\n" + "for each loop example...");	
		// for each
		for(int item: nos)
		{
			System.out.println(item);

		}
	}
}
