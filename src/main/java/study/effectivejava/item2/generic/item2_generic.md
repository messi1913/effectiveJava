## Java Generic (제너릭, 제네릭,지네릭..........)
#1.프로그래밍 기법
  	일반적 코드를 작성 후 다양한 타입의 객체에 대하여 재사용
  	java 5 부터 사용가능
  
#2. 용법

+example

	List<String> strList = new ArrayList<>();
	List<Ojbect> objList = new ArrayList<>();
	
	public interface List<E> extends Collection<E> {
	..
	
	}
	public class ArrayList<E> extends AbstractList<E>
			implements List<E>, RandomAccess, Cloneable, java.io.Serializable
	{
	...
	}


일반적으로 특정타입만을 담을 수 있는 것 아니라, <> 안에 명시한 타입을 담을 수 있도록 제공.

E - Element
K - Key
N - Number
T - Type
V - Value
뜻이 있는 용어로 제너릭 타입을 명시하는것을 추천.

연습 예제

	class Test<T>
	{
		private T t;

		/**
		 * @return the t
		 */
		public T getT( )
		{
			return t;
		}

		/**
		 * @param t
		 *            the t to set
		 */
		public void setT( T t )
		{
			this.t = t;
		}

		static <S> /* 2 */ S method( S /* 1 */ s )
		{

			return s;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString( )
		{
			return "Test [t=" + getT( ) + "]";
		}

		
		
		public static void main( String[ ] args )
		{
			Test<String> a = new Test<>( );
			a.setT( "111" );
			System.out.println( a );

			Test<Integer> b = new Test<>( );
			//b.setT( "1111111111" ); complie Err
			b.setT( 111 );

			Test<Integer> c = new Test<>( );
			c.setT( 222 );

			System.out.println( a.getT( ) + b.getT( ) );
			System.out.println( b.getT( ) + c.getT( ) );

			System.out.println( "////////////////////////////////////타입 추론//////////////////////////////////" );

			System.out.println( Test.method( 1111 ).getClass( ) ); // 넘어온 매개변수의 타입추론에 의하여 제너릭 타입을 Integer 처리
			System.out.println( Test.<Integer> method( 1111 ).getClass( ) );

			System.out.println( Test.method( 1111L ).getClass( ) ); //넘어온 매개변수의 타입추론에 의하여 제너릭 타입을 Long 처리
			System.out.println( Test.<Long> method( 1111L ).getClass( ) );

			System.out.println( Test.method( "1111" ).getClass( ) ); //넘어온 매개변수의 타입추론에 의하여 제너릭 타입을 String 처리
			System.out.println( Test.<String> method( "1111" ).getClass( ) );

		}

	}

	

> 결과


> Test [t=111]
111111
333
////////////////////////////////////타입 추론//////////////////////////////////
class java.lang.Integer
class java.lang.Integer
class java.lang.Long
class java.lang.Long
class java.lang.String
class java.lang.String



class, interface 에 Generic

class Test<T>
public interface Map<K,V> ...


method 에서의 generic /* 타입추론으로 사용가능*/


참고 : 타입추론 에 대한 JavaDoc
//https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html

	static <S> /* 2 */ S method(S /* 1 */ s) {
			
		return s;
	}

매개변수<1> 로 넘어온 타입에 대한 명시를 각 메소드마다 generic type <2>  명시
Test.method( 1111 ); // 타입추론에 의하여 컴파일러가 제네릭타입을 Integer로 인식

Map<String, String> myMap = new HashMap<String, String>();
Map<String, String> myMap = new HashMap<>(); 
  // 타입추론에 의하여 컴파일러가 HashMap의 제네릭타입을 <String, String> 로 알아먹음. 똑똑캄.

Wild Card - ?... ( 제너릭에서의 다형성 )

1. < ? > 어떤거든 다쓰겠다, 일단드루와, 모르게따....... 등등 내부적으로는 Ojbect로 표현됨.
1. < ? extends A> A를 상속하고 있는 하위타입
1. < ? super A> A의 하이라키 상 상위타입



PS . 좋은 소스를 위하여
5장 제너릭 참고
