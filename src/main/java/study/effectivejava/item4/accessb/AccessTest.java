package study.effectivejava.item4.accessb;

import study.effectivejava.item4.accessa.AccessModifier;

public class AccessTest {
	public static void main(String[] args) {
		AccessModifier test = new AccessModifier();
		// System.out.println(test.a);
		// System.out.println(test.b);
		// System.out.println(test.c);
		System.out.println(test.d); // public 이므로 access 가능
		
		//test.methodA();
		//test.methodB();
		//test.methodC();
		test.methodD();
	}
}