package study.effectivejava.item4.accessb;

import study.effectivejava.item4.accessa.AccessModifier;

class Access extends AccessModifier {
	public void test() {
		// methodA(); 동클래스가 아니니 접근불가
		// methodB(); 동패키지가 아니니 접근불가
		methodC(); // 상속되었으니 접근가능.
		methodD(); // public 이라 접근가능.
	}
}