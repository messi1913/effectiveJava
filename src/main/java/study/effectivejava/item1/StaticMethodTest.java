package study.effectivejava.item1;

public class StaticMethodTest {
	//���� ����
	static int one;
	static int two;
	
	String three;
	
	public StaticMethodTest(int one, int two, String three) {
		StaticMethodTest.one = one;
		StaticMethodTest.two = two;
		
		this.three = three;
	}
	
	//���� �޼ҵ�
	public static int sum() {
		return StaticMethodTest.one + StaticMethodTest.two;
	}
	
	
	public static void main(String[] args) {
		//���� ������ ��ü ���� ���� ��� ����
		//three�� ���������� �ƴϹǷ� ���� �Ұ�
		StaticMethodTest.one = 4;
		StaticMethodTest.two = 8;
		
		System.out.println(StaticMethodTest.one + ", " + StaticMethodTest.two);
		
		//���� �޼ҵ�� ��ü ���� ���� ��� ����
		System.out.println(StaticMethodTest.sum());
		
		//�����ڸ� ���� ��ü ���� �� �ʱ�ȭ
		//���� ������ �ƴ� three�� ��ü ������ ���ÿ� �ʱ�ȭ ����
		StaticMethodTest t1 = new StaticMethodTest(1, 2, "aaa");
		StaticMethodTest t2 = new StaticMethodTest(1, 2, "bbb");
		
		//System.out.println(t1.one + ", " + t1.two + ", " + t1.three);
		System.out.println(StaticMethodTest.one + ", " + StaticMethodTest.two + ", " + t1.three);
		
		//System.out.println(t2.one + ", " + t2.two + ", " + t2.three);
		System.out.println(StaticMethodTest.one + ", " + StaticMethodTest.two + ", " + t2.three);
	}
}
