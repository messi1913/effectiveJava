package study.effectivejava.item4.abstr;

public class Main {

	public static void main(String[] args) {

		TestClass d = new TestClass();
		d.methodTest();
		d.methodTest2();
		d.methodTest3();

		TestClass.methodTest2(); // ?????
		AbstractClass.methodTest2(); // ?????

		TestClass2 dd = new TestClass2();

		dd.methodTest();
		dd.methodTest3();

		// TestClass.methodTest2();
		InterFaceExam.methodTest2();

	}

}
