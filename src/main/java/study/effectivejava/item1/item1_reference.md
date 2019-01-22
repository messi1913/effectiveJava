# 생성자(Constructor)
 - 객체(인스턴스)를 생성(new 키워드 사용) 할때 객체 데이터의 초기화를 하기 위해 사용된다.
 - 생성자가 없으면 default 생성자를 컴파일 시 자동으로 만들어준다.

 사용자 정의 생성자 규칙
1. 값을 반환하지 않는다.
2. 생성자의 이름은 클래스의 이름과 동일하다.
3. 사용자 정의 생성자를 만들면 default 생성자는 만들어지지 않는다.

```java
public class ConsturctorTest {
	int one;
	int two;
	String three;

// 주석 처리 시 default 생성자가 컴파일 시 생성 ( 아래와 동일한 형태 )
    public ConsturctorTest() {

    }

	public ConsturctorTest(int one, int two, String three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
```






# Static
인스턴스를 생성하면 각 인스턴스들은 서로 독립적이기때문에 서로 다른 값을 유지한다. 경우에 따라 공통적으로 같은 값을 유지하기 위해서 static을 사용한다.
클래스가 메모리에 올라갈때 이미 자동적으로 생성이 된다.
static 메서드는 인스턴스 생성 없이 호출이 가능하기 때문에 인스턴스가 생성 되있을수도 안되어있을수도 있기 때문에 static 변수만 사용 가능하다.

```java
//정적 변수
static int one;
static int two;

//정적 메소드
public static int sum() {
  // 정적 변수 사용
	return StaticMethodTest.one + StaticMethodTest.two;
}
// 정적 메소드 사용 : 객체 생성 없이 사용 가능
StaticMethodTest.sum();
```

# 불변클래스(Immutable Class)
 객체가 생성되면 그 값을 변경할 수 없는 클래스를 말한다. ex) String

```java
public class ImmutableClassTest {
  static ImmutableClassTest instance;
  //값 변경 불가
  private int i;

  private ImmutableClassTest() {}

  public static ImmutableClassTest newInstance() {
  	instance = new ImmutableClassTest();

  	return instance;
  }

  //setValue를 통해서만 i 값을 변경 가능할 때, 변경을 위해서는 객체 생성이
  //되면서 이전 객체의 값변경 할 수 없다.
  public int setValue(int value) {
  	instance = new ImmutableClassTest();
  	instance.i = value;

  	return instance.i;
  }
}
```
