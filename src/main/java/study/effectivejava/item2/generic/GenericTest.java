package study.effectivejava.item2.generic;

public class GenericTest {

	public static void main(String[] args) {
		Test<String> a = new Test<>();
		a.setT("111");
		System.out.println(a);

		Test<Integer> b = new Test<>();
		// b.setT( "1111111111" ); complie Err
		b.setT(111);

		Test<Integer> c = new Test<>();
		c.setT(222);

		System.out.println(a.getT() + b.getT());
		System.out.println(b.getT() + c.getT());

		System.out.println("////////////////////////////////////타입 추론//////////////////////////////////");

		System.out.println(Test.method(1111).getClass()); // 넘어온 매개변수의 타입추론에 의하여 제너릭 타입을 Integer 처리
		System.out.println(Test.<Integer>method(1111).getClass());

		System.out.println(Test.method(1111L).getClass()); // 넘어온 매개변수의 타입추론에 의하여 제너릭 타입을 Long 처리
		System.out.println(Test.<Long>method(1111L).getClass());

		System.out.println(Test.method("1111").getClass()); // 넘어온 매개변수의 타입추론에 의하여 제너릭 타입을 String 처리
		System.out.println(Test.<String>method("1111").getClass());

	}

}

class Test<T> {
	private T t;

	/**
	 * @return the t
	 */
	public T getT() {
		return t;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(T t) {
		this.t = t;
	}

	static <S> /* 2 */ S method(S /* 1 */ s) {

		return s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Test [t=" + getT() + "]";
	}

}