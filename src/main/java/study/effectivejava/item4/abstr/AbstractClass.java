package study.effectivejava.item4.abstr;

public abstract class AbstractClass {

	int a;

	static int b;

	abstract void methodTest(); // extends 하는 하위 클래스에 이 메소드의 overide를 강제

	static void methodTest2() {
		//System.out.println(a);
		System.out.println(b);
	};
	
	void methodTest3() {
		System.out.println(a);
		System.out.println(b);
	};

}
