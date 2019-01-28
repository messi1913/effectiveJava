package study.effectivejava.item1;

public class ImmutableClassMain {
	
public static void main(String[] args) {
		
		ImmutableClassTest t1 = ImmutableClassTest.newInstance();
				
		t1.setValue(111);
		
		t1.setValue(222);
		
		
		String a = "aaaa";
		System.out.println(a.hashCode());
		
		a = "bbbb";
		System.out.println(a.hashCode());
		
		a = "cccc";
		System.out.println(a.hashCode());
		
		
		
	}
}
