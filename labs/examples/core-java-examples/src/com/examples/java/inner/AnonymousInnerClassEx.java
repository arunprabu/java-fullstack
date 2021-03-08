package com.examples.java.inner;

public class AnonymousInnerClassEx {

	interface HelloWorld {
		public void greet();

		public void greetSomeone(String someone);
	}

	public void sayHello() {
		
		// Local Class
		class EnglishGreeting implements HelloWorld {
			String name = "Welcome to Anonymous Inner class training...";

			public void greet() {
				greetSomeone(name);
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting();

		
		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monde";

			public void greet() {
				greetSomeone("tout le monde");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
		};

		
		HelloWorld spanishGreeting = new HelloWorld() {
			String name = "mundo";

			public void greet() {
				greetSomeone("mundo");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hola, " + name);
			}
		};
		
		englishGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
		spanishGreeting.greet();
	}

	public static void main(String... args) {
		AnonymousInnerClassEx myApp = new AnonymousInnerClassEx();
		myApp.sayHello();
	}
}
