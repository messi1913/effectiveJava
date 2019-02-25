# item6 용어정리

**- 박싱(boxing), 언박싱(unboxing)**
* 박싱(boxing)
	-   박싱(boxing)은 기본 자료형의 데이터를 래퍼(wrapper) 클래스의 객체로 만드는 과정

* 언박싱(un-boxing)
	-  언박싱(un boxing)은 래퍼(wrapper) 클래스의 데이터를 기본 자료형으로 얻어내는 과정

* 래퍼(Wrapper)클래스
	-  기본 자료형(int, double, boolean 등)의 데이터를 인스턴스(객체)로 만들기 위해 사용(포장) 하는 클래스<br/>* char형과 int형만 이름이 다르다.


### - 래퍼클래스 예시

| 기본형 | 포장 클래스 | 생성 예 |
|---|:---:|---|
| `boolean` | [B]()oolean | Boolean bA = new Boolean(true);<br/>Boolean bB = new Boolean(“false”); |
| `char` | [Character]() | Character cA = new Character(‘a’); |
| `byte` | [B]()yte | Byte byA = new Byte(10);<br/> Byte byB = new Byte(“127”); |
| `short` | [S]()hort | Short sA = new Short(1234);<br/>Short sB = new Short(“1234”); |
| `int` | [Integer]() | Integer iA = new Integer(1234);<br/>Integer iB = new Integer(“1234”); |
| `long` | [L]()ong | Long lA = new Long(1234);<br/>Long lB = new Long(“1234”); |
| `float` | [F]()loat | Float fA = new Float(12.34f);<br/>Float fB = new Float(“12.34f”); |
| `double` | [D]()ouble | Double dA = new Double(12.34);<br/>Double dB = new Double(“12.34”); |
    생성자는 위와 같이 해당하는 기본형 값을 줄 수도 있고 문자열로 줄 수도 있다.
    문자열로 주는 경우 해당 데이터형의 형식에 맞아야 한다.


### - 박싱, 언박싱 예시
```java
package study.effectivejava.item6;

public class Boxing {
	public static void main(String[] args) {
		Integer iA = new Integer(123);
		Integer iB = new Integer(123);
		
		int ia = (int) iA;          // (1) 언박싱(unboxing)
		int ib = iB;                // (2) 오토언박싱(auto unboxing)
		Integer iC = (Integer) 456; // (3) 박싱(boxing)
		Integer iD = ia;            // (4) 오토 박싱(auto boxing)
	}
}
```
    박싱(boxing)이란 기본형을 참조형으로 변환하는 것이고 언박싱(unboxing)이란 반대로 참조형을 기본형으로 바꾸는 것이다.
    그리고 JDK 1.5부터는 이것을 자동으로 해주는 기능이 추가되었다.
