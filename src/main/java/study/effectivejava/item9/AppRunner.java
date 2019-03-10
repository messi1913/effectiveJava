package study.effectivejava.item9;

public class AppRunner {

    public static void main(String[] args) {
//        MyResource myResource = new MyResource();
//        try {
//            myResource.doSomething();
//        } catch (FirstError error) {
//            System.out.println("first error");
//            throw error;
//        } finally {
//            myResource.close();
//        }
        try (MyResource myResource = new MyResource()){
            myResource.doSomething();
        }
    }
}
