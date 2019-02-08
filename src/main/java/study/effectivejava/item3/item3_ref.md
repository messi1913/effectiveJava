## 싱글턴 패턴 (Singleton pattern)
**인스턴스가 오직 하나만 생성**되는 것을 보장, 이 인스턴스에 어디에서든 접근할 수 있도록 하는 디자인 패턴.
- 싱글톤 패턴은 어플리케이션이 시작될 때 특정 클래스가 객체를 생성할 때 최초 한번만 메모리를 할당하고, 그 메모리에 인스턴스를 만들어 사용하는 디자인 패턴을 말한다.
- 생성자가 여러 차례 호출되더라도 실제로는 최초에 생성된 객체를 반환한다.

- 사용자 모두가 인스턴스가 필요할때마다 생성하게 되면 무분별한 객체 생성 및 메모리를 크게 차지 하기 때문에 하나의 인스턴스만 선언하여 사용하도록 한 것.
- 싱글톤 패턴을 적용하면 생성자의 접근 제어 수식어가 private이기 때문에 외부에서는 생성자를 이용해 접근을 할 수 없고, 정적 메소드인 getInstance() 메소드를 사용해서 객체를 구한 후 사용한다.


장점
- 최초에 할당된 메모리를 재사용하기 때문에 메모리의 낭비를 줄일 수 있고 싱글톤으로 만들어진 인스턴스는 전역이기 때문에 다른 클래스의 인스턴스들과 공유하기 쉽다.
- 커넥션 풀이나 스레드 풀과 같은 자원 풀을 관리하는데 사용된다.
- 싱글톤 패턴은 인스턴스가 필요한 상황에서만 생성하기 때문에 자원관리가 효율적이다.


구현방법

```java
public class Singleton{
  //싱글톤 클래스의 유일한 인스턴스를 저장하기 위한 정적 변수.
  private static Singleton one;
  //생성자를 private으로 선언했기 때문에 Singleton 클래스에서만 인스턴스를 만들 수 있다. 
  private Singleton() {}
  //Singleton 타입의 인스턴스가 null이면 인스턴스를 하나 만들고
  //존재한다면 존재하는 인스턴스를 리턴한다.
  public static Singleton getInstance() {
    if(one==null){
      one = new Singleton();
    }
    return one;
  }
}

```

문제점
- **멀티 스레드 환경**에서 사용시 경합조건이 발생할 수 있다.
- 경합조건 : 메모리와 같은 동일한 자원을 2개이상의 스레드가 이용하려고 서로 경쟁하는 현상

- 샘플 코드 중 printer 객체 유무를 판단하는 if문에서 경합조건이 발생하여 인스턴스가 1개이상 생성될 수 있다.
- 설명) 스레스1이 if문을 실행하여 생성자를 호출해 인스턴스를 만들기전에 스레드2가 if문을 정상적으로 실행할 경우, 스레드 2가 인스턴스를 생성하고 이후에 스레드 1도 인스턴스를 생성하여 결과적으로 2개의 인스턴스가 생성됨.

해결방법
- 정적변수에 인스턴스를 만들어 바로 초기화 하는 방법
- getInstance()메소드를 만들 때 synchronized 키워드를 사용해 한 스레드가 메소드 사용을 끝낼 때까지 다른 스레드는 사용을 할 수 없도록 하는 방법.(인스턴스를 만드는 메서드에 동기화)

```java
/*해결방법1 : 정적변수에 인스턴스를 만들어 바로 초기화 하는 방법*/
class Printer{
  //정적변수는 객체가 생성되기 전 클래스가 메모리에 로딩될 때 만들어져 초기화가 한번만 실행된다.
	private static Printer printer = new Printer();
	private Printer() {}
	
	public static Printer getPrinter() {
		//다중 스레드 환경에서 문제를 일으켰던 if(printer == null) 조건 검사구문을 원천적으로 제거.
		return printer;
	}
	
	public void print(String str) {
		System.out.println(str);
	}
}

/*해결방법2 : 인스턴스를 만드는 메서드에 동기화 하는 방법*/
class Printer{
	private static Printer printer = null;
	private Printer() {}
	
	//객체를 얻는 getPrinter 메서드를 동기화(synchronized)
	//동시에 여러스레드가 getPrinter 메서드를 소유하는 객체에 접근하는 것을 방지한다.
	public synchronized static Printer getPrinter() {
		if(printer == null) {
			printer = new Printer();		
		}
		return printer;
	}
	
	public void print(String str) {
		System.out.println(str);
	}
}

```