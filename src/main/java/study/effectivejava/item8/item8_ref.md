# item8 용어정리

**- finalizer, Cleaner**
* finalizer
	- 최상위 클래스인 Object 클래스는 finalize라는 메소드를 갖고있다.
    이 클래스는 객체가 기비지 콜렉션 과정에서 가지고 있던 리소스가 반환될 때 해야 할 일을 에 대한 정의를 가지고 있다.
    물론, 사용자가 정의한 클래스에서 재정의가 가능하다.
    자바 9에서는 deprecated됨

* Cleaner
	-  deprecated된 finalizer를 대신하여 나온 객체
     허나 finalizer와 마찬가지도 위험부담이 따른다.
     
## 자바 네이티브 메서드
  - 다른 언어로 작성된 코드를 자바에서 호출하도록 만들어진 규약
  - 현재는 C/C+에 대한 호출만을 정확하게 지원함
  - 자바의 속도 문제 또는 legacy 시스템과의 연계 문제 때문에 사용함

## 참고

* [finalizer](https://starplaying.tistory.com/129), (https://sjh836.tistory.com/168)
* [네이티브 메서드](https://roughexistence.tistory.com/81)
