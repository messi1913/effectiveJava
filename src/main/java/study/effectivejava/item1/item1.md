# Item 1. 생성자 대신 static 팩토리 메소드를 고려해 봐라.

기본 : public 생성자를 통해서 인스턴스를 얻는다. 
변경 : 정적 팩토리 메서드 (static factory method) 를 제공할 수 있다. 

```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;
} 
``` 

## 장점 
1. 이름을 가질 수 있다. 
    - 생성자에 제공하는 파라메터가 거기서 반환하는 객체를 잘 설명하지 못할 경우에, 잘 만든 이름을 가진 static 팩토리를 사용하는 것이 사용하기 보다 더 쉽고 (해당 팩토리 메소드의 클라이언트 코드를) 읽기 편한다. 그 예로 `BigInteger.probablePrime`을 들고 있다.<br>
  또, 생성자는 시그니처에 제약이 있다. 똑같은 타입을 파라미터로 받는 생성자 두개를 만들 수 없으니까 그런 경우에도 public static 팩토리 메소드를 사용하는것이 유용하다.
  
2. 호출 될 때마다 인스턴스를 새로 생성하지 않아도 된다.
    - 불변클래스(immutable class) 인 경우나 매번 새로운 객체를 만들 필요가 없는 경우에 미리 만들어둔 인스턴스 또는 캐시해둔 인스턴스를 반환할 수 있다. `Boolean.valueOf(boolean)` 메소드도 그 경우에 해당한다.
    
3. 반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다. 
    - 반환 할 수 있는 객체를 선택 할 수 있는 유연성을 제공한다. 리턴 타입의 하위 타입의 인스턴스를 만들어줘도 되니까, 리턴 타입은 인터페이스로 지정하고 그 인터페이스의 구현체는 API로 노출 시키지 않지만 그 구현체의 인스턴스를 만들어 줄 수 있다. `java.util.Collections`가 그 예에 해당한다.<br>
     Collections 는 45개에 달하는 구현체들은 전부 non-public 이다. 즉 인터페이스 뒤에 감쳐줘 있어서 public 으로 제공해야 할 API 를 줄였을 뿐 아니라 개념적인 무게(conceptual weight)까지 줄일 수 있었다.
     여기서 개념적인 무게란, 프로그래머가 어떤 인터페이스가 제공하는 API 를 사용할 때 알아야 할 개념의 개수와 난이도를 말한다. <br>
     자바 8부터  인터페이스에 public static 메소드를 추가할 수 있게 되었지만 private static 메소드는 자바 9부터 추가할 수 있다. 따라서 자바 8부터 인터페이스에 public static 메소드를 사용해서 그 인터페이스의 구현체를 메소드를 제공할 수도 있지만 private static 메소드가 필요한 경우, 자바 9가 아니면 기존처럼 별도의 (인스턴스를 만들 수 없는, `java.util.Collections` 같은) 클래스를 사용해야 할 수도 있다.
     
4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환 할 수 있다. 
    - `EnumSet` 클래스는 생성자 없이 public static 메소드, `allOf()`, `of()` 등을 제공한다. 그 안에서 리턴하는 객체의 타입은 enum 타입의 개수에 따라 `RegularEnumSet` 또는 `JumboEnumSet`으로 달라진다.
    
5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
    - 이런 유연함은 서비스 제공자 프레임워크 (service provider framework) 를 만드는 근간이 된다. 
      `서비스 프로바이더` 프레임워크는 서비스의 구현체를 대표하는 `서비스 인터페이스`와 구현체를 등록하는데 사용하는 `프로바이더 등록 API` 그리고 클라이언트가 해당 서비스의 인스턴스를 가져갈 때 사용하는 `서비스 엑세스 API`가 필수로 필요하다. 부가적으로, 서비스 인터페이스의 인스턴스를 제공하는 `서비스 프로바이더 인터페이스`를 만들 수도 있는데, 그게 없는 경우에는 리플랙션을 사용해서 구현체를 만들어 준다.<br>
      `JDBC`의 경우, `DriverManager.registerDriver()`가 `프로바이더 등록 API`. `DriverManager.getConnection()`이 `서비스 엑세스 API`. 그리고 `Driver`가 `서비스 프로바이더 인터페이스` 역할을 한다.<br>
      자바 6부터는 `java.util.ServiceLoader`라는 일반적인 용도의 서비스 프로바이더를 제공하지만, `JDBC`가 그 보다 이전에 만들어졌기 때문에 `JDBC`는 `ServiceLoader`를 사용하진 않는다.
      
## 단점
1. 상속을 하려면 public 이나 protected 생성자가 필요하니 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다. 
    - 컬렉션 프레임워크의 유틸리티 구현 클래스들은 상속할 수 없다는 이야기다. 오히려 장접일 수 있음. 
    
2. 정적 팩터리 메서드는 프로그래머가 찾기 어렵다. 
    - JavaDoc 의 경우 생성자 API 설명은 명확히 드러나나 정적 팩터리 메서드는 그렇지 않다. 그러므로 주석을 잘 달던 명명방식을 잘 지키자. 
    
    
### Static Method Types
 - from : 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드. <br> 
   ```java
   Date d = Data.form(instance);
   ```
 - of : 여러 매개변수를 받아서 적합한 타입의 인스턴스를 반환하는 형변환 메서드. <br> 
   ```java
   Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);
   ``` 
 - valueOf : from 과 of 의 더 자세한 버전. <br> 
   ```java
   BigInteger prime = BigInteger.valueOf(Integer.MAX_VALUE);
   ```
 - instance/getInstance : 매개변수로 명시한 인스턴스를 반환 같은 인스턴스를 보장하지 않는다. <br> 
    ```java
    StackWalker luke = StackWalker.getInstance(options);
     ```
 - create/newInstance : 매번 새로운 Instance 를 생성해 반환함을 보장. <br> 
    ```java
    Object newArray = Array.newInstance(classObject, arraylength);
     ```
 - getType : 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의할때 사용. <br> 
     ```java
     FileStore fs = Files.getFileStore(path)
      ```
 - newType : 생성할 클래스가 아닌 다른 클래스에 팩터리 메서드를 정의 할때 . <br> 
     ```java
     BufferedReader reader = File.newBufferedReader(path);
     ```
 - type : getType / newType 의 간결한 버전. <br> 
     ```java
     List<Complaint> list = Collections.list(legacyLitany);
      ``` 
         