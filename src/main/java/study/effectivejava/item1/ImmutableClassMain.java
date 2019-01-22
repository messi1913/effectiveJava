package study.effectivejava.item1;

public class ImmutableClassMain {
	
	public static void main(String[] args) {
		//사용 불가
		ImmutableClassTest i = new ImmutableClassTest();
		
		ImmutableClassTest i1 = ImmutableClassTest.newInstance();
		ImmutableClassTest i2 = ImmutableClassTest.newInstance();
		
		System.out.println(i1.equals(i2));
		
		ImmutableClassTest i3 = ImmutableClassTest.getInstance();
		ImmutableClassTest i4 = ImmutableClassTest.getInstance();
		
		System.out.println(i3.equals(i4));
		
	}
}
