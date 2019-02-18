package study.effectivejava.item4.abstr;

public class Main {

	public static void main(String[] args) {

		//AbstractClass instance = new AbstractClass();
		//InterFaceExam instance = new InterFaceExam();
		
		// 물론 이제 익명클래스로 선언해서 바로 인스턴스하는 과정을 거치면 가능은 함
		
		TestClass d = new TestClass();
		d.methodTest();
		d.methodTest2();
		d.methodTest3();

		System.out.println("ddddddddddddddddddddddddddd");
		
		TestClass.methodTest2(); // ?????
		AbstractClass.methodTest2(); // ????? 모호..
		
		System.out.println("ddddddddddddddddddddddddddd");
		
		TestClass.b = 1;
		TestClass.methodTest2(); // ?????
		AbstractClass.methodTest2(); // ????? 모호..
		
		System.out.println("ddddddddddddddddddddddddddd");
		
		AbstractClass.b = 2;
		TestClass.methodTest2(); // ?????
		AbstractClass.methodTest2(); // ????? 모호..
		
		System.out.println("ddddddddddddddddddddddddddd");
		
		
		
		TestClass2 dd = new TestClass2();

		dd.methodTest();
		dd.methodTest3();
		
		System.out.println(TestClass2.a);
		System.out.println(InterFaceExam.a);
		// TestClass2.a  = 1; error
		// InterFaceExam.a  = 1; error

		// TestClass.methodTest2();
		InterFaceExam.methodTest2();

	}

}
