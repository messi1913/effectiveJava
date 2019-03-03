# 아이템 7 용어정리

JAVA는 C,C++처럼 메모리를 직접 관리않고 GC(Garbage collector)을 이용하여 스스로 메모리를 해제한다.
하지만 그렇다고 메모리관리에 아예 신경을 안써도 되는 것은 아니다.

##Garbage란?
가비지란 정리되지 않은 메모리, 유효하지 않은 메모리 주소를 말합니다.

## 예제
```java
int[] array = new int[3];
 
array[0] = 0;
array[1] = 10;
array[2] = 20;
 
array = new String[] {'하하', '호호', '히히', '후후', '헤헤'};
 
System.out.println(array[0]);
```

## WeakHashMap(약한 참조 해시맵)
Java에는 세 가지 유형의 참조가 존재

1. 강한 참조(String Reference)
   Integer prime = 1;   
   => 가장 일반적인 참조 유형, 강한 참조는 GC의 대상이 되지 않는다.
2. 부드러운 참조(Soft Reference)
   SoftReference<Integer> soft = new SoftReference<Integer>(prime); 
   prime == null인 경우에 GC대상으로 판단 
   메모리가 부족하지 않으면 GC대상이 아니다.
3. 약한 참조(Weak Reference)
   WeakReference<Integer> soft = new WeakReference<Integer>(prime);
   prime == null인 경우에 GC대상으로 판단 + 메모리가 부족하지 않아도 GC의 대상

## 참고

* [가비지 컬렉터](https://ko.wikipedia.org/wiki/%EC%93%B0%EB%A0%88%EA%B8%B0_%EC%88%98%EC%A7%91_(%EC%BB%B4%ED%93%A8%ED%84%B0_%EA%B3%BC%ED%95%99))
* [가비지 컬렉터](https://wanzargen.tistory.com/15)
* [WeakHashMap] http://blog.breakingthat.com/2018/08/26/java-collection-map-weakhashmap/
