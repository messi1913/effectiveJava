# 변경가능성을 최소화 하라

**불변 클래스** : 인스턴스의 내부값을 수정 할 수 없는 클래스

간직된 정보는 객체가 파괴될 때 까지 들고있으..

String, 기본타입의 박싱 클래스들, BigInteger..

**불변클래스의 핵심**
*	객체의 상태를 변경하는 메서드를 제공하지않는다.		
*	클래스를 확장 할 수 없도록한다.
*	모든 필드를 final로 선언한다.
*	모든 필드를 private으로 선언한다.
*	자신 외에는 내부의 가변 컴포넌트에 접근 할 수 없도록 한다.
	

 
```java
	public final class Complex {

		private final double re;
		private final double im;
	
		public Complex(double re, double im) {
			this.re = re;
			this.im = im;
		}
	
		public double realPart() {
			return re;
		}
	
		public double imaginaryPart() {
			return im;
		}
	
		public Complex plus(Complex c) {
			return new Complex(re + c.re, im + c.im);
		}
		
		
	}
```

**사칙연산 메소드들이 값을 바꾸지않고, 새로운 객체를 반환하는 것에 주목.** 
 피연산자가 그대로인것 함수형 프로그래밍.

	
**불변이 되는 영역의 비율이 높아지는 장점.** 
> 프로그래머가 다른 노력을 들이지 않아도 불변이 됨으로써, 가변객체가 가지는 불확실성, 임의의 복잡한 상태에서 벗어 날 수 있음.
> 변경자 메서드가 일으키는 상태 전이를 정밀하게 문서로 남겨놓지 않으면, 사용하기 굉장히 까다로움.

	
불변 객체는 근본적으로 Thread safe , 동기화에 대한 걱정을 덜 수 있다. -> 클래스를 가장 간단하게 Thread safe하게 만드는 방법.

불변 객체는 안심하고 공유가능. 인스턴스를 재사용 하는것을 권장.


Complex 클래스가 제공 할 수 있는 상수들


```java
	public static final Complex ZERO = new Complex(0,0);
	public static final Complex ONE = new Complex(1,0);
```


정적 팩토리 (item 1)를 제공할 수 있어, 여러 클라이언트가 한 인스턴스를 볼 수 있도록 처리가능.
> 이는 가비지 컬렉션 비용을 줄일 수 있고, 메모리 사용량을 줄 일 수 있다.

새로운 클래스를 설계할때, 정적 팩토리를 만들어두면, 클라이언트를 수정하지 않는 선에서, 캐싱기능을 덧붙일수 있음.

불변 객체는 자유롭게 공유가능, 불변객체끼리 내부 데이터 공유가능.



 

	
 

#핵심정리



