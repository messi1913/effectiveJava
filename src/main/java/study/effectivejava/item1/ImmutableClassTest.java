package study.effectivejava.item1;

public class ImmutableClassTest {
	
	static ImmutableClassTest instance;
	static final ImmutableClassTest instance2 = new ImmutableClassTest(); 
	
	private int i;
	
	private ImmutableClassTest() {}
	
	public static ImmutableClassTest newInstance() {
		instance = new ImmutableClassTest();
		
		return instance;
	}
	
	
	public int setValue(int value) {
		instance = new ImmutableClassTest();
		instance.i = value;
		
		return instance.i;
	}
	
	
	
	
	
}
