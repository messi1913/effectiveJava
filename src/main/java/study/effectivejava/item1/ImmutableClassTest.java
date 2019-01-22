package study.effectivejava.item1;

public class ImmutableClassTest {
	static ImmutableClassTest instance;
	static final ImmutableClassTest instance2 = new ImmutableClassTest(); 
	
	
	//private �����ڸ� ���� ��ü ������ ���ϰ� ����
	private ImmutableClassTest() {}
	
	//���� �޼ҵ带 ���� ��ü ����
	//��ü�� ������ �ȵ� ��쿡�� �����ǰ� ��
	public static ImmutableClassTest getInstance() {
		if(instance == null)
			instance = new ImmutableClassTest();
		return instance;
	}
	
	public static ImmutableClassTest newInstance() {
		return instance2;
	}
	
}
