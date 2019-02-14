package study.effectivejava.item4.accessa;

import study.effectivejava.item4.accessa.Access.AccessInnerSecond;

public class Access extends AccessModifier {
	public void test() {
		methodB();
		methodC();
		methodD();
		AccessInner dd = new AccessInner();
		System.out.println(dd.a);
	}

	public class AccessInner {
		public int a;
	}

	public static class AccessInnerSecond {
		public int a;
	}
}

class AccessInnerTest {
	public void test() {
		Access test = new Access();
		test.test();

		AccessInnerSecond test2 = new AccessInnerSecond();
		// new AccessInner();
		// new test.AccessInner();
		// new Access.AccessInner();
	}

}