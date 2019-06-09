# Public 클래스에서는 public 필드가 아닌 접근자 메서드를 사용하라

패키지 바깥에서 접근할수 있는 클래스라면, 접근자를 제공함으로써 클래스표현방식을 언제든지 바꿀수 있는
유연성을 얻을수 있음

```java
	public class Foo {

		private int a;
		private int b;
	
		public int getA() {
			return a;
		}
	
		public void setA(int a) {
			this.a = a;
		}
	
		public int getB() {
			return b;
		}
	
		public void setB(int b) {
			this.b = b;
		}
	}
```

하지만 package-private 클래스 혹은 private 중첩 클래스라면 데이터필드를 노출한다해도 하등의 문제가 없음.
(내 생각 : 라이브러리로 묶여진 클래스를 사용한다 했을때 동 패키지가 아니면, 접근이 불가능, 사용할수 없음 )


#핵심정리
public 클래스는 절대 가변 필드를 직접노출해서는 안된다. 불변필드라면 노출해도 덜 위험하지만, 완전히 안심할 수 는 없다.
하지만 package-private 클래스나 private 중첩 클래스에서는 종종(가변이든 ,불변이든) 필드를 노출하는 편이 나을 때도 있다.



