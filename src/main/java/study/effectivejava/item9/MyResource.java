package study.effectivejava.item9;

public class MyResource implements AutoCloseable{

    public void doSomething(){
        System.out.println("Do Something");
        throw new FirstError();
    }

    @Override
    public void close() {
        System.out.println("Close my Resource");
        throw new SecondError();
    }
}
