package study.effectivejava.item1;

public class ConsturctorTest {
	int one;
	int two;
	String three;
	
	// �����ڴ� Ŭ���� �̸��� ����
	// ��ȯ�ϴ� ���� �����ϸ� �ȵ�
	// �ּ� ó�� �� default �����ڰ� ������ �� ���� ( �Ʒ��� ������ ���� )
//	public ConsturctorTest() {
//		
//	}
	
	public ConsturctorTest(int one, int two, String three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
	
	
	public static void main(String[] args) {
		
		//�����ڸ� �����ϸ� default �����ڸ� ����Ҽ� ����.
		//ConsturctorTest c1 = new ConsturctorTest();
		
		ConsturctorTest c2 = new ConsturctorTest(1, 2, "aaa");
		ConsturctorTest c3 = new ConsturctorTest(3, 4, "bbb");
		
		System.out.println(c2.one + ", " + c2.two + ", " + c2.three);
		System.out.println(c3.one + ", " + c3.two + ", " + c3.three);
		
		System.out.println(c2.equals(c3));
		
		
	}
}
