## 점층적 생성자 패턴 (telescoping constructor pattern)
한 클래스 내에서 **오버로딩**을 통해 생성자를 여러개 작성하는 것

```java
public class Employee {
	private final String id; // 필수값
	private final String name; // 선택값
	private final int age; // 선택값
	private final String dept; // 선택값

	// 필수 생성자
	public Employee(String id){
		this(id, "이름 모름", 0, "부서 모름");
	}
	
	// 필수값과 이름 받는 경우
	public Employee(String id, String name){}{
		this(id, name, 0, "부서 모름");
	}

	// 필수값과 이름, 나이 받는 경우
	public Employee(String id, String name, int age){
		this(id, name, age, "부서 모름");
	}
	
	// 다 받는 경우
	public Employee(String id, String name, int age, String dept){
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
}
```

```java
// 인스턴스 생성
Employee emp = new Employee("y0521.sung");
Employee emp = new Employee("y0521.sung", "성연준");
Employee emp = new Employee("y0521.sung", null, 0, null);
Employee emp = new Employee("y0521.sung", null, 32, null);
Employee emp = new Employee("y0521.sung", null, 32, "MES");
Employee emp = new Employee("y0521.sung", "성연준", 32, "MES");
````
- 장점
. **new Employee("y0521.sung",  "이름모름", 0, "부서모름")** 과 같은 호출이 자주 일어날 경우
**new Employee("y0521.sung")** 으로 대체 가능
- 단점
. 같은 이름의 매개변수가 다른 생성자를 호출하는 생성자가 많으므로, 매개변수가 추가되면 코드 수정이 어려워 질 수 있다.
. 매개변수가 많아지면 해당 값의 의미를 알기 어렵다.
. 가독성이 떨어진다.


## 자바 빈 패턴 (JavaBeans pattern)
매개변수가 없는생성자로 객체를 만든 후, **setter** 메서드를 호출해 값을 설정하는 방식
```java
public class Employee{
	private String id = "";
	private String name = "";
	private int age = 0;
	private String dept = "";
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
		
	public void setAge(int age) {
		this.age = age;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
```
```java
Employee emp = new Employee();
emp.setId("y0521.sung");
emp.setName("성연준");
emp.setAge(32);
emp.setDept("MES");
```
- 장점
. 각 매개변수 별 의미 파악이 쉬워짐
. 여러개 생성자를 만들 필요가 없다.
. 가독성 확보
- 단점
. 함수 호출 1회로 객체 생성을 끝낼 수 없다. ( 생성한 객체에 값을 set 해줘야함)
 -> 객체 일관성(consistency)이 깨진다.
. setter 메서드로 인해 불변 클래스를 만들 수 없음.

## 빌더 패턴 (Builder pattern)

점층적 생성자 패턴의 안전성과 자바빈즈 패턴의 가독성을 겸비.
사용자는 필요한 객체를 직접 생성하는 대신, 필수 인자를 전달하여 빌더 객체를 만든 뒤, 빌더 객체에 정의된 설정 메서드들을 호출하여 인스턴스 생성

```java

public class EmployeeInfo {
	private String id = "";
	private String name = "";
	private int age = 0;
	private String dept = "";
	
	public EmployeeInfo(String id, String name, int age, String dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getEmployeeInfo() {
		String employeeInfo = String.format("id : %s, name : %s, age : %d, dept : %s", id, name, age, dept);
		return employeeInfo;
	}
	
}
```
```java

public class EmployeeBuilder {
	private String id = "";
	private String name = "";
	private int age = 0;
	private String dept = "";
	
	public EmployeeBuilder setId(String id) {
		this.id = id;
		return this;
	}
	
	public EmployeeBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public EmployeeBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	
	public EmployeeBuilder setDept(String dept) {
		this.dept = dept;
		return this;
	}
	
	public EmployeeInfo build() {
		EmployeeInfo ei = new EmployeeInfo(id, name, age, dept);
		return ei;
	}
	
	
	public static void main(String [] args) {
		EmployeeBuilder employeeBuilder = new EmployeeBuilder();
		EmployeeInfo employeeInfo = employeeBuilder.setAge(32).setDept("MES").setId("y0521.sung").setName("성연준").build();
		System.out.println(employeeInfo.getEmployeeInfo());
	}
}
```
- 장점
. 각각의 매개변수의 의미파악이 쉽다.
. 한번에 객체 생성이 가능하다
. build() 메서드에 입력 파라미터에 대한 유효성 검사 로직을 추가 가능
- 단점
 . 점층적 생성자 패턴보다 코드가 길어, 매개변수가 4개 이상 될 때부터 유용하게 쓰임
 . 객체 생성 전 빌더부터 만들어야 함
