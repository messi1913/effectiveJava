# Comparable을 구현할지 고려하라


Comparable에 존재하는 유일무이한 `compareTo` 메서드
성격은 Object의 `equals` 와 비슷
단 2가지 차이
    - 동치성에 비교해서 순서까지 비교할 수 있음. 
    - 제네릭함

Comparable을 implements 한 구현체들은  그 클래스의 인스턴스들에 자연적인 순서가 있음을 뜻한다.

```java
    Arrays.sort(a);
```
위의 메서드로 손쉽게 배열을 정리할 수 있다.

compareTo 메서드의 규약 (equals과 비슷)
    -1 0 1을 반환해야함
    
    1 . 비교되는 객체 x,y 에 대해서 x.compareTo(y) == -y.compareTo(x) 여야함.
    2 . Comparable을 구현한 클래스는 추이성을 보장해야한다. x.compareTo(y) > 0 , y.compareTo(z) > 0 이면 x.compareTo(z) > 0 여야함.
    3 . 모든 z에 대해 x.compareTo(y) == 0 이면 x.compareTo(z), y.compareTo(z)는 동일해야 한다
    4 . 필수사항은 아니지만 x.compareTo(y) == 0 이면 x.equals(y)    는 true 인 것이 좋다.
    

4 에 대한 추가 설명
    equals와 compareTo의 동치성이 어긋나는 경우, Collection 이하의 구현체들은 구현체에서 정의된
    동작과 엇박자를 낼수 있다. 
    Collection들은 동치성을 비교할때 equals 대신 compareTo를 사용하고 있다.

    BigDecimal의 경우 compareTo와 equals가 일관되지 않다. 
    new BigInteger