package study.effectivejava.item4.accessa;

public class AccessModifier {
	private int a;
	int b;
	protected int c;
	public int d;

	private void methodA() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	};

	void methodB() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	};

	protected void methodC() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	};

	public void methodD() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	};
}

