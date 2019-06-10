# Lamda 정의 & 예재 & 기술스펙
   
람다란 ? 식별자 없이 실행 가능한 `함수 표현식`
기존의 불필요한 코드를 줄이고 가독성을 향상시키는것에 목적을 두고 있음.

expression 예제

```
	( parameters ) -> expression body
	( parameters ) -> { expression body }
	() -> { expression body }
	() -> expression body
```

Thread - traditional Code

```java
	new Thread(new Runnable() {
		@Override
		public void run() {
			System.out.println("Hello World.");
		}
	}).start();
```

Lambda_Expression_Code

```java
	new Thread(()->{
		System.out.println("Hello World.");
	}).start();
```

