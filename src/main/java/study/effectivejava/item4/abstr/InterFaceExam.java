package study.effectivejava.item4.abstr;

public interface InterFaceExam {
	int a = 0; // It's Final field 상수야 상수

	void methodTest();

	static void methodTest2() {
		System.out.println(a);
	};

	default void methodTest3() {
		System.out.println(a);
	};
}