# item9 용어정리

**- AutoCloseable 인터페이스**

* JDK1.7에는 AutoCloseable 인터페이스가 추가
```java
  public interface AutoCloseable {
      void close() throws Exception;
  }
```


# MES JAVA 소스 적용 예

**- gmes-base > SmFileApp.java  > line130**

* 현재 소스 
```java
		ServletOutputStream out = svo.getResponse().getOutputStream();
		try {
        		....
         } catch (Gmes2LogicException ex) {
        		....
         } catch (Exception ex) {
        		....
         } finally {
			out.flush();
			out.close();
		}
```

* 적용 소스
```java
		try(ServletOutputStream out = svo.getResponse().getOutputStream()) {
        		....
         } catch (Gmes2LogicException ex) {
        		....
         } catch (Exception ex) {
        		....
         }
```

**- gmes-base > FuncUtil.java  > line62**

* 현재 소스 
```java
		JarInputStream crunchifyJarFile = null;
		try {
        		....
         } catch (Exception ex) {
        		....
         } finally {
			crunchifyJarFile.close();
		}
```

* 적용 소스
```java
		try(JarInputStream crunchifyJarFile = null) {
        		....
         } catch (Exception ex) {
        		....
         }
```