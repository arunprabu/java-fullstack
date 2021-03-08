package com.examples.java.oops;

public class ProjectorDemo {
	
	public static void main(String[] args)
	{
		// Object Declaration
		Projector epson;
		//Projector.id = 10;
		//Projector.printProjectorDetail();
		
		// Instantiation -> Construction & Initialization
		epson = new Projector("Epson","E105","White",10);
		int size = epson.getSize();
		System.out.println(size);
		//epson.printProjectorDetail();
		
		/*String message = "Hello";		
		print(message);	// pass by value		
		System.out.println(message); // Hello
		System.out.println();
		print(epson);
		System.out.println();
		epson.printProjectorDetail();*/
		
		

		
		
		
//		epson.switchOn();
//		epson.zoomIn(100);
//		epson.zoomOut(50);
//		epson.switchOff();
		
		// 
		//Projector samsung = new Projector("Samsung","S105","Black",20);
		//samsung.printProjectorDetail();
//		samsung.switchOn();
//		samsung.zoomIn(200);
//		samsung.zoomOut(100);
//		samsung.switchOff();
	}
	
	public static void print(String message)
	{
		message = "Hello World";
		System.out.println("Print method called with pass by value: " + message); // Hello World
	}

	public static void print(Projector proj)
	{
		proj.model = "K897";
		proj.printProjectorDetail();
	}
}
