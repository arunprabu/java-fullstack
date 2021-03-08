package com.examples.java.inner;

public class ShadowingEx {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowingEx.this.x = " + ShadowingEx.this.x);
		}
	}

	public static void main(String... args) {
		ShadowingEx shadowingEx = new ShadowingEx();
		ShadowingEx.FirstLevel fl = shadowingEx.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}
