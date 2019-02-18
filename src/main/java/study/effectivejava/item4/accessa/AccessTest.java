package study.effectivejava.item4.accessa;

public class AccessTest {
	public static void main(String[] args) {
		AccessModifier test = new AccessModifier();
		// System.out.println(test.a); // 같은 클래스 아니므로 컴파일에러
		System.out.println(test.b); // 동패키지 이므로 access 가능
		System.out.println(test.c); // 동패키지 이므로 access 가능
		System.out.println(test.d); // public 이므로 access 가능

		Access testExtends = new Access();
		// System.out.println(testExtends.a); // 같은 클래스 아니므로 컴파일에러
		System.out.println(testExtends.b); // 동패키지 이므로 access 가능
		System.out.println(testExtends.c); // 동패키지 이므로 access 가능
		System.out.println(testExtends.d); // public 이므로 access 가능
	}
}