package study.effectivejava.item4.abstr;

public abstract class AbstractClass {

	int a;

	static int b;

	abstract void methodTest(); // extends 하는 하위 클래스에 이 메소드의 overide를 강제
								// 하나이상의 abstract 메소드를 가지고 있다면, abstract Class가 되어야한다
								// 혹은 abstract 메소드가 없어도 명시적으로 abstract Class를 지정할수있다.
	
	static void methodTest2() {
		//System.out.println(a);
		System.out.println(b);
	};
	
	void methodTest3() {
		System.out.println(a);
		System.out.println(b);
	};

}
